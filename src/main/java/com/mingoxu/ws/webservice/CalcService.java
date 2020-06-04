package com.mingoxu.ws.webservice;

import com.mingoxu.ws.entity.request.Calc;
import com.mingoxu.ws.entity.response.Result;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface CalcService {

    @WebMethod
    public String doArithmetic(Calc calc);
}
