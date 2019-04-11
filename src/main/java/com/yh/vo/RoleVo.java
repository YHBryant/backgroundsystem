package com.yh.vo;

import com.yh.tools.SplitePageBean;

public class RoleVo {
    String rolename;
    SplitePageBean splitePageBean;

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public SplitePageBean getSplitePageBean() {
        return splitePageBean;
    }

    public void setSplitePageBean(SplitePageBean splitePageBean) {
        this.splitePageBean = splitePageBean;
    }

    @Override
    public String toString() {
        return "RoleVo{" +
                "rolename='" + rolename + '\'' +
                ", splitePageBean=" + splitePageBean +
                '}';
    }
}
