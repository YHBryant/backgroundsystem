package com.yh.dto;

import com.yh.pojo.MenuInfo;
import com.yh.tools.SplitePageBean;

import java.util.List;

public class MenuDto {
    //当前页数据
    List<MenuInfo> menuInfoList;
    //分页数据
    SplitePageBean splitePageBean;

    public List<MenuInfo> getMenuInfoList() {
        return menuInfoList;
    }

    public void setMenuInfoList(List<MenuInfo> menuInfoList) {
        this.menuInfoList = menuInfoList;
    }

    public SplitePageBean getSplitePageBean() {
        return splitePageBean;
    }

    public void setSplitePageBean(SplitePageBean splitePageBean) {
        this.splitePageBean = splitePageBean;
    }

    @Override
    public String toString() {
        return "MenuDto{" +
                "menuInfoList=" + menuInfoList +
                ", splitePageBean=" + splitePageBean +
                '}';
    }
}
