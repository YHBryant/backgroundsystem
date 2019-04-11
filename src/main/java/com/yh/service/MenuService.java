package com.yh.service;

import com.yh.dto.MenuInfoDto;
import com.yh.pojo.MenuInfo;
import com.yh.pojo.UserInfo;
import com.yh.vo.AssignPermessionVo;
import com.yh.vo.MenuInfoVo;

import java.util.List;

public interface MenuService {
    public List<MenuInfoDto> getAllMenu(int roleId);

    public int modifyMenuByRoleId(AssignPermessionVo assignPermessionVo);

    public List<MenuInfo> getMenuAll();

    public List<MenuInfo> getMenuInfosPageBy(MenuInfoVo menuInfoVo);

    /**
     * 查询总数据条数
     * @return 总数据条数
     */
    public int getCount(MenuInfoVo menuInfoVo);

    public List<MenuInfo> getMenuInfoBy(UserInfo userInfo);
}
