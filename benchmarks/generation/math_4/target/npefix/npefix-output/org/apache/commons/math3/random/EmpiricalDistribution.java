package org.apache.commons.math3.random;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.distribution.AbstractRealDistribution;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.RealDistribution;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.descriptive.StatisticalSummary;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

public class EmpiricalDistribution extends AbstractRealDistribution {
    private abstract class DataAdapter {
        public abstract void computeBinStats() throws IOException;

        public abstract void computeStats() throws IOException;
    }

    private class StreamDataAdapter extends EmpiricalDistribution.DataAdapter {
        private BufferedReader inputStream;

        public StreamDataAdapter(BufferedReader in) {
            super();
            ConstructorContext _bcornu_methode_context481 = new ConstructorContext(EmpiricalDistribution.StreamDataAdapter.class, 345, 13166, 13414);
            try {
                inputStream = in;
                CallChecker.varAssign(this.inputStream, "this.inputStream", 347, 13388, 13404);
            } finally {
                _bcornu_methode_context481.methodEnd();
            }
        }

        @Override
        public void computeBinStats() throws IOException {
            MethodContext _bcornu_methode_context2209 = new MethodContext(void.class, 352, 13425, 13888);
            try {
                CallChecker.varInit(this, "this", 352, 13425, 13888);
                CallChecker.varInit(this.inputStream, "inputStream", 352, 13425, 13888);
                String str = CallChecker.varInit(null, "str", 353, 13535, 13552);
                double val = CallChecker.varInit(((double) (0.0)), "val", 354, 13566, 13583);
                inputStream = CallChecker.beforeCalled(inputStream, BufferedReader.class, 355, 13611, 13621);
                while ((str = CallChecker.isCalled(inputStream, BufferedReader.class, 355, 13611, 13621).readLine()) != null) {
                    CallChecker.varAssign(str, "str", 355, 13604, 13633);
                    val = Double.parseDouble(str);
                    CallChecker.varAssign(val, "val", 356, 13662, 13691);
                    SummaryStatistics stats = CallChecker.init(SummaryStatistics.class);
                    if (CallChecker.beforeDeref(binStats, List.class, 357, 13735, 13742)) {
                        stats = CallChecker.isCalled(binStats, List.class, 357, 13735, 13742).get(findBin(val));
                        CallChecker.varAssign(stats, "stats", 357, 13735, 13742);
                    }
                    if (CallChecker.beforeDeref(stats, SummaryStatistics.class, 358, 13779, 13783)) {
                        stats = CallChecker.beforeCalled(stats, SummaryStatistics.class, 358, 13779, 13783);
                        CallChecker.isCalled(stats, SummaryStatistics.class, 358, 13779, 13783).addValue(val);
                    }
                } 
                if (CallChecker.beforeDeref(inputStream, BufferedReader.class, 361, 13827, 13837)) {
                    inputStream = CallChecker.beforeCalled(inputStream, BufferedReader.class, 361, 13827, 13837);
                    CallChecker.isCalled(inputStream, BufferedReader.class, 361, 13827, 13837).close();
                }
                inputStream = null;
                CallChecker.varAssign(this.inputStream, "this.inputStream", 362, 13860, 13878);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2209.methodEnd();
            }
        }

        @Override
        public void computeStats() throws IOException {
            MethodContext _bcornu_methode_context2210 = new MethodContext(void.class, 367, 13899, 14354);
            try {
                CallChecker.varInit(this, "this", 367, 13899, 14354);
                CallChecker.varInit(this.inputStream, "inputStream", 367, 13899, 14354);
                String str = CallChecker.varInit(null, "str", 368, 14006, 14023);
                double val = CallChecker.varInit(((double) (0.0)), "val", 369, 14037, 14053);
                sampleStats = new SummaryStatistics();
                CallChecker.varAssign(EmpiricalDistribution.this.sampleStats, "this.sampleStats", 370, 14067, 14104);
                inputStream = CallChecker.beforeCalled(inputStream, BufferedReader.class, 371, 14132, 14142);
                while ((str = CallChecker.isCalled(inputStream, BufferedReader.class, 371, 14132, 14142).readLine()) != null) {
                    CallChecker.varAssign(str, "str", 371, 14125, 14154);
                    if (CallChecker.beforeDeref(Double.valueOf(str), Double.class, 372, 14189, 14207)) {
                        val = CallChecker.isCalled(Double.valueOf(str), Double.class, 372, 14189, 14207).doubleValue();
                        CallChecker.varAssign(val, "val", 372, 14183, 14222);
                    }
                    if (CallChecker.beforeDeref(sampleStats, SummaryStatistics.class, 373, 14240, 14250)) {
                        sampleStats = CallChecker.beforeCalled(sampleStats, SummaryStatistics.class, 373, 14240, 14250);
                        CallChecker.isCalled(sampleStats, SummaryStatistics.class, 373, 14240, 14250).addValue(val);
                    }
                } 
                if (CallChecker.beforeDeref(inputStream, BufferedReader.class, 375, 14293, 14303)) {
                    inputStream = CallChecker.beforeCalled(inputStream, BufferedReader.class, 375, 14293, 14303);
                    CallChecker.isCalled(inputStream, BufferedReader.class, 375, 14293, 14303).close();
                }
                inputStream = null;
                CallChecker.varAssign(this.inputStream, "this.inputStream", 376, 14326, 14344);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2210.methodEnd();
            }
        }
    }

    private class ArrayDataAdapter extends EmpiricalDistribution.DataAdapter {
        private double[] inputArray;

        public ArrayDataAdapter(double[] in) throws NullArgumentException {
            super();
            ConstructorContext _bcornu_methode_context482 = new ConstructorContext(EmpiricalDistribution.ArrayDataAdapter.class, 394, 14597, 14969);
            try {
                MathUtils.checkNotNull(in);
                inputArray = in;
                CallChecker.varAssign(this.inputArray, "this.inputArray", 397, 14944, 14959);
            } finally {
                _bcornu_methode_context482.methodEnd();
            }
        }

