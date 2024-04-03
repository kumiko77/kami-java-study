package priv.kami.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import priv.kami.study.mapper.UserMapper;
import priv.kami.study.po.Result;
import priv.kami.study.po.User;
import priv.kami.study.req.Login.LoginReq;
import priv.kami.study.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import priv.kami.study.util.JwtUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kami
 * @since 2024-04-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper dataMapper;

    @Override
    public Result login(LoginReq loginReq) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("phone_number", loginReq.getPhoneNumber())
                .eq("status", 1);
        User user = dataMapper.selectOne(queryWrapper);
        if(user == null) {
            return Result.error("用户不存在");
        }

        if(!Objects.equals(loginReq.getPassword(), user.getPassword())) {
            return Result.error("密码错误");
        }

        if(user.getStatus() != 1) {
            return Result.error("账号已被冻结");
        }

        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        String jwt = JwtUtils.generateJwt(claims);
        return Result.success(jwt);
    }
}
