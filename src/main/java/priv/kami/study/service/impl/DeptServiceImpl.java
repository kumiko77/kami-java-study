package priv.kami.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import priv.kami.study.po.Dept;
import priv.kami.study.mapper.DeptMapper;
import priv.kami.study.po.PageBean;
import priv.kami.study.po.Result;
import priv.kami.study.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author kami
 * @since 2024-03-18
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

    @Resource
    DeptMapper dataMapper;

    public PageBean list(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Dept> deptList = dataMapper.selectList(new QueryWrapper<>());
        Page<Dept> p = (Page<Dept>) deptList;
        PageBean pageBean = new PageBean(p.getPageNum(), p.getPageSize(), p.getTotal(), p.getResult());
        return pageBean;
    }

    @Override
    public void deleteById(Integer id) {
        dataMapper.deleteById(id);
    }

    @Override
    public void saveDept(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        dataMapper.insert(dept);
    }

    @Override
    public Result updateDept(Dept dept) {
        Dept getDept = getById(dept.getId());
        if(getDept == null) {
            return Result.error("部门不存在");
        }

        dept.setUpdateTime(LocalDateTime.now());

        dataMapper.updateById(dept);

        return Result.success();
    }
}
