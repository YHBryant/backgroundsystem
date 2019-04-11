package com.yh.service.impl;

import com.yh.dto.RoleInfoDto;
import com.yh.mapper.RoleInfoMapper;
import com.yh.pojo.RoleInfo;
import com.yh.service.RoleService;
import com.yh.vo.RoleInfoVo;
import com.yh.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleInfoMapper roleInfoMapper;

    public List<RoleInfoDto> getRoleInfoByUserId(int userId) {
        return roleInfoMapper.getRoleInfoByUserId(userId);
    }

    @Transactional
    public int addRoleByUserId(RoleInfoVo roleInfoVo){
        int i = roleInfoMapper.delRoleByUserId(roleInfoVo.getUserId());
        System.out.println(i);

        return roleInfoMapper.addRoleByUserId(roleInfoVo);
    }

    public List<RoleInfo> getRoleInfoBy() {
        return roleInfoMapper.getRoleInfoBy();
    }

    public int delRoleById(int id) {
        return roleInfoMapper.delRoleById(id);
    }

    @Transactional
    public int addRoleInfo(RoleInfo roleInfo) {
        return   roleInfoMapper.addRoleInfo(roleInfo);
//        int u = roleInfoMapper.addUser_RoleByUser(roleInfo.getRoleid());
//        int m = roleInfoMapper.addMenu_RoleByMenu(roleInfo.getRoleid());
//        if(r>0&&u>0&&m>0){
//            return true;
//        }
//        return false;
    }

    public int updateRole(RoleInfo roleInfo) {
        return roleInfoMapper.updateRole(roleInfo);
    }

    public RoleInfo getRoleInfoById(int id) {
        return roleInfoMapper.getRoleInfoById(id);
    }

    public boolean batchDelRoleInfo(Map map) {
        if(this.roleInfoMapper.batchDelRoleInfo(map)>0){
            return true;
        }
        return false;
    }

    public List<RoleInfo> getRoleInfosPageBy(RoleVo roleVo) {
        return this.roleInfoMapper.getRoleInfosPageBy(roleVo);
    }

    public int getCount(RoleVo roleVo) {
        return this.roleInfoMapper.getCount(roleVo);
    }


}