        @Override
        public void computeStats() throws IOException {
            MethodContext _bcornu_methode_context2211 = new MethodContext(void.class, 402, 14980, 15259);
            try {
                CallChecker.varInit(this, "this", 402, 14980, 15259);
                CallChecker.varInit(this.inputArray, "inputArray", 402, 14980, 15259);
                sampleStats = new SummaryStatistics();
                CallChecker.varAssign(EmpiricalDistribution.this.sampleStats, "this.sampleStats", 403, 15087, 15124);
                inputArray = CallChecker.beforeCalled(inputArray, double[].class, 404, 15158, 15167);
                for (int i = 0; i < (CallChecker.isCalled(inputArray, double[].class, 404, 15158, 15167).length); i++) {
                    if (CallChecker.beforeDeref(inputArray, double[].class, 405, 15221, 15230)) {
                        if (CallChecker.beforeDeref(sampleStats, SummaryStatistics.class, 405, 15200, 15210)) {
                            inputArray = CallChecker.beforeCalled(inputArray, double[].class, 405, 15221, 15230);
                            sampleStats = CallChecker.beforeCalled(sampleStats, SummaryStatistics.class, 405, 15200, 15210);
                            CallChecker.isCalled(sampleStats, SummaryStatistics.class, 405, 15200, 15210).addValue(CallChecker.isCalled(inputArray, double[].class, 405, 15221, 15230)[i]);
                        }
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2211.methodEnd();
            }
        }

        @Override
        public void computeBinStats() throws IOException {
            MethodContext _bcornu_methode_context2212 = new MethodContext(void.class, 411, 15270, 15595);
            try {
                CallChecker.varInit(this, "this", 411, 15270, 15595);
                CallChecker.varInit(this.inputArray, "inputArray", 411, 15270, 15595);
                inputArray = CallChecker.beforeCalled(inputArray, double[].class, 412, 15400, 15409);
                for (int i = 0; i < (CallChecker.isCalled(inputArray, double[].class, 412, 15400, 15409).length); i++) {
                    SummaryStatistics stats = CallChecker.init(SummaryStatistics.class);
                    if (CallChecker.beforeDeref(inputArray, double[].class, 414, 15509, 15518)) {
                        if (CallChecker.beforeDeref(binStats, List.class, 414, 15488, 15495)) {
                            inputArray = CallChecker.beforeCalled(inputArray, double[].class, 414, 15509, 15518);
                            stats = CallChecker.isCalled(binStats, List.class, 414, 15488, 15495).get(findBin(CallChecker.isCalled(inputArray, double[].class, 414, 15509, 15518)[i]));
                            CallChecker.varAssign(stats, "stats", 414, 15509, 15518);
                        }
                    }
                    if (CallChecker.beforeDeref(inputArray, double[].class, 415, 15557, 15566)) {
                        if (CallChecker.beforeDeref(stats, SummaryStatistics.class, 415, 15542, 15546)) {
                            inputArray = CallChecker.beforeCalled(inputArray, double[].class, 415, 15557, 15566);
                            stats = CallChecker.beforeCalled(stats, SummaryStatistics.class, 415, 15542, 15546);
                            CallChecker.isCalled(stats, SummaryStatistics.class, 415, 15542, 15546).addValue(CallChecker.isCalled(inputArray, double[].class, 415, 15557, 15566)[i]);
                        }
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2212.methodEnd();
            }
        }
    }

    public static final int DEFAULT_BIN_COUNT = 1000;

    private static final String FILE_CHARSET = "US-ASCII";

    private static final long serialVersionUID = 5729073523949762654L;

    protected final RandomDataGenerator randomData;

    private final List<SummaryStatistics> binStats;

    private SummaryStatistics sampleStats = null;

    private double max = Double.NEGATIVE_INFINITY;

    private double min = Double.POSITIVE_INFINITY;

    private double delta = 0.0;

    private final int binCount;

    private boolean loaded = false;

    private double[] upperBounds = null;

    public EmpiricalDistribution() {
        this(EmpiricalDistribution.DEFAULT_BIN_COUNT);
        ConstructorContext _bcornu_methode_context483 = new ConstructorContext(EmpiricalDistribution.class, 143, 6320, 6477);
        try {
        } finally {
            _bcornu_methode_context483.methodEnd();
        }
    }

    public EmpiricalDistribution(int binCount) {
        this(binCount, new RandomDataGenerator());
        ConstructorContext _bcornu_methode_context484 = new ConstructorContext(EmpiricalDistribution.class, 152, 6484, 6718);
        try {
        } finally {
            _bcornu_methode_context484.methodEnd();
        }
    }

    public EmpiricalDistribution(int binCount, RandomGenerator generator) {
        this(binCount, new RandomDataGenerator(generator));
        ConstructorContext _bcornu_methode_context485 = new ConstructorContext(EmpiricalDistribution.class, 164, 6725, 7188);
        try {
        } finally {
            _bcornu_methode_context485.methodEnd();
        }
    }

    public EmpiricalDistribution(RandomGenerator generator) {
        this(EmpiricalDistribution.DEFAULT_BIN_COUNT, generator);
        ConstructorContext _bcornu_methode_context486 = new ConstructorContext(EmpiricalDistribution.class, 175, 7195, 7584);
        try {
        } finally {
            _bcornu_methode_context486.methodEnd();
        }
    }

    @Deprecated
    public EmpiricalDistribution(int binCount, RandomDataImpl randomData) {
        this(binCount, CallChecker.isCalled(randomData, RandomDataImpl.class, 190, 8140, 8149).getDelegate());
        ConstructorContext _bcornu_methode_context487 = new ConstructorContext(EmpiricalDistribution.class, 189, 7591, 8171);
        try {
        } finally {
            _bcornu_methode_context487.methodEnd();
        }
    }

    @Deprecated
    public EmpiricalDistribution(RandomDataImpl randomData) {
        this(EmpiricalDistribution.DEFAULT_BIN_COUNT, randomData);
        ConstructorContext _bcornu_methode_context488 = new ConstructorContext(EmpiricalDistribution.class, 202, 8178, 8682);
        try {
        } finally {
            _bcornu_methode_context488.methodEnd();
        }
    }

    private EmpiricalDistribution(int binCount, RandomDataGenerator randomData) {
        super(null);
        ConstructorContext _bcornu_methode_context489 = new ConstructorContext(EmpiricalDistribution.class, 213, 8689, 9192);
        try {
            this.binCount = binCount;
            CallChecker.varAssign(this.binCount, "this.binCount", 216, 9069, 9093);
            this.randomData = randomData;
            CallChecker.varAssign(this.randomData, "this.randomData", 217, 9103, 9131);
            binStats = new ArrayList<SummaryStatistics>();
            CallChecker.varAssign(this.binStats, "this.binStats", 218, 9141, 9186);
        } finally {
            _bcornu_methode_context489.methodEnd();
        }
    }

    public void load(double[] in) throws NullArgumentException {
        MethodContext _bcornu_methode_context2213 = new MethodContext(void.class, 228, 9199, 9800);
        try {
            CallChecker.varInit(this, "this", 228, 9199, 9800);
            CallChecker.varInit(in, "in", 228, 9199, 9800);
            CallChecker.varInit(this.random, "random", 228, 9199, 9800);
            CallChecker.varInit(this.randomData, "randomData", 228, 9199, 9800);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 228, 9199, 9800);
            CallChecker.varInit(this.upperBounds, "upperBounds", 228, 9199, 9800);
            CallChecker.varInit(this.loaded, "loaded", 228, 9199, 9800);
            CallChecker.varInit(this.binCount, "binCount", 228, 9199, 9800);
            CallChecker.varInit(this.delta, "delta", 228, 9199, 9800);
            CallChecker.varInit(this.min, "min", 228, 9199, 9800);
            CallChecker.varInit(this.max, "max", 228, 9199, 9800);
            CallChecker.varInit(this.sampleStats, "sampleStats", 228, 9199, 9800);
            CallChecker.varInit(this.binStats, "binStats", 228, 9199, 9800);
            CallChecker.varInit(this.randomData, "randomData", 228, 9199, 9800);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.EmpiricalDistribution.serialVersionUID", 228, 9199, 9800);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.EmpiricalDistribution.FILE_CHARSET", 228, 9199, 9800);
            CallChecker.varInit(DEFAULT_BIN_COUNT, "org.apache.commons.math3.random.EmpiricalDistribution.DEFAULT_BIN_COUNT", 228, 9199, 9800);
            EmpiricalDistribution.DataAdapter da = CallChecker.varInit(new EmpiricalDistribution.ArrayDataAdapter(in), "da", 229, 9469, 9510);
            TryContext _bcornu_try_context_36 = new TryContext(36, EmpiricalDistribution.class, "java.io.IOException");
            try {
                if (CallChecker.beforeDeref(da, EmpiricalDistribution.DataAdapter.class, 231, 9538, 9539)) {
                    da = CallChecker.beforeCalled(da, EmpiricalDistribution.DataAdapter.class, 231, 9538, 9539);
                    CallChecker.isCalled(da, EmpiricalDistribution.DataAdapter.class, 231, 9538, 9539).computeStats();
                }
                fillBinStats(new EmpiricalDistribution.ArrayDataAdapter(in));
            } catch (IOException ex) {
                _bcornu_try_context_36.catchStart(36);
                throw new MathInternalError();
            } finally {
                _bcornu_try_context_36.finallyStart(36);
            }
            loaded = true;
            CallChecker.varAssign(this.loaded, "this.loaded", 238, 9780, 9793);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2213.methodEnd();
        }
    }

    public void load(URL url) throws IOException, NullArgumentException, ZeroException {
        MethodContext _bcornu_methode_context2214 = new MethodContext(void.class, 254, 9807, 11132);
        try {
            CallChecker.varInit(this, "this", 254, 9807, 11132);
            CallChecker.varInit(url, "url", 254, 9807, 11132);
            CallChecker.varInit(this.random, "random", 254, 9807, 11132);
            CallChecker.varInit(this.randomData, "randomData", 254, 9807, 11132);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 254, 9807, 11132);
            CallChecker.varInit(this.upperBounds, "upperBounds", 254, 9807, 11132);
            CallChecker.varInit(this.loaded, "loaded", 254, 9807, 11132);
            CallChecker.varInit(this.binCount, "binCount", 254, 9807, 11132);
            CallChecker.varInit(this.delta, "delta", 254, 9807, 11132);
            CallChecker.varInit(this.min, "min", 254, 9807, 11132);
            CallChecker.varInit(this.max, "max", 254, 9807, 11132);
            CallChecker.varInit(this.sampleStats, "sampleStats", 254, 9807, 11132);
            CallChecker.varInit(this.binStats, "binStats", 254, 9807, 11132);
            CallChecker.varInit(this.randomData, "randomData", 254, 9807, 11132);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.EmpiricalDistribution.serialVersionUID", 254, 9807, 11132);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.EmpiricalDistribution.FILE_CHARSET", 254, 9807, 11132);
            CallChecker.varInit(DEFAULT_BIN_COUNT, "org.apache.commons.math3.random.EmpiricalDistribution.DEFAULT_BIN_COUNT", 254, 9807, 11132);
            MathUtils.checkNotNull(url);
            Charset charset = CallChecker.varInit(Charset.forName(EmpiricalDistribution.FILE_CHARSET), "charset", 256, 10354, 10401);
            BufferedReader in = CallChecker.init(BufferedReader.class);
            if (CallChecker.beforeDeref(url, URL.class, 258, 10484, 10486)) {
                url = CallChecker.beforeCalled(url, URL.class, 258, 10484, 10486);
                in = new BufferedReader(new InputStreamReader(CallChecker.isCalled(url, URL.class, 258, 10484, 10486).openStream(), charset));
                CallChecker.varAssign(in, "in", 258, 10484, 10486);
            }
            TryContext _bcornu_try_context_38 = new TryContext(38, EmpiricalDistribution.class);
            try {
                EmpiricalDistribution.DataAdapter da = CallChecker.varInit(new EmpiricalDistribution.StreamDataAdapter(in), "da", 260, 10539, 10581);
                if (CallChecker.beforeDeref(da, EmpiricalDistribution.DataAdapter.class, 261, 10595, 10596)) {
                    da = CallChecker.beforeCalled(da, EmpiricalDistribution.DataAdapter.class, 261, 10595, 10596);
                    CallChecker.isCalled(da, EmpiricalDistribution.DataAdapter.class, 261, 10595, 10596).computeStats();
                }
                if (CallChecker.beforeDeref(sampleStats, SummaryStatistics.class, 262, 10630, 10640)) {
                    sampleStats = CallChecker.beforeCalled(sampleStats, SummaryStatistics.class, 262, 10630, 10640);
                    if ((CallChecker.isCalled(sampleStats, SummaryStatistics.class, 262, 10630, 10640).getN()) == 0) {
                        throw new ZeroException(LocalizedFormats.URL_CONTAINS_NO_DATA, url);
                    }
                }
                if (CallChecker.beforeDeref(url, URL.class, 266, 10861, 10863)) {
                    url = CallChecker.beforeCalled(url, URL.class, 266, 10861, 10863);
                    in = new BufferedReader(new InputStreamReader(CallChecker.isCalled(url, URL.class, 266, 10861, 10863).openStream(), charset));
                    CallChecker.varAssign(in, "in", 266, 10815, 10888);
                }
                fillBinStats(new EmpiricalDistribution.StreamDataAdapter(in));
                loaded = true;
                CallChecker.varAssign(this.loaded, "this.loaded", 268, 10955, 10968);
            } finally {
                _bcornu_try_context_38.finallyStart(38);
                TryContext _bcornu_try_context_37 = new TryContext(37, EmpiricalDistribution.class, "java.io.IOException");
                try {
                    if (CallChecker.beforeDeref(in, BufferedReader.class, 271, 11022, 11023)) {
                        in = CallChecker.beforeCalled(in, BufferedReader.class, 271, 11022, 11023);
                        CallChecker.isCalled(in, BufferedReader.class, 271, 11022, 11023).close();
                    }
                } catch (IOException ex) {
                    _bcornu_try_context_37.catchStart(37);
                } finally {
                    _bcornu_try_context_37.finallyStart(37);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2214.methodEnd();
        }
    }

    public void load(File file) throws IOException, NullArgumentException {
        MethodContext _bcornu_methode_context2215 = new MethodContext(void.class, 288, 11139, 12295);
        try {
            CallChecker.varInit(this, "this", 288, 11139, 12295);
            CallChecker.varInit(file, "file", 288, 11139, 12295);
            CallChecker.varInit(this.random, "random", 288, 11139, 12295);
            CallChecker.varInit(this.randomData, "randomData", 288, 11139, 12295);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 288, 11139, 12295);
            CallChecker.varInit(this.upperBounds, "upperBounds", 288, 11139, 12295);
            CallChecker.varInit(this.loaded, "loaded", 288, 11139, 12295);
            CallChecker.varInit(this.binCount, "binCount", 288, 11139, 12295);
            CallChecker.varInit(this.delta, "delta", 288, 11139, 12295);
            CallChecker.varInit(this.min, "min", 288, 11139, 12295);
            CallChecker.varInit(this.max, "max", 288, 11139, 12295);
            CallChecker.varInit(this.sampleStats, "sampleStats", 288, 11139, 12295);
            CallChecker.varInit(this.binStats, "binStats", 288, 11139, 12295);
            CallChecker.varInit(this.randomData, "randomData", 288, 11139, 12295);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.EmpiricalDistribution.serialVersionUID", 288, 11139, 12295);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.EmpiricalDistribution.FILE_CHARSET", 288, 11139, 12295);
            CallChecker.varInit(DEFAULT_BIN_COUNT, "org.apache.commons.math3.random.EmpiricalDistribution.DEFAULT_BIN_COUNT", 288, 11139, 12295);
            MathUtils.checkNotNull(file);
            Charset charset = CallChecker.varInit(Charset.forName(EmpiricalDistribution.FILE_CHARSET), "charset", 290, 11602, 11649);
            InputStream is = CallChecker.varInit(new FileInputStream(file), "is", 291, 11659, 11701);
            BufferedReader in = CallChecker.varInit(new BufferedReader(new InputStreamReader(is, charset)), "in", 292, 11711, 11785);
            TryContext _bcornu_try_context_40 = new TryContext(40, EmpiricalDistribution.class);
            try {
                EmpiricalDistribution.DataAdapter da = CallChecker.varInit(new EmpiricalDistribution.StreamDataAdapter(in), "da", 294, 11813, 11855);
                if (CallChecker.beforeDeref(da, EmpiricalDistribution.DataAdapter.class, 295, 11869, 11870)) {
                    da = CallChecker.beforeCalled(da, EmpiricalDistribution.DataAdapter.class, 295, 11869, 11870);
                    CallChecker.isCalled(da, EmpiricalDistribution.DataAdapter.class, 295, 11869, 11870).computeStats();
                }
                is = new FileInputStream(file);
                CallChecker.varAssign(is, "is", 297, 11943, 11973);
                in = new BufferedReader(new InputStreamReader(is, charset));
                CallChecker.varAssign(in, "in", 298, 11987, 12046);
                fillBinStats(new EmpiricalDistribution.StreamDataAdapter(in));
                loaded = true;
                CallChecker.varAssign(this.loaded, "this.loaded", 300, 12113, 12126);
            } finally {
                _bcornu_try_context_40.finallyStart(40);
                TryContext _bcornu_try_context_39 = new TryContext(39, EmpiricalDistribution.class, "java.io.IOException");
                try {
                    if (CallChecker.beforeDeref(in, BufferedReader.class, 303, 12182, 12183)) {
                        in = CallChecker.beforeCalled(in, BufferedReader.class, 303, 12182, 12183);
                        CallChecker.isCalled(in, BufferedReader.class, 303, 12182, 12183).close();
                    }
                } catch (IOException ex) {
                    _bcornu_try_context_39.catchStart(39);
                } finally {
                    _bcornu_try_context_39.finallyStart(39);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2215.methodEnd();
        }
    }

    private void fillBinStats(final EmpiricalDistribution.DataAdapter da) throws IOException {
        MethodContext _bcornu_methode_context2216 = new MethodContext(void.class, 426, 15608, 16799);
        try {
            CallChecker.varInit(this, "this", 426, 15608, 16799);
            CallChecker.varInit(da, "da", 426, 15608, 16799);
            CallChecker.varInit(this.random, "random", 426, 15608, 16799);
            CallChecker.varInit(this.randomData, "randomData", 426, 15608, 16799);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 426, 15608, 16799);
            CallChecker.varInit(this.upperBounds, "upperBounds", 426, 15608, 16799);
            CallChecker.varInit(this.loaded, "loaded", 426, 15608, 16799);
            CallChecker.varInit(this.binCount, "binCount", 426, 15608, 16799);
            CallChecker.varInit(this.delta, "delta", 426, 15608, 16799);
            CallChecker.varInit(this.min, "min", 426, 15608, 16799);
            CallChecker.varInit(this.max, "max", 426, 15608, 16799);
            CallChecker.varInit(this.sampleStats, "sampleStats", 426, 15608, 16799);
            CallChecker.varInit(this.binStats, "binStats", 426, 15608, 16799);
            CallChecker.varInit(this.randomData, "randomData", 426, 15608, 16799);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.EmpiricalDistribution.serialVersionUID", 426, 15608, 16799);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.EmpiricalDistribution.FILE_CHARSET", 426, 15608, 16799);
            CallChecker.varInit(DEFAULT_BIN_COUNT, "org.apache.commons.math3.random.EmpiricalDistribution.DEFAULT_BIN_COUNT", 426, 15608, 16799);
            if (CallChecker.beforeDeref(sampleStats, SummaryStatistics.class, 429, 15909, 15919)) {
                sampleStats = CallChecker.beforeCalled(sampleStats, SummaryStatistics.class, 429, 15909, 15919);
                min = CallChecker.isCalled(sampleStats, SummaryStatistics.class, 429, 15909, 15919).getMin();
                CallChecker.varAssign(this.min, "this.min", 429, 15903, 15929);
            }
            if (CallChecker.beforeDeref(sampleStats, SummaryStatistics.class, 430, 15945, 15955)) {
                sampleStats = CallChecker.beforeCalled(sampleStats, SummaryStatistics.class, 430, 15945, 15955);
                max = CallChecker.isCalled(sampleStats, SummaryStatistics.class, 430, 15945, 15955).getMax();
                CallChecker.varAssign(this.max, "this.max", 430, 15939, 15965);
            }
            if (CallChecker.beforeDeref(Double.valueOf(binCount), Double.class, 431, 15995, 16020)) {
                delta = ((max) - (min)) / (CallChecker.isCalled(Double.valueOf(binCount), Double.class, 431, 15995, 16020).doubleValue());
                CallChecker.varAssign(this.delta, "this.delta", 431, 15975, 16035);
            }
            if (CallChecker.beforeDeref(binStats, List.class, 434, 16092, 16099)) {
                if (!(CallChecker.isCalled(binStats, List.class, 434, 16092, 16099).isEmpty())) {
                    if (CallChecker.beforeDeref(binStats, List.class, 435, 16126, 16133)) {
                        CallChecker.isCalled(binStats, List.class, 435, 16126, 16133).clear();
                    }
                }
            }
            for (int i = 0; i < (binCount); i++) {
                SummaryStatistics stats = CallChecker.varInit(new SummaryStatistics(), "stats", 438, 16211, 16260);
                if (CallChecker.beforeDeref(binStats, List.class, 439, 16274, 16281)) {
                    CallChecker.isCalled(binStats, List.class, 439, 16274, 16281).add(i, stats);
                }
            }
            if (CallChecker.beforeDeref(da, EmpiricalDistribution.DataAdapter.class, 443, 16358, 16359)) {
                CallChecker.isCalled(da, EmpiricalDistribution.DataAdapter.class, 443, 16358, 16359).computeBinStats();
            }
            upperBounds = new double[binCount];
            CallChecker.varAssign(this.upperBounds, "this.upperBounds", 446, 16439, 16473);
            if (CallChecker.beforeDeref(upperBounds, double[].class, 447, 16483, 16493)) {
                if (CallChecker.beforeDeref(binStats, List.class, 448, 16518, 16525)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(binStats, List.class, 448, 16518, 16525).get(0), SummaryStatistics.class, 448, 16518, 16532)) {
                        if (CallChecker.beforeDeref(sampleStats, SummaryStatistics.class, 448, 16553, 16563)) {
                            upperBounds = CallChecker.beforeCalled(upperBounds, double[].class, 447, 16483, 16493);
                            sampleStats = CallChecker.beforeCalled(sampleStats, SummaryStatistics.class, 448, 16553, 16563);
                            CallChecker.isCalled(upperBounds, double[].class, 447, 16483, 16493)[0] = ((double) (CallChecker.isCalled(CallChecker.isCalled(binStats, List.class, 448, 16518, 16525).get(0), SummaryStatistics.class, 448, 16518, 16532).getN())) / ((double) (CallChecker.isCalled(sampleStats, SummaryStatistics.class, 448, 16553, 16563).getN()));
                            CallChecker.varAssign(CallChecker.isCalled(this.upperBounds, double[].class, 447, 16483, 16493)[0], "CallChecker.isCalled(this.upperBounds, double[].class, 447, 16483, 16493)[0]", 447, 16483, 16571);
                        }
                    }
                }
            }
            for (int i = 1; i < ((binCount) - 1); i++) {
                if (CallChecker.beforeDeref(upperBounds, double[].class, 450, 16632, 16642)) {
                    if (CallChecker.beforeDeref(upperBounds, double[].class, 450, 16649, 16659)) {
                        if (CallChecker.beforeDeref(binStats, List.class, 451, 16690, 16697)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(binStats, List.class, 451, 16690, 16697).get(i), SummaryStatistics.class, 451, 16690, 16704)) {
                                if (CallChecker.beforeDeref(sampleStats, SummaryStatistics.class, 451, 16725, 16735)) {
                                    upperBounds = CallChecker.beforeCalled(upperBounds, double[].class, 450, 16632, 16642);
                                    upperBounds = CallChecker.beforeCalled(upperBounds, double[].class, 450, 16649, 16659);
                                    sampleStats = CallChecker.beforeCalled(sampleStats, SummaryStatistics.class, 451, 16725, 16735);
                                    CallChecker.isCalled(upperBounds, double[].class, 450, 16632, 16642)[i] = (CallChecker.isCalled(upperBounds, double[].class, 450, 16649, 16659)[(i - 1)]) + (((double) (CallChecker.isCalled(CallChecker.isCalled(binStats, List.class, 451, 16690, 16697).get(i), SummaryStatistics.class, 451, 16690, 16704).getN())) / ((double) (CallChecker.isCalled(sampleStats, SummaryStatistics.class, 451, 16725, 16735).getN())));
                                    CallChecker.varAssign(CallChecker.isCalled(this.upperBounds, double[].class, 450, 16632, 16642)[i], "CallChecker.isCalled(this.upperBounds, double[].class, 450, 16632, 16642)[i]", 450, 16632, 16743);
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(upperBounds, double[].class, 453, 16763, 16773)) {
                upperBounds = CallChecker.beforeCalled(upperBounds, double[].class, 453, 16763, 16773);
                CallChecker.isCalled(upperBounds, double[].class, 453, 16763, 16773)[((binCount) - 1)] = 1.0;
                CallChecker.varAssign(CallChecker.isCalled(this.upperBounds, double[].class, 453, 16763, 16773)[((this.binCount) - 1)], "CallChecker.isCalled(this.upperBounds, double[].class, 453, 16763, 16773)[((this.binCount) - 1)]", 453, 16763, 16793);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2216.methodEnd();
        }
    }

    private int findBin(double value) {
        MethodContext _bcornu_methode_context2217 = new MethodContext(int.class, 462, 16806, 17199);
        try {
            CallChecker.varInit(this, "this", 462, 16806, 17199);
            CallChecker.varInit(value, "value", 462, 16806, 17199);
            CallChecker.varInit(this.random, "random", 462, 16806, 17199);
            CallChecker.varInit(this.randomData, "randomData", 462, 16806, 17199);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 462, 16806, 17199);
            CallChecker.varInit(this.upperBounds, "upperBounds", 462, 16806, 17199);
            CallChecker.varInit(this.loaded, "loaded", 462, 16806, 17199);
            CallChecker.varInit(this.binCount, "binCount", 462, 16806, 17199);
            CallChecker.varInit(this.delta, "delta", 462, 16806, 17199);
            CallChecker.varInit(this.min, "min", 462, 16806, 17199);
            CallChecker.varInit(this.max, "max", 462, 16806, 17199);
            CallChecker.varInit(this.sampleStats, "sampleStats", 462, 16806, 17199);
            CallChecker.varInit(this.binStats, "binStats", 462, 16806, 17199);
            CallChecker.varInit(this.randomData, "randomData", 462, 16806, 17199);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.EmpiricalDistribution.serialVersionUID", 462, 16806, 17199);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.EmpiricalDistribution.FILE_CHARSET", 462, 16806, 17199);
            CallChecker.varInit(DEFAULT_BIN_COUNT, "org.apache.commons.math3.random.EmpiricalDistribution.DEFAULT_BIN_COUNT", 462, 16806, 17199);
            return FastMath.min(FastMath.max((((int) (FastMath.ceil(((value - (min)) / (delta))))) - 1), 0), ((binCount) - 1));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2217.methodEnd();
        }
    }

