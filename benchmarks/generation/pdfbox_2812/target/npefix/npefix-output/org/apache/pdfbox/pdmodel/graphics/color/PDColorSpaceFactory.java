package org.apache.pdfbox.pdmodel.graphics.color;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.awt.color.ColorSpace;
import java.io.IOException;
import java.util.Map;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.graphics.pattern.PDPatternResources;

public final class PDColorSpaceFactory {
    private PDColorSpaceFactory() {
        ConstructorContext _bcornu_methode_context1 = new ConstructorContext(PDColorSpaceFactory.class, 46, 1641, 1795);
        try {
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    public static PDColorSpace createColorSpace(COSBase colorSpace) throws IOException {
        MethodContext _bcornu_methode_context1 = new MethodContext(PDColorSpace.class, 60, 1802, 2195);
        try {
            CallChecker.varInit(colorSpace, "colorSpace", 60, 1802, 2195);
            return PDColorSpaceFactory.createColorSpace(colorSpace, null);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PDColorSpace) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    public static PDColorSpace createColorSpace(COSBase colorSpace, Map<String, PDColorSpace> colorSpaces) throws IOException {
        MethodContext _bcornu_methode_context2 = new MethodContext(PDColorSpace.class, 75, 2202, 2741);
        try {
            CallChecker.varInit(colorSpaces, "colorSpaces", 75, 2202, 2741);
            CallChecker.varInit(colorSpace, "colorSpace", 75, 2202, 2741);
            return PDColorSpaceFactory.createColorSpace(colorSpace, colorSpaces, null);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PDColorSpace) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2.methodEnd();
        }
    }

    public static PDColorSpace createColorSpace(COSBase colorSpace, Map<String, PDColorSpace> colorSpaces, Map<String, PDPatternResources> patterns) throws IOException {
        MethodContext _bcornu_methode_context3 = new MethodContext(PDColorSpace.class, 91, 2748, 5628);
        try {
            CallChecker.varInit(patterns, "patterns", 91, 2748, 5628);
            CallChecker.varInit(colorSpaces, "colorSpaces", 91, 2748, 5628);
            CallChecker.varInit(colorSpace, "colorSpace", 91, 2748, 5628);
            PDColorSpace retval = CallChecker.varInit(null, "retval", 95, 3352, 3378);
            if (colorSpace instanceof COSObject) {
                if (CallChecker.beforeDeref(colorSpace, COSBase.class, 98, 3487, 3496)) {
                    colorSpace = CallChecker.beforeCalled(colorSpace, COSObject.class, 98, 3487, 3496);
                    retval = PDColorSpaceFactory.createColorSpace(CallChecker.isCalled(((COSObject) (colorSpace)), COSObject.class, 98, 3487, 3496).getObject(), colorSpaces);
                    CallChecker.varAssign(retval, "retval", 98, 3448, 3525);
                }
            }else
                if (colorSpace instanceof org.apache.pdfbox.cos.COSName) {
                    if (CallChecker.beforeDeref(colorSpace, COSBase.class, 101, 3638, 3647)) {
                        colorSpace = CallChecker.beforeCalled(colorSpace, org.apache.pdfbox.cos.COSName.class, 101, 3638, 3647);
                        retval = PDColorSpaceFactory.createColorSpace(CallChecker.isCalled(((org.apache.pdfbox.cos.COSName) (colorSpace)), org.apache.pdfbox.cos.COSName.class, 101, 3638, 3647).getName(), colorSpaces);
                        CallChecker.varAssign(retval, "retval", 101, 3601, 3674);
                    }
                }else
                    if (colorSpace instanceof org.apache.pdfbox.cos.COSArray) {
                        org.apache.pdfbox.cos.COSArray array = CallChecker.varInit(((org.apache.pdfbox.cos.COSArray) (colorSpace)), "array", 105, 3758, 3795);
                        String name = CallChecker.init(String.class);
                        if (CallChecker.beforeDeref(array, org.apache.pdfbox.cos.COSArray.class, 106, 3833, 3837)) {
                            array = CallChecker.beforeCalled(array, org.apache.pdfbox.cos.COSArray.class, 106, 3833, 3837);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(array, org.apache.pdfbox.cos.COSArray.class, 106, 3833, 3837).getObject(0), COSBase.class, 106, 3833, 3852)) {
                                array = CallChecker.beforeCalled(array, org.apache.pdfbox.cos.COSArray.class, 106, 3833, 3837);
                                name = CallChecker.isCalled(((org.apache.pdfbox.cos.COSName) (CallChecker.isCalled(array, org.apache.pdfbox.cos.COSArray.class, 106, 3833, 3837).getObject(0))), org.apache.pdfbox.cos.COSName.class, 106, 3833, 3852).getName();
                                CallChecker.varAssign(name, "name", 106, 3833, 3837);
                            }
                        }
                        if (CallChecker.beforeDeref(name, String.class, 107, 3882, 3885)) {
                            name = CallChecker.beforeCalled(name, String.class, 107, 3882, 3885);
                            if (CallChecker.isCalled(name, String.class, 107, 3882, 3885).equals(PDCalGray.NAME)) {
                                retval = new PDCalGray(array);
                                CallChecker.varAssign(retval, "retval", 109, 3944, 3975);
                            }else
                                if (CallChecker.beforeDeref(name, String.class, 111, 4012, 4015)) {
                                    name = CallChecker.beforeCalled(name, String.class, 111, 4012, 4015);
                                    if (CallChecker.isCalled(name, String.class, 111, 4012, 4015).equals(PDDeviceRGB.NAME)) {
                                        retval = PDDeviceRGB.INSTANCE;
                                        CallChecker.varAssign(retval, "retval", 113, 4076, 4105);
                                    }else
                                        if (CallChecker.beforeDeref(name, String.class, 115, 4142, 4145)) {
                                            name = CallChecker.beforeCalled(name, String.class, 115, 4142, 4145);
                                            if (CallChecker.isCalled(name, String.class, 115, 4142, 4145).equals(PDDeviceGray.NAME)) {
                                                retval = new PDDeviceGray();
                                                CallChecker.varAssign(retval, "retval", 117, 4207, 4234);
                                            }else
                                                if (CallChecker.beforeDeref(name, String.class, 119, 4271, 4274)) {
                                                    name = CallChecker.beforeCalled(name, String.class, 119, 4271, 4274);
                                                    if (CallChecker.isCalled(name, String.class, 119, 4271, 4274).equals(PDDeviceCMYK.NAME)) {
                                                        retval = PDDeviceCMYK.INSTANCE;
                                                        CallChecker.varAssign(retval, "retval", 121, 4336, 4366);
                                                    }else
                                                        if (CallChecker.beforeDeref(name, String.class, 123, 4403, 4406)) {
                                                            name = CallChecker.beforeCalled(name, String.class, 123, 4403, 4406);
                                                            if (CallChecker.isCalled(name, String.class, 123, 4403, 4406).equals(PDCalRGB.NAME)) {
                                                                retval = new PDCalRGB(array);
                                                                CallChecker.varAssign(retval, "retval", 125, 4464, 4494);
                                                            }else
                                                                if (CallChecker.beforeDeref(name, String.class, 127, 4531, 4534)) {
                                                                    name = CallChecker.beforeCalled(name, String.class, 127, 4531, 4534);
                                                                    if (CallChecker.isCalled(name, String.class, 127, 4531, 4534).equals(PDDeviceN.NAME)) {
                                                                        retval = new PDDeviceN(array);
                                                                        CallChecker.varAssign(retval, "retval", 129, 4593, 4624);
                                                                    }else
                                                                        if (CallChecker.beforeDeref(name, String.class, 131, 4661, 4664)) {
                                                                            if (CallChecker.beforeDeref(name, String.class, 132, 4713, 4716)) {
                                                                                name = CallChecker.beforeCalled(name, String.class, 131, 4661, 4664);
                                                                                name = CallChecker.beforeCalled(name, String.class, 132, 4713, 4716);
                                                                                if ((CallChecker.isCalled(name, String.class, 131, 4661, 4664).equals(PDIndexed.NAME)) || (CallChecker.isCalled(name, String.class, 132, 4713, 4716).equals(PDIndexed.ABBREVIATED_NAME))) {
                                                                                    retval = new PDIndexed(array);
                                                                                    CallChecker.varAssign(retval, "retval", 134, 4786, 4817);
                                                                                }else
                                                                                    if (CallChecker.beforeDeref(name, String.class, 136, 4854, 4857)) {
                                                                                        name = CallChecker.beforeCalled(name, String.class, 136, 4854, 4857);
                                                                                        if (CallChecker.isCalled(name, String.class, 136, 4854, 4857).equals(PDLab.NAME)) {
                                                                                            retval = new PDLab(array);
                                                                                            CallChecker.varAssign(retval, "retval", 138, 4912, 4939);
                                                                                        }else
                                                                                            if (CallChecker.beforeDeref(name, String.class, 140, 4976, 4979)) {
                                                                                                name = CallChecker.beforeCalled(name, String.class, 140, 4976, 4979);
                                                                                                if (CallChecker.isCalled(name, String.class, 140, 4976, 4979).equals(PDSeparation.NAME)) {
                                                                                                    retval = new PDSeparation(array);
                                                                                                    CallChecker.varAssign(retval, "retval", 142, 5041, 5075);
                                                                                                }else
                                                                                                    if (CallChecker.beforeDeref(name, String.class, 144, 5112, 5115)) {
                                                                                                        name = CallChecker.beforeCalled(name, String.class, 144, 5112, 5115);
                                                                                                        if (CallChecker.isCalled(name, String.class, 144, 5112, 5115).equals(PDICCBased.NAME)) {
                                                                                                            retval = new PDICCBased(array);
                                                                                                            CallChecker.varAssign(retval, "retval", 146, 5175, 5207);
                                                                                                        }else
                                                                                                            if (CallChecker.beforeDeref(name, String.class, 148, 5244, 5247)) {
                                                                                                                name = CallChecker.beforeCalled(name, String.class, 148, 5244, 5247);
                                                                                                                if (CallChecker.isCalled(name, String.class, 148, 5244, 5247).equals(PDPattern.NAME)) {
                                                                                                                    retval = new PDPattern(array);
                                                                                                                    CallChecker.varAssign(retval, "retval", 150, 5306, 5337);
                                                                                                                }else {
                                                                                                                    throw new IOException(("Unknown colorspace array type:" + name));
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
                                        
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else {
                        throw new IOException(("Unknown colorspace type:" + colorSpace));
                    }
                
            
            return retval;
        } catch (ForceReturn _bcornu_return_t) {
            return ((PDColorSpace) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3.methodEnd();
        }
    }

    public static PDColorSpace createColorSpace(String colorSpaceName) throws IOException {
        MethodContext _bcornu_methode_context4 = new MethodContext(PDColorSpace.class, 173, 5635, 6041);
        try {
            CallChecker.varInit(colorSpaceName, "colorSpaceName", 173, 5635, 6041);
            return PDColorSpaceFactory.createColorSpace(colorSpaceName, null);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PDColorSpace) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4.methodEnd();
        }
    }

    public static PDColorSpace createColorSpace(String colorSpaceName, Map<String, PDColorSpace> colorSpaces) throws IOException {
        MethodContext _bcornu_methode_context5 = new MethodContext(PDColorSpace.class, 188, 6048, 7673);
        try {
            CallChecker.varInit(colorSpaces, "colorSpaces", 188, 6048, 7673);
            CallChecker.varInit(colorSpaceName, "colorSpaceName", 188, 6048, 7673);
            PDColorSpace cs = CallChecker.varInit(null, "cs", 191, 6535, 6557);
            if (CallChecker.beforeDeref(colorSpaceName, String.class, 192, 6571, 6584)) {
                if (CallChecker.beforeDeref(colorSpaceName, String.class, 193, 6634, 6647)) {
                    colorSpaceName = CallChecker.beforeCalled(colorSpaceName, String.class, 192, 6571, 6584);
                    colorSpaceName = CallChecker.beforeCalled(colorSpaceName, String.class, 193, 6634, 6647);
                    if ((CallChecker.isCalled(colorSpaceName, String.class, 192, 6571, 6584).equals(PDDeviceCMYK.NAME)) || (CallChecker.isCalled(colorSpaceName, String.class, 193, 6634, 6647).equals(PDDeviceCMYK.ABBREVIATED_NAME))) {
                        cs = PDDeviceCMYK.INSTANCE;
                        CallChecker.varAssign(cs, "cs", 195, 6713, 6739);
                    }else
                        if (CallChecker.beforeDeref(colorSpaceName, String.class, 197, 6768, 6781)) {
                            if (CallChecker.beforeDeref(colorSpaceName, String.class, 198, 6830, 6843)) {
                                colorSpaceName = CallChecker.beforeCalled(colorSpaceName, String.class, 197, 6768, 6781);
                                colorSpaceName = CallChecker.beforeCalled(colorSpaceName, String.class, 198, 6830, 6843);
                                if ((CallChecker.isCalled(colorSpaceName, String.class, 197, 6768, 6781).equals(PDDeviceRGB.NAME)) || (CallChecker.isCalled(colorSpaceName, String.class, 198, 6830, 6843).equals(PDDeviceRGB.ABBREVIATED_NAME))) {
                                    cs = PDDeviceRGB.INSTANCE;
                                    CallChecker.varAssign(cs, "cs", 200, 6908, 6933);
                                }else
                                    if (CallChecker.beforeDeref(colorSpaceName, String.class, 202, 6962, 6975)) {
                                        if (CallChecker.beforeDeref(colorSpaceName, String.class, 203, 7025, 7038)) {
                                            colorSpaceName = CallChecker.beforeCalled(colorSpaceName, String.class, 202, 6962, 6975);
                                            colorSpaceName = CallChecker.beforeCalled(colorSpaceName, String.class, 203, 7025, 7038);
                                            if ((CallChecker.isCalled(colorSpaceName, String.class, 202, 6962, 6975).equals(PDDeviceGray.NAME)) || (CallChecker.isCalled(colorSpaceName, String.class, 203, 7025, 7038).equals(PDDeviceGray.ABBREVIATED_NAME))) {
                                                cs = new PDDeviceGray();
                                                CallChecker.varAssign(cs, "cs", 205, 7103, 7126);
                                            }else
                                                if ((colorSpaces != null) && ((colorSpaces.get(colorSpaceName)) != null)) {
                                                    cs = ((PDColorSpace) (colorSpaces.get(colorSpaceName)));
                                                    CallChecker.varAssign(cs, "cs", 209, 7244, 7296);
                                                }else
                                                    if (CallChecker.beforeDeref(colorSpaceName, String.class, 211, 7325, 7338)) {
                                                        colorSpaceName = CallChecker.beforeCalled(colorSpaceName, String.class, 211, 7325, 7338);
                                                        if (CallChecker.isCalled(colorSpaceName, String.class, 211, 7325, 7338).equals(PDLab.NAME)) {
                                                            cs = new PDLab();
                                                            CallChecker.varAssign(cs, "cs", 213, 7385, 7401);
                                                        }else
                                                            if (CallChecker.beforeDeref(colorSpaceName, String.class, 215, 7430, 7443)) {
                                                                colorSpaceName = CallChecker.beforeCalled(colorSpaceName, String.class, 215, 7430, 7443);
                                                                if (CallChecker.isCalled(colorSpaceName, String.class, 215, 7430, 7443).equals(PDPattern.NAME)) {
                                                                    cs = new PDPattern();
                                                                    CallChecker.varAssign(cs, "cs", 217, 7494, 7514);
                                                                }else {
                                                                    throw new IOException((("Error: Unknown colorspace '" + colorSpaceName) + "'"));
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
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            return cs;
        } catch (ForceReturn _bcornu_return_t) {
            return ((PDColorSpace) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5.methodEnd();
        }
    }

    public static PDColorSpace createColorSpace(PDDocument doc, ColorSpace cs) throws IOException {
        MethodContext _bcornu_methode_context6 = new MethodContext(PDColorSpace.class, 236, 7680, 9279);
        try {
            CallChecker.varInit(cs, "cs", 236, 7680, 9279);
            CallChecker.varInit(doc, "doc", 236, 7680, 9279);
            PDColorSpace retval = CallChecker.varInit(null, "retval", 238, 8093, 8119);
            if (CallChecker.beforeDeref(cs, ColorSpace.class, 239, 8133, 8134)) {
                cs = CallChecker.beforeCalled(cs, ColorSpace.class, 239, 8133, 8134);
                if (CallChecker.isCalled(cs, ColorSpace.class, 239, 8133, 8134).isCS_sRGB()) {
                    retval = PDDeviceRGB.INSTANCE;
                    CallChecker.varAssign(retval, "retval", 241, 8172, 8201);
                }else
                    if (cs instanceof java.awt.color.ICC_ColorSpace) {
                        java.awt.color.ICC_ColorSpace ics = CallChecker.varInit(((java.awt.color.ICC_ColorSpace) (cs)), "ics", 245, 8283, 8322);
                        PDICCBased pdCS = CallChecker.varInit(new PDICCBased(doc), "pdCS", 246, 8336, 8375);
                        retval = pdCS;
                        CallChecker.varAssign(retval, "retval", 247, 8389, 8402);
                        org.apache.pdfbox.cos.COSArray ranges = CallChecker.varInit(new org.apache.pdfbox.cos.COSArray(), "ranges", 248, 8416, 8448);
                        cs = CallChecker.beforeCalled(cs, ColorSpace.class, 249, 8478, 8479);
                        for (int i = 0; i < (CallChecker.isCalled(cs, ColorSpace.class, 249, 8478, 8479).getNumComponents()); i++) {
                            if (CallChecker.beforeDeref(ics, java.awt.color.ICC_ColorSpace.class, 251, 8563, 8565)) {
                                if (CallChecker.beforeDeref(ranges, org.apache.pdfbox.cos.COSArray.class, 251, 8537, 8542)) {
                                    ics = CallChecker.beforeCalled(ics, java.awt.color.ICC_ColorSpace.class, 251, 8563, 8565);
                                    ranges = CallChecker.beforeCalled(ranges, org.apache.pdfbox.cos.COSArray.class, 251, 8537, 8542);
                                    CallChecker.isCalled(ranges, org.apache.pdfbox.cos.COSArray.class, 251, 8537, 8542).add(new org.apache.pdfbox.cos.COSFloat(CallChecker.isCalled(ics, java.awt.color.ICC_ColorSpace.class, 251, 8563, 8565).getMinValue(i)));
                                }
                            }
                            if (CallChecker.beforeDeref(ics, java.awt.color.ICC_ColorSpace.class, 252, 8631, 8633)) {
                                if (CallChecker.beforeDeref(ranges, org.apache.pdfbox.cos.COSArray.class, 252, 8605, 8610)) {
                                    ics = CallChecker.beforeCalled(ics, java.awt.color.ICC_ColorSpace.class, 252, 8631, 8633);
                                    ranges = CallChecker.beforeCalled(ranges, org.apache.pdfbox.cos.COSArray.class, 252, 8605, 8610);
                                    CallChecker.isCalled(ranges, org.apache.pdfbox.cos.COSArray.class, 252, 8605, 8610).add(new org.apache.pdfbox.cos.COSFloat(CallChecker.isCalled(ics, java.awt.color.ICC_ColorSpace.class, 252, 8631, 8633).getMaxValue(i)));
                                }
                            }
                        }
                        org.apache.pdfbox.pdmodel.common.PDStream iccData = CallChecker.init(org.apache.pdfbox.pdmodel.common.PDStream.class);
                        if (CallChecker.beforeDeref(pdCS, PDICCBased.class, 254, 8702, 8705)) {
                            pdCS = CallChecker.beforeCalled(pdCS, PDICCBased.class, 254, 8702, 8705);
                            iccData = CallChecker.isCalled(pdCS, PDICCBased.class, 254, 8702, 8705).getPDStream();
                            CallChecker.varAssign(iccData, "iccData", 254, 8702, 8705);
                        }
                        java.io.OutputStream output = CallChecker.varInit(null, "output", 255, 8734, 8760);
                        fr.inria.spirals.npefix.resi.context.TryContext _bcornu_try_context_1 = new fr.inria.spirals.npefix.resi.context.TryContext(1, PDColorSpaceFactory.class);
                        try {
                            if (CallChecker.beforeDeref(iccData, org.apache.pdfbox.pdmodel.common.PDStream.class, 258, 8817, 8823)) {
                                iccData = CallChecker.beforeCalled(iccData, org.apache.pdfbox.pdmodel.common.PDStream.class, 258, 8817, 8823);
                                output = CallChecker.isCalled(iccData, org.apache.pdfbox.pdmodel.common.PDStream.class, 258, 8817, 8823).createOutputStream();
                                CallChecker.varAssign(output, "output", 258, 8808, 8845);
                            }
                            if (CallChecker.beforeDeref(ics, java.awt.color.ICC_ColorSpace.class, 259, 8877, 8879)) {
                                ics = CallChecker.beforeCalled(ics, java.awt.color.ICC_ColorSpace.class, 259, 8877, 8879);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(ics, java.awt.color.ICC_ColorSpace.class, 259, 8877, 8879).getProfile(), java.awt.color.ICC_Profile.class, 259, 8877, 8892)) {
                                    if (CallChecker.beforeDeref(output, java.io.OutputStream.class, 259, 8863, 8868)) {
                                        ics = CallChecker.beforeCalled(ics, java.awt.color.ICC_ColorSpace.class, 259, 8877, 8879);
                                        output = CallChecker.beforeCalled(output, java.io.OutputStream.class, 259, 8863, 8868);
                                        CallChecker.isCalled(output, java.io.OutputStream.class, 259, 8863, 8868).write(CallChecker.isCalled(CallChecker.isCalled(ics, java.awt.color.ICC_ColorSpace.class, 259, 8877, 8879).getProfile(), java.awt.color.ICC_Profile.class, 259, 8877, 8892).getData());
                                    }
                                }
                            }
                        } finally {
                            _bcornu_try_context_1.finallyStart(1);
                            if (output != null) {
                                output.close();
                            }
                        }
                        if (CallChecker.beforeDeref(cs, ColorSpace.class, 268, 9118, 9119)) {
                            if (CallChecker.beforeDeref(pdCS, PDICCBased.class, 268, 9090, 9093)) {
                                cs = CallChecker.beforeCalled(cs, ColorSpace.class, 268, 9118, 9119);
                                pdCS = CallChecker.beforeCalled(pdCS, PDICCBased.class, 268, 9090, 9093);
                                CallChecker.isCalled(pdCS, PDICCBased.class, 268, 9090, 9093).setNumberOfComponents(CallChecker.isCalled(cs, ColorSpace.class, 268, 9118, 9119).getNumComponents());
                            }
                        }
                    }else {
                        throw new IOException(("Not yet implemented:" + cs));
                    }
                
            }else
                throw new AbnormalExecutionError();
            
            return retval;
        } catch (ForceReturn _bcornu_return_t) {
            return ((PDColorSpace) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context6.methodEnd();
        }
    }
}

