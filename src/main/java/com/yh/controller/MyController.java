package com.yh.controller;

import com.yh.dto.UserInfoDto;
import com.yh.pojo.UserInfo;
import com.yh.service.UserService;
import com.yh.tools.Md5Utils;
import com.yh.tools.SplitePageBean;
import com.yh.vo.UserInfoVo;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MyController {

    @Autowired
    UserService userService;
    //测试
    @ResponseBody//经过json处理的
    @RequestMapping(value = "test",method = RequestMethod.POST)
    public String test(){
        System.out.println("inner test");
        return "hello world";
    }
    //登录验证
    @ResponseBody
    @RequestMapping(value = "loginCheck",method = RequestMethod.POST)
    public String loginCheck(@RequestBody UserInfo userInfo, HttpSession session){
        Boolean flag = false;
        userInfo.setPassword(Md5Utils.encodePassword(userInfo.getPassword()));
        System.out.println("username="+userInfo.getUsername()+",password="+userInfo.getPassword());
        //登录成功以后将用户名和密码保存到session中
        UserInfo userInfo1 = userService.loginCheck(userInfo);
        if (userInfo1!=null){
            //登录成功,保存
            session.setAttribute("userInfo",userInfo1);
            flag=true;
        }
        return flag.toString();
    }
    //获取所有用户信息与分页
    @ResponseBody
    @RequestMapping(value = "userInfoList",method = RequestMethod.POST)
    public Object userInfoList(@RequestBody(required = false) UserInfoVo userInfoVo){
//        System.out.println(userInfoVo);
        //当前第几页,每页多少行
        List<UserInfo> userInfoList = this.userService.getUserInfosPageBy(userInfoVo);
//        System.out.println(userInfoList.toString()+"11111");
//        System.out.println(userMessageBy.toString());
        //获取分页类对象
        SplitePageBean splitePageBean = new SplitePageBean();
        //获取数据条数
        int count = this.userService.getCount(userInfoVo);
        splitePageBean.setCurrentPage(userInfoVo.getSplitePageBean().getCurrentPage());
        splitePageBean.setPageCount(count%2==0?count/2:count/2+1);
        splitePageBean.setDataCount(count);
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setSplitePageBean(splitePageBean);
        userInfoDto.setUserInfoList(userInfoList);
        return userInfoDto;
    }
    //根据Id获取信息
    @ResponseBody
    @RequestMapping(value = "getUserInfoById",method = RequestMethod.POST)
    public UserInfo getUserInfoById(@RequestBody(required = false) UserInfo userInfo){
        UserInfo userInfoById = this.userService.getUserInfoById(userInfo.getUserId());
//        System.out.println(userInfo.getUserId());
        return userInfoById;
    }
    //更新修改
    @ResponseBody
    @RequestMapping(value = "updateUserMessage",method = RequestMethod.POST)
    public Object updateUserMessage(@RequestBody UserInfo userInfo){
//        System.out.println(userInfo);
        if(userInfo.getUserId()==0){
            return false+"";
        }
        boolean flag = this.userService.updateUserMessage(userInfo);
        return flag;
    }
    //单个删除
    @ResponseBody
    @RequestMapping(value = "delUserMessage",method = RequestMethod.POST)
    public Object delUserMessage(@RequestBody UserInfo userInfo){
        int i = this.userService.delUserMessage(userInfo.getUserId());
        return i;
    }
    //添加用户
    @ResponseBody
    @RequestMapping(value = "addUserMessage",method = RequestMethod.POST)
    public Object addUserMessage(@RequestBody UserInfo userInfo) throws Exception {
//        System.out.println(userInfo);
        boolean b = this.userService.addUserMessage(userInfo);
        return b;
    }

    @ResponseBody
    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    public Object addUser(@RequestBody UserInfo userInfo) throws Exception {
        boolean flag = false;
        userInfo.setPassword(Md5Utils.encodePassword(userInfo.getPassword()));
        flag = this.userService.addUserMessage(userInfo);
        return flag;
    }
    //批量删除
    @ResponseBody
    @RequestMapping(value = "batchDelUserInfo",method = RequestMethod.GET)
    public String batchDelUserInfo(@RequestParam(value = "ids[]", required = false) Integer[] ids){
        Map<String,Object> map = new HashMap();
        map.put("ids",ids);
        Boolean flag = this.userService.batchDelUserInfo(map);
        return flag.toString();
    }
    //上传文件
    @ResponseBody
    @RequestMapping(value = "/fileUpload1")
    public Object fileUpload1(@RequestParam("uploadFile") CommonsMultipartFile uploadFile) throws IOException {
        //定义文件路径
        String path="D:/"+new Date().getTime()+uploadFile.getOriginalFilename();
        File destFile = new File(path);
        uploadFile.transferTo(destFile);
        return "上传成功";
    }
    //下载文件
    @RequestMapping("/testDownload")
    public ResponseEntity<byte[]> download() throws IOException {
        //创建文件
        File file = new File("D://s.txt");
        byte[] body = null;
        //创建输入流(从硬盘读取数据)
        InputStream is = new FileInputStream(file);
        //创建字节数组并指定长度
        body = new byte[is.available()];
        //将数据从输入流导到输出流
        is.read(body);
        //创建响应头并设置指定值
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename=" + file.getName());
        //设置HTTP响应状态。
        HttpStatus statusCode = HttpStatus.OK;
        //创建响应实体对象
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
        return entity;
    }

}
