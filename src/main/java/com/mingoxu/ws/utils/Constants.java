package com.mingoxu.ws.utils;

public enum Constants {
    /**      自定义状态码    **/
    RESULT_MASSAGE_SUCCESS("200"),  //成功
    RESULT_MASSAGE_ERROR("0"),      //失败
    RESULT_MASSAGE_EXCEPTION("-1"), //异常
    RESULT_MASSAGE_EMPTY("201"),    //参数缺失
    RESULT_MASSAGE_PARAM("300"),    //参数错误
    ;

    private String value;

    Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
