package org.apache.sling.security.impl;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.PropertyUnbounded;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.wrappers.SlingHttpServletResponseWrapper;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(metatype = true, description = "Request filter adding Content Disposition attachment for certain paths/content types", label = " Apache Sling Content Disposition Filter")
@Service(value = Filter.class)
@Properties(value = { @Property(name = "sling.filter.scope", value = { "request" }, propertyPrivate = true) , @Property(name = "service.ranking", intValue = -25000, propertyPrivate = true) })
public class ContentDispositionFilter implements Filter {
    protected class RewriterResponse extends SlingHttpServletResponseWrapper {
        private static final String CONTENT_DISPOSTION = "Content-Disposition";

        private static final String CONTENT_DISPOSTION_ATTACHMENT = "attachment";

        private static final String PROP_JCR_DATA = "jcr:data";

        private static final String JCR_CONTENT_LEAF = "jcr:content";

        static final String ATTRIBUTE_NAME = "org.apache.sling.security.impl.ContentDispositionFilter.RewriterResponse.contentType";

        private final SlingHttpServletRequest request;

        public RewriterResponse(SlingHttpServletRequest request, SlingHttpServletResponse wrappedResponse) {
            super(wrappedResponse);
            ConstructorContext _bcornu_methode_context1 = new ConstructorContext(ContentDispositionFilter.RewriterResponse.class, 214, 9230, 9423);
            try {
                this.request = request;
                CallChecker.varAssign(this.request, "this.request", 216, 9391, 9413);
            } finally {
                _bcornu_methode_context1.methodEnd();
            }
        }

