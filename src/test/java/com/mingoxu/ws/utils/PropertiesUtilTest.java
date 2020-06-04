package com.mingoxu.ws.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class PropertiesUtilTest {

    @Test
    public void getInstance() {
        String url = PropertiesUtil.getInstance().getProperty("wsdl_url");
        System.out.println(url);
    }

    @Test
    public void say() {
    }
}