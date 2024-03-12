package priv.kami.study.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import priv.kami.study.dto.User;
import priv.kami.study.service.IUserService;

import javax.annotation.Resource;

@Api(tags = "用户管理")
@RequestMapping("/user")
@RestController
public class UserController {

    @Resource
    private IUserService userService;
    @ApiOperation("新增用户")
    @PostMapping
    public void saveUser(@RequestBody User user) {
        userService.save(user);
    }

    @ApiOperation("删除用户")
    @DeleteMapping("{id}")
    public void deleteUser(@ApiParam("用户id") @PathVariable("id") Long id) {
        userService.removeById(id);
    }

    @ApiOperation("根据id查询用户")
    @GetMapping("{id}")
    public User getUser(@ApiParam("用户id") @PathVariable("id") Long id) {
        return userService.getById(id);
    }
}
