package com.yh.vo;


import java.util.List;

public class RoleInfoVo {
    int userId;
    List<Integer> rids;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Integer> getRids() {
        return rids;
    }

    public void setRids(List<Integer> rids) {
        this.rids = rids;
    }

    @Override
    public String toString() {
        return "RoleInfoVo{" +
                "userId=" + userId +
                ", rids=" + rids +
                '}';
    }
}
