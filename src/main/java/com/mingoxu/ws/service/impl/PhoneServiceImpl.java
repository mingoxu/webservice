package com.mingoxu.ws.service.impl;

import com.mingoxu.ws.service.PhoneService;
import com.mingoxu.ws.utils.MobileCodeWS.MobileCodeWSStub;
import com.mingoxu.ws.utils.PropertiesUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class PhoneServiceImpl implements PhoneService {
    private Logger logger = Logger.getLogger(PhoneServiceImpl.class);
    private static final String URL = PropertiesUtil.getInstance().getProperty("wsdl_url");

    @Override
    public String doQuery(String phoneNumber) {
        try {
            MobileCodeWSStub stub = new MobileCodeWSStub(URL);
            MobileCodeWSStub.GetMobileCodeInfo getMobileCodeInfo = new MobileCodeWSStub.GetMobileCodeInfo();
            getMobileCodeInfo.setMobileCode(phoneNumber);
            getMobileCodeInfo.setUserID(null);
            MobileCodeWSStub.GetMobileCodeInfoResponse response =stub.getMobileCodeInfo(getMobileCodeInfo);
            return response.getGetMobileCodeInfoResult();
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
