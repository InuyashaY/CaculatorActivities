package yzl.swu.caculatoractivities;

import java.io.Serializable;

public class CaculatorModel implements Serializable {
    Integer param1;
    Integer param2;
    String caculatortype;

    public Integer getParam1() {
        return param1;
    }

    public void setParam1(Integer param1) {
        this.param1 = param1;
    }

    public Integer getParam2() {
        return param2;
    }

    public void setParam2(Integer param2) {
        this.param2 = param2;
    }

    public String getCaculatortype() {
        return caculatortype;
    }

    public void setCaculatortype(String caculatortype) {
        this.caculatortype = caculatortype;
    }
}
