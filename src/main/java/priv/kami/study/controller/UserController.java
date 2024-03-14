package priv.kami.study.controller;

import cn.hutool.core.bean.BeanUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import priv.kami.study.dto.UserDTO;
import priv.kami.study.po.User;
import priv.kami.study.service.IUserService;
import priv.kami.study.vo.UserVO;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "用户管理")
@RequestMapping("/user")
@RestController
public class UserController {

    @Resource
    private IUserService userService;
    @ApiOperation("新增用户")
    @PostMapping
    public void saveUser(@RequestBody UserDTO userDTO) {
        User user = BeanUtil.copyProperties(userDTO, User.class);
        // 设置默认余额
        user.setBalance(100);
        userService.save(user);
    }

    @ApiOperation("删除用户")
    @DeleteMapping("{id}")
    public void deleteUser(@ApiParam("用户id") @PathVariable("id") Long id) {
        userService.removeById(id);
    }

    @ApiOperation("根据id查询用户")
    @GetMapping("{id}")
    public UserVO getUserById(@ApiParam("用户id") @PathVariable("id") Long id) {
        User user = userService.getById(id);
        return BeanUtil.copyProperties(user, UserVO.class);
    }

    @ApiOperation("根据id批量查询用户")
    @GetMapping
    public List<UserVO> getUserByIds(@ApiParam("用户id集合") @RequestParam("id") List<Long> ids) {
        List<User> userList = userService.listByIds(ids);
        return BeanUtil.copyToList(userList, UserVO.class);
    }

    @ApiOperation("扣减用户余额")
    @PutMapping("/{id}/deduct/{amount}")
    public void deductUserBalance(
            @ApiParam("用户id") @PathVariable("id") Long id,
            @ApiParam("扣减金额") @PathVariable("amount") Integer amount) {
        userService.deductBalance(id, amount);
    }
}
