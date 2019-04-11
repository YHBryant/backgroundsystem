package com.yh.service;

import com.yh.dto.RoleInfoDto;
import com.yh.pojo.RoleInfo;
import com.yh.vo.RoleInfoVo;
import com.yh.vo.RoleVo;

import java.util.List;
import java.util.Map;

public interface RoleService {
    public List<RoleInfoDto> getRoleInfoByUserId(int userId);

    public int addRoleByUserId(RoleInfoVo roleInfoVo);

    public List<RoleInfo> getRoleInfoBy();

    public int delRoleById(int id);

    public int addRoleInfo(RoleInfo roleInfo);

    public int updateRole(RoleInfo roleInfo);

    public RoleInfo getRoleInfoById(int id);

    public boolean batchDelRoleInfo(Map map);

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
