package priv.kami.study.controller;


import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import priv.kami.study.mapper.EmpMapper;
import priv.kami.study.po.Emp;
import priv.kami.study.po.PageBean;
import priv.kami.study.po.Result;
import priv.kami.study.service.IEmpService;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 员工表 前端控制器
 * </p>
 *
 * @author kami
 * @since 2024-03-18
 */
@Slf4j
@RestController
@RequestMapping("/emp")
public class EmpController {

    @Resource
    private IEmpService empService;

    @ApiOperation("用户列表")
    @GetMapping("/list")
    public PageBean list(@RequestParam(defaultValue = "1") Integer page,
                         @RequestParam(defaultValue = "10") Integer pageSize,
                         String name, Short gender,
                         @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                         @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end) {
        System.out.println(begin + "123" +end);
        return empService.list(page, pageSize, name, gender, begin, end);
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        empService.deleteById(id);
        return Result.success();
    }

    @ApiOperation("新增用户")
    @PostMapping("/save")
    public Result saveEmp(@RequestBody Emp emp) {
        empService.saveEmp(emp);
        return Result.success();
    }
}
