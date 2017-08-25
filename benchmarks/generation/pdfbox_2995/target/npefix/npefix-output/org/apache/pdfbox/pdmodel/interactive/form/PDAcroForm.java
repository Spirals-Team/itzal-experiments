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
import java.util.Iterator;
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
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.COSArrayList;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.fdf.FDFCatalog;
import org.apache.pdfbox.pdmodel.fdf.FDFDictionary;
import org.apache.pdfbox.pdmodel.fdf.FDFDocument;
import org.apache.pdfbox.pdmodel.fdf.FDFField;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.util.Matrix;

public final class PDAcroForm implements COSObjectable {
    private static final int FLAG_SIGNATURES_EXIST = 1;

    private static final int FLAG_APPEND_ONLY = 1 << 1;

    private final PDDocument document;

    private final COSDictionary dictionary;

    private Map<String, PDField> fieldCache;

    public PDAcroForm(PDDocument doc) {
        ConstructorContext _bcornu_methode_context1 = new ConstructorContext(PDAcroForm.class, 68, 2416, 2687);
        try {
            document = doc;
            CallChecker.varAssign(this.document, "this.document", 70, 2565, 2579);
            dictionary = new COSDictionary();
            CallChecker.varAssign(this.dictionary, "this.dictionary", 71, 2589, 2621);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 72, 2631, 2640)) {
                CallChecker.isCalled(dictionary, COSDictionary.class, 72, 2631, 2640).setItem(COSName.FIELDS, new COSArray());
            }
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    public PDAcroForm(PDDocument doc, COSDictionary form) {
        ConstructorContext _bcornu_methode_context2 = new ConstructorContext(PDAcroForm.class, 81, 2694, 2952);
        try {
            document = doc;
            CallChecker.varAssign(this.document, "this.document", 83, 2905, 2919);
            dictionary = form;
            CallChecker.varAssign(this.dictionary, "this.dictionary", 84, 2929, 2946);
        } finally {
            _bcornu_methode_context2.methodEnd();
        }
    }

