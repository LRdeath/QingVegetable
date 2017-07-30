package io.github.vzer.factory.utils;

import java.util.regex.Pattern;

/**
 * @author: Vzer.
 * @date: 2017/7/30. 16:46
 * @email: vzer@qq.com
 */

public class RegexUtil {
    // 手机号的正则,11位手机号
    private static final String REGEX_MOBILE = "[1][3,4,5,7,8][0-9]{9}$";

    //手机号正则
    public static boolean checkMobile(String phone) {
        return Pattern.matches(REGEX_MOBILE, phone);
    }
}
