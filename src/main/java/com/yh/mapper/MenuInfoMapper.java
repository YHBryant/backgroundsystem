package com.yh.mapper;

import com.yh.dto.MenuInfoDto;
import com.yh.pojo.MenuInfo;
import com.yh.pojo.UserInfo;
import com.yh.vo.AssignPermessionVo;
import com.yh.vo.MenuInfoVo;

import java.util.List;
import java.util.Map;

public interface MenuInfoMapper {
    public List<MenuInfoDto> getAllMenu(int roleId);

    public int emptyMenu(int roleId);

    public int queryExist(Map map);

    public int updateRM (Map map);

    public int addRM (Map map);

    public int addRMByAssign(AssignPermessionVo assignPermessionVo);

    public List<MenuInfo> getMenuAll();

    public List<MenuInfo> getMenuInfosPageBy(MenuInfoVo menuInfoVo);

    /**
     * 查询总数据条数
     * @return 总数据条数
     */
    public int getCount(MenuInfoVo menuInfoVo);

    public List<MenuInfo> getMenuInfoBy(UserInfo userInfo);
}
