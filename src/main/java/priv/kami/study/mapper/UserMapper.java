package priv.kami.study.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import priv.kami.study.po.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Update("UPDATE user SET balance = balance - #{amount} where id = #{id}")
    void deductBalance(@Param("id") Long id,@Param("amount") Integer amount);
}
