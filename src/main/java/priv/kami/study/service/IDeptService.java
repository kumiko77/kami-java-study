package priv.kami.study.service;

import priv.kami.study.po.Dept;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.kami.study.po.PageBean;
import priv.kami.study.po.Result;

import java.util.List;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author kami
 * @since 2024-03-18
 */
public interface IDeptService extends IService<Dept> {
    PageBean list(Integer page, Integer pageSize);

    void deleteById(Integer id);

    void saveDept(Dept dept);

    Result updateDept(Dept dept);
}
