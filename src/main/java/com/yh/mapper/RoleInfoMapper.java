package com.yh.mapper;

import com.yh.dto.RoleInfoDto;
import com.yh.pojo.RoleInfo;
import com.yh.pojo.UserInfo;
import com.yh.vo.RoleInfoVo;
import com.yh.vo.RoleVo;
import com.yh.vo.UserInfoVo;

import javax.management.relation.Role;
import java.util.List;
import java.util.Map;

public interface RoleInfoMapper {
    public List<RoleInfoDto> getRoleInfoByUserId(int userId);

    public int delRoleByUserId(int userId);

    public int addRoleByUserId(RoleInfoVo roleInfoVo);

    public List<RoleInfo> getRoleInfoBy();

    public int delRoleById(int id);

    public int addRoleInfo(RoleInfo roleInfo);

//    public int addUser_RoleByUser(int roleId);
//
//    public int addMenu_RoleByMenu(int roleId);

    public int updateRole(RoleInfo roleInfo);

    public RoleInfo getRoleInfoById(int id);

    public int batchDelRoleInfo(Map map);

    /**
     * 根据条件查询分页数据
     * @param roleVo
     * @return 符合条件的数据
     */
    public List<RoleInfo> getRoleInfosPageBy(RoleVo roleVo);

    /**
     * 查询总数据条数
     * @return 总数据条数
     */
    public int getCount(RoleVo roleVo);


}
