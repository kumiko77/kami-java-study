package priv.kami.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import priv.kami.study.po.Emp;
import priv.kami.study.mapper.EmpMapper;
import priv.kami.study.po.PageBean;
import priv.kami.study.service.IEmpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author kami
 * @since 2024-03-18
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {

    @Resource
    private EmpMapper dataMapper;

    @Override
    public PageBean list(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        PageHelper.startPage(page, pageSize);
        QueryWrapper<Emp> queryWrapper = new QueryWrapper<>();
        System.out.println(begin);
        System.out.println(end);
        queryWrapper.like(name != null, "name", name)
                .eq(gender != null, "gender", gender)
                .ge(begin != null, "entryDate", begin)
                .le(end != null, "entryDate", end);
        List<Emp> empList = dataMapper.selectList(queryWrapper);
        System.out.println(empList);
        Page<Emp> p = (Page<Emp>) empList;
        System.out.println(p);
        return new PageBean(p.getPageNum(), p.getPageSize(), p.getTotal(), p.getResult());
    }

    @Override
    public void deleteById(Integer id) {
        dataMapper.deleteById(id);
    }

    @Override
    public void saveEmp(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        dataMapper.insert(emp);
    }
}
