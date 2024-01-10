package org.wzj.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wzj.service.SysMenuService;
import org.wzj.service.ValidateCodeService;
import org.wzj.service.SysUserService;
import org.wzj.spzx.model.dto.system.LoginDto;
import org.wzj.spzx.model.entity.system.SysUser;
import org.wzj.spzx.model.vo.common.Result;
import org.wzj.spzx.model.vo.common.ResultCodeEnum;
import org.wzj.spzx.model.vo.system.LoginVo;
import org.wzj.spzx.model.vo.system.SysMenuVo;
import org.wzj.spzx.model.vo.system.ValidateCodeVo;
import org.wzj.utils.AuthContextUtil;

import java.util.List;


@Tag(name="登录接口")
@RestController
@RequestMapping("/admin/system/index")
public class IndexController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ValidateCodeService validateCodeService;

    @Autowired
    private SysMenuService sysMenuService;

    @Operation(summary = "验证码的方法")
    //生成图片验证码
    @GetMapping(value = "/generateValidateCode")
    public Result<ValidateCodeVo> generateValidateCode() {
        ValidateCodeVo validateCodeVo = validateCodeService.generateValidateCode();
        return Result.build(validateCodeVo, ResultCodeEnum.SUCCESS);
    }

    //登录
    @Operation(summary = "登录的方法")
    @PostMapping("/login")
    public Result login(@RequestBody LoginDto loginDto) {
        LoginVo loginVo = sysUserService.login(loginDto);
        return Result.build(loginVo, ResultCodeEnum.SUCCESS);
    }

//    //获取当前用户登录信息
//    @GetMapping(value = "/getUserInfo")
//    public Result<SysUser> getUserInfo() {
//        //用户信息返回
//        return Result.build(AuthContextUtil.get(),ResultCodeEnum.SUCCESS);
//    }

    //获取当前用户登录信息
    @Operation(summary = "获取当前用户登录信息的方法")
    @GetMapping(value = "/getUserInfo")
    public Result<SysUser> getUserInfo(@RequestHeader(value = "token") String token) {
        //getUserInfo(HttpServletRequest request)
        //从请求头获得token
        //String header = request.getHeader("token");

        //根据token查询redis获取用户信息
        SysUser sysUser = sysUserService.getUserInfo(token);

        //用户信息返回
        return Result.build(sysUser,ResultCodeEnum.SUCCESS);
    }

    //退出账号功能
    @Operation(summary = "退出账号功能")
    @GetMapping(value = "/logout")
    public Result<SysUser> logout(@RequestHeader(value = "token") String token){
        sysUserService.logout(token);
        return Result.build(null,ResultCodeEnum.SUCCESS);
    }

    @GetMapping("/menus")
    public Result menus() {
        List<SysMenuVo> sysMenuVoList =  sysMenuService.findUserMenuList() ;
        return Result.build(sysMenuVoList , ResultCodeEnum.SUCCESS) ;
    }
}