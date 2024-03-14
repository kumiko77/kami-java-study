package priv.kami.study.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import org.springframework.stereotype.Service;
import priv.kami.study.mapper.UserMapper;
import priv.kami.study.po.Address;
import priv.kami.study.po.User;
import priv.kami.study.service.IUserService;
import priv.kami.study.vo.AddressVO;
import priv.kami.study.vo.UserVO;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public Integer deductBalance(Long id, Integer amount) {
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
//        baseMapper.deductBalance(id, amount);
        int result = user.getBalance() - amount;
        lambdaUpdate()
                .set(User::getBalance, result)
                .set(result <= 0, User::getStatus, 0)
                .eq(User::getId, id)
                .update();
        return result;
    }

    @Override
    public List<User> queryUsers(String name, Integer status, Integer minBalance, Integer maxBalance) {
        return lambdaQuery()
                .like(name != null, User::getName, name)
                .eq(status != null, User::getStatus, status)
                .ge(minBalance != null, User::getBalance, minBalance)
                .le(maxBalance != null, User::getBalance, maxBalance)
                .list();
    }

    @Override
    public UserVO queryUserAndAddressById(Long id) {
        // 查询用户
        User user = getById(id);
        if(user == null || user.getStatus() == 0) {
            throw new RuntimeException("用户状态异常");
        }
        // 查询地址
        List<Address> addresses = Db.lambdaQuery(Address.class)
                .eq(Address::getUserId, id).list();
        UserVO userVO = BeanUtil.copyProperties(user, UserVO.class);
        if(CollUtil.isNotEmpty(addresses)) {
            userVO.setAddresses(BeanUtil.copyToList(addresses, AddressVO.class));
        }
        return userVO;
    }
}
