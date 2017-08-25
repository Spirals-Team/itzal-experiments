package org.apache.commons.math3.ode;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;

public class ExpandableStatefulODE {
    private static class SecondaryComponent {
        private final SecondaryEquations equation;

        private final EquationsMapper mapper;

        private final double[] state;

        private final double[] stateDot;

        public SecondaryComponent(final SecondaryEquations equation, final int firstIndex) {
            ConstructorContext _bcornu_methode_context47 = new ConstructorContext(ExpandableStatefulODE.SecondaryComponent.class, 321, 11824, 12348);
            try {
                final int n = CallChecker.varInit(((int) (CallChecker.isCalled(equation, SecondaryEquations.class, 322, 12127, 12134).getDimension())), "n", 322, 12111, 12150);
                this.equation = equation;
                CallChecker.varAssign(this.equation, "this.equation", 323, 12164, 12188);
                mapper = new EquationsMapper(firstIndex, n);
                CallChecker.varAssign(this.mapper, "this.mapper", 324, 12202, 12252);
                state = new double[n];
                CallChecker.varAssign(this.state, "this.state", 325, 12266, 12295);
                stateDot = new double[n];
                CallChecker.varAssign(this.stateDot, "this.stateDot", 326, 12309, 12338);
            } finally {
                _bcornu_methode_context47.methodEnd();
            }
        }
    }

    private final FirstOrderDifferentialEquations primary;

    private final EquationsMapper primaryMapper;

    private double time;

    private final double[] primaryState;

    private final double[] primaryStateDot;

    private List<ExpandableStatefulODE.SecondaryComponent> components;

