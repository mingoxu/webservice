package com.mingoxu.ws.utils.wsutil;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;

import javax.xml.rpc.ParameterMode;

public class WSClientUtil {

    public static Object invoke(String url,String method,Object[] params) throws Exception {
        Service service = new Service();
        Call call = (Call) service.createCall();
        call.setTargetEndpointAddress(url);
        call.setOperationName(method);//WSDL里面描述的接口名称
        call.addParameter("mobileCode", XMLType.XSD_STRING,
                ParameterMode.IN);//接口的参数
        call.addParameter("userID", XMLType.XSD_STRING,
                ParameterMode.IN);//接口的参数
        call.setUseSOAPAction(true);
        call.setSOAPActionURI("http://WebXml.com.cn/getMobileCodeInfo");
        call.setReturnType(XMLType.XSD_STRING);//设置返回类型

        return call.invoke(params);
    }
}