    public double getNextValue() throws MathIllegalStateException {
        MethodContext _bcornu_methode_context2218 = new MethodContext(double.class, 475, 17206, 18467);
        try {
            CallChecker.varInit(this, "this", 475, 17206, 18467);
            CallChecker.varInit(this.random, "random", 475, 17206, 18467);
            CallChecker.varInit(this.randomData, "randomData", 475, 17206, 18467);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 475, 17206, 18467);
            CallChecker.varInit(this.upperBounds, "upperBounds", 475, 17206, 18467);
            CallChecker.varInit(this.loaded, "loaded", 475, 17206, 18467);
            CallChecker.varInit(this.binCount, "binCount", 475, 17206, 18467);
            CallChecker.varInit(this.delta, "delta", 475, 17206, 18467);
            CallChecker.varInit(this.min, "min", 475, 17206, 18467);
            CallChecker.varInit(this.max, "max", 475, 17206, 18467);
            CallChecker.varInit(this.sampleStats, "sampleStats", 475, 17206, 18467);
            CallChecker.varInit(this.binStats, "binStats", 475, 17206, 18467);
            CallChecker.varInit(this.randomData, "randomData", 475, 17206, 18467);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.EmpiricalDistribution.serialVersionUID", 475, 17206, 18467);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.EmpiricalDistribution.FILE_CHARSET", 475, 17206, 18467);
            CallChecker.varInit(DEFAULT_BIN_COUNT, "org.apache.commons.math3.random.EmpiricalDistribution.DEFAULT_BIN_COUNT", 475, 17206, 18467);
            if (!(loaded)) {
                throw new MathIllegalStateException(LocalizedFormats.DISTRIBUTION_NOT_LOADED);
            }
            final double x = CallChecker.varInit(((double) (CallChecker.isCalled(this.randomData, RandomDataGenerator.class, 482, 17800, 17809).nextUniform(0, 1))), "x", 482, 17714, 17827);
            for (int i = 0; i < (binCount); i++) {
                if (CallChecker.beforeDeref(upperBounds, double[].class, 486, 17972, 17982)) {
                    upperBounds = CallChecker.beforeCalled(upperBounds, double[].class, 486, 17972, 17982);
                    if (x <= (CallChecker.isCalled(upperBounds, double[].class, 486, 17972, 17982)[i])) {
                        SummaryStatistics stats = CallChecker.init(SummaryStatistics.class);
                        if (CallChecker.beforeDeref(binStats, List.class, 487, 18031, 18038)) {
                            stats = CallChecker.isCalled(binStats, List.class, 487, 18031, 18038).get(i);
                            CallChecker.varAssign(stats, "stats", 487, 18031, 18038);
                        }
                        if (CallChecker.beforeDeref(stats, SummaryStatistics.class, 488, 18067, 18071)) {
                            stats = CallChecker.beforeCalled(stats, SummaryStatistics.class, 488, 18067, 18071);
                            if ((CallChecker.isCalled(stats, SummaryStatistics.class, 488, 18067, 18071).getN()) > 0) {
                                if (CallChecker.beforeDeref(stats, SummaryStatistics.class, 489, 18110, 18114)) {
                                    stats = CallChecker.beforeCalled(stats, SummaryStatistics.class, 489, 18110, 18114);
                                    if ((CallChecker.isCalled(stats, SummaryStatistics.class, 489, 18110, 18114).getStandardDeviation()) > 0) {
                                        final RealDistribution npe_invocation_var630 = getKernel(stats);
                                        if (CallChecker.beforeDeref(npe_invocation_var630, RealDistribution.class, 490, 18198, 18213)) {
                                            return CallChecker.isCalled(npe_invocation_var630, RealDistribution.class, 490, 18198, 18213).sample();
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else {
                                        if (CallChecker.beforeDeref(stats, SummaryStatistics.class, 492, 18283, 18287)) {
                                            stats = CallChecker.beforeCalled(stats, SummaryStatistics.class, 492, 18283, 18287);
                                            return CallChecker.isCalled(stats, SummaryStatistics.class, 492, 18283, 18287).getMean();
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            throw new MathIllegalStateException(LocalizedFormats.NO_BIN_SELECTED);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2218.methodEnd();
        }
    }

    public StatisticalSummary getSampleStats() {
        MethodContext _bcornu_methode_context2219 = new MethodContext(StatisticalSummary.class, 508, 18474, 18886);
        try {
            CallChecker.varInit(this, "this", 508, 18474, 18886);
            CallChecker.varInit(this.random, "random", 508, 18474, 18886);
            CallChecker.varInit(this.randomData, "randomData", 508, 18474, 18886);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 508, 18474, 18886);
            CallChecker.varInit(this.upperBounds, "upperBounds", 508, 18474, 18886);
            CallChecker.varInit(this.loaded, "loaded", 508, 18474, 18886);
            CallChecker.varInit(this.binCount, "binCount", 508, 18474, 18886);
            CallChecker.varInit(this.delta, "delta", 508, 18474, 18886);
            CallChecker.varInit(this.min, "min", 508, 18474, 18886);
            CallChecker.varInit(this.max, "max", 508, 18474, 18886);
            CallChecker.varInit(this.sampleStats, "sampleStats", 508, 18474, 18886);
            CallChecker.varInit(this.binStats, "binStats", 508, 18474, 18886);
            CallChecker.varInit(this.randomData, "randomData", 508, 18474, 18886);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.EmpiricalDistribution.serialVersionUID", 508, 18474, 18886);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.EmpiricalDistribution.FILE_CHARSET", 508, 18474, 18886);
            CallChecker.varInit(DEFAULT_BIN_COUNT, "org.apache.commons.math3.random.EmpiricalDistribution.DEFAULT_BIN_COUNT", 508, 18474, 18886);
            return sampleStats;
        } catch (ForceReturn _bcornu_return_t) {
            return ((StatisticalSummary) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2219.methodEnd();
        }
    }

    public int getBinCount() {
        MethodContext _bcornu_methode_context2220 = new MethodContext(int.class, 517, 18893, 19042);
        try {
            CallChecker.varInit(this, "this", 517, 18893, 19042);
            CallChecker.varInit(this.random, "random", 517, 18893, 19042);
            CallChecker.varInit(this.randomData, "randomData", 517, 18893, 19042);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 517, 18893, 19042);
            CallChecker.varInit(this.upperBounds, "upperBounds", 517, 18893, 19042);
            CallChecker.varInit(this.loaded, "loaded", 517, 18893, 19042);
            CallChecker.varInit(this.binCount, "binCount", 517, 18893, 19042);
            CallChecker.varInit(this.delta, "delta", 517, 18893, 19042);
            CallChecker.varInit(this.min, "min", 517, 18893, 19042);
            CallChecker.varInit(this.max, "max", 517, 18893, 19042);
            CallChecker.varInit(this.sampleStats, "sampleStats", 517, 18893, 19042);
            CallChecker.varInit(this.binStats, "binStats", 517, 18893, 19042);
            CallChecker.varInit(this.randomData, "randomData", 517, 18893, 19042);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.EmpiricalDistribution.serialVersionUID", 517, 18893, 19042);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.EmpiricalDistribution.FILE_CHARSET", 517, 18893, 19042);
            CallChecker.varInit(DEFAULT_BIN_COUNT, "org.apache.commons.math3.random.EmpiricalDistribution.DEFAULT_BIN_COUNT", 517, 18893, 19042);
            return binCount;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2220.methodEnd();
        }
    }

    public List<SummaryStatistics> getBinStats() {
        MethodContext _bcornu_methode_context2221 = new MethodContext(List.class, 528, 19049, 19367);
        try {
            CallChecker.varInit(this, "this", 528, 19049, 19367);
            CallChecker.varInit(this.random, "random", 528, 19049, 19367);
            CallChecker.varInit(this.randomData, "randomData", 528, 19049, 19367);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 528, 19049, 19367);
            CallChecker.varInit(this.upperBounds, "upperBounds", 528, 19049, 19367);
            CallChecker.varInit(this.loaded, "loaded", 528, 19049, 19367);
            CallChecker.varInit(this.binCount, "binCount", 528, 19049, 19367);
            CallChecker.varInit(this.delta, "delta", 528, 19049, 19367);
            CallChecker.varInit(this.min, "min", 528, 19049, 19367);
            CallChecker.varInit(this.max, "max", 528, 19049, 19367);
            CallChecker.varInit(this.sampleStats, "sampleStats", 528, 19049, 19367);
            CallChecker.varInit(this.binStats, "binStats", 528, 19049, 19367);
            CallChecker.varInit(this.randomData, "randomData", 528, 19049, 19367);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.EmpiricalDistribution.serialVersionUID", 528, 19049, 19367);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.EmpiricalDistribution.FILE_CHARSET", 528, 19049, 19367);
            CallChecker.varInit(DEFAULT_BIN_COUNT, "org.apache.commons.math3.random.EmpiricalDistribution.DEFAULT_BIN_COUNT", 528, 19049, 19367);
            return binStats;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<SummaryStatistics>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2221.methodEnd();
        }
    }

    public double[] getUpperBounds() {
        MethodContext _bcornu_methode_context2222 = new MethodContext(double[].class, 545, 19374, 20183);
        try {
            CallChecker.varInit(this, "this", 545, 19374, 20183);
            CallChecker.varInit(this.random, "random", 545, 19374, 20183);
            CallChecker.varInit(this.randomData, "randomData", 545, 19374, 20183);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 545, 19374, 20183);
            CallChecker.varInit(this.upperBounds, "upperBounds", 545, 19374, 20183);
            CallChecker.varInit(this.loaded, "loaded", 545, 19374, 20183);
            CallChecker.varInit(this.binCount, "binCount", 545, 19374, 20183);
            CallChecker.varInit(this.delta, "delta", 545, 19374, 20183);
            CallChecker.varInit(this.min, "min", 545, 19374, 20183);
            CallChecker.varInit(this.max, "max", 545, 19374, 20183);
            CallChecker.varInit(this.sampleStats, "sampleStats", 545, 19374, 20183);
            CallChecker.varInit(this.binStats, "binStats", 545, 19374, 20183);
            CallChecker.varInit(this.randomData, "randomData", 545, 19374, 20183);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.EmpiricalDistribution.serialVersionUID", 545, 19374, 20183);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.EmpiricalDistribution.FILE_CHARSET", 545, 19374, 20183);
            CallChecker.varInit(DEFAULT_BIN_COUNT, "org.apache.commons.math3.random.EmpiricalDistribution.DEFAULT_BIN_COUNT", 545, 19374, 20183);
            double[] binUpperBounds = CallChecker.varInit(new double[binCount], "binUpperBounds", 546, 19942, 19988);
            for (int i = 0; i < ((binCount) - 1); i++) {
                if (CallChecker.beforeDeref(binUpperBounds, double[].class, 548, 20051, 20064)) {
                    binUpperBounds = CallChecker.beforeCalled(binUpperBounds, double[].class, 548, 20051, 20064);
                    CallChecker.isCalled(binUpperBounds, double[].class, 548, 20051, 20064)[i] = (min) + ((delta) * (i + 1));
                    CallChecker.varAssign(CallChecker.isCalled(binUpperBounds, double[].class, 548, 20051, 20064)[i], "CallChecker.isCalled(binUpperBounds, double[].class, 548, 20051, 20064)[i]", 548, 20051, 20092);
                }
            }
            if (CallChecker.beforeDeref(binUpperBounds, double[].class, 550, 20112, 20125)) {
                binUpperBounds = CallChecker.beforeCalled(binUpperBounds, double[].class, 550, 20112, 20125);
                CallChecker.isCalled(binUpperBounds, double[].class, 550, 20112, 20125)[((binCount) - 1)] = max;
                CallChecker.varAssign(CallChecker.isCalled(binUpperBounds, double[].class, 550, 20112, 20125)[((this.binCount) - 1)], "CallChecker.isCalled(binUpperBounds, double[].class, 550, 20112, 20125)[((this.binCount) - 1)]", 550, 20112, 20146);
            }
            return binUpperBounds;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2222.methodEnd();
        }
    }

    public double[] getGeneratorUpperBounds() {
        MethodContext _bcornu_methode_context2223 = new MethodContext(double[].class, 565, 20190, 20879);
        try {
            CallChecker.varInit(this, "this", 565, 20190, 20879);
            CallChecker.varInit(this.random, "random", 565, 20190, 20879);
            CallChecker.varInit(this.randomData, "randomData", 565, 20190, 20879);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 565, 20190, 20879);
            CallChecker.varInit(this.upperBounds, "upperBounds", 565, 20190, 20879);
            CallChecker.varInit(this.loaded, "loaded", 565, 20190, 20879);
            CallChecker.varInit(this.binCount, "binCount", 565, 20190, 20879);
            CallChecker.varInit(this.delta, "delta", 565, 20190, 20879);
            CallChecker.varInit(this.min, "min", 565, 20190, 20879);
            CallChecker.varInit(this.max, "max", 565, 20190, 20879);
            CallChecker.varInit(this.sampleStats, "sampleStats", 565, 20190, 20879);
            CallChecker.varInit(this.binStats, "binStats", 565, 20190, 20879);
            CallChecker.varInit(this.randomData, "randomData", 565, 20190, 20879);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.EmpiricalDistribution.serialVersionUID", 565, 20190, 20879);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.EmpiricalDistribution.FILE_CHARSET", 565, 20190, 20879);
            CallChecker.varInit(DEFAULT_BIN_COUNT, "org.apache.commons.math3.random.EmpiricalDistribution.DEFAULT_BIN_COUNT", 565, 20190, 20879);
            int len = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(upperBounds, double[].class, 566, 20740, 20750)) {
                upperBounds = CallChecker.beforeCalled(upperBounds, double[].class, 566, 20740, 20750);
                len = CallChecker.isCalled(upperBounds, double[].class, 566, 20740, 20750).length;
                CallChecker.varAssign(len, "len", 566, 20740, 20750);
            }
            double[] out = CallChecker.varInit(new double[len], "out", 567, 20768, 20798);
            System.arraycopy(upperBounds, 0, out, 0, len);
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2223.methodEnd();
        }
    }

    public boolean isLoaded() {
        MethodContext _bcornu_methode_context2224 = new MethodContext(boolean.class, 577, 20886, 21096);
        try {
            CallChecker.varInit(this, "this", 577, 20886, 21096);
            CallChecker.varInit(this.random, "random", 577, 20886, 21096);
            CallChecker.varInit(this.randomData, "randomData", 577, 20886, 21096);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 577, 20886, 21096);
            CallChecker.varInit(this.upperBounds, "upperBounds", 577, 20886, 21096);
            CallChecker.varInit(this.loaded, "loaded", 577, 20886, 21096);
            CallChecker.varInit(this.binCount, "binCount", 577, 20886, 21096);
            CallChecker.varInit(this.delta, "delta", 577, 20886, 21096);
            CallChecker.varInit(this.min, "min", 577, 20886, 21096);
            CallChecker.varInit(this.max, "max", 577, 20886, 21096);
            CallChecker.varInit(this.sampleStats, "sampleStats", 577, 20886, 21096);
            CallChecker.varInit(this.binStats, "binStats", 577, 20886, 21096);
            CallChecker.varInit(this.randomData, "randomData", 577, 20886, 21096);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.EmpiricalDistribution.serialVersionUID", 577, 20886, 21096);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.EmpiricalDistribution.FILE_CHARSET", 577, 20886, 21096);
            CallChecker.varInit(DEFAULT_BIN_COUNT, "org.apache.commons.math3.random.EmpiricalDistribution.DEFAULT_BIN_COUNT", 577, 20886, 21096);
            return loaded;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2224.methodEnd();
        }
    }

    public void reSeed(long seed) {
        MethodContext _bcornu_methode_context2225 = new MethodContext(void.class, 587, 21103, 21330);
        try {
            CallChecker.varInit(this, "this", 587, 21103, 21330);
            CallChecker.varInit(seed, "seed", 587, 21103, 21330);
            CallChecker.varInit(this.random, "random", 587, 21103, 21330);
            CallChecker.varInit(this.randomData, "randomData", 587, 21103, 21330);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 587, 21103, 21330);
            CallChecker.varInit(this.upperBounds, "upperBounds", 587, 21103, 21330);
            CallChecker.varInit(this.loaded, "loaded", 587, 21103, 21330);
            CallChecker.varInit(this.binCount, "binCount", 587, 21103, 21330);
            CallChecker.varInit(this.delta, "delta", 587, 21103, 21330);
            CallChecker.varInit(this.min, "min", 587, 21103, 21330);
            CallChecker.varInit(this.max, "max", 587, 21103, 21330);
            CallChecker.varInit(this.sampleStats, "sampleStats", 587, 21103, 21330);
            CallChecker.varInit(this.binStats, "binStats", 587, 21103, 21330);
            CallChecker.varInit(this.randomData, "randomData", 587, 21103, 21330);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.EmpiricalDistribution.serialVersionUID", 587, 21103, 21330);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.EmpiricalDistribution.FILE_CHARSET", 587, 21103, 21330);
            CallChecker.varInit(DEFAULT_BIN_COUNT, "org.apache.commons.math3.random.EmpiricalDistribution.DEFAULT_BIN_COUNT", 587, 21103, 21330);
            if (CallChecker.beforeDeref(randomData, RandomDataGenerator.class, 588, 21301, 21310)) {
                CallChecker.isCalled(randomData, RandomDataGenerator.class, 588, 21301, 21310).reSeed(seed);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2225.methodEnd();
        }
    }

    public double probability(double x) {
        MethodContext _bcornu_methode_context2226 = new MethodContext(double.class, 597, 21337, 21509);
        try {
            CallChecker.varInit(this, "this", 597, 21337, 21509);
            CallChecker.varInit(x, "x", 597, 21337, 21509);
            CallChecker.varInit(this.random, "random", 597, 21337, 21509);
            CallChecker.varInit(this.randomData, "randomData", 597, 21337, 21509);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 597, 21337, 21509);
            CallChecker.varInit(this.upperBounds, "upperBounds", 597, 21337, 21509);
            CallChecker.varInit(this.loaded, "loaded", 597, 21337, 21509);
            CallChecker.varInit(this.binCount, "binCount", 597, 21337, 21509);
            CallChecker.varInit(this.delta, "delta", 597, 21337, 21509);
            CallChecker.varInit(this.min, "min", 597, 21337, 21509);
            CallChecker.varInit(this.max, "max", 597, 21337, 21509);
            CallChecker.varInit(this.sampleStats, "sampleStats", 597, 21337, 21509);
            CallChecker.varInit(this.binStats, "binStats", 597, 21337, 21509);
            CallChecker.varInit(this.randomData, "randomData", 597, 21337, 21509);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.EmpiricalDistribution.serialVersionUID", 597, 21337, 21509);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.EmpiricalDistribution.FILE_CHARSET", 597, 21337, 21509);
            CallChecker.varInit(DEFAULT_BIN_COUNT, "org.apache.commons.math3.random.EmpiricalDistribution.DEFAULT_BIN_COUNT", 597, 21337, 21509);
            return 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2226.methodEnd();
        }
    }

    public double density(double x) {
        MethodContext _bcornu_methode_context2227 = new MethodContext(double.class, 615, 21516, 22341);
        try {
            CallChecker.varInit(this, "this", 615, 21516, 22341);
            CallChecker.varInit(x, "x", 615, 21516, 22341);
            CallChecker.varInit(this.random, "random", 615, 21516, 22341);
            CallChecker.varInit(this.randomData, "randomData", 615, 21516, 22341);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 615, 21516, 22341);
            CallChecker.varInit(this.upperBounds, "upperBounds", 615, 21516, 22341);
            CallChecker.varInit(this.loaded, "loaded", 615, 21516, 22341);
            CallChecker.varInit(this.binCount, "binCount", 615, 21516, 22341);
            CallChecker.varInit(this.delta, "delta", 615, 21516, 22341);
            CallChecker.varInit(this.min, "min", 615, 21516, 22341);
            CallChecker.varInit(this.max, "max", 615, 21516, 22341);
            CallChecker.varInit(this.sampleStats, "sampleStats", 615, 21516, 22341);
            CallChecker.varInit(this.binStats, "binStats", 615, 21516, 22341);
            CallChecker.varInit(this.randomData, "randomData", 615, 21516, 22341);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.EmpiricalDistribution.serialVersionUID", 615, 21516, 22341);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.EmpiricalDistribution.FILE_CHARSET", 615, 21516, 22341);
            CallChecker.varInit(DEFAULT_BIN_COUNT, "org.apache.commons.math3.random.EmpiricalDistribution.DEFAULT_BIN_COUNT", 615, 21516, 22341);
            if ((x < (min)) || (x > (max))) {
                return 0.0;
            }
            final int binIndex = CallChecker.varInit(((int) (findBin(x))), "binIndex", 619, 22165, 22196);
            final RealDistribution kernel = CallChecker.varInit(getKernel(CallChecker.isCalled(binStats, List.class, 620, 22248, 22255).get(binIndex)), "kernel", 620, 22206, 22271);
            return ((CallChecker.isCalled(kernel, RealDistribution.class, 621, 22288, 22293).density(x)) * (pB(binIndex))) / (kB(binIndex));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2227.methodEnd();
        }
    }

    public double cumulativeProbability(double x) {
        MethodContext _bcornu_methode_context2228 = new MethodContext(double.class, 637, 22348, 23604);
        try {
            CallChecker.varInit(this, "this", 637, 22348, 23604);
            CallChecker.varInit(x, "x", 637, 22348, 23604);
            CallChecker.varInit(this.random, "random", 637, 22348, 23604);
            CallChecker.varInit(this.randomData, "randomData", 637, 22348, 23604);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 637, 22348, 23604);
            CallChecker.varInit(this.upperBounds, "upperBounds", 637, 22348, 23604);
            CallChecker.varInit(this.loaded, "loaded", 637, 22348, 23604);
            CallChecker.varInit(this.binCount, "binCount", 637, 22348, 23604);
            CallChecker.varInit(this.delta, "delta", 637, 22348, 23604);
            CallChecker.varInit(this.min, "min", 637, 22348, 23604);
            CallChecker.varInit(this.max, "max", 637, 22348, 23604);
            CallChecker.varInit(this.sampleStats, "sampleStats", 637, 22348, 23604);
            CallChecker.varInit(this.binStats, "binStats", 637, 22348, 23604);
            CallChecker.varInit(this.randomData, "randomData", 637, 22348, 23604);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.EmpiricalDistribution.serialVersionUID", 637, 22348, 23604);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.EmpiricalDistribution.FILE_CHARSET", 637, 22348, 23604);
            CallChecker.varInit(DEFAULT_BIN_COUNT, "org.apache.commons.math3.random.EmpiricalDistribution.DEFAULT_BIN_COUNT", 637, 22348, 23604);
            if (x < (min)) {
                return 0.0;
            }else
                if (x >= (max)) {
                    return 1.0;
                }
            
            final int binIndex = CallChecker.varInit(((int) (findBin(x))), "binIndex", 643, 23091, 23122);
            final double pBminus = CallChecker.varInit(((double) (pBminus(binIndex))), "pBminus", 644, 23132, 23172);
            final double pB = CallChecker.varInit(((double) (pB(binIndex))), "pB", 645, 23182, 23212);
            final double[] binBounds = CallChecker.varInit(getUpperBounds(), "binBounds", 646, 23222, 23265);
            final double kB = CallChecker.varInit(((double) (kB(binIndex))), "kB", 647, 23275, 23305);
            double lower = CallChecker.init(double.class);
            if (binIndex == 0) {
                lower = min;
                CallChecker.varAssign(lower, "lower", 648, 23336, 23380);
            }else {
                if (CallChecker.beforeDeref(binBounds, double[].class, 648, 23358, 23366)) {
                    lower = CallChecker.isCalled(binBounds, double[].class, 648, 23358, 23366)[(binIndex - 1)];
                    CallChecker.varAssign(lower, "lower", 648, 23336, 23380);
                }
            }
            final RealDistribution kernel = CallChecker.varInit(k(x), "kernel", 649, 23391, 23427);
            final double withinBinCum = CallChecker.varInit(((double) (((CallChecker.isCalled(kernel, RealDistribution.class, 651, 23478, 23483).cumulativeProbability(x)) - (CallChecker.isCalled(kernel, RealDistribution.class, 651, 23513, 23518).cumulativeProbability(lower))) / kB)), "withinBinCum", 650, 23437, 23554);
            return pBminus + (pB * withinBinCum);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2228.methodEnd();
        }
    }

    public double inverseCumulativeProbability(final double p) throws OutOfRangeException {
        MethodContext _bcornu_methode_context2229 = new MethodContext(double.class, 675, 23611, 25324);
        try {
            CallChecker.varInit(this, "this", 675, 23611, 25324);
            CallChecker.varInit(p, "p", 675, 23611, 25324);
            CallChecker.varInit(this.random, "random", 675, 23611, 25324);
            CallChecker.varInit(this.randomData, "randomData", 675, 23611, 25324);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 675, 23611, 25324);
            CallChecker.varInit(this.upperBounds, "upperBounds", 675, 23611, 25324);
            CallChecker.varInit(this.loaded, "loaded", 675, 23611, 25324);
            CallChecker.varInit(this.binCount, "binCount", 675, 23611, 25324);
            CallChecker.varInit(this.delta, "delta", 675, 23611, 25324);
            CallChecker.varInit(this.min, "min", 675, 23611, 25324);
            CallChecker.varInit(this.max, "max", 675, 23611, 25324);
            CallChecker.varInit(this.sampleStats, "sampleStats", 675, 23611, 25324);
            CallChecker.varInit(this.binStats, "binStats", 675, 23611, 25324);
            CallChecker.varInit(this.randomData, "randomData", 675, 23611, 25324);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.EmpiricalDistribution.serialVersionUID", 675, 23611, 25324);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.EmpiricalDistribution.FILE_CHARSET", 675, 23611, 25324);
            CallChecker.varInit(DEFAULT_BIN_COUNT, "org.apache.commons.math3.random.EmpiricalDistribution.DEFAULT_BIN_COUNT", 675, 23611, 25324);
            if ((p < 0.0) || (p > 1.0)) {
                throw new OutOfRangeException(p, 0, 1);
            }
            if (p == 0.0) {
                return getSupportLowerBound();
            }
            if (p == 1.0) {
                return getSupportUpperBound();
            }
            int i = CallChecker.varInit(((int) (0)), "i", 688, 24705, 24714);
            while ((cumBinP(i)) < p) {
                i++;
            } 
            final RealDistribution kernel = CallChecker.varInit(getKernel(CallChecker.isCalled(binStats, List.class, 693, 24827, 24834).get(i)), "kernel", 693, 24785, 24843);
            final double kB = CallChecker.varInit(((double) (kB(i))), "kB", 694, 24853, 24876);
            final double[] binBounds = CallChecker.varInit(getUpperBounds(), "binBounds", 695, 24886, 24929);
            double lower = CallChecker.init(double.class);
            if (i == 0) {
                lower = min;
                CallChecker.varAssign(lower, "lower", 696, 24960, 24990);
            }else {
                if (CallChecker.beforeDeref(binBounds, double[].class, 696, 24975, 24983)) {
                    lower = CallChecker.isCalled(binBounds, double[].class, 696, 24975, 24983)[(i - 1)];
                    CallChecker.varAssign(lower, "lower", 696, 24960, 24990);
                }
            }
            final double kBminus = CallChecker.varInit(((double) (CallChecker.isCalled(kernel, RealDistribution.class, 697, 25024, 25029).cumulativeProbability(lower))), "kBminus", 697, 25001, 25059);
            final double pB = CallChecker.varInit(((double) (pB(i))), "pB", 698, 25069, 25092);
            final double pBminus = CallChecker.varInit(((double) (pBminus(i))), "pBminus", 699, 25102, 25135);
            final double pCrit = CallChecker.varInit(((double) (p - pBminus)), "pCrit", 700, 25145, 25177);
            if (pCrit <= 0) {
                return lower;
            }
            if (CallChecker.beforeDeref(kernel, RealDistribution.class, 704, 25256, 25261)) {
                return CallChecker.isCalled(kernel, RealDistribution.class, 704, 25256, 25261).inverseCumulativeProbability((kBminus + ((pCrit * kB) / pB)));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2229.methodEnd();
        }
    }

    public double getNumericalMean() {
        MethodContext _bcornu_methode_context2230 = new MethodContext(double.class, 711, 25331, 25462);
        try {
            CallChecker.varInit(this, "this", 711, 25331, 25462);
            CallChecker.varInit(this.random, "random", 711, 25331, 25462);
            CallChecker.varInit(this.randomData, "randomData", 711, 25331, 25462);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 711, 25331, 25462);
            CallChecker.varInit(this.upperBounds, "upperBounds", 711, 25331, 25462);
            CallChecker.varInit(this.loaded, "loaded", 711, 25331, 25462);
            CallChecker.varInit(this.binCount, "binCount", 711, 25331, 25462);
            CallChecker.varInit(this.delta, "delta", 711, 25331, 25462);
            CallChecker.varInit(this.min, "min", 711, 25331, 25462);
            CallChecker.varInit(this.max, "max", 711, 25331, 25462);
            CallChecker.varInit(this.sampleStats, "sampleStats", 711, 25331, 25462);
            CallChecker.varInit(this.binStats, "binStats", 711, 25331, 25462);
            CallChecker.varInit(this.randomData, "randomData", 711, 25331, 25462);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.EmpiricalDistribution.serialVersionUID", 711, 25331, 25462);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.EmpiricalDistribution.FILE_CHARSET", 711, 25331, 25462);
            CallChecker.varInit(DEFAULT_BIN_COUNT, "org.apache.commons.math3.random.EmpiricalDistribution.DEFAULT_BIN_COUNT", 711, 25331, 25462);
            if (CallChecker.beforeDeref(sampleStats, SummaryStatistics.class, 712, 25435, 25445)) {
                sampleStats = CallChecker.beforeCalled(sampleStats, SummaryStatistics.class, 712, 25435, 25445);
                return CallChecker.isCalled(sampleStats, SummaryStatistics.class, 712, 25435, 25445).getMean();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2230.methodEnd();
        }
    }

    public double getNumericalVariance() {
        MethodContext _bcornu_methode_context2231 = new MethodContext(double.class, 719, 25469, 25609);
        try {
            CallChecker.varInit(this, "this", 719, 25469, 25609);
            CallChecker.varInit(this.random, "random", 719, 25469, 25609);
            CallChecker.varInit(this.randomData, "randomData", 719, 25469, 25609);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 719, 25469, 25609);
            CallChecker.varInit(this.upperBounds, "upperBounds", 719, 25469, 25609);
            CallChecker.varInit(this.loaded, "loaded", 719, 25469, 25609);
            CallChecker.varInit(this.binCount, "binCount", 719, 25469, 25609);
            CallChecker.varInit(this.delta, "delta", 719, 25469, 25609);
            CallChecker.varInit(this.min, "min", 719, 25469, 25609);
            CallChecker.varInit(this.max, "max", 719, 25469, 25609);
            CallChecker.varInit(this.sampleStats, "sampleStats", 719, 25469, 25609);
            CallChecker.varInit(this.binStats, "binStats", 719, 25469, 25609);
            CallChecker.varInit(this.randomData, "randomData", 719, 25469, 25609);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.EmpiricalDistribution.serialVersionUID", 719, 25469, 25609);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.EmpiricalDistribution.FILE_CHARSET", 719, 25469, 25609);
            CallChecker.varInit(DEFAULT_BIN_COUNT, "org.apache.commons.math3.random.EmpiricalDistribution.DEFAULT_BIN_COUNT", 719, 25469, 25609);
            if (CallChecker.beforeDeref(sampleStats, SummaryStatistics.class, 720, 25578, 25588)) {
                sampleStats = CallChecker.beforeCalled(sampleStats, SummaryStatistics.class, 720, 25578, 25588);
                return CallChecker.isCalled(sampleStats, SummaryStatistics.class, 720, 25578, 25588).getVariance();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2231.methodEnd();
        }
    }

    public double getSupportLowerBound() {
        MethodContext _bcornu_methode_context2232 = new MethodContext(double.class, 727, 25616, 25733);
        try {
            CallChecker.varInit(this, "this", 727, 25616, 25733);
            CallChecker.varInit(this.random, "random", 727, 25616, 25733);
            CallChecker.varInit(this.randomData, "randomData", 727, 25616, 25733);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 727, 25616, 25733);
            CallChecker.varInit(this.upperBounds, "upperBounds", 727, 25616, 25733);
            CallChecker.varInit(this.loaded, "loaded", 727, 25616, 25733);
            CallChecker.varInit(this.binCount, "binCount", 727, 25616, 25733);
            CallChecker.varInit(this.delta, "delta", 727, 25616, 25733);
            CallChecker.varInit(this.min, "min", 727, 25616, 25733);
            CallChecker.varInit(this.max, "max", 727, 25616, 25733);
            CallChecker.varInit(this.sampleStats, "sampleStats", 727, 25616, 25733);
            CallChecker.varInit(this.binStats, "binStats", 727, 25616, 25733);
            CallChecker.varInit(this.randomData, "randomData", 727, 25616, 25733);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.EmpiricalDistribution.serialVersionUID", 727, 25616, 25733);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.EmpiricalDistribution.FILE_CHARSET", 727, 25616, 25733);
            CallChecker.varInit(DEFAULT_BIN_COUNT, "org.apache.commons.math3.random.EmpiricalDistribution.DEFAULT_BIN_COUNT", 727, 25616, 25733);
            return min;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2232.methodEnd();
        }
    }

    public double getSupportUpperBound() {
        MethodContext _bcornu_methode_context2233 = new MethodContext(double.class, 735, 25740, 25858);
        try {
            CallChecker.varInit(this, "this", 735, 25740, 25858);
            CallChecker.varInit(this.random, "random", 735, 25740, 25858);
            CallChecker.varInit(this.randomData, "randomData", 735, 25740, 25858);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 735, 25740, 25858);
            CallChecker.varInit(this.upperBounds, "upperBounds", 735, 25740, 25858);
            CallChecker.varInit(this.loaded, "loaded", 735, 25740, 25858);
            CallChecker.varInit(this.binCount, "binCount", 735, 25740, 25858);
            CallChecker.varInit(this.delta, "delta", 735, 25740, 25858);
            CallChecker.varInit(this.min, "min", 735, 25740, 25858);
            CallChecker.varInit(this.max, "max", 735, 25740, 25858);
            CallChecker.varInit(this.sampleStats, "sampleStats", 735, 25740, 25858);
            CallChecker.varInit(this.binStats, "binStats", 735, 25740, 25858);
            CallChecker.varInit(this.randomData, "randomData", 735, 25740, 25858);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.EmpiricalDistribution.serialVersionUID", 735, 25740, 25858);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.EmpiricalDistribution.FILE_CHARSET", 735, 25740, 25858);
            CallChecker.varInit(DEFAULT_BIN_COUNT, "org.apache.commons.math3.random.EmpiricalDistribution.DEFAULT_BIN_COUNT", 735, 25740, 25858);
            return max;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2233.methodEnd();
        }
    }

    public boolean isSupportLowerBoundInclusive() {
        MethodContext _bcornu_methode_context2234 = new MethodContext(boolean.class, 743, 25865, 25993);
        try {
            CallChecker.varInit(this, "this", 743, 25865, 25993);
            CallChecker.varInit(this.random, "random", 743, 25865, 25993);
            CallChecker.varInit(this.randomData, "randomData", 743, 25865, 25993);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 743, 25865, 25993);
            CallChecker.varInit(this.upperBounds, "upperBounds", 743, 25865, 25993);
            CallChecker.varInit(this.loaded, "loaded", 743, 25865, 25993);
            CallChecker.varInit(this.binCount, "binCount", 743, 25865, 25993);
            CallChecker.varInit(this.delta, "delta", 743, 25865, 25993);
            CallChecker.varInit(this.min, "min", 743, 25865, 25993);
            CallChecker.varInit(this.max, "max", 743, 25865, 25993);
            CallChecker.varInit(this.sampleStats, "sampleStats", 743, 25865, 25993);
            CallChecker.varInit(this.binStats, "binStats", 743, 25865, 25993);
            CallChecker.varInit(this.randomData, "randomData", 743, 25865, 25993);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.EmpiricalDistribution.serialVersionUID", 743, 25865, 25993);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.EmpiricalDistribution.FILE_CHARSET", 743, 25865, 25993);
            CallChecker.varInit(DEFAULT_BIN_COUNT, "org.apache.commons.math3.random.EmpiricalDistribution.DEFAULT_BIN_COUNT", 743, 25865, 25993);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2234.methodEnd();
        }
    }

    public boolean isSupportUpperBoundInclusive() {
        MethodContext _bcornu_methode_context2235 = new MethodContext(boolean.class, 751, 26000, 26128);
        try {
            CallChecker.varInit(this, "this", 751, 26000, 26128);
            CallChecker.varInit(this.random, "random", 751, 26000, 26128);
            CallChecker.varInit(this.randomData, "randomData", 751, 26000, 26128);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 751, 26000, 26128);
            CallChecker.varInit(this.upperBounds, "upperBounds", 751, 26000, 26128);
            CallChecker.varInit(this.loaded, "loaded", 751, 26000, 26128);
            CallChecker.varInit(this.binCount, "binCount", 751, 26000, 26128);
            CallChecker.varInit(this.delta, "delta", 751, 26000, 26128);
            CallChecker.varInit(this.min, "min", 751, 26000, 26128);
            CallChecker.varInit(this.max, "max", 751, 26000, 26128);
            CallChecker.varInit(this.sampleStats, "sampleStats", 751, 26000, 26128);
            CallChecker.varInit(this.binStats, "binStats", 751, 26000, 26128);
            CallChecker.varInit(this.randomData, "randomData", 751, 26000, 26128);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.EmpiricalDistribution.serialVersionUID", 751, 26000, 26128);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.EmpiricalDistribution.FILE_CHARSET", 751, 26000, 26128);
            CallChecker.varInit(DEFAULT_BIN_COUNT, "org.apache.commons.math3.random.EmpiricalDistribution.DEFAULT_BIN_COUNT", 751, 26000, 26128);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2235.methodEnd();
        }
    }

    public boolean isSupportConnected() {
        MethodContext _bcornu_methode_context2236 = new MethodContext(boolean.class, 759, 26135, 26253);
        try {
            CallChecker.varInit(this, "this", 759, 26135, 26253);
            CallChecker.varInit(this.random, "random", 759, 26135, 26253);
            CallChecker.varInit(this.randomData, "randomData", 759, 26135, 26253);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 759, 26135, 26253);
            CallChecker.varInit(this.upperBounds, "upperBounds", 759, 26135, 26253);
            CallChecker.varInit(this.loaded, "loaded", 759, 26135, 26253);
            CallChecker.varInit(this.binCount, "binCount", 759, 26135, 26253);
            CallChecker.varInit(this.delta, "delta", 759, 26135, 26253);
            CallChecker.varInit(this.min, "min", 759, 26135, 26253);
            CallChecker.varInit(this.max, "max", 759, 26135, 26253);
            CallChecker.varInit(this.sampleStats, "sampleStats", 759, 26135, 26253);
            CallChecker.varInit(this.binStats, "binStats", 759, 26135, 26253);
            CallChecker.varInit(this.randomData, "randomData", 759, 26135, 26253);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.EmpiricalDistribution.serialVersionUID", 759, 26135, 26253);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.EmpiricalDistribution.FILE_CHARSET", 759, 26135, 26253);
            CallChecker.varInit(DEFAULT_BIN_COUNT, "org.apache.commons.math3.random.EmpiricalDistribution.DEFAULT_BIN_COUNT", 759, 26135, 26253);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2236.methodEnd();
        }
    }

    @Override
    public double sample() {
        MethodContext _bcornu_methode_context2237 = new MethodContext(double.class, 768, 26260, 26389);
        try {
            CallChecker.varInit(this, "this", 768, 26260, 26389);
            CallChecker.varInit(this.random, "random", 768, 26260, 26389);
            CallChecker.varInit(this.randomData, "randomData", 768, 26260, 26389);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 768, 26260, 26389);
            CallChecker.varInit(this.upperBounds, "upperBounds", 768, 26260, 26389);
            CallChecker.varInit(this.loaded, "loaded", 768, 26260, 26389);
            CallChecker.varInit(this.binCount, "binCount", 768, 26260, 26389);
            CallChecker.varInit(this.delta, "delta", 768, 26260, 26389);
            CallChecker.varInit(this.min, "min", 768, 26260, 26389);
            CallChecker.varInit(this.max, "max", 768, 26260, 26389);
            CallChecker.varInit(this.sampleStats, "sampleStats", 768, 26260, 26389);
            CallChecker.varInit(this.binStats, "binStats", 768, 26260, 26389);
            CallChecker.varInit(this.randomData, "randomData", 768, 26260, 26389);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.EmpiricalDistribution.serialVersionUID", 768, 26260, 26389);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.EmpiricalDistribution.FILE_CHARSET", 768, 26260, 26389);
            CallChecker.varInit(DEFAULT_BIN_COUNT, "org.apache.commons.math3.random.EmpiricalDistribution.DEFAULT_BIN_COUNT", 768, 26260, 26389);
            return getNextValue();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2237.methodEnd();
        }
    }

    @Override
    public void reseedRandomGenerator(long seed) {
        MethodContext _bcornu_methode_context2238 = new MethodContext(void.class, 777, 26396, 26549);
        try {
            CallChecker.varInit(this, "this", 777, 26396, 26549);
            CallChecker.varInit(seed, "seed", 777, 26396, 26549);
            CallChecker.varInit(this.random, "random", 777, 26396, 26549);
            CallChecker.varInit(this.randomData, "randomData", 777, 26396, 26549);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 777, 26396, 26549);
            CallChecker.varInit(this.upperBounds, "upperBounds", 777, 26396, 26549);
            CallChecker.varInit(this.loaded, "loaded", 777, 26396, 26549);
            CallChecker.varInit(this.binCount, "binCount", 777, 26396, 26549);
            CallChecker.varInit(this.delta, "delta", 777, 26396, 26549);
            CallChecker.varInit(this.min, "min", 777, 26396, 26549);
            CallChecker.varInit(this.max, "max", 777, 26396, 26549);
            CallChecker.varInit(this.sampleStats, "sampleStats", 777, 26396, 26549);
            CallChecker.varInit(this.binStats, "binStats", 777, 26396, 26549);
            CallChecker.varInit(this.randomData, "randomData", 777, 26396, 26549);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.EmpiricalDistribution.serialVersionUID", 777, 26396, 26549);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.EmpiricalDistribution.FILE_CHARSET", 777, 26396, 26549);
            CallChecker.varInit(DEFAULT_BIN_COUNT, "org.apache.commons.math3.random.EmpiricalDistribution.DEFAULT_BIN_COUNT", 777, 26396, 26549);
            if (CallChecker.beforeDeref(randomData, RandomDataGenerator.class, 778, 26520, 26529)) {
                CallChecker.isCalled(randomData, RandomDataGenerator.class, 778, 26520, 26529).reSeed(seed);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2238.methodEnd();
        }
    }

    private double pB(int i) {
        MethodContext _bcornu_methode_context2239 = new MethodContext(double.class, 787, 26556, 26832);
        try {
            CallChecker.varInit(this, "this", 787, 26556, 26832);
            CallChecker.varInit(i, "i", 787, 26556, 26832);
            CallChecker.varInit(this.random, "random", 787, 26556, 26832);
            CallChecker.varInit(this.randomData, "randomData", 787, 26556, 26832);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 787, 26556, 26832);
            CallChecker.varInit(this.upperBounds, "upperBounds", 787, 26556, 26832);
            CallChecker.varInit(this.loaded, "loaded", 787, 26556, 26832);
            CallChecker.varInit(this.binCount, "binCount", 787, 26556, 26832);
            CallChecker.varInit(this.delta, "delta", 787, 26556, 26832);
            CallChecker.varInit(this.min, "min", 787, 26556, 26832);
            CallChecker.varInit(this.max, "max", 787, 26556, 26832);
            CallChecker.varInit(this.sampleStats, "sampleStats", 787, 26556, 26832);
            CallChecker.varInit(this.binStats, "binStats", 787, 26556, 26832);
            CallChecker.varInit(this.randomData, "randomData", 787, 26556, 26832);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.EmpiricalDistribution.serialVersionUID", 787, 26556, 26832);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.EmpiricalDistribution.FILE_CHARSET", 787, 26556, 26832);
            CallChecker.varInit(DEFAULT_BIN_COUNT, "org.apache.commons.math3.random.EmpiricalDistribution.DEFAULT_BIN_COUNT", 787, 26556, 26832);
            if (i == 0) {
                if (CallChecker.beforeDeref(upperBounds, double[].class, 788, 26762, 26772)) {
                    upperBounds = CallChecker.beforeCalled(upperBounds, double[].class, 788, 26762, 26772);
                    return CallChecker.isCalled(upperBounds, double[].class, 788, 26762, 26772)[0];
                }else
                    throw new AbnormalExecutionError();
                
            }else {
                upperBounds = CallChecker.beforeCalled(upperBounds, double[].class, 789, 26791, 26801);
                upperBounds = CallChecker.beforeCalled(upperBounds, double[].class, 789, 26808, 26818);
                return (CallChecker.isCalled(upperBounds, double[].class, 789, 26791, 26801)[i]) - (CallChecker.isCalled(upperBounds, double[].class, 789, 26808, 26818)[(i - 1)]);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2239.methodEnd();
        }
    }

    private double pBminus(int i) {
        MethodContext _bcornu_methode_context2240 = new MethodContext(double.class, 798, 26839, 27133);
        try {
            CallChecker.varInit(this, "this", 798, 26839, 27133);
            CallChecker.varInit(i, "i", 798, 26839, 27133);
            CallChecker.varInit(this.random, "random", 798, 26839, 27133);
            CallChecker.varInit(this.randomData, "randomData", 798, 26839, 27133);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 798, 26839, 27133);
            CallChecker.varInit(this.upperBounds, "upperBounds", 798, 26839, 27133);
            CallChecker.varInit(this.loaded, "loaded", 798, 26839, 27133);
            CallChecker.varInit(this.binCount, "binCount", 798, 26839, 27133);
            CallChecker.varInit(this.delta, "delta", 798, 26839, 27133);
            CallChecker.varInit(this.min, "min", 798, 26839, 27133);
            CallChecker.varInit(this.max, "max", 798, 26839, 27133);
            CallChecker.varInit(this.sampleStats, "sampleStats", 798, 26839, 27133);
            CallChecker.varInit(this.binStats, "binStats", 798, 26839, 27133);
            CallChecker.varInit(this.randomData, "randomData", 798, 26839, 27133);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.EmpiricalDistribution.serialVersionUID", 798, 26839, 27133);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.EmpiricalDistribution.FILE_CHARSET", 798, 26839, 27133);
            CallChecker.varInit(DEFAULT_BIN_COUNT, "org.apache.commons.math3.random.EmpiricalDistribution.DEFAULT_BIN_COUNT", 798, 26839, 27133);
            if (i == 0) {
                return 0;
            }else {
                if (CallChecker.beforeDeref(upperBounds, double[].class, 799, 27109, 27119)) {
                    upperBounds = CallChecker.beforeCalled(upperBounds, double[].class, 799, 27109, 27119);
                    return CallChecker.isCalled(upperBounds, double[].class, 799, 27109, 27119)[(i - 1)];
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2240.methodEnd();
        }
    }

    @SuppressWarnings(value = "deprecation")
    private double kB(int i) {
        MethodContext _bcornu_methode_context2241 = new MethodContext(double.class, 810, 27140, 27707);
        try {
            CallChecker.varInit(this, "this", 810, 27140, 27707);
            CallChecker.varInit(i, "i", 810, 27140, 27707);
            CallChecker.varInit(this.random, "random", 810, 27140, 27707);
            CallChecker.varInit(this.randomData, "randomData", 810, 27140, 27707);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 810, 27140, 27707);
            CallChecker.varInit(this.upperBounds, "upperBounds", 810, 27140, 27707);
            CallChecker.varInit(this.loaded, "loaded", 810, 27140, 27707);
            CallChecker.varInit(this.binCount, "binCount", 810, 27140, 27707);
            CallChecker.varInit(this.delta, "delta", 810, 27140, 27707);
            CallChecker.varInit(this.min, "min", 810, 27140, 27707);
            CallChecker.varInit(this.max, "max", 810, 27140, 27707);
            CallChecker.varInit(this.sampleStats, "sampleStats", 810, 27140, 27707);
            CallChecker.varInit(this.binStats, "binStats", 810, 27140, 27707);
            CallChecker.varInit(this.randomData, "randomData", 810, 27140, 27707);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.EmpiricalDistribution.serialVersionUID", 810, 27140, 27707);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.EmpiricalDistribution.FILE_CHARSET", 810, 27140, 27707);
            CallChecker.varInit(DEFAULT_BIN_COUNT, "org.apache.commons.math3.random.EmpiricalDistribution.DEFAULT_BIN_COUNT", 810, 27140, 27707);
            final double[] binBounds = CallChecker.varInit(getUpperBounds(), "binBounds", 811, 27442, 27485);
            final RealDistribution kernel = CallChecker.varInit(getKernel(CallChecker.isCalled(binStats, List.class, 812, 27537, 27544).get(i)), "kernel", 812, 27495, 27553);
            if (i == 0) {
                if (CallChecker.beforeDeref(binBounds, double[].class, 813, 27613, 27621)) {
                    if (CallChecker.beforeDeref(kernel, RealDistribution.class, 813, 27579, 27584)) {
                        return CallChecker.isCalled(kernel, RealDistribution.class, 813, 27579, 27584).cumulativeProbability(min, CallChecker.isCalled(binBounds, double[].class, 813, 27613, 27621)[0]);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else {
                if (CallChecker.beforeDeref(binBounds, double[].class, 814, 27670, 27678)) {
                    if (CallChecker.beforeDeref(binBounds, double[].class, 814, 27688, 27696)) {
                        if (CallChecker.beforeDeref(kernel, RealDistribution.class, 814, 27641, 27646)) {
                            return CallChecker.isCalled(kernel, RealDistribution.class, 814, 27641, 27646).cumulativeProbability(CallChecker.isCalled(binBounds, double[].class, 814, 27670, 27678)[(i - 1)], CallChecker.isCalled(binBounds, double[].class, 814, 27688, 27696)[i]);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2241.methodEnd();
        }
    }

    private RealDistribution k(double x) {
        MethodContext _bcornu_methode_context2242 = new MethodContext(RealDistribution.class, 823, 27714, 28040);
        try {
            CallChecker.varInit(this, "this", 823, 27714, 28040);
            CallChecker.varInit(x, "x", 823, 27714, 28040);
            CallChecker.varInit(this.random, "random", 823, 27714, 28040);
            CallChecker.varInit(this.randomData, "randomData", 823, 27714, 28040);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 823, 27714, 28040);
            CallChecker.varInit(this.upperBounds, "upperBounds", 823, 27714, 28040);
            CallChecker.varInit(this.loaded, "loaded", 823, 27714, 28040);
            CallChecker.varInit(this.binCount, "binCount", 823, 27714, 28040);
            CallChecker.varInit(this.delta, "delta", 823, 27714, 28040);
            CallChecker.varInit(this.min, "min", 823, 27714, 28040);
            CallChecker.varInit(this.max, "max", 823, 27714, 28040);
            CallChecker.varInit(this.sampleStats, "sampleStats", 823, 27714, 28040);
            CallChecker.varInit(this.binStats, "binStats", 823, 27714, 28040);
            CallChecker.varInit(this.randomData, "randomData", 823, 27714, 28040);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.EmpiricalDistribution.serialVersionUID", 823, 27714, 28040);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.EmpiricalDistribution.FILE_CHARSET", 823, 27714, 28040);
            CallChecker.varInit(DEFAULT_BIN_COUNT, "org.apache.commons.math3.random.EmpiricalDistribution.DEFAULT_BIN_COUNT", 823, 27714, 28040);
            final int binIndex = CallChecker.varInit(((int) (findBin(x))), "binIndex", 824, 27953, 27984);
            if (CallChecker.beforeDeref(binStats, List.class, 825, 28011, 28018)) {
                return getKernel(CallChecker.isCalled(binStats, List.class, 825, 28011, 28018).get(binIndex));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealDistribution) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2242.methodEnd();
        }
    }

    private double cumBinP(int binIndex) {
        MethodContext _bcornu_methode_context2243 = new MethodContext(double.class, 834, 28047, 28331);
        try {
            CallChecker.varInit(this, "this", 834, 28047, 28331);
            CallChecker.varInit(binIndex, "binIndex", 834, 28047, 28331);
            CallChecker.varInit(this.random, "random", 834, 28047, 28331);
            CallChecker.varInit(this.randomData, "randomData", 834, 28047, 28331);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 834, 28047, 28331);
            CallChecker.varInit(this.upperBounds, "upperBounds", 834, 28047, 28331);
            CallChecker.varInit(this.loaded, "loaded", 834, 28047, 28331);
            CallChecker.varInit(this.binCount, "binCount", 834, 28047, 28331);
            CallChecker.varInit(this.delta, "delta", 834, 28047, 28331);
            CallChecker.varInit(this.min, "min", 834, 28047, 28331);
            CallChecker.varInit(this.max, "max", 834, 28047, 28331);
            CallChecker.varInit(this.sampleStats, "sampleStats", 834, 28047, 28331);
            CallChecker.varInit(this.binStats, "binStats", 834, 28047, 28331);
            CallChecker.varInit(this.randomData, "randomData", 834, 28047, 28331);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.EmpiricalDistribution.serialVersionUID", 834, 28047, 28331);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.EmpiricalDistribution.FILE_CHARSET", 834, 28047, 28331);
            CallChecker.varInit(DEFAULT_BIN_COUNT, "org.apache.commons.math3.random.EmpiricalDistribution.DEFAULT_BIN_COUNT", 834, 28047, 28331);
            if (CallChecker.beforeDeref(upperBounds, double[].class, 835, 28304, 28314)) {
                upperBounds = CallChecker.beforeCalled(upperBounds, double[].class, 835, 28304, 28314);
                return CallChecker.isCalled(upperBounds, double[].class, 835, 28304, 28314)[binIndex];
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2243.methodEnd();
        }
    }

    protected RealDistribution getKernel(SummaryStatistics bStats) {
        MethodContext _bcornu_methode_context2244 = new MethodContext(RealDistribution.class, 844, 28338, 28817);
        try {
            CallChecker.varInit(this, "this", 844, 28338, 28817);
            CallChecker.varInit(bStats, "bStats", 844, 28338, 28817);
            CallChecker.varInit(this.random, "random", 844, 28338, 28817);
            CallChecker.varInit(this.randomData, "randomData", 844, 28338, 28817);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 844, 28338, 28817);
            CallChecker.varInit(this.upperBounds, "upperBounds", 844, 28338, 28817);
            CallChecker.varInit(this.loaded, "loaded", 844, 28338, 28817);
            CallChecker.varInit(this.binCount, "binCount", 844, 28338, 28817);
            CallChecker.varInit(this.delta, "delta", 844, 28338, 28817);
            CallChecker.varInit(this.min, "min", 844, 28338, 28817);
            CallChecker.varInit(this.max, "max", 844, 28338, 28817);
            CallChecker.varInit(this.sampleStats, "sampleStats", 844, 28338, 28817);
            CallChecker.varInit(this.binStats, "binStats", 844, 28338, 28817);
            CallChecker.varInit(this.randomData, "randomData", 844, 28338, 28817);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.EmpiricalDistribution.serialVersionUID", 844, 28338, 28817);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.EmpiricalDistribution.FILE_CHARSET", 844, 28338, 28817);
            CallChecker.varInit(DEFAULT_BIN_COUNT, "org.apache.commons.math3.random.EmpiricalDistribution.DEFAULT_BIN_COUNT", 844, 28338, 28817);
            if (CallChecker.beforeDeref(randomData, RandomDataGenerator.class, 846, 28644, 28653)) {
                if (CallChecker.beforeDeref(bStats, SummaryStatistics.class, 847, 28693, 28698)) {
                    if (CallChecker.beforeDeref(bStats, SummaryStatistics.class, 847, 28711, 28716)) {
                        bStats = CallChecker.beforeCalled(bStats, SummaryStatistics.class, 847, 28693, 28698);
                        bStats = CallChecker.beforeCalled(bStats, SummaryStatistics.class, 847, 28711, 28716);
                        return new NormalDistribution(CallChecker.isCalled(randomData, RandomDataGenerator.class, 846, 28644, 28653).getRandomGenerator(), CallChecker.isCalled(bStats, SummaryStatistics.class, 847, 28693, 28698).getMean(), CallChecker.isCalled(bStats, SummaryStatistics.class, 847, 28711, 28716).getStandardDeviation(), NormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealDistribution) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2244.methodEnd();
        }
    }
}

