package com.mingoxu.ws.utils.wsutil;

import com.mingoxu.ws.utils.PropertiesUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class WSClientUtilTest {
    private final String url = PropertiesUtil.getInstance().getProperty("wsdl_url");
    private final String method = PropertiesUtil.getInstance().getProperty("method");
    private final String phoneNumber = PropertiesUtil.getInstance().getProperty("phone_number");

    @Test
    public void invoke() throws Exception {
        String[] params = {phoneNumber,null};
        String result = (String) WSClientUtil.invoke(url,method,params);
        System.out.println(result);
    }
}