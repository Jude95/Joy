package com.jude.joy.utils;

import com.jude.utils.JUtils;

/**
 * Created by Mr.Jude on 2015/8/24.
 */
public class TextFilter {
    public static String[] FilterStrings = {
            "</p>",
            "<p>",
            "&nbsp;",
            "&lt;/pstyle=\\\"text-indent:2em;text-align:left;\\\"&gt;"
    };

    public static String filter(String original){
        JUtils.Log("index"+original.indexOf(FilterStrings[1]));
        for (String filterString : FilterStrings) {
            original = original.replace(filterString, "");
        }
        return original;
    }
}
