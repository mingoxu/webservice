package com.mingoxu.ws.entity.request;

public class Calc {
    private String num1;
    private String num2;
    private String oper;

    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    @Override
    public String toString() {
        return "Calc{" +
                "num1='" + num1 + '\'' +
                ", num2='" + num2 + '\'' +
                ", oper='" + oper + '\'' +
                '}';
    }
}
