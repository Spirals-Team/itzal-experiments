package org.apache.pdfbox.pdmodel.interactive.form;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.COSArrayList;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.fdf.FDFCatalog;
import org.apache.pdfbox.pdmodel.fdf.FDFDictionary;
import org.apache.pdfbox.pdmodel.fdf.FDFDocument;
import org.apache.pdfbox.pdmodel.fdf.FDFField;

public final class PDAcroForm implements COSObjectable {
    private static final int FLAG_SIGNATURES_EXIST = 1;

    private static final int FLAG_APPEND_ONLY = 1 << 1;

    private final PDDocument document;

    private final COSDictionary dictionary;

    private Map<String, PDField> fieldCache;

    public PDAcroForm(PDDocument doc) {
        ConstructorContext _bcornu_methode_context1 = new ConstructorContext(PDAcroForm.class, 60, 2043, 2314);
        try {
            document = doc;
            CallChecker.varAssign(this.document, "this.document", 62, 2192, 2206);
            dictionary = new COSDictionary();
            CallChecker.varAssign(this.dictionary, "this.dictionary", 63, 2216, 2248);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 64, 2258, 2267)) {
                CallChecker.isCalled(dictionary, COSDictionary.class, 64, 2258, 2267).setItem(COSName.FIELDS, new COSArray());
            }
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    public PDAcroForm(PDDocument doc, COSDictionary form) {
        ConstructorContext _bcornu_methode_context2 = new ConstructorContext(PDAcroForm.class, 73, 2321, 2579);
        try {
            document = doc;
            CallChecker.varAssign(this.document, "this.document", 75, 2532, 2546);
            dictionary = form;
            CallChecker.varAssign(this.dictionary, "this.dictionary", 76, 2556, 2573);
        } finally {
            _bcornu_methode_context2.methodEnd();
        }
    }

