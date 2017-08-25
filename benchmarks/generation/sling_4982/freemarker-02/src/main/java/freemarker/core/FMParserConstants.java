/* Generated By:JavaCC: Do not edit this line. FMParserConstants.java */
package freemarker.core;

interface FMParserConstants {

  int EOF = 0;
  int BLANK = 1;
  int START_TAG = 2;
  int END_TAG = 3;
  int CLOSE_TAG1 = 4;
  int CLOSE_TAG2 = 5;
  int ATTEMPT = 6;
  int RECOVER = 7;
  int IF = 8;
  int ELSE_IF = 9;
  int LIST = 10;
  int FOREACH = 11;
  int SWITCH = 12;
  int CASE = 13;
  int ASSIGN = 14;
  int GLOBALASSIGN = 15;
  int LOCALASSIGN = 16;
  int INCLUDE = 17;
  int IMPORT = 18;
  int FUNCTION = 19;
  int MACRO = 20;
  int TRANSFORM = 21;
  int VISIT = 22;
  int STOP = 23;
  int RETURN = 24;
  int CALL = 25;
  int SETTING = 26;
  int COMPRESS = 27;
  int COMMENT = 28;
  int TERSE_COMMENT = 29;
  int NOPARSE = 30;
  int END_IF = 31;
  int END_LIST = 32;
  int END_RECOVER = 33;
  int END_FOREACH = 34;
  int END_LOCAL = 35;
  int END_GLOBAL = 36;
  int END_ASSIGN = 37;
  int END_FUNCTION = 38;
  int END_MACRO = 39;
  int END_COMPRESS = 40;
  int END_TRANSFORM = 41;
  int END_SWITCH = 42;
  int ELSE = 43;
  int BREAK = 44;
  int SIMPLE_RETURN = 45;
  int HALT = 46;
  int FLUSH = 47;
  int TRIM = 48;
  int LTRIM = 49;
  int RTRIM = 50;
  int NOTRIM = 51;
  int DEFAUL = 52;
  int SIMPLE_NESTED = 53;
  int NESTED = 54;
  int SIMPLE_RECURSE = 55;
  int RECURSE = 56;
  int FALLBACK = 57;
  int ESCAPE = 58;
  int END_ESCAPE = 59;
  int NOESCAPE = 60;
  int END_NOESCAPE = 61;
  int UNIFIED_CALL = 62;
  int UNIFIED_CALL_END = 63;
  int FTL_HEADER = 64;
  int TRIVIAL_FTL_HEADER = 65;
  int UNKNOWN_DIRECTIVE = 66;
  int WHITESPACE = 67;
  int PRINTABLE_CHARS = 68;
  int FALSE_ALERT = 69;
  int OUTPUT_ESCAPE = 70;
  int NUMERICAL_ESCAPE = 71;
  int ESCAPED_CHAR = 78;
  int STRING_LITERAL = 79;
  int RAW_STRING = 80;
  int FALSE = 81;
  int TRUE = 82;
  int INTEGER = 83;
  int DECIMAL = 84;
  int DOT = 85;
  int DOT_DOT = 86;
  int BUILT_IN = 87;
  int EQUALS = 88;
  int DOUBLE_EQUALS = 89;
  int NOT_EQUALS = 90;
  int LESS_THAN = 91;
  int LESS_THAN_EQUALS = 92;
  int ESCAPED_GT = 93;
  int ESCAPED_GTE = 94;
  int PLUS = 95;
  int MINUS = 96;
  int TIMES = 97;
  int DOUBLE_STAR = 98;
  int ELLIPSIS = 99;
  int DIVIDE = 100;
  int PERCENT = 101;
  int AND = 102;
  int OR = 103;
  int NOT = 104;
  int COMMA = 105;
  int SEMICOLON = 106;
  int COLON = 107;
  int OPEN_BRACKET = 108;
  int CLOSE_BRACKET = 109;
  int OPEN_PAREN = 110;
  int CLOSE_PAREN = 111;
  int OPEN_BRACE = 112;
  int CLOSE_BRACE = 113;
  int IN = 114;
  int AS = 115;
  int USING = 116;
  int ID = 117;
  int LETTER = 118;
  int DIGIT = 119;
  int DIRECTIVE_END = 120;
  int EMPTY_DIRECTIVE_END = 121;
  int NATURAL_GT = 122;
  int NATURAL_GTE = 123;
  int TERMINATING_WHITESPACE = 124;
  int TERSE_COMMENT_END = 125;
  int MAYBE_END = 126;
  int KEEP_GOING = 127;
  int LONE_LESS_THAN_OR_DASH = 128;

