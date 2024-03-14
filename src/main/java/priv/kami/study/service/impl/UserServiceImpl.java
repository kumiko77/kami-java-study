package priv.kami.study.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import priv.kami.study.mapper.UserMapper;
import priv.kami.study.po.User;
import priv.kami.study.service.IUserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public void deductBalance(Long id, Integer amount) {
        // 查询用户
        User user = getById(id);
        // 校验用户状态
        if(user == null) {
            throw new RuntimeException("用户不存在");
        }
        // 校验余额是否充足
        Integer balance =  user.getBalance();
        System.out.println(balance);
        System.out.println(amount);
        System.out.println(balance < amount);
        if(balance < amount) {
            throw new RuntimeException("用户余额不足，无法扣减");
        }
        // 余额扣减
        baseMapper.deductBalance(id, amount);
    }
}
