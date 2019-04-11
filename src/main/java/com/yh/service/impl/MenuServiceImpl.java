package com.yh.service.impl;

import com.yh.dto.MenuInfoDto;
import com.yh.mapper.MenuInfoMapper;
import com.yh.pojo.MenuInfo;
import com.yh.pojo.UserInfo;
import com.yh.service.MenuService;
import com.yh.vo.AssignPermessionVo;
import com.yh.vo.MenuInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuInfoMapper menuInfoMapper;

    public List<MenuInfoDto> getAllMenu(int roleId) {
//        System.out.println(menuInfoMapper.getAllMenu(1));
        return menuInfoMapper.getAllMenu(roleId);
    }

    @Transactional
    public int modifyMenuByRoleId(AssignPermessionVo assignPermessionVo) {
        int result=-1;
        int num=menuInfoMapper.emptyMenu(assignPermessionVo.getRoleId());
        if(num==0){
            result=menuInfoMapper.addRMByAssign(assignPermessionVo);
            return result;
        }else {
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            map.put("roleId",assignPermessionVo.getRoleId());
            for(int i=0;i<assignPermessionVo.getMenuIds().size();i++){
                map.put("menuId",assignPermessionVo.getMenuIds().get(i));
                result=menuInfoMapper.queryExist(map);
                System.out.println("result:"+result);
                if(result==0){
                    menuInfoMapper.addRM(map);
                }else {
                    menuInfoMapper.updateRM(map);
                }
            }
            return  result;
        }
    }

    public List<MenuInfo> getMenuAll() {
        return menuInfoMapper.getMenuAll();
    }

    public List<MenuInfo> getMenuInfosPageBy(MenuInfoVo menuInfoVo) {
        return menuInfoMapper.getMenuInfosPageBy(menuInfoVo);
    }

    public int getCount(MenuInfoVo menuInfoVo) {
        return menuInfoMapper.getCount(menuInfoVo);
    }

    public List<MenuInfo> getMenuInfoBy(UserInfo userInfo) {
//        System.out.println(userInfo);
        return menuInfoMapper.getMenuInfoBy(userInfo);
    }


}
