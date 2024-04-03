package priv.kami.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.kami.study.po.Result;
import priv.kami.study.po.User;
import priv.kami.study.req.Login.LoginReq;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kami
 * @since 2024-04-03
 */
public interface IUserService extends IService<User> {

    Result login(LoginReq loginReq);
}
