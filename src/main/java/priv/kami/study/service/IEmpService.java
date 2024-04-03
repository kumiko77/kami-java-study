package priv.kami.study.service;

import priv.kami.study.po.Emp;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.kami.study.po.PageBean;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 员工表 服务类
 * </p>
 *
 * @author kami
 * @since 2024-03-18
 */
public interface IEmpService extends IService<Emp> {

    PageBean list(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    void deleteById(Integer id);

    void saveEmp(Emp emp);
}