    PDDocument getDocument() {
        MethodContext _bcornu_methode_context1 = new MethodContext(PDDocument.class, 92, 2959, 3136);
        try {
            CallChecker.varInit(this, "this", 92, 2959, 3136);
            CallChecker.varInit(this.fieldCache, "fieldCache", 92, 2959, 3136);
            CallChecker.varInit(this.dictionary, "dictionary", 92, 2959, 3136);
            CallChecker.varInit(this.document, "document", 92, 2959, 3136);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 92, 2959, 3136);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 92, 2959, 3136);
            return document;
        } catch (ForceReturn _bcornu_return_t) {
            return ((PDDocument) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    @Override
    public COSDictionary getCOSObject() {
        MethodContext _bcornu_methode_context2 = new MethodContext(COSDictionary.class, 98, 3147, 3234);
        try {
            CallChecker.varInit(this, "this", 98, 3147, 3234);
            CallChecker.varInit(this.fieldCache, "fieldCache", 98, 3147, 3234);
            CallChecker.varInit(this.dictionary, "dictionary", 98, 3147, 3234);
            CallChecker.varInit(this.document, "document", 98, 3147, 3234);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 98, 3147, 3234);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 98, 3147, 3234);
            return dictionary;
        } catch (ForceReturn _bcornu_return_t) {
            return ((COSDictionary) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2.methodEnd();
        }
    }

    public void importFDF(FDFDocument fdf) throws IOException {
        MethodContext _bcornu_methode_context3 = new MethodContext(void.class, 111, 3241, 3998);
        try {
            CallChecker.varInit(this, "this", 111, 3241, 3998);
            CallChecker.varInit(fdf, "fdf", 111, 3241, 3998);
            CallChecker.varInit(this.fieldCache, "fieldCache", 111, 3241, 3998);
            CallChecker.varInit(this.dictionary, "dictionary", 111, 3241, 3998);
            CallChecker.varInit(this.document, "document", 111, 3241, 3998);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 111, 3241, 3998);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 111, 3241, 3998);
            List<FDFField> fields = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(fdf, FDFDocument.class, 113, 3593, 3595)) {
                fdf = CallChecker.beforeCalled(fdf, FDFDocument.class, 113, 3593, 3595);
                if (CallChecker.beforeDeref(CallChecker.isCalled(fdf, FDFDocument.class, 113, 3593, 3595).getCatalog(), FDFCatalog.class, 113, 3593, 3608)) {
                    fdf = CallChecker.beforeCalled(fdf, FDFDocument.class, 113, 3593, 3595);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(fdf, FDFDocument.class, 113, 3593, 3595).getCatalog(), FDFCatalog.class, 113, 3593, 3608).getFDF(), FDFDictionary.class, 113, 3593, 3617)) {
                        fdf = CallChecker.beforeCalled(fdf, FDFDocument.class, 113, 3593, 3595);
                        fields = CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(fdf, FDFDocument.class, 113, 3593, 3595).getCatalog(), FDFCatalog.class, 113, 3593, 3608).getFDF(), FDFDictionary.class, 113, 3593, 3617).getFields();
                        CallChecker.varAssign(fields, "fields", 113, 3593, 3595);
                    }
                }
            }
            if (fields != null) {
                for (FDFField field : fields) {
                    FDFField fdfField = CallChecker.varInit(field, "fdfField", 118, 3742, 3767);
                    PDField docField = CallChecker.init(PDField.class);
                    if (CallChecker.beforeDeref(fdfField, FDFField.class, 119, 3813, 3820)) {
                        fdfField = CallChecker.beforeCalled(fdfField, FDFField.class, 119, 3813, 3820);
                        docField = getField(CallChecker.isCalled(fdfField, FDFField.class, 119, 3813, 3820).getPartialFieldName());
                        CallChecker.varAssign(docField, "docField", 119, 3813, 3820);
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
        MethodContext _bcornu_methode_context4 = new MethodContext(FDFDocument.class, 134, 4005, 4853);
        try {
            CallChecker.varInit(this, "this", 134, 4005, 4853);
            CallChecker.varInit(this.fieldCache, "fieldCache", 134, 4005, 4853);
            CallChecker.varInit(this.dictionary, "dictionary", 134, 4005, 4853);
            CallChecker.varInit(this.document, "document", 134, 4005, 4853);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 134, 4005, 4853);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 134, 4005, 4853);
            FDFDocument fdf = CallChecker.varInit(new FDFDocument(), "fdf", 136, 4272, 4307);
            FDFCatalog catalog = CallChecker.init(FDFCatalog.class);
            if (CallChecker.beforeDeref(fdf, FDFDocument.class, 137, 4338, 4340)) {
                fdf = CallChecker.beforeCalled(fdf, FDFDocument.class, 137, 4338, 4340);
                catalog = CallChecker.isCalled(fdf, FDFDocument.class, 137, 4338, 4340).getCatalog();
                CallChecker.varAssign(catalog, "catalog", 137, 4338, 4340);
            }
            FDFDictionary fdfDict = CallChecker.varInit(new FDFDictionary(), "fdfDict", 138, 4364, 4407);
            if (CallChecker.beforeDeref(catalog, FDFCatalog.class, 139, 4417, 4423)) {
                catalog = CallChecker.beforeCalled(catalog, FDFCatalog.class, 139, 4417, 4423);
                CallChecker.isCalled(catalog, FDFCatalog.class, 139, 4417, 4423).setFDF(fdfDict);
            }
            List<FDFField> fdfFields = CallChecker.varInit(new ArrayList<FDFField>(), "fdfFields", 141, 4451, 4503);
            List<PDField> fields = CallChecker.varInit(getFields(), "fields", 142, 4513, 4547);
            if (CallChecker.beforeDeref(fields, FDFDocument.class, 143, 4578, 4583)) {
                for (PDField field : fields) {
                    if (CallChecker.beforeDeref(field, PDField.class, 145, 4622, 4626)) {
                        if (CallChecker.beforeDeref(fdfFields, List.class, 145, 4608, 4616)) {
                            fdfFields = CallChecker.beforeCalled(fdfFields, List.class, 145, 4608, 4616);
                            CallChecker.isCalled(fdfFields, List.class, 145, 4608, 4616).add(CallChecker.isCalled(field, PDField.class, 145, 4622, 4626).exportFDF());
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(document, PDDocument.class, 148, 4683, 4690)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(document, PDDocument.class, 148, 4683, 4690).getDocument(), COSDocument.class, 148, 4683, 4704)) {
                    if (CallChecker.beforeDeref(fdfDict, FDFDictionary.class, 148, 4669, 4675)) {
                        fdfDict = CallChecker.beforeCalled(fdfDict, FDFDictionary.class, 148, 4669, 4675);
                        CallChecker.isCalled(fdfDict, FDFDictionary.class, 148, 4669, 4675).setID(CallChecker.isCalled(CallChecker.isCalled(document, PDDocument.class, 148, 4683, 4690).getDocument(), COSDocument.class, 148, 4683, 4704).getDocumentID());
                    }
                }
            }
            if (CallChecker.beforeDeref(fdfFields, List.class, 150, 4746, 4754)) {
                fdfFields = CallChecker.beforeCalled(fdfFields, List.class, 150, 4746, 4754);
                if (!(CallChecker.isCalled(fdfFields, List.class, 150, 4746, 4754).isEmpty())) {
                    if (CallChecker.beforeDeref(fdfDict, FDFDictionary.class, 152, 4789, 4795)) {
                        fdfDict = CallChecker.beforeCalled(fdfDict, FDFDictionary.class, 152, 4789, 4795);
                        CallChecker.isCalled(fdfDict, FDFDictionary.class, 152, 4789, 4795).setFields(fdfFields);
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

    public void flatten() throws IOException {
        MethodContext _bcornu_methode_context5 = new MethodContext(void.class, 166, 4869, 7514);
        try {
            CallChecker.varInit(this, "this", 166, 4869, 7514);
            CallChecker.varInit(this.fieldCache, "fieldCache", 166, 4869, 7514);
            CallChecker.varInit(this.dictionary, "dictionary", 166, 4869, 7514);
            CallChecker.varInit(this.document, "document", 166, 4869, 7514);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 166, 4869, 7514);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 166, 4869, 7514);
            boolean isContentStreamWrapped = CallChecker.varInit(((boolean) (false)), "isContentStreamWrapped", 170, 5306, 5344);
            PDPageContentStream contentStream = CallChecker.init(PDPageContentStream.class);
            for (PDField field : getFieldTree()) {
                for (PDAnnotationWidget widget : CallChecker.isCalled(((PDTerminalField) (field)), PDTerminalField.class, 179, 5697, 5701).getWidgets()) {
                    if (CallChecker.beforeDeref(widget, PDAnnotationWidget.class, 181, 5752, 5757)) {
                        if ((CallChecker.isCalled(widget, PDAnnotationWidget.class, 181, 5752, 5757).getNormalAppearanceStream()) != null) {
                            PDPage page = CallChecker.init(PDPage.class);
                            if (CallChecker.beforeDeref(widget, PDAnnotationWidget.class, 183, 5848, 5853)) {
                                page = CallChecker.isCalled(widget, PDAnnotationWidget.class, 183, 5848, 5853).getPage();
                                CallChecker.varAssign(page, "page", 183, 5848, 5853);
                            }
                            if (!isContentStreamWrapped) {
                                contentStream = new PDPageContentStream(document, page, true, true, true);
                                CallChecker.varAssign(contentStream, "contentStream", 186, 5961, 6034);
                                isContentStreamWrapped = true;
                                CallChecker.varAssign(isContentStreamWrapped, "isContentStreamWrapped", 187, 6060, 6089);
                            }else {
                                contentStream = new PDPageContentStream(document, page, true, true);
                                CallChecker.varAssign(contentStream, "contentStream", 191, 6184, 6251);
                            }
                            PDFormXObject fieldObject = CallChecker.init(PDFormXObject.class);
                            if (CallChecker.beforeDeref(widget, PDAnnotationWidget.class, 194, 6362, 6367)) {
                                fieldObject = new PDFormXObject(CallChecker.isCalled(widget, PDAnnotationWidget.class, 194, 6362, 6367).getNormalAppearanceStream().getCOSStream());
                                CallChecker.varAssign(fieldObject, "fieldObject", 194, 6362, 6367);
                            }
                            Matrix translationMatrix = CallChecker.init(Matrix.class);
                            if (CallChecker.beforeDeref(widget, PDAnnotationWidget.class, 196, 6510, 6515)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(widget, PDAnnotationWidget.class, 196, 6510, 6515).getRectangle(), PDRectangle.class, 196, 6510, 6530)) {
                                    if (CallChecker.beforeDeref(widget, PDAnnotationWidget.class, 196, 6549, 6554)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(widget, PDAnnotationWidget.class, 196, 6549, 6554).getRectangle(), PDRectangle.class, 196, 6549, 6569)) {
                                            translationMatrix = Matrix.getTranslateInstance(CallChecker.isCalled(CallChecker.isCalled(widget, PDAnnotationWidget.class, 196, 6510, 6515).getRectangle(), PDRectangle.class, 196, 6510, 6530).getLowerLeftX(), CallChecker.isCalled(CallChecker.isCalled(widget, PDAnnotationWidget.class, 196, 6549, 6554).getRectangle(), PDRectangle.class, 196, 6549, 6569).getLowerLeftY());
                                            CallChecker.varAssign(translationMatrix, "translationMatrix", 196, 6510, 6515);
                                        }
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(contentStream, PDPageContentStream.class, 197, 6609, 6621)) {
                                contentStream = CallChecker.beforeCalled(contentStream, PDPageContentStream.class, 197, 6609, 6621);
                                CallChecker.isCalled(contentStream, PDPageContentStream.class, 197, 6609, 6621).saveGraphicsState();
                            }
                            if (CallChecker.beforeDeref(contentStream, PDPageContentStream.class, 198, 6664, 6676)) {
                                contentStream = CallChecker.beforeCalled(contentStream, PDPageContentStream.class, 198, 6664, 6676);
                                CallChecker.isCalled(contentStream, PDPageContentStream.class, 198, 6664, 6676).transform(translationMatrix);
                            }
                            if (CallChecker.beforeDeref(contentStream, PDPageContentStream.class, 199, 6728, 6740)) {
                                contentStream = CallChecker.beforeCalled(contentStream, PDPageContentStream.class, 199, 6728, 6740);
                                CallChecker.isCalled(contentStream, PDPageContentStream.class, 199, 6728, 6740).drawForm(fieldObject);
                            }
                            if (CallChecker.beforeDeref(contentStream, PDPageContentStream.class, 200, 6785, 6797)) {
                                contentStream = CallChecker.beforeCalled(contentStream, PDPageContentStream.class, 200, 6785, 6797);
                                CallChecker.isCalled(contentStream, PDPageContentStream.class, 200, 6785, 6797).restoreGraphicsState();
                            }
                            if (CallChecker.beforeDeref(contentStream, PDPageContentStream.class, 201, 6843, 6855)) {
                                contentStream = CallChecker.beforeCalled(contentStream, PDPageContentStream.class, 201, 6843, 6855);
                                CallChecker.isCalled(contentStream, PDPageContentStream.class, 201, 6843, 6855).close();
                            }
                        }
                    }
                }
            }
            for (PDPage page : CallChecker.isCalled(document, PDDocument.class, 207, 6983, 6990).getPages()) {
                List<PDAnnotation> annotations = CallChecker.varInit(new ArrayList<PDAnnotation>(), "annotations", 209, 7026, 7088);
                for (PDAnnotation annotation : CallChecker.isCalled(page, PDPage.class, 211, 7145, 7148).getAnnotations()) {
                    if (!(annotation instanceof PDAnnotationWidget)) {
                        if (CallChecker.beforeDeref(annotations, List.class, 215, 7285, 7295)) {
                            annotations = CallChecker.beforeCalled(annotations, List.class, 215, 7285, 7295);
                            CallChecker.isCalled(annotations, List.class, 215, 7285, 7295).add(annotation);
                        }
                    }
                }
                if (CallChecker.beforeDeref(page, PDPage.class, 218, 7375, 7378)) {
                    CallChecker.isCalled(page, PDPage.class, 218, 7375, 7378).setAnnotations(annotations);
                }
            }
            setFields(Collections.<PDField>emptyList());
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5.methodEnd();
        }
    }

    public List<PDField> getFields() {
        MethodContext _bcornu_methode_context6 = new MethodContext(List.class, 238, 7525, 8871);
        try {
            CallChecker.varInit(this, "this", 238, 7525, 8871);
            CallChecker.varInit(this.fieldCache, "fieldCache", 238, 7525, 8871);
            CallChecker.varInit(this.dictionary, "dictionary", 238, 7525, 8871);
            CallChecker.varInit(this.document, "document", 238, 7525, 8871);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 238, 7525, 8871);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 238, 7525, 8871);
            COSArray cosFields = CallChecker.init(COSArray.class);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 240, 8205, 8214)) {
                cosFields = ((COSArray) (CallChecker.isCalled(dictionary, COSDictionary.class, 240, 8205, 8214).getDictionaryObject(COSName.FIELDS)));
                CallChecker.varAssign(cosFields, "cosFields", 240, 8205, 8214);
            }
            if (cosFields == null) {
                return Collections.emptyList();
            }
            List<PDField> pdFields = CallChecker.varInit(new ArrayList<PDField>(), "pdFields", 245, 8356, 8405);
            for (int i = 0; i < (cosFields.size()); i++) {
                COSDictionary element = CallChecker.varInit(((COSDictionary) (cosFields.getObject(i))), "element", 248, 8480, 8542);
                if (element != null) {
                    PDField field = CallChecker.varInit(PDField.fromDictionary(this, element, null), "field", 251, 8607, 8666);
                    if (field != null) {
                        if (CallChecker.beforeDeref(pdFields, List.class, 254, 8741, 8748)) {
                            pdFields = CallChecker.beforeCalled(pdFields, List.class, 254, 8741, 8748);
                            CallChecker.isCalled(pdFields, List.class, 254, 8741, 8748).add(field);
                        }
                    }
                }
            }
            return new COSArrayList<PDField>(pdFields, cosFields);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<PDField>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context6.methodEnd();
        }
    }

    public void setFields(List<PDField> fields) {
        MethodContext _bcornu_methode_context7 = new MethodContext(void.class, 266, 8878, 9155);
        try {
            CallChecker.varInit(this, "this", 266, 8878, 9155);
            CallChecker.varInit(fields, "fields", 266, 8878, 9155);
            CallChecker.varInit(this.fieldCache, "fieldCache", 266, 8878, 9155);
            CallChecker.varInit(this.dictionary, "dictionary", 266, 8878, 9155);
            CallChecker.varInit(this.document, "document", 266, 8878, 9155);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 266, 8878, 9155);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 266, 8878, 9155);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 268, 9073, 9082)) {
                CallChecker.isCalled(dictionary, COSDictionary.class, 268, 9073, 9082).setItem(COSName.FIELDS, COSArrayList.converterToCOSArray(fields));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context7.methodEnd();
        }
    }

    public Iterator<PDField> getFieldIterator() {
        MethodContext _bcornu_methode_context8 = new MethodContext(Iterator.class, 274, 9166, 9364);
        try {
            CallChecker.varInit(this, "this", 274, 9166, 9364);
            CallChecker.varInit(this.fieldCache, "fieldCache", 274, 9166, 9364);
            CallChecker.varInit(this.dictionary, "dictionary", 274, 9166, 9364);
            CallChecker.varInit(this.document, "document", 274, 9166, 9364);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 274, 9166, 9364);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 274, 9166, 9364);
            if (CallChecker.beforeDeref(new PDFieldTree(this), PDFieldTree.class, 276, 9326, 9346)) {
                return CallChecker.isCalled(new PDFieldTree(this), PDFieldTree.class, 276, 9326, 9346).iterator();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<PDField>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context8.methodEnd();
        }
    }

    public PDFieldTree getFieldTree() {
        MethodContext _bcornu_methode_context9 = new MethodContext(PDFieldTree.class, 282, 9371, 9527);
        try {
            CallChecker.varInit(this, "this", 282, 9371, 9527);
            CallChecker.varInit(this.fieldCache, "fieldCache", 282, 9371, 9527);
            CallChecker.varInit(this.dictionary, "dictionary", 282, 9371, 9527);
            CallChecker.varInit(this.document, "document", 282, 9371, 9527);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 282, 9371, 9527);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 282, 9371, 9527);
            return new PDFieldTree(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PDFieldTree) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context9.methodEnd();
        }
    }

    public void setCacheFields(boolean cache) {
        MethodContext _bcornu_methode_context10 = new MethodContext(void.class, 295, 9542, 10289);
        try {
            CallChecker.varInit(this, "this", 295, 9542, 10289);
            CallChecker.varInit(cache, "cache", 295, 9542, 10289);
            CallChecker.varInit(this.fieldCache, "fieldCache", 295, 9542, 10289);
            CallChecker.varInit(this.dictionary, "dictionary", 295, 9542, 10289);
            CallChecker.varInit(this.document, "document", 295, 9542, 10289);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 295, 9542, 10289);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 295, 9542, 10289);
            if (cache) {
                fieldCache = new HashMap<String, PDField>();
                CallChecker.varAssign(this.fieldCache, "this.fieldCache", 299, 10018, 10061);
                for (PDField field : getFieldTree()) {
                    if (CallChecker.beforeDeref(field, PDField.class, 303, 10158, 10162)) {
                        if (CallChecker.beforeDeref(fieldCache, Map.class, 303, 10143, 10152)) {
                            fieldCache = CallChecker.beforeCalled(fieldCache, Map.class, 303, 10143, 10152);
                            CallChecker.isCalled(fieldCache, Map.class, 303, 10143, 10152).put(CallChecker.isCalled(field, PDField.class, 303, 10158, 10162).getFullyQualifiedName(), field);
                        }
                    }
                }
            }else {
                fieldCache = null;
                CallChecker.varAssign(this.fieldCache, "this.fieldCache", 308, 10256, 10273);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context10.methodEnd();
        }
    }

    public boolean isCachingFields() {
        MethodContext _bcornu_methode_context11 = new MethodContext(boolean.class, 317, 10296, 10512);
        try {
            CallChecker.varInit(this, "this", 317, 10296, 10512);
            CallChecker.varInit(this.fieldCache, "fieldCache", 317, 10296, 10512);
            CallChecker.varInit(this.dictionary, "dictionary", 317, 10296, 10512);
            CallChecker.varInit(this.document, "document", 317, 10296, 10512);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 317, 10296, 10512);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 317, 10296, 10512);
            return (fieldCache) != null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context11.methodEnd();
        }
    }

    public PDField getField(String fullyQualifiedName) {
        MethodContext _bcornu_methode_context12 = new MethodContext(PDField.class, 328, 10519, 11265);
        try {
            CallChecker.varInit(this, "this", 328, 10519, 11265);
            CallChecker.varInit(fullyQualifiedName, "fullyQualifiedName", 328, 10519, 11265);
            CallChecker.varInit(this.fieldCache, "fieldCache", 328, 10519, 11265);
            CallChecker.varInit(this.dictionary, "dictionary", 328, 10519, 11265);
            CallChecker.varInit(this.document, "document", 328, 10519, 11265);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 328, 10519, 11265);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 328, 10519, 11265);
            if ((fieldCache) != null) {
                return fieldCache.get(fullyQualifiedName);
            }
            for (PDField field : getFieldTree()) {
                if (CallChecker.beforeDeref(field, PDField.class, 339, 11097, 11101)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(field, PDField.class, 339, 11097, 11101).getFullyQualifiedName(), String.class, 339, 11097, 11125)) {
                        if ((CallChecker.isCalled(CallChecker.isCalled(field, PDField.class, 339, 11097, 11101).getFullyQualifiedName(), String.class, 339, 11097, 11125).compareTo(fullyQualifiedName)) == 0) {
                            return field;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((PDField) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context12.methodEnd();
        }
    }

    public String getDefaultAppearance() {
        MethodContext _bcornu_methode_context13 = new MethodContext(String.class, 353, 11272, 11561);
        try {
            CallChecker.varInit(this, "this", 353, 11272, 11561);
            CallChecker.varInit(this.fieldCache, "fieldCache", 353, 11272, 11561);
            CallChecker.varInit(this.dictionary, "dictionary", 353, 11272, 11561);
            CallChecker.varInit(this.document, "document", 353, 11272, 11561);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 353, 11272, 11561);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 353, 11272, 11561);
            COSString defaultAppearance = CallChecker.init(COSString.class);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 355, 11479, 11488)) {
                defaultAppearance = ((COSString) (CallChecker.isCalled(dictionary, COSDictionary.class, 355, 11479, 11488).getItem(COSName.DA)));
                CallChecker.varAssign(defaultAppearance, "defaultAppearance", 355, 11479, 11488);
            }
            if (CallChecker.beforeDeref(defaultAppearance, COSString.class, 356, 11526, 11542)) {
                defaultAppearance = CallChecker.beforeCalled(defaultAppearance, COSString.class, 356, 11526, 11542);
                return CallChecker.isCalled(defaultAppearance, COSString.class, 356, 11526, 11542).getString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context13.methodEnd();
        }
    }

    public void setDefaultAppearance(String daValue) {
        MethodContext _bcornu_methode_context14 = new MethodContext(void.class, 364, 11568, 11802);
        try {
            CallChecker.varInit(this, "this", 364, 11568, 11802);
            CallChecker.varInit(daValue, "daValue", 364, 11568, 11802);
            CallChecker.varInit(this.fieldCache, "fieldCache", 364, 11568, 11802);
            CallChecker.varInit(this.dictionary, "dictionary", 364, 11568, 11802);
            CallChecker.varInit(this.document, "document", 364, 11568, 11802);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 364, 11568, 11802);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 364, 11568, 11802);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 366, 11755, 11764)) {
                CallChecker.isCalled(dictionary, COSDictionary.class, 366, 11755, 11764).setString(COSName.DA, daValue);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context14.methodEnd();
        }
    }

    public boolean getNeedAppearances() {
        MethodContext _bcornu_methode_context15 = new MethodContext(boolean.class, 375, 11809, 12153);
        try {
            CallChecker.varInit(this, "this", 375, 11809, 12153);
            CallChecker.varInit(this.fieldCache, "fieldCache", 375, 11809, 12153);
            CallChecker.varInit(this.dictionary, "dictionary", 375, 11809, 12153);
            CallChecker.varInit(this.document, "document", 375, 11809, 12153);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 375, 11809, 12153);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 375, 11809, 12153);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 377, 12093, 12102)) {
                return CallChecker.isCalled(dictionary, COSDictionary.class, 377, 12093, 12102).getBoolean(COSName.NEED_APPEARANCES, false);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context15.methodEnd();
        }
    }

    public void setNeedAppearances(Boolean value) {
        MethodContext _bcornu_methode_context16 = new MethodContext(void.class, 386, 12160, 12470);
        try {
            CallChecker.varInit(this, "this", 386, 12160, 12470);
            CallChecker.varInit(value, "value", 386, 12160, 12470);
            CallChecker.varInit(this.fieldCache, "fieldCache", 386, 12160, 12470);
            CallChecker.varInit(this.dictionary, "dictionary", 386, 12160, 12470);
            CallChecker.varInit(this.document, "document", 386, 12160, 12470);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 386, 12160, 12470);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 386, 12160, 12470);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 388, 12410, 12419)) {
                CallChecker.isCalled(dictionary, COSDictionary.class, 388, 12410, 12419).setBoolean(COSName.NEED_APPEARANCES, value);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context16.methodEnd();
        }
    }

    public PDResources getDefaultResources() {
        MethodContext _bcornu_methode_context17 = new MethodContext(PDResources.class, 396, 12481, 12886);
        try {
            CallChecker.varInit(this, "this", 396, 12481, 12886);
            CallChecker.varInit(this.fieldCache, "fieldCache", 396, 12481, 12886);
            CallChecker.varInit(this.dictionary, "dictionary", 396, 12481, 12886);
            CallChecker.varInit(this.document, "document", 396, 12481, 12886);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 396, 12481, 12886);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 396, 12481, 12886);
            PDResources retval = CallChecker.varInit(null, "retval", 398, 12659, 12684);
            COSDictionary dr = CallChecker.init(COSDictionary.class);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 399, 12729, 12738)) {
                dr = ((COSDictionary) (CallChecker.isCalled(dictionary, COSDictionary.class, 399, 12729, 12738).getDictionaryObject(COSName.DR)));
                CallChecker.varAssign(dr, "dr", 399, 12729, 12738);
            }
            if (dr != null) {
                retval = new PDResources(dr);
                CallChecker.varAssign(retval, "retval", 402, 12819, 12847);
            }
            return retval;
        } catch (ForceReturn _bcornu_return_t) {
            return ((PDResources) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context17.methodEnd();
        }
    }

    public void setDefaultResources(PDResources dr) {
        MethodContext _bcornu_methode_context18 = new MethodContext(void.class, 412, 12893, 13123);
        try {
            CallChecker.varInit(this, "this", 412, 12893, 13123);
            CallChecker.varInit(dr, "dr", 412, 12893, 13123);
            CallChecker.varInit(this.fieldCache, "fieldCache", 412, 12893, 13123);
            CallChecker.varInit(this.dictionary, "dictionary", 412, 12893, 13123);
            CallChecker.varInit(this.document, "document", 412, 12893, 13123);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 412, 12893, 13123);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 412, 12893, 13123);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 414, 13083, 13092)) {
                CallChecker.isCalled(dictionary, COSDictionary.class, 414, 13083, 13092).setItem(COSName.DR, dr);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context18.methodEnd();
        }
    }

    public boolean hasXFA() {
        MethodContext _bcornu_methode_context19 = new MethodContext(boolean.class, 422, 13130, 13345);
        try {
            CallChecker.varInit(this, "this", 422, 13130, 13345);
            CallChecker.varInit(this.fieldCache, "fieldCache", 422, 13130, 13345);
            CallChecker.varInit(this.dictionary, "dictionary", 422, 13130, 13345);
            CallChecker.varInit(this.document, "document", 422, 13130, 13345);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 422, 13130, 13345);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 422, 13130, 13345);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 424, 13304, 13313)) {
                return CallChecker.isCalled(dictionary, COSDictionary.class, 424, 13304, 13313).containsKey(COSName.XFA);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context19.methodEnd();
        }
    }

    public boolean xfaIsDynamic() {
        MethodContext _bcornu_methode_context20 = new MethodContext(boolean.class, 432, 13352, 13584);
        try {
            CallChecker.varInit(this, "this", 432, 13352, 13584);
            CallChecker.varInit(this.fieldCache, "fieldCache", 432, 13352, 13584);
            CallChecker.varInit(this.dictionary, "dictionary", 432, 13352, 13584);
            CallChecker.varInit(this.document, "document", 432, 13352, 13584);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 432, 13352, 13584);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 432, 13352, 13584);
            return (hasXFA()) && (CallChecker.isCalled(getFields(), List.class, 434, 13557, 13567).isEmpty());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context20.methodEnd();
        }
    }

    public PDXFAResource getXFA() {
        MethodContext _bcornu_methode_context21 = new MethodContext(PDXFAResource.class, 442, 13595, 14010);
        try {
            CallChecker.varInit(this, "this", 442, 13595, 14010);
            CallChecker.varInit(this.fieldCache, "fieldCache", 442, 13595, 14010);
            CallChecker.varInit(this.dictionary, "dictionary", 442, 13595, 14010);
            CallChecker.varInit(this.document, "document", 442, 13595, 14010);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 442, 13595, 14010);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 442, 13595, 14010);
            PDXFAResource xfa = CallChecker.varInit(null, "xfa", 444, 13803, 13827);
            COSBase base = CallChecker.init(COSBase.class);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 445, 13852, 13861)) {
                base = CallChecker.isCalled(dictionary, COSDictionary.class, 445, 13852, 13861).getDictionaryObject(COSName.XFA);
                CallChecker.varAssign(base, "base", 445, 13852, 13861);
            }
            if (base != null) {
                xfa = new PDXFAResource(base);
                CallChecker.varAssign(xfa, "xfa", 448, 13945, 13974);
            }
            return xfa;
        } catch (ForceReturn _bcornu_return_t) {
            return ((PDXFAResource) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context21.methodEnd();
        }
    }

    public void setXFA(PDXFAResource xfa) {
        MethodContext _bcornu_methode_context22 = new MethodContext(void.class, 458, 14017, 14237);
        try {
            CallChecker.varInit(this, "this", 458, 14017, 14237);
            CallChecker.varInit(xfa, "xfa", 458, 14017, 14237);
            CallChecker.varInit(this.fieldCache, "fieldCache", 458, 14017, 14237);
            CallChecker.varInit(this.dictionary, "dictionary", 458, 14017, 14237);
            CallChecker.varInit(this.document, "document", 458, 14017, 14237);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 458, 14017, 14237);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 458, 14017, 14237);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 460, 14195, 14204)) {
                CallChecker.isCalled(dictionary, COSDictionary.class, 460, 14195, 14204).setItem(COSName.XFA, xfa);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context22.methodEnd();
        }
    }

    public int getQ() {
        MethodContext _bcornu_methode_context23 = new MethodContext(int.class, 472, 14248, 14772);
        try {
            CallChecker.varInit(this, "this", 472, 14248, 14772);
            CallChecker.varInit(this.fieldCache, "fieldCache", 472, 14248, 14772);
            CallChecker.varInit(this.dictionary, "dictionary", 472, 14248, 14772);
            CallChecker.varInit(this.document, "document", 472, 14248, 14772);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 472, 14248, 14772);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 472, 14248, 14772);
            int retval = CallChecker.varInit(((int) (0)), "retval", 474, 14560, 14574);
            COSNumber number = CallChecker.init(COSNumber.class);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 475, 14614, 14623)) {
                number = ((COSNumber) (CallChecker.isCalled(dictionary, COSDictionary.class, 475, 14614, 14623).getDictionaryObject(COSName.Q)));
                CallChecker.varAssign(number, "number", 475, 14614, 14623);
            }
            if (number != null) {
                retval = number.intValue();
                CallChecker.varAssign(retval, "retval", 478, 14707, 14733);
            }
            return retval;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context23.methodEnd();
        }
    }

    public void setQ(int q) {
        MethodContext _bcornu_methode_context24 = new MethodContext(void.class, 488, 14779, 15007);
        try {
            CallChecker.varInit(this, "this", 488, 14779, 15007);
            CallChecker.varInit(q, "q", 488, 14779, 15007);
            CallChecker.varInit(this.fieldCache, "fieldCache", 488, 14779, 15007);
            CallChecker.varInit(this.dictionary, "dictionary", 488, 14779, 15007);
            CallChecker.varInit(this.document, "document", 488, 14779, 15007);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 488, 14779, 15007);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 488, 14779, 15007);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 490, 14970, 14979)) {
                CallChecker.isCalled(dictionary, COSDictionary.class, 490, 14970, 14979).setInt(COSName.Q, q);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context24.methodEnd();
        }
    }

    public boolean isSignaturesExist() {
        MethodContext _bcornu_methode_context25 = new MethodContext(boolean.class, 498, 15014, 15274);
        try {
            CallChecker.varInit(this, "this", 498, 15014, 15274);
            CallChecker.varInit(this.fieldCache, "fieldCache", 498, 15014, 15274);
            CallChecker.varInit(this.dictionary, "dictionary", 498, 15014, 15274);
            CallChecker.varInit(this.document, "document", 498, 15014, 15274);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 498, 15014, 15274);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 498, 15014, 15274);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 500, 15208, 15217)) {
                return CallChecker.isCalled(dictionary, COSDictionary.class, 500, 15208, 15217).getFlag(COSName.SIG_FLAGS, PDAcroForm.FLAG_SIGNATURES_EXIST);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context25.methodEnd();
        }
    }

    public void setSignaturesExist(boolean signaturesExist) {
        MethodContext _bcornu_methode_context26 = new MethodContext(void.class, 508, 15281, 15554);
        try {
            CallChecker.varInit(this, "this", 508, 15281, 15554);
            CallChecker.varInit(signaturesExist, "signaturesExist", 508, 15281, 15554);
            CallChecker.varInit(this.fieldCache, "fieldCache", 508, 15281, 15554);
            CallChecker.varInit(this.dictionary, "dictionary", 508, 15281, 15554);
            CallChecker.varInit(this.document, "document", 508, 15281, 15554);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 508, 15281, 15554);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 508, 15281, 15554);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 510, 15471, 15480)) {
                CallChecker.isCalled(dictionary, COSDictionary.class, 510, 15471, 15480).setFlag(COSName.SIG_FLAGS, PDAcroForm.FLAG_SIGNATURES_EXIST, signaturesExist);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context26.methodEnd();
        }
    }

    public boolean isAppendOnly() {
        MethodContext _bcornu_methode_context27 = new MethodContext(boolean.class, 518, 15561, 15839);
        try {
            CallChecker.varInit(this, "this", 518, 15561, 15839);
            CallChecker.varInit(this.fieldCache, "fieldCache", 518, 15561, 15839);
            CallChecker.varInit(this.dictionary, "dictionary", 518, 15561, 15839);
            CallChecker.varInit(this.document, "document", 518, 15561, 15839);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 518, 15561, 15839);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 518, 15561, 15839);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 520, 15778, 15787)) {
                return CallChecker.isCalled(dictionary, COSDictionary.class, 520, 15778, 15787).getFlag(COSName.SIG_FLAGS, PDAcroForm.FLAG_APPEND_ONLY);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context27.methodEnd();
        }
    }

    public void setAppendOnly(boolean appendOnly) {
        MethodContext _bcornu_methode_context28 = new MethodContext(void.class, 528, 15846, 16084);
        try {
            CallChecker.varInit(this, "this", 528, 15846, 16084);
            CallChecker.varInit(appendOnly, "appendOnly", 528, 15846, 16084);
            CallChecker.varInit(this.fieldCache, "fieldCache", 528, 15846, 16084);
            CallChecker.varInit(this.dictionary, "dictionary", 528, 15846, 16084);
            CallChecker.varInit(this.document, "document", 528, 15846, 16084);
            CallChecker.varInit(FLAG_APPEND_ONLY, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_APPEND_ONLY", 528, 15846, 16084);
            CallChecker.varInit(FLAG_SIGNATURES_EXIST, "org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm.FLAG_SIGNATURES_EXIST", 528, 15846, 16084);
            if (CallChecker.beforeDeref(dictionary, COSDictionary.class, 530, 16011, 16020)) {
                CallChecker.isCalled(dictionary, COSDictionary.class, 530, 16011, 16020).setFlag(COSName.SIG_FLAGS, PDAcroForm.FLAG_APPEND_ONLY, appendOnly);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context28.methodEnd();
        }
    }
}

