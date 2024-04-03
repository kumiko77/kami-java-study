package priv.kami.study.controller;


import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import priv.kami.study.po.Dept;
import priv.kami.study.po.PageBean;
import priv.kami.study.po.Result;
import priv.kami.study.service.IDeptService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author kami
 * @since 2024-03-18
 */
@Slf4j
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Resource
    private IDeptService deptService;

    @ApiOperation("部门列表")
    @GetMapping("/list")
    public Result list(Integer page, Integer pageSize) {
        log.info("查询全部部门记录");
        PageBean deptList = deptService.list(page, pageSize);

        return Result.success(deptList);
    }

    @ApiOperation("删除部门")
    @DeleteMapping("/{id}")
    public Result deleteDeptById(@PathVariable Integer id) {
        log.info("根据id删除部门:{}", id);

        deptService.deleteById(id);

        return Result.success("删除成功");
    }

    @ApiOperation("新增部门")
    @PostMapping("/save")
    public Result saveDept(@RequestBody Dept dept) {
        log.info("新增部门:{}", dept);

        deptService.saveDept(dept);

        return Result.success("新增成功");
    }

    @ApiOperation("修改部门")
    @PutMapping("/update")
    public Result updateDept(@RequestBody Dept dept) {
        log.info("修改部门:{}", dept);

        return  deptService.updateDept(dept);
    }
}
