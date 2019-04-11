package com.yh.dto;

import com.yh.pojo.UserInfo;
import com.yh.tools.SplitePageBean;

import java.util.List;

public class UserInfoDto {
    //当前页数据
    List<UserInfo> userInfoList;
    //分页数据
    SplitePageBean splitePageBean;


    public List<UserInfo> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<UserInfo> userInfoList) {
        this.userInfoList = userInfoList;
    }

    public SplitePageBean getSplitePageBean() {
        return splitePageBean;
    }

    public void setSplitePageBean(SplitePageBean splitePageBean) {
        this.splitePageBean = splitePageBean;
    }
}
