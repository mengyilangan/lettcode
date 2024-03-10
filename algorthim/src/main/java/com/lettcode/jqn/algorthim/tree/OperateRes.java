package com.lettcode.jqn.algorthim.tree;

public class OperateRes {
    public boolean finalRes;

    public boolean currentRes;

    public static OperateRes currentOperate() {
        OperateRes operateRes = new OperateRes();
        operateRes.currentRes = true;
        operateRes.finalRes = true;
        return operateRes;
    }

    public void childOperate() {
        currentRes = false;
    }
}
