package com.mckoi.database.jdbcserver;

import com.mckoi.database.DataCell;
import com.mckoi.database.Database;
import com.mckoi.database.DatabaseConnection;
import com.mckoi.database.RowEnumeration;
import com.mckoi.database.Table;
import com.mckoi.database.User;
import com.mckoi.database.Variable;
import com.mckoi.database.global.ColumnDescription;
import com.mckoi.database.interpret.SQLQueryExecutor;
import com.mckoi.database.jdbc.DatabaseInterface;
import com.mckoi.database.jdbc.MSQLException;
import com.mckoi.database.jdbc.QueryResponse;
import com.mckoi.database.jdbc.ResultPart;
import com.mckoi.database.jdbc.SQLQuery;
import com.mckoi.database.sql.ParseException;
import com.mckoi.debug.DebugLogger;
import com.mckoi.debug.Lvl;
import com.mckoi.util.IntegerVector;
import com.mckoi.util.StringUtil;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public abstract class AbstractJDBCDatabaseInterface implements DatabaseInterface {
    private static final class JDIQueryResponse implements QueryResponse {
        int result_id;

        AbstractJDBCDatabaseInterface.ResultSetInfo result_set_info;

        int query_time;

        String warnings;

        JDIQueryResponse(int result_id, AbstractJDBCDatabaseInterface.ResultSetInfo result_set_info, int query_time, String warnings) {
            MethodContext _bcornu_methode_context6 = new MethodContext(null);
            try {
                this.result_id = result_id;
                CallChecker.varAssign(this.result_id, "this.result_id", 553, 17379, 17405);
                this.result_set_info = result_set_info;
                CallChecker.varAssign(this.result_set_info, "this.result_set_info", 554, 17414, 17452);
                this.query_time = query_time;
                CallChecker.varAssign(this.query_time, "this.query_time", 555, 17461, 17489);
                this.warnings = warnings;
                CallChecker.varAssign(this.warnings, "this.warnings", 556, 17498, 17522);
            } finally {
                _bcornu_methode_context6.methodEnd();
            }
        }

        public int getResultID() {
            MethodContext _bcornu_methode_context34 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 559, 17538, 17595);
                CallChecker.varInit(this.warnings, "warnings", 559, 17538, 17595);
                CallChecker.varInit(this.query_time, "query_time", 559, 17538, 17595);
                CallChecker.varInit(this.result_set_info, "result_set_info", 559, 17538, 17595);
                CallChecker.varInit(this.result_id, "result_id", 559, 17538, 17595);
                return result_id;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context34.methodEnd();
            }
        }

        public int getQueryTimeMillis() {
            MethodContext _bcornu_methode_context35 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 563, 17604, 17669);
                CallChecker.varInit(this.warnings, "warnings", 563, 17604, 17669);
                CallChecker.varInit(this.query_time, "query_time", 563, 17604, 17669);
                CallChecker.varInit(this.result_set_info, "result_set_info", 563, 17604, 17669);
                CallChecker.varInit(this.result_id, "result_id", 563, 17604, 17669);
                return query_time;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context35.methodEnd();
            }
        }

        public int getRowCount() {
            MethodContext _bcornu_methode_context36 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 567, 17678, 17755);
                CallChecker.varInit(this.warnings, "warnings", 567, 17678, 17755);
                CallChecker.varInit(this.query_time, "query_time", 567, 17678, 17755);
                CallChecker.varInit(this.result_set_info, "result_set_info", 567, 17678, 17755);
                CallChecker.varInit(this.result_id, "result_id", 567, 17678, 17755);
                if (CallChecker.beforeDeref(result_set_info, AbstractJDBCDatabaseInterface.ResultSetInfo.class, 568, 17719, 17733)) {
                    result_set_info = CallChecker.beforeCalled(result_set_info, AbstractJDBCDatabaseInterface.ResultSetInfo.class, 568, 17719, 17733);
                    return CallChecker.isCalled(result_set_info, AbstractJDBCDatabaseInterface.ResultSetInfo.class, 568, 17719, 17733).getRowCount();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context36.methodEnd();
            }
        }

        public int getColumnCount() {
            MethodContext _bcornu_methode_context37 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 571, 17764, 17847);
                CallChecker.varInit(this.warnings, "warnings", 571, 17764, 17847);
                CallChecker.varInit(this.query_time, "query_time", 571, 17764, 17847);
                CallChecker.varInit(this.result_set_info, "result_set_info", 571, 17764, 17847);
                CallChecker.varInit(this.result_id, "result_id", 571, 17764, 17847);
                if (CallChecker.beforeDeref(result_set_info, AbstractJDBCDatabaseInterface.ResultSetInfo.class, 572, 17808, 17822)) {
                    result_set_info = CallChecker.beforeCalled(result_set_info, AbstractJDBCDatabaseInterface.ResultSetInfo.class, 572, 17808, 17822);
                    return CallChecker.isCalled(result_set_info, AbstractJDBCDatabaseInterface.ResultSetInfo.class, 572, 17808, 17822).getColumnCount();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context37.methodEnd();
            }
        }

        public ColumnDescription getColumnDescription(int n) {
            MethodContext _bcornu_methode_context38 = new MethodContext(ColumnDescription.class);
            try {
                CallChecker.varInit(this, "this", 575, 17856, 17962);
                CallChecker.varInit(n, "n", 575, 17856, 17962);
                CallChecker.varInit(this.warnings, "warnings", 575, 17856, 17962);
                CallChecker.varInit(this.query_time, "query_time", 575, 17856, 17962);
                CallChecker.varInit(this.result_set_info, "result_set_info", 575, 17856, 17962);
                CallChecker.varInit(this.result_id, "result_id", 575, 17856, 17962);
                if (CallChecker.beforeDeref(result_set_info, AbstractJDBCDatabaseInterface.ResultSetInfo.class, 576, 17925, 17939)) {
                    result_set_info = CallChecker.beforeCalled(result_set_info, AbstractJDBCDatabaseInterface.ResultSetInfo.class, 576, 17925, 17939);
                    final ColumnDescription[] npe_invocation_var21 = CallChecker.isCalled(result_set_info, AbstractJDBCDatabaseInterface.ResultSetInfo.class, 576, 17925, 17939).getFields();
                    if (CallChecker.beforeDeref(npe_invocation_var21, ColumnDescription[].class, 576, 17925, 17951)) {
                        return CallChecker.isCalled(npe_invocation_var21, ColumnDescription[].class, 576, 17925, 17951)[n];
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((ColumnDescription) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context38.methodEnd();
            }
        }

        public String getWarnings() {
            MethodContext _bcornu_methode_context39 = new MethodContext(String.class);
            try {
                CallChecker.varInit(this, "this", 579, 17971, 18030);
                CallChecker.varInit(this.warnings, "warnings", 579, 17971, 18030);
                CallChecker.varInit(this.query_time, "query_time", 579, 17971, 18030);
                CallChecker.varInit(this.result_set_info, "result_set_info", 579, 17971, 18030);
                CallChecker.varInit(this.result_id, "result_id", 579, 17971, 18030);
                return warnings;
            } catch (ForceReturn _bcornu_return_t) {
                return ((String) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context39.methodEnd();
            }
        }
    }

    private static final class ResultSetInfo {
        private SQLQuery query;

        private Table result;

        private ColumnDescription[] col_desc;

        private IntegerVector row_index_map;

        private int locked;

        ResultSetInfo(SQLQuery query, Table table) {
            MethodContext _bcornu_methode_context7 = new MethodContext(null);
            try {
                this.query = query;
                CallChecker.varAssign(this.query, "this.query", 629, 19220, 19238);
                this.result = table;
                CallChecker.varAssign(this.result, "this.result", 630, 19247, 19266);
                RowEnumeration row_enum = CallChecker.init(RowEnumeration.class);
                if (CallChecker.beforeDeref(table, Table.class, 636, 19578, 19582)) {
                    table = CallChecker.beforeCalled(table, Table.class, 636, 19578, 19582);
                    row_enum = CallChecker.isCalled(table, Table.class, 636, 19578, 19582).rowEnumeration();
                    CallChecker.varAssign(row_enum, "row_enum", 636, 19578, 19582);
                }
                if (CallChecker.beforeDeref(row_enum, RowEnumeration.class, 637, 19613, 19620)) {
                    row_enum = CallChecker.beforeCalled(row_enum, RowEnumeration.class, 637, 19613, 19620);
                    if (CallChecker.isCalled(row_enum, RowEnumeration.class, 637, 19613, 19620).hasMoreRows()) {
                        int row_index = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(row_enum, RowEnumeration.class, 638, 19664, 19671)) {
                            row_enum = CallChecker.beforeCalled(row_enum, RowEnumeration.class, 638, 19664, 19671);
                            row_index = CallChecker.isCalled(row_enum, RowEnumeration.class, 638, 19664, 19671).nextRowIndex();
                            CallChecker.varAssign(row_index, "row_index", 638, 19664, 19671);
                        }
                        table = CallChecker.beforeCalled(table, Table.class, 639, 19718, 19722);
                        for (int c = 0; c < (CallChecker.isCalled(table, Table.class, 639, 19718, 19722).getColumnCount()); ++c) {
                            if (CallChecker.beforeDeref(table, Table.class, 640, 19760, 19764)) {
                                table = CallChecker.beforeCalled(table, Table.class, 640, 19760, 19764);
                                CallChecker.isCalled(table, Table.class, 640, 19760, 19764).getCellContents(c, row_index);
                            }
                        }
                    }
                }else
                    throw new AbnormalExecutionError();
                
                row_enum = null;
                CallChecker.varAssign(row_enum, "row_enum", 643, 19824, 19839);
                if (CallChecker.beforeDeref(table, Table.class, 646, 19916, 19920)) {
                    table = CallChecker.beforeCalled(table, Table.class, 646, 19916, 19920);
                    row_index_map = new IntegerVector(CallChecker.isCalled(table, Table.class, 646, 19916, 19920).getRowCount());
                    CallChecker.varAssign(this.row_index_map, "this.row_index_map", 646, 19882, 19936);
                }
                RowEnumeration e = CallChecker.init(RowEnumeration.class);
                if (CallChecker.beforeDeref(table, Table.class, 647, 19964, 19968)) {
                    table = CallChecker.beforeCalled(table, Table.class, 647, 19964, 19968);
                    e = CallChecker.isCalled(table, Table.class, 647, 19964, 19968).rowEnumeration();
                    CallChecker.varAssign(e, "e", 647, 19964, 19968);
                }
                e = CallChecker.beforeCalled(e, RowEnumeration.class, 648, 20002, 20002);
                while (CallChecker.isCalled(e, RowEnumeration.class, 648, 20002, 20002).hasMoreRows()) {
                    if (CallChecker.beforeDeref(e, RowEnumeration.class, 649, 20051, 20051)) {
                        if (CallChecker.beforeDeref(row_index_map, IntegerVector.class, 649, 20030, 20042)) {
                            e = CallChecker.beforeCalled(e, RowEnumeration.class, 649, 20051, 20051);
                            row_index_map = CallChecker.beforeCalled(row_index_map, IntegerVector.class, 649, 20030, 20042);
                            CallChecker.isCalled(row_index_map, IntegerVector.class, 649, 20030, 20042).addInt(CallChecker.isCalled(e, RowEnumeration.class, 649, 20051, 20051).nextRowIndex());
                        }
                    }
                } 
                table = CallChecker.beforeCalled(table, Table.class, 656, 20360, 20364);
                final int col_count = CallChecker.varInit(((int) (CallChecker.isCalled(table, Table.class, 656, 20360, 20364).getColumnCount())), "col_count", 656, 20088, 20382);
                col_desc = new ColumnDescription[col_count];
                CallChecker.varAssign(this.col_desc, "this.col_desc", 657, 20391, 20434);
                for (int i = 0; i < col_count; ++i) {
                    Variable v = CallChecker.init(Variable.class);
                    if (CallChecker.beforeDeref(table, Table.class, 659, 20503, 20507)) {
                        table = CallChecker.beforeCalled(table, Table.class, 659, 20503, 20507);
                        v = CallChecker.isCalled(table, Table.class, 659, 20503, 20507).getResolvedVariable(i);
                        CallChecker.varAssign(v, "v", 659, 20503, 20507);
                    }
                    String field_name = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(v, Variable.class, 661, 20574, 20574)) {
                        v = CallChecker.beforeCalled(v, Variable.class, 661, 20574, 20574);
                        if ((CallChecker.isCalled(v, Variable.class, 661, 20574, 20574).getTableName()) == null) {
                            if (CallChecker.beforeDeref(v, Variable.class, 663, 20681, 20681)) {
                                v = CallChecker.beforeCalled(v, Variable.class, 663, 20681, 20681);
                                field_name = "@a" + (CallChecker.isCalled(v, Variable.class, 663, 20681, 20681).getName());
                                CallChecker.varAssign(field_name, "field_name", 663, 20661, 20692);
                            }
                        }else {
                            if (CallChecker.beforeDeref(v, Variable.class, 667, 20824, 20824)) {
                                v = CallChecker.beforeCalled(v, Variable.class, 667, 20824, 20824);
                                field_name = "@f" + (CallChecker.isCalled(v, Variable.class, 667, 20824, 20824).toString());
                                CallChecker.varAssign(field_name, "field_name", 667, 20804, 20836);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(col_desc, ColumnDescription[].class, 669, 20858, 20865)) {
                        if (CallChecker.beforeDeref(table, Table.class, 669, 20906, 20910)) {
                            col_desc = CallChecker.beforeCalled(col_desc, ColumnDescription[].class, 669, 20858, 20865);
                            table = CallChecker.beforeCalled(table, Table.class, 669, 20906, 20910);
                            CallChecker.isCalled(col_desc, ColumnDescription[].class, 669, 20858, 20865)[i] = new ColumnDescription(field_name, CallChecker.isCalled(table, Table.class, 669, 20906, 20910).getFieldAt(i));
                            CallChecker.varAssign(CallChecker.isCalled(this.col_desc, ColumnDescription[].class, 669, 20858, 20865)[i], "CallChecker.isCalled(this.col_desc, ColumnDescription[].class, 669, 20858, 20865)[i]", 669, 20858, 20926);
                        }
                    }
                }
                locked = 0;
                CallChecker.varAssign(this.locked, "this.locked", 672, 20946, 20956);
            } finally {
                _bcornu_methode_context7.methodEnd();
            }
        }

        SQLQuery getSQLQuery() {
            MethodContext _bcornu_methode_context40 = new MethodContext(SQLQuery.class);
            try {
                CallChecker.varInit(this, "this", 678, 20972, 21108);
                CallChecker.varInit(this.locked, "locked", 678, 20972, 21108);
                CallChecker.varInit(this.row_index_map, "row_index_map", 678, 20972, 21108);
                CallChecker.varInit(this.col_desc, "col_desc", 678, 20972, 21108);
                CallChecker.varInit(this.result, "result", 678, 20972, 21108);
                CallChecker.varInit(this.query, "query", 678, 20972, 21108);
                return query;
            } catch (ForceReturn _bcornu_return_t) {
                return ((SQLQuery) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context40.methodEnd();
            }
        }

        void dispose() {
            MethodContext _bcornu_methode_context41 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 685, 21117, 21324);
                CallChecker.varInit(this.locked, "locked", 685, 21117, 21324);
                CallChecker.varInit(this.row_index_map, "row_index_map", 685, 21117, 21324);
                CallChecker.varInit(this.col_desc, "col_desc", 685, 21117, 21324);
                CallChecker.varInit(this.result, "result", 685, 21117, 21324);
                CallChecker.varInit(this.query, "query", 685, 21117, 21324);
                while ((locked) > 0) {
                    unlockRoot((-1));
                } 
                result = null;
                CallChecker.varAssign(this.result, "this.result", 689, 21251, 21264);
                row_index_map = null;
                CallChecker.varAssign(this.row_index_map, "this.row_index_map", 690, 21273, 21293);
                col_desc = null;
                CallChecker.varAssign(this.col_desc, "this.col_desc", 691, 21302, 21317);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context41.methodEnd();
            }
        }

        DataCell getCellContents(int column, int row) {
            MethodContext _bcornu_methode_context42 = new MethodContext(DataCell.class);
            try {
                CallChecker.varInit(this, "this", 699, 21333, 21741);
                CallChecker.varInit(row, "row", 699, 21333, 21741);
                CallChecker.varInit(column, "column", 699, 21333, 21741);
                CallChecker.varInit(this.locked, "locked", 699, 21333, 21741);
                CallChecker.varInit(this.row_index_map, "row_index_map", 699, 21333, 21741);
                CallChecker.varInit(this.col_desc, "col_desc", 699, 21333, 21741);
                CallChecker.varInit(this.result, "result", 699, 21333, 21741);
                CallChecker.varInit(this.query, "query", 699, 21333, 21741);
                if ((locked) > 0) {
                    int real_row = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(row_index_map, IntegerVector.class, 701, 21567, 21579)) {
                        row_index_map = CallChecker.beforeCalled(row_index_map, IntegerVector.class, 701, 21567, 21579);
                        real_row = CallChecker.isCalled(row_index_map, IntegerVector.class, 701, 21567, 21579).intAt(row);
                        CallChecker.varAssign(real_row, "real_row", 701, 21567, 21579);
                    }
                    if (CallChecker.beforeDeref(result, Table.class, 702, 21609, 21614)) {
                        result = CallChecker.beforeCalled(result, Table.class, 702, 21609, 21614);
                        return CallChecker.isCalled(result, Table.class, 702, 21609, 21614).getCellContents(column, real_row);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else {
                    throw new Error("Table roots not locked!");
                }
            } catch (ForceReturn _bcornu_return_t) {
                return ((DataCell) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context42.methodEnd();
            }
        }

        int getColumnCount() {
            MethodContext _bcornu_methode_context43 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 712, 21750, 21869);
                CallChecker.varInit(this.locked, "locked", 712, 21750, 21869);
                CallChecker.varInit(this.row_index_map, "row_index_map", 712, 21750, 21869);
                CallChecker.varInit(this.col_desc, "col_desc", 712, 21750, 21869);
                CallChecker.varInit(this.result, "result", 712, 21750, 21869);
                CallChecker.varInit(this.query, "query", 712, 21750, 21869);
                if (CallChecker.beforeDeref(result, Table.class, 713, 21839, 21844)) {
                    result = CallChecker.beforeCalled(result, Table.class, 713, 21839, 21844);
                    return CallChecker.isCalled(result, Table.class, 713, 21839, 21844).getColumnCount();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context43.methodEnd();
            }
        }

        int getRowCount() {
            MethodContext _bcornu_methode_context44 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 719, 21878, 21988);
                CallChecker.varInit(this.locked, "locked", 719, 21878, 21988);
                CallChecker.varInit(this.row_index_map, "row_index_map", 719, 21878, 21988);
                CallChecker.varInit(this.col_desc, "col_desc", 719, 21878, 21988);
                CallChecker.varInit(this.result, "result", 719, 21878, 21988);
                CallChecker.varInit(this.query, "query", 719, 21878, 21988);
                if (CallChecker.beforeDeref(row_index_map, IntegerVector.class, 720, 21961, 21973)) {
                    row_index_map = CallChecker.beforeCalled(row_index_map, IntegerVector.class, 720, 21961, 21973);
                    return CallChecker.isCalled(row_index_map, IntegerVector.class, 720, 21961, 21973).size();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context44.methodEnd();
            }
        }

        ColumnDescription[] getFields() {
            MethodContext _bcornu_methode_context45 = new MethodContext(ColumnDescription[].class);
            try {
                CallChecker.varInit(this, "this", 726, 21997, 22156);
                CallChecker.varInit(this.locked, "locked", 726, 21997, 22156);
                CallChecker.varInit(this.row_index_map, "row_index_map", 726, 21997, 22156);
                CallChecker.varInit(this.col_desc, "col_desc", 726, 21997, 22156);
                CallChecker.varInit(this.result, "result", 726, 21997, 22156);
                CallChecker.varInit(this.query, "query", 726, 21997, 22156);
                return col_desc;
            } catch (ForceReturn _bcornu_return_t) {
                return ((ColumnDescription[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context45.methodEnd();
            }
        }

        void lockRoot(int key) {
            MethodContext _bcornu_methode_context46 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 733, 22165, 22301);
                CallChecker.varInit(key, "key", 733, 22165, 22301);
                CallChecker.varInit(this.locked, "locked", 733, 22165, 22301);
                CallChecker.varInit(this.row_index_map, "row_index_map", 733, 22165, 22301);
                CallChecker.varInit(this.col_desc, "col_desc", 733, 22165, 22301);
                CallChecker.varInit(this.result, "result", 733, 22165, 22301);
                CallChecker.varInit(this.query, "query", 733, 22165, 22301);
                if (CallChecker.beforeDeref(result, Table.class, 734, 22257, 22262)) {
                    result = CallChecker.beforeCalled(result, Table.class, 734, 22257, 22262);
                    CallChecker.isCalled(result, Table.class, 734, 22257, 22262).lockRoot(key);
                }
                ++(locked);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context46.methodEnd();
            }
        }

        void unlockRoot(int key) {
            MethodContext _bcornu_methode_context47 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 741, 22310, 22452);
                CallChecker.varInit(key, "key", 741, 22310, 22452);
                CallChecker.varInit(this.locked, "locked", 741, 22310, 22452);
                CallChecker.varInit(this.row_index_map, "row_index_map", 741, 22310, 22452);
                CallChecker.varInit(this.col_desc, "col_desc", 741, 22310, 22452);
                CallChecker.varInit(this.result, "result", 741, 22310, 22452);
                CallChecker.varInit(this.query, "query", 741, 22310, 22452);
                if (CallChecker.beforeDeref(result, Table.class, 742, 22406, 22411)) {
                    result = CallChecker.beforeCalled(result, Table.class, 742, 22406, 22411);
                    CallChecker.isCalled(result, Table.class, 742, 22406, 22411).unlockRoot(key);
                }
                --(locked);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context47.methodEnd();
            }
        }
    }

    private Database database;

    private HashMap result_set_map;

    private int unique_result_id;

    private User user = null;

    private DatabaseConnection database_connection;

    private SQLQueryExecutor sql_executor;

    private boolean disposed;

    public AbstractJDBCDatabaseInterface(Database database) {
        MethodContext _bcornu_methode_context8 = new MethodContext(null);
        try {
            this.database = database;
            CallChecker.varAssign(this.database, "this.database", 120, 3932, 3956);
            result_set_map = new HashMap();
            CallChecker.varAssign(this.result_set_map, "this.result_set_map", 121, 3963, 3993);
            unique_result_id = 1;
            CallChecker.varAssign(this.unique_result_id, "this.unique_result_id", 122, 4000, 4020);
            disposed = false;
            CallChecker.varAssign(this.disposed, "this.disposed", 123, 4027, 4043);
        } finally {
            _bcornu_methode_context8.methodEnd();
        }
    }

    protected final void init(User user, DatabaseConnection connection) {
        MethodContext _bcornu_methode_context48 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 134, 4055, 4620);
            CallChecker.varInit(connection, "connection", 134, 4055, 4620);
            CallChecker.varInit(user, "user", 134, 4055, 4620);
            CallChecker.varInit(this.disposed, "disposed", 134, 4055, 4620);
            CallChecker.varInit(this.sql_executor, "sql_executor", 134, 4055, 4620);
            CallChecker.varInit(this.database_connection, "database_connection", 134, 4055, 4620);
            CallChecker.varInit(this.user, "user", 134, 4055, 4620);
            CallChecker.varInit(this.unique_result_id, "unique_result_id", 134, 4055, 4620);
            CallChecker.varInit(this.result_set_map, "result_set_map", 134, 4055, 4620);
            CallChecker.varInit(this.database, "database", 134, 4055, 4620);
            this.user = user;
            CallChecker.varAssign(this.user, "this.user", 135, 4429, 4445);
            this.database_connection = connection;
            CallChecker.varAssign(this.database_connection, "this.database_connection", 136, 4452, 4489);
            sql_executor = new SQLQueryExecutor();
            CallChecker.varAssign(this.sql_executor, "this.sql_executor", 138, 4527, 4564);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context48.methodEnd();
        }
    }

    protected final Database getDatabase() {
        MethodContext _bcornu_methode_context49 = new MethodContext(Database.class);
        try {
            CallChecker.varInit(this, "this", 145, 4627, 4773);
            CallChecker.varInit(this.disposed, "disposed", 145, 4627, 4773);
            CallChecker.varInit(this.sql_executor, "sql_executor", 145, 4627, 4773);
            CallChecker.varInit(this.database_connection, "database_connection", 145, 4627, 4773);
            CallChecker.varInit(this.user, "user", 145, 4627, 4773);
            CallChecker.varInit(this.unique_result_id, "unique_result_id", 145, 4627, 4773);
            CallChecker.varInit(this.result_set_map, "result_set_map", 145, 4627, 4773);
            CallChecker.varInit(this.database, "database", 145, 4627, 4773);
            return database;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Database) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context49.methodEnd();
        }
    }

    protected final User getUser() {
        MethodContext _bcornu_methode_context50 = new MethodContext(User.class);
        try {
            CallChecker.varInit(this, "this", 152, 4780, 4899);
            CallChecker.varInit(this.disposed, "disposed", 152, 4780, 4899);
            CallChecker.varInit(this.sql_executor, "sql_executor", 152, 4780, 4899);
            CallChecker.varInit(this.database_connection, "database_connection", 152, 4780, 4899);
            CallChecker.varInit(this.user, "user", 152, 4780, 4899);
            CallChecker.varInit(this.unique_result_id, "unique_result_id", 152, 4780, 4899);
            CallChecker.varInit(this.result_set_map, "result_set_map", 152, 4780, 4899);
            CallChecker.varInit(this.database, "database", 152, 4780, 4899);
            return user;
        } catch (ForceReturn _bcornu_return_t) {
            return ((User) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context50.methodEnd();
        }
    }

    public final DebugLogger Debug() {
        MethodContext _bcornu_methode_context51 = new MethodContext(DebugLogger.class);
        try {
            CallChecker.varInit(this, "this", 160, 4906, 5082);
            CallChecker.varInit(this.disposed, "disposed", 160, 4906, 5082);
            CallChecker.varInit(this.sql_executor, "sql_executor", 160, 4906, 5082);
            CallChecker.varInit(this.database_connection, "database_connection", 160, 4906, 5082);
            CallChecker.varInit(this.user, "user", 160, 4906, 5082);
            CallChecker.varInit(this.unique_result_id, "unique_result_id", 160, 4906, 5082);
            CallChecker.varInit(this.result_set_map, "result_set_map", 160, 4906, 5082);
            CallChecker.varInit(this.database, "database", 160, 4906, 5082);
            final Database npe_invocation_var22 = getDatabase();
            if (CallChecker.beforeDeref(npe_invocation_var22, Database.class, 161, 5056, 5068)) {
                return CallChecker.isCalled(npe_invocation_var22, Database.class, 161, 5056, 5068).Debug();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DebugLogger) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context51.methodEnd();
        }
    }

    protected final DatabaseConnection getDatabaseConnection() {
        MethodContext _bcornu_methode_context52 = new MethodContext(DatabaseConnection.class);
        try {
            CallChecker.varInit(this, "this", 167, 5089, 5265);
            CallChecker.varInit(this.disposed, "disposed", 167, 5089, 5265);
            CallChecker.varInit(this.sql_executor, "sql_executor", 167, 5089, 5265);
            CallChecker.varInit(this.database_connection, "database_connection", 167, 5089, 5265);
            CallChecker.varInit(this.user, "user", 167, 5089, 5265);
            CallChecker.varInit(this.unique_result_id, "unique_result_id", 167, 5089, 5265);
            CallChecker.varInit(this.result_set_map, "result_set_map", 167, 5089, 5265);
            CallChecker.varInit(this.database, "database", 167, 5089, 5265);
            return database_connection;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DatabaseConnection) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context52.methodEnd();
        }
    }

    private int addResultSet(AbstractJDBCDatabaseInterface.ResultSetInfo result) {
        MethodContext _bcornu_methode_context53 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 176, 5272, 5926);
            CallChecker.varInit(result, "result", 176, 5272, 5926);
            CallChecker.varInit(this.disposed, "disposed", 176, 5272, 5926);
            CallChecker.varInit(this.sql_executor, "sql_executor", 176, 5272, 5926);
            CallChecker.varInit(this.database_connection, "database_connection", 176, 5272, 5926);
            CallChecker.varInit(this.user, "user", 176, 5272, 5926);
            CallChecker.varInit(this.unique_result_id, "unique_result_id", 176, 5272, 5926);
            CallChecker.varInit(this.result_set_map, "result_set_map", 176, 5272, 5926);
            CallChecker.varInit(this.database, "database", 176, 5272, 5926);
            if (CallChecker.beforeDeref(result, AbstractJDBCDatabaseInterface.ResultSetInfo.class, 178, 5544, 5549)) {
                result = CallChecker.beforeCalled(result, AbstractJDBCDatabaseInterface.ResultSetInfo.class, 178, 5544, 5549);
                CallChecker.isCalled(result, AbstractJDBCDatabaseInterface.ResultSetInfo.class, 178, 5544, 5549).lockRoot((-1));
            }
            int result_id = CallChecker.init(int.class);
            synchronized(result_set_map) {
                result_id = ++(unique_result_id);
                CallChecker.varAssign(result_id, "result_id", 184, 5763, 5793);
                if (CallChecker.beforeDeref(result_set_map, HashMap.class, 186, 5839, 5852)) {
                    result_set_map = CallChecker.beforeCalled(result_set_map, HashMap.class, 186, 5839, 5852);
                    CallChecker.isCalled(result_set_map, HashMap.class, 186, 5839, 5852).put(new Integer(result_id), result);
                }
            }
            return result_id;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context53.methodEnd();
        }
    }

    private AbstractJDBCDatabaseInterface.ResultSetInfo getResultSet(int result_id) {
        MethodContext _bcornu_methode_context54 = new MethodContext(AbstractJDBCDatabaseInterface.ResultSetInfo.class);
        try {
            CallChecker.varInit(this, "this", 195, 5933, 6172);
            CallChecker.varInit(result_id, "result_id", 195, 5933, 6172);
            CallChecker.varInit(this.disposed, "disposed", 195, 5933, 6172);
            CallChecker.varInit(this.sql_executor, "sql_executor", 195, 5933, 6172);
            CallChecker.varInit(this.database_connection, "database_connection", 195, 5933, 6172);
            CallChecker.varInit(this.user, "user", 195, 5933, 6172);
            CallChecker.varInit(this.unique_result_id, "unique_result_id", 195, 5933, 6172);
            CallChecker.varInit(this.result_set_map, "result_set_map", 195, 5933, 6172);
            CallChecker.varInit(this.database, "database", 195, 5933, 6172);
            synchronized(result_set_map) {
                if (CallChecker.beforeDeref(result_set_map, HashMap.class, 197, 6118, 6131)) {
                    result_set_map = CallChecker.beforeCalled(result_set_map, HashMap.class, 197, 6118, 6131);
                    return ((AbstractJDBCDatabaseInterface.ResultSetInfo) (CallChecker.isCalled(result_set_map, HashMap.class, 197, 6118, 6131).get(new Integer(result_id))));
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((AbstractJDBCDatabaseInterface.ResultSetInfo) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context54.methodEnd();
        }
    }

    private void disposeResultSet(int result_id) {
        MethodContext _bcornu_methode_context55 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 205, 6179, 6722);
            CallChecker.varInit(result_id, "result_id", 205, 6179, 6722);
            CallChecker.varInit(this.disposed, "disposed", 205, 6179, 6722);
            CallChecker.varInit(this.sql_executor, "sql_executor", 205, 6179, 6722);
            CallChecker.varInit(this.database_connection, "database_connection", 205, 6179, 6722);
            CallChecker.varInit(this.user, "user", 205, 6179, 6722);
            CallChecker.varInit(this.unique_result_id, "unique_result_id", 205, 6179, 6722);
            CallChecker.varInit(this.result_set_map, "result_set_map", 205, 6179, 6722);
            CallChecker.varInit(this.database, "database", 205, 6179, 6722);
            AbstractJDBCDatabaseInterface.ResultSetInfo table = CallChecker.init(AbstractJDBCDatabaseInterface.ResultSetInfo.class);
            synchronized(result_set_map) {
                if (CallChecker.beforeDeref(result_set_map, HashMap.class, 209, 6488, 6501)) {
                    result_set_map = CallChecker.beforeCalled(result_set_map, HashMap.class, 209, 6488, 6501);
                    table = ((AbstractJDBCDatabaseInterface.ResultSetInfo) (CallChecker.isCalled(result_set_map, HashMap.class, 209, 6488, 6501).remove(new Integer(result_id))));
                    CallChecker.varAssign(table, "table", 209, 6464, 6533);
                }
            }
            if (table != null) {
                table.dispose();
            }else {
                final DebugLogger npe_invocation_var23 = Debug();
                if (CallChecker.beforeDeref(npe_invocation_var23, DebugLogger.class, 215, 6618, 6624)) {
                    CallChecker.isCalled(npe_invocation_var23, DebugLogger.class, 215, 6618, 6624).write(Lvl.ERROR, this, "Attempt to dispose invalid 'result_id'.");
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context55.methodEnd();
        }
    }

    protected final void clearResultSetMap() {
        MethodContext _bcornu_methode_context56 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 224, 6729, 7296);
            CallChecker.varInit(this.disposed, "disposed", 224, 6729, 7296);
            CallChecker.varInit(this.sql_executor, "sql_executor", 224, 6729, 7296);
            CallChecker.varInit(this.database_connection, "database_connection", 224, 6729, 7296);
            CallChecker.varInit(this.user, "user", 224, 6729, 7296);
            CallChecker.varInit(this.unique_result_id, "unique_result_id", 224, 6729, 7296);
            CallChecker.varInit(this.result_set_map, "result_set_map", 224, 6729, 7296);
            CallChecker.varInit(this.database, "database", 224, 6729, 7296);
            Iterator keys = CallChecker.init(Iterator.class);
            ArrayList list = CallChecker.init(ArrayList.class);
            synchronized(result_set_map) {
                if (CallChecker.beforeDeref(result_set_map, HashMap.class, 228, 6981, 6994)) {
                    result_set_map = CallChecker.beforeCalled(result_set_map, HashMap.class, 228, 6981, 6994);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(result_set_map, HashMap.class, 228, 6981, 6994).keySet(), Set.class, 228, 6981, 7003)) {
                        result_set_map = CallChecker.beforeCalled(result_set_map, HashMap.class, 228, 6981, 6994);
                        keys = CallChecker.isCalled(CallChecker.isCalled(result_set_map, HashMap.class, 228, 6981, 6994).keySet(), Set.class, 228, 6981, 7003).iterator();
                        CallChecker.varAssign(keys, "keys", 228, 6974, 7015);
                    }
                }
                list = new ArrayList();
                CallChecker.varAssign(list, "list", 230, 7026, 7048);
                keys = CallChecker.beforeCalled(keys, Iterator.class, 231, 7064, 7067);
                while (CallChecker.isCalled(keys, Iterator.class, 231, 7064, 7067).hasNext()) {
                    if (CallChecker.beforeDeref(keys, Iterator.class, 232, 7100, 7103)) {
                        if (CallChecker.beforeDeref(list, ArrayList.class, 232, 7091, 7094)) {
                            keys = CallChecker.beforeCalled(keys, Iterator.class, 232, 7100, 7103);
                            list = CallChecker.beforeCalled(list, ArrayList.class, 232, 7091, 7094);
                            CallChecker.isCalled(list, ArrayList.class, 232, 7091, 7094).add(CallChecker.isCalled(keys, Iterator.class, 232, 7100, 7103).next());
                        }
                    }
                } 
            }
            if (CallChecker.beforeDeref(list, ArrayList.class, 235, 7142, 7145)) {
                list = CallChecker.beforeCalled(list, ArrayList.class, 235, 7142, 7145);
                keys = CallChecker.isCalled(list, ArrayList.class, 235, 7142, 7145).iterator();
                CallChecker.varAssign(keys, "keys", 235, 7135, 7157);
            }
            keys = CallChecker.beforeCalled(keys, Iterator.class, 237, 7173, 7176);
            while (CallChecker.isCalled(keys, Iterator.class, 237, 7173, 7176).hasNext()) {
                int result_id = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(keys, Iterator.class, 238, 7225, 7228)) {
                    keys = CallChecker.beforeCalled(keys, Iterator.class, 238, 7225, 7228);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(keys, Iterator.class, 238, 7225, 7228).next(), Object.class, 238, 7225, 7235)) {
                        keys = CallChecker.beforeCalled(keys, Iterator.class, 238, 7225, 7228);
                        result_id = CallChecker.isCalled(((Integer) (CallChecker.isCalled(keys, Iterator.class, 238, 7225, 7228).next())), Integer.class, 238, 7225, 7235).intValue();
                        CallChecker.varAssign(result_id, "result_id", 238, 7225, 7228);
                    }
                }
                disposeResultSet(result_id);
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context56.methodEnd();
        }
    }

    protected final SQLException handleExecuteThrowable(Throwable e, SQLQuery query) {
        MethodContext _bcornu_methode_context57 = new MethodContext(SQLException.class);
        try {
            CallChecker.varInit(this, "this", 248, 7303, 8784);
            CallChecker.varInit(query, "query", 248, 7303, 8784);
            CallChecker.varInit(e, "e", 248, 7303, 8784);
            CallChecker.varInit(this.disposed, "disposed", 248, 7303, 8784);
            CallChecker.varInit(this.sql_executor, "sql_executor", 248, 7303, 8784);
            CallChecker.varInit(this.database_connection, "database_connection", 248, 7303, 8784);
            CallChecker.varInit(this.user, "user", 248, 7303, 8784);
            CallChecker.varInit(this.unique_result_id, "unique_result_id", 248, 7303, 8784);
            CallChecker.varInit(this.result_set_map, "result_set_map", 248, 7303, 8784);
            CallChecker.varInit(this.database, "database", 248, 7303, 8784);
            if (e instanceof ParseException) {
                final DebugLogger npe_invocation_var24 = Debug();
                if (CallChecker.beforeDeref(npe_invocation_var24, DebugLogger.class, 252, 7676, 7682)) {
                    CallChecker.isCalled(npe_invocation_var24, DebugLogger.class, 252, 7676, 7682).writeException(Lvl.WARNING, e);
                }
                String msg = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(e, Throwable.class, 255, 7786, 7786)) {
                    e = CallChecker.beforeCalled(e, Throwable.class, 255, 7786, 7786);
                    msg = CallChecker.isCalled(e, Throwable.class, 255, 7786, 7786).getMessage();
                    CallChecker.varAssign(msg, "msg", 255, 7786, 7786);
                }
                msg = StringUtil.searchAndReplace(msg, "\r", "");
                CallChecker.varAssign(msg, "msg", 256, 7809, 7857);
                return new MSQLException(msg, msg, 35, e);
            }else
                if (e instanceof com.mckoi.database.TransactionException) {
                    com.mckoi.database.TransactionException te = CallChecker.varInit(((com.mckoi.database.TransactionException) (e)), "te", 262, 7978, 8028);
                    final DebugLogger npe_invocation_var25 = Debug();
                    if (CallChecker.beforeDeref(npe_invocation_var25, DebugLogger.class, 265, 8094, 8100)) {
                        CallChecker.isCalled(npe_invocation_var25, DebugLogger.class, 265, 8094, 8100).write(Lvl.INFORMATION, this, ("Transaction error on: " + query));
                    }
                    final DebugLogger npe_invocation_var26 = Debug();
                    if (CallChecker.beforeDeref(npe_invocation_var26, DebugLogger.class, 267, 8192, 8198)) {
                        CallChecker.isCalled(npe_invocation_var26, DebugLogger.class, 267, 8192, 8198).writeException(Lvl.INFORMATION, e);
                    }
                    if (CallChecker.beforeDeref(e, Throwable.class, 270, 8313, 8313)) {
                        if (CallChecker.beforeDeref(e, Throwable.class, 270, 8329, 8329)) {
                            e = CallChecker.beforeCalled(e, Throwable.class, 270, 8313, 8313);
                            e = CallChecker.beforeCalled(e, Throwable.class, 270, 8329, 8329);
                            te = CallChecker.beforeCalled(te, com.mckoi.database.TransactionException.class, 271, 8383, 8384);
                            return new MSQLException(CallChecker.isCalled(e, Throwable.class, 270, 8313, 8313).getMessage(), CallChecker.isCalled(e, Throwable.class, 270, 8329, 8329).getMessage(), (200 + (CallChecker.isCalled(te, com.mckoi.database.TransactionException.class, 271, 8383, 8384).getType())), e);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else {
                    final DebugLogger npe_invocation_var27 = Debug();
                    if (CallChecker.beforeDeref(npe_invocation_var27, DebugLogger.class, 276, 8484, 8490)) {
                        CallChecker.isCalled(npe_invocation_var27, DebugLogger.class, 276, 8484, 8490).write(Lvl.WARNING, this, ("Exception thrown during query processing on: " + query));
                    }
                    final DebugLogger npe_invocation_var28 = Debug();
                    if (CallChecker.beforeDeref(npe_invocation_var28, DebugLogger.class, 278, 8601, 8607)) {
                        CallChecker.isCalled(npe_invocation_var28, DebugLogger.class, 278, 8601, 8607).writeException(Lvl.WARNING, e);
                    }
                    if (CallChecker.beforeDeref(e, Throwable.class, 281, 8731, 8731)) {
                        if (CallChecker.beforeDeref(e, Throwable.class, 281, 8747, 8747)) {
                            e = CallChecker.beforeCalled(e, Throwable.class, 281, 8731, 8731);
                            e = CallChecker.beforeCalled(e, Throwable.class, 281, 8747, 8747);
                            return new MSQLException(CallChecker.isCalled(e, Throwable.class, 281, 8731, 8731).getMessage(), CallChecker.isCalled(e, Throwable.class, 281, 8747, 8747).getMessage(), 1, e);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((SQLException) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context57.methodEnd();
        }
    }

    protected final void internalDispose() {
        MethodContext _bcornu_methode_context58 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 293, 8791, 9277);
            CallChecker.varInit(this.disposed, "disposed", 293, 8791, 9277);
            CallChecker.varInit(this.sql_executor, "sql_executor", 293, 8791, 9277);
            CallChecker.varInit(this.database_connection, "database_connection", 293, 8791, 9277);
            CallChecker.varInit(this.user, "user", 293, 8791, 9277);
            CallChecker.varInit(this.unique_result_id, "unique_result_id", 293, 8791, 9277);
            CallChecker.varInit(this.result_set_map, "result_set_map", 293, 8791, 9277);
            CallChecker.varInit(this.database, "database", 293, 8791, 9277);
            disposed = true;
            CallChecker.varAssign(this.disposed, "this.disposed", 294, 9098, 9113);
            clearResultSetMap();
            if (CallChecker.beforeDeref(user, User.class, 297, 9183, 9186)) {
                user = CallChecker.beforeCalled(user, User.class, 297, 9183, 9186);
                CallChecker.isCalled(user, User.class, 297, 9183, 9186).close();
            }
            user = null;
            CallChecker.varAssign(this.user, "this.user", 298, 9202, 9213);
            database_connection = null;
            CallChecker.varAssign(this.database_connection, "this.database_connection", 299, 9220, 9246);
            sql_executor = null;
            CallChecker.varAssign(this.sql_executor, "this.sql_executor", 300, 9253, 9272);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context58.methodEnd();
        }
    }

    public QueryResponse execQuery(SQLQuery query) throws SQLException {
        MethodContext _bcornu_methode_context59 = new MethodContext(QueryResponse.class);
        try {
            CallChecker.varInit(this, "this", 306, 9284, 15082);
            CallChecker.varInit(query, "query", 306, 9284, 15082);
            CallChecker.varInit(this.disposed, "disposed", 306, 9284, 15082);
            CallChecker.varInit(this.sql_executor, "sql_executor", 306, 9284, 15082);
            CallChecker.varInit(this.database_connection, "database_connection", 306, 9284, 15082);
            CallChecker.varInit(this.user, "user", 306, 9284, 15082);
            CallChecker.varInit(this.unique_result_id, "unique_result_id", 306, 9284, 15082);
            CallChecker.varInit(this.result_set_map, "result_set_map", 306, 9284, 15082);
            CallChecker.varInit(this.database, "database", 306, 9284, 15082);
            if (disposed) {
                throw new RuntimeException("Interface is disposed.");
            }
            long start_time = CallChecker.varInit(((long) (System.currentTimeMillis())), "start_time", 313, 9554, 9598);
            AbstractJDBCDatabaseInterface.ResultSetInfo result_set_info = CallChecker.init(AbstractJDBCDatabaseInterface.ResultSetInfo.class);
            int result_id = CallChecker.varInit(((int) (-1)), "result_id", 316, 9688, 9706);
            TryContext _bcornu_try_context_16 = new TryContext(16, AbstractJDBCDatabaseInterface.class, "java.lang.Throwable");
            try {
                Table result = CallChecker.init(Table.class);
                if (CallChecker.beforeDeref(sql_executor, SQLQueryExecutor.class, 396, 12508, 12519)) {
                    sql_executor = CallChecker.beforeCalled(sql_executor, SQLQueryExecutor.class, 396, 12508, 12519);
                    result = CallChecker.isCalled(sql_executor, SQLQueryExecutor.class, 396, 12508, 12519).execute(database_connection, query);
                    CallChecker.varAssign(result, "result", 396, 12508, 12519);
                }
                result_set_info = new AbstractJDBCDatabaseInterface.ResultSetInfo(query, result);
                CallChecker.varAssign(result_set_info, "result_set_info", 403, 12894, 12944);
                result_id = addResultSet(result_set_info);
                CallChecker.varAssign(result_id, "result_id", 404, 12953, 12994);
            } catch (Throwable e) {
                _bcornu_try_context_16.catchStart(16);
                if (result_id != (-1)) {
                    disposeResultSet(result_id);
                }
                throw handleExecuteThrowable(e, query);
            } finally {
                _bcornu_try_context_16.finallyStart(16);
            }
            long taken = CallChecker.varInit(((long) ((System.currentTimeMillis()) - start_time)), "taken", 465, 14908, 14960);
            return new AbstractJDBCDatabaseInterface.JDIQueryResponse(result_id, result_set_info, ((int) (taken)), "");
        } catch (ForceReturn _bcornu_return_t) {
            return ((QueryResponse) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context59.methodEnd();
        }
    }

    public ResultPart getResultPart(int result_id, int row_number, int row_count) throws SQLException {
        MethodContext _bcornu_methode_context60 = new MethodContext(ResultPart.class);
        try {
            CallChecker.varInit(this, "this", 473, 15091, 16463);
            CallChecker.varInit(row_count, "row_count", 473, 15091, 16463);
            CallChecker.varInit(row_number, "row_number", 473, 15091, 16463);
            CallChecker.varInit(result_id, "result_id", 473, 15091, 16463);
            CallChecker.varInit(this.disposed, "disposed", 473, 15091, 16463);
            CallChecker.varInit(this.sql_executor, "sql_executor", 473, 15091, 16463);
            CallChecker.varInit(this.database_connection, "database_connection", 473, 15091, 16463);
            CallChecker.varInit(this.user, "user", 473, 15091, 16463);
            CallChecker.varInit(this.unique_result_id, "unique_result_id", 473, 15091, 16463);
            CallChecker.varInit(this.result_set_map, "result_set_map", 473, 15091, 16463);
            CallChecker.varInit(this.database, "database", 473, 15091, 16463);
            if (disposed) {
                throw new RuntimeException("Interface is disposed.");
            }
            AbstractJDBCDatabaseInterface.ResultSetInfo table = CallChecker.varInit(getResultSet(result_id), "table", 479, 15322, 15367);
            if (table == null) {
                throw new MSQLException("'result_id' invalid.", null, 4, ((Throwable) (null)));
            }
            int row_end = CallChecker.varInit(((int) (row_number + row_count)), "row_end", 485, 15523, 15559);
            if (((row_number < 0) || (row_number >= (table.getRowCount()))) || (row_end > (table.getRowCount()))) {
                throw new MSQLException("Result part out of range.", null, 4, ((Throwable) (null)));
            }
            TryContext _bcornu_try_context_17 = new TryContext(17, AbstractJDBCDatabaseInterface.class, "java.lang.Throwable");
            try {
                int col_count = CallChecker.varInit(((int) (table.getColumnCount())), "col_count", 494, 15815, 15853);
                ResultPart block = CallChecker.varInit(new ResultPart((row_count * col_count)), "block", 495, 15862, 15918);
                for (int r = row_number; r < row_end; ++r) {
                    for (int c = 0; c < col_count; ++c) {
                        table = CallChecker.beforeCalled(table, AbstractJDBCDatabaseInterface.ResultSetInfo.class, 498, 16047, 16051);
                        final DataCell npe_invocation_var29 = CallChecker.isCalled(table, AbstractJDBCDatabaseInterface.ResultSetInfo.class, 498, 16047, 16051).getCellContents(c, r);
                        if (CallChecker.beforeDeref(npe_invocation_var29, DataCell.class, 498, 16047, 16073)) {
                            if (CallChecker.beforeDeref(block, ResultPart.class, 498, 16030, 16034)) {
                                block = CallChecker.beforeCalled(block, ResultPart.class, 498, 16030, 16034);
                                CallChecker.isCalled(block, ResultPart.class, 498, 16030, 16034).addElement(CallChecker.isCalled(npe_invocation_var29, DataCell.class, 498, 16047, 16073).getCell());
                            }
                        }
                    }
                }
                return block;
            } catch (Throwable e) {
                _bcornu_try_context_17.catchStart(17);
                final DebugLogger npe_invocation_var30 = Debug();
                if (CallChecker.beforeDeref(npe_invocation_var30, DebugLogger.class, 504, 16169, 16175)) {
                    CallChecker.isCalled(npe_invocation_var30, DebugLogger.class, 504, 16169, 16175).writeException(Lvl.WARNING, e);
                }
                throw new MSQLException(("Exception while reading results: " + (e.getMessage())), e.getMessage(), 4, e);
            } finally {
                _bcornu_try_context_17.finallyStart(17);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((ResultPart) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context60.methodEnd();
        }
    }

    public void disposeResult(int result_id) throws SQLException {
        MethodContext _bcornu_methode_context61 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 515, 16472, 16663);
            CallChecker.varInit(result_id, "result_id", 515, 16472, 16663);
            CallChecker.varInit(this.disposed, "disposed", 515, 16472, 16663);
            CallChecker.varInit(this.sql_executor, "sql_executor", 515, 16472, 16663);
            CallChecker.varInit(this.database_connection, "database_connection", 515, 16472, 16663);
            CallChecker.varInit(this.user, "user", 515, 16472, 16663);
            CallChecker.varInit(this.unique_result_id, "unique_result_id", 515, 16472, 16663);
            CallChecker.varInit(this.result_set_map, "result_set_map", 515, 16472, 16663);
            CallChecker.varInit(this.database, "database", 515, 16472, 16663);
            if (disposed) {
                throw new RuntimeException("Interface is disposed.");
            }
            disposeResultSet(result_id);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context61.methodEnd();
        }
    }

    public void finalize() throws Throwable {
        MethodContext _bcornu_methode_context62 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 529, 16672, 16950);
            CallChecker.varInit(this.disposed, "disposed", 529, 16672, 16950);
            CallChecker.varInit(this.sql_executor, "sql_executor", 529, 16672, 16950);
            CallChecker.varInit(this.database_connection, "database_connection", 529, 16672, 16950);
            CallChecker.varInit(this.user, "user", 529, 16672, 16950);
            CallChecker.varInit(this.unique_result_id, "unique_result_id", 529, 16672, 16950);
            CallChecker.varInit(this.result_set_map, "result_set_map", 529, 16672, 16950);
            CallChecker.varInit(this.database, "database", 529, 16672, 16950);
            super.finalize();
            TryContext _bcornu_try_context_18 = new TryContext(18, AbstractJDBCDatabaseInterface.class, "java.lang.Throwable");
            try {
                if (!(disposed)) {
                    dispose();
                }
            } catch (Throwable e) {
                _bcornu_try_context_18.catchStart(18);
            } finally {
                _bcornu_try_context_18.finallyStart(18);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context62.methodEnd();
        }
    }
}

