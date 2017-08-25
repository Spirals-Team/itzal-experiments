package org.apache.felix.framework.util.manifestparser;

import org.apache.felix.framework.util.VersionRange;
import org.osgi.framework.Version;
import fr.inria.spirals.npefix.resi.context.TryContext;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.regex.Pattern;
import org.apache.felix.framework.util.FelixConstants;
import java.util.Dictionary;
import org.osgi.framework.Constants;
import java.util.Collections;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.osgi.framework.BundleException;
import java.util.Arrays;
import java.util.ArrayList;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.osgi.framework.Filter;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.osgi.framework.FrameworkUtil;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import org.apache.felix.framework.Logger;
import java.util.Map;
import java.util.regex.Matcher;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class NativeLibraryClause {
    private static final String OS_AIX = "aix";

    private static final String OS_DIGITALUNIX = "digitalunix";

    private static final String OS_EPOC = "epoc32";

    private static final String OS_HPUX = "hpux";

    private static final String OS_IRIX = "irix";

    private static final String OS_LINUX = "linux";

    private static final String OS_MACOS = "macos";

    private static final String OS_MACOSX = "macosx";

    private static final String OS_NETBSD = "netbsd";

    private static final String OS_NETWARE = "netware";

    private static final String OS_OPENBSD = "openbsd";

    private static final String OS_OS2 = "os2";

    private static final String OS_QNX = "qnx";

    private static final String OS_SOLARIS = "solaris";

    private static final String OS_SUNOS = "sunos";

    private static final String OS_VXWORKS = "vxworks";

    private static final String OS_WINDOWS_2000 = "windows2000";

    private static final String OS_WINDOWS_2003 = "windows2003";

    private static final String OS_WINDOWS_7 = "windows7";

    private static final String OS_WINDOWS_8 = "windows8";

    private static final String OS_WINDOWS_9 = "windows9";

    private static final String OS_WINDOWS_95 = "windows95";

    private static final String OS_WINDOWS_98 = "windows98";

    private static final String OS_WINDOWS_CE = "windowsce";

    private static final String OS_WINDOWS_NT = "windowsnt";

    private static final String OS_WINDOWS_SERVER_2008 = "windowsserver2008";

    private static final String OS_WINDOWS_SERVER_2012 = "windowsserver2012";

    private static final String OS_WINDOWS_VISTA = "windowsvista";

    private static final String OS_WINDOWS_XP = "windowsxp";

    private static final String OS_WIN_32 = "win32";

    private static final String PROC_X86_64 = "x86-64";

    private static final String PROC_X86 = "x86";

    private static final String PROC_68K = "68k";

    private static final String PROC_ARM_LE = "arm_le";

    private static final String PROC_ARM_BE = "arm_be";

    private static final String PROC_ARM = "arm";

    private static final String PROC_ALPHA = "alpha";

    private static final String PROC_IGNITE = "ignite";

    private static final String PROC_MIPS = "mips";

    private static final String PROC_PARISC = "parisc";

    private static final String PROC_POWER_PC = "powerpc";

    private static final String PROC_SPARC = "sparc";

    private static final Map<String, List<String>> OS_ALIASES = new HashMap<String, List<String>>();

    private static final Map<String, List<String>> PROC_ALIASES = new HashMap<String, List<String>>();

    private final String[] m_libraryEntries;

    private final String[] m_osnames;

    private final String[] m_processors;

    private final String[] m_osversions;

    private final String[] m_languages;

    private final String m_selectionFilter;

    public NativeLibraryClause(String[] libraryEntries, String[] osnames, String[] processors, String[] osversions, String[] languages, String selectionFilter) {
        MethodContext _bcornu_methode_context174 = new MethodContext(null);
        try {
            m_libraryEntries = libraryEntries;
            CallChecker.varAssign(this.m_libraryEntries, "this.m_libraryEntries", 105, 4616, 4649);
            m_osnames = osnames;
            CallChecker.varAssign(this.m_osnames, "this.m_osnames", 106, 4659, 4678);
            m_processors = processors;
            CallChecker.varAssign(this.m_processors, "this.m_processors", 107, 4688, 4713);
            m_osversions = osversions;
            CallChecker.varAssign(this.m_osversions, "this.m_osversions", 108, 4723, 4748);
            m_languages = languages;
            CallChecker.varAssign(this.m_languages, "this.m_languages", 109, 4758, 4781);
            m_selectionFilter = selectionFilter;
            CallChecker.varAssign(this.m_selectionFilter, "this.m_selectionFilter", 110, 4791, 4826);
        } finally {
            _bcornu_methode_context174.methodEnd();
        }
    }

    public NativeLibraryClause(NativeLibraryClause library) {
        this(CallChecker.isCalled(library, NativeLibraryClause.class, 115, 4914, 4920).m_libraryEntries, CallChecker.isCalled(library, NativeLibraryClause.class, 115, 4940, 4946).m_osnames, CallChecker.isCalled(library, NativeLibraryClause.class, 115, 4959, 4965).m_osversions, CallChecker.isCalled(library, NativeLibraryClause.class, 116, 4993, 4999).m_processors, CallChecker.isCalled(library, NativeLibraryClause.class, 116, 5015, 5021).m_languages, CallChecker.isCalled(library, NativeLibraryClause.class, 117, 5048, 5054).m_selectionFilter);
        MethodContext _bcornu_methode_context175 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context175.methodEnd();
        }
    }

    public static synchronized void initializeNativeAliases(Map configMap) {
        MethodContext _bcornu_methode_context1756 = new MethodContext(void.class);
        try {
            CallChecker.varInit(configMap, "configMap", 125, 5087, 5644);
            CallChecker.varInit(PROC_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALIASES", 125, 5087, 5644);
            CallChecker.varInit(OS_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_ALIASES", 125, 5087, 5644);
            CallChecker.varInit(PROC_SPARC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_SPARC", 125, 5087, 5644);
            CallChecker.varInit(PROC_POWER_PC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_POWER_PC", 125, 5087, 5644);
            CallChecker.varInit(PROC_PARISC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_PARISC", 125, 5087, 5644);
            CallChecker.varInit(PROC_MIPS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_MIPS", 125, 5087, 5644);
            CallChecker.varInit(PROC_IGNITE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_IGNITE", 125, 5087, 5644);
            CallChecker.varInit(PROC_ALPHA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALPHA", 125, 5087, 5644);
            CallChecker.varInit(PROC_ARM, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM", 125, 5087, 5644);
            CallChecker.varInit(PROC_ARM_BE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_BE", 125, 5087, 5644);
            CallChecker.varInit(PROC_ARM_LE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_LE", 125, 5087, 5644);
            CallChecker.varInit(PROC_68K, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_68K", 125, 5087, 5644);
            CallChecker.varInit(PROC_X86, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86", 125, 5087, 5644);
            CallChecker.varInit(PROC_X86_64, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86_64", 125, 5087, 5644);
            CallChecker.varInit(OS_WIN_32, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WIN_32", 125, 5087, 5644);
            CallChecker.varInit(OS_WINDOWS_XP, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_XP", 125, 5087, 5644);
            CallChecker.varInit(OS_WINDOWS_VISTA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_VISTA", 125, 5087, 5644);
            CallChecker.varInit(OS_WINDOWS_SERVER_2012, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2012", 125, 5087, 5644);
            CallChecker.varInit(OS_WINDOWS_SERVER_2008, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2008", 125, 5087, 5644);
            CallChecker.varInit(OS_WINDOWS_NT, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_NT", 125, 5087, 5644);
            CallChecker.varInit(OS_WINDOWS_CE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_CE", 125, 5087, 5644);
            CallChecker.varInit(OS_WINDOWS_98, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_98", 125, 5087, 5644);
            CallChecker.varInit(OS_WINDOWS_95, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_95", 125, 5087, 5644);
            CallChecker.varInit(OS_WINDOWS_9, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_9", 125, 5087, 5644);
            CallChecker.varInit(OS_WINDOWS_8, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_8", 125, 5087, 5644);
            CallChecker.varInit(OS_WINDOWS_7, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_7", 125, 5087, 5644);
            CallChecker.varInit(OS_WINDOWS_2003, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2003", 125, 5087, 5644);
            CallChecker.varInit(OS_WINDOWS_2000, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2000", 125, 5087, 5644);
            CallChecker.varInit(OS_VXWORKS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_VXWORKS", 125, 5087, 5644);
            CallChecker.varInit(OS_SUNOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SUNOS", 125, 5087, 5644);
            CallChecker.varInit(OS_SOLARIS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SOLARIS", 125, 5087, 5644);
            CallChecker.varInit(OS_QNX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_QNX", 125, 5087, 5644);
            CallChecker.varInit(OS_OS2, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OS2", 125, 5087, 5644);
            CallChecker.varInit(OS_OPENBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OPENBSD", 125, 5087, 5644);
            CallChecker.varInit(OS_NETWARE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETWARE", 125, 5087, 5644);
            CallChecker.varInit(OS_NETBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETBSD", 125, 5087, 5644);
            CallChecker.varInit(OS_MACOSX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOSX", 125, 5087, 5644);
            CallChecker.varInit(OS_MACOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOS", 125, 5087, 5644);
            CallChecker.varInit(OS_LINUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_LINUX", 125, 5087, 5644);
            CallChecker.varInit(OS_IRIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_IRIX", 125, 5087, 5644);
            CallChecker.varInit(OS_HPUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_HPUX", 125, 5087, 5644);
            CallChecker.varInit(OS_EPOC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_EPOC", 125, 5087, 5644);
            CallChecker.varInit(OS_DIGITALUNIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_DIGITALUNIX", 125, 5087, 5644);
            CallChecker.varInit(OS_AIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_AIX", 125, 5087, 5644);
            Map<String, String> osNameKeyMap = CallChecker.varInit(NativeLibraryClause.getAllKeysWithPrefix(FelixConstants.NATIVE_OS_NAME_ALIAS_PREFIX, configMap), "osNameKeyMap", 127, 5288, 5398);
            Map<String, String> processorKeyMap = CallChecker.varInit(NativeLibraryClause.getAllKeysWithPrefix(FelixConstants.NATIVE_PROC_NAME_ALIAS_PREFIX, configMap), "processorKeyMap", 129, 5409, 5524);
            NativeLibraryClause.parseNativeAliases(osNameKeyMap, NativeLibraryClause.OS_ALIASES);
            NativeLibraryClause.parseNativeAliases(processorKeyMap, NativeLibraryClause.PROC_ALIASES);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1756.methodEnd();
        }
    }

    private static void parseNativeAliases(Map<String, String> aliasStringMap, Map<String, List<String>> aliasMap) {
        MethodContext _bcornu_methode_context1757 = new MethodContext(void.class);
        try {
            CallChecker.varInit(aliasMap, "aliasMap", 135, 5651, 7768);
            CallChecker.varInit(aliasStringMap, "aliasStringMap", 135, 5651, 7768);
            CallChecker.varInit(PROC_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALIASES", 135, 5651, 7768);
            CallChecker.varInit(OS_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_ALIASES", 135, 5651, 7768);
            CallChecker.varInit(PROC_SPARC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_SPARC", 135, 5651, 7768);
            CallChecker.varInit(PROC_POWER_PC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_POWER_PC", 135, 5651, 7768);
            CallChecker.varInit(PROC_PARISC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_PARISC", 135, 5651, 7768);
            CallChecker.varInit(PROC_MIPS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_MIPS", 135, 5651, 7768);
            CallChecker.varInit(PROC_IGNITE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_IGNITE", 135, 5651, 7768);
            CallChecker.varInit(PROC_ALPHA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALPHA", 135, 5651, 7768);
            CallChecker.varInit(PROC_ARM, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM", 135, 5651, 7768);
            CallChecker.varInit(PROC_ARM_BE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_BE", 135, 5651, 7768);
            CallChecker.varInit(PROC_ARM_LE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_LE", 135, 5651, 7768);
            CallChecker.varInit(PROC_68K, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_68K", 135, 5651, 7768);
            CallChecker.varInit(PROC_X86, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86", 135, 5651, 7768);
            CallChecker.varInit(PROC_X86_64, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86_64", 135, 5651, 7768);
            CallChecker.varInit(OS_WIN_32, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WIN_32", 135, 5651, 7768);
            CallChecker.varInit(OS_WINDOWS_XP, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_XP", 135, 5651, 7768);
            CallChecker.varInit(OS_WINDOWS_VISTA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_VISTA", 135, 5651, 7768);
            CallChecker.varInit(OS_WINDOWS_SERVER_2012, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2012", 135, 5651, 7768);
            CallChecker.varInit(OS_WINDOWS_SERVER_2008, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2008", 135, 5651, 7768);
            CallChecker.varInit(OS_WINDOWS_NT, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_NT", 135, 5651, 7768);
            CallChecker.varInit(OS_WINDOWS_CE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_CE", 135, 5651, 7768);
            CallChecker.varInit(OS_WINDOWS_98, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_98", 135, 5651, 7768);
            CallChecker.varInit(OS_WINDOWS_95, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_95", 135, 5651, 7768);
            CallChecker.varInit(OS_WINDOWS_9, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_9", 135, 5651, 7768);
            CallChecker.varInit(OS_WINDOWS_8, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_8", 135, 5651, 7768);
            CallChecker.varInit(OS_WINDOWS_7, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_7", 135, 5651, 7768);
            CallChecker.varInit(OS_WINDOWS_2003, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2003", 135, 5651, 7768);
            CallChecker.varInit(OS_WINDOWS_2000, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2000", 135, 5651, 7768);
            CallChecker.varInit(OS_VXWORKS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_VXWORKS", 135, 5651, 7768);
            CallChecker.varInit(OS_SUNOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SUNOS", 135, 5651, 7768);
            CallChecker.varInit(OS_SOLARIS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SOLARIS", 135, 5651, 7768);
            CallChecker.varInit(OS_QNX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_QNX", 135, 5651, 7768);
            CallChecker.varInit(OS_OS2, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OS2", 135, 5651, 7768);
            CallChecker.varInit(OS_OPENBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OPENBSD", 135, 5651, 7768);
            CallChecker.varInit(OS_NETWARE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETWARE", 135, 5651, 7768);
            CallChecker.varInit(OS_NETBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETBSD", 135, 5651, 7768);
            CallChecker.varInit(OS_MACOSX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOSX", 135, 5651, 7768);
            CallChecker.varInit(OS_MACOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOS", 135, 5651, 7768);
            CallChecker.varInit(OS_LINUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_LINUX", 135, 5651, 7768);
            CallChecker.varInit(OS_IRIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_IRIX", 135, 5651, 7768);
            CallChecker.varInit(OS_HPUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_HPUX", 135, 5651, 7768);
            CallChecker.varInit(OS_EPOC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_EPOC", 135, 5651, 7768);
            CallChecker.varInit(OS_DIGITALUNIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_DIGITALUNIX", 135, 5651, 7768);
            CallChecker.varInit(OS_AIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_AIX", 135, 5651, 7768);
            aliasStringMap = CallChecker.beforeCalled(aliasStringMap, Map.class, 137, 5824, 5837);
            for (Map.Entry<String, String> aliasEntryString : CallChecker.isCalled(aliasStringMap, Map.class, 137, 5824, 5837).entrySet()) {
                String currentAliasKey = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(aliasEntryString, Map.Entry.class, 139, 5898, 5913)) {
                    currentAliasKey = CallChecker.isCalled(aliasEntryString, Map.Entry.class, 139, 5898, 5913).getKey();
                    CallChecker.varAssign(currentAliasKey, "currentAliasKey", 139, 5898, 5913);
                }
                String currentNormalizedName = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(currentAliasKey, String.class, 141, 5995, 6009)) {
                    if (CallChecker.beforeDeref(currentAliasKey, String.class, 141, 5969, 5983)) {
                        currentAliasKey = CallChecker.beforeCalled(currentAliasKey, String.class, 141, 5995, 6009);
                        currentAliasKey = CallChecker.beforeCalled(currentAliasKey, String.class, 141, 5969, 5983);
                        currentNormalizedName = CallChecker.isCalled(currentAliasKey, String.class, 141, 5969, 5983).substring(((CallChecker.isCalled(currentAliasKey, String.class, 141, 5995, 6009).lastIndexOf(".")) + 1));
                        CallChecker.varAssign(currentNormalizedName, "currentNormalizedName", 141, 5995, 6009);
                    }
                }
                String currentAliasesString = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(aliasEntryString, Map.Entry.class, 143, 6075, 6090)) {
                    currentAliasesString = CallChecker.isCalled(aliasEntryString, Map.Entry.class, 143, 6075, 6090).getValue();
                    CallChecker.varAssign(currentAliasesString, "currentAliasesString", 143, 6075, 6090);
                }
                if (currentAliasesString != null) {
                    String[] aliases = CallChecker.varInit(currentAliasesString.split(","), "aliases", 147, 6180, 6230);
                    List<String> fullAliasList = CallChecker.varInit(new ArrayList<String>(), "fullAliasList", 148, 6248, 6300);
                    if (CallChecker.beforeDeref(fullAliasList, List.class, 150, 6369, 6381)) {
                        fullAliasList = CallChecker.beforeCalled(fullAliasList, List.class, 150, 6369, 6381);
                        CallChecker.isCalled(fullAliasList, List.class, 150, 6369, 6381).add(currentNormalizedName);
                    }
                    if (CallChecker.beforeDeref(fullAliasList, List.class, 151, 6427, 6439)) {
                        fullAliasList = CallChecker.beforeCalled(fullAliasList, List.class, 151, 6427, 6439);
                        CallChecker.isCalled(fullAliasList, List.class, 151, 6427, 6439).addAll(Arrays.asList(aliases));
                    }
                    if (CallChecker.beforeDeref(aliasMap, Map.class, 152, 6489, 6496)) {
                        aliasMap = CallChecker.beforeCalled(aliasMap, Map.class, 152, 6489, 6496);
                        CallChecker.isCalled(aliasMap, Map.class, 152, 6489, 6496).put(currentNormalizedName, fullAliasList);
                    }
                    if (CallChecker.beforeDeref(aliases, void.class, 153, 6582, 6588)) {
                        for (String currentAlias : aliases) {
                            List<String> aliasList = CallChecker.init(List.class);
                            if (CallChecker.beforeDeref(aliasMap, Map.class, 155, 6654, 6661)) {
                                aliasMap = CallChecker.beforeCalled(aliasMap, Map.class, 155, 6654, 6661);
                                aliasList = CallChecker.isCalled(aliasMap, Map.class, 155, 6654, 6661).get(currentAlias);
                                CallChecker.varAssign(aliasList, "aliasList", 155, 6654, 6661);
                            }
                            if (aliasList == null) {
                                if (CallChecker.beforeDeref(aliasMap, Map.class, 158, 6770, 6777)) {
                                    aliasMap = CallChecker.beforeCalled(aliasMap, Map.class, 158, 6770, 6777);
                                    CallChecker.isCalled(aliasMap, Map.class, 158, 6770, 6777).put(currentAlias, fullAliasList);
                                }
                            }else {
                                if (CallChecker.beforeDeref(aliases, void.class, 162, 6929, 6935)) {
                                    for (String newAliases : aliases) {
                                        if (!(aliasList.contains(newAliases))) {
                                            aliasList.add(newAliases);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }else {
                    List<String> aliasList = CallChecker.init(List.class);
                    if (CallChecker.beforeDeref(aliasMap, Map.class, 174, 7299, 7306)) {
                        aliasMap = CallChecker.beforeCalled(aliasMap, Map.class, 174, 7299, 7306);
                        aliasList = CallChecker.isCalled(aliasMap, Map.class, 174, 7299, 7306).get(currentNormalizedName);
                        CallChecker.varAssign(aliasList, "aliasList", 174, 7299, 7306);
                    }
                    if (aliasList == null) {
                        if (CallChecker.beforeDeref(aliasMap, Map.class, 177, 7412, 7419)) {
                            aliasMap = CallChecker.beforeCalled(aliasMap, Map.class, 177, 7412, 7419);
                            CallChecker.isCalled(aliasMap, Map.class, 177, 7412, 7419).put(currentNormalizedName, new ArrayList<String>(Collections.singletonList(currentNormalizedName)));
                        }
                    }else {
                        aliasList.add(0, currentNormalizedName);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1757.methodEnd();
        }
    }

    private static Map<String, String> getAllKeysWithPrefix(String prefix, Map<String, String> configMap) {
        MethodContext _bcornu_methode_context1758 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(configMap, "configMap", 188, 7775, 8257);
            CallChecker.varInit(prefix, "prefix", 188, 7775, 8257);
            CallChecker.varInit(PROC_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALIASES", 188, 7775, 8257);
            CallChecker.varInit(OS_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_ALIASES", 188, 7775, 8257);
            CallChecker.varInit(PROC_SPARC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_SPARC", 188, 7775, 8257);
            CallChecker.varInit(PROC_POWER_PC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_POWER_PC", 188, 7775, 8257);
            CallChecker.varInit(PROC_PARISC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_PARISC", 188, 7775, 8257);
            CallChecker.varInit(PROC_MIPS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_MIPS", 188, 7775, 8257);
            CallChecker.varInit(PROC_IGNITE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_IGNITE", 188, 7775, 8257);
            CallChecker.varInit(PROC_ALPHA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALPHA", 188, 7775, 8257);
            CallChecker.varInit(PROC_ARM, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM", 188, 7775, 8257);
            CallChecker.varInit(PROC_ARM_BE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_BE", 188, 7775, 8257);
            CallChecker.varInit(PROC_ARM_LE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_LE", 188, 7775, 8257);
            CallChecker.varInit(PROC_68K, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_68K", 188, 7775, 8257);
            CallChecker.varInit(PROC_X86, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86", 188, 7775, 8257);
            CallChecker.varInit(PROC_X86_64, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86_64", 188, 7775, 8257);
            CallChecker.varInit(OS_WIN_32, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WIN_32", 188, 7775, 8257);
            CallChecker.varInit(OS_WINDOWS_XP, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_XP", 188, 7775, 8257);
            CallChecker.varInit(OS_WINDOWS_VISTA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_VISTA", 188, 7775, 8257);
            CallChecker.varInit(OS_WINDOWS_SERVER_2012, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2012", 188, 7775, 8257);
            CallChecker.varInit(OS_WINDOWS_SERVER_2008, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2008", 188, 7775, 8257);
            CallChecker.varInit(OS_WINDOWS_NT, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_NT", 188, 7775, 8257);
            CallChecker.varInit(OS_WINDOWS_CE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_CE", 188, 7775, 8257);
            CallChecker.varInit(OS_WINDOWS_98, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_98", 188, 7775, 8257);
            CallChecker.varInit(OS_WINDOWS_95, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_95", 188, 7775, 8257);
            CallChecker.varInit(OS_WINDOWS_9, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_9", 188, 7775, 8257);
            CallChecker.varInit(OS_WINDOWS_8, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_8", 188, 7775, 8257);
            CallChecker.varInit(OS_WINDOWS_7, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_7", 188, 7775, 8257);
            CallChecker.varInit(OS_WINDOWS_2003, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2003", 188, 7775, 8257);
            CallChecker.varInit(OS_WINDOWS_2000, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2000", 188, 7775, 8257);
            CallChecker.varInit(OS_VXWORKS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_VXWORKS", 188, 7775, 8257);
            CallChecker.varInit(OS_SUNOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SUNOS", 188, 7775, 8257);
            CallChecker.varInit(OS_SOLARIS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SOLARIS", 188, 7775, 8257);
            CallChecker.varInit(OS_QNX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_QNX", 188, 7775, 8257);
            CallChecker.varInit(OS_OS2, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OS2", 188, 7775, 8257);
            CallChecker.varInit(OS_OPENBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OPENBSD", 188, 7775, 8257);
            CallChecker.varInit(OS_NETWARE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETWARE", 188, 7775, 8257);
            CallChecker.varInit(OS_NETBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETBSD", 188, 7775, 8257);
            CallChecker.varInit(OS_MACOSX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOSX", 188, 7775, 8257);
            CallChecker.varInit(OS_MACOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOS", 188, 7775, 8257);
            CallChecker.varInit(OS_LINUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_LINUX", 188, 7775, 8257);
            CallChecker.varInit(OS_IRIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_IRIX", 188, 7775, 8257);
            CallChecker.varInit(OS_HPUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_HPUX", 188, 7775, 8257);
            CallChecker.varInit(OS_EPOC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_EPOC", 188, 7775, 8257);
            CallChecker.varInit(OS_DIGITALUNIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_DIGITALUNIX", 188, 7775, 8257);
            CallChecker.varInit(OS_AIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_AIX", 188, 7775, 8257);
            Map<String, String> keysWithPrefix = CallChecker.varInit(new HashMap<String, String>(), "keysWithPrefix", 190, 7891, 7957);
            configMap = CallChecker.beforeCalled(configMap, Map.class, 191, 8011, 8019);
            for (Map.Entry<String, String> currentEntry : CallChecker.isCalled(configMap, Map.class, 191, 8011, 8019).entrySet()) {
                if (CallChecker.beforeDeref(currentEntry, Map.Entry.class, 193, 8058, 8069)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(currentEntry, Map.Entry.class, 193, 8058, 8069).getKey(), String.class, 193, 8058, 8078)) {
                        if (CallChecker.isCalled(CallChecker.isCalled(currentEntry, Map.Entry.class, 193, 8058, 8069).getKey(), String.class, 193, 8058, 8078).startsWith(prefix)) {
                            if (CallChecker.beforeDeref(currentEntry, Map.Entry.class, 195, 8149, 8160)) {
                                if (CallChecker.beforeDeref(currentEntry, Map.Entry.class, 195, 8172, 8183)) {
                                    if (CallChecker.beforeDeref(keysWithPrefix, Map.class, 195, 8130, 8143)) {
                                        keysWithPrefix = CallChecker.beforeCalled(keysWithPrefix, Map.class, 195, 8130, 8143);
                                        CallChecker.isCalled(keysWithPrefix, Map.class, 195, 8130, 8143).put(CallChecker.isCalled(currentEntry, Map.Entry.class, 195, 8149, 8160).getKey(), CallChecker.isCalled(currentEntry, Map.Entry.class, 195, 8172, 8183).getValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return keysWithPrefix;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<String, String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1758.methodEnd();
        }
    }

    public String[] getLibraryEntries() {
        MethodContext _bcornu_methode_context1759 = new MethodContext(String[].class);
        try {
            CallChecker.varInit(this, "this", 201, 8264, 8343);
            CallChecker.varInit(this.m_selectionFilter, "m_selectionFilter", 201, 8264, 8343);
            CallChecker.varInit(this.m_languages, "m_languages", 201, 8264, 8343);
            CallChecker.varInit(this.m_osversions, "m_osversions", 201, 8264, 8343);
            CallChecker.varInit(this.m_processors, "m_processors", 201, 8264, 8343);
            CallChecker.varInit(this.m_osnames, "m_osnames", 201, 8264, 8343);
            CallChecker.varInit(this.m_libraryEntries, "m_libraryEntries", 201, 8264, 8343);
            CallChecker.varInit(PROC_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALIASES", 201, 8264, 8343);
            CallChecker.varInit(OS_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_ALIASES", 201, 8264, 8343);
            CallChecker.varInit(PROC_SPARC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_SPARC", 201, 8264, 8343);
            CallChecker.varInit(PROC_POWER_PC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_POWER_PC", 201, 8264, 8343);
            CallChecker.varInit(PROC_PARISC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_PARISC", 201, 8264, 8343);
            CallChecker.varInit(PROC_MIPS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_MIPS", 201, 8264, 8343);
            CallChecker.varInit(PROC_IGNITE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_IGNITE", 201, 8264, 8343);
            CallChecker.varInit(PROC_ALPHA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALPHA", 201, 8264, 8343);
            CallChecker.varInit(PROC_ARM, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM", 201, 8264, 8343);
            CallChecker.varInit(PROC_ARM_BE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_BE", 201, 8264, 8343);
            CallChecker.varInit(PROC_ARM_LE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_LE", 201, 8264, 8343);
            CallChecker.varInit(PROC_68K, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_68K", 201, 8264, 8343);
            CallChecker.varInit(PROC_X86, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86", 201, 8264, 8343);
            CallChecker.varInit(PROC_X86_64, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86_64", 201, 8264, 8343);
            CallChecker.varInit(OS_WIN_32, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WIN_32", 201, 8264, 8343);
            CallChecker.varInit(OS_WINDOWS_XP, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_XP", 201, 8264, 8343);
            CallChecker.varInit(OS_WINDOWS_VISTA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_VISTA", 201, 8264, 8343);
            CallChecker.varInit(OS_WINDOWS_SERVER_2012, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2012", 201, 8264, 8343);
            CallChecker.varInit(OS_WINDOWS_SERVER_2008, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2008", 201, 8264, 8343);
            CallChecker.varInit(OS_WINDOWS_NT, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_NT", 201, 8264, 8343);
            CallChecker.varInit(OS_WINDOWS_CE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_CE", 201, 8264, 8343);
            CallChecker.varInit(OS_WINDOWS_98, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_98", 201, 8264, 8343);
            CallChecker.varInit(OS_WINDOWS_95, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_95", 201, 8264, 8343);
            CallChecker.varInit(OS_WINDOWS_9, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_9", 201, 8264, 8343);
            CallChecker.varInit(OS_WINDOWS_8, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_8", 201, 8264, 8343);
            CallChecker.varInit(OS_WINDOWS_7, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_7", 201, 8264, 8343);
            CallChecker.varInit(OS_WINDOWS_2003, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2003", 201, 8264, 8343);
            CallChecker.varInit(OS_WINDOWS_2000, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2000", 201, 8264, 8343);
            CallChecker.varInit(OS_VXWORKS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_VXWORKS", 201, 8264, 8343);
            CallChecker.varInit(OS_SUNOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SUNOS", 201, 8264, 8343);
            CallChecker.varInit(OS_SOLARIS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SOLARIS", 201, 8264, 8343);
            CallChecker.varInit(OS_QNX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_QNX", 201, 8264, 8343);
            CallChecker.varInit(OS_OS2, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OS2", 201, 8264, 8343);
            CallChecker.varInit(OS_OPENBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OPENBSD", 201, 8264, 8343);
            CallChecker.varInit(OS_NETWARE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETWARE", 201, 8264, 8343);
            CallChecker.varInit(OS_NETBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETBSD", 201, 8264, 8343);
            CallChecker.varInit(OS_MACOSX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOSX", 201, 8264, 8343);
            CallChecker.varInit(OS_MACOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOS", 201, 8264, 8343);
            CallChecker.varInit(OS_LINUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_LINUX", 201, 8264, 8343);
            CallChecker.varInit(OS_IRIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_IRIX", 201, 8264, 8343);
            CallChecker.varInit(OS_HPUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_HPUX", 201, 8264, 8343);
            CallChecker.varInit(OS_EPOC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_EPOC", 201, 8264, 8343);
            CallChecker.varInit(OS_DIGITALUNIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_DIGITALUNIX", 201, 8264, 8343);
            CallChecker.varInit(OS_AIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_AIX", 201, 8264, 8343);
            return m_libraryEntries;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1759.methodEnd();
        }
    }

    public String[] getOSNames() {
        MethodContext _bcornu_methode_context1760 = new MethodContext(String[].class);
        try {
            CallChecker.varInit(this, "this", 206, 8350, 8415);
            CallChecker.varInit(this.m_selectionFilter, "m_selectionFilter", 206, 8350, 8415);
            CallChecker.varInit(this.m_languages, "m_languages", 206, 8350, 8415);
            CallChecker.varInit(this.m_osversions, "m_osversions", 206, 8350, 8415);
            CallChecker.varInit(this.m_processors, "m_processors", 206, 8350, 8415);
            CallChecker.varInit(this.m_osnames, "m_osnames", 206, 8350, 8415);
            CallChecker.varInit(this.m_libraryEntries, "m_libraryEntries", 206, 8350, 8415);
            CallChecker.varInit(PROC_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALIASES", 206, 8350, 8415);
            CallChecker.varInit(OS_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_ALIASES", 206, 8350, 8415);
            CallChecker.varInit(PROC_SPARC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_SPARC", 206, 8350, 8415);
            CallChecker.varInit(PROC_POWER_PC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_POWER_PC", 206, 8350, 8415);
            CallChecker.varInit(PROC_PARISC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_PARISC", 206, 8350, 8415);
            CallChecker.varInit(PROC_MIPS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_MIPS", 206, 8350, 8415);
            CallChecker.varInit(PROC_IGNITE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_IGNITE", 206, 8350, 8415);
            CallChecker.varInit(PROC_ALPHA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALPHA", 206, 8350, 8415);
            CallChecker.varInit(PROC_ARM, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM", 206, 8350, 8415);
            CallChecker.varInit(PROC_ARM_BE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_BE", 206, 8350, 8415);
            CallChecker.varInit(PROC_ARM_LE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_LE", 206, 8350, 8415);
            CallChecker.varInit(PROC_68K, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_68K", 206, 8350, 8415);
            CallChecker.varInit(PROC_X86, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86", 206, 8350, 8415);
            CallChecker.varInit(PROC_X86_64, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86_64", 206, 8350, 8415);
            CallChecker.varInit(OS_WIN_32, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WIN_32", 206, 8350, 8415);
            CallChecker.varInit(OS_WINDOWS_XP, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_XP", 206, 8350, 8415);
            CallChecker.varInit(OS_WINDOWS_VISTA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_VISTA", 206, 8350, 8415);
            CallChecker.varInit(OS_WINDOWS_SERVER_2012, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2012", 206, 8350, 8415);
            CallChecker.varInit(OS_WINDOWS_SERVER_2008, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2008", 206, 8350, 8415);
            CallChecker.varInit(OS_WINDOWS_NT, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_NT", 206, 8350, 8415);
            CallChecker.varInit(OS_WINDOWS_CE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_CE", 206, 8350, 8415);
            CallChecker.varInit(OS_WINDOWS_98, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_98", 206, 8350, 8415);
            CallChecker.varInit(OS_WINDOWS_95, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_95", 206, 8350, 8415);
            CallChecker.varInit(OS_WINDOWS_9, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_9", 206, 8350, 8415);
            CallChecker.varInit(OS_WINDOWS_8, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_8", 206, 8350, 8415);
            CallChecker.varInit(OS_WINDOWS_7, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_7", 206, 8350, 8415);
            CallChecker.varInit(OS_WINDOWS_2003, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2003", 206, 8350, 8415);
            CallChecker.varInit(OS_WINDOWS_2000, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2000", 206, 8350, 8415);
            CallChecker.varInit(OS_VXWORKS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_VXWORKS", 206, 8350, 8415);
            CallChecker.varInit(OS_SUNOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SUNOS", 206, 8350, 8415);
            CallChecker.varInit(OS_SOLARIS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SOLARIS", 206, 8350, 8415);
            CallChecker.varInit(OS_QNX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_QNX", 206, 8350, 8415);
            CallChecker.varInit(OS_OS2, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OS2", 206, 8350, 8415);
            CallChecker.varInit(OS_OPENBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OPENBSD", 206, 8350, 8415);
            CallChecker.varInit(OS_NETWARE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETWARE", 206, 8350, 8415);
            CallChecker.varInit(OS_NETBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETBSD", 206, 8350, 8415);
            CallChecker.varInit(OS_MACOSX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOSX", 206, 8350, 8415);
            CallChecker.varInit(OS_MACOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOS", 206, 8350, 8415);
            CallChecker.varInit(OS_LINUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_LINUX", 206, 8350, 8415);
            CallChecker.varInit(OS_IRIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_IRIX", 206, 8350, 8415);
            CallChecker.varInit(OS_HPUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_HPUX", 206, 8350, 8415);
            CallChecker.varInit(OS_EPOC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_EPOC", 206, 8350, 8415);
            CallChecker.varInit(OS_DIGITALUNIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_DIGITALUNIX", 206, 8350, 8415);
            CallChecker.varInit(OS_AIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_AIX", 206, 8350, 8415);
            return m_osnames;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1760.methodEnd();
        }
    }

    public String[] getProcessors() {
        MethodContext _bcornu_methode_context1761 = new MethodContext(String[].class);
        try {
            CallChecker.varInit(this, "this", 211, 8422, 8493);
            CallChecker.varInit(this.m_selectionFilter, "m_selectionFilter", 211, 8422, 8493);
            CallChecker.varInit(this.m_languages, "m_languages", 211, 8422, 8493);
            CallChecker.varInit(this.m_osversions, "m_osversions", 211, 8422, 8493);
            CallChecker.varInit(this.m_processors, "m_processors", 211, 8422, 8493);
            CallChecker.varInit(this.m_osnames, "m_osnames", 211, 8422, 8493);
            CallChecker.varInit(this.m_libraryEntries, "m_libraryEntries", 211, 8422, 8493);
            CallChecker.varInit(PROC_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALIASES", 211, 8422, 8493);
            CallChecker.varInit(OS_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_ALIASES", 211, 8422, 8493);
            CallChecker.varInit(PROC_SPARC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_SPARC", 211, 8422, 8493);
            CallChecker.varInit(PROC_POWER_PC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_POWER_PC", 211, 8422, 8493);
            CallChecker.varInit(PROC_PARISC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_PARISC", 211, 8422, 8493);
            CallChecker.varInit(PROC_MIPS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_MIPS", 211, 8422, 8493);
            CallChecker.varInit(PROC_IGNITE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_IGNITE", 211, 8422, 8493);
            CallChecker.varInit(PROC_ALPHA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALPHA", 211, 8422, 8493);
            CallChecker.varInit(PROC_ARM, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM", 211, 8422, 8493);
            CallChecker.varInit(PROC_ARM_BE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_BE", 211, 8422, 8493);
            CallChecker.varInit(PROC_ARM_LE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_LE", 211, 8422, 8493);
            CallChecker.varInit(PROC_68K, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_68K", 211, 8422, 8493);
            CallChecker.varInit(PROC_X86, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86", 211, 8422, 8493);
            CallChecker.varInit(PROC_X86_64, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86_64", 211, 8422, 8493);
            CallChecker.varInit(OS_WIN_32, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WIN_32", 211, 8422, 8493);
            CallChecker.varInit(OS_WINDOWS_XP, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_XP", 211, 8422, 8493);
            CallChecker.varInit(OS_WINDOWS_VISTA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_VISTA", 211, 8422, 8493);
            CallChecker.varInit(OS_WINDOWS_SERVER_2012, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2012", 211, 8422, 8493);
            CallChecker.varInit(OS_WINDOWS_SERVER_2008, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2008", 211, 8422, 8493);
            CallChecker.varInit(OS_WINDOWS_NT, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_NT", 211, 8422, 8493);
            CallChecker.varInit(OS_WINDOWS_CE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_CE", 211, 8422, 8493);
            CallChecker.varInit(OS_WINDOWS_98, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_98", 211, 8422, 8493);
            CallChecker.varInit(OS_WINDOWS_95, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_95", 211, 8422, 8493);
            CallChecker.varInit(OS_WINDOWS_9, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_9", 211, 8422, 8493);
            CallChecker.varInit(OS_WINDOWS_8, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_8", 211, 8422, 8493);
            CallChecker.varInit(OS_WINDOWS_7, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_7", 211, 8422, 8493);
            CallChecker.varInit(OS_WINDOWS_2003, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2003", 211, 8422, 8493);
            CallChecker.varInit(OS_WINDOWS_2000, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2000", 211, 8422, 8493);
            CallChecker.varInit(OS_VXWORKS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_VXWORKS", 211, 8422, 8493);
            CallChecker.varInit(OS_SUNOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SUNOS", 211, 8422, 8493);
            CallChecker.varInit(OS_SOLARIS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SOLARIS", 211, 8422, 8493);
            CallChecker.varInit(OS_QNX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_QNX", 211, 8422, 8493);
            CallChecker.varInit(OS_OS2, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OS2", 211, 8422, 8493);
            CallChecker.varInit(OS_OPENBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OPENBSD", 211, 8422, 8493);
            CallChecker.varInit(OS_NETWARE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETWARE", 211, 8422, 8493);
            CallChecker.varInit(OS_NETBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETBSD", 211, 8422, 8493);
            CallChecker.varInit(OS_MACOSX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOSX", 211, 8422, 8493);
            CallChecker.varInit(OS_MACOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOS", 211, 8422, 8493);
            CallChecker.varInit(OS_LINUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_LINUX", 211, 8422, 8493);
            CallChecker.varInit(OS_IRIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_IRIX", 211, 8422, 8493);
            CallChecker.varInit(OS_HPUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_HPUX", 211, 8422, 8493);
            CallChecker.varInit(OS_EPOC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_EPOC", 211, 8422, 8493);
            CallChecker.varInit(OS_DIGITALUNIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_DIGITALUNIX", 211, 8422, 8493);
            CallChecker.varInit(OS_AIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_AIX", 211, 8422, 8493);
            return m_processors;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1761.methodEnd();
        }
    }

    public String[] getOSVersions() {
        MethodContext _bcornu_methode_context1762 = new MethodContext(String[].class);
        try {
            CallChecker.varInit(this, "this", 216, 8500, 8571);
            CallChecker.varInit(this.m_selectionFilter, "m_selectionFilter", 216, 8500, 8571);
            CallChecker.varInit(this.m_languages, "m_languages", 216, 8500, 8571);
            CallChecker.varInit(this.m_osversions, "m_osversions", 216, 8500, 8571);
            CallChecker.varInit(this.m_processors, "m_processors", 216, 8500, 8571);
            CallChecker.varInit(this.m_osnames, "m_osnames", 216, 8500, 8571);
            CallChecker.varInit(this.m_libraryEntries, "m_libraryEntries", 216, 8500, 8571);
            CallChecker.varInit(PROC_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALIASES", 216, 8500, 8571);
            CallChecker.varInit(OS_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_ALIASES", 216, 8500, 8571);
            CallChecker.varInit(PROC_SPARC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_SPARC", 216, 8500, 8571);
            CallChecker.varInit(PROC_POWER_PC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_POWER_PC", 216, 8500, 8571);
            CallChecker.varInit(PROC_PARISC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_PARISC", 216, 8500, 8571);
            CallChecker.varInit(PROC_MIPS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_MIPS", 216, 8500, 8571);
            CallChecker.varInit(PROC_IGNITE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_IGNITE", 216, 8500, 8571);
            CallChecker.varInit(PROC_ALPHA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALPHA", 216, 8500, 8571);
            CallChecker.varInit(PROC_ARM, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM", 216, 8500, 8571);
            CallChecker.varInit(PROC_ARM_BE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_BE", 216, 8500, 8571);
            CallChecker.varInit(PROC_ARM_LE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_LE", 216, 8500, 8571);
            CallChecker.varInit(PROC_68K, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_68K", 216, 8500, 8571);
            CallChecker.varInit(PROC_X86, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86", 216, 8500, 8571);
            CallChecker.varInit(PROC_X86_64, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86_64", 216, 8500, 8571);
            CallChecker.varInit(OS_WIN_32, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WIN_32", 216, 8500, 8571);
            CallChecker.varInit(OS_WINDOWS_XP, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_XP", 216, 8500, 8571);
            CallChecker.varInit(OS_WINDOWS_VISTA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_VISTA", 216, 8500, 8571);
            CallChecker.varInit(OS_WINDOWS_SERVER_2012, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2012", 216, 8500, 8571);
            CallChecker.varInit(OS_WINDOWS_SERVER_2008, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2008", 216, 8500, 8571);
            CallChecker.varInit(OS_WINDOWS_NT, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_NT", 216, 8500, 8571);
            CallChecker.varInit(OS_WINDOWS_CE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_CE", 216, 8500, 8571);
            CallChecker.varInit(OS_WINDOWS_98, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_98", 216, 8500, 8571);
            CallChecker.varInit(OS_WINDOWS_95, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_95", 216, 8500, 8571);
            CallChecker.varInit(OS_WINDOWS_9, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_9", 216, 8500, 8571);
            CallChecker.varInit(OS_WINDOWS_8, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_8", 216, 8500, 8571);
            CallChecker.varInit(OS_WINDOWS_7, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_7", 216, 8500, 8571);
            CallChecker.varInit(OS_WINDOWS_2003, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2003", 216, 8500, 8571);
            CallChecker.varInit(OS_WINDOWS_2000, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2000", 216, 8500, 8571);
            CallChecker.varInit(OS_VXWORKS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_VXWORKS", 216, 8500, 8571);
            CallChecker.varInit(OS_SUNOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SUNOS", 216, 8500, 8571);
            CallChecker.varInit(OS_SOLARIS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SOLARIS", 216, 8500, 8571);
            CallChecker.varInit(OS_QNX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_QNX", 216, 8500, 8571);
            CallChecker.varInit(OS_OS2, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OS2", 216, 8500, 8571);
            CallChecker.varInit(OS_OPENBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OPENBSD", 216, 8500, 8571);
            CallChecker.varInit(OS_NETWARE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETWARE", 216, 8500, 8571);
            CallChecker.varInit(OS_NETBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETBSD", 216, 8500, 8571);
            CallChecker.varInit(OS_MACOSX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOSX", 216, 8500, 8571);
            CallChecker.varInit(OS_MACOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOS", 216, 8500, 8571);
            CallChecker.varInit(OS_LINUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_LINUX", 216, 8500, 8571);
            CallChecker.varInit(OS_IRIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_IRIX", 216, 8500, 8571);
            CallChecker.varInit(OS_HPUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_HPUX", 216, 8500, 8571);
            CallChecker.varInit(OS_EPOC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_EPOC", 216, 8500, 8571);
            CallChecker.varInit(OS_DIGITALUNIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_DIGITALUNIX", 216, 8500, 8571);
            CallChecker.varInit(OS_AIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_AIX", 216, 8500, 8571);
            return m_osversions;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1762.methodEnd();
        }
    }

    public String[] getLanguages() {
        MethodContext _bcornu_methode_context1763 = new MethodContext(String[].class);
        try {
            CallChecker.varInit(this, "this", 221, 8578, 8647);
            CallChecker.varInit(this.m_selectionFilter, "m_selectionFilter", 221, 8578, 8647);
            CallChecker.varInit(this.m_languages, "m_languages", 221, 8578, 8647);
            CallChecker.varInit(this.m_osversions, "m_osversions", 221, 8578, 8647);
            CallChecker.varInit(this.m_processors, "m_processors", 221, 8578, 8647);
            CallChecker.varInit(this.m_osnames, "m_osnames", 221, 8578, 8647);
            CallChecker.varInit(this.m_libraryEntries, "m_libraryEntries", 221, 8578, 8647);
            CallChecker.varInit(PROC_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALIASES", 221, 8578, 8647);
            CallChecker.varInit(OS_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_ALIASES", 221, 8578, 8647);
            CallChecker.varInit(PROC_SPARC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_SPARC", 221, 8578, 8647);
            CallChecker.varInit(PROC_POWER_PC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_POWER_PC", 221, 8578, 8647);
            CallChecker.varInit(PROC_PARISC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_PARISC", 221, 8578, 8647);
            CallChecker.varInit(PROC_MIPS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_MIPS", 221, 8578, 8647);
            CallChecker.varInit(PROC_IGNITE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_IGNITE", 221, 8578, 8647);
            CallChecker.varInit(PROC_ALPHA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALPHA", 221, 8578, 8647);
            CallChecker.varInit(PROC_ARM, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM", 221, 8578, 8647);
            CallChecker.varInit(PROC_ARM_BE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_BE", 221, 8578, 8647);
            CallChecker.varInit(PROC_ARM_LE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_LE", 221, 8578, 8647);
            CallChecker.varInit(PROC_68K, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_68K", 221, 8578, 8647);
            CallChecker.varInit(PROC_X86, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86", 221, 8578, 8647);
            CallChecker.varInit(PROC_X86_64, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86_64", 221, 8578, 8647);
            CallChecker.varInit(OS_WIN_32, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WIN_32", 221, 8578, 8647);
            CallChecker.varInit(OS_WINDOWS_XP, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_XP", 221, 8578, 8647);
            CallChecker.varInit(OS_WINDOWS_VISTA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_VISTA", 221, 8578, 8647);
            CallChecker.varInit(OS_WINDOWS_SERVER_2012, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2012", 221, 8578, 8647);
            CallChecker.varInit(OS_WINDOWS_SERVER_2008, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2008", 221, 8578, 8647);
            CallChecker.varInit(OS_WINDOWS_NT, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_NT", 221, 8578, 8647);
            CallChecker.varInit(OS_WINDOWS_CE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_CE", 221, 8578, 8647);
            CallChecker.varInit(OS_WINDOWS_98, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_98", 221, 8578, 8647);
            CallChecker.varInit(OS_WINDOWS_95, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_95", 221, 8578, 8647);
            CallChecker.varInit(OS_WINDOWS_9, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_9", 221, 8578, 8647);
            CallChecker.varInit(OS_WINDOWS_8, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_8", 221, 8578, 8647);
            CallChecker.varInit(OS_WINDOWS_7, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_7", 221, 8578, 8647);
            CallChecker.varInit(OS_WINDOWS_2003, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2003", 221, 8578, 8647);
            CallChecker.varInit(OS_WINDOWS_2000, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2000", 221, 8578, 8647);
            CallChecker.varInit(OS_VXWORKS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_VXWORKS", 221, 8578, 8647);
            CallChecker.varInit(OS_SUNOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SUNOS", 221, 8578, 8647);
            CallChecker.varInit(OS_SOLARIS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SOLARIS", 221, 8578, 8647);
            CallChecker.varInit(OS_QNX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_QNX", 221, 8578, 8647);
            CallChecker.varInit(OS_OS2, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OS2", 221, 8578, 8647);
            CallChecker.varInit(OS_OPENBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OPENBSD", 221, 8578, 8647);
            CallChecker.varInit(OS_NETWARE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETWARE", 221, 8578, 8647);
            CallChecker.varInit(OS_NETBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETBSD", 221, 8578, 8647);
            CallChecker.varInit(OS_MACOSX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOSX", 221, 8578, 8647);
            CallChecker.varInit(OS_MACOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOS", 221, 8578, 8647);
            CallChecker.varInit(OS_LINUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_LINUX", 221, 8578, 8647);
            CallChecker.varInit(OS_IRIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_IRIX", 221, 8578, 8647);
            CallChecker.varInit(OS_HPUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_HPUX", 221, 8578, 8647);
            CallChecker.varInit(OS_EPOC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_EPOC", 221, 8578, 8647);
            CallChecker.varInit(OS_DIGITALUNIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_DIGITALUNIX", 221, 8578, 8647);
            CallChecker.varInit(OS_AIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_AIX", 221, 8578, 8647);
            return m_languages;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1763.methodEnd();
        }
    }

    public String getSelectionFilter() {
        MethodContext _bcornu_methode_context1764 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 226, 8654, 8733);
            CallChecker.varInit(this.m_selectionFilter, "m_selectionFilter", 226, 8654, 8733);
            CallChecker.varInit(this.m_languages, "m_languages", 226, 8654, 8733);
            CallChecker.varInit(this.m_osversions, "m_osversions", 226, 8654, 8733);
            CallChecker.varInit(this.m_processors, "m_processors", 226, 8654, 8733);
            CallChecker.varInit(this.m_osnames, "m_osnames", 226, 8654, 8733);
            CallChecker.varInit(this.m_libraryEntries, "m_libraryEntries", 226, 8654, 8733);
            CallChecker.varInit(PROC_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALIASES", 226, 8654, 8733);
            CallChecker.varInit(OS_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_ALIASES", 226, 8654, 8733);
            CallChecker.varInit(PROC_SPARC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_SPARC", 226, 8654, 8733);
            CallChecker.varInit(PROC_POWER_PC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_POWER_PC", 226, 8654, 8733);
            CallChecker.varInit(PROC_PARISC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_PARISC", 226, 8654, 8733);
            CallChecker.varInit(PROC_MIPS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_MIPS", 226, 8654, 8733);
            CallChecker.varInit(PROC_IGNITE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_IGNITE", 226, 8654, 8733);
            CallChecker.varInit(PROC_ALPHA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALPHA", 226, 8654, 8733);
            CallChecker.varInit(PROC_ARM, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM", 226, 8654, 8733);
            CallChecker.varInit(PROC_ARM_BE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_BE", 226, 8654, 8733);
            CallChecker.varInit(PROC_ARM_LE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_LE", 226, 8654, 8733);
            CallChecker.varInit(PROC_68K, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_68K", 226, 8654, 8733);
            CallChecker.varInit(PROC_X86, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86", 226, 8654, 8733);
            CallChecker.varInit(PROC_X86_64, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86_64", 226, 8654, 8733);
            CallChecker.varInit(OS_WIN_32, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WIN_32", 226, 8654, 8733);
            CallChecker.varInit(OS_WINDOWS_XP, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_XP", 226, 8654, 8733);
            CallChecker.varInit(OS_WINDOWS_VISTA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_VISTA", 226, 8654, 8733);
            CallChecker.varInit(OS_WINDOWS_SERVER_2012, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2012", 226, 8654, 8733);
            CallChecker.varInit(OS_WINDOWS_SERVER_2008, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2008", 226, 8654, 8733);
            CallChecker.varInit(OS_WINDOWS_NT, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_NT", 226, 8654, 8733);
            CallChecker.varInit(OS_WINDOWS_CE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_CE", 226, 8654, 8733);
            CallChecker.varInit(OS_WINDOWS_98, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_98", 226, 8654, 8733);
            CallChecker.varInit(OS_WINDOWS_95, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_95", 226, 8654, 8733);
            CallChecker.varInit(OS_WINDOWS_9, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_9", 226, 8654, 8733);
            CallChecker.varInit(OS_WINDOWS_8, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_8", 226, 8654, 8733);
            CallChecker.varInit(OS_WINDOWS_7, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_7", 226, 8654, 8733);
            CallChecker.varInit(OS_WINDOWS_2003, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2003", 226, 8654, 8733);
            CallChecker.varInit(OS_WINDOWS_2000, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2000", 226, 8654, 8733);
            CallChecker.varInit(OS_VXWORKS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_VXWORKS", 226, 8654, 8733);
            CallChecker.varInit(OS_SUNOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SUNOS", 226, 8654, 8733);
            CallChecker.varInit(OS_SOLARIS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SOLARIS", 226, 8654, 8733);
            CallChecker.varInit(OS_QNX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_QNX", 226, 8654, 8733);
            CallChecker.varInit(OS_OS2, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OS2", 226, 8654, 8733);
            CallChecker.varInit(OS_OPENBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OPENBSD", 226, 8654, 8733);
            CallChecker.varInit(OS_NETWARE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETWARE", 226, 8654, 8733);
            CallChecker.varInit(OS_NETBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETBSD", 226, 8654, 8733);
            CallChecker.varInit(OS_MACOSX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOSX", 226, 8654, 8733);
            CallChecker.varInit(OS_MACOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOS", 226, 8654, 8733);
            CallChecker.varInit(OS_LINUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_LINUX", 226, 8654, 8733);
            CallChecker.varInit(OS_IRIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_IRIX", 226, 8654, 8733);
            CallChecker.varInit(OS_HPUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_HPUX", 226, 8654, 8733);
            CallChecker.varInit(OS_EPOC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_EPOC", 226, 8654, 8733);
            CallChecker.varInit(OS_DIGITALUNIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_DIGITALUNIX", 226, 8654, 8733);
            CallChecker.varInit(OS_AIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_AIX", 226, 8654, 8733);
            return m_selectionFilter;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1764.methodEnd();
        }
    }

    public boolean match(Map configMap) throws BundleException {
        MethodContext _bcornu_methode_context1765 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 231, 8740, 10202);
            CallChecker.varInit(configMap, "configMap", 231, 8740, 10202);
            CallChecker.varInit(this.m_selectionFilter, "m_selectionFilter", 231, 8740, 10202);
            CallChecker.varInit(this.m_languages, "m_languages", 231, 8740, 10202);
            CallChecker.varInit(this.m_osversions, "m_osversions", 231, 8740, 10202);
            CallChecker.varInit(this.m_processors, "m_processors", 231, 8740, 10202);
            CallChecker.varInit(this.m_osnames, "m_osnames", 231, 8740, 10202);
            CallChecker.varInit(this.m_libraryEntries, "m_libraryEntries", 231, 8740, 10202);
            CallChecker.varInit(PROC_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALIASES", 231, 8740, 10202);
            CallChecker.varInit(OS_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_ALIASES", 231, 8740, 10202);
            CallChecker.varInit(PROC_SPARC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_SPARC", 231, 8740, 10202);
            CallChecker.varInit(PROC_POWER_PC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_POWER_PC", 231, 8740, 10202);
            CallChecker.varInit(PROC_PARISC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_PARISC", 231, 8740, 10202);
            CallChecker.varInit(PROC_MIPS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_MIPS", 231, 8740, 10202);
            CallChecker.varInit(PROC_IGNITE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_IGNITE", 231, 8740, 10202);
            CallChecker.varInit(PROC_ALPHA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALPHA", 231, 8740, 10202);
            CallChecker.varInit(PROC_ARM, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM", 231, 8740, 10202);
            CallChecker.varInit(PROC_ARM_BE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_BE", 231, 8740, 10202);
            CallChecker.varInit(PROC_ARM_LE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_LE", 231, 8740, 10202);
            CallChecker.varInit(PROC_68K, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_68K", 231, 8740, 10202);
            CallChecker.varInit(PROC_X86, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86", 231, 8740, 10202);
            CallChecker.varInit(PROC_X86_64, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86_64", 231, 8740, 10202);
            CallChecker.varInit(OS_WIN_32, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WIN_32", 231, 8740, 10202);
            CallChecker.varInit(OS_WINDOWS_XP, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_XP", 231, 8740, 10202);
            CallChecker.varInit(OS_WINDOWS_VISTA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_VISTA", 231, 8740, 10202);
            CallChecker.varInit(OS_WINDOWS_SERVER_2012, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2012", 231, 8740, 10202);
            CallChecker.varInit(OS_WINDOWS_SERVER_2008, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2008", 231, 8740, 10202);
            CallChecker.varInit(OS_WINDOWS_NT, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_NT", 231, 8740, 10202);
            CallChecker.varInit(OS_WINDOWS_CE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_CE", 231, 8740, 10202);
            CallChecker.varInit(OS_WINDOWS_98, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_98", 231, 8740, 10202);
            CallChecker.varInit(OS_WINDOWS_95, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_95", 231, 8740, 10202);
            CallChecker.varInit(OS_WINDOWS_9, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_9", 231, 8740, 10202);
            CallChecker.varInit(OS_WINDOWS_8, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_8", 231, 8740, 10202);
            CallChecker.varInit(OS_WINDOWS_7, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_7", 231, 8740, 10202);
            CallChecker.varInit(OS_WINDOWS_2003, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2003", 231, 8740, 10202);
            CallChecker.varInit(OS_WINDOWS_2000, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2000", 231, 8740, 10202);
            CallChecker.varInit(OS_VXWORKS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_VXWORKS", 231, 8740, 10202);
            CallChecker.varInit(OS_SUNOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SUNOS", 231, 8740, 10202);
            CallChecker.varInit(OS_SOLARIS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SOLARIS", 231, 8740, 10202);
            CallChecker.varInit(OS_QNX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_QNX", 231, 8740, 10202);
            CallChecker.varInit(OS_OS2, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OS2", 231, 8740, 10202);
            CallChecker.varInit(OS_OPENBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OPENBSD", 231, 8740, 10202);
            CallChecker.varInit(OS_NETWARE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETWARE", 231, 8740, 10202);
            CallChecker.varInit(OS_NETBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETBSD", 231, 8740, 10202);
            CallChecker.varInit(OS_MACOSX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOSX", 231, 8740, 10202);
            CallChecker.varInit(OS_MACOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOS", 231, 8740, 10202);
            CallChecker.varInit(OS_LINUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_LINUX", 231, 8740, 10202);
            CallChecker.varInit(OS_IRIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_IRIX", 231, 8740, 10202);
            CallChecker.varInit(OS_HPUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_HPUX", 231, 8740, 10202);
            CallChecker.varInit(OS_EPOC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_EPOC", 231, 8740, 10202);
            CallChecker.varInit(OS_DIGITALUNIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_DIGITALUNIX", 231, 8740, 10202);
            CallChecker.varInit(OS_AIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_AIX", 231, 8740, 10202);
            String osName = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(configMap, Map.class, 233, 8838, 8846)) {
                configMap = CallChecker.beforeCalled(configMap, Map.class, 233, 8838, 8846);
                osName = ((String) (CallChecker.isCalled(configMap, Map.class, 233, 8838, 8846).get(FelixConstants.FRAMEWORK_OS_NAME)));
                CallChecker.varAssign(osName, "osName", 233, 8838, 8846);
            }
            String processorName = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(configMap, Map.class, 234, 8927, 8935)) {
                configMap = CallChecker.beforeCalled(configMap, Map.class, 234, 8927, 8935);
                processorName = ((String) (CallChecker.isCalled(configMap, Map.class, 234, 8927, 8935).get(FelixConstants.FRAMEWORK_PROCESSOR)));
                CallChecker.varAssign(processorName, "processorName", 234, 8927, 8935);
            }
            String osVersion = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(configMap, Map.class, 235, 9014, 9022)) {
                configMap = CallChecker.beforeCalled(configMap, Map.class, 235, 9014, 9022);
                osVersion = ((String) (CallChecker.isCalled(configMap, Map.class, 235, 9014, 9022).get(FelixConstants.FRAMEWORK_OS_VERSION)));
                CallChecker.varAssign(osVersion, "osVersion", 235, 9014, 9022);
            }
            String language = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(configMap, Map.class, 236, 9101, 9109)) {
                configMap = CallChecker.beforeCalled(configMap, Map.class, 236, 9101, 9109);
                language = ((String) (CallChecker.isCalled(configMap, Map.class, 236, 9101, 9109).get(FelixConstants.FRAMEWORK_LANGUAGE)));
                CallChecker.varAssign(language, "language", 236, 9101, 9109);
            }
            if (!(checkOSNames(osName, getOSNames()))) {
                return false;
            }
            if (!(checkProcessors(processorName, getProcessors()))) {
                return false;
            }
            if ((((getOSVersions()) != null) && ((getOSVersions().length) > 0)) && (!(checkOSVersions(osVersion, getOSVersions())))) {
                return false;
            }
            if ((((getLanguages()) != null) && ((getLanguages().length) > 0)) && (!(checkLanguages(language, getLanguages())))) {
                return false;
            }
            if ((((getSelectionFilter()) != null) && ((getSelectionFilter().length()) >= 0)) && (!(checkSelectionFilter(configMap, getSelectionFilter())))) {
                return false;
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1765.methodEnd();
        }
    }

    private boolean checkOSNames(String osName, String[] osnames) {
        MethodContext _bcornu_methode_context1766 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 277, 10209, 10654);
            CallChecker.varInit(osnames, "osnames", 277, 10209, 10654);
            CallChecker.varInit(osName, "osName", 277, 10209, 10654);
            CallChecker.varInit(this.m_selectionFilter, "m_selectionFilter", 277, 10209, 10654);
            CallChecker.varInit(this.m_languages, "m_languages", 277, 10209, 10654);
            CallChecker.varInit(this.m_osversions, "m_osversions", 277, 10209, 10654);
            CallChecker.varInit(this.m_processors, "m_processors", 277, 10209, 10654);
            CallChecker.varInit(this.m_osnames, "m_osnames", 277, 10209, 10654);
            CallChecker.varInit(this.m_libraryEntries, "m_libraryEntries", 277, 10209, 10654);
            CallChecker.varInit(PROC_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALIASES", 277, 10209, 10654);
            CallChecker.varInit(OS_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_ALIASES", 277, 10209, 10654);
            CallChecker.varInit(PROC_SPARC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_SPARC", 277, 10209, 10654);
            CallChecker.varInit(PROC_POWER_PC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_POWER_PC", 277, 10209, 10654);
            CallChecker.varInit(PROC_PARISC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_PARISC", 277, 10209, 10654);
            CallChecker.varInit(PROC_MIPS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_MIPS", 277, 10209, 10654);
            CallChecker.varInit(PROC_IGNITE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_IGNITE", 277, 10209, 10654);
            CallChecker.varInit(PROC_ALPHA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALPHA", 277, 10209, 10654);
            CallChecker.varInit(PROC_ARM, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM", 277, 10209, 10654);
            CallChecker.varInit(PROC_ARM_BE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_BE", 277, 10209, 10654);
            CallChecker.varInit(PROC_ARM_LE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_LE", 277, 10209, 10654);
            CallChecker.varInit(PROC_68K, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_68K", 277, 10209, 10654);
            CallChecker.varInit(PROC_X86, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86", 277, 10209, 10654);
            CallChecker.varInit(PROC_X86_64, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86_64", 277, 10209, 10654);
            CallChecker.varInit(OS_WIN_32, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WIN_32", 277, 10209, 10654);
            CallChecker.varInit(OS_WINDOWS_XP, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_XP", 277, 10209, 10654);
            CallChecker.varInit(OS_WINDOWS_VISTA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_VISTA", 277, 10209, 10654);
            CallChecker.varInit(OS_WINDOWS_SERVER_2012, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2012", 277, 10209, 10654);
            CallChecker.varInit(OS_WINDOWS_SERVER_2008, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2008", 277, 10209, 10654);
            CallChecker.varInit(OS_WINDOWS_NT, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_NT", 277, 10209, 10654);
            CallChecker.varInit(OS_WINDOWS_CE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_CE", 277, 10209, 10654);
            CallChecker.varInit(OS_WINDOWS_98, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_98", 277, 10209, 10654);
            CallChecker.varInit(OS_WINDOWS_95, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_95", 277, 10209, 10654);
            CallChecker.varInit(OS_WINDOWS_9, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_9", 277, 10209, 10654);
            CallChecker.varInit(OS_WINDOWS_8, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_8", 277, 10209, 10654);
            CallChecker.varInit(OS_WINDOWS_7, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_7", 277, 10209, 10654);
            CallChecker.varInit(OS_WINDOWS_2003, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2003", 277, 10209, 10654);
            CallChecker.varInit(OS_WINDOWS_2000, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2000", 277, 10209, 10654);
            CallChecker.varInit(OS_VXWORKS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_VXWORKS", 277, 10209, 10654);
            CallChecker.varInit(OS_SUNOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SUNOS", 277, 10209, 10654);
            CallChecker.varInit(OS_SOLARIS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SOLARIS", 277, 10209, 10654);
            CallChecker.varInit(OS_QNX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_QNX", 277, 10209, 10654);
            CallChecker.varInit(OS_OS2, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OS2", 277, 10209, 10654);
            CallChecker.varInit(OS_OPENBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OPENBSD", 277, 10209, 10654);
            CallChecker.varInit(OS_NETWARE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETWARE", 277, 10209, 10654);
            CallChecker.varInit(OS_NETBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETBSD", 277, 10209, 10654);
            CallChecker.varInit(OS_MACOSX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOSX", 277, 10209, 10654);
            CallChecker.varInit(OS_MACOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOS", 277, 10209, 10654);
            CallChecker.varInit(OS_LINUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_LINUX", 277, 10209, 10654);
            CallChecker.varInit(OS_IRIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_IRIX", 277, 10209, 10654);
            CallChecker.varInit(OS_HPUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_HPUX", 277, 10209, 10654);
            CallChecker.varInit(OS_EPOC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_EPOC", 277, 10209, 10654);
            CallChecker.varInit(OS_DIGITALUNIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_DIGITALUNIX", 277, 10209, 10654);
            CallChecker.varInit(OS_AIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_AIX", 277, 10209, 10654);
            List<String> capabilityOsNames = CallChecker.varInit(NativeLibraryClause.getOsNameWithAliases(osName), "capabilityOsNames", 279, 10285, 10346);
            if ((capabilityOsNames != null) && (osnames != null)) {
                for (String curOsName : osnames) {
                    if (capabilityOsNames.contains(curOsName)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1766.methodEnd();
        }
    }

    private boolean checkProcessors(String processorName, String[] processors) {
        MethodContext _bcornu_methode_context1767 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 294, 10661, 11163);
            CallChecker.varInit(processors, "processors", 294, 10661, 11163);
            CallChecker.varInit(processorName, "processorName", 294, 10661, 11163);
            CallChecker.varInit(this.m_selectionFilter, "m_selectionFilter", 294, 10661, 11163);
            CallChecker.varInit(this.m_languages, "m_languages", 294, 10661, 11163);
            CallChecker.varInit(this.m_osversions, "m_osversions", 294, 10661, 11163);
            CallChecker.varInit(this.m_processors, "m_processors", 294, 10661, 11163);
            CallChecker.varInit(this.m_osnames, "m_osnames", 294, 10661, 11163);
            CallChecker.varInit(this.m_libraryEntries, "m_libraryEntries", 294, 10661, 11163);
            CallChecker.varInit(PROC_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALIASES", 294, 10661, 11163);
            CallChecker.varInit(OS_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_ALIASES", 294, 10661, 11163);
            CallChecker.varInit(PROC_SPARC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_SPARC", 294, 10661, 11163);
            CallChecker.varInit(PROC_POWER_PC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_POWER_PC", 294, 10661, 11163);
            CallChecker.varInit(PROC_PARISC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_PARISC", 294, 10661, 11163);
            CallChecker.varInit(PROC_MIPS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_MIPS", 294, 10661, 11163);
            CallChecker.varInit(PROC_IGNITE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_IGNITE", 294, 10661, 11163);
            CallChecker.varInit(PROC_ALPHA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALPHA", 294, 10661, 11163);
            CallChecker.varInit(PROC_ARM, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM", 294, 10661, 11163);
            CallChecker.varInit(PROC_ARM_BE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_BE", 294, 10661, 11163);
            CallChecker.varInit(PROC_ARM_LE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_LE", 294, 10661, 11163);
            CallChecker.varInit(PROC_68K, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_68K", 294, 10661, 11163);
            CallChecker.varInit(PROC_X86, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86", 294, 10661, 11163);
            CallChecker.varInit(PROC_X86_64, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86_64", 294, 10661, 11163);
            CallChecker.varInit(OS_WIN_32, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WIN_32", 294, 10661, 11163);
            CallChecker.varInit(OS_WINDOWS_XP, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_XP", 294, 10661, 11163);
            CallChecker.varInit(OS_WINDOWS_VISTA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_VISTA", 294, 10661, 11163);
            CallChecker.varInit(OS_WINDOWS_SERVER_2012, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2012", 294, 10661, 11163);
            CallChecker.varInit(OS_WINDOWS_SERVER_2008, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2008", 294, 10661, 11163);
            CallChecker.varInit(OS_WINDOWS_NT, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_NT", 294, 10661, 11163);
            CallChecker.varInit(OS_WINDOWS_CE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_CE", 294, 10661, 11163);
            CallChecker.varInit(OS_WINDOWS_98, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_98", 294, 10661, 11163);
            CallChecker.varInit(OS_WINDOWS_95, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_95", 294, 10661, 11163);
            CallChecker.varInit(OS_WINDOWS_9, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_9", 294, 10661, 11163);
            CallChecker.varInit(OS_WINDOWS_8, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_8", 294, 10661, 11163);
            CallChecker.varInit(OS_WINDOWS_7, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_7", 294, 10661, 11163);
            CallChecker.varInit(OS_WINDOWS_2003, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2003", 294, 10661, 11163);
            CallChecker.varInit(OS_WINDOWS_2000, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2000", 294, 10661, 11163);
            CallChecker.varInit(OS_VXWORKS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_VXWORKS", 294, 10661, 11163);
            CallChecker.varInit(OS_SUNOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SUNOS", 294, 10661, 11163);
            CallChecker.varInit(OS_SOLARIS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SOLARIS", 294, 10661, 11163);
            CallChecker.varInit(OS_QNX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_QNX", 294, 10661, 11163);
            CallChecker.varInit(OS_OS2, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OS2", 294, 10661, 11163);
            CallChecker.varInit(OS_OPENBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OPENBSD", 294, 10661, 11163);
            CallChecker.varInit(OS_NETWARE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETWARE", 294, 10661, 11163);
            CallChecker.varInit(OS_NETBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETBSD", 294, 10661, 11163);
            CallChecker.varInit(OS_MACOSX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOSX", 294, 10661, 11163);
            CallChecker.varInit(OS_MACOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOS", 294, 10661, 11163);
            CallChecker.varInit(OS_LINUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_LINUX", 294, 10661, 11163);
            CallChecker.varInit(OS_IRIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_IRIX", 294, 10661, 11163);
            CallChecker.varInit(OS_HPUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_HPUX", 294, 10661, 11163);
            CallChecker.varInit(OS_EPOC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_EPOC", 294, 10661, 11163);
            CallChecker.varInit(OS_DIGITALUNIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_DIGITALUNIX", 294, 10661, 11163);
            CallChecker.varInit(OS_AIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_AIX", 294, 10661, 11163);
            List<String> capabilitiesProcessors = CallChecker.varInit(NativeLibraryClause.getProcessorWithAliases(processorName), "capabilitiesProcessors", 296, 10750, 10826);
            if ((capabilitiesProcessors != null) && (processors != null)) {
                for (String currentProcessor : processors) {
                    if (capabilitiesProcessors.contains(currentProcessor)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1767.methodEnd();
        }
    }

    private boolean checkOSVersions(String osVersion, String[] osversions) throws BundleException {
        MethodContext _bcornu_methode_context1768 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 310, 11170, 11905);
            CallChecker.varInit(osversions, "osversions", 310, 11170, 11905);
            CallChecker.varInit(osVersion, "osVersion", 310, 11170, 11905);
            CallChecker.varInit(this.m_selectionFilter, "m_selectionFilter", 310, 11170, 11905);
            CallChecker.varInit(this.m_languages, "m_languages", 310, 11170, 11905);
            CallChecker.varInit(this.m_osversions, "m_osversions", 310, 11170, 11905);
            CallChecker.varInit(this.m_processors, "m_processors", 310, 11170, 11905);
            CallChecker.varInit(this.m_osnames, "m_osnames", 310, 11170, 11905);
            CallChecker.varInit(this.m_libraryEntries, "m_libraryEntries", 310, 11170, 11905);
            CallChecker.varInit(PROC_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALIASES", 310, 11170, 11905);
            CallChecker.varInit(OS_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_ALIASES", 310, 11170, 11905);
            CallChecker.varInit(PROC_SPARC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_SPARC", 310, 11170, 11905);
            CallChecker.varInit(PROC_POWER_PC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_POWER_PC", 310, 11170, 11905);
            CallChecker.varInit(PROC_PARISC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_PARISC", 310, 11170, 11905);
            CallChecker.varInit(PROC_MIPS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_MIPS", 310, 11170, 11905);
            CallChecker.varInit(PROC_IGNITE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_IGNITE", 310, 11170, 11905);
            CallChecker.varInit(PROC_ALPHA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALPHA", 310, 11170, 11905);
            CallChecker.varInit(PROC_ARM, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM", 310, 11170, 11905);
            CallChecker.varInit(PROC_ARM_BE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_BE", 310, 11170, 11905);
            CallChecker.varInit(PROC_ARM_LE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_LE", 310, 11170, 11905);
            CallChecker.varInit(PROC_68K, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_68K", 310, 11170, 11905);
            CallChecker.varInit(PROC_X86, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86", 310, 11170, 11905);
            CallChecker.varInit(PROC_X86_64, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86_64", 310, 11170, 11905);
            CallChecker.varInit(OS_WIN_32, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WIN_32", 310, 11170, 11905);
            CallChecker.varInit(OS_WINDOWS_XP, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_XP", 310, 11170, 11905);
            CallChecker.varInit(OS_WINDOWS_VISTA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_VISTA", 310, 11170, 11905);
            CallChecker.varInit(OS_WINDOWS_SERVER_2012, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2012", 310, 11170, 11905);
            CallChecker.varInit(OS_WINDOWS_SERVER_2008, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2008", 310, 11170, 11905);
            CallChecker.varInit(OS_WINDOWS_NT, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_NT", 310, 11170, 11905);
            CallChecker.varInit(OS_WINDOWS_CE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_CE", 310, 11170, 11905);
            CallChecker.varInit(OS_WINDOWS_98, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_98", 310, 11170, 11905);
            CallChecker.varInit(OS_WINDOWS_95, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_95", 310, 11170, 11905);
            CallChecker.varInit(OS_WINDOWS_9, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_9", 310, 11170, 11905);
            CallChecker.varInit(OS_WINDOWS_8, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_8", 310, 11170, 11905);
            CallChecker.varInit(OS_WINDOWS_7, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_7", 310, 11170, 11905);
            CallChecker.varInit(OS_WINDOWS_2003, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2003", 310, 11170, 11905);
            CallChecker.varInit(OS_WINDOWS_2000, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2000", 310, 11170, 11905);
            CallChecker.varInit(OS_VXWORKS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_VXWORKS", 310, 11170, 11905);
            CallChecker.varInit(OS_SUNOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SUNOS", 310, 11170, 11905);
            CallChecker.varInit(OS_SOLARIS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SOLARIS", 310, 11170, 11905);
            CallChecker.varInit(OS_QNX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_QNX", 310, 11170, 11905);
            CallChecker.varInit(OS_OS2, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OS2", 310, 11170, 11905);
            CallChecker.varInit(OS_OPENBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OPENBSD", 310, 11170, 11905);
            CallChecker.varInit(OS_NETWARE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETWARE", 310, 11170, 11905);
            CallChecker.varInit(OS_NETBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETBSD", 310, 11170, 11905);
            CallChecker.varInit(OS_MACOSX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOSX", 310, 11170, 11905);
            CallChecker.varInit(OS_MACOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOS", 310, 11170, 11905);
            CallChecker.varInit(OS_LINUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_LINUX", 310, 11170, 11905);
            CallChecker.varInit(OS_IRIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_IRIX", 310, 11170, 11905);
            CallChecker.varInit(OS_HPUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_HPUX", 310, 11170, 11905);
            CallChecker.varInit(OS_EPOC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_EPOC", 310, 11170, 11905);
            CallChecker.varInit(OS_DIGITALUNIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_DIGITALUNIX", 310, 11170, 11905);
            CallChecker.varInit(OS_AIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_AIX", 310, 11170, 11905);
            Version currentOSVersion = CallChecker.varInit(Version.parseVersion(NativeLibraryClause.formatOSVersion(osVersion)), "currentOSVersion", 313, 11287, 11362);
            osversions = CallChecker.beforeCalled(osversions, String[].class, 314, 11417, 11426);
            for (int i = 0; (osversions != null) && (i < (CallChecker.isCalled(osversions, String[].class, 314, 11417, 11426).length)); i++) {
                TryContext _bcornu_try_context_476 = new TryContext(476, NativeLibraryClause.class, "java.lang.Exception");
                try {
                    VersionRange range = CallChecker.varInit(VersionRange.parse(osversions[i]), "range", 318, 11498, 11552);
                    if (CallChecker.beforeDeref(range, VersionRange.class, 319, 11574, 11578)) {
                        range = CallChecker.beforeCalled(range, VersionRange.class, 319, 11574, 11578);
                        if (CallChecker.isCalled(range, VersionRange.class, 319, 11574, 11578).isInRange(currentOSVersion)) {
                            return true;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                } catch (Exception ex) {
                    _bcornu_try_context_476.catchStart(476);
                    throw new BundleException(("Error evaluating osversion: " + (osversions[i])), ex);
                } finally {
                    _bcornu_try_context_476.finallyStart(476);
                }
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1768.methodEnd();
        }
    }

    private boolean checkLanguages(String currentLanguage, String[] languages) {
        MethodContext _bcornu_methode_context1769 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 333, 11912, 12226);
            CallChecker.varInit(languages, "languages", 333, 11912, 12226);
            CallChecker.varInit(currentLanguage, "currentLanguage", 333, 11912, 12226);
            CallChecker.varInit(this.m_selectionFilter, "m_selectionFilter", 333, 11912, 12226);
            CallChecker.varInit(this.m_languages, "m_languages", 333, 11912, 12226);
            CallChecker.varInit(this.m_osversions, "m_osversions", 333, 11912, 12226);
            CallChecker.varInit(this.m_processors, "m_processors", 333, 11912, 12226);
            CallChecker.varInit(this.m_osnames, "m_osnames", 333, 11912, 12226);
            CallChecker.varInit(this.m_libraryEntries, "m_libraryEntries", 333, 11912, 12226);
            CallChecker.varInit(PROC_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALIASES", 333, 11912, 12226);
            CallChecker.varInit(OS_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_ALIASES", 333, 11912, 12226);
            CallChecker.varInit(PROC_SPARC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_SPARC", 333, 11912, 12226);
            CallChecker.varInit(PROC_POWER_PC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_POWER_PC", 333, 11912, 12226);
            CallChecker.varInit(PROC_PARISC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_PARISC", 333, 11912, 12226);
            CallChecker.varInit(PROC_MIPS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_MIPS", 333, 11912, 12226);
            CallChecker.varInit(PROC_IGNITE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_IGNITE", 333, 11912, 12226);
            CallChecker.varInit(PROC_ALPHA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALPHA", 333, 11912, 12226);
            CallChecker.varInit(PROC_ARM, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM", 333, 11912, 12226);
            CallChecker.varInit(PROC_ARM_BE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_BE", 333, 11912, 12226);
            CallChecker.varInit(PROC_ARM_LE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_LE", 333, 11912, 12226);
            CallChecker.varInit(PROC_68K, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_68K", 333, 11912, 12226);
            CallChecker.varInit(PROC_X86, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86", 333, 11912, 12226);
            CallChecker.varInit(PROC_X86_64, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86_64", 333, 11912, 12226);
            CallChecker.varInit(OS_WIN_32, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WIN_32", 333, 11912, 12226);
            CallChecker.varInit(OS_WINDOWS_XP, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_XP", 333, 11912, 12226);
            CallChecker.varInit(OS_WINDOWS_VISTA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_VISTA", 333, 11912, 12226);
            CallChecker.varInit(OS_WINDOWS_SERVER_2012, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2012", 333, 11912, 12226);
            CallChecker.varInit(OS_WINDOWS_SERVER_2008, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2008", 333, 11912, 12226);
            CallChecker.varInit(OS_WINDOWS_NT, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_NT", 333, 11912, 12226);
            CallChecker.varInit(OS_WINDOWS_CE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_CE", 333, 11912, 12226);
            CallChecker.varInit(OS_WINDOWS_98, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_98", 333, 11912, 12226);
            CallChecker.varInit(OS_WINDOWS_95, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_95", 333, 11912, 12226);
            CallChecker.varInit(OS_WINDOWS_9, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_9", 333, 11912, 12226);
            CallChecker.varInit(OS_WINDOWS_8, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_8", 333, 11912, 12226);
            CallChecker.varInit(OS_WINDOWS_7, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_7", 333, 11912, 12226);
            CallChecker.varInit(OS_WINDOWS_2003, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2003", 333, 11912, 12226);
            CallChecker.varInit(OS_WINDOWS_2000, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2000", 333, 11912, 12226);
            CallChecker.varInit(OS_VXWORKS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_VXWORKS", 333, 11912, 12226);
            CallChecker.varInit(OS_SUNOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SUNOS", 333, 11912, 12226);
            CallChecker.varInit(OS_SOLARIS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SOLARIS", 333, 11912, 12226);
            CallChecker.varInit(OS_QNX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_QNX", 333, 11912, 12226);
            CallChecker.varInit(OS_OS2, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OS2", 333, 11912, 12226);
            CallChecker.varInit(OS_OPENBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OPENBSD", 333, 11912, 12226);
            CallChecker.varInit(OS_NETWARE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETWARE", 333, 11912, 12226);
            CallChecker.varInit(OS_NETBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETBSD", 333, 11912, 12226);
            CallChecker.varInit(OS_MACOSX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOSX", 333, 11912, 12226);
            CallChecker.varInit(OS_MACOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOS", 333, 11912, 12226);
            CallChecker.varInit(OS_LINUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_LINUX", 333, 11912, 12226);
            CallChecker.varInit(OS_IRIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_IRIX", 333, 11912, 12226);
            CallChecker.varInit(OS_HPUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_HPUX", 333, 11912, 12226);
            CallChecker.varInit(OS_EPOC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_EPOC", 333, 11912, 12226);
            CallChecker.varInit(OS_DIGITALUNIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_DIGITALUNIX", 333, 11912, 12226);
            CallChecker.varInit(OS_AIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_AIX", 333, 11912, 12226);
            languages = CallChecker.beforeCalled(languages, String[].class, 335, 12045, 12053);
            for (int i = 0; (languages != null) && (i < (CallChecker.isCalled(languages, String[].class, 335, 12045, 12053).length)); i++) {
                languages = CallChecker.beforeCalled(languages, String[].class, 337, 12095, 12103);
                if (CallChecker.beforeDeref(CallChecker.isCalled(languages, String[].class, 337, 12095, 12103)[i], String.class, 337, 12095, 12106)) {
                    languages[i] = CallChecker.beforeCalled(languages[i], String.class, 337, 12095, 12106);
                    if (CallChecker.isCalled(languages[i], String.class, 337, 12095, 12106).equals(currentLanguage)) {
                        return true;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1769.methodEnd();
        }
    }

    private boolean checkSelectionFilter(Map configMap, String expr) throws BundleException {
        MethodContext _bcornu_methode_context1770 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 345, 12233, 12915);
            CallChecker.varInit(expr, "expr", 345, 12233, 12915);
            CallChecker.varInit(configMap, "configMap", 345, 12233, 12915);
            CallChecker.varInit(this.m_selectionFilter, "m_selectionFilter", 345, 12233, 12915);
            CallChecker.varInit(this.m_languages, "m_languages", 345, 12233, 12915);
            CallChecker.varInit(this.m_osversions, "m_osversions", 345, 12233, 12915);
            CallChecker.varInit(this.m_processors, "m_processors", 345, 12233, 12915);
            CallChecker.varInit(this.m_osnames, "m_osnames", 345, 12233, 12915);
            CallChecker.varInit(this.m_libraryEntries, "m_libraryEntries", 345, 12233, 12915);
            CallChecker.varInit(PROC_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALIASES", 345, 12233, 12915);
            CallChecker.varInit(OS_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_ALIASES", 345, 12233, 12915);
            CallChecker.varInit(PROC_SPARC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_SPARC", 345, 12233, 12915);
            CallChecker.varInit(PROC_POWER_PC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_POWER_PC", 345, 12233, 12915);
            CallChecker.varInit(PROC_PARISC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_PARISC", 345, 12233, 12915);
            CallChecker.varInit(PROC_MIPS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_MIPS", 345, 12233, 12915);
            CallChecker.varInit(PROC_IGNITE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_IGNITE", 345, 12233, 12915);
            CallChecker.varInit(PROC_ALPHA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALPHA", 345, 12233, 12915);
            CallChecker.varInit(PROC_ARM, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM", 345, 12233, 12915);
            CallChecker.varInit(PROC_ARM_BE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_BE", 345, 12233, 12915);
            CallChecker.varInit(PROC_ARM_LE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_LE", 345, 12233, 12915);
            CallChecker.varInit(PROC_68K, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_68K", 345, 12233, 12915);
            CallChecker.varInit(PROC_X86, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86", 345, 12233, 12915);
            CallChecker.varInit(PROC_X86_64, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86_64", 345, 12233, 12915);
            CallChecker.varInit(OS_WIN_32, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WIN_32", 345, 12233, 12915);
            CallChecker.varInit(OS_WINDOWS_XP, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_XP", 345, 12233, 12915);
            CallChecker.varInit(OS_WINDOWS_VISTA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_VISTA", 345, 12233, 12915);
            CallChecker.varInit(OS_WINDOWS_SERVER_2012, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2012", 345, 12233, 12915);
            CallChecker.varInit(OS_WINDOWS_SERVER_2008, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2008", 345, 12233, 12915);
            CallChecker.varInit(OS_WINDOWS_NT, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_NT", 345, 12233, 12915);
            CallChecker.varInit(OS_WINDOWS_CE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_CE", 345, 12233, 12915);
            CallChecker.varInit(OS_WINDOWS_98, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_98", 345, 12233, 12915);
            CallChecker.varInit(OS_WINDOWS_95, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_95", 345, 12233, 12915);
            CallChecker.varInit(OS_WINDOWS_9, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_9", 345, 12233, 12915);
            CallChecker.varInit(OS_WINDOWS_8, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_8", 345, 12233, 12915);
            CallChecker.varInit(OS_WINDOWS_7, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_7", 345, 12233, 12915);
            CallChecker.varInit(OS_WINDOWS_2003, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2003", 345, 12233, 12915);
            CallChecker.varInit(OS_WINDOWS_2000, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2000", 345, 12233, 12915);
            CallChecker.varInit(OS_VXWORKS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_VXWORKS", 345, 12233, 12915);
            CallChecker.varInit(OS_SUNOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SUNOS", 345, 12233, 12915);
            CallChecker.varInit(OS_SOLARIS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SOLARIS", 345, 12233, 12915);
            CallChecker.varInit(OS_QNX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_QNX", 345, 12233, 12915);
            CallChecker.varInit(OS_OS2, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OS2", 345, 12233, 12915);
            CallChecker.varInit(OS_OPENBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OPENBSD", 345, 12233, 12915);
            CallChecker.varInit(OS_NETWARE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETWARE", 345, 12233, 12915);
            CallChecker.varInit(OS_NETBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETBSD", 345, 12233, 12915);
            CallChecker.varInit(OS_MACOSX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOSX", 345, 12233, 12915);
            CallChecker.varInit(OS_MACOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOS", 345, 12233, 12915);
            CallChecker.varInit(OS_LINUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_LINUX", 345, 12233, 12915);
            CallChecker.varInit(OS_IRIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_IRIX", 345, 12233, 12915);
            CallChecker.varInit(OS_HPUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_HPUX", 345, 12233, 12915);
            CallChecker.varInit(OS_EPOC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_EPOC", 345, 12233, 12915);
            CallChecker.varInit(OS_DIGITALUNIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_DIGITALUNIX", 345, 12233, 12915);
            CallChecker.varInit(OS_AIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_AIX", 345, 12233, 12915);
            Dictionary dict = CallChecker.varInit(new Hashtable(), "dict", 349, 12383, 12416);
            configMap = CallChecker.beforeCalled(configMap, Map.class, 350, 12444, 12452);
            for (Iterator i = CallChecker.isCalled(CallChecker.isCalled(configMap, Map.class, 350, 12444, 12452).keySet(), Set.class, 350, 12444, 12461).iterator(); CallChecker.isCalled(i, Iterator.class, 350, 12475, 12475).hasNext();) {
                Object key = CallChecker.init(Object.class);
                if (CallChecker.beforeDeref(i, Iterator.class, 352, 12525, 12525)) {
                    key = CallChecker.isCalled(i, Iterator.class, 352, 12525, 12525).next();
                    CallChecker.varAssign(key, "key", 352, 12525, 12525);
                }
                if (CallChecker.beforeDeref(configMap, Map.class, 353, 12561, 12569)) {
                    if (CallChecker.beforeDeref(dict, Dictionary.class, 353, 12547, 12550)) {
                        configMap = CallChecker.beforeCalled(configMap, Map.class, 353, 12561, 12569);
                        dict = CallChecker.beforeCalled(dict, Dictionary.class, 353, 12547, 12550);
                        CallChecker.isCalled(dict, Dictionary.class, 353, 12547, 12550).put(key, CallChecker.isCalled(configMap, Map.class, 353, 12561, 12569).get(key));
                    }
                }
            }
            TryContext _bcornu_try_context_477 = new TryContext(477, NativeLibraryClause.class, "java.lang.Exception");
            try {
                Filter filter = CallChecker.varInit(FrameworkUtil.createFilter(expr), "filter", 358, 12656, 12704);
                if (CallChecker.beforeDeref(filter, Filter.class, 359, 12725, 12730)) {
                    filter = CallChecker.beforeCalled(filter, Filter.class, 359, 12725, 12730);
                    return CallChecker.isCalled(filter, Filter.class, 359, 12725, 12730).match(dict);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (Exception ex) {
                _bcornu_try_context_477.catchStart(477);
                throw new BundleException(("Error evaluating filter expression: " + expr), ex);
            } finally {
                _bcornu_try_context_477.finallyStart(477);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1770.methodEnd();
        }
    }

    public static NativeLibraryClause parse(Logger logger, String s) {
        MethodContext _bcornu_methode_context1771 = new MethodContext(NativeLibraryClause.class);
        try {
            CallChecker.varInit(s, "s", 368, 12922, 18207);
            CallChecker.varInit(logger, "logger", 368, 12922, 18207);
            CallChecker.varInit(PROC_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALIASES", 368, 12922, 18207);
            CallChecker.varInit(OS_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_ALIASES", 368, 12922, 18207);
            CallChecker.varInit(PROC_SPARC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_SPARC", 368, 12922, 18207);
            CallChecker.varInit(PROC_POWER_PC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_POWER_PC", 368, 12922, 18207);
            CallChecker.varInit(PROC_PARISC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_PARISC", 368, 12922, 18207);
            CallChecker.varInit(PROC_MIPS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_MIPS", 368, 12922, 18207);
            CallChecker.varInit(PROC_IGNITE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_IGNITE", 368, 12922, 18207);
            CallChecker.varInit(PROC_ALPHA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALPHA", 368, 12922, 18207);
            CallChecker.varInit(PROC_ARM, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM", 368, 12922, 18207);
            CallChecker.varInit(PROC_ARM_BE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_BE", 368, 12922, 18207);
            CallChecker.varInit(PROC_ARM_LE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_LE", 368, 12922, 18207);
            CallChecker.varInit(PROC_68K, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_68K", 368, 12922, 18207);
            CallChecker.varInit(PROC_X86, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86", 368, 12922, 18207);
            CallChecker.varInit(PROC_X86_64, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86_64", 368, 12922, 18207);
            CallChecker.varInit(OS_WIN_32, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WIN_32", 368, 12922, 18207);
            CallChecker.varInit(OS_WINDOWS_XP, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_XP", 368, 12922, 18207);
            CallChecker.varInit(OS_WINDOWS_VISTA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_VISTA", 368, 12922, 18207);
            CallChecker.varInit(OS_WINDOWS_SERVER_2012, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2012", 368, 12922, 18207);
            CallChecker.varInit(OS_WINDOWS_SERVER_2008, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2008", 368, 12922, 18207);
            CallChecker.varInit(OS_WINDOWS_NT, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_NT", 368, 12922, 18207);
            CallChecker.varInit(OS_WINDOWS_CE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_CE", 368, 12922, 18207);
            CallChecker.varInit(OS_WINDOWS_98, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_98", 368, 12922, 18207);
            CallChecker.varInit(OS_WINDOWS_95, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_95", 368, 12922, 18207);
            CallChecker.varInit(OS_WINDOWS_9, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_9", 368, 12922, 18207);
            CallChecker.varInit(OS_WINDOWS_8, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_8", 368, 12922, 18207);
            CallChecker.varInit(OS_WINDOWS_7, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_7", 368, 12922, 18207);
            CallChecker.varInit(OS_WINDOWS_2003, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2003", 368, 12922, 18207);
            CallChecker.varInit(OS_WINDOWS_2000, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2000", 368, 12922, 18207);
            CallChecker.varInit(OS_VXWORKS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_VXWORKS", 368, 12922, 18207);
            CallChecker.varInit(OS_SUNOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SUNOS", 368, 12922, 18207);
            CallChecker.varInit(OS_SOLARIS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SOLARIS", 368, 12922, 18207);
            CallChecker.varInit(OS_QNX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_QNX", 368, 12922, 18207);
            CallChecker.varInit(OS_OS2, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OS2", 368, 12922, 18207);
            CallChecker.varInit(OS_OPENBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OPENBSD", 368, 12922, 18207);
            CallChecker.varInit(OS_NETWARE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETWARE", 368, 12922, 18207);
            CallChecker.varInit(OS_NETBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETBSD", 368, 12922, 18207);
            CallChecker.varInit(OS_MACOSX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOSX", 368, 12922, 18207);
            CallChecker.varInit(OS_MACOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOS", 368, 12922, 18207);
            CallChecker.varInit(OS_LINUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_LINUX", 368, 12922, 18207);
            CallChecker.varInit(OS_IRIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_IRIX", 368, 12922, 18207);
            CallChecker.varInit(OS_HPUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_HPUX", 368, 12922, 18207);
            CallChecker.varInit(OS_EPOC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_EPOC", 368, 12922, 18207);
            CallChecker.varInit(OS_DIGITALUNIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_DIGITALUNIX", 368, 12922, 18207);
            CallChecker.varInit(OS_AIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_AIX", 368, 12922, 18207);
            TryContext _bcornu_try_context_478 = new TryContext(478, NativeLibraryClause.class, "java.lang.RuntimeException");
            try {
                if ((s == null) || ((s.length()) == 0)) {
                    return null;
                }
                s = s.trim();
                CallChecker.varAssign(s, "s", 377, 13135, 13147);
                if (s.equals(FelixConstants.BUNDLE_NATIVECODE_OPTIONAL)) {
                    return new NativeLibraryClause(null, null, null, null, null, null);
                }
                StringTokenizer st = CallChecker.varInit(new StringTokenizer(s, ";"), "st", 386, 13512, 13560);
                String[] libEntries = CallChecker.init(String[].class);
                if (CallChecker.beforeDeref(st, StringTokenizer.class, 387, 13607, 13608)) {
                    st = CallChecker.beforeCalled(st, StringTokenizer.class, 387, 13607, 13608);
                    libEntries = new String[CallChecker.isCalled(st, StringTokenizer.class, 387, 13607, 13608).countTokens()];
                    CallChecker.varAssign(libEntries, "libEntries", 387, 13607, 13608);
                }
                List osNameList = CallChecker.varInit(new ArrayList(), "osNameList", 388, 13638, 13671);
                List osVersionList = CallChecker.varInit(new ArrayList(), "osVersionList", 389, 13685, 13721);
                List processorList = CallChecker.varInit(new ArrayList(), "processorList", 390, 13735, 13771);
                List languageList = CallChecker.varInit(new ArrayList(), "languageList", 391, 13785, 13820);
                String selectionFilter = CallChecker.varInit(null, "selectionFilter", 392, 13834, 13863);
                int libCount = CallChecker.varInit(((int) (0)), "libCount", 393, 13877, 13893);
                st = CallChecker.beforeCalled(st, StringTokenizer.class, 394, 13914, 13915);
                while (CallChecker.isCalled(st, StringTokenizer.class, 394, 13914, 13915).hasMoreTokens()) {
                    String token = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(st, StringTokenizer.class, 396, 13979, 13980)) {
                        st = CallChecker.beforeCalled(st, StringTokenizer.class, 396, 13979, 13980);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(st, StringTokenizer.class, 396, 13979, 13980).nextToken(), String.class, 396, 13979, 13992)) {
                            st = CallChecker.beforeCalled(st, StringTokenizer.class, 396, 13979, 13980);
                            token = CallChecker.isCalled(CallChecker.isCalled(st, StringTokenizer.class, 396, 13979, 13980).nextToken(), String.class, 396, 13979, 13992).trim();
                            CallChecker.varAssign(token, "token", 396, 13979, 13980);
                        }
                    }
                    if (CallChecker.beforeDeref(token, String.class, 397, 14022, 14026)) {
                        token = CallChecker.beforeCalled(token, String.class, 397, 14022, 14026);
                        if ((CallChecker.isCalled(token, String.class, 397, 14022, 14026).indexOf('=')) < 0) {
                            if (CallChecker.beforeDeref(token, String.class, 400, 14163, 14167)) {
                                token = CallChecker.beforeCalled(token, String.class, 400, 14163, 14167);
                                if ((CallChecker.isCalled(token, String.class, 400, 14163, 14167).charAt(0)) == '/') {
                                    if (CallChecker.beforeDeref(libEntries, String[].class, 400, 14139, 14148)) {
                                        if (CallChecker.beforeDeref(token, String.class, 401, 14213, 14217)) {
                                            libEntries = CallChecker.beforeCalled(libEntries, String[].class, 400, 14139, 14148);
                                            token = CallChecker.beforeCalled(token, String.class, 401, 14213, 14217);
                                            CallChecker.isCalled(libEntries, String[].class, 400, 14139, 14148)[libCount] = CallChecker.isCalled(token, String.class, 401, 14213, 14217).substring(1);
                                            CallChecker.varAssign(CallChecker.isCalled(libEntries, String[].class, 400, 14139, 14148)[libCount], "CallChecker.isCalled(libEntries, String[].class, 400, 14139, 14148)[libCount]", 400, 14139, 14263);
                                        }
                                    }
                                }else {
                                    if (CallChecker.beforeDeref(libEntries, String[].class, 400, 14139, 14148)) {
                                        libEntries = CallChecker.beforeCalled(libEntries, String[].class, 400, 14139, 14148);
                                        CallChecker.isCalled(libEntries, String[].class, 400, 14139, 14148)[libCount] = token;
                                        CallChecker.varAssign(CallChecker.isCalled(libEntries, String[].class, 400, 14139, 14148)[libCount], "CallChecker.isCalled(libEntries, String[].class, 400, 14139, 14148)[libCount]", 400, 14139, 14263);
                                    }
                                }
                            }
                            libCount++;
                        }else {
                            String property = CallChecker.varInit(null, "property", 412, 14747, 14769);
                            String value = CallChecker.varInit(null, "value", 413, 14791, 14810);
                            if (CallChecker.beforeDeref(token, String.class, 414, 14838, 14842)) {
                                token = CallChecker.beforeCalled(token, String.class, 414, 14838, 14842);
                                if (!((CallChecker.isCalled(token, String.class, 414, 14838, 14842).indexOf("=")) > 1)) {
                                    throw new IllegalArgumentException(("Bundle manifest native library entry malformed: " + token));
                                }else {
                                    if (CallChecker.beforeDeref(token, String.class, 421, 15158, 15162)) {
                                        if (CallChecker.beforeDeref(token, String.class, 421, 15139, 15143)) {
                                            token = CallChecker.beforeCalled(token, String.class, 421, 15158, 15162);
                                            token = CallChecker.beforeCalled(token, String.class, 421, 15139, 15143);
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(token, String.class, 421, 15139, 15143).substring(0, CallChecker.isCalled(token, String.class, 421, 15158, 15162).indexOf("=")), String.class, 421, 15138, 15177)) {
                                                token = CallChecker.beforeCalled(token, String.class, 421, 15158, 15162);
                                                token = CallChecker.beforeCalled(token, String.class, 421, 15139, 15143);
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(token, String.class, 421, 15139, 15143).substring(0, CallChecker.isCalled(token, String.class, 421, 15158, 15162).indexOf("=")), String.class, 421, 15138, 15177).trim(), String.class, 421, 15138, 15213)) {
                                                    token = CallChecker.beforeCalled(token, String.class, 421, 15158, 15162);
                                                    token = CallChecker.beforeCalled(token, String.class, 421, 15139, 15143);
                                                    property = CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(token, String.class, 421, 15139, 15143).substring(0, CallChecker.isCalled(token, String.class, 421, 15158, 15162).indexOf("=")), String.class, 421, 15138, 15177).trim(), String.class, 421, 15138, 15213).toLowerCase();
                                                    CallChecker.varAssign(property, "property", 421, 15127, 15228);
                                                }
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(token, String.class, 423, 15279, 15283)) {
                                        if (CallChecker.beforeDeref(token, String.class, 423, 15303, 15307)) {
                                            if (CallChecker.beforeDeref(token, String.class, 423, 15263, 15267)) {
                                                token = CallChecker.beforeCalled(token, String.class, 423, 15279, 15283);
                                                token = CallChecker.beforeCalled(token, String.class, 423, 15303, 15307);
                                                token = CallChecker.beforeCalled(token, String.class, 423, 15263, 15267);
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(token, String.class, 423, 15263, 15267).substring(((CallChecker.isCalled(token, String.class, 423, 15279, 15283).indexOf("=")) + 1), CallChecker.isCalled(token, String.class, 423, 15303, 15307).length()), String.class, 423, 15262, 15347)) {
                                                    token = CallChecker.beforeCalled(token, String.class, 423, 15279, 15283);
                                                    token = CallChecker.beforeCalled(token, String.class, 423, 15303, 15307);
                                                    token = CallChecker.beforeCalled(token, String.class, 423, 15263, 15267);
                                                    value = CallChecker.isCalled(CallChecker.isCalled(token, String.class, 423, 15263, 15267).substring(((CallChecker.isCalled(token, String.class, 423, 15279, 15283).indexOf("=")) + 1), CallChecker.isCalled(token, String.class, 423, 15303, 15307).length()), String.class, 423, 15262, 15347).trim();
                                                    CallChecker.varAssign(value, "value", 423, 15254, 15355);
                                                }
                                            }
                                        }
                                    }
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(value, String.class, 428, 15478, 15482)) {
                                value = CallChecker.beforeCalled(value, String.class, 428, 15478, 15482);
                                if ((CallChecker.isCalled(value, String.class, 428, 15478, 15482).charAt(0)) == '"') {
                                    if (CallChecker.beforeDeref(value, String.class, 433, 15753, 15757)) {
                                        if (CallChecker.beforeDeref(value, String.class, 433, 15740, 15744)) {
                                            value = CallChecker.beforeCalled(value, String.class, 433, 15753, 15757);
                                            value = CallChecker.beforeCalled(value, String.class, 433, 15740, 15744);
                                            if ((CallChecker.isCalled(value, String.class, 433, 15740, 15744).charAt(((CallChecker.isCalled(value, String.class, 433, 15753, 15757).length()) - 1))) == '"') {
                                                if (CallChecker.beforeDeref(value, String.class, 435, 15862, 15866)) {
                                                    if (CallChecker.beforeDeref(value, String.class, 435, 15843, 15847)) {
                                                        value = CallChecker.beforeCalled(value, String.class, 435, 15862, 15866);
                                                        value = CallChecker.beforeCalled(value, String.class, 435, 15843, 15847);
                                                        value = CallChecker.isCalled(value, String.class, 435, 15843, 15847).substring(1, ((CallChecker.isCalled(value, String.class, 435, 15862, 15866).length()) - 1));
                                                        CallChecker.varAssign(value, "value", 435, 15835, 15881);
                                                    }
                                                }
                                            }else {
                                                if (CallChecker.beforeDeref(value, String.class, 439, 16000, 16004)) {
                                                    value = CallChecker.beforeCalled(value, String.class, 439, 16000, 16004);
                                                    value = CallChecker.isCalled(value, String.class, 439, 16000, 16004).substring(1);
                                                    CallChecker.varAssign(value, "value", 439, 15992, 16018);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (value != null) {
                                value = value.toLowerCase();
                                CallChecker.varAssign(value, "value", 445, 16154, 16181);
                            }
                            if (CallChecker.beforeDeref(property, String.class, 449, 16303, 16310)) {
                                property = CallChecker.beforeCalled(property, String.class, 449, 16303, 16310);
                                if (CallChecker.isCalled(property, String.class, 449, 16303, 16310).equals(Constants.BUNDLE_NATIVECODE_OSNAME)) {
                                    if (CallChecker.beforeDeref(osNameList, List.class, 451, 16402, 16411)) {
                                        osNameList = CallChecker.beforeCalled(osNameList, List.class, 451, 16402, 16411);
                                        CallChecker.isCalled(osNameList, List.class, 451, 16402, 16411).add(value);
                                    }
                                }else
                                    if (CallChecker.beforeDeref(property, String.class, 453, 16476, 16483)) {
                                        property = CallChecker.beforeCalled(property, String.class, 453, 16476, 16483);
                                        if (CallChecker.isCalled(property, String.class, 453, 16476, 16483).equals(Constants.BUNDLE_NATIVECODE_OSVERSION)) {
                                            if (CallChecker.beforeDeref(osVersionList, List.class, 455, 16578, 16590)) {
                                                osVersionList = CallChecker.beforeCalled(osVersionList, List.class, 455, 16578, 16590);
                                                CallChecker.isCalled(osVersionList, List.class, 455, 16578, 16590).add(NativeLibraryClause.normalizeOSVersion(value));
                                            }
                                        }else
                                            if (CallChecker.beforeDeref(property, String.class, 457, 16675, 16682)) {
                                                property = CallChecker.beforeCalled(property, String.class, 457, 16675, 16682);
                                                if (CallChecker.isCalled(property, String.class, 457, 16675, 16682).equals(Constants.BUNDLE_NATIVECODE_PROCESSOR)) {
                                                    if (CallChecker.beforeDeref(processorList, List.class, 459, 16777, 16789)) {
                                                        processorList = CallChecker.beforeCalled(processorList, List.class, 459, 16777, 16789);
                                                        CallChecker.isCalled(processorList, List.class, 459, 16777, 16789).add(value);
                                                    }
                                                }else
                                                    if (CallChecker.beforeDeref(property, String.class, 461, 16854, 16861)) {
                                                        property = CallChecker.beforeCalled(property, String.class, 461, 16854, 16861);
                                                        if (CallChecker.isCalled(property, String.class, 461, 16854, 16861).equals(Constants.BUNDLE_NATIVECODE_LANGUAGE)) {
                                                            if (CallChecker.beforeDeref(languageList, List.class, 463, 16955, 16966)) {
                                                                languageList = CallChecker.beforeCalled(languageList, List.class, 463, 16955, 16966);
                                                                CallChecker.isCalled(languageList, List.class, 463, 16955, 16966).add(value);
                                                            }
                                                        }else
                                                            if (CallChecker.beforeDeref(property, String.class, 465, 17031, 17038)) {
                                                                property = CallChecker.beforeCalled(property, String.class, 465, 17031, 17038);
                                                                if (CallChecker.isCalled(property, String.class, 465, 17031, 17038).equals(Constants.SELECTION_FILTER_ATTRIBUTE)) {
                                                                    selectionFilter = value;
                                                                    CallChecker.varAssign(selectionFilter, "selectionFilter", 468, 17228, 17251);
                                                                }
                                                            }
                                                        
                                                    }
                                                
                                            }
                                        
                                    }
                                
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                } 
                if (libCount == 0) {
                    return null;
                }
                String[] actualLibEntries = CallChecker.varInit(new String[libCount], "actualLibEntries", 479, 17447, 17495);
                System.arraycopy(libEntries, 0, actualLibEntries, 0, libCount);
                if (CallChecker.beforeDeref(osNameList, List.class, 483, 17708, 17717)) {
                    if (CallChecker.beforeDeref(osNameList, List.class, 483, 17678, 17687)) {
                        if (CallChecker.beforeDeref(processorList, List.class, 484, 17789, 17801)) {
                            if (CallChecker.beforeDeref(processorList, List.class, 484, 17756, 17768)) {
                                if (CallChecker.beforeDeref(osVersionList, List.class, 485, 17873, 17885)) {
                                    if (CallChecker.beforeDeref(osVersionList, List.class, 485, 17840, 17852)) {
                                        if (CallChecker.beforeDeref(languageList, List.class, 486, 17956, 17967)) {
                                            if (CallChecker.beforeDeref(languageList, List.class, 486, 17924, 17935)) {
                                                osNameList = CallChecker.beforeCalled(osNameList, List.class, 483, 17708, 17717);
                                                osNameList = CallChecker.beforeCalled(osNameList, List.class, 483, 17678, 17687);
                                                processorList = CallChecker.beforeCalled(processorList, List.class, 484, 17789, 17801);
                                                processorList = CallChecker.beforeCalled(processorList, List.class, 484, 17756, 17768);
                                                osVersionList = CallChecker.beforeCalled(osVersionList, List.class, 485, 17873, 17885);
                                                osVersionList = CallChecker.beforeCalled(osVersionList, List.class, 485, 17840, 17852);
                                                languageList = CallChecker.beforeCalled(languageList, List.class, 486, 17956, 17967);
                                                languageList = CallChecker.beforeCalled(languageList, List.class, 486, 17924, 17935);
                                                return new NativeLibraryClause(actualLibEntries, ((String[]) (CallChecker.isCalled(osNameList, List.class, 483, 17678, 17687).toArray(new String[CallChecker.isCalled(osNameList, List.class, 483, 17708, 17717).size()]))), ((String[]) (CallChecker.isCalled(processorList, List.class, 484, 17756, 17768).toArray(new String[CallChecker.isCalled(processorList, List.class, 484, 17789, 17801).size()]))), ((String[]) (CallChecker.isCalled(osVersionList, List.class, 485, 17840, 17852).toArray(new String[CallChecker.isCalled(osVersionList, List.class, 485, 17873, 17885).size()]))), ((String[]) (CallChecker.isCalled(languageList, List.class, 486, 17924, 17935).toArray(new String[CallChecker.isCalled(languageList, List.class, 486, 17956, 17967).size()]))), selectionFilter);
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
                
            } catch (RuntimeException ex) {
                _bcornu_try_context_478.catchStart(478);
                if (CallChecker.beforeDeref(logger, Logger.class, 491, 18081, 18086)) {
                    logger = CallChecker.beforeCalled(logger, Logger.class, 491, 18081, 18086);
                    CallChecker.isCalled(logger, Logger.class, 491, 18081, 18086).log(Logger.LOG_ERROR, "Error parsing native library header.", ex);
                }
                throw ex;
            } finally {
                _bcornu_try_context_478.finallyStart(478);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((NativeLibraryClause) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1771.methodEnd();
        }
    }

    public static String formatOSVersion(String value) {
        MethodContext _bcornu_methode_context1772 = new MethodContext(String.class);
        try {
            CallChecker.varInit(value, "value", 497, 18214, 18838);
            CallChecker.varInit(PROC_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALIASES", 497, 18214, 18838);
            CallChecker.varInit(OS_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_ALIASES", 497, 18214, 18838);
            CallChecker.varInit(PROC_SPARC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_SPARC", 497, 18214, 18838);
            CallChecker.varInit(PROC_POWER_PC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_POWER_PC", 497, 18214, 18838);
            CallChecker.varInit(PROC_PARISC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_PARISC", 497, 18214, 18838);
            CallChecker.varInit(PROC_MIPS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_MIPS", 497, 18214, 18838);
            CallChecker.varInit(PROC_IGNITE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_IGNITE", 497, 18214, 18838);
            CallChecker.varInit(PROC_ALPHA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALPHA", 497, 18214, 18838);
            CallChecker.varInit(PROC_ARM, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM", 497, 18214, 18838);
            CallChecker.varInit(PROC_ARM_BE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_BE", 497, 18214, 18838);
            CallChecker.varInit(PROC_ARM_LE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_LE", 497, 18214, 18838);
            CallChecker.varInit(PROC_68K, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_68K", 497, 18214, 18838);
            CallChecker.varInit(PROC_X86, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86", 497, 18214, 18838);
            CallChecker.varInit(PROC_X86_64, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86_64", 497, 18214, 18838);
            CallChecker.varInit(OS_WIN_32, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WIN_32", 497, 18214, 18838);
            CallChecker.varInit(OS_WINDOWS_XP, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_XP", 497, 18214, 18838);
            CallChecker.varInit(OS_WINDOWS_VISTA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_VISTA", 497, 18214, 18838);
            CallChecker.varInit(OS_WINDOWS_SERVER_2012, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2012", 497, 18214, 18838);
            CallChecker.varInit(OS_WINDOWS_SERVER_2008, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2008", 497, 18214, 18838);
            CallChecker.varInit(OS_WINDOWS_NT, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_NT", 497, 18214, 18838);
            CallChecker.varInit(OS_WINDOWS_CE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_CE", 497, 18214, 18838);
            CallChecker.varInit(OS_WINDOWS_98, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_98", 497, 18214, 18838);
            CallChecker.varInit(OS_WINDOWS_95, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_95", 497, 18214, 18838);
            CallChecker.varInit(OS_WINDOWS_9, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_9", 497, 18214, 18838);
            CallChecker.varInit(OS_WINDOWS_8, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_8", 497, 18214, 18838);
            CallChecker.varInit(OS_WINDOWS_7, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_7", 497, 18214, 18838);
            CallChecker.varInit(OS_WINDOWS_2003, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2003", 497, 18214, 18838);
            CallChecker.varInit(OS_WINDOWS_2000, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2000", 497, 18214, 18838);
            CallChecker.varInit(OS_VXWORKS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_VXWORKS", 497, 18214, 18838);
            CallChecker.varInit(OS_SUNOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SUNOS", 497, 18214, 18838);
            CallChecker.varInit(OS_SOLARIS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SOLARIS", 497, 18214, 18838);
            CallChecker.varInit(OS_QNX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_QNX", 497, 18214, 18838);
            CallChecker.varInit(OS_OS2, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OS2", 497, 18214, 18838);
            CallChecker.varInit(OS_OPENBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OPENBSD", 497, 18214, 18838);
            CallChecker.varInit(OS_NETWARE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETWARE", 497, 18214, 18838);
            CallChecker.varInit(OS_NETBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETBSD", 497, 18214, 18838);
            CallChecker.varInit(OS_MACOSX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOSX", 497, 18214, 18838);
            CallChecker.varInit(OS_MACOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOS", 497, 18214, 18838);
            CallChecker.varInit(OS_LINUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_LINUX", 497, 18214, 18838);
            CallChecker.varInit(OS_IRIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_IRIX", 497, 18214, 18838);
            CallChecker.varInit(OS_HPUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_HPUX", 497, 18214, 18838);
            CallChecker.varInit(OS_EPOC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_EPOC", 497, 18214, 18838);
            CallChecker.varInit(OS_DIGITALUNIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_DIGITALUNIX", 497, 18214, 18838);
            CallChecker.varInit(OS_AIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_AIX", 497, 18214, 18838);
            TryContext _bcornu_try_context_479 = new TryContext(479, NativeLibraryClause.class, "java.lang.Exception");
            try {
                Pattern versionPattern = CallChecker.varInit(Pattern.compile("\\d+\\.?\\d*\\.?\\d*"), "versionPattern", 503, 18436, 18500);
                Matcher matcher = CallChecker.init(Matcher.class);
                if (CallChecker.beforeDeref(versionPattern, Pattern.class, 504, 18532, 18545)) {
                    versionPattern = CallChecker.beforeCalled(versionPattern, Pattern.class, 504, 18532, 18545);
                    matcher = CallChecker.isCalled(versionPattern, Pattern.class, 504, 18532, 18545).matcher(value);
                    CallChecker.varAssign(matcher, "matcher", 504, 18532, 18545);
                }
                if (CallChecker.beforeDeref(matcher, Matcher.class, 505, 18579, 18585)) {
                    matcher = CallChecker.beforeCalled(matcher, Matcher.class, 505, 18579, 18585);
                    if (CallChecker.isCalled(matcher, Matcher.class, 505, 18579, 18585).find()) {
                        if (CallChecker.beforeDeref(matcher, Matcher.class, 507, 18633, 18639)) {
                            matcher = CallChecker.beforeCalled(matcher, Matcher.class, 507, 18633, 18639);
                            value = CallChecker.isCalled(matcher, Matcher.class, 507, 18633, 18639).group();
                            CallChecker.varAssign(value, "value", 507, 18625, 18648);
                        }
                    }
                }
                final Version npe_invocation_var561 = Version.parseVersion(value);
                if (CallChecker.beforeDeref(npe_invocation_var561, Version.class, 509, 18683, 18709)) {
                    return CallChecker.isCalled(npe_invocation_var561, Version.class, 509, 18683, 18709).toString();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (Exception ex) {
                _bcornu_try_context_479.catchStart(479);
                if (CallChecker.beforeDeref(Version.emptyVersion, Version.class, 513, 18791, 18810)) {
                    return CallChecker.isCalled(Version.emptyVersion, Version.class, 513, 18791, 18810).toString();
                }else
                    throw new AbnormalExecutionError();
                
            } finally {
                _bcornu_try_context_479.finallyStart(479);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1772.methodEnd();
        }
    }

    public static List<String> getOsNameWithAliases(String osName) {
        MethodContext _bcornu_methode_context1773 = new MethodContext(List.class);
        try {
            CallChecker.varInit(osName, "osName", 517, 18845, 19221);
            CallChecker.varInit(PROC_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALIASES", 517, 18845, 19221);
            CallChecker.varInit(OS_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_ALIASES", 517, 18845, 19221);
            CallChecker.varInit(PROC_SPARC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_SPARC", 517, 18845, 19221);
            CallChecker.varInit(PROC_POWER_PC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_POWER_PC", 517, 18845, 19221);
            CallChecker.varInit(PROC_PARISC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_PARISC", 517, 18845, 19221);
            CallChecker.varInit(PROC_MIPS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_MIPS", 517, 18845, 19221);
            CallChecker.varInit(PROC_IGNITE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_IGNITE", 517, 18845, 19221);
            CallChecker.varInit(PROC_ALPHA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALPHA", 517, 18845, 19221);
            CallChecker.varInit(PROC_ARM, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM", 517, 18845, 19221);
            CallChecker.varInit(PROC_ARM_BE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_BE", 517, 18845, 19221);
            CallChecker.varInit(PROC_ARM_LE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_LE", 517, 18845, 19221);
            CallChecker.varInit(PROC_68K, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_68K", 517, 18845, 19221);
            CallChecker.varInit(PROC_X86, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86", 517, 18845, 19221);
            CallChecker.varInit(PROC_X86_64, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86_64", 517, 18845, 19221);
            CallChecker.varInit(OS_WIN_32, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WIN_32", 517, 18845, 19221);
            CallChecker.varInit(OS_WINDOWS_XP, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_XP", 517, 18845, 19221);
            CallChecker.varInit(OS_WINDOWS_VISTA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_VISTA", 517, 18845, 19221);
            CallChecker.varInit(OS_WINDOWS_SERVER_2012, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2012", 517, 18845, 19221);
            CallChecker.varInit(OS_WINDOWS_SERVER_2008, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2008", 517, 18845, 19221);
            CallChecker.varInit(OS_WINDOWS_NT, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_NT", 517, 18845, 19221);
            CallChecker.varInit(OS_WINDOWS_CE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_CE", 517, 18845, 19221);
            CallChecker.varInit(OS_WINDOWS_98, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_98", 517, 18845, 19221);
            CallChecker.varInit(OS_WINDOWS_95, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_95", 517, 18845, 19221);
            CallChecker.varInit(OS_WINDOWS_9, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_9", 517, 18845, 19221);
            CallChecker.varInit(OS_WINDOWS_8, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_8", 517, 18845, 19221);
            CallChecker.varInit(OS_WINDOWS_7, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_7", 517, 18845, 19221);
            CallChecker.varInit(OS_WINDOWS_2003, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2003", 517, 18845, 19221);
            CallChecker.varInit(OS_WINDOWS_2000, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2000", 517, 18845, 19221);
            CallChecker.varInit(OS_VXWORKS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_VXWORKS", 517, 18845, 19221);
            CallChecker.varInit(OS_SUNOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SUNOS", 517, 18845, 19221);
            CallChecker.varInit(OS_SOLARIS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SOLARIS", 517, 18845, 19221);
            CallChecker.varInit(OS_QNX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_QNX", 517, 18845, 19221);
            CallChecker.varInit(OS_OS2, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OS2", 517, 18845, 19221);
            CallChecker.varInit(OS_OPENBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OPENBSD", 517, 18845, 19221);
            CallChecker.varInit(OS_NETWARE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETWARE", 517, 18845, 19221);
            CallChecker.varInit(OS_NETBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETBSD", 517, 18845, 19221);
            CallChecker.varInit(OS_MACOSX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOSX", 517, 18845, 19221);
            CallChecker.varInit(OS_MACOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOS", 517, 18845, 19221);
            CallChecker.varInit(OS_LINUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_LINUX", 517, 18845, 19221);
            CallChecker.varInit(OS_IRIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_IRIX", 517, 18845, 19221);
            CallChecker.varInit(OS_HPUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_HPUX", 517, 18845, 19221);
            CallChecker.varInit(OS_EPOC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_EPOC", 517, 18845, 19221);
            CallChecker.varInit(OS_DIGITALUNIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_DIGITALUNIX", 517, 18845, 19221);
            CallChecker.varInit(OS_AIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_AIX", 517, 18845, 19221);
            osName = NativeLibraryClause.normalizeOSName(osName);
            CallChecker.varAssign(osName, "osName", 520, 18970, 19002);
            List<String> result = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(NativeLibraryClause.OS_ALIASES, Map.class, 522, 19035, 19044)) {
                result = CallChecker.isCalled(NativeLibraryClause.OS_ALIASES, Map.class, 522, 19035, 19044).get(osName);
                CallChecker.varAssign(result, "result", 522, 19035, 19044);
            }
            if (result == null) {
                result = Collections.singletonList(osName);
                CallChecker.varAssign(result, "result", 526, 19109, 19151);
            }
            return Collections.unmodifiableList(result);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1773.methodEnd();
        }
    }

    public static List<String> getProcessorWithAliases(String processor) {
        MethodContext _bcornu_methode_context1774 = new MethodContext(List.class);
        try {
            CallChecker.varInit(processor, "processor", 532, 19228, 19626);
            CallChecker.varInit(PROC_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALIASES", 532, 19228, 19626);
            CallChecker.varInit(OS_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_ALIASES", 532, 19228, 19626);
            CallChecker.varInit(PROC_SPARC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_SPARC", 532, 19228, 19626);
            CallChecker.varInit(PROC_POWER_PC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_POWER_PC", 532, 19228, 19626);
            CallChecker.varInit(PROC_PARISC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_PARISC", 532, 19228, 19626);
            CallChecker.varInit(PROC_MIPS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_MIPS", 532, 19228, 19626);
            CallChecker.varInit(PROC_IGNITE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_IGNITE", 532, 19228, 19626);
            CallChecker.varInit(PROC_ALPHA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALPHA", 532, 19228, 19626);
            CallChecker.varInit(PROC_ARM, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM", 532, 19228, 19626);
            CallChecker.varInit(PROC_ARM_BE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_BE", 532, 19228, 19626);
            CallChecker.varInit(PROC_ARM_LE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_LE", 532, 19228, 19626);
            CallChecker.varInit(PROC_68K, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_68K", 532, 19228, 19626);
            CallChecker.varInit(PROC_X86, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86", 532, 19228, 19626);
            CallChecker.varInit(PROC_X86_64, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86_64", 532, 19228, 19626);
            CallChecker.varInit(OS_WIN_32, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WIN_32", 532, 19228, 19626);
            CallChecker.varInit(OS_WINDOWS_XP, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_XP", 532, 19228, 19626);
            CallChecker.varInit(OS_WINDOWS_VISTA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_VISTA", 532, 19228, 19626);
            CallChecker.varInit(OS_WINDOWS_SERVER_2012, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2012", 532, 19228, 19626);
            CallChecker.varInit(OS_WINDOWS_SERVER_2008, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2008", 532, 19228, 19626);
            CallChecker.varInit(OS_WINDOWS_NT, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_NT", 532, 19228, 19626);
            CallChecker.varInit(OS_WINDOWS_CE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_CE", 532, 19228, 19626);
            CallChecker.varInit(OS_WINDOWS_98, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_98", 532, 19228, 19626);
            CallChecker.varInit(OS_WINDOWS_95, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_95", 532, 19228, 19626);
            CallChecker.varInit(OS_WINDOWS_9, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_9", 532, 19228, 19626);
            CallChecker.varInit(OS_WINDOWS_8, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_8", 532, 19228, 19626);
            CallChecker.varInit(OS_WINDOWS_7, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_7", 532, 19228, 19626);
            CallChecker.varInit(OS_WINDOWS_2003, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2003", 532, 19228, 19626);
            CallChecker.varInit(OS_WINDOWS_2000, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2000", 532, 19228, 19626);
            CallChecker.varInit(OS_VXWORKS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_VXWORKS", 532, 19228, 19626);
            CallChecker.varInit(OS_SUNOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SUNOS", 532, 19228, 19626);
            CallChecker.varInit(OS_SOLARIS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SOLARIS", 532, 19228, 19626);
            CallChecker.varInit(OS_QNX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_QNX", 532, 19228, 19626);
            CallChecker.varInit(OS_OS2, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OS2", 532, 19228, 19626);
            CallChecker.varInit(OS_OPENBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OPENBSD", 532, 19228, 19626);
            CallChecker.varInit(OS_NETWARE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETWARE", 532, 19228, 19626);
            CallChecker.varInit(OS_NETBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETBSD", 532, 19228, 19626);
            CallChecker.varInit(OS_MACOSX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOSX", 532, 19228, 19626);
            CallChecker.varInit(OS_MACOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOS", 532, 19228, 19626);
            CallChecker.varInit(OS_LINUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_LINUX", 532, 19228, 19626);
            CallChecker.varInit(OS_IRIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_IRIX", 532, 19228, 19626);
            CallChecker.varInit(OS_HPUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_HPUX", 532, 19228, 19626);
            CallChecker.varInit(OS_EPOC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_EPOC", 532, 19228, 19626);
            CallChecker.varInit(OS_DIGITALUNIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_DIGITALUNIX", 532, 19228, 19626);
            CallChecker.varInit(OS_AIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_AIX", 532, 19228, 19626);
            processor = NativeLibraryClause.normalizeProcessor(processor);
            CallChecker.varAssign(processor, "processor", 535, 19359, 19400);
            List<String> result = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(NativeLibraryClause.PROC_ALIASES, Map.class, 537, 19433, 19444)) {
                result = CallChecker.isCalled(NativeLibraryClause.PROC_ALIASES, Map.class, 537, 19433, 19444).get(processor);
                CallChecker.varAssign(result, "result", 537, 19433, 19444);
            }
            if (result == null) {
                result = Collections.singletonList(processor);
                CallChecker.varAssign(result, "result", 541, 19512, 19557);
            }
            return Collections.unmodifiableList(result);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1774.methodEnd();
        }
    }

    public static String normalizeOSName(String value) {
        MethodContext _bcornu_methode_context1775 = new MethodContext(String.class);
        try {
            CallChecker.varInit(value, "value", 546, 19633, 23370);
            CallChecker.varInit(PROC_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALIASES", 546, 19633, 23370);
            CallChecker.varInit(OS_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_ALIASES", 546, 19633, 23370);
            CallChecker.varInit(PROC_SPARC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_SPARC", 546, 19633, 23370);
            CallChecker.varInit(PROC_POWER_PC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_POWER_PC", 546, 19633, 23370);
            CallChecker.varInit(PROC_PARISC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_PARISC", 546, 19633, 23370);
            CallChecker.varInit(PROC_MIPS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_MIPS", 546, 19633, 23370);
            CallChecker.varInit(PROC_IGNITE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_IGNITE", 546, 19633, 23370);
            CallChecker.varInit(PROC_ALPHA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALPHA", 546, 19633, 23370);
            CallChecker.varInit(PROC_ARM, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM", 546, 19633, 23370);
            CallChecker.varInit(PROC_ARM_BE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_BE", 546, 19633, 23370);
            CallChecker.varInit(PROC_ARM_LE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_LE", 546, 19633, 23370);
            CallChecker.varInit(PROC_68K, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_68K", 546, 19633, 23370);
            CallChecker.varInit(PROC_X86, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86", 546, 19633, 23370);
            CallChecker.varInit(PROC_X86_64, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86_64", 546, 19633, 23370);
            CallChecker.varInit(OS_WIN_32, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WIN_32", 546, 19633, 23370);
            CallChecker.varInit(OS_WINDOWS_XP, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_XP", 546, 19633, 23370);
            CallChecker.varInit(OS_WINDOWS_VISTA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_VISTA", 546, 19633, 23370);
            CallChecker.varInit(OS_WINDOWS_SERVER_2012, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2012", 546, 19633, 23370);
            CallChecker.varInit(OS_WINDOWS_SERVER_2008, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2008", 546, 19633, 23370);
            CallChecker.varInit(OS_WINDOWS_NT, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_NT", 546, 19633, 23370);
            CallChecker.varInit(OS_WINDOWS_CE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_CE", 546, 19633, 23370);
            CallChecker.varInit(OS_WINDOWS_98, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_98", 546, 19633, 23370);
            CallChecker.varInit(OS_WINDOWS_95, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_95", 546, 19633, 23370);
            CallChecker.varInit(OS_WINDOWS_9, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_9", 546, 19633, 23370);
            CallChecker.varInit(OS_WINDOWS_8, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_8", 546, 19633, 23370);
            CallChecker.varInit(OS_WINDOWS_7, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_7", 546, 19633, 23370);
            CallChecker.varInit(OS_WINDOWS_2003, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2003", 546, 19633, 23370);
            CallChecker.varInit(OS_WINDOWS_2000, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2000", 546, 19633, 23370);
            CallChecker.varInit(OS_VXWORKS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_VXWORKS", 546, 19633, 23370);
            CallChecker.varInit(OS_SUNOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SUNOS", 546, 19633, 23370);
            CallChecker.varInit(OS_SOLARIS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SOLARIS", 546, 19633, 23370);
            CallChecker.varInit(OS_QNX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_QNX", 546, 19633, 23370);
            CallChecker.varInit(OS_OS2, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OS2", 546, 19633, 23370);
            CallChecker.varInit(OS_OPENBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OPENBSD", 546, 19633, 23370);
            CallChecker.varInit(OS_NETWARE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETWARE", 546, 19633, 23370);
            CallChecker.varInit(OS_NETBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETBSD", 546, 19633, 23370);
            CallChecker.varInit(OS_MACOSX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOSX", 546, 19633, 23370);
            CallChecker.varInit(OS_MACOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOS", 546, 19633, 23370);
            CallChecker.varInit(OS_LINUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_LINUX", 546, 19633, 23370);
            CallChecker.varInit(OS_IRIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_IRIX", 546, 19633, 23370);
            CallChecker.varInit(OS_HPUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_HPUX", 546, 19633, 23370);
            CallChecker.varInit(OS_EPOC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_EPOC", 546, 19633, 23370);
            CallChecker.varInit(OS_DIGITALUNIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_DIGITALUNIX", 546, 19633, 23370);
            CallChecker.varInit(OS_AIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_AIX", 546, 19633, 23370);
            if (CallChecker.beforeDeref(value, String.class, 548, 19706, 19710)) {
                value = CallChecker.beforeCalled(value, String.class, 548, 19706, 19710);
                value = CallChecker.isCalled(value, String.class, 548, 19706, 19710).toLowerCase();
                CallChecker.varAssign(value, "value", 548, 19698, 19725);
            }
            if (CallChecker.beforeDeref(NativeLibraryClause.OS_ALIASES, Map.class, 550, 19740, 19749)) {
                if (CallChecker.isCalled(NativeLibraryClause.OS_ALIASES, Map.class, 550, 19740, 19749).containsKey(value)) {
                    if (CallChecker.beforeDeref(NativeLibraryClause.OS_ALIASES, Map.class, 553, 19891, 19900)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(NativeLibraryClause.OS_ALIASES, Map.class, 553, 19891, 19900).get(value), List.class, 553, 19891, 19911)) {
                            return CallChecker.isCalled(CallChecker.isCalled(NativeLibraryClause.OS_ALIASES, Map.class, 553, 19891, 19900).get(value), List.class, 553, 19891, 19911).get(0);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(value, String.class, 557, 20015, 20019)) {
                value = CallChecker.beforeCalled(value, String.class, 557, 20015, 20019);
                if (CallChecker.isCalled(value, String.class, 557, 20015, 20019).startsWith("win")) {
                    String os = CallChecker.varInit("win", "os", 559, 20062, 20079);
                    if (CallChecker.beforeDeref(value, String.class, 560, 20097, 20101)) {
                        if (CallChecker.beforeDeref(value, String.class, 560, 20125, 20129)) {
                            value = CallChecker.beforeCalled(value, String.class, 560, 20097, 20101);
                            value = CallChecker.beforeCalled(value, String.class, 560, 20125, 20129);
                            if (((CallChecker.isCalled(value, String.class, 560, 20097, 20101).indexOf("32")) >= 0) || ((CallChecker.isCalled(value, String.class, 560, 20125, 20129).indexOf("*")) >= 0)) {
                                os = NativeLibraryClause.OS_WIN_32;
                                CallChecker.varAssign(os, "os", 562, 20180, 20194);
                            }else
                                if (CallChecker.beforeDeref(value, String.class, 564, 20231, 20235)) {
                                    value = CallChecker.beforeCalled(value, String.class, 564, 20231, 20235);
                                    if ((CallChecker.isCalled(value, String.class, 564, 20231, 20235).indexOf("95")) >= 0) {
                                        os = NativeLibraryClause.OS_WINDOWS_95;
                                        CallChecker.varAssign(os, "os", 566, 20287, 20305);
                                    }else
                                        if (CallChecker.beforeDeref(value, String.class, 568, 20342, 20346)) {
                                            value = CallChecker.beforeCalled(value, String.class, 568, 20342, 20346);
                                            if ((CallChecker.isCalled(value, String.class, 568, 20342, 20346).indexOf("98")) >= 0) {
                                                os = NativeLibraryClause.OS_WINDOWS_98;
                                                CallChecker.varAssign(os, "os", 570, 20398, 20416);
                                            }else
                                                if (CallChecker.beforeDeref(value, String.class, 572, 20453, 20457)) {
                                                    value = CallChecker.beforeCalled(value, String.class, 572, 20453, 20457);
                                                    if ((CallChecker.isCalled(value, String.class, 572, 20453, 20457).indexOf("nt")) >= 0) {
                                                        os = NativeLibraryClause.OS_WINDOWS_NT;
                                                        CallChecker.varAssign(os, "os", 574, 20509, 20527);
                                                    }else
                                                        if (CallChecker.beforeDeref(value, String.class, 576, 20564, 20568)) {
                                                            value = CallChecker.beforeCalled(value, String.class, 576, 20564, 20568);
                                                            if ((CallChecker.isCalled(value, String.class, 576, 20564, 20568).indexOf("2000")) >= 0) {
                                                                os = NativeLibraryClause.OS_WINDOWS_2000;
                                                                CallChecker.varAssign(os, "os", 578, 20622, 20642);
                                                            }else
                                                                if (CallChecker.beforeDeref(value, String.class, 580, 20679, 20683)) {
                                                                    value = CallChecker.beforeCalled(value, String.class, 580, 20679, 20683);
                                                                    if ((CallChecker.isCalled(value, String.class, 580, 20679, 20683).indexOf("2003")) >= 0) {
                                                                        os = NativeLibraryClause.OS_WINDOWS_2003;
                                                                        CallChecker.varAssign(os, "os", 582, 20737, 20757);
                                                                    }else
                                                                        if (CallChecker.beforeDeref(value, String.class, 584, 20794, 20798)) {
                                                                            value = CallChecker.beforeCalled(value, String.class, 584, 20794, 20798);
                                                                            if ((CallChecker.isCalled(value, String.class, 584, 20794, 20798).indexOf("2008")) >= 0) {
                                                                                os = NativeLibraryClause.OS_WINDOWS_SERVER_2008;
                                                                                CallChecker.varAssign(os, "os", 586, 20852, 20879);
                                                                            }else
                                                                                if (CallChecker.beforeDeref(value, String.class, 588, 20916, 20920)) {
                                                                                    value = CallChecker.beforeCalled(value, String.class, 588, 20916, 20920);
                                                                                    if ((CallChecker.isCalled(value, String.class, 588, 20916, 20920).indexOf("2012")) >= 0) {
                                                                                        os = NativeLibraryClause.OS_WINDOWS_SERVER_2012;
                                                                                        CallChecker.varAssign(os, "os", 590, 20974, 21001);
                                                                                    }else
                                                                                        if (CallChecker.beforeDeref(value, String.class, 592, 21038, 21042)) {
                                                                                            value = CallChecker.beforeCalled(value, String.class, 592, 21038, 21042);
                                                                                            if ((CallChecker.isCalled(value, String.class, 592, 21038, 21042).indexOf("xp")) >= 0) {
                                                                                                os = NativeLibraryClause.OS_WINDOWS_XP;
                                                                                                CallChecker.varAssign(os, "os", 594, 21094, 21112);
                                                                                            }else
                                                                                                if (CallChecker.beforeDeref(value, String.class, 596, 21149, 21153)) {
                                                                                                    value = CallChecker.beforeCalled(value, String.class, 596, 21149, 21153);
                                                                                                    if ((CallChecker.isCalled(value, String.class, 596, 21149, 21153).indexOf("ce")) >= 0) {
                                                                                                        os = NativeLibraryClause.OS_WINDOWS_CE;
                                                                                                        CallChecker.varAssign(os, "os", 598, 21205, 21223);
                                                                                                    }else
                                                                                                        if (CallChecker.beforeDeref(value, String.class, 600, 21260, 21264)) {
                                                                                                            value = CallChecker.beforeCalled(value, String.class, 600, 21260, 21264);
                                                                                                            if ((CallChecker.isCalled(value, String.class, 600, 21260, 21264).indexOf("vista")) >= 0) {
                                                                                                                os = NativeLibraryClause.OS_WINDOWS_VISTA;
                                                                                                                CallChecker.varAssign(os, "os", 602, 21319, 21340);
                                                                                                            }else
                                                                                                                if (CallChecker.beforeDeref(value, String.class, 604, 21378, 21382)) {
                                                                                                                    if (CallChecker.beforeDeref(value, String.class, 604, 21407, 21411)) {
                                                                                                                        value = CallChecker.beforeCalled(value, String.class, 604, 21378, 21382);
                                                                                                                        value = CallChecker.beforeCalled(value, String.class, 604, 21407, 21411);
                                                                                                                        if (((CallChecker.isCalled(value, String.class, 604, 21378, 21382).indexOf(" 7")) >= 0) || (CallChecker.isCalled(value, String.class, 604, 21407, 21411).equals("win7"))) {
                                                                                                                            os = NativeLibraryClause.OS_WINDOWS_7;
                                                                                                                            CallChecker.varAssign(os, "os", 606, 21459, 21476);
                                                                                                                        }else
                                                                                                                            if (CallChecker.beforeDeref(value, String.class, 608, 21514, 21518)) {
                                                                                                                                if (CallChecker.beforeDeref(value, String.class, 608, 21543, 21547)) {
                                                                                                                                    value = CallChecker.beforeCalled(value, String.class, 608, 21514, 21518);
                                                                                                                                    value = CallChecker.beforeCalled(value, String.class, 608, 21543, 21547);
                                                                                                                                    if (((CallChecker.isCalled(value, String.class, 608, 21514, 21518).indexOf(" 8")) >= 0) || (CallChecker.isCalled(value, String.class, 608, 21543, 21547).equals("win8"))) {
                                                                                                                                        os = NativeLibraryClause.OS_WINDOWS_8;
                                                                                                                                        CallChecker.varAssign(os, "os", 610, 21595, 21612);
                                                                                                                                    }else
                                                                                                                                        if (CallChecker.beforeDeref(value, String.class, 612, 21650, 21654)) {
                                                                                                                                            if (CallChecker.beforeDeref(value, String.class, 612, 21679, 21683)) {
                                                                                                                                                value = CallChecker.beforeCalled(value, String.class, 612, 21650, 21654);
                                                                                                                                                value = CallChecker.beforeCalled(value, String.class, 612, 21679, 21683);
                                                                                                                                                if (((CallChecker.isCalled(value, String.class, 612, 21650, 21654).indexOf(" 9")) >= 0) || (CallChecker.isCalled(value, String.class, 612, 21679, 21683).equals("win9"))) {
                                                                                                                                                    os = NativeLibraryClause.OS_WINDOWS_9;
                                                                                                                                                    CallChecker.varAssign(os, "os", 614, 21731, 21748);
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
                                                                                    
                                                                                }
                                                                            
                                                                        }
                                                                    
                                                                }
                                                            
                                                        }
                                                    
                                                }
                                            
                                        }
                                    
                                }
                            
                        }
                    }
                    return os;
                }else
                    if (CallChecker.beforeDeref(value, String.class, 618, 21814, 21818)) {
                        value = CallChecker.beforeCalled(value, String.class, 618, 21814, 21818);
                        if (CallChecker.isCalled(value, String.class, 618, 21814, 21818).startsWith(NativeLibraryClause.OS_LINUX)) {
                            return NativeLibraryClause.OS_LINUX;
                        }else
                            if (CallChecker.beforeDeref(value, String.class, 622, 21908, 21912)) {
                                value = CallChecker.beforeCalled(value, String.class, 622, 21908, 21912);
                                if (CallChecker.isCalled(value, String.class, 622, 21908, 21912).startsWith(NativeLibraryClause.OS_AIX)) {
                                    return NativeLibraryClause.OS_AIX;
                                }else
                                    if (CallChecker.beforeDeref(value, String.class, 626, 21998, 22002)) {
                                        value = CallChecker.beforeCalled(value, String.class, 626, 21998, 22002);
                                        if (CallChecker.isCalled(value, String.class, 626, 21998, 22002).startsWith(NativeLibraryClause.OS_DIGITALUNIX)) {
                                            return NativeLibraryClause.OS_DIGITALUNIX;
                                        }else
                                            if (CallChecker.beforeDeref(value, String.class, 630, 22104, 22108)) {
                                                value = CallChecker.beforeCalled(value, String.class, 630, 22104, 22108);
                                                if (CallChecker.isCalled(value, String.class, 630, 22104, 22108).startsWith(NativeLibraryClause.OS_HPUX)) {
                                                    return NativeLibraryClause.OS_HPUX;
                                                }else
                                                    if (CallChecker.beforeDeref(value, String.class, 634, 22196, 22200)) {
                                                        value = CallChecker.beforeCalled(value, String.class, 634, 22196, 22200);
                                                        if (CallChecker.isCalled(value, String.class, 634, 22196, 22200).startsWith(NativeLibraryClause.OS_IRIX)) {
                                                            return NativeLibraryClause.OS_IRIX;
                                                        }else
                                                            if (CallChecker.beforeDeref(value, String.class, 638, 22288, 22292)) {
                                                                if (CallChecker.beforeDeref(value, String.class, 638, 22319, 22323)) {
                                                                    value = CallChecker.beforeCalled(value, String.class, 638, 22288, 22292);
                                                                    value = CallChecker.beforeCalled(value, String.class, 638, 22319, 22323);
                                                                    if ((CallChecker.isCalled(value, String.class, 638, 22288, 22292).startsWith(NativeLibraryClause.OS_MACOSX)) || (CallChecker.isCalled(value, String.class, 638, 22319, 22323).startsWith("mac os x"))) {
                                                                        return NativeLibraryClause.OS_MACOSX;
                                                                    }else
                                                                        if (CallChecker.beforeDeref(value, String.class, 642, 22416, 22420)) {
                                                                            if (CallChecker.beforeDeref(value, String.class, 642, 22446, 22450)) {
                                                                                value = CallChecker.beforeCalled(value, String.class, 642, 22416, 22420);
                                                                                value = CallChecker.beforeCalled(value, String.class, 642, 22446, 22450);
                                                                                if ((CallChecker.isCalled(value, String.class, 642, 22416, 22420).startsWith(NativeLibraryClause.OS_MACOS)) || (CallChecker.isCalled(value, String.class, 642, 22446, 22450).startsWith("mac os"))) {
                                                                                    return NativeLibraryClause.OS_MACOS;
                                                                                }else
                                                                                    if (CallChecker.beforeDeref(value, String.class, 646, 22540, 22544)) {
                                                                                        value = CallChecker.beforeCalled(value, String.class, 646, 22540, 22544);
                                                                                        if (CallChecker.isCalled(value, String.class, 646, 22540, 22544).startsWith(NativeLibraryClause.OS_NETWARE)) {
                                                                                            return NativeLibraryClause.OS_NETWARE;
                                                                                        }else
                                                                                            if (CallChecker.beforeDeref(value, String.class, 650, 22638, 22642)) {
                                                                                                value = CallChecker.beforeCalled(value, String.class, 650, 22638, 22642);
                                                                                                if (CallChecker.isCalled(value, String.class, 650, 22638, 22642).startsWith(NativeLibraryClause.OS_OPENBSD)) {
                                                                                                    return NativeLibraryClause.OS_OPENBSD;
                                                                                                }else
                                                                                                    if (CallChecker.beforeDeref(value, String.class, 654, 22736, 22740)) {
                                                                                                        value = CallChecker.beforeCalled(value, String.class, 654, 22736, 22740);
                                                                                                        if (CallChecker.isCalled(value, String.class, 654, 22736, 22740).startsWith(NativeLibraryClause.OS_NETBSD)) {
                                                                                                            return NativeLibraryClause.OS_NETBSD;
                                                                                                        }else
                                                                                                            if (CallChecker.beforeDeref(value, String.class, 658, 22832, 22836)) {
                                                                                                                if (CallChecker.beforeDeref(value, String.class, 658, 22860, 22864)) {
                                                                                                                    value = CallChecker.beforeCalled(value, String.class, 658, 22832, 22836);
                                                                                                                    value = CallChecker.beforeCalled(value, String.class, 658, 22860, 22864);
                                                                                                                    if ((CallChecker.isCalled(value, String.class, 658, 22832, 22836).startsWith(NativeLibraryClause.OS_OS2)) || (CallChecker.isCalled(value, String.class, 658, 22860, 22864).startsWith("os/2"))) {
                                                                                                                        return NativeLibraryClause.OS_OS2;
                                                                                                                    }else
                                                                                                                        if (CallChecker.beforeDeref(value, String.class, 662, 22950, 22954)) {
                                                                                                                            if (CallChecker.beforeDeref(value, String.class, 662, 22978, 22982)) {
                                                                                                                                value = CallChecker.beforeCalled(value, String.class, 662, 22950, 22954);
                                                                                                                                value = CallChecker.beforeCalled(value, String.class, 662, 22978, 22982);
                                                                                                                                if ((CallChecker.isCalled(value, String.class, 662, 22950, 22954).startsWith(NativeLibraryClause.OS_QNX)) || (CallChecker.isCalled(value, String.class, 662, 22978, 22982).startsWith("procnto"))) {
                                                                                                                                    return NativeLibraryClause.OS_QNX;
                                                                                                                                }else
                                                                                                                                    if (CallChecker.beforeDeref(value, String.class, 666, 23071, 23075)) {
                                                                                                                                        value = CallChecker.beforeCalled(value, String.class, 666, 23071, 23075);
                                                                                                                                        if (CallChecker.isCalled(value, String.class, 666, 23071, 23075).startsWith(NativeLibraryClause.OS_SOLARIS)) {
                                                                                                                                            return NativeLibraryClause.OS_SOLARIS;
                                                                                                                                        }else
                                                                                                                                            if (CallChecker.beforeDeref(value, String.class, 670, 23169, 23173)) {
                                                                                                                                                value = CallChecker.beforeCalled(value, String.class, 670, 23169, 23173);
                                                                                                                                                if (CallChecker.isCalled(value, String.class, 670, 23169, 23173).startsWith(NativeLibraryClause.OS_SUNOS)) {
                                                                                                                                                    return NativeLibraryClause.OS_SUNOS;
                                                                                                                                                }else
                                                                                                                                                    if (CallChecker.beforeDeref(value, String.class, 674, 23263, 23267)) {
                                                                                                                                                        value = CallChecker.beforeCalled(value, String.class, 674, 23263, 23267);
                                                                                                                                                        if (CallChecker.isCalled(value, String.class, 674, 23263, 23267).startsWith(NativeLibraryClause.OS_VXWORKS)) {
                                                                                                                                                            return NativeLibraryClause.OS_VXWORKS;
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
            
            return value;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1775.methodEnd();
        }
    }

    public static String normalizeProcessor(String value) {
        MethodContext _bcornu_methode_context1776 = new MethodContext(String.class);
        try {
            CallChecker.varInit(value, "value", 681, 23377, 25153);
            CallChecker.varInit(PROC_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALIASES", 681, 23377, 25153);
            CallChecker.varInit(OS_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_ALIASES", 681, 23377, 25153);
            CallChecker.varInit(PROC_SPARC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_SPARC", 681, 23377, 25153);
            CallChecker.varInit(PROC_POWER_PC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_POWER_PC", 681, 23377, 25153);
            CallChecker.varInit(PROC_PARISC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_PARISC", 681, 23377, 25153);
            CallChecker.varInit(PROC_MIPS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_MIPS", 681, 23377, 25153);
            CallChecker.varInit(PROC_IGNITE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_IGNITE", 681, 23377, 25153);
            CallChecker.varInit(PROC_ALPHA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALPHA", 681, 23377, 25153);
            CallChecker.varInit(PROC_ARM, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM", 681, 23377, 25153);
            CallChecker.varInit(PROC_ARM_BE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_BE", 681, 23377, 25153);
            CallChecker.varInit(PROC_ARM_LE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_LE", 681, 23377, 25153);
            CallChecker.varInit(PROC_68K, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_68K", 681, 23377, 25153);
            CallChecker.varInit(PROC_X86, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86", 681, 23377, 25153);
            CallChecker.varInit(PROC_X86_64, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86_64", 681, 23377, 25153);
            CallChecker.varInit(OS_WIN_32, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WIN_32", 681, 23377, 25153);
            CallChecker.varInit(OS_WINDOWS_XP, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_XP", 681, 23377, 25153);
            CallChecker.varInit(OS_WINDOWS_VISTA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_VISTA", 681, 23377, 25153);
            CallChecker.varInit(OS_WINDOWS_SERVER_2012, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2012", 681, 23377, 25153);
            CallChecker.varInit(OS_WINDOWS_SERVER_2008, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2008", 681, 23377, 25153);
            CallChecker.varInit(OS_WINDOWS_NT, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_NT", 681, 23377, 25153);
            CallChecker.varInit(OS_WINDOWS_CE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_CE", 681, 23377, 25153);
            CallChecker.varInit(OS_WINDOWS_98, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_98", 681, 23377, 25153);
            CallChecker.varInit(OS_WINDOWS_95, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_95", 681, 23377, 25153);
            CallChecker.varInit(OS_WINDOWS_9, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_9", 681, 23377, 25153);
            CallChecker.varInit(OS_WINDOWS_8, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_8", 681, 23377, 25153);
            CallChecker.varInit(OS_WINDOWS_7, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_7", 681, 23377, 25153);
            CallChecker.varInit(OS_WINDOWS_2003, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2003", 681, 23377, 25153);
            CallChecker.varInit(OS_WINDOWS_2000, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2000", 681, 23377, 25153);
            CallChecker.varInit(OS_VXWORKS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_VXWORKS", 681, 23377, 25153);
            CallChecker.varInit(OS_SUNOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SUNOS", 681, 23377, 25153);
            CallChecker.varInit(OS_SOLARIS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SOLARIS", 681, 23377, 25153);
            CallChecker.varInit(OS_QNX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_QNX", 681, 23377, 25153);
            CallChecker.varInit(OS_OS2, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OS2", 681, 23377, 25153);
            CallChecker.varInit(OS_OPENBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OPENBSD", 681, 23377, 25153);
            CallChecker.varInit(OS_NETWARE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETWARE", 681, 23377, 25153);
            CallChecker.varInit(OS_NETBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETBSD", 681, 23377, 25153);
            CallChecker.varInit(OS_MACOSX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOSX", 681, 23377, 25153);
            CallChecker.varInit(OS_MACOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOS", 681, 23377, 25153);
            CallChecker.varInit(OS_LINUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_LINUX", 681, 23377, 25153);
            CallChecker.varInit(OS_IRIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_IRIX", 681, 23377, 25153);
            CallChecker.varInit(OS_HPUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_HPUX", 681, 23377, 25153);
            CallChecker.varInit(OS_EPOC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_EPOC", 681, 23377, 25153);
            CallChecker.varInit(OS_DIGITALUNIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_DIGITALUNIX", 681, 23377, 25153);
            CallChecker.varInit(OS_AIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_AIX", 681, 23377, 25153);
            if (CallChecker.beforeDeref(value, String.class, 683, 23453, 23457)) {
                value = CallChecker.beforeCalled(value, String.class, 683, 23453, 23457);
                value = CallChecker.isCalled(value, String.class, 683, 23453, 23457).toLowerCase();
                CallChecker.varAssign(value, "value", 683, 23445, 23472);
            }
            if (CallChecker.beforeDeref(NativeLibraryClause.PROC_ALIASES, Map.class, 685, 23486, 23497)) {
                if (CallChecker.isCalled(NativeLibraryClause.PROC_ALIASES, Map.class, 685, 23486, 23497).containsKey(value)) {
                    if (CallChecker.beforeDeref(NativeLibraryClause.PROC_ALIASES, Map.class, 687, 23548, 23559)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(NativeLibraryClause.PROC_ALIASES, Map.class, 687, 23548, 23559).get(value), List.class, 687, 23548, 23570)) {
                            return CallChecker.isCalled(CallChecker.isCalled(NativeLibraryClause.PROC_ALIASES, Map.class, 687, 23548, 23559).get(value), List.class, 687, 23548, 23570).get(0);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(value, String.class, 690, 23603, 23607)) {
                if (CallChecker.beforeDeref(value, String.class, 690, 23636, 23640)) {
                    if (CallChecker.beforeDeref(value, String.class, 691, 23677, 23681)) {
                        if (CallChecker.beforeDeref(value, String.class, 691, 23705, 23709)) {
                            value = CallChecker.beforeCalled(value, String.class, 690, 23603, 23607);
                            value = CallChecker.beforeCalled(value, String.class, 690, 23636, 23640);
                            value = CallChecker.beforeCalled(value, String.class, 691, 23677, 23681);
                            value = CallChecker.beforeCalled(value, String.class, 691, 23705, 23709);
                            if ((((CallChecker.isCalled(value, String.class, 690, 23603, 23607).startsWith(NativeLibraryClause.PROC_X86_64)) || (CallChecker.isCalled(value, String.class, 690, 23636, 23640).startsWith("amd64"))) || (CallChecker.isCalled(value, String.class, 691, 23677, 23681).startsWith("em64"))) || (CallChecker.isCalled(value, String.class, 691, 23705, 23709).startsWith("x86_64"))) {
                                return NativeLibraryClause.PROC_X86_64;
                            }else
                                if (CallChecker.beforeDeref(value, String.class, 695, 23802, 23806)) {
                                    if (CallChecker.beforeDeref(value, String.class, 695, 23832, 23836)) {
                                        if (CallChecker.beforeDeref(value, String.class, 696, 23875, 23879)) {
                                            if (CallChecker.beforeDeref(value, String.class, 696, 23903, 23907)) {
                                                if (CallChecker.beforeDeref(value, String.class, 697, 23943, 23947)) {
                                                    if (CallChecker.beforeDeref(value, String.class, 697, 23971, 23975)) {
                                                        value = CallChecker.beforeCalled(value, String.class, 695, 23802, 23806);
                                                        value = CallChecker.beforeCalled(value, String.class, 695, 23832, 23836);
                                                        value = CallChecker.beforeCalled(value, String.class, 696, 23875, 23879);
                                                        value = CallChecker.beforeCalled(value, String.class, 696, 23903, 23907);
                                                        value = CallChecker.beforeCalled(value, String.class, 697, 23943, 23947);
                                                        value = CallChecker.beforeCalled(value, String.class, 697, 23971, 23975);
                                                        if ((((((CallChecker.isCalled(value, String.class, 695, 23802, 23806).startsWith(NativeLibraryClause.PROC_X86)) || (CallChecker.isCalled(value, String.class, 695, 23832, 23836).startsWith("pentium"))) || (CallChecker.isCalled(value, String.class, 696, 23875, 23879).startsWith("i386"))) || (CallChecker.isCalled(value, String.class, 696, 23903, 23907).startsWith("i486"))) || (CallChecker.isCalled(value, String.class, 697, 23943, 23947).startsWith("i586"))) || (CallChecker.isCalled(value, String.class, 697, 23971, 23975).startsWith("i686"))) {
                                                            return NativeLibraryClause.PROC_X86;
                                                        }else
                                                            if (CallChecker.beforeDeref(value, String.class, 701, 24063, 24067)) {
                                                                value = CallChecker.beforeCalled(value, String.class, 701, 24063, 24067);
                                                                if (CallChecker.isCalled(value, String.class, 701, 24063, 24067).startsWith(NativeLibraryClause.PROC_68K)) {
                                                                    return NativeLibraryClause.PROC_68K;
                                                                }else
                                                                    if (CallChecker.beforeDeref(value, String.class, 705, 24157, 24161)) {
                                                                        value = CallChecker.beforeCalled(value, String.class, 705, 24157, 24161);
                                                                        if (CallChecker.isCalled(value, String.class, 705, 24157, 24161).startsWith(NativeLibraryClause.PROC_ARM_LE)) {
                                                                            return NativeLibraryClause.PROC_ARM_LE;
                                                                        }else
                                                                            if (CallChecker.beforeDeref(value, String.class, 709, 24257, 24261)) {
                                                                                value = CallChecker.beforeCalled(value, String.class, 709, 24257, 24261);
                                                                                if (CallChecker.isCalled(value, String.class, 709, 24257, 24261).startsWith(NativeLibraryClause.PROC_ARM_BE)) {
                                                                                    return NativeLibraryClause.PROC_ARM_BE;
                                                                                }else
                                                                                    if (CallChecker.beforeDeref(value, String.class, 713, 24357, 24361)) {
                                                                                        value = CallChecker.beforeCalled(value, String.class, 713, 24357, 24361);
                                                                                        if (CallChecker.isCalled(value, String.class, 713, 24357, 24361).startsWith(NativeLibraryClause.PROC_ARM)) {
                                                                                            return NativeLibraryClause.PROC_ARM;
                                                                                        }else
                                                                                            if (CallChecker.beforeDeref(value, String.class, 717, 24451, 24455)) {
                                                                                                value = CallChecker.beforeCalled(value, String.class, 717, 24451, 24455);
                                                                                                if (CallChecker.isCalled(value, String.class, 717, 24451, 24455).startsWith(NativeLibraryClause.PROC_ALPHA)) {
                                                                                                    return NativeLibraryClause.PROC_ALPHA;
                                                                                                }else
                                                                                                    if (CallChecker.beforeDeref(value, String.class, 721, 24549, 24553)) {
                                                                                                        if (CallChecker.beforeDeref(value, String.class, 721, 24582, 24586)) {
                                                                                                            value = CallChecker.beforeCalled(value, String.class, 721, 24549, 24553);
                                                                                                            value = CallChecker.beforeCalled(value, String.class, 721, 24582, 24586);
                                                                                                            if ((CallChecker.isCalled(value, String.class, 721, 24549, 24553).startsWith(NativeLibraryClause.PROC_IGNITE)) || (CallChecker.isCalled(value, String.class, 721, 24582, 24586).startsWith("psc1k"))) {
                                                                                                                return NativeLibraryClause.PROC_IGNITE;
                                                                                                            }else
                                                                                                                if (CallChecker.beforeDeref(value, String.class, 725, 24678, 24682)) {
                                                                                                                    value = CallChecker.beforeCalled(value, String.class, 725, 24678, 24682);
                                                                                                                    if (CallChecker.isCalled(value, String.class, 725, 24678, 24682).startsWith(NativeLibraryClause.PROC_MIPS)) {
                                                                                                                        return NativeLibraryClause.PROC_MIPS;
                                                                                                                    }else
                                                                                                                        if (CallChecker.beforeDeref(value, String.class, 729, 24774, 24778)) {
                                                                                                                            value = CallChecker.beforeCalled(value, String.class, 729, 24774, 24778);
                                                                                                                            if (CallChecker.isCalled(value, String.class, 729, 24774, 24778).startsWith(NativeLibraryClause.PROC_PARISC)) {
                                                                                                                                return NativeLibraryClause.PROC_PARISC;
                                                                                                                            }else
                                                                                                                                if (CallChecker.beforeDeref(value, String.class, 733, 24874, 24878)) {
                                                                                                                                    if (CallChecker.beforeDeref(value, String.class, 733, 24909, 24913)) {
                                                                                                                                        if (CallChecker.beforeDeref(value, String.class, 734, 24950, 24954)) {
                                                                                                                                            value = CallChecker.beforeCalled(value, String.class, 733, 24874, 24878);
                                                                                                                                            value = CallChecker.beforeCalled(value, String.class, 733, 24909, 24913);
                                                                                                                                            value = CallChecker.beforeCalled(value, String.class, 734, 24950, 24954);
                                                                                                                                            if (((CallChecker.isCalled(value, String.class, 733, 24874, 24878).startsWith(NativeLibraryClause.PROC_POWER_PC)) || (CallChecker.isCalled(value, String.class, 733, 24909, 24913).startsWith("power"))) || (CallChecker.isCalled(value, String.class, 734, 24950, 24954).startsWith("ppc"))) {
                                                                                                                                                return NativeLibraryClause.PROC_POWER_PC;
                                                                                                                                            }else
                                                                                                                                                if (CallChecker.beforeDeref(value, String.class, 738, 25046, 25050)) {
                                                                                                                                                    value = CallChecker.beforeCalled(value, String.class, 738, 25046, 25050);
                                                                                                                                                    if (CallChecker.isCalled(value, String.class, 738, 25046, 25050).startsWith(NativeLibraryClause.PROC_SPARC)) {
                                                                                                                                                        return NativeLibraryClause.PROC_SPARC;
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
            
            return value;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1776.methodEnd();
        }
    }

    public static String normalizeOSVersion(String value) {
        MethodContext _bcornu_methode_context1777 = new MethodContext(String.class);
        try {
            CallChecker.varInit(value, "value", 745, 25160, 25545);
            CallChecker.varInit(PROC_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALIASES", 745, 25160, 25545);
            CallChecker.varInit(OS_ALIASES, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_ALIASES", 745, 25160, 25545);
            CallChecker.varInit(PROC_SPARC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_SPARC", 745, 25160, 25545);
            CallChecker.varInit(PROC_POWER_PC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_POWER_PC", 745, 25160, 25545);
            CallChecker.varInit(PROC_PARISC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_PARISC", 745, 25160, 25545);
            CallChecker.varInit(PROC_MIPS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_MIPS", 745, 25160, 25545);
            CallChecker.varInit(PROC_IGNITE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_IGNITE", 745, 25160, 25545);
            CallChecker.varInit(PROC_ALPHA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ALPHA", 745, 25160, 25545);
            CallChecker.varInit(PROC_ARM, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM", 745, 25160, 25545);
            CallChecker.varInit(PROC_ARM_BE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_BE", 745, 25160, 25545);
            CallChecker.varInit(PROC_ARM_LE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_ARM_LE", 745, 25160, 25545);
            CallChecker.varInit(PROC_68K, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_68K", 745, 25160, 25545);
            CallChecker.varInit(PROC_X86, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86", 745, 25160, 25545);
            CallChecker.varInit(PROC_X86_64, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.PROC_X86_64", 745, 25160, 25545);
            CallChecker.varInit(OS_WIN_32, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WIN_32", 745, 25160, 25545);
            CallChecker.varInit(OS_WINDOWS_XP, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_XP", 745, 25160, 25545);
            CallChecker.varInit(OS_WINDOWS_VISTA, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_VISTA", 745, 25160, 25545);
            CallChecker.varInit(OS_WINDOWS_SERVER_2012, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2012", 745, 25160, 25545);
            CallChecker.varInit(OS_WINDOWS_SERVER_2008, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_SERVER_2008", 745, 25160, 25545);
            CallChecker.varInit(OS_WINDOWS_NT, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_NT", 745, 25160, 25545);
            CallChecker.varInit(OS_WINDOWS_CE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_CE", 745, 25160, 25545);
            CallChecker.varInit(OS_WINDOWS_98, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_98", 745, 25160, 25545);
            CallChecker.varInit(OS_WINDOWS_95, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_95", 745, 25160, 25545);
            CallChecker.varInit(OS_WINDOWS_9, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_9", 745, 25160, 25545);
            CallChecker.varInit(OS_WINDOWS_8, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_8", 745, 25160, 25545);
            CallChecker.varInit(OS_WINDOWS_7, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_7", 745, 25160, 25545);
            CallChecker.varInit(OS_WINDOWS_2003, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2003", 745, 25160, 25545);
            CallChecker.varInit(OS_WINDOWS_2000, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_WINDOWS_2000", 745, 25160, 25545);
            CallChecker.varInit(OS_VXWORKS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_VXWORKS", 745, 25160, 25545);
            CallChecker.varInit(OS_SUNOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SUNOS", 745, 25160, 25545);
            CallChecker.varInit(OS_SOLARIS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_SOLARIS", 745, 25160, 25545);
            CallChecker.varInit(OS_QNX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_QNX", 745, 25160, 25545);
            CallChecker.varInit(OS_OS2, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OS2", 745, 25160, 25545);
            CallChecker.varInit(OS_OPENBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_OPENBSD", 745, 25160, 25545);
            CallChecker.varInit(OS_NETWARE, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETWARE", 745, 25160, 25545);
            CallChecker.varInit(OS_NETBSD, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_NETBSD", 745, 25160, 25545);
            CallChecker.varInit(OS_MACOSX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOSX", 745, 25160, 25545);
            CallChecker.varInit(OS_MACOS, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_MACOS", 745, 25160, 25545);
            CallChecker.varInit(OS_LINUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_LINUX", 745, 25160, 25545);
            CallChecker.varInit(OS_IRIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_IRIX", 745, 25160, 25545);
            CallChecker.varInit(OS_HPUX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_HPUX", 745, 25160, 25545);
            CallChecker.varInit(OS_EPOC, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_EPOC", 745, 25160, 25545);
            CallChecker.varInit(OS_DIGITALUNIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_DIGITALUNIX", 745, 25160, 25545);
            CallChecker.varInit(OS_AIX, "org.apache.felix.framework.util.manifestparser.NativeLibraryClause.OS_AIX", 745, 25160, 25545);
            TryContext _bcornu_try_context_480 = new TryContext(480, NativeLibraryClause.class, "java.lang.Exception");
            try {
                final VersionRange npe_invocation_var562 = VersionRange.parse(value);
                if (CallChecker.beforeDeref(npe_invocation_var562, VersionRange.class, 751, 25392, 25416)) {
                    return CallChecker.isCalled(npe_invocation_var562, VersionRange.class, 751, 25392, 25416).toString();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (Exception ex) {
                _bcornu_try_context_480.catchStart(480);
                if (CallChecker.beforeDeref(Version.emptyVersion, Version.class, 755, 25498, 25517)) {
                    return CallChecker.isCalled(Version.emptyVersion, Version.class, 755, 25498, 25517).toString();
                }else
                    throw new AbnormalExecutionError();
                
            } finally {
                _bcornu_try_context_480.finallyStart(480);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1777.methodEnd();
        }
    }
}

