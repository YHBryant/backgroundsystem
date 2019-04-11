package com.yh.mapper;

import com.yh.pojo.UserInfo;
import com.yh.vo.UserInfoVo;

import java.util.List;
import java.util.Map;

public interface UserInfoMapper {
    public UserInfo loginCheck(UserInfo userInfo);

    public int addUserMessage(UserInfo userInfo);

    public List<UserInfo> getUserInfoMapById(int id);

    public int updateUserMessage(UserInfo userInfo);

    public int delUserMessage(int id);

    public List<UserInfo> getUserMessageBy(UserInfo userInfo);

    public UserInfo getUserInfoById(int id);

    /**
     * 根据条件查询分页数据
     * @param userInfoVo
     * @return 符合条件的数据
     */
    public List<UserInfo> getUserInfosPageBy(UserInfoVo userInfoVo);

    /**
     * 查询总数据条数
     * @return 总数据条数
     */
    public int getCount(UserInfoVo userInfoVo);

    public int batchDelUserInfo(Map map);
}