  int DEFAULT = 0;
  int NODIRECTIVE = 1;
  int FM_EXPRESSION = 2;
  int IN_PAREN = 3;
  int EXPRESSION_COMMENT = 4;
  int NO_SPACE_EXPRESSION = 5;
  int NO_PARSE = 6;

  String[] tokenImage = {
    "<EOF>",
    "<BLANK>",
    "<START_TAG>",
    "<END_TAG>",
    "<CLOSE_TAG1>",
    "<CLOSE_TAG2>",
    "<ATTEMPT>",
    "<RECOVER>",
    "<IF>",
    "<ELSE_IF>",
    "<LIST>",
    "<FOREACH>",
    "<SWITCH>",
    "<CASE>",
    "<ASSIGN>",
    "<GLOBALASSIGN>",
    "<LOCALASSIGN>",
    "<INCLUDE>",
    "<IMPORT>",
    "<FUNCTION>",
    "<MACRO>",
    "<TRANSFORM>",
    "<VISIT>",
    "<STOP>",
    "<RETURN>",
    "<CALL>",
    "<SETTING>",
    "<COMPRESS>",
    "<COMMENT>",
    "\"<#--\"",
    "<NOPARSE>",
    "<END_IF>",
    "<END_LIST>",
    "<END_RECOVER>",
    "<END_FOREACH>",
    "<END_LOCAL>",
    "<END_GLOBAL>",
    "<END_ASSIGN>",
    "<END_FUNCTION>",
    "<END_MACRO>",
    "<END_COMPRESS>",
    "<END_TRANSFORM>",
    "<END_SWITCH>",
    "<ELSE>",
    "<BREAK>",
    "<SIMPLE_RETURN>",
    "<HALT>",
    "<FLUSH>",
    "<TRIM>",
    "<LTRIM>",
    "<RTRIM>",
    "<NOTRIM>",
    "<DEFAUL>",
    "<SIMPLE_NESTED>",
    "<NESTED>",
    "<SIMPLE_RECURSE>",
    "<RECURSE>",
    "<FALLBACK>",
    "<ESCAPE>",
    "<END_ESCAPE>",
    "<NOESCAPE>",
    "<END_NOESCAPE>",
    "\"<@\"",
    "<UNIFIED_CALL_END>",
    "<FTL_HEADER>",
    "<TRIVIAL_FTL_HEADER>",
    "<UNKNOWN_DIRECTIVE>",
    "<WHITESPACE>",
    "<PRINTABLE_CHARS>",
    "<FALSE_ALERT>",
    "\"${\"",
    "\"#{\"",
    "<token of kind 72>",
    "<token of kind 73>",
    "<token of kind 74>",
    "\">\"",
    "\"-\"",
    "\"-->\"",
    "<ESCAPED_CHAR>",
    "<STRING_LITERAL>",
    "<RAW_STRING>",
    "\"false\"",
    "\"true\"",
    "<INTEGER>",
    "<DECIMAL>",
    "\".\"",
    "\"..\"",
    "\"?\"",
    "\"=\"",
    "\"==\"",
    "\"!=\"",
    "<LESS_THAN>",
    "<LESS_THAN_EQUALS>",
    "<ESCAPED_GT>",
    "<ESCAPED_GTE>",
    "\"+\"",
    "\"-\"",
    "\"*\"",
    "\"**\"",
    "\"...\"",
    "\"/\"",
    "\"%\"",
    "<AND>",
    "<OR>",
    "\"!\"",
    "\",\"",
    "\";\"",
    "\":\"",
    "\"[\"",
    "\"]\"",
    "\"(\"",
    "\")\"",
    "\"{\"",
    "\"}\"",
    "\"in\"",
    "\"as\"",
    "\"using\"",
    "<ID>",
    "<LETTER>",
    "<DIGIT>",
    "\">\"",
    "\"/>\"",
    "\">\"",
    "\">=\"",
    "<TERMINATING_WHITESPACE>",
    "\"-->\"",
    "<MAYBE_END>",
    "<KEEP_GOING>",
    "<LONE_LESS_THAN_OR_DASH>",
  };

}