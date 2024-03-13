package priv.kami.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.kami.study.po.User;

public interface IUserService extends IService<User> {
    void deductBalance(Long id, Integer amount);
}
