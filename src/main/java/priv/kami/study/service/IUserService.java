package priv.kami.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.kami.study.po.User;
import priv.kami.study.vo.UserVO;

import java.util.List;

public interface IUserService extends IService<User> {
    Integer deductBalance(Long id, Integer amount);

    List<User> queryUsers(String name, Integer status, Integer minBalance, Integer maxBalance);

    UserVO queryUserAndAddressById(Long id);
}
