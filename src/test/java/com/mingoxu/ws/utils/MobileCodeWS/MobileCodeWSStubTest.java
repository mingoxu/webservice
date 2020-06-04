package com.mingoxu.ws.utils.MobileCodeWS;

import com.mingoxu.ws.utils.PropertiesUtil;
import org.junit.Test;

public class MobileCodeWSStubTest {
    private final String url = PropertiesUtil.getInstance().getProperty("wsdl_url");
    private final String phoneNumber = PropertiesUtil.getInstance().getProperty("phone_number");

    @Test
    public void getMobileCodeInfo() throws Exception {
        MobileCodeWSStub mobileCodeWSStub = new MobileCodeWSStub(url);
        MobileCodeWSStub.GetMobileCodeInfo getMobileCodeInfo = new MobileCodeWSStub.GetMobileCodeInfo();
        getMobileCodeInfo.setMobileCode(phoneNumber);
        getMobileCodeInfo.setUserID(null);
        MobileCodeWSStub.GetMobileCodeInfoResponse response =mobileCodeWSStub.getMobileCodeInfo(getMobileCodeInfo);
        System.out.println(response.getGetMobileCodeInfoResult());
    }

    @Test
    public void startgetMobileCodeInfo() {
    }

    @Test
    public void getDatabaseInfo() {
    }

    @Test
    public void startgetDatabaseInfo() {
    }
}