    PDDocument getDocument() {
        MethodContext _bcornu_methode_context1 = new MethodContext(PDDocument.class, 84, 2586, 2763);
        try {
            CallChecker.varInit(this, "this", 84, 2586, 2763);
            CallChecker.varInit(this.fieldCache, "fieldCache", 84, 2586, 2763);
            CallChecker.varInit(this.dictionary, "dictionary", 84, 2586, 2763);
            CallChecker.varInit(this.document, "document", 84, 2586, 2763);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 84, 2586, 2763);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 84, 2586, 2763);
            return document;
        } catch (ForceReturn _bcornu_return_t) {
            return ((PDDocument) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    @Override
    public COSDictionary getCOSObject() {
        MethodContext _bcornu_methode_context2 = new MethodContext(COSDictionary.class, 90, 2770, 2857);
        try {
            CallChecker.varInit(this, "this", 90, 2770, 2857);
            CallChecker.varInit(this.fieldCache, "fieldCache", 90, 2770, 2857);
            CallChecker.varInit(this.dictionary, "dictionary", 90, 2770, 2857);
            CallChecker.varInit(this.document, "document", 90, 2770, 2857);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 90, 2770, 2857);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 90, 2770, 2857);
            return dictionary;
        } catch (ForceReturn _bcornu_return_t) {
            return ((COSDictionary) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2.methodEnd();
        }
    }

    public void importFDF(FDFDocument fdf) throws IOException {
        MethodContext _bcornu_methode_context3 = new MethodContext(void.class, 103, 2864, 3621);
        try {
            CallChecker.varInit(this, "this", 103, 2864, 3621);
            CallChecker.varInit(fdf, "fdf", 103, 2864, 3621);
            CallChecker.varInit(this.fieldCache, "fieldCache", 103, 2864, 3621);
            CallChecker.varInit(this.dictionary, "dictionary", 103, 2864, 3621);
            CallChecker.varInit(this.document, "document", 103, 2864, 3621);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 103, 2864, 3621);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 103, 2864, 3621);
            List<FDFField> fields = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(fdf, FDFDocument.class, 105, 3216, 3218)) {
                fdf = CallChecker.beforeCalled(fdf, FDFDocument.class, 105, 3216, 3218);
                if (CallChecker.beforeDeref(CallChecker.isCalled(fdf, FDFDocument.class, 105, 3216, 3218).getCatalog(), FDFCatalog.class, 105, 3216, 3231)) {
                    fdf = CallChecker.beforeCalled(fdf, FDFDocument.class, 105, 3216, 3218);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(fdf, FDFDocument.class, 105, 3216, 3218).getCatalog(), FDFCatalog.class, 105, 3216, 3231).getFDF(), FDFDictionary.class, 105, 3216, 3240)) {
                        fdf = CallChecker.beforeCalled(fdf, FDFDocument.class, 105, 3216, 3218);
                        fields = CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(fdf, FDFDocument.class, 105, 3216, 3218).getCatalog(), FDFCatalog.class, 105, 3216, 3231).getFDF(), FDFDictionary.class, 105, 3216, 3240).getFields();
                        CallChecker.varAssign(fields, "fields", 105, 3216, 3218);
                    }
                }
            }
            if (fields != null) {
                for (FDFField field : fields) {
                    FDFField fdfField = CallChecker.varInit(field, "fdfField", 110, 3365, 3390);
                    PDField docField = CallChecker.init(PDField.class);
                    if (CallChecker.beforeDeref(fdfField, FDFField.class, 111, 3436, 3443)) {
                        fdfField = CallChecker.beforeCalled(fdfField, FDFField.class, 111, 3436, 3443);
                        docField = getField(CallChecker.isCalled(fdfField, FDFField.class, 111, 3436, 3443).getPartialFieldName());
                        CallChecker.varAssign(docField, "docField", 111, 3436, 3443);
                    }
                    if (docField != null) {
                        docField.importFDF(fdfField);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3.methodEnd();
        }
    }

    public FDFDocument exportFDF() throws IOException {
        MethodContext _bcornu_methode_context4 = new MethodContext(FDFDocument.class, 126, 3628, 4460);
        try {
            CallChecker.varInit(this, "this", 126, 3628, 4460);
            CallChecker.varInit(this.fieldCache, "fieldCache", 126, 3628, 4460);
            CallChecker.varInit(this.dictionary, "dictionary", 126, 3628, 4460);
            CallChecker.varInit(this.document, "document", 126, 3628, 4460);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 126, 3628, 4460);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 126, 3628, 4460);
            FDFDocument fdf = CallChecker.varInit(new FDFDocument(), "fdf", 128, 3895, 3930);
            FDFCatalog catalog = CallChecker.init(FDFCatalog.class);
            if (CallChecker.beforeDeref(fdf, FDFDocument.class, 129, 3961, 3963)) {
                fdf = CallChecker.beforeCalled(fdf, FDFDocument.class, 129, 3961, 3963);
                catalog = CallChecker.isCalled(fdf, FDFDocument.class, 129, 3961, 3963).getCatalog();
                CallChecker.varAssign(catalog, "catalog", 129, 3961, 3963);
            }
            FDFDictionary fdfDict = CallChecker.varInit(new FDFDictionary(), "fdfDict", 130, 3987, 4030);
            if (CallChecker.beforeDeref(catalog, FDFCatalog.class, 131, 4040, 4046)) {
                catalog = CallChecker.beforeCalled(catalog, FDFCatalog.class, 131, 4040, 4046);
                CallChecker.isCalled(catalog, FDFCatalog.class, 131, 4040, 4046).setFDF(fdfDict);
            }
            List<FDFField> fdfFields = CallChecker.varInit(new ArrayList<FDFField>(), "fdfFields", 133, 4074, 4126);
            List<PDField> fields = CallChecker.varInit(getFields(), "fields", 134, 4136, 4170);
            if (CallChecker.beforeDeref(fields, FDFDocument.class, 135, 4201, 4206)) {
                for (PDField field : fields) {
                    if (CallChecker.beforeDeref(field, PDField.class, 137, 4245, 4249)) {
                        if (CallChecker.beforeDeref(fdfFields, List.class, 137, 4231, 4239)) {
                            fdfFields = CallChecker.beforeCalled(fdfFields, List.class, 137, 4231, 4239);
                            CallChecker.isCalled(fdfFields, List.class, 137, 4231, 4239).add(CallChecker.isCalled(field, PDField.class, 137, 4245, 4249).exportFDF());
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(document, PDDocument.class, 140, 4298, 4305)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(document, PDDocument.class, 140, 4298, 4305).getDocument(), COSDocument.class, 140, 4298, 4319)) {
                    if (CallChecker.beforeDeref(fdfDict, FDFDictionary.class, 140, 4284, 4290)) {
                        fdfDict = CallChecker.beforeCalled(fdfDict, FDFDictionary.class, 140, 4284, 4290);
                        CallChecker.isCalled(fdfDict, FDFDictionary.class, 140, 4284, 4290).setID(CallChecker.isCalled(CallChecker.isCalled(document, PDDocument.class, 140, 4298, 4305).getDocument(), COSDocument.class, 140, 4298, 4319).getDocumentID());
                    }
                }
            }
            if (CallChecker.beforeDeref(fdfFields, List.class, 142, 4353, 4361)) {
                fdfFields = CallChecker.beforeCalled(fdfFields, List.class, 142, 4353, 4361);
                if (!(CallChecker.isCalled(fdfFields, List.class, 142, 4353, 4361).isEmpty())) {
                    if (CallChecker.beforeDeref(fdfDict, FDFDictionary.class, 144, 4396, 4402)) {
                        fdfDict = CallChecker.beforeCalled(fdfDict, FDFDictionary.class, 144, 4396, 4402);
                        CallChecker.isCalled(fdfDict, FDFDictionary.class, 144, 4396, 4402).setFields(fdfFields);
                    }
                }
            }
            return fdf;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FDFDocument) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4.methodEnd();
        }
    }

    public List<PDField> getFields() {
        MethodContext _bcornu_methode_context5 = new MethodContext(List.class, 162, 4467, 5808);
        try {
            CallChecker.varInit(this, "this", 162, 4467, 5808);
            CallChecker.varInit(this.fieldCache, "fieldCache", 162, 4467, 5808);
            CallChecker.varInit(this.dictionary, "dictionary", 162, 4467, 5808);
            CallChecker.varInit(this.document, "document", 162, 4467, 5808);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 162, 4467, 5808);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 162, 4467, 5808);
            COSArray cosFields = CallChecker.init(COSArray.class);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 164, 5142, 5151)) {
                cosFields = ((COSArray) (CallChecker.isCalled(dictionary, COSDictionary.class, 164, 5142, 5151).getDictionaryObject(COSName.FIELDS)));
                CallChecker.varAssign(cosFields, "cosFields", 164, 5142, 5151);
            }
            if (cosFields == null) {
                return Collections.emptyList();
            }
            List<PDField> pdFields = CallChecker.varInit(new ArrayList<PDField>(), "pdFields", 169, 5293, 5342);
            for (int i = 0; i < (cosFields.size()); i++) {
                COSDictionary element = CallChecker.varInit(((COSDictionary) (cosFields.getObject(i))), "element", 172, 5417, 5479);
                if (element != null) {
                    PDField field = CallChecker.varInit(PDField.fromDictionary(this, element, null), "field", 175, 5544, 5603);
                    if (field != null) {
                        if (CallChecker.beforeDeref(pdFields, List.class, 178, 5678, 5685)) {
                            pdFields = CallChecker.beforeCalled(pdFields, List.class, 178, 5678, 5685);
                            CallChecker.isCalled(pdFields, List.class, 178, 5678, 5685).add(field);
                        }
                    }
                }
            }
            return new COSArrayList<PDField>(pdFields, cosFields);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<PDField>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5.methodEnd();
        }
    }

    public void setFields(List<PDField> fields) {
        MethodContext _bcornu_methode_context6 = new MethodContext(void.class, 190, 5815, 6092);
        try {
            CallChecker.varInit(this, "this", 190, 5815, 6092);
            CallChecker.varInit(fields, "fields", 190, 5815, 6092);
            CallChecker.varInit(this.fieldCache, "fieldCache", 190, 5815, 6092);
            CallChecker.varInit(this.dictionary, "dictionary", 190, 5815, 6092);
            CallChecker.varInit(this.document, "document", 190, 5815, 6092);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 190, 5815, 6092);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 190, 5815, 6092);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 192, 6010, 6019)) {
                CallChecker.isCalled(dictionary, COSDictionary.class, 192, 6010, 6019).setItem(COSName.FIELDS, COSArrayList.converterToCOSArray(fields));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context6.methodEnd();
        }
    }

    public void setCacheFields(boolean cache) throws IOException {
        MethodContext _bcornu_methode_context7 = new MethodContext(void.class, 204, 6099, 7059);
        try {
            CallChecker.varInit(this, "this", 204, 6099, 7059);
            CallChecker.varInit(cache, "cache", 204, 6099, 7059);
            CallChecker.varInit(this.fieldCache, "fieldCache", 204, 6099, 7059);
            CallChecker.varInit(this.dictionary, "dictionary", 204, 6099, 7059);
            CallChecker.varInit(this.document, "document", 204, 6099, 7059);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 204, 6099, 7059);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 204, 6099, 7059);
            if (cache) {
                fieldCache = new HashMap<String, PDField>();
                CallChecker.varAssign(this.fieldCache, "this.fieldCache", 208, 6668, 6711);
                List<PDField> fields = CallChecker.varInit(getFields(), "fields", 210, 6806, 6840);
                if (CallChecker.beforeDeref(fields, void.class, 211, 6875, 6880)) {
                    for (PDField field : fields) {
                        if (CallChecker.beforeDeref(field, PDField.class, 213, 6928, 6932)) {
                            if (CallChecker.beforeDeref(fieldCache, Map.class, 213, 6913, 6922)) {
                                fieldCache = CallChecker.beforeCalled(fieldCache, Map.class, 213, 6913, 6922);
                                CallChecker.isCalled(fieldCache, Map.class, 213, 6913, 6922).put(CallChecker.isCalled(field, PDField.class, 213, 6928, 6932).getFullyQualifiedName(), field);
                            }
                        }
                    }
                }
            }else {
                fieldCache = null;
                CallChecker.varAssign(this.fieldCache, "this.fieldCache", 218, 7026, 7043);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context7.methodEnd();
        }
    }

    public boolean isCachingFields() {
        MethodContext _bcornu_methode_context8 = new MethodContext(boolean.class, 227, 7066, 7282);
        try {
            CallChecker.varInit(this, "this", 227, 7066, 7282);
            CallChecker.varInit(this.fieldCache, "fieldCache", 227, 7066, 7282);
            CallChecker.varInit(this.dictionary, "dictionary", 227, 7066, 7282);
            CallChecker.varInit(this.document, "document", 227, 7066, 7282);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 227, 7066, 7282);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 227, 7066, 7282);
            return (fieldCache) != null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context8.methodEnd();
        }
    }

    public PDField getField(String fullyQualifiedName) {
        MethodContext _bcornu_methode_context9 = new MethodContext(PDField.class, 239, 7289, 9424);
        try {
            CallChecker.varInit(this, "this", 239, 7289, 9424);
            CallChecker.varInit(fullyQualifiedName, "fullyQualifiedName", 239, 7289, 9424);
            CallChecker.varInit(this.fieldCache, "fieldCache", 239, 7289, 9424);
            CallChecker.varInit(this.dictionary, "dictionary", 239, 7289, 9424);
            CallChecker.varInit(this.document, "document", 239, 7289, 9424);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 239, 7289, 9424);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 239, 7289, 9424);
            PDField retval = CallChecker.varInit(null, "retval", 241, 7666, 7687);
            if ((fieldCache) != null) {
                retval = fieldCache.get(fullyQualifiedName);
                CallChecker.varAssign(retval, "retval", 244, 7743, 7786);
            }else {
                String[] nameSubSection = CallChecker.init(String[].class);
                if (CallChecker.beforeDeref(fullyQualifiedName, String.class, 248, 7859, 7876)) {
                    fullyQualifiedName = CallChecker.beforeCalled(fullyQualifiedName, String.class, 248, 7859, 7876);
                    nameSubSection = CallChecker.isCalled(fullyQualifiedName, String.class, 248, 7859, 7876).split("\\.");
                    CallChecker.varAssign(nameSubSection, "nameSubSection", 248, 7859, 7876);
                }
                COSArray fields = CallChecker.init(COSArray.class);
                if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 249, 7933, 7942)) {
                    fields = ((COSArray) (CallChecker.isCalled(dictionary, COSDictionary.class, 249, 7933, 7942).getDictionaryObject(COSName.FIELDS)));
                    CallChecker.varAssign(fields, "fields", 249, 7933, 7942);
                }
                fields = CallChecker.beforeCalled(fields, COSArray.class, 251, 8014, 8019);
                for (int i = 0; (i < (CallChecker.isCalled(fields, COSArray.class, 251, 8014, 8019).size())) && (retval == null); i++) {
                    COSDictionary element = CallChecker.init(COSDictionary.class);
                    if (CallChecker.beforeDeref(fields, COSArray.class, 253, 8122, 8127)) {
                        fields = CallChecker.beforeCalled(fields, COSArray.class, 253, 8122, 8127);
                        element = ((COSDictionary) (CallChecker.isCalled(fields, COSArray.class, 253, 8122, 8127).getObject(i)));
                        CallChecker.varAssign(element, "element", 253, 8122, 8127);
                    }
                    if (element != null) {
                        COSString fieldName = CallChecker.varInit(((COSString) (element.getDictionaryObject(COSName.T))), "fieldName", 256, 8218, 8317);
                        if (CallChecker.beforeDeref(fieldName, COSString.class, 258, 8343, 8351)) {
                            fieldName = CallChecker.beforeCalled(fieldName, COSString.class, 258, 8343, 8351);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(fieldName, COSString.class, 258, 8343, 8351).getString(), String.class, 258, 8343, 8363)) {
                                if (CallChecker.beforeDeref(fieldName, COSString.class, 259, 8423, 8431)) {
                                    if (CallChecker.beforeDeref(nameSubSection, String[].class, 259, 8452, 8465)) {
                                        fieldName = CallChecker.beforeCalled(fieldName, COSString.class, 259, 8423, 8431);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(fieldName, COSString.class, 259, 8423, 8431).getString(), String.class, 259, 8423, 8443)) {
                                            fieldName = CallChecker.beforeCalled(fieldName, COSString.class, 258, 8343, 8351);
                                            fieldName = CallChecker.beforeCalled(fieldName, COSString.class, 259, 8423, 8431);
                                            nameSubSection = CallChecker.beforeCalled(nameSubSection, String[].class, 259, 8452, 8465);
                                            if ((CallChecker.isCalled(CallChecker.isCalled(fieldName, COSString.class, 258, 8343, 8351).getString(), String.class, 258, 8343, 8363).equals(fullyQualifiedName)) || (CallChecker.isCalled(CallChecker.isCalled(fieldName, COSString.class, 259, 8423, 8431).getString(), String.class, 259, 8423, 8443).equals(CallChecker.isCalled(nameSubSection, String[].class, 259, 8452, 8465)[0]))) {
                                                PDField root = CallChecker.varInit(PDField.fromDictionary(this, element, null), "root", 261, 8518, 8576);
                                                if (root != null) {
                                                    if (CallChecker.beforeDeref(nameSubSection, String[].class, 264, 8678, 8691)) {
                                                        nameSubSection = CallChecker.beforeCalled(nameSubSection, String[].class, 264, 8678, 8691);
                                                        if ((CallChecker.isCalled(nameSubSection, String[].class, 264, 8678, 8691).length) > 1) {
                                                            PDField kid = CallChecker.varInit(root.findKid(nameSubSection, 1), "kid", 266, 8767, 8812);
                                                            if (kid != null) {
                                                                retval = kid;
                                                                CallChecker.varAssign(retval, "retval", 269, 8933, 8945);
                                                            }else {
                                                                retval = root;
                                                                CallChecker.varAssign(retval, "retval", 273, 9088, 9101);
                                                            }
                                                        }else {
                                                            retval = root;
                                                            CallChecker.varAssign(retval, "retval", 278, 9262, 9275);
                                                        }
                                                    }else
                                                        throw new AbnormalExecutionError();
                                                    
                                                }
                                            }
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
            return retval;
        } catch (ForceReturn _bcornu_return_t) {
            return ((PDField) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context9.methodEnd();
        }
    }

    public String getDefaultAppearance() {
        MethodContext _bcornu_methode_context10 = new MethodContext(String.class, 293, 9431, 9719);
        try {
            CallChecker.varInit(this, "this", 293, 9431, 9719);
            CallChecker.varInit(this.fieldCache, "fieldCache", 293, 9431, 9719);
            CallChecker.varInit(this.dictionary, "dictionary", 293, 9431, 9719);
            CallChecker.varInit(this.document, "document", 293, 9431, 9719);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 293, 9431, 9719);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 293, 9431, 9719);
            COSString defaultAppearance = CallChecker.init(COSString.class);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 295, 9637, 9646)) {
                defaultAppearance = ((COSString) (CallChecker.isCalled(dictionary, COSDictionary.class, 295, 9637, 9646).getItem(COSName.DA)));
                CallChecker.varAssign(defaultAppearance, "defaultAppearance", 295, 9637, 9646);
            }
            if (CallChecker.beforeDeref(defaultAppearance, COSString.class, 296, 9684, 9700)) {
                defaultAppearance = CallChecker.beforeCalled(defaultAppearance, COSString.class, 296, 9684, 9700);
                return CallChecker.isCalled(defaultAppearance, COSString.class, 296, 9684, 9700).getString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context10.methodEnd();
        }
    }

    public void setDefaultAppearance(String daValue) {
        MethodContext _bcornu_methode_context11 = new MethodContext(void.class, 304, 9726, 9959);
        try {
            CallChecker.varInit(this, "this", 304, 9726, 9959);
            CallChecker.varInit(daValue, "daValue", 304, 9726, 9959);
            CallChecker.varInit(this.fieldCache, "fieldCache", 304, 9726, 9959);
            CallChecker.varInit(this.dictionary, "dictionary", 304, 9726, 9959);
            CallChecker.varInit(this.document, "document", 304, 9726, 9959);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 304, 9726, 9959);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 304, 9726, 9959);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 306, 9912, 9921)) {
                CallChecker.isCalled(dictionary, COSDictionary.class, 306, 9912, 9921).setString(COSName.DA, daValue);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context11.methodEnd();
        }
    }

    public boolean getNeedAppearances() {
        MethodContext _bcornu_methode_context12 = new MethodContext(boolean.class, 315, 9966, 10309);
        try {
            CallChecker.varInit(this, "this", 315, 9966, 10309);
            CallChecker.varInit(this.fieldCache, "fieldCache", 315, 9966, 10309);
            CallChecker.varInit(this.dictionary, "dictionary", 315, 9966, 10309);
            CallChecker.varInit(this.document, "document", 315, 9966, 10309);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 315, 9966, 10309);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 315, 9966, 10309);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 317, 10249, 10258)) {
                return CallChecker.isCalled(dictionary, COSDictionary.class, 317, 10249, 10258).getBoolean(COSName.NEED_APPEARANCES, false);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context12.methodEnd();
        }
    }

    public void setNeedAppearances(Boolean value) {
        MethodContext _bcornu_methode_context13 = new MethodContext(void.class, 326, 10316, 10625);
        try {
            CallChecker.varInit(this, "this", 326, 10316, 10625);
            CallChecker.varInit(value, "value", 326, 10316, 10625);
            CallChecker.varInit(this.fieldCache, "fieldCache", 326, 10316, 10625);
            CallChecker.varInit(this.dictionary, "dictionary", 326, 10316, 10625);
            CallChecker.varInit(this.document, "document", 326, 10316, 10625);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 326, 10316, 10625);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 326, 10316, 10625);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 328, 10565, 10574)) {
                CallChecker.isCalled(dictionary, COSDictionary.class, 328, 10565, 10574).setBoolean(COSName.NEED_APPEARANCES, value);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context13.methodEnd();
        }
    }

    public PDResources getDefaultResources() {
        MethodContext _bcornu_methode_context14 = new MethodContext(PDResources.class, 336, 10632, 11037);
        try {
            CallChecker.varInit(this, "this", 336, 10632, 11037);
            CallChecker.varInit(this.fieldCache, "fieldCache", 336, 10632, 11037);
            CallChecker.varInit(this.dictionary, "dictionary", 336, 10632, 11037);
            CallChecker.varInit(this.document, "document", 336, 10632, 11037);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 336, 10632, 11037);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 336, 10632, 11037);
            PDResources retval = CallChecker.varInit(null, "retval", 338, 10810, 10835);
            COSDictionary dr = CallChecker.init(COSDictionary.class);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 339, 10880, 10889)) {
                dr = ((COSDictionary) (CallChecker.isCalled(dictionary, COSDictionary.class, 339, 10880, 10889).getDictionaryObject(COSName.DR)));
                CallChecker.varAssign(dr, "dr", 339, 10880, 10889);
            }
            if (dr != null) {
                retval = new PDResources(dr);
                CallChecker.varAssign(retval, "retval", 342, 10970, 10998);
            }
            return retval;
        } catch (ForceReturn _bcornu_return_t) {
            return ((PDResources) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context14.methodEnd();
        }
    }

    public void setDefaultResources(PDResources dr) {
        MethodContext _bcornu_methode_context15 = new MethodContext(void.class, 352, 11044, 11274);
        try {
            CallChecker.varInit(this, "this", 352, 11044, 11274);
            CallChecker.varInit(dr, "dr", 352, 11044, 11274);
            CallChecker.varInit(this.fieldCache, "fieldCache", 352, 11044, 11274);
            CallChecker.varInit(this.dictionary, "dictionary", 352, 11044, 11274);
            CallChecker.varInit(this.document, "document", 352, 11044, 11274);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 352, 11044, 11274);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 352, 11044, 11274);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 354, 11234, 11243)) {
                CallChecker.isCalled(dictionary, COSDictionary.class, 354, 11234, 11243).setItem(COSName.DR, dr);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context15.methodEnd();
        }
    }

    public boolean hasXFA() {
        MethodContext _bcornu_methode_context16 = new MethodContext(boolean.class, 362, 11281, 11496);
        try {
            CallChecker.varInit(this, "this", 362, 11281, 11496);
            CallChecker.varInit(this.fieldCache, "fieldCache", 362, 11281, 11496);
            CallChecker.varInit(this.dictionary, "dictionary", 362, 11281, 11496);
            CallChecker.varInit(this.document, "document", 362, 11281, 11496);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 362, 11281, 11496);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 362, 11281, 11496);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 364, 11455, 11464)) {
                return CallChecker.isCalled(dictionary, COSDictionary.class, 364, 11455, 11464).containsKey(COSName.XFA);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context16.methodEnd();
        }
    }

    public boolean xfaIsDynamic() {
        MethodContext _bcornu_methode_context17 = new MethodContext(boolean.class, 372, 11503, 11735);
        try {
            CallChecker.varInit(this, "this", 372, 11503, 11735);
            CallChecker.varInit(this.fieldCache, "fieldCache", 372, 11503, 11735);
            CallChecker.varInit(this.dictionary, "dictionary", 372, 11503, 11735);
            CallChecker.varInit(this.document, "document", 372, 11503, 11735);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 372, 11503, 11735);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 372, 11503, 11735);
            return (hasXFA()) && (CallChecker.isCalled(getFields(), List.class, 374, 11708, 11718).isEmpty());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context17.methodEnd();
        }
    }

    public PDXFAResource getXFA() {
        MethodContext _bcornu_methode_context18 = new MethodContext(PDXFAResource.class, 382, 11742, 12157);
        try {
            CallChecker.varInit(this, "this", 382, 11742, 12157);
            CallChecker.varInit(this.fieldCache, "fieldCache", 382, 11742, 12157);
            CallChecker.varInit(this.dictionary, "dictionary", 382, 11742, 12157);
            CallChecker.varInit(this.document, "document", 382, 11742, 12157);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 382, 11742, 12157);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 382, 11742, 12157);
            PDXFAResource xfa = CallChecker.varInit(null, "xfa", 384, 11950, 11974);
            COSBase base = CallChecker.init(COSBase.class);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 385, 11999, 12008)) {
                base = CallChecker.isCalled(dictionary, COSDictionary.class, 385, 11999, 12008).getDictionaryObject(COSName.XFA);
                CallChecker.varAssign(base, "base", 385, 11999, 12008);
            }
            if (base != null) {
                xfa = new PDXFAResource(base);
                CallChecker.varAssign(xfa, "xfa", 388, 12092, 12121);
            }
            return xfa;
        } catch (ForceReturn _bcornu_return_t) {
            return ((PDXFAResource) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context18.methodEnd();
        }
    }

    public void setXFA(PDXFAResource xfa) {
        MethodContext _bcornu_methode_context19 = new MethodContext(void.class, 398, 12164, 12384);
        try {
            CallChecker.varInit(this, "this", 398, 12164, 12384);
            CallChecker.varInit(xfa, "xfa", 398, 12164, 12384);
            CallChecker.varInit(this.fieldCache, "fieldCache", 398, 12164, 12384);
            CallChecker.varInit(this.dictionary, "dictionary", 398, 12164, 12384);
            CallChecker.varInit(this.document, "document", 398, 12164, 12384);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 398, 12164, 12384);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 398, 12164, 12384);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 400, 12342, 12351)) {
                CallChecker.isCalled(dictionary, COSDictionary.class, 400, 12342, 12351).setItem(COSName.XFA, xfa);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context19.methodEnd();
        }
    }

    public int getQ() {
        MethodContext _bcornu_methode_context20 = new MethodContext(int.class, 412, 12391, 12915);
        try {
            CallChecker.varInit(this, "this", 412, 12391, 12915);
            CallChecker.varInit(this.fieldCache, "fieldCache", 412, 12391, 12915);
            CallChecker.varInit(this.dictionary, "dictionary", 412, 12391, 12915);
            CallChecker.varInit(this.document, "document", 412, 12391, 12915);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 412, 12391, 12915);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 412, 12391, 12915);
            int retval = CallChecker.varInit(((int) (0)), "retval", 414, 12703, 12717);
            COSNumber number = CallChecker.init(COSNumber.class);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 415, 12757, 12766)) {
                number = ((COSNumber) (CallChecker.isCalled(dictionary, COSDictionary.class, 415, 12757, 12766).getDictionaryObject(COSName.Q)));
                CallChecker.varAssign(number, "number", 415, 12757, 12766);
            }
            if (number != null) {
                retval = number.intValue();
                CallChecker.varAssign(retval, "retval", 418, 12850, 12876);
            }
            return retval;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context20.methodEnd();
        }
    }

    public void setQ(int q) {
        MethodContext _bcornu_methode_context21 = new MethodContext(void.class, 428, 12922, 13150);
        try {
            CallChecker.varInit(this, "this", 428, 12922, 13150);
            CallChecker.varInit(q, "q", 428, 12922, 13150);
            CallChecker.varInit(this.fieldCache, "fieldCache", 428, 12922, 13150);
            CallChecker.varInit(this.dictionary, "dictionary", 428, 12922, 13150);
            CallChecker.varInit(this.document, "document", 428, 12922, 13150);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 428, 12922, 13150);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 428, 12922, 13150);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 430, 13113, 13122)) {
                CallChecker.isCalled(dictionary, COSDictionary.class, 430, 13113, 13122).setInt(COSName.Q, q);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context21.methodEnd();
        }
    }

    public boolean isSignaturesExist() {
        MethodContext _bcornu_methode_context22 = new MethodContext(boolean.class, 438, 13157, 13416);
        try {
            CallChecker.varInit(this, "this", 438, 13157, 13416);
            CallChecker.varInit(this.fieldCache, "fieldCache", 438, 13157, 13416);
            CallChecker.varInit(this.dictionary, "dictionary", 438, 13157, 13416);
            CallChecker.varInit(this.document, "document", 438, 13157, 13416);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 438, 13157, 13416);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 438, 13157, 13416);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 440, 13350, 13359)) {
                return CallChecker.isCalled(dictionary, COSDictionary.class, 440, 13350, 13359).getFlag(COSName.SIG_FLAGS, PDAcroForm.FLAG_SIGNATURES_EXIST);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context22.methodEnd();
        }
    }

    public void setSignaturesExist(boolean signaturesExist) {
        MethodContext _bcornu_methode_context23 = new MethodContext(void.class, 448, 13423, 13696);
        try {
            CallChecker.varInit(this, "this", 448, 13423, 13696);
            CallChecker.varInit(signaturesExist, "signaturesExist", 448, 13423, 13696);
            CallChecker.varInit(this.fieldCache, "fieldCache", 448, 13423, 13696);
            CallChecker.varInit(this.dictionary, "dictionary", 448, 13423, 13696);
            CallChecker.varInit(this.document, "document", 448, 13423, 13696);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 448, 13423, 13696);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 448, 13423, 13696);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 450, 13613, 13622)) {
                CallChecker.isCalled(dictionary, COSDictionary.class, 450, 13613, 13622).setFlag(COSName.SIG_FLAGS, PDAcroForm.FLAG_SIGNATURES_EXIST, signaturesExist);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context23.methodEnd();
        }
    }

    public boolean isAppendOnly() {
        MethodContext _bcornu_methode_context24 = new MethodContext(boolean.class, 458, 13703, 13980);
        try {
            CallChecker.varInit(this, "this", 458, 13703, 13980);
            CallChecker.varInit(this.fieldCache, "fieldCache", 458, 13703, 13980);
            CallChecker.varInit(this.dictionary, "dictionary", 458, 13703, 13980);
            CallChecker.varInit(this.document, "document", 458, 13703, 13980);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 458, 13703, 13980);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 458, 13703, 13980);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 460, 13919, 13928)) {
                return CallChecker.isCalled(dictionary, COSDictionary.class, 460, 13919, 13928).getFlag(COSName.SIG_FLAGS, PDAcroForm.FLAG_APPEND_ONLY);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context24.methodEnd();
        }
    }

    public void setAppendOnly(boolean appendOnly) {
        MethodContext _bcornu_methode_context25 = new MethodContext(void.class, 468, 13987, 14225);
        try {
            CallChecker.varInit(this, "this", 468, 13987, 14225);
            CallChecker.varInit(appendOnly, "appendOnly", 468, 13987, 14225);
            CallChecker.varInit(this.fieldCache, "fieldCache", 468, 13987, 14225);
            CallChecker.varInit(this.dictionary, "dictionary", 468, 13987, 14225);
            CallChecker.varInit(this.document, "document", 468, 13987, 14225);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 468, 13987, 14225);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 468, 13987, 14225);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 470, 14152, 14161)) {
                CallChecker.isCalled(dictionary, COSDictionary.class, 470, 14152, 14161).setFlag(COSName.SIG_FLAGS, PDAcroForm.FLAG_APPEND_ONLY, appendOnly);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context25.methodEnd();
        }
    }
}

