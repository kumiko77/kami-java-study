package priv.kami.study.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import priv.kami.study.po.User;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kami
 * @since 2024-04-03
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