    public ExpandableStatefulODE(final FirstOrderDifferentialEquations primary) {
        ConstructorContext _bcornu_methode_context48 = new ConstructorContext(ExpandableStatefulODE.class, 73, 2454, 3062);
        try {
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(primary, FirstOrderDifferentialEquations.class, 74, 2711, 2717).getDimension())), "n", 74, 2688, 2733);
            this.primary = primary;
            CallChecker.varAssign(this.primary, "this.primary", 75, 2743, 2773);
            this.primaryMapper = new EquationsMapper(0, n);
            CallChecker.varAssign(this.primaryMapper, "this.primaryMapper", 76, 2783, 2831);
            this.time = Double.NaN;
            CallChecker.varAssign(this.time, "this.time", 77, 2841, 2874);
            this.primaryState = new double[n];
            CallChecker.varAssign(this.primaryState, "this.primaryState", 78, 2884, 2920);
            this.primaryStateDot = new double[n];
            CallChecker.varAssign(this.primaryStateDot, "this.primaryStateDot", 79, 2930, 2966);
            this.components = new ArrayList<ExpandableStatefulODE.SecondaryComponent>();
            CallChecker.varAssign(this.components, "this.components", 80, 2976, 3056);
        } finally {
            _bcornu_methode_context48.methodEnd();
        }
    }

    public FirstOrderDifferentialEquations getPrimary() {
        MethodContext _bcornu_methode_context145 = new MethodContext(FirstOrderDifferentialEquations.class, 86, 3069, 3267);
        try {
            CallChecker.varInit(this, "this", 86, 3069, 3267);
            CallChecker.varInit(this.components, "components", 86, 3069, 3267);
            CallChecker.varInit(this.primaryStateDot, "primaryStateDot", 86, 3069, 3267);
            CallChecker.varInit(this.primaryState, "primaryState", 86, 3069, 3267);
            CallChecker.varInit(this.time, "time", 86, 3069, 3267);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 86, 3069, 3267);
            CallChecker.varInit(this.primary, "primary", 86, 3069, 3267);
            return primary;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FirstOrderDifferentialEquations) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context145.methodEnd();
        }
    }

    public int getTotalDimension() {
        MethodContext _bcornu_methode_context146 = new MethodContext(int.class, 96, 3274, 4018);
        try {
            CallChecker.varInit(this, "this", 96, 3274, 4018);
            CallChecker.varInit(this.components, "components", 96, 3274, 4018);
            CallChecker.varInit(this.primaryStateDot, "primaryStateDot", 96, 3274, 4018);
            CallChecker.varInit(this.primaryState, "primaryState", 96, 3274, 4018);
            CallChecker.varInit(this.time, "time", 96, 3274, 4018);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 96, 3274, 4018);
            CallChecker.varInit(this.primary, "primary", 96, 3274, 4018);
            if (CallChecker.beforeDeref(components, List.class, 97, 3563, 3572)) {
                components = CallChecker.beforeCalled(components, List.class, 97, 3563, 3572);
                if (CallChecker.isCalled(components, List.class, 97, 3563, 3572).isEmpty()) {
                    if (CallChecker.beforeDeref(primaryMapper, EquationsMapper.class, 99, 3702, 3714)) {
                        return CallChecker.isCalled(primaryMapper, EquationsMapper.class, 99, 3702, 3714).getDimension();
                    }else
                        throw new AbnormalExecutionError();
                    
                }else {
                    components = CallChecker.beforeCalled(components, List.class, 102, 3898, 3907);
                    components = CallChecker.beforeCalled(components, List.class, 102, 3883, 3892);
                    final EquationsMapper lastMapper = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(components, List.class, 102, 3883, 3892).get(((CallChecker.isCalled(components, List.class, 102, 3898, 3907).size()) - 1)), ExpandableStatefulODE.SecondaryComponent.class, 102, 3883, 3919).mapper, "lastMapper", 102, 3761, 3927);
                    return (CallChecker.isCalled(lastMapper, EquationsMapper.class, 103, 3948, 3957).getFirstIndex()) + (CallChecker.isCalled(lastMapper, EquationsMapper.class, 103, 3977, 3986).getDimension());
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context146.methodEnd();
        }
    }

    public void computeDerivatives(final double t, final double[] y, final double[] yDot) throws DimensionMismatchException, MaxCountExceededException {
        MethodContext _bcornu_methode_context147 = new MethodContext(void.class, 114, 4025, 5404);
        try {
            CallChecker.varInit(this, "this", 114, 4025, 5404);
            CallChecker.varInit(yDot, "yDot", 114, 4025, 5404);
            CallChecker.varInit(y, "y", 114, 4025, 5404);
            CallChecker.varInit(t, "t", 114, 4025, 5404);
            CallChecker.varInit(this.components, "components", 114, 4025, 5404);
            CallChecker.varInit(this.primaryStateDot, "primaryStateDot", 114, 4025, 5404);
            CallChecker.varInit(this.primaryState, "primaryState", 114, 4025, 5404);
            CallChecker.varInit(this.time, "time", 114, 4025, 5404);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 114, 4025, 5404);
            CallChecker.varInit(this.primary, "primary", 114, 4025, 5404);
            if (CallChecker.beforeDeref(primaryMapper, EquationsMapper.class, 118, 4767, 4779)) {
                CallChecker.isCalled(primaryMapper, EquationsMapper.class, 118, 4767, 4779).extractEquationData(y, primaryState);
            }
            if (CallChecker.beforeDeref(primary, FirstOrderDifferentialEquations.class, 119, 4827, 4833)) {
                CallChecker.isCalled(primary, FirstOrderDifferentialEquations.class, 119, 4827, 4833).computeDerivatives(t, primaryState, primaryStateDot);
            }
            if (CallChecker.beforeDeref(components, void.class, 122, 4992, 5001)) {
                for (final ExpandableStatefulODE.SecondaryComponent component : components) {
                    if (CallChecker.beforeDeref(component, ExpandableStatefulODE.SecondaryComponent.class, 123, 5018, 5026)) {
                        if (CallChecker.beforeDeref(component, ExpandableStatefulODE.SecondaryComponent.class, 123, 5058, 5066)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(component, ExpandableStatefulODE.SecondaryComponent.class, 123, 5018, 5026).mapper, EquationsMapper.class, 123, 5018, 5033)) {
                                CallChecker.isCalled(CallChecker.isCalled(component, ExpandableStatefulODE.SecondaryComponent.class, 123, 5018, 5026).mapper, EquationsMapper.class, 123, 5018, 5033).extractEquationData(y, CallChecker.isCalled(component, ExpandableStatefulODE.SecondaryComponent.class, 123, 5058, 5066).state);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(component, ExpandableStatefulODE.SecondaryComponent.class, 124, 5088, 5096)) {
                        if (CallChecker.beforeDeref(component, ExpandableStatefulODE.SecondaryComponent.class, 125, 5210, 5218)) {
                            if (CallChecker.beforeDeref(component, ExpandableStatefulODE.SecondaryComponent.class, 125, 5227, 5235)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(component, ExpandableStatefulODE.SecondaryComponent.class, 124, 5088, 5096).equation, SecondaryEquations.class, 124, 5088, 5105)) {
                                    CallChecker.isCalled(CallChecker.isCalled(component, ExpandableStatefulODE.SecondaryComponent.class, 124, 5088, 5096).equation, SecondaryEquations.class, 124, 5088, 5105).computeDerivatives(t, primaryState, primaryStateDot, CallChecker.isCalled(component, ExpandableStatefulODE.SecondaryComponent.class, 125, 5210, 5218).state, CallChecker.isCalled(component, ExpandableStatefulODE.SecondaryComponent.class, 125, 5227, 5235).stateDot);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(component, ExpandableStatefulODE.SecondaryComponent.class, 126, 5260, 5268)) {
                        if (CallChecker.beforeDeref(component, ExpandableStatefulODE.SecondaryComponent.class, 126, 5296, 5304)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(component, ExpandableStatefulODE.SecondaryComponent.class, 126, 5260, 5268).mapper, EquationsMapper.class, 126, 5260, 5275)) {
                                CallChecker.isCalled(CallChecker.isCalled(component, ExpandableStatefulODE.SecondaryComponent.class, 126, 5260, 5268).mapper, EquationsMapper.class, 126, 5260, 5275).insertEquationData(CallChecker.isCalled(component, ExpandableStatefulODE.SecondaryComponent.class, 126, 5296, 5304).stateDot, yDot);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(primaryMapper, EquationsMapper.class, 129, 5342, 5354)) {
                CallChecker.isCalled(primaryMapper, EquationsMapper.class, 129, 5342, 5354).insertEquationData(primaryStateDot, yDot);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context147.methodEnd();
        }
    }

    public int addSecondaryEquations(final SecondaryEquations secondary) {
        MethodContext _bcornu_methode_context148 = new MethodContext(int.class, 137, 5411, 6254);
        try {
            CallChecker.varInit(this, "this", 137, 5411, 6254);
            CallChecker.varInit(secondary, "secondary", 137, 5411, 6254);
            CallChecker.varInit(this.components, "components", 137, 5411, 6254);
            CallChecker.varInit(this.primaryStateDot, "primaryStateDot", 137, 5411, 6254);
            CallChecker.varInit(this.primaryState, "primaryState", 137, 5411, 6254);
            CallChecker.varInit(this.time, "time", 137, 5411, 6254);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 137, 5411, 6254);
            CallChecker.varInit(this.primary, "primary", 137, 5411, 6254);
            int firstIndex = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(components, List.class, 140, 5736, 5745)) {
                components = CallChecker.beforeCalled(components, List.class, 140, 5736, 5745);
                if (CallChecker.isCalled(components, List.class, 140, 5736, 5745).isEmpty()) {
                    components = new ArrayList<ExpandableStatefulODE.SecondaryComponent>();
                    CallChecker.varAssign(this.components, "this.components", 142, 5824, 5894);
                    if (CallChecker.beforeDeref(primary, FirstOrderDifferentialEquations.class, 143, 5921, 5927)) {
                        firstIndex = CallChecker.isCalled(primary, FirstOrderDifferentialEquations.class, 143, 5921, 5927).getDimension();
                        CallChecker.varAssign(firstIndex, "firstIndex", 143, 5908, 5943);
                    }
                }else {
                    components = CallChecker.beforeCalled(components, List.class, 145, 6021, 6030);
                    components = CallChecker.beforeCalled(components, List.class, 145, 6006, 6015);
                    final ExpandableStatefulODE.SecondaryComponent last = CallChecker.varInit(CallChecker.isCalled(components, List.class, 145, 6006, 6015).get(((CallChecker.isCalled(components, List.class, 145, 6021, 6030).size()) - 1)), "last", 145, 5974, 6043);
                    if (CallChecker.beforeDeref(last, ExpandableStatefulODE.SecondaryComponent.class, 146, 6070, 6073)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(last, ExpandableStatefulODE.SecondaryComponent.class, 146, 6070, 6073).mapper, EquationsMapper.class, 146, 6070, 6080)) {
                            if (CallChecker.beforeDeref(last, ExpandableStatefulODE.SecondaryComponent.class, 146, 6100, 6103)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(last, ExpandableStatefulODE.SecondaryComponent.class, 146, 6100, 6103).mapper, EquationsMapper.class, 146, 6100, 6110)) {
                                    firstIndex = (CallChecker.isCalled(CallChecker.isCalled(last, ExpandableStatefulODE.SecondaryComponent.class, 146, 6070, 6073).mapper, EquationsMapper.class, 146, 6070, 6080).getFirstIndex()) + (CallChecker.isCalled(CallChecker.isCalled(last, ExpandableStatefulODE.SecondaryComponent.class, 146, 6100, 6103).mapper, EquationsMapper.class, 146, 6100, 6110).getDimension());
                                    CallChecker.varAssign(firstIndex, "firstIndex", 146, 6057, 6126);
                                }
                            }
                        }
                    }
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(components, List.class, 149, 6147, 6156)) {
                components = CallChecker.beforeCalled(components, List.class, 149, 6147, 6156);
                CallChecker.isCalled(components, List.class, 149, 6147, 6156).add(new ExpandableStatefulODE.SecondaryComponent(secondary, firstIndex));
            }
            components = CallChecker.beforeCalled(components, List.class, 151, 6226, 6235);
            return (CallChecker.isCalled(components, List.class, 151, 6226, 6235).size()) - 1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context148.methodEnd();
        }
    }

    public EquationsMapper getPrimaryMapper() {
        MethodContext _bcornu_methode_context149 = new MethodContext(EquationsMapper.class, 159, 6261, 6487);
        try {
            CallChecker.varInit(this, "this", 159, 6261, 6487);
            CallChecker.varInit(this.components, "components", 159, 6261, 6487);
            CallChecker.varInit(this.primaryStateDot, "primaryStateDot", 159, 6261, 6487);
            CallChecker.varInit(this.primaryState, "primaryState", 159, 6261, 6487);
            CallChecker.varInit(this.time, "time", 159, 6261, 6487);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 159, 6261, 6487);
            CallChecker.varInit(this.primary, "primary", 159, 6261, 6487);
            return primaryMapper;
        } catch (ForceReturn _bcornu_return_t) {
            return ((EquationsMapper) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context149.methodEnd();
        }
    }

    public EquationsMapper[] getSecondaryMappers() {
        MethodContext _bcornu_methode_context150 = new MethodContext(EquationsMapper[].class, 167, 6494, 6939);
        try {
            CallChecker.varInit(this, "this", 167, 6494, 6939);
            CallChecker.varInit(this.components, "components", 167, 6494, 6939);
            CallChecker.varInit(this.primaryStateDot, "primaryStateDot", 167, 6494, 6939);
            CallChecker.varInit(this.primaryState, "primaryState", 167, 6494, 6939);
            CallChecker.varInit(this.time, "time", 167, 6494, 6939);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 167, 6494, 6939);
            CallChecker.varInit(this.primary, "primary", 167, 6494, 6939);
            components = CallChecker.beforeCalled(components, List.class, 168, 6779, 6788);
            final EquationsMapper[] mappers = CallChecker.varInit(new EquationsMapper[CallChecker.isCalled(components, List.class, 168, 6779, 6788).size()], "mappers", 168, 6725, 6797);
            for (int i = 0; i < (CallChecker.isCalled(mappers, EquationsMapper[].class, 169, 6827, 6833).length); ++i) {
                if (CallChecker.beforeDeref(mappers, EquationsMapper[].class, 170, 6862, 6868)) {
                    if (CallChecker.beforeDeref(components, List.class, 170, 6875, 6884)) {
                        components = CallChecker.beforeCalled(components, List.class, 170, 6875, 6884);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(components, List.class, 170, 6875, 6884).get(i), ExpandableStatefulODE.SecondaryComponent.class, 170, 6875, 6891)) {
                            components = CallChecker.beforeCalled(components, List.class, 170, 6875, 6884);
                            CallChecker.isCalled(mappers, EquationsMapper[].class, 170, 6862, 6868)[i] = CallChecker.isCalled(CallChecker.isCalled(components, List.class, 170, 6875, 6884).get(i), ExpandableStatefulODE.SecondaryComponent.class, 170, 6875, 6891).mapper;
                            CallChecker.varAssign(CallChecker.isCalled(mappers, EquationsMapper[].class, 170, 6862, 6868)[i], "CallChecker.isCalled(mappers, EquationsMapper[].class, 170, 6862, 6868)[i]", 170, 6862, 6899);
                        }
                    }
                }
            }
            return mappers;
        } catch (ForceReturn _bcornu_return_t) {
            return ((EquationsMapper[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context150.methodEnd();
        }
    }

    public void setTime(final double time) {
        MethodContext _bcornu_methode_context151 = new MethodContext(void.class, 178, 6946, 7083);
        try {
            CallChecker.varInit(this, "this", 178, 6946, 7083);
            CallChecker.varInit(time, "time", 178, 6946, 7083);
            CallChecker.varInit(this.components, "components", 178, 6946, 7083);
            CallChecker.varInit(this.primaryStateDot, "primaryStateDot", 178, 6946, 7083);
            CallChecker.varInit(this.primaryState, "primaryState", 178, 6946, 7083);
            CallChecker.varInit(this.time, "time", 178, 6946, 7083);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 178, 6946, 7083);
            CallChecker.varInit(this.primary, "primary", 178, 6946, 7083);
            this.time = time;
            CallChecker.varAssign(this.time, "this.time", 179, 7061, 7077);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context151.methodEnd();
        }
    }

    public double getTime() {
        MethodContext _bcornu_methode_context152 = new MethodContext(double.class, 185, 7090, 7203);
        try {
            CallChecker.varInit(this, "this", 185, 7090, 7203);
            CallChecker.varInit(this.components, "components", 185, 7090, 7203);
            CallChecker.varInit(this.primaryStateDot, "primaryStateDot", 185, 7090, 7203);
            CallChecker.varInit(this.primaryState, "primaryState", 185, 7090, 7203);
            CallChecker.varInit(this.time, "time", 185, 7090, 7203);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 185, 7090, 7203);
            CallChecker.varInit(this.primary, "primary", 185, 7090, 7203);
            return time;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context152.methodEnd();
        }
    }

    public void setPrimaryState(final double[] primaryState) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context153 = new MethodContext(void.class, 194, 7210, 7841);
        try {
            CallChecker.varInit(this, "this", 194, 7210, 7841);
            CallChecker.varInit(primaryState, "primaryState", 194, 7210, 7841);
            CallChecker.varInit(this.components, "components", 194, 7210, 7841);
            CallChecker.varInit(this.primaryStateDot, "primaryStateDot", 194, 7210, 7841);
            CallChecker.varInit(this.primaryState, "primaryState", 194, 7210, 7841);
            CallChecker.varInit(this.time, "time", 194, 7210, 7841);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 194, 7210, 7841);
            CallChecker.varInit(this.primary, "primary", 194, 7210, 7841);
            if (CallChecker.beforeDeref(primaryState, double[].class, 197, 7567, 7578)) {
                if (CallChecker.beforeDeref(this.primaryState, double[].class, 197, 7590, 7606)) {
                    if ((CallChecker.isCalled(primaryState, double[].class, 197, 7567, 7578).length) != (CallChecker.isCalled(this.primaryState, double[].class, 197, 7590, 7606).length)) {
                        if (CallChecker.beforeDeref(primaryState, double[].class, 198, 7667, 7678)) {
                            if (CallChecker.beforeDeref(this.primaryState, double[].class, 198, 7688, 7704)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(primaryState, double[].class, 198, 7667, 7678).length, CallChecker.isCalled(this.primaryState, double[].class, 198, 7688, 7704).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
            if (CallChecker.beforeDeref(primaryState, double[].class, 202, 7814, 7825)) {
                System.arraycopy(primaryState, 0, this.primaryState, 0, CallChecker.isCalled(primaryState, double[].class, 202, 7814, 7825).length);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context153.methodEnd();
        }
    }

    public double[] getPrimaryState() {
        MethodContext _bcornu_methode_context154 = new MethodContext(double[].class, 209, 7848, 8029);
        try {
            CallChecker.varInit(this, "this", 209, 7848, 8029);
            CallChecker.varInit(this.components, "components", 209, 7848, 8029);
            CallChecker.varInit(this.primaryStateDot, "primaryStateDot", 209, 7848, 8029);
            CallChecker.varInit(this.primaryState, "primaryState", 209, 7848, 8029);
            CallChecker.varInit(this.time, "time", 209, 7848, 8029);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 209, 7848, 8029);
            CallChecker.varInit(this.primary, "primary", 209, 7848, 8029);
            if (CallChecker.beforeDeref(primaryState, double[].class, 210, 8003, 8014)) {
                return CallChecker.isCalled(primaryState, double[].class, 210, 8003, 8014).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context154.methodEnd();
        }
    }

    public double[] getPrimaryStateDot() {
        MethodContext _bcornu_methode_context155 = new MethodContext(double[].class, 216, 8036, 8245);
        try {
            CallChecker.varInit(this, "this", 216, 8036, 8245);
            CallChecker.varInit(this.components, "components", 216, 8036, 8245);
            CallChecker.varInit(this.primaryStateDot, "primaryStateDot", 216, 8036, 8245);
            CallChecker.varInit(this.primaryState, "primaryState", 216, 8036, 8245);
            CallChecker.varInit(this.time, "time", 216, 8036, 8245);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 216, 8036, 8245);
            CallChecker.varInit(this.primary, "primary", 216, 8036, 8245);
            if (CallChecker.beforeDeref(primaryStateDot, double[].class, 217, 8216, 8230)) {
                return CallChecker.isCalled(primaryStateDot, double[].class, 217, 8216, 8230).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context155.methodEnd();
        }
    }

    public void setSecondaryState(final int index, final double[] secondaryState) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context156 = new MethodContext(void.class, 227, 8252, 9154);
        try {
            CallChecker.varInit(this, "this", 227, 8252, 9154);
            CallChecker.varInit(secondaryState, "secondaryState", 227, 8252, 9154);
            CallChecker.varInit(index, "index", 227, 8252, 9154);
            CallChecker.varInit(this.components, "components", 227, 8252, 9154);
            CallChecker.varInit(this.primaryStateDot, "primaryStateDot", 227, 8252, 9154);
            CallChecker.varInit(this.primaryState, "primaryState", 227, 8252, 9154);
            CallChecker.varInit(this.time, "time", 227, 8252, 9154);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 227, 8252, 9154);
            CallChecker.varInit(this.primary, "primary", 227, 8252, 9154);
            double[] localArray = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(components, List.class, 231, 8826, 8835)) {
                components = CallChecker.beforeCalled(components, List.class, 231, 8826, 8835);
                if (CallChecker.beforeDeref(CallChecker.isCalled(components, List.class, 231, 8826, 8835).get(index), ExpandableStatefulODE.SecondaryComponent.class, 231, 8826, 8846)) {
                    components = CallChecker.beforeCalled(components, List.class, 231, 8826, 8835);
                    localArray = CallChecker.isCalled(CallChecker.isCalled(components, List.class, 231, 8826, 8835).get(index), ExpandableStatefulODE.SecondaryComponent.class, 231, 8826, 8846).state;
                    CallChecker.varAssign(localArray, "localArray", 231, 8826, 8835);
                }
            }
            if (CallChecker.beforeDeref(secondaryState, double[].class, 234, 8893, 8906)) {
                if (CallChecker.beforeDeref(localArray, double[].class, 234, 8918, 8927)) {
                    localArray = CallChecker.beforeCalled(localArray, double[].class, 234, 8918, 8927);
                    if ((CallChecker.isCalled(secondaryState, double[].class, 234, 8893, 8906).length) != (CallChecker.isCalled(localArray, double[].class, 234, 8918, 8927).length)) {
                        if (CallChecker.beforeDeref(secondaryState, double[].class, 235, 8988, 9001)) {
                            if (CallChecker.beforeDeref(localArray, double[].class, 235, 9011, 9020)) {
                                localArray = CallChecker.beforeCalled(localArray, double[].class, 235, 9011, 9020);
                                throw new DimensionMismatchException(CallChecker.isCalled(secondaryState, double[].class, 235, 8988, 9001).length, CallChecker.isCalled(localArray, double[].class, 235, 9011, 9020).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
            if (CallChecker.beforeDeref(secondaryState, double[].class, 239, 9125, 9138)) {
                System.arraycopy(secondaryState, 0, localArray, 0, CallChecker.isCalled(secondaryState, double[].class, 239, 9125, 9138).length);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context156.methodEnd();
        }
    }

    public double[] getSecondaryState(final int index) {
        MethodContext _bcornu_methode_context157 = new MethodContext(double[].class, 248, 9161, 9496);
        try {
            CallChecker.varInit(this, "this", 248, 9161, 9496);
            CallChecker.varInit(index, "index", 248, 9161, 9496);
            CallChecker.varInit(this.components, "components", 248, 9161, 9496);
            CallChecker.varInit(this.primaryStateDot, "primaryStateDot", 248, 9161, 9496);
            CallChecker.varInit(this.primaryState, "primaryState", 248, 9161, 9496);
            CallChecker.varInit(this.time, "time", 248, 9161, 9496);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 248, 9161, 9496);
            CallChecker.varInit(this.primary, "primary", 248, 9161, 9496);
            if (CallChecker.beforeDeref(components, List.class, 249, 9455, 9464)) {
                components = CallChecker.beforeCalled(components, List.class, 249, 9455, 9464);
                if (CallChecker.beforeDeref(CallChecker.isCalled(components, List.class, 249, 9455, 9464).get(index), ExpandableStatefulODE.SecondaryComponent.class, 249, 9455, 9475)) {
                    components = CallChecker.beforeCalled(components, List.class, 249, 9455, 9464);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(components, List.class, 249, 9455, 9464).get(index), ExpandableStatefulODE.SecondaryComponent.class, 249, 9455, 9475).state, double[].class, 249, 9455, 9481)) {
                        components = CallChecker.beforeCalled(components, List.class, 249, 9455, 9464);
                        return CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(components, List.class, 249, 9455, 9464).get(index), ExpandableStatefulODE.SecondaryComponent.class, 249, 9455, 9475).state, double[].class, 249, 9455, 9481).clone();
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context157.methodEnd();
        }
    }

    public double[] getSecondaryStateDot(final int index) {
        MethodContext _bcornu_methode_context158 = new MethodContext(double[].class, 257, 9503, 9866);
        try {
            CallChecker.varInit(this, "this", 257, 9503, 9866);
            CallChecker.varInit(index, "index", 257, 9503, 9866);
            CallChecker.varInit(this.components, "components", 257, 9503, 9866);
            CallChecker.varInit(this.primaryStateDot, "primaryStateDot", 257, 9503, 9866);
            CallChecker.varInit(this.primaryState, "primaryState", 257, 9503, 9866);
            CallChecker.varInit(this.time, "time", 257, 9503, 9866);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 257, 9503, 9866);
            CallChecker.varInit(this.primary, "primary", 257, 9503, 9866);
            if (CallChecker.beforeDeref(components, List.class, 258, 9822, 9831)) {
                components = CallChecker.beforeCalled(components, List.class, 258, 9822, 9831);
                if (CallChecker.beforeDeref(CallChecker.isCalled(components, List.class, 258, 9822, 9831).get(index), ExpandableStatefulODE.SecondaryComponent.class, 258, 9822, 9842)) {
                    components = CallChecker.beforeCalled(components, List.class, 258, 9822, 9831);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(components, List.class, 258, 9822, 9831).get(index), ExpandableStatefulODE.SecondaryComponent.class, 258, 9822, 9842).stateDot, double[].class, 258, 9822, 9851)) {
                        components = CallChecker.beforeCalled(components, List.class, 258, 9822, 9831);
                        return CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(components, List.class, 258, 9822, 9831).get(index), ExpandableStatefulODE.SecondaryComponent.class, 258, 9822, 9842).stateDot, double[].class, 258, 9822, 9851).clone();
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context158.methodEnd();
        }
    }

    public void setCompleteState(final double[] completeState) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context159 = new MethodContext(void.class, 266, 9873, 10680);
        try {
            CallChecker.varInit(this, "this", 266, 9873, 10680);
            CallChecker.varInit(completeState, "completeState", 266, 9873, 10680);
            CallChecker.varInit(this.components, "components", 266, 9873, 10680);
            CallChecker.varInit(this.primaryStateDot, "primaryStateDot", 266, 9873, 10680);
            CallChecker.varInit(this.primaryState, "primaryState", 266, 9873, 10680);
            CallChecker.varInit(this.time, "time", 266, 9873, 10680);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 266, 9873, 10680);
            CallChecker.varInit(this.primary, "primary", 266, 9873, 10680);
            if (CallChecker.beforeDeref(completeState, double[].class, 270, 10272, 10284)) {
                if ((CallChecker.isCalled(completeState, double[].class, 270, 10272, 10284).length) != (getTotalDimension())) {
                    if (CallChecker.beforeDeref(completeState, double[].class, 271, 10368, 10380)) {
                        throw new DimensionMismatchException(CallChecker.isCalled(completeState, double[].class, 271, 10368, 10380).length, getTotalDimension());
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            if (CallChecker.beforeDeref(primaryMapper, EquationsMapper.class, 275, 10455, 10467)) {
                CallChecker.isCalled(primaryMapper, EquationsMapper.class, 275, 10455, 10467).extractEquationData(completeState, primaryState);
            }
            if (CallChecker.beforeDeref(components, void.class, 276, 10569, 10578)) {
                for (final ExpandableStatefulODE.SecondaryComponent component : components) {
                    if (CallChecker.beforeDeref(component, ExpandableStatefulODE.SecondaryComponent.class, 277, 10595, 10603)) {
                        if (CallChecker.beforeDeref(component, ExpandableStatefulODE.SecondaryComponent.class, 277, 10647, 10655)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(component, ExpandableStatefulODE.SecondaryComponent.class, 277, 10595, 10603).mapper, EquationsMapper.class, 277, 10595, 10610)) {
                                CallChecker.isCalled(CallChecker.isCalled(component, ExpandableStatefulODE.SecondaryComponent.class, 277, 10595, 10603).mapper, EquationsMapper.class, 277, 10595, 10610).extractEquationData(completeState, CallChecker.isCalled(component, ExpandableStatefulODE.SecondaryComponent.class, 277, 10647, 10655).state);
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context159.methodEnd();
        }
    }

    public double[] getCompleteState() throws DimensionMismatchException {
        MethodContext _bcornu_methode_context160 = new MethodContext(double[].class, 287, 10687, 11374);
        try {
            CallChecker.varInit(this, "this", 287, 10687, 11374);
            CallChecker.varInit(this.components, "components", 287, 10687, 11374);
            CallChecker.varInit(this.primaryStateDot, "primaryStateDot", 287, 10687, 11374);
            CallChecker.varInit(this.primaryState, "primaryState", 287, 10687, 11374);
            CallChecker.varInit(this.time, "time", 287, 10687, 11374);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 287, 10687, 11374);
            CallChecker.varInit(this.primary, "primary", 287, 10687, 11374);
            double[] completeState = CallChecker.varInit(new double[getTotalDimension()], "completeState", 290, 11029, 11085);
            if (CallChecker.beforeDeref(primaryMapper, EquationsMapper.class, 293, 11120, 11132)) {
                CallChecker.isCalled(primaryMapper, EquationsMapper.class, 293, 11120, 11132).insertEquationData(primaryState, completeState);
            }
            if (CallChecker.beforeDeref(components, double[].class, 294, 11233, 11242)) {
                for (final ExpandableStatefulODE.SecondaryComponent component : components) {
                    if (CallChecker.beforeDeref(component, ExpandableStatefulODE.SecondaryComponent.class, 295, 11259, 11267)) {
                        if (CallChecker.beforeDeref(component, ExpandableStatefulODE.SecondaryComponent.class, 295, 11295, 11303)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(component, ExpandableStatefulODE.SecondaryComponent.class, 295, 11259, 11267).mapper, EquationsMapper.class, 295, 11259, 11274)) {
                                CallChecker.isCalled(CallChecker.isCalled(component, ExpandableStatefulODE.SecondaryComponent.class, 295, 11259, 11267).mapper, EquationsMapper.class, 295, 11259, 11274).insertEquationData(CallChecker.isCalled(component, ExpandableStatefulODE.SecondaryComponent.class, 295, 11295, 11303).state, completeState);
                            }
                        }
                    }
                }
            }
            return completeState;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context160.methodEnd();
        }
    }
}

