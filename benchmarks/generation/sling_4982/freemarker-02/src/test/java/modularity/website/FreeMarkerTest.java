package modularity.website;

import freemarker.cache.CacheStorage;
import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.MruCacheStorage;
import freemarker.cache.TemplateLoader;
import freemarker.core.Environment;
import freemarker.template.Configuration;
import freemarker.template.SimpleScalar;
import freemarker.template.Template;
import freemarker.template.TemplateModel;
import freemarker.template.ObjectWrapper;
import freemarker.template.SimpleObjectWrapper;
import freemarker.template.TemplateModelException;
import junit.framework.TestCase;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.io.StringWriter;
import java.util.*;

/**
 * @noinspection UnusedCatchParameter,ProtectedField
 */
public class FreeMarkerTest extends TestCase
{
    private final Map<TemplateLoader, CacheStorage> cacheStoragesByLoader = new HashMap<TemplateLoader, CacheStorage>();
    private ByteArrayOutputStream baos;

    public void setUp() throws Exception
    {
        TemplateLoader loader = new ClassTemplateLoader(FreeMarkerTest.class);
        TemplateResource templateResource = new TemplateResource(loader, "default.ftl");
        TemplateDataModel model = new TemplateDataModel();
        model.bind("title", new SimpleScalar("Test"));

        String templateName = templateResource.getTemplatePath();

        if (templateName.charAt(0) == '/')
        {
            throw new IllegalArgumentException("Illegal templateName name:" + templateName + ". templates must not start with '/'");
        }

        Configuration configuration = new Configuration();
        configuration.setCacheStorage(getCacheStorage(templateResource.getTemplateLoader()));
        configuration.setTemplateLoader(templateResource.getTemplateLoader());

        Template template;
        try
        {
            template = configuration.getTemplate(templateName);
            if (template == null)
            {
                //noinspection ProhibitedExceptionThrown
                throw new Exception("Failed to find template: " + templateName, null);
            }
        }
        catch (IOException e)
        {
            //noinspection ProhibitedExceptionThrown
            throw new Exception("Failed to parse template: " + templateName, e);
        }

        // Templates are immutable as far as FreeMarker is concerned.
        // Because we want to change the object wrapper for this use of the template we must synchronize to ensure
        // the template is not used by a different thread which might change the object wrapper.
        synchronized (template) {
            template.setObjectWrapper(model.getObjectWrapper());
            baos = new ByteArrayOutputStream();
            PrintWriter pw = new PrintWriter(baos, true);
            mergeTemplate(pw, model, template);
        }
    }

    public void testMe() throws Exception
    {
    }

    private CacheStorage getCacheStorage(TemplateLoader loader)
    {
        CacheStorage cache = cacheStoragesByLoader.get(loader);
        if (cache == null)
        {
            cache = new MruCacheStorage(10, 50);
            cacheStoragesByLoader.put(loader, cache);
        }
        return cache;
    }


    private static void mergeTemplate(Writer writer, TemplateDataModel model, Template template) throws Exception
    {
        if (model == null)
        {
            throw new IllegalArgumentException("Cannot pass null for argument: model");
        }
        try
        {
            Environment env = template.createProcessingEnvironment(model.getTemplateVariables(), writer);
            env.process();
            writer.flush();
        }
        catch (Exception e)
        {
            //noinspection ProhibitedExceptionThrown
            throw new Exception("Failed to merge template: " + template.getName(), e);
        }
    }
}

class TemplateResource
{
    private final TemplateLoader templateLoader;
    private final String path;

    public TemplateResource(TemplateLoader templateLoader, String path)
    {
        this.templateLoader = templateLoader;
        this.path = path;
    }

    public String getTemplatePath()
    {
        return path;
    }

    public TemplateLoader getTemplateLoader()
    {
        return templateLoader;
    }
}

class TemplateDataModel
{
    private Map<String, TemplateModel> rootMap = new HashMap<String, TemplateModel>();
    private CompositeObjectWrapper objectWrapper = new CompositeObjectWrapper();

    public void bind(String name, TemplateModel binding)
    {
        rootMap.put(name, binding);
    }

    public ObjectWrapper getObjectWrapper()
    {
        return objectWrapper;
    }

    public Map<String, TemplateModel> getTemplateVariables()
    {
        return rootMap;
    }

    public void addWrapper(ObjectWrapperEx wrapper)
    {
        objectWrapper.add(wrapper);
    }
}

class CompositeObjectWrapper extends SimpleObjectWrapper
{
    private final List wrappers = new ArrayList();

    public TemplateModel wrap(Object obj) throws TemplateModelException
    {
        for (Iterator it = wrappers.iterator(); it.hasNext();)
        {
            ObjectWrapperEx wrapper = (ObjectWrapperEx) it.next();
            TemplateModel templateModel = wrapper.wrap(obj, this);
            if (templateModel != null)
            {
                return templateModel;
            }
        }
        return super.wrap(obj);
    }

    public void add(ObjectWrapperEx wrapper)
    {
        wrappers.add(wrapper);
    }

    public String toString()
    {
        StringWriter writer = new StringWriter();
        PrintWriter w = new PrintWriter(writer);
        for (Iterator it = wrappers.iterator(); it.hasNext();)
        {
            ObjectWrapperEx objectWrapperEx = (ObjectWrapperEx) it.next();
            w.println("Wrapper: "+objectWrapperEx);
        }
        w.flush();
        return writer.toString();
    }
}

interface ObjectWrapperEx
{
    TemplateModel wrap(Object obj, ObjectWrapper parent) throws TemplateModelException;
}
