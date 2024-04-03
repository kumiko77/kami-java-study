package priv.kami.study.mapper;

import org.apache.ibatis.annotations.Mapper;
import priv.kami.study.po.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author kami
 * @since 2024-03-18
 */
@Mapper
public interface DeptMapper extends BaseMapper<Dept> {

}
