package com.demo.springlocalstack.utils;

import java.beans.JavaBean;

@JavaBean
public class Messages {
    public static String getRequiredMsg(String fieldName) {
        return String.format("%sを入力してくだいさい。", fieldName);
    }
}
