package com.fuyu.common.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class SecurityUtil {
    public static String md5Encode(byte [] input){
        return DigestUtils.md5Hex(input);
    }
}
