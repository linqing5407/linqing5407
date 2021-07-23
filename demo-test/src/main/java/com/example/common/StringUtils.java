//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.common;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringUtils extends org.apache.commons.lang3.StringUtils {
    private static final Logger logger = LoggerFactory.getLogger(StringUtils.class);

    public StringUtils() {
    }

    public static String lowerFirst(String str) {
        return isBlank(str) ? "" : str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    public static String upperFirst(String str) {
        return isBlank(str) ? "" : str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String replaceHtml(String html) {
        if (isBlank(html)) {
            return "";
        } else {
            String regEx = "<.+?>";
            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(html);
            return matcher.replaceAll("");
        }
    }

    public static Double toDouble(Object val) {
        if (val == null) {
            return 0.0D;
        } else {
            try {
                return Double.valueOf(trim(val.toString()));
            } catch (Exception var2) {
                return 0.0D;
            }
        }
    }

    public static Float toFloat(Object val) {
        return toDouble(val).floatValue();
    }

    public static Long toLong(Object val) {
        return toDouble(val).longValue();
    }

    public static Integer toInteger(Object val) {
        return toLong(val).intValue();
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null ? true : "".equals(str.trim());
    }

    public static boolean isNotEmptyAll(CharSequence... cs) {
        CharSequence[] var1 = cs;
        int var2 = cs.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            CharSequence charSequence = var1[var3];
            if (!isNotEmpty(charSequence)) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkRegex(String regex, String content) {
        return isEmpty(content) ? false : Pattern.compile(regex).matcher(content).matches();
    }

    public static boolean checkLength(String str, int length) {
        int strLength = length(str);
        return length >= strLength;
    }
}
