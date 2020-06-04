package com.mingoxu.ws.webservice.impl;

import com.mingoxu.ws.entity.request.Calc;
import com.mingoxu.ws.entity.response.Result;
import com.mingoxu.ws.utils.Constants;
import com.mingoxu.ws.webservice.CalcService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import javax.jws.WebService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 简单的计算器WebService
 */
@WebService(endpointInterface = "com.mingoxu.ws.webservice.CalcService",serviceName = "CalcService")
public class CalcServiceImpl implements CalcService {
    private Logger logger = Logger.getLogger(CalcService.class);

    private Integer num1;
    private Integer num2;

    @Override
    public String doArithmetic(Calc calc) {
        logger.info("==========开始算数运算==========");
        doChange(calc);
        Result result = doCheck(calc);

        StringBuffer resultXML = new StringBuffer();

        if ("200".equals(result.getStatusCode())) {
            if ("+".equals(calc.getOper())) {
                common(resultXML);
                resultXML.append("<SOULTION>"+add(calc)+"</SOULTION>");
            }else if ("-".equals(calc.getOper())) {
                common(resultXML);
                resultXML.append("<SOULTION>"+sub(calc)+"</SOULTION>");
            }else if ("*".equals(calc.getOper())) {
                common(resultXML);
                resultXML.append("<SOULTION>"+mult(calc)+"</SOULTION>");
            }else {
                String str = divi(calc);
                if (str.contains("#")) {
                    resultXML.append("<STATUSCODE>0</STATUSCODE>");
                    resultXML.append("<MESSAGE>"+str.replace("#","")+"</MESSAGE>");
                }else {
                    common(resultXML);
                    resultXML.append("<SOULTION>"+divi(calc)+"</SOULTION>");
                }
            }
        }else {
            resultXML.append("<STATUSCODE>0</STATUSCODE>");
            resultXML.append("<MESSAGE>"+result.getMsg()+"</MESSAGE>");
        }
        logger.info("==========结束算数运算==========");
        return resultXML.toString();
    }

    private void common(StringBuffer sb) {
        sb.append("<STATUSCODE>200</STATUSCODE>");
        sb.append("<MESSAGE>运算成功</MESSAGE>");
    }

    /**
     * 校验入参
     * @param calc
     * @return
     */
    private Result doCheck(Calc calc) {
        logger.info("==========算数运算校验参数[]: " + calc.toString());
        String msg = "校验成功";

        //算数1校验
        if (StringUtils.isEmpty(calc.getNum1())) {
            return new Result(Constants.RESULT_MASSAGE_PARAM.getValue(),"算数1为空");
        }else {
            if (doCheckNum(calc.getNum2())!=true) {
                return new Result(Constants.RESULT_MASSAGE_PARAM.getValue(),"算数1输入不正确");
            }
        }

        //算数2校验
        if (StringUtils.isEmpty(calc.getNum2())) {
            return new Result(Constants.RESULT_MASSAGE_PARAM.getValue(),"算数2为空");
        }else {
            if (doCheckNum(calc.getNum2())!=true) {
                return new Result(Constants.RESULT_MASSAGE_PARAM.getValue(),"算数2输入不正确");
            }
        }

        //算数操作符校验
        if (StringUtils.isEmpty(calc.getOper())){
            return new Result(Constants.RESULT_MASSAGE_PARAM.getValue(),"算数操作符为空");
        }else {
            if (doCheckOper(calc.getOper())!=true) {
                return new Result(Constants.RESULT_MASSAGE_PARAM.getValue(),"算数操作符输入不正确");
            }
        }

        return new Result(Constants.RESULT_MASSAGE_SUCCESS.getValue(),msg);
    }

    /**
     * 操作符校验
     * @param oper
     * @return
     */
    private boolean doCheckOper(String oper) {
        String reg = "[+\\-*/]";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(oper);
        boolean flag = m.matches();
        return flag;
    }

    /**
     * 算数校验
     * @param num
     * @return
     */
    private boolean doCheckNum(String num) {
        String reg = "([0-9]\\d*\\.?\\d*)|(0\\.\\d*[0-9])";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(num);
        boolean flag = m.matches();
        return flag;
    }

    /**
     * 转换类型并赋值
     * @param calc
     */
    private void doChange(Calc calc) {
        logger.info(">>>>>>>算数转换类型开始：" + calc.toString());
        num1 = Integer.parseInt(calc.getNum1());
        num2 = Integer.parseInt(calc.getNum2());
        logger.info(">>>>>>>算数转换类型结束");
    }

    /**
     * 加法运算
     * @param calc
     * @return
     */
    private String add(Calc calc) {
        logger.info(">>>>>>>执行加法运算：" + calc.toString());
        int result = num1 + num2;
        logger.info(">>>>>>>执行加法运算成功，得数为：" + result);
        return String.valueOf(result);
    }

    /**
     * 减法运算
     * @param calc
     * @return
     */
    private String sub(Calc calc) {
        logger.info(">>>>>>>执行减法运算：" + calc.toString());
        int result = num1 - num2;
        logger.info(">>>>>>>执行减法运算成功，得数为：" + result);
        return  String.valueOf(result);
    }

    /**
     * 乘法运算
     * @param calc
     * @return
     */
    private String mult(Calc calc) {
        logger.info(">>>>>>>执行乘法运算：" + calc.toString());
        int result = num1 * num2;
        logger.info(">>>>>>>执行乘法运算成功，得数为：" + result);
        return String.valueOf(result);
    }

    /**
     * 除法运算
     * @param calc
     * @return
     */
    private String divi(Calc calc) {
        logger.info(">>>>>>>执行除法运算：" + calc.toString());
        if (num2==0) {
            logger.error(">>>>>>>执行除法运算失败，除数不能为0!!!");
            return "#除数不能为0";
        }else {
            double result = num1 * 1.0 / num2;
            logger.info(">>>>>>>执行除法运算成功，得数为：" + result);
            return String.valueOf(result);
        }
    }


}