        public void setContentType(String type) {
            MethodContext _bcornu_methode_context1 = new MethodContext(void.class, 222, 9442, 11824);
            try {
                CallChecker.varInit(this, "this", 222, 9442, 11824);
                CallChecker.varInit(type, "type", 222, 9442, 11824);
                CallChecker.varInit(this.request, "request", 222, 9442, 11824);
                CallChecker.varInit(ATTRIBUTE_NAME, "org.apache.sling.security.impl.ContentDispositionFilter.RewriterResponse.ATTRIBUTE_NAME", 222, 9442, 11824);
                CallChecker.varInit(JCR_CONTENT_LEAF, "org.apache.sling.security.impl.ContentDispositionFilter.RewriterResponse.JCR_CONTENT_LEAF", 222, 9442, 11824);
                CallChecker.varInit(PROP_JCR_DATA, "org.apache.sling.security.impl.ContentDispositionFilter.RewriterResponse.PROP_JCR_DATA", 222, 9442, 11824);
                CallChecker.varInit(CONTENT_DISPOSTION_ATTACHMENT, "org.apache.sling.security.impl.ContentDispositionFilter.RewriterResponse.CONTENT_DISPOSTION_ATTACHMENT", 222, 9442, 11824);
                CallChecker.varInit(CONTENT_DISPOSTION, "org.apache.sling.security.impl.ContentDispositionFilter.RewriterResponse.CONTENT_DISPOSTION", 222, 9442, 11824);
                String previousContentType = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(request, SlingHttpServletRequest.class, 223, 9645, 9651)) {
                    previousContentType = ((String) (CallChecker.isCalled(request, SlingHttpServletRequest.class, 223, 9645, 9651).getAttribute(ContentDispositionFilter.RewriterResponse.ATTRIBUTE_NAME)));
                    CallChecker.varAssign(previousContentType, "previousContentType", 223, 9645, 9651);
                }
                if ((previousContentType != null) && (previousContentType.equals(type))) {
                    return ;
                }
                if (CallChecker.beforeDeref(request, SlingHttpServletRequest.class, 228, 9829, 9835)) {
                    CallChecker.isCalled(request, SlingHttpServletRequest.class, 228, 9829, 9835).setAttribute(ContentDispositionFilter.RewriterResponse.ATTRIBUTE_NAME, type);
                }
                Resource resource = CallChecker.init(Resource.class);
                if (CallChecker.beforeDeref(request, SlingHttpServletRequest.class, 229, 9905, 9911)) {
                    resource = CallChecker.isCalled(request, SlingHttpServletRequest.class, 229, 9905, 9911).getResource();
                    CallChecker.varAssign(resource, "resource", 229, 9905, 9911);
                }
                String resourcePath = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(resource, Resource.class, 230, 9962, 9969)) {
                    resource = CallChecker.beforeCalled(resource, Resource.class, 230, 9962, 9969);
                    resourcePath = CallChecker.isCalled(resource, Resource.class, 230, 9962, 9969).getPath();
                    CallChecker.varAssign(resourcePath, "resourcePath", 230, 9962, 9969);
                }
                if (CallChecker.beforeDeref(contentDispositionExcludedPaths, Set.class, 232, 10012, 10042)) {
                    contentDispositionExcludedPaths = CallChecker.beforeCalled(contentDispositionExcludedPaths, Set.class, 232, 10012, 10042);
                    if (!(CallChecker.isCalled(contentDispositionExcludedPaths, Set.class, 232, 10012, 10042).contains(resourcePath))) {
                        if (enableContentDispositionAllPaths) {
                            setContentDisposition(resource);
                        }else {
                            boolean contentDispositionAdded = CallChecker.varInit(((boolean) (false)), "contentDispositionAdded", 238, 10241, 10280);
                            if (CallChecker.beforeDeref(contentDispositionPaths, Set.class, 239, 10306, 10328)) {
                                contentDispositionPaths = CallChecker.beforeCalled(contentDispositionPaths, Set.class, 239, 10306, 10328);
                                if (CallChecker.isCalled(contentDispositionPaths, Set.class, 239, 10306, 10328).contains(resourcePath)) {
                                    if (CallChecker.beforeDeref(contentTypesMapping, Map.class, 241, 10385, 10403)) {
                                        contentTypesMapping = CallChecker.beforeCalled(contentTypesMapping, Map.class, 241, 10385, 10403);
                                        if (CallChecker.isCalled(contentTypesMapping, Map.class, 241, 10385, 10403).containsKey(resourcePath)) {
                                            Set<String> exceptions = CallChecker.init(Set.class);
                                            if (CallChecker.beforeDeref(contentTypesMapping, Map.class, 242, 10488, 10506)) {
                                                contentTypesMapping = CallChecker.beforeCalled(contentTypesMapping, Map.class, 242, 10488, 10506);
                                                exceptions = CallChecker.isCalled(contentTypesMapping, Map.class, 242, 10488, 10506).get(resourcePath);
                                                CallChecker.varAssign(exceptions, "exceptions", 242, 10488, 10506);
                                            }
                                            if (CallChecker.beforeDeref(exceptions, Set.class, 243, 10560, 10569)) {
                                                exceptions = CallChecker.beforeCalled(exceptions, Set.class, 243, 10560, 10569);
                                                if (!(CallChecker.isCalled(exceptions, Set.class, 243, 10560, 10569).contains(type))) {
                                                    contentDispositionAdded = setContentDisposition(resource);
                                                    CallChecker.varAssign(contentDispositionAdded, "contentDispositionAdded", 244, 10621, 10678);
                                                }
                                            }
                                        }else {
                                            contentDispositionAdded = setContentDisposition(resource);
                                            CallChecker.varAssign(contentDispositionAdded, "contentDispositionAdded", 247, 10771, 10828);
                                        }
                                    }
                                }
                            }
                            if (!contentDispositionAdded) {
                                if (CallChecker.beforeDeref(contentDispositionPathsPfx, void.class, 251, 10985, 11010)) {
                                    for (String path : contentDispositionPathsPfx) {
                                        if (CallChecker.beforeDeref(resourcePath, String.class, 252, 11047, 11058)) {
                                            resourcePath = CallChecker.beforeCalled(resourcePath, String.class, 252, 11047, 11058);
                                            if (CallChecker.isCalled(resourcePath, String.class, 252, 11047, 11058).startsWith(path)) {
                                                if (CallChecker.beforeDeref(contentTypesMapping, Map.class, 253, 11116, 11134)) {
                                                    contentTypesMapping = CallChecker.beforeCalled(contentTypesMapping, Map.class, 253, 11116, 11134);
                                                    if (CallChecker.isCalled(contentTypesMapping, Map.class, 253, 11116, 11134).containsKey(path)) {
                                                        Set<String> exceptions = CallChecker.init(Set.class);
                                                        if (CallChecker.beforeDeref(contentTypesMapping, Map.class, 254, 11219, 11237)) {
                                                            contentTypesMapping = CallChecker.beforeCalled(contentTypesMapping, Map.class, 254, 11219, 11237);
                                                            exceptions = CallChecker.isCalled(contentTypesMapping, Map.class, 254, 11219, 11237).get(path);
                                                            CallChecker.varAssign(exceptions, "exceptions", 254, 11219, 11237);
                                                        }
                                                        if (CallChecker.beforeDeref(exceptions, Set.class, 255, 11291, 11300)) {
                                                            exceptions = CallChecker.beforeCalled(exceptions, Set.class, 255, 11291, 11300);
                                                            if (!(CallChecker.isCalled(exceptions, Set.class, 255, 11291, 11300).contains(type))) {
                                                                setContentDisposition(resource);
                                                                break;
                                                            }
                                                        }
                                                    }else {
                                                        setContentDisposition(resource);
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                super.setContentType(type);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1.methodEnd();
            }
        }

        private boolean setContentDisposition(Resource resource) {
            MethodContext _bcornu_methode_context2 = new MethodContext(boolean.class, 274, 11845, 12298);
            try {
                CallChecker.varInit(this, "this", 274, 11845, 12298);
                CallChecker.varInit(resource, "resource", 274, 11845, 12298);
                CallChecker.varInit(this.request, "request", 274, 11845, 12298);
                CallChecker.varInit(ATTRIBUTE_NAME, "org.apache.sling.security.impl.ContentDispositionFilter.RewriterResponse.ATTRIBUTE_NAME", 274, 11845, 12298);
                CallChecker.varInit(JCR_CONTENT_LEAF, "org.apache.sling.security.impl.ContentDispositionFilter.RewriterResponse.JCR_CONTENT_LEAF", 274, 11845, 12298);
                CallChecker.varInit(PROP_JCR_DATA, "org.apache.sling.security.impl.ContentDispositionFilter.RewriterResponse.PROP_JCR_DATA", 274, 11845, 12298);
                CallChecker.varInit(CONTENT_DISPOSTION_ATTACHMENT, "org.apache.sling.security.impl.ContentDispositionFilter.RewriterResponse.CONTENT_DISPOSTION_ATTACHMENT", 274, 11845, 12298);
                CallChecker.varInit(CONTENT_DISPOSTION, "org.apache.sling.security.impl.ContentDispositionFilter.RewriterResponse.CONTENT_DISPOSTION", 274, 11845, 12298);
                boolean contentDispositionAdded = CallChecker.varInit(((boolean) (false)), "contentDispositionAdded", 275, 11972, 12011);
                if ((!(this.containsHeader(ContentDispositionFilter.RewriterResponse.CONTENT_DISPOSTION))) && (this.isJcrData(resource))) {
                    this.addHeader(ContentDispositionFilter.RewriterResponse.CONTENT_DISPOSTION, ContentDispositionFilter.RewriterResponse.CONTENT_DISPOSTION_ATTACHMENT);
                    contentDispositionAdded = true;
                    CallChecker.varAssign(contentDispositionAdded, "contentDispositionAdded", 278, 12200, 12230);
                }
                return contentDispositionAdded;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2.methodEnd();
            }
        }

        private boolean isJcrData(Resource resource) {
            MethodContext _bcornu_methode_context3 = new MethodContext(boolean.class, 283, 12317, 13042);
            try {
                CallChecker.varInit(this, "this", 283, 12317, 13042);
                CallChecker.varInit(resource, "resource", 283, 12317, 13042);
                CallChecker.varInit(this.request, "request", 283, 12317, 13042);
                CallChecker.varInit(ATTRIBUTE_NAME, "org.apache.sling.security.impl.ContentDispositionFilter.RewriterResponse.ATTRIBUTE_NAME", 283, 12317, 13042);
                CallChecker.varInit(JCR_CONTENT_LEAF, "org.apache.sling.security.impl.ContentDispositionFilter.RewriterResponse.JCR_CONTENT_LEAF", 283, 12317, 13042);
                CallChecker.varInit(PROP_JCR_DATA, "org.apache.sling.security.impl.ContentDispositionFilter.RewriterResponse.PROP_JCR_DATA", 283, 12317, 13042);
                CallChecker.varInit(CONTENT_DISPOSTION_ATTACHMENT, "org.apache.sling.security.impl.ContentDispositionFilter.RewriterResponse.CONTENT_DISPOSTION_ATTACHMENT", 283, 12317, 13042);
                CallChecker.varInit(CONTENT_DISPOSTION, "org.apache.sling.security.impl.ContentDispositionFilter.RewriterResponse.CONTENT_DISPOSTION", 283, 12317, 13042);
                boolean jcrData = CallChecker.varInit(((boolean) (false)), "jcrData", 284, 12375, 12398);
                if (resource != null) {
                    ValueMap props = CallChecker.varInit(resource.adaptTo(ValueMap.class), "props", 286, 12451, 12500);
                    if (CallChecker.beforeDeref(props, ValueMap.class, 287, 12522, 12526)) {
                        props = CallChecker.beforeCalled(props, ValueMap.class, 287, 12522, 12526);
                        if (CallChecker.isCalled(props, ValueMap.class, 287, 12522, 12526).containsKey(ContentDispositionFilter.RewriterResponse.PROP_JCR_DATA)) {
                            jcrData = true;
                            CallChecker.varAssign(jcrData, "jcrData", 288, 12579, 12593);
                        }else {
                            Resource jcrContent = CallChecker.varInit(resource.getChild(ContentDispositionFilter.RewriterResponse.JCR_CONTENT_LEAF), "jcrContent", 290, 12640, 12697);
                            if (jcrContent != null) {
                                props = jcrContent.adaptTo(ValueMap.class);
                                CallChecker.varAssign(props, "props", 292, 12768, 12810);
                                if (CallChecker.beforeDeref(props, ValueMap.class, 293, 12840, 12844)) {
                                    props = CallChecker.beforeCalled(props, ValueMap.class, 293, 12840, 12844);
                                    if (CallChecker.isCalled(props, ValueMap.class, 293, 12840, 12844).containsKey(ContentDispositionFilter.RewriterResponse.PROP_JCR_DATA)) {
                                        jcrData = true;
                                        CallChecker.varAssign(jcrData, "jcrData", 294, 12905, 12919);
                                    }
                                }
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                return jcrData;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3.methodEnd();
            }
        }
    }

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Property(label = "Content Disposition Paths", description = "These paths are checked by the filter. " + ("Each entry is of the form \'path [ \":\" CSV of excluded content types ]\'. " + "Invalid entries are logged and ignored."), unbounded = PropertyUnbounded.ARRAY, value = { "" })
    private static final String PROP_CONTENT_DISPOSTION_PATHS = "sling.content.disposition.paths";

    @Property(label = "Content Disposition Excluded Paths", description = "These paths are excluded by the filter. " + "Each entry is of the form 'path'. ", unbounded = PropertyUnbounded.ARRAY, value = { "" })
    private static final String PROP_CONTENT_DISPOSTION_EXCLUDED_PATHS = "sling.content.disposition.excluded.paths";

    private static final boolean DEFAULT_ENABLE_CONTENT_DISPOSTION_ALL_PATHS = false;

    @Property(boolValue = ContentDispositionFilter.DEFAULT_ENABLE_CONTENT_DISPOSTION_ALL_PATHS, label = "Enable Content Disposition for all paths", description = "This flag controls whether to enable" + " Content Disposition for all paths.")
    private static final String PROP_ENABLE_CONTENT_DISPOSTION_ALL_PATHS = "sling.content.disposition.all.paths";

    Set<String> contentDispositionPaths;

    private String[] contentDispositionPathsPfx;

    Set contentDispositionExcludedPaths;

    private Map<String, Set<String>> contentTypesMapping;

    private boolean enableContentDispositionAllPaths;

    @Activate
    private void activate(final ComponentContext ctx) {
        MethodContext _bcornu_methode_context4 = new MethodContext(void.class, 101, 4301, 7360);
        try {
            CallChecker.varInit(this, "this", 101, 4301, 7360);
            CallChecker.varInit(ctx, "ctx", 101, 4301, 7360);
            CallChecker.varInit(this.enableContentDispositionAllPaths, "enableContentDispositionAllPaths", 101, 4301, 7360);
            CallChecker.varInit(this.contentTypesMapping, "contentTypesMapping", 101, 4301, 7360);
            CallChecker.varInit(this.contentDispositionExcludedPaths, "contentDispositionExcludedPaths", 101, 4301, 7360);
            CallChecker.varInit(this.contentDispositionPathsPfx, "contentDispositionPathsPfx", 101, 4301, 7360);
            CallChecker.varInit(this.contentDispositionPaths, "contentDispositionPaths", 101, 4301, 7360);
            CallChecker.varInit(PROP_ENABLE_CONTENT_DISPOSTION_ALL_PATHS, "org.apache.sling.security.impl.ContentDispositionFilter.PROP_ENABLE_CONTENT_DISPOSTION_ALL_PATHS", 101, 4301, 7360);
            CallChecker.varInit(DEFAULT_ENABLE_CONTENT_DISPOSTION_ALL_PATHS, "org.apache.sling.security.impl.ContentDispositionFilter.DEFAULT_ENABLE_CONTENT_DISPOSTION_ALL_PATHS", 101, 4301, 7360);
            CallChecker.varInit(PROP_CONTENT_DISPOSTION_EXCLUDED_PATHS, "org.apache.sling.security.impl.ContentDispositionFilter.PROP_CONTENT_DISPOSTION_EXCLUDED_PATHS", 101, 4301, 7360);
            CallChecker.varInit(PROP_CONTENT_DISPOSTION_PATHS, "org.apache.sling.security.impl.ContentDispositionFilter.PROP_CONTENT_DISPOSTION_PATHS", 101, 4301, 7360);
            CallChecker.varInit(this.logger, "logger", 101, 4301, 7360);
            final Dictionary props = CallChecker.varInit(CallChecker.isCalled(ctx, ComponentContext.class, 102, 4400, 4402).getProperties(), "props", 102, 4375, 4419);
            String[] contentDispostionProps = CallChecker.init(String[].class);
            if (CallChecker.beforeDeref(props, Dictionary.class, 104, 4501, 4505)) {
                contentDispostionProps = PropertiesUtil.toStringArray(CallChecker.isCalled(props, Dictionary.class, 104, 4501, 4505).get(ContentDispositionFilter.PROP_CONTENT_DISPOSTION_PATHS));
                CallChecker.varAssign(contentDispostionProps, "contentDispostionProps", 104, 4501, 4505);
            }
            Set<String> paths = CallChecker.varInit(new HashSet<String>(), "paths", 106, 4561, 4602);
            List<String> pfxs = CallChecker.varInit(new ArrayList<String>(), "pfxs", 107, 4612, 4655);
            Map<String, Set<String>> contentTypesMap = CallChecker.varInit(new HashMap<String, Set<String>>(), "contentTypesMap", 108, 4665, 4742);
            if (CallChecker.beforeDeref(contentDispostionProps, void.class, 110, 4780, 4801)) {
                for (String path : contentDispostionProps) {
                    if (CallChecker.beforeDeref(path, String.class, 111, 4825, 4828)) {
                        path = CallChecker.isCalled(path, String.class, 111, 4825, 4828).trim();
                        CallChecker.varAssign(path, "path", 111, 4818, 4836);
                    }
                    if (CallChecker.beforeDeref(path, String.class, 112, 4854, 4857)) {
                        if ((CallChecker.isCalled(path, String.class, 112, 4854, 4857).length()) > 0) {
                            int idx = CallChecker.init(int.class);
                            if (CallChecker.beforeDeref(path, String.class, 113, 4901, 4904)) {
                                idx = CallChecker.isCalled(path, String.class, 113, 4901, 4904).indexOf('*');
                                CallChecker.varAssign(idx, "idx", 113, 4901, 4904);
                            }
                            int colonIdx = CallChecker.init(int.class);
                            if (CallChecker.beforeDeref(path, String.class, 114, 4951, 4954)) {
                                colonIdx = CallChecker.isCalled(path, String.class, 114, 4951, 4954).indexOf(":");
                                CallChecker.varAssign(colonIdx, "colonIdx", 114, 4951, 4954);
                            }
                            if ((colonIdx > (-1)) && (colonIdx < idx)) {
                                if (CallChecker.beforeDeref(logger, Logger.class, 118, 5114, 5119)) {
                                    CallChecker.isCalled(logger, Logger.class, 118, 5114, 5119).info("':' in paths is not allowed.");
                                }
                            }else {
                                String p = CallChecker.varInit(null, "p", 120, 5204, 5219);
                                if (idx >= 0) {
                                    if (idx > 0) {
                                        if (CallChecker.beforeDeref(path, String.class, 123, 5328, 5331)) {
                                            p = CallChecker.isCalled(path, String.class, 123, 5328, 5331).substring(0, idx);
                                            CallChecker.varAssign(p, "p", 123, 5324, 5350);
                                        }
                                        if (CallChecker.beforeDeref(pfxs, List.class, 124, 5380, 5383)) {
                                            pfxs = CallChecker.beforeCalled(pfxs, List.class, 124, 5380, 5383);
                                            CallChecker.isCalled(pfxs, List.class, 124, 5380, 5383).add(p);
                                        }
                                    }else {
                                        if (CallChecker.beforeDeref(logger, Logger.class, 128, 5568, 5573)) {
                                            CallChecker.isCalled(logger, Logger.class, 128, 5568, 5573).info("catch-all wildcard for paths not allowed.");
                                        }
                                    }
                                }else {
                                    if (colonIdx > (-1)) {
                                        if (CallChecker.beforeDeref(path, String.class, 132, 5758, 5761)) {
                                            p = CallChecker.isCalled(path, String.class, 132, 5758, 5761).substring(0, colonIdx);
                                            CallChecker.varAssign(p, "p", 132, 5754, 5785);
                                        }
                                    }else {
                                        p = path;
                                        CallChecker.varAssign(p, "p", 134, 5848, 5856);
                                    }
                                    if (CallChecker.beforeDeref(paths, Set.class, 136, 5908, 5912)) {
                                        paths = CallChecker.beforeCalled(paths, Set.class, 136, 5908, 5912);
                                        CallChecker.isCalled(paths, Set.class, 136, 5908, 5912).add(p);
                                    }
                                }
                                if ((colonIdx != (-1)) && (p != null)) {
                                    Set<String> contentTypes = CallChecker.init(Set.class);
                                    if (CallChecker.beforeDeref(path, String.class, 139, 6086, 6089)) {
                                        contentTypes = ContentDispositionFilter.getContentTypes(CallChecker.isCalled(path, String.class, 139, 6086, 6089).substring((colonIdx + 1)));
                                        CallChecker.varAssign(contentTypes, "contentTypes", 139, 6086, 6089);
                                    }
                                    if (CallChecker.beforeDeref(contentTypesMap, Map.class, 140, 6139, 6153)) {
                                        contentTypesMap = CallChecker.beforeCalled(contentTypesMap, Map.class, 140, 6139, 6153);
                                        CallChecker.isCalled(contentTypesMap, Map.class, 140, 6139, 6153).put(p, contentTypes);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(paths, Set.class, 147, 6285, 6289)) {
                paths = CallChecker.beforeCalled(paths, Set.class, 147, 6285, 6289);
                if (CallChecker.isCalled(paths, Set.class, 147, 6285, 6289).isEmpty()) {
                    contentDispositionPaths = Collections.<String>emptySet();
                    CallChecker.varAssign(this.contentDispositionPaths, "this.contentDispositionPaths", 147, 6259, 6341);
                }else {
                    contentDispositionPaths = paths;
                    CallChecker.varAssign(this.contentDispositionPaths, "this.contentDispositionPaths", 147, 6259, 6341);
                }
            }
            if (CallChecker.beforeDeref(pfxs, List.class, 148, 6404, 6407)) {
                if (CallChecker.beforeDeref(pfxs, List.class, 148, 6380, 6383)) {
                    pfxs = CallChecker.beforeCalled(pfxs, List.class, 148, 6404, 6407);
                    pfxs = CallChecker.beforeCalled(pfxs, List.class, 148, 6380, 6383);
                    contentDispositionPathsPfx = CallChecker.isCalled(pfxs, List.class, 148, 6380, 6383).toArray(new String[CallChecker.isCalled(pfxs, List.class, 148, 6404, 6407).size()]);
                    CallChecker.varAssign(this.contentDispositionPathsPfx, "this.contentDispositionPathsPfx", 148, 6351, 6417);
                }
            }
            if (CallChecker.beforeDeref(contentTypesMap, Map.class, 149, 6449, 6463)) {
                contentTypesMap = CallChecker.beforeCalled(contentTypesMap, Map.class, 149, 6449, 6463);
                if (CallChecker.isCalled(contentTypesMap, Map.class, 149, 6449, 6463).isEmpty()) {
                    contentTypesMapping = Collections.<String, Set<String>>emptyMap();
                    CallChecker.varAssign(this.contentTypesMapping, "this.contentTypesMapping", 149, 6427, 6535);
                }else {
                    contentTypesMapping = contentTypesMap;
                    CallChecker.varAssign(this.contentTypesMapping, "this.contentTypesMapping", 149, 6427, 6535);
                }
            }
            if (CallChecker.beforeDeref(props, Dictionary.class, 151, 6615, 6619)) {
                enableContentDispositionAllPaths = PropertiesUtil.toBoolean(CallChecker.isCalled(props, Dictionary.class, 151, 6615, 6619).get(ContentDispositionFilter.PROP_ENABLE_CONTENT_DISPOSTION_ALL_PATHS), ContentDispositionFilter.DEFAULT_ENABLE_CONTENT_DISPOSTION_ALL_PATHS);
                CallChecker.varAssign(this.enableContentDispositionAllPaths, "this.enableContentDispositionAllPaths", 151, 6554, 6711);
            }
            String[] contentDispostionExcludedPathsArray = CallChecker.init(String[].class);
            if (CallChecker.beforeDeref(props, Dictionary.class, 154, 6815, 6819)) {
                contentDispostionExcludedPathsArray = PropertiesUtil.toStringArray(CallChecker.isCalled(props, Dictionary.class, 154, 6815, 6819).get(ContentDispositionFilter.PROP_CONTENT_DISPOSTION_EXCLUDED_PATHS));
                CallChecker.varAssign(contentDispostionExcludedPathsArray, "contentDispostionExcludedPathsArray", 154, 6815, 6819);
            }
            contentDispositionExcludedPaths = new HashSet<String>(Arrays.asList(contentDispostionExcludedPathsArray));
            CallChecker.varAssign(this.contentDispositionExcludedPaths, "this.contentDispositionExcludedPaths", 156, 6884, 6989);
            if (CallChecker.beforeDeref(logger, Logger.class, 158, 7008, 7013)) {
                CallChecker.isCalled(logger, Logger.class, 158, 7008, 7013).info("Initialized. content disposition paths: {}, content disposition paths-pfx {}, content disposition excluded paths: {}. Enable Content Disposition for all paths is set to {}", new Object[]{ contentDispositionPaths , contentDispositionPathsPfx , contentDispositionExcludedPaths , enableContentDispositionAllPaths });
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4.methodEnd();
        }
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        MethodContext _bcornu_methode_context5 = new MethodContext(void.class, 164, 7372, 7471);
        try {
            CallChecker.varInit(this, "this", 164, 7372, 7471);
            CallChecker.varInit(filterConfig, "filterConfig", 164, 7372, 7471);
            CallChecker.varInit(this.enableContentDispositionAllPaths, "enableContentDispositionAllPaths", 164, 7372, 7471);
            CallChecker.varInit(this.contentTypesMapping, "contentTypesMapping", 164, 7372, 7471);
            CallChecker.varInit(this.contentDispositionExcludedPaths, "contentDispositionExcludedPaths", 164, 7372, 7471);
            CallChecker.varInit(this.contentDispositionPathsPfx, "contentDispositionPathsPfx", 164, 7372, 7471);
            CallChecker.varInit(this.contentDispositionPaths, "contentDispositionPaths", 164, 7372, 7471);
            CallChecker.varInit(PROP_ENABLE_CONTENT_DISPOSTION_ALL_PATHS, "org.apache.sling.security.impl.ContentDispositionFilter.PROP_ENABLE_CONTENT_DISPOSTION_ALL_PATHS", 164, 7372, 7471);
            CallChecker.varInit(DEFAULT_ENABLE_CONTENT_DISPOSTION_ALL_PATHS, "org.apache.sling.security.impl.ContentDispositionFilter.DEFAULT_ENABLE_CONTENT_DISPOSTION_ALL_PATHS", 164, 7372, 7471);
            CallChecker.varInit(PROP_CONTENT_DISPOSTION_EXCLUDED_PATHS, "org.apache.sling.security.impl.ContentDispositionFilter.PROP_CONTENT_DISPOSTION_EXCLUDED_PATHS", 164, 7372, 7471);
            CallChecker.varInit(PROP_CONTENT_DISPOSTION_PATHS, "org.apache.sling.security.impl.ContentDispositionFilter.PROP_CONTENT_DISPOSTION_PATHS", 164, 7372, 7471);
            CallChecker.varInit(this.logger, "logger", 164, 7372, 7471);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5.methodEnd();
        }
    }

    public void destroy() {
        MethodContext _bcornu_methode_context6 = new MethodContext(void.class, 168, 7478, 7531);
        try {
            CallChecker.varInit(this, "this", 168, 7478, 7531);
            CallChecker.varInit(this.enableContentDispositionAllPaths, "enableContentDispositionAllPaths", 168, 7478, 7531);
            CallChecker.varInit(this.contentTypesMapping, "contentTypesMapping", 168, 7478, 7531);
            CallChecker.varInit(this.contentDispositionExcludedPaths, "contentDispositionExcludedPaths", 168, 7478, 7531);
            CallChecker.varInit(this.contentDispositionPathsPfx, "contentDispositionPathsPfx", 168, 7478, 7531);
            CallChecker.varInit(this.contentDispositionPaths, "contentDispositionPaths", 168, 7478, 7531);
            CallChecker.varInit(PROP_ENABLE_CONTENT_DISPOSTION_ALL_PATHS, "org.apache.sling.security.impl.ContentDispositionFilter.PROP_ENABLE_CONTENT_DISPOSTION_ALL_PATHS", 168, 7478, 7531);
            CallChecker.varInit(DEFAULT_ENABLE_CONTENT_DISPOSTION_ALL_PATHS, "org.apache.sling.security.impl.ContentDispositionFilter.DEFAULT_ENABLE_CONTENT_DISPOSTION_ALL_PATHS", 168, 7478, 7531);
            CallChecker.varInit(PROP_CONTENT_DISPOSTION_EXCLUDED_PATHS, "org.apache.sling.security.impl.ContentDispositionFilter.PROP_CONTENT_DISPOSTION_EXCLUDED_PATHS", 168, 7478, 7531);
            CallChecker.varInit(PROP_CONTENT_DISPOSTION_PATHS, "org.apache.sling.security.impl.ContentDispositionFilter.PROP_CONTENT_DISPOSTION_PATHS", 168, 7478, 7531);
            CallChecker.varInit(this.logger, "logger", 168, 7478, 7531);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context6.methodEnd();
        }
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        MethodContext _bcornu_methode_context7 = new MethodContext(void.class, 172, 7538, 8020);
        try {
            CallChecker.varInit(this, "this", 172, 7538, 8020);
            CallChecker.varInit(chain, "chain", 172, 7538, 8020);
            CallChecker.varInit(response, "response", 172, 7538, 8020);
            CallChecker.varInit(request, "request", 172, 7538, 8020);
            CallChecker.varInit(this.enableContentDispositionAllPaths, "enableContentDispositionAllPaths", 172, 7538, 8020);
            CallChecker.varInit(this.contentTypesMapping, "contentTypesMapping", 172, 7538, 8020);
            CallChecker.varInit(this.contentDispositionExcludedPaths, "contentDispositionExcludedPaths", 172, 7538, 8020);
            CallChecker.varInit(this.contentDispositionPathsPfx, "contentDispositionPathsPfx", 172, 7538, 8020);
            CallChecker.varInit(this.contentDispositionPaths, "contentDispositionPaths", 172, 7538, 8020);
            CallChecker.varInit(PROP_ENABLE_CONTENT_DISPOSTION_ALL_PATHS, "org.apache.sling.security.impl.ContentDispositionFilter.PROP_ENABLE_CONTENT_DISPOSTION_ALL_PATHS", 172, 7538, 8020);
            CallChecker.varInit(DEFAULT_ENABLE_CONTENT_DISPOSTION_ALL_PATHS, "org.apache.sling.security.impl.ContentDispositionFilter.DEFAULT_ENABLE_CONTENT_DISPOSTION_ALL_PATHS", 172, 7538, 8020);
            CallChecker.varInit(PROP_CONTENT_DISPOSTION_EXCLUDED_PATHS, "org.apache.sling.security.impl.ContentDispositionFilter.PROP_CONTENT_DISPOSTION_EXCLUDED_PATHS", 172, 7538, 8020);
            CallChecker.varInit(PROP_CONTENT_DISPOSTION_PATHS, "org.apache.sling.security.impl.ContentDispositionFilter.PROP_CONTENT_DISPOSTION_PATHS", 172, 7538, 8020);
            CallChecker.varInit(this.logger, "logger", 172, 7538, 8020);
            final SlingHttpServletRequest slingRequest = CallChecker.varInit(((SlingHttpServletRequest) (request)), "slingRequest", 175, 7690, 7768);
            final SlingHttpServletResponse slingResponse = CallChecker.varInit(((SlingHttpServletResponse) (response)), "slingResponse", 176, 7778, 7860);
            final ContentDispositionFilter.RewriterResponse rewriterResponse = CallChecker.varInit(new ContentDispositionFilter.RewriterResponse(slingRequest, slingResponse), "rewriterResponse", 178, 7871, 7962);
            if (CallChecker.beforeDeref(chain, FilterChain.class, 180, 7973, 7977)) {
                chain = CallChecker.beforeCalled(chain, FilterChain.class, 180, 7973, 7977);
                CallChecker.isCalled(chain, FilterChain.class, 180, 7973, 7977).doFilter(request, rewriterResponse);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context7.methodEnd();
        }
    }

    private static Set<String> getContentTypes(String contentTypes) {
        MethodContext _bcornu_methode_context8 = new MethodContext(Set.class, 185, 8031, 8506);
        try {
            CallChecker.varInit(contentTypes, "contentTypes", 185, 8031, 8506);
            CallChecker.varInit(PROP_ENABLE_CONTENT_DISPOSTION_ALL_PATHS, "org.apache.sling.security.impl.ContentDispositionFilter.PROP_ENABLE_CONTENT_DISPOSTION_ALL_PATHS", 185, 8031, 8506);
            CallChecker.varInit(DEFAULT_ENABLE_CONTENT_DISPOSTION_ALL_PATHS, "org.apache.sling.security.impl.ContentDispositionFilter.DEFAULT_ENABLE_CONTENT_DISPOSTION_ALL_PATHS", 185, 8031, 8506);
            CallChecker.varInit(PROP_CONTENT_DISPOSTION_EXCLUDED_PATHS, "org.apache.sling.security.impl.ContentDispositionFilter.PROP_CONTENT_DISPOSTION_EXCLUDED_PATHS", 185, 8031, 8506);
            CallChecker.varInit(PROP_CONTENT_DISPOSTION_PATHS, "org.apache.sling.security.impl.ContentDispositionFilter.PROP_CONTENT_DISPOSTION_PATHS", 185, 8031, 8506);
            Set<String> contentTypesSet = CallChecker.varInit(new HashSet<String>(), "contentTypesSet", 186, 8153, 8204);
            if ((contentTypes != null) && ((contentTypes.length()) > 0)) {
                String[] contentTypesArray = CallChecker.varInit(contentTypes.split(","), "contentTypesArray", 188, 8283, 8335);
                if (CallChecker.beforeDeref(contentTypesArray, Set.class, 189, 8375, 8391)) {
                    for (String contentType : contentTypesArray) {
                        if (CallChecker.beforeDeref(contentTypesSet, Set.class, 190, 8412, 8426)) {
                            contentTypesSet = CallChecker.beforeCalled(contentTypesSet, Set.class, 190, 8412, 8426);
                            CallChecker.isCalled(contentTypesSet, Set.class, 190, 8412, 8426).add(contentType);
                        }
                    }
                }
            }
            return contentTypesSet;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context8.methodEnd();
        }
    }
}

