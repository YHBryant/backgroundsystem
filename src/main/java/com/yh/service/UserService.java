package com.yh.service;

import com.yh.pojo.UserInfo;
import com.yh.vo.UserInfoVo;

import java.util.List;
import java.util.Map;

public interface UserService {
    public UserInfo loginCheck(UserInfo userInfo);

    public boolean addUserMessage(UserInfo userInfo) throws Exception;

    public UserInfo getUserInfoMapById(int id);

    public boolean updateUserMessage(UserInfo userInfo);

    public int delUserMessage(int id);

    public List<UserInfo> getUserMessageBy(UserInfo userInfo);

    public UserInfo getUserInfoById(int id);

    /**
     * 查询总数据条数
     * @return 总数据条数
     */
    public int getCount(UserInfoVo userInfoVo);

    /**
     * 根据条件查询分页数据
     * @param userInfoVo
     * @return 符合条件的数据
     */
    public List<UserInfo> getUserInfosPageBy(UserInfoVo userInfoVo);

    public boolean batchDelUserInfo(Map map);
}
