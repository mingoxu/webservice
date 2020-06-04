package com.mingoxu.ws.utils;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConstantsTest {

    @Test
    public void testConstants() {
        System.out.println(Constants.RESULT_MASSAGE_SUCCESS.getValue());
        System.out.println(Constants.RESULT_MASSAGE_SUCCESS);

        for (Constants c : Constants.values()) {
            System.out.println(c.getValue());
        }
    }

    @Test
    public void testReg() {
        //String reg = "[+\\-*/]";
        String reg = "([0-9]\\d*\\.?\\d*)|(0\\.\\d*[0-9])";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher("0");
        boolean b = m.matches();
        System.out.println(b);
    }
}