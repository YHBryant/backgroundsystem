package com.yh.vo;

import com.yh.tools.SplitePageBean;

public class MenuInfoVo {
    String menuname;
    SplitePageBean splitePageBean;

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public SplitePageBean getSplitePageBean() {
        return splitePageBean;
    }

    public void setSplitePageBean(SplitePageBean splitePageBean) {
        this.splitePageBean = splitePageBean;
    }

    @Override
    public String toString() {
        return "MenuInfoVo{" +
                "menuname='" + menuname + '\'' +
                ", splitePageBean=" + splitePageBean +
                '}';
    }
}
