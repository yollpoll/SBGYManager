package com.yollpoll.sbgymanager.view.bean;

import com.avos.avoscloud.AVObject;
import com.yollpoll.sbgymanager.base.BaseBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 鹏祺 on 2017/8/18.
 */

public class TaskBean extends BaseBean {
    private String deviceName;
    private String lubricatingPart;
    private String greasePart;
    private String lubricatingPoint;
    private String greaseTool;
    private String lubricatingNumber;
    private AddOilStandardBean addOilStandardBean;
    private UpdateOilStandardBean updateOilStandardBean;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getLubricatingPart() {
        return lubricatingPart;
    }

    public void setLubricatingPart(String lubricatingPart) {
        this.lubricatingPart = lubricatingPart;
    }

    public String getGreasePart() {
        return greasePart;
    }

    public void setGreasePart(String greasePart) {
        this.greasePart = greasePart;
    }

    public String getLubricatingPoint() {
        return lubricatingPoint;
    }

    public void setLubricatingPoint(String lubricatingPoint) {
        this.lubricatingPoint = lubricatingPoint;
    }

    public String getGreaseTool() {
        return greaseTool;
    }

    public void setGreaseTool(String greaseTool) {
        this.greaseTool = greaseTool;
    }

    public String getLubricatingNumber() {
        return lubricatingNumber;
    }

    public void setLubricatingNumber(String lubricatingNumber) {
        this.lubricatingNumber = lubricatingNumber;
    }

    public AddOilStandardBean getAddOilStandardBean() {
        return addOilStandardBean;
    }

    public void setAddOilStandardBean(AddOilStandardBean addOilStandardBean) {
        this.addOilStandardBean = addOilStandardBean;
    }

    public UpdateOilStandardBean getUpdateOilStandardBean() {
        return updateOilStandardBean;
    }

    public void setUpdateOilStandardBean(UpdateOilStandardBean updateOilStandardBean) {
        this.updateOilStandardBean = updateOilStandardBean;
    }

    public static TaskBean getBean(AVObject avObject) {
        TaskBean taskBean = new TaskBean();
        taskBean.setDeviceName((String) avObject.get("deviceKind"));
        taskBean.setLubricatingPart(avObject.getString("lubricatingPart"));
        taskBean.setGreaseTool(avObject.getString("greaseTool"));
        taskBean.setGreasePart(avObject.getString("greasePart"));
        taskBean.setLubricatingNumber(avObject.getString("lubricatingNumber"));
        taskBean.setAddOilStandardBean(AddOilStandardBean.getBean(avObject.getAVObject("addOilStandard")));
        taskBean.setUpdateOilStandardBean(UpdateOilStandardBean.getBean(avObject.getAVObject("changeOilStandard")));
        return taskBean;
    }

    public static List<TaskBean> getList(List<AVObject> avList) {
        List<TaskBean> list = new ArrayList<>();
        for (AVObject avObject : avList) {
            list.add(getBean(avObject));
        }
        return list;
    }
}
