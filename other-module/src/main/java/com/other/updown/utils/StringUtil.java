package com.other.updown.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhangbingquan
 * @desc 字符串工具类
 * @time 2019-09-24 23:33
 */
public class StringUtil {
    public StringUtil() {
    }

    public static boolean isNull(String str) {
        return str == null || str.trim().equals("") || str.equals("-1");
    }

    public static boolean isNotNull(String str) {
        return !isNull(str);
    }

    public static boolean isObjectNull(Object obj) {
        if (obj == null) {
            return true;
        } else {
            String str = obj.toString().trim();
            return "".equals(str) || "null".equalsIgnoreCase(str) || "\"null\"".equalsIgnoreCase(str) || "'null'".equalsIgnoreCase(str);
        }
    }

    public static boolean isObjectNotNull(Object obj) {
        return !isObjectNull(obj);
    }

    public static String nvl(String str, String def) {
        return isNull(str) ? def : str;
    }

    public static String traceSql(String sql, String... strings) {
        for(int i = 0; i < strings.length; ++i) {
            if (strings[i] == null) {
                sql = sql.replaceFirst("\\?", "NULL");
            } else {
                String replacement = strings[i].toString();
                replacement = replacement.replaceAll("\\$", "RDS_CHAR_DOLLAR");
                sql = sql.replaceFirst("\\?", replacement);
                sql = sql.replaceAll("RDS_CHAR_DOLLAR", "\\$");
            }
        }

        return sql;
    }

    public static String traceSql(String sql, Object... strings) {
        for(int i = 0; i < strings.length; ++i) {
            if (strings[i] == null) {
                sql = sql.replaceFirst("\\?", "NULL");
            } else {
                String replacement = strings[i].toString();
                replacement = replacement.replaceAll("\\$", "RDS_CHAR_DOLLAR");
                sql = sql.replaceFirst("\\?", replacement);
                sql = sql.replaceAll("RDS_CHAR_DOLLAR", "\\$");
            }
        }

        return sql;
    }

    public static String join(String... strings) {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < strings.length; ++i) {
            if (!isNull(strings[i])) {
                sb.append(strings[i]).append(":");
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static String copyString(int len, String str) {
        String fStr = "";

        for(int i = 0; i < len; ++i) {
            fStr = fStr + str;
        }

        return fStr;
    }

    public static String toString(Object obj) {
        return obj == null ? "" : trim(obj.toString());
    }

    public static String toString(Object obj, String defaultValue) {
        return isObjectNull(obj) ? defaultValue : obj.toString();
    }

    public static String trim(String str, String forNull) {
        return str == null ? forNull : str.trim();
    }

    public static String trim(String str) {
        return trim(str, "");
    }

    public static Map<String, Object> trimNull(Map<String, Object> map) {
        Iterator it = map.entrySet().iterator();

        while(it.hasNext()) {
            Map.Entry<String, Object> entry = (Map.Entry)it.next();
            if (entry.getValue() == null) {
                it.remove();
            }
        }

        return map;
    }

    public static List<Map<String, Object>> trimNull(List<Map<String, Object>> list) {
        Iterator var1 = list.iterator();

        while(var1.hasNext()) {
            Map<String, Object> map = (Map)var1.next();
            trimNull(map);
        }

        return list;
    }

    public static String format(long number, int length) {
        return String.format("%0" + length + "d", number);
    }

    public static String remove00(String str) {
        char[] charArray = str.toCharArray();
        int index = -1;

        for(int i = charArray.length - 1; i > 0; i -= 2) {
            if (charArray[i] != '0' || charArray[i - 1] != '0') {
                index = i;
                break;
            }
        }

        return index < 0 ? "" : String.valueOf(charArray, 0, index + 1);
    }

    public static boolean isEmpty(String input) {
        boolean isEmpty = true;
        if (input != null) {
            for(int i = 0; i < input.length(); ++i) {
                char c = input.charAt(i);
                if (c != ' ' && c != '\r' && c != '\n') {
                    return false;
                }
            }
        }

        return isEmpty;
    }

    public static boolean isNotEmpty(String input) {
        return !isEmpty(input);
    }

    public static boolean isInteger(String str) {
        String pattern = "^-?\\d+$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);
        return m.find();
    }

    public static boolean isFloat(String str) {
        String pattern = "^(-?\\d+)(\\.\\d+)?$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);
        return m.find();
    }

    public static boolean isValidate(String str) {
        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\]<>/\\\\?]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }

