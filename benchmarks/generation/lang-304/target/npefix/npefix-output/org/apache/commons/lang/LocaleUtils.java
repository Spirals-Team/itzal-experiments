package org.apache.commons.lang;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class LocaleUtils {
    private static final List cAvailableLocaleList;

    private static Set cAvailableLocaleSet;

    private static final Map cLanguagesByCountry = Collections.synchronizedMap(new HashMap());

    private static final Map cCountriesByLanguage = Collections.synchronizedMap(new HashMap());

    static {
        List list = CallChecker.varInit(Arrays.asList(Locale.getAvailableLocales()), "list", 51, 2014, 2069);
        cAvailableLocaleList = Collections.unmodifiableList(list);
        CallChecker.varAssign(cAvailableLocaleList, "LocaleUtils.cAvailableLocaleList", 52, 2079, 2136);
    }

    public LocaleUtils() {
        super();
        ConstructorContext _bcornu_methode_context1 = new ConstructorContext(LocaleUtils.class, 62, 2149, 2512);
        try {
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    public static Locale toLocale(String str) {
        MethodContext _bcornu_methode_context1 = new MethodContext(Locale.class, 94, 2519, 5078);
        try {
            CallChecker.varInit(str, "str", 94, 2519, 5078);
            CallChecker.varInit(cCountriesByLanguage, "org.apache.commons.lang.LocaleUtils.cCountriesByLanguage", 94, 2519, 5078);
            CallChecker.varInit(cLanguagesByCountry, "org.apache.commons.lang.LocaleUtils.cLanguagesByCountry", 94, 2519, 5078);
            CallChecker.varInit(LocaleUtils.cAvailableLocaleSet, "org.apache.commons.lang.LocaleUtils.cAvailableLocaleSet", 94, 2519, 5078);
            CallChecker.varInit(cAvailableLocaleList, "org.apache.commons.lang.LocaleUtils.cAvailableLocaleList", 94, 2519, 5078);
            if (str == null) {
                return null;
            }
            int len = CallChecker.varInit(((int) (str.length())), "len", 98, 3830, 3852);
            if (((len != 2) && (len != 5)) && (len < 7)) {
                throw new IllegalArgumentException(("Invalid locale format: " + str));
            }
            char ch0 = CallChecker.varInit(((char) (str.charAt(0))), "ch0", 102, 4000, 4024);
            char ch1 = CallChecker.varInit(((char) (str.charAt(1))), "ch1", 103, 4034, 4058);
            if ((((ch0 < 'a') || (ch0 > 'z')) || (ch1 < 'a')) || (ch1 > 'z')) {
                throw new IllegalArgumentException(("Invalid locale format: " + str));
            }
            if (len == 2) {
                return new Locale(str, "");
            }else {
                if ((str.charAt(2)) != '_') {
                    throw new IllegalArgumentException(("Invalid locale format: " + str));
                }
                char ch3 = CallChecker.varInit(((char) (str.charAt(3))), "ch3", 113, 4447, 4471);
                char ch4 = CallChecker.varInit(((char) (str.charAt(4))), "ch4", 114, 4485, 4509);
                if ((((ch3 < 'A') || (ch3 > 'Z')) || (ch4 < 'A')) || (ch4 > 'Z')) {
                    throw new IllegalArgumentException(("Invalid locale format: " + str));
                }
                if (len == 5) {
                    return new Locale(str.substring(0, 2), str.substring(3, 5));
                }else {
                    if ((str.charAt(5)) != '_') {
                        throw new IllegalArgumentException(("Invalid locale format: " + str));
                    }
                    return new Locale(str.substring(0, 2), str.substring(3, 5), str.substring(6));
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Locale) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    public static List localeLookupList(Locale locale) {
        MethodContext _bcornu_methode_context2 = new MethodContext(List.class, 142, 5085, 5675);
        try {
            CallChecker.varInit(locale, "locale", 142, 5085, 5675);
            CallChecker.varInit(cCountriesByLanguage, "org.apache.commons.lang.LocaleUtils.cCountriesByLanguage", 142, 5085, 5675);
            CallChecker.varInit(cLanguagesByCountry, "org.apache.commons.lang.LocaleUtils.cLanguagesByCountry", 142, 5085, 5675);
            CallChecker.varInit(LocaleUtils.cAvailableLocaleSet, "org.apache.commons.lang.LocaleUtils.cAvailableLocaleSet", 142, 5085, 5675);
            CallChecker.varInit(cAvailableLocaleList, "org.apache.commons.lang.LocaleUtils.cAvailableLocaleList", 142, 5085, 5675);
            return LocaleUtils.localeLookupList(locale, locale);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2.methodEnd();
        }
    }

    public static List localeLookupList(Locale locale, Locale defaultLocale) {
        MethodContext _bcornu_methode_context3 = new MethodContext(List.class, 164, 5682, 7136);
        try {
            CallChecker.varInit(defaultLocale, "defaultLocale", 164, 5682, 7136);
            CallChecker.varInit(locale, "locale", 164, 5682, 7136);
            CallChecker.varInit(cCountriesByLanguage, "org.apache.commons.lang.LocaleUtils.cCountriesByLanguage", 164, 5682, 7136);
            CallChecker.varInit(cLanguagesByCountry, "org.apache.commons.lang.LocaleUtils.cLanguagesByCountry", 164, 5682, 7136);
            CallChecker.varInit(LocaleUtils.cAvailableLocaleSet, "org.apache.commons.lang.LocaleUtils.cAvailableLocaleSet", 164, 5682, 7136);
            CallChecker.varInit(cAvailableLocaleList, "org.apache.commons.lang.LocaleUtils.cAvailableLocaleList", 164, 5682, 7136);
            List list = CallChecker.varInit(new ArrayList(4), "list", 165, 6592, 6620);
            if (locale != null) {
                if (CallChecker.beforeDeref(list, List.class, 167, 6664, 6667)) {
                    list = CallChecker.beforeCalled(list, List.class, 167, 6664, 6667);
                    CallChecker.isCalled(list, List.class, 167, 6664, 6667).add(locale);
                }
                locale = CallChecker.beforeCalled(locale, Locale.class, 168, 6698, 6703);
                if (CallChecker.beforeDeref(CallChecker.isCalled(locale, Locale.class, 168, 6698, 6703).getVariant(), String.class, 168, 6698, 6716)) {
                    if ((CallChecker.isCalled(locale.getVariant(), String.class, 168, 6698, 6716).length()) > 0) {
                        if (CallChecker.beforeDeref(list, List.class, 169, 6750, 6753)) {
                            list = CallChecker.beforeCalled(list, List.class, 169, 6750, 6753);
                            CallChecker.isCalled(list, List.class, 169, 6750, 6753).add(new Locale(locale.getLanguage(), locale.getCountry()));
                        }
                    }
                }
                locale = CallChecker.beforeCalled(locale, Locale.class, 171, 6845, 6850);
                if (CallChecker.beforeDeref(CallChecker.isCalled(locale, Locale.class, 171, 6845, 6850).getCountry(), String.class, 171, 6845, 6863)) {
                    if ((CallChecker.isCalled(locale.getCountry(), String.class, 171, 6845, 6863).length()) > 0) {
                        if (CallChecker.beforeDeref(list, List.class, 172, 6897, 6900)) {
                            list = CallChecker.beforeCalled(list, List.class, 172, 6897, 6900);
                            CallChecker.isCalled(list, List.class, 172, 6897, 6900).add(new Locale(locale.getLanguage(), ""));
                        }
                    }
                }
                if (CallChecker.beforeDeref(list, List.class, 174, 6975, 6978)) {
                    list = CallChecker.beforeCalled(list, List.class, 174, 6975, 6978);
                    if ((CallChecker.isCalled(list, List.class, 174, 6975, 6978).contains(defaultLocale)) == false) {
                        if (CallChecker.beforeDeref(list, List.class, 175, 7032, 7035)) {
                            list = CallChecker.beforeCalled(list, List.class, 175, 7032, 7035);
                            CallChecker.isCalled(list, List.class, 175, 7032, 7035).add(defaultLocale);
                        }
                    }
                }
            }
            return Collections.unmodifiableList(list);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3.methodEnd();
        }
    }

    public static List availableLocaleList() {
        MethodContext _bcornu_methode_context4 = new MethodContext(List.class, 191, 7143, 7645);
        try {
            CallChecker.varInit(cCountriesByLanguage, "org.apache.commons.lang.LocaleUtils.cCountriesByLanguage", 191, 7143, 7645);
            CallChecker.varInit(cLanguagesByCountry, "org.apache.commons.lang.LocaleUtils.cLanguagesByCountry", 191, 7143, 7645);
            CallChecker.varInit(LocaleUtils.cAvailableLocaleSet, "org.apache.commons.lang.LocaleUtils.cAvailableLocaleSet", 191, 7143, 7645);
            CallChecker.varInit(cAvailableLocaleList, "org.apache.commons.lang.LocaleUtils.cAvailableLocaleList", 191, 7143, 7645);
            return LocaleUtils.cAvailableLocaleList;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4.methodEnd();
        }
    }

    public static Set availableLocaleSet() {
        MethodContext _bcornu_methode_context5 = new MethodContext(Set.class, 205, 7652, 8354);
        try {
            CallChecker.varInit(cCountriesByLanguage, "org.apache.commons.lang.LocaleUtils.cCountriesByLanguage", 205, 7652, 8354);
            CallChecker.varInit(cLanguagesByCountry, "org.apache.commons.lang.LocaleUtils.cLanguagesByCountry", 205, 7652, 8354);
            CallChecker.varInit(LocaleUtils.cAvailableLocaleSet, "org.apache.commons.lang.LocaleUtils.cAvailableLocaleSet", 205, 7652, 8354);
            CallChecker.varInit(cAvailableLocaleList, "org.apache.commons.lang.LocaleUtils.cAvailableLocaleList", 205, 7652, 8354);
            Set set = CallChecker.varInit(LocaleUtils.cAvailableLocaleSet, "set", 206, 8117, 8146);
            if (set == null) {
                set = new HashSet(LocaleUtils.availableLocaleList());
                CallChecker.varAssign(set, "set", 208, 8187, 8227);
                set = Collections.unmodifiableSet(set);
                CallChecker.varAssign(set, "set", 209, 8241, 8279);
                LocaleUtils.cAvailableLocaleSet = set;
                CallChecker.varAssign(LocaleUtils.cAvailableLocaleSet, "LocaleUtils.cAvailableLocaleSet", 210, 8293, 8318);
            }
            return set;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5.methodEnd();
        }
    }

    public static boolean isAvailableLocale(Locale locale) {
        MethodContext _bcornu_methode_context6 = new MethodContext(boolean.class, 222, 8361, 8777);
        try {
            CallChecker.varInit(locale, "locale", 222, 8361, 8777);
            CallChecker.varInit(cCountriesByLanguage, "org.apache.commons.lang.LocaleUtils.cCountriesByLanguage", 222, 8361, 8777);
            CallChecker.varInit(cLanguagesByCountry, "org.apache.commons.lang.LocaleUtils.cLanguagesByCountry", 222, 8361, 8777);
            CallChecker.varInit(LocaleUtils.cAvailableLocaleSet, "org.apache.commons.lang.LocaleUtils.cAvailableLocaleSet", 222, 8361, 8777);
            CallChecker.varInit(cAvailableLocaleList, "org.apache.commons.lang.LocaleUtils.cAvailableLocaleList", 222, 8361, 8777);
            if (CallChecker.beforeDeref(LocaleUtils.cAvailableLocaleSet, Set.class, 223, 8735, 8753)) {
                LocaleUtils.cAvailableLocaleSet = CallChecker.beforeCalled(LocaleUtils.cAvailableLocaleSet, Set.class, 223, 8735, 8753);
                return CallChecker.isCalled(LocaleUtils.cAvailableLocaleSet, Set.class, 223, 8735, 8753).contains(locale);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context6.methodEnd();
        }
    }

    public static List languagesByCountry(String countryCode) {
        MethodContext _bcornu_methode_context7 = new MethodContext(List.class, 236, 8784, 10131);
        try {
            CallChecker.varInit(countryCode, "countryCode", 236, 8784, 10131);
            CallChecker.varInit(cCountriesByLanguage, "org.apache.commons.lang.LocaleUtils.cCountriesByLanguage", 236, 8784, 10131);
            CallChecker.varInit(cLanguagesByCountry, "org.apache.commons.lang.LocaleUtils.cLanguagesByCountry", 236, 8784, 10131);
            CallChecker.varInit(LocaleUtils.cAvailableLocaleSet, "org.apache.commons.lang.LocaleUtils.cAvailableLocaleSet", 236, 8784, 10131);
            CallChecker.varInit(cAvailableLocaleList, "org.apache.commons.lang.LocaleUtils.cAvailableLocaleList", 236, 8784, 10131);
            List langs = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(LocaleUtils.cLanguagesByCountry, Map.class, 237, 9340, 9358)) {
                langs = ((List) (CallChecker.isCalled(LocaleUtils.cLanguagesByCountry, Map.class, 237, 9340, 9358).get(countryCode)));
                CallChecker.varAssign(langs, "langs", 237, 9340, 9358);
            }
            if (langs == null) {
                if (countryCode != null) {
                    langs = new ArrayList();
                    CallChecker.varAssign(langs, "langs", 240, 9471, 9494);
                    List locales = CallChecker.varInit(LocaleUtils.availableLocaleList(), "locales", 241, 9512, 9548);
                    locales = CallChecker.beforeCalled(locales, List.class, 242, 9586, 9592);
                    for (int i = 0; i < (CallChecker.isCalled(locales, List.class, 242, 9586, 9592).size()); i++) {
                        Locale locale = CallChecker.init(Locale.class);
                        if (CallChecker.beforeDeref(locales, List.class, 243, 9654, 9660)) {
                            locales = CallChecker.beforeCalled(locales, List.class, 243, 9654, 9660);
                            locale = ((Locale) (CallChecker.isCalled(locales, List.class, 243, 9654, 9660).get(i)));
                            CallChecker.varAssign(locale, "locale", 243, 9654, 9660);
                        }
                        if (CallChecker.beforeDeref(locale, Locale.class, 244, 9713, 9718)) {
                            if (CallChecker.beforeDeref(locale, Locale.class, 245, 9765, 9770)) {
                                locale = CallChecker.beforeCalled(locale, Locale.class, 245, 9765, 9770);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(locale, Locale.class, 245, 9765, 9770).getVariant(), String.class, 245, 9765, 9783)) {
                                    locale = CallChecker.beforeCalled(locale, Locale.class, 244, 9713, 9718);
                                    locale = CallChecker.beforeCalled(locale, Locale.class, 245, 9765, 9770);
                                    if ((countryCode.equals(CallChecker.isCalled(locale, Locale.class, 244, 9713, 9718).getCountry())) && ((CallChecker.isCalled(CallChecker.isCalled(locale, Locale.class, 245, 9765, 9770).getVariant(), String.class, 245, 9765, 9783).length()) == 0)) {
                                        if (CallChecker.beforeDeref(langs, List.class, 246, 9826, 9830)) {
                                            langs = CallChecker.beforeCalled(langs, List.class, 246, 9826, 9830);
                                            CallChecker.isCalled(langs, List.class, 246, 9826, 9830).add(locale);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    langs = Collections.unmodifiableList(langs);
                    CallChecker.varAssign(langs, "langs", 249, 9901, 9944);
                }else {
                    langs = Collections.EMPTY_LIST;
                    CallChecker.varAssign(langs, "langs", 251, 9983, 10013);
                }
                if (CallChecker.beforeDeref(LocaleUtils.cLanguagesByCountry, Map.class, 253, 10041, 10059)) {
                    CallChecker.isCalled(LocaleUtils.cLanguagesByCountry, Map.class, 253, 10041, 10059).put(countryCode, langs);
                }
            }
            return langs;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context7.methodEnd();
        }
    }

    public static List countriesByLanguage(String languageCode) {
        MethodContext _bcornu_methode_context8 = new MethodContext(List.class, 268, 10138, 11601);
        try {
            CallChecker.varInit(languageCode, "languageCode", 268, 10138, 11601);
            CallChecker.varInit(cCountriesByLanguage, "org.apache.commons.lang.LocaleUtils.cCountriesByLanguage", 268, 10138, 11601);
            CallChecker.varInit(cLanguagesByCountry, "org.apache.commons.lang.LocaleUtils.cLanguagesByCountry", 268, 10138, 11601);
            CallChecker.varInit(LocaleUtils.cAvailableLocaleSet, "org.apache.commons.lang.LocaleUtils.cAvailableLocaleSet", 268, 10138, 11601);
            CallChecker.varInit(cAvailableLocaleList, "org.apache.commons.lang.LocaleUtils.cAvailableLocaleList", 268, 10138, 11601);
            List countries = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(LocaleUtils.cCountriesByLanguage, Map.class, 269, 10706, 10725)) {
                countries = ((List) (CallChecker.isCalled(LocaleUtils.cCountriesByLanguage, Map.class, 269, 10706, 10725).get(languageCode)));
                CallChecker.varAssign(countries, "countries", 269, 10706, 10725);
            }
            if (countries == null) {
                if (languageCode != null) {
                    countries = new ArrayList();
                    CallChecker.varAssign(countries, "countries", 272, 10844, 10871);
                    List locales = CallChecker.varInit(LocaleUtils.availableLocaleList(), "locales", 273, 10889, 10925);
                    locales = CallChecker.beforeCalled(locales, List.class, 274, 10963, 10969);
                    for (int i = 0; i < (CallChecker.isCalled(locales, List.class, 274, 10963, 10969).size()); i++) {
                        Locale locale = CallChecker.init(Locale.class);
                        if (CallChecker.beforeDeref(locales, List.class, 275, 11031, 11037)) {
                            locales = CallChecker.beforeCalled(locales, List.class, 275, 11031, 11037);
                            locale = ((Locale) (CallChecker.isCalled(locales, List.class, 275, 11031, 11037).get(i)));
                            CallChecker.varAssign(locale, "locale", 275, 11031, 11037);
                        }
                        if (CallChecker.beforeDeref(locale, Locale.class, 276, 11091, 11096)) {
                            if (CallChecker.beforeDeref(locale, Locale.class, 277, 11144, 11149)) {
                                locale = CallChecker.beforeCalled(locale, Locale.class, 277, 11144, 11149);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(locale, Locale.class, 277, 11144, 11149).getCountry(), String.class, 277, 11144, 11162)) {
                                    if (CallChecker.beforeDeref(locale, Locale.class, 278, 11209, 11214)) {
                                        locale = CallChecker.beforeCalled(locale, Locale.class, 278, 11209, 11214);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(locale, Locale.class, 278, 11209, 11214).getVariant(), String.class, 278, 11209, 11227)) {
                                            locale = CallChecker.beforeCalled(locale, Locale.class, 276, 11091, 11096);
                                            locale = CallChecker.beforeCalled(locale, Locale.class, 277, 11144, 11149);
                                            locale = CallChecker.beforeCalled(locale, Locale.class, 278, 11209, 11214);
                                            if (((languageCode.equals(CallChecker.isCalled(locale, Locale.class, 276, 11091, 11096).getLanguage())) && ((CallChecker.isCalled(CallChecker.isCalled(locale, Locale.class, 277, 11144, 11149).getCountry(), String.class, 277, 11144, 11162).length()) != 0)) && ((CallChecker.isCalled(CallChecker.isCalled(locale, Locale.class, 278, 11209, 11214).getVariant(), String.class, 278, 11209, 11227).length()) == 0)) {
                                                if (CallChecker.beforeDeref(countries, List.class, 279, 11270, 11278)) {
                                                    countries = CallChecker.beforeCalled(countries, List.class, 279, 11270, 11278);
                                                    CallChecker.isCalled(countries, List.class, 279, 11270, 11278).add(locale);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    countries = Collections.unmodifiableList(countries);
                    CallChecker.varAssign(countries, "countries", 282, 11349, 11400);
                }else {
                    countries = Collections.EMPTY_LIST;
                    CallChecker.varAssign(countries, "countries", 284, 11439, 11473);
                }
                if (CallChecker.beforeDeref(LocaleUtils.cCountriesByLanguage, Map.class, 286, 11501, 11520)) {
                    CallChecker.isCalled(LocaleUtils.cCountriesByLanguage, Map.class, 286, 11501, 11520).put(languageCode, countries);
                }
            }
            return countries;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context8.methodEnd();
        }
    }
}

