package priv.kami.study.mapper;

import org.apache.ibatis.annotations.Mapper;
import priv.kami.study.po.Address;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kami
 * @since 2024-03-14
 */
@Mapper
public interface AddressMapper extends BaseMapper<Address> {

}
