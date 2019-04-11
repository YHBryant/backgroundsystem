package com.yh.controller;

import com.yh.dto.RoleDto;
import com.yh.dto.RoleInfoDto;
import com.yh.pojo.RoleInfo;
import com.yh.service.RoleService;
import com.yh.tools.SplitePageBean;
import com.yh.vo.RoleInfoVo;
import com.yh.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RoleController {

    @Autowired
    RoleService roleService;


    //获取角色信息
    @RequestMapping(value = "getRoleInfo",method = RequestMethod.POST)
    public List<RoleInfoDto> getRoleInfo(@RequestParam int userId){
//        System.out.println(userId);
        return this.roleService.getRoleInfoByUserId(userId);
    }
    //权限分配
    @RequestMapping(value = "addRoleByUserId")
    public int addRoleByUserId(@RequestBody(required = false) RoleInfoVo roleInfoVo){
        return roleService.addRoleByUserId(roleInfoVo);
    }


    @RequestMapping(value = "getRoleInfoBy")
    public Object getRoleInfoBy(){
        return roleService.getRoleInfoBy();
    }


    @ResponseBody
    @RequestMapping(value = "delRoleById",method = RequestMethod.POST)
    public Object delRoleById(@RequestBody RoleInfo roleInfo){
        int i = roleService.delRoleById(roleInfo.getRoleid());
        return i;
    }

    //添加用户
    @RequestMapping(value = "addRoleInfo",method = RequestMethod.POST)
    public Object addRoleInfo(@RequestBody RoleInfo roleInfo){
//        if (roleInfo == null) {
//            return false + "";
//        }
//        boolean flag = roleService.addRoleInfo(roleInfo);
//        System.out.println(flag);
//        return flag;
        return roleService.addRoleInfo(roleInfo);
    }

    //根据Id获取信息
    @ResponseBody
    @RequestMapping(value = "getRoleInfoById",method = RequestMethod.POST)
    public RoleInfo getRoleInfoById(@RequestBody(required = false) RoleInfo roleInfo){
        RoleInfo roleInfoById = this.roleService.getRoleInfoById(roleInfo.getRoleid());
        return roleInfoById;
    }

    //角色修改
    @ResponseBody
    @RequestMapping(value = "updateRole",method = RequestMethod.POST)
    public Object updateRole(@RequestBody RoleInfo roleInfo){
        int i = roleService.updateRole(roleInfo);
        return i;
    }

    //批量删除
    @ResponseBody
    @RequestMapping(value = "batchDelRoleInfo",method = RequestMethod.GET)
    public String batchDelRoleInfo(@RequestParam(value = "ids[]", required = false) Integer[] ids){
        Map<String,Object> map = new HashMap();
        map.put("ids",ids);
        Boolean flag = this.roleService.batchDelRoleInfo(map);
        return flag.toString();
    }

    //获取所有用户信息与分页
    @ResponseBody
    @RequestMapping(value = "roleInfoList",method = RequestMethod.POST)
    public Object roleInfoList(@RequestBody(required = false) RoleVo roleVo){
        //当前第几页,每页多少行
        List<RoleInfo> roleInfoList = this.roleService.getRoleInfosPageBy(roleVo);
        //获取分页类对象
        SplitePageBean splitePageBean = new SplitePageBean();
        //获取数据条数
        int count = this.roleService.getCount(roleVo);
        splitePageBean.setCurrentPage(roleVo.getSplitePageBean().getCurrentPage());
        splitePageBean.setPageCount(count%2==0?count/2:count/2+1);
        splitePageBean.setDataCount(count);
        RoleDto roleDto = new RoleDto();
        roleDto.setSplitePageBean(splitePageBean);
        roleDto.setRoleInfoList(roleInfoList);
        return roleDto;
    }
}
