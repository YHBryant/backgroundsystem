package com.yh.pojo;

public class MenuInfo {
    int menuid;
    String menuname;
    int parentid;

    public int getMenuid() {
        return menuid;
    }

    public void setMenuid(int menuid) {
        this.menuid = menuid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    @Override
    public String toString() {
        return "MenuInfo{" +
                "menuid=" + menuid +
                ", menuname='" + menuname + '\'' +
                ", parentid=" + parentid +
                '}';
    }
}
