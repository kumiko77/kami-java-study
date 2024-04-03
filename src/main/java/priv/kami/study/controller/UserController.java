package priv.kami.study.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import priv.kami.study.po.PageBean;
import priv.kami.study.po.Result;
import priv.kami.study.req.Login.LoginReq;
import priv.kami.study.service.IEmpService;
import priv.kami.study.service.IUserService;

import javax.annotation.Resource;
import java.time.LocalDate;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kami
 * @since 2024-04-03
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public Result login(@RequestBody LoginReq loginReq) {
        return userService.login(loginReq);
    }
}
