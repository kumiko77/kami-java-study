package priv.kami.study.mapper;

import org.apache.ibatis.annotations.Mapper;
import priv.kami.study.po.Emp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 员工表 Mapper 接口
 * </p>
 *
 * @author kami
 * @since 2024-03-18
 */
@Mapper
public interface EmpMapper extends BaseMapper<Emp> {

}
