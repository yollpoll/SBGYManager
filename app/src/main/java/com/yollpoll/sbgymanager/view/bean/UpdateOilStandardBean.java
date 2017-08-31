package com.yollpoll.sbgymanager.view.bean;

import com.avos.avoscloud.AVObject;
import com.yollpoll.sbgymanager.base.BaseBean;

/**
 * Created by 鹏祺 on 2017/8/18.
 */

public class UpdateOilStandardBean extends BaseBean {
    private String mass;
    private String updateCycle;

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getUpdateCycle() {
        return updateCycle;
    }

    public void setUpdateCycle(String updateCycle) {
        this.updateCycle = updateCycle;
    }

    public static UpdateOilStandardBean getBean(AVObject avObject) {
        UpdateOilStandardBean bean = new UpdateOilStandardBean();
        bean.setMass(avObject.getString("oilMass"));
        bean.setUpdateCycle(avObject.getString("changeCycle"));
        return bean;
    }
}
