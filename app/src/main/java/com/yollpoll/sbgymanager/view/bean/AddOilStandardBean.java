package com.yollpoll.sbgymanager.view.bean;

import com.avos.avoscloud.AVObject;
import com.yollpoll.sbgymanager.base.BaseBean;

/**
 * Created by 鹏祺 on 2017/8/18.
 */

public class AddOilStandardBean extends BaseBean {
    private String oilMass;
    private String addCycle;
    private String checkCycle;

    public String getOilMass() {
        return oilMass;
    }

    public void setOilMass(String oilMass) {
        this.oilMass = oilMass;
    }

    public String getAddCycle() {
        return addCycle;
    }

    public void setAddCycle(String addCycle) {
        this.addCycle = addCycle;
    }

    public String getCheckCycle() {
        return checkCycle;
    }

    public void setCheckCycle(String checkCycle) {
        this.checkCycle = checkCycle;
    }

    public static AddOilStandardBean getBean(AVObject avObject) {
        AddOilStandardBean bean = new AddOilStandardBean();
        bean.setOilMass(avObject.getString("oilMass"));
        bean.setAddCycle(avObject.getString("addCycle"));
        bean.setCheckCycle(avObject.getString("checkCycle"));
        return bean;
    }
}
