package com.yh.vo;

import java.io.Serializable;
import java.util.List;

public class AssignPermessionVo implements Serializable {
    int roleId;
    List<Integer> menuIds;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public List<Integer> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<Integer> menuIds) {
        this.menuIds = menuIds;
    }

    @Override
    public String toString() {
        return "AssignPermessionVo{" +
                "roleId=" + roleId +
                ", menuIds=" + menuIds +
                '}';
    }
}