    public static boolean isIP(String str) {
        String[] arr = str.split("\\.");
        if (arr.length != 4) {
            return false;
        } else {
            for(int i = 0; i < arr.length; ++i) {
                try {
                    int num = Integer.parseInt(arr[i]);
                    if (num < 0 || num > 255) {
                        return false;
                    }
                } catch (NumberFormatException var4) {
                    return false;
                }
            }

            return true;
        }
    }

    public static int nullToZero(Object o) {
        if (o == null) {
            return 0;
        } else {
            int i = 0;

            try {
                i = Integer.valueOf(Integer.parseInt(o.toString()));
            } catch (Exception var3) {
            }

            return i;
        }
    }

    public static String getBASE64(String s) {
        return s == null ? "" : (new BASE64Encoder()).encode(s.getBytes());
    }

    public static String getFormBASE64(String s) {
        if (s == null) {
            return "";
        } else {
            BASE64Decoder decoder = new BASE64Decoder();

            try {
                byte[] b = decoder.decodeBuffer(s);
                return new String(b);
            } catch (Exception var3) {
                return "";
            }
        }
    }

    public static String time2CronExpression(String timeStr) {
        String cronExpression = "";
        String[] time = timeStr.split(":");

        for(int i = time.length - 1; i >= 0; --i) {
            cronExpression = cronExpression + Integer.valueOf(time[i].trim()) + " ";
        }

        return cronExpression + " * * ?";
    }

    public static String getNext2DigitCode(String curCode) {
        char[] codeChar = curCode.toCharArray();
        int firstCode = codeChar[0];
        int secondCode = codeChar[1];
        if (secondCode + 1 > 57 && secondCode < 'A') {
            secondCode = 65;
        } else if (secondCode + 1 > 90) {
            secondCode = 48;
            ++firstCode;
        } else {
            secondCode = secondCode + 1;
        }

        if (firstCode > 57 && firstCode < 65) {
            firstCode = 65;
        } else if (firstCode > 90) {
            firstCode = 48;
        }

        byte[] asicllBtye = new byte[]{(byte)firstCode, (byte)secondCode};
        return new String(asicllBtye);
    }

    public static String getNext4DigitCode(String curCode) {
        char[] codeChar = curCode.toCharArray();
        int firstCode = codeChar[0];
        int secondCode = codeChar[1];
        int thirdCode = codeChar[2];
        int lastCode = codeChar[3];
        if (lastCode + 1 > 57 && lastCode < 'A') {
            lastCode = 65;
        } else if (lastCode + 1 > 90) {
            lastCode = 48;
            ++thirdCode;
        } else {
            lastCode = lastCode + 1;
        }

        if (thirdCode + 1 > 57 && thirdCode < 65) {
            thirdCode = 65;
        } else if (thirdCode + 1 > 90) {
            thirdCode = 48;
            ++secondCode;
        }

        if (secondCode + 1 > 57 && secondCode < 65) {
            secondCode = 65;
        } else if (secondCode + 1 > 90) {
            secondCode = 48;
            ++firstCode;
        }

        if (firstCode > 57 && firstCode < 65) {
            firstCode = 65;
        } else if (firstCode > 90) {
            firstCode = 48;
        }

        byte[] asicllBtye = new byte[]{(byte)firstCode, (byte)secondCode, (byte)thirdCode, (byte)lastCode};
        return new String(asicllBtye);
    }

    public static String escapeEsSpecial(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '\\' || c == '+' || c == '-' || c == '!' || c == '(' || c == ')' || c == '^' || c == '[' || c == ']' || c == '"' || c == '{' || c == '}' || c == '~' || c == '|' || c == '&' || c == '/') {
                sb.append('\\');
            }

            sb.append(c);
        }

        return sb.toString();
    }

    public static int toInteger(Object obj, int defaultValue) {
        try {
            return Integer.parseInt(toString(obj, ""));
        } catch (Exception var3) {
            return defaultValue;
        }
    }

    public static long toLong(Object obj, long defaultValue) {
        try {
            return Long.parseLong(toString(obj, ""));
        } catch (Exception var4) {
            return defaultValue;
        }
    }

    public static double toDouble(Object obj, double defaultValue) {
        try {
            return Double.parseDouble(toString(obj, ""));
        } catch (Exception var4) {
            return defaultValue;
        }
    }

    public static float toFloat(Object obj, float defaultValue) {
        try {
            return Float.parseFloat(toString(obj, ""));
        } catch (Exception var3) {
            return defaultValue;
        }
    }
}
