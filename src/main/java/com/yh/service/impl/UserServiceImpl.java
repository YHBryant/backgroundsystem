package com.yh.service.impl;

import com.yh.mapper.UserInfoMapper;
import com.yh.pojo.UserInfo;
import com.yh.service.UserService;
import com.yh.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserInfoMapper userInfoMapper;
    public UserInfo loginCheck(UserInfo userInfo) {

        return userInfoMapper.loginCheck(userInfo);
    }

//    @Transactional
    public boolean addUserMessage(UserInfo userInfo) throws Exception {
        int count = this.userInfoMapper.addUserMessage(userInfo);
//        if(true) {
////            throw new NegativeArraySizeException();
//        }
        if(count>0){
            return true;
        }
        return false;
    }

    public UserInfo getUserInfoMapById(int id) {
        List<UserInfo> userInfoMapById = userInfoMapper.getUserInfoMapById(id);
        return userInfoMapById.get(0);
    }

    public boolean updateUserMessage(UserInfo userInfo) {
        boolean flag = false;
        if(this.userInfoMapper.updateUserMessage(userInfo)>0){
            flag = true;
        }
        return flag;
    }

    public int delUserMessage(int id) {
       int i = userInfoMapper.delUserMessage(id);
        System.out.println(i);
        return i;
    }

    public List<UserInfo> getUserMessageBy(UserInfo userInfo) {
        return this.userInfoMapper.getUserMessageBy(userInfo);
    }

    public UserInfo getUserInfoById(int id) {
        return this.userInfoMapper.getUserInfoById(id);
    }

    public int getCount(UserInfoVo userInfoVo) {
        return this.userInfoMapper.getCount(userInfoVo);
    }

    public List<UserInfo> getUserInfosPageBy(UserInfoVo userInfoVo) {
        return this.userInfoMapper.getUserInfosPageBy(userInfoVo);
    }

    public boolean batchDelUserInfo(Map map) {
        if(this.userInfoMapper.batchDelUserInfo(map)>0){
            return true;
        }
        return false;
    }
}
