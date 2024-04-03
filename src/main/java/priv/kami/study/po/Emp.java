package priv.kami.study.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 员工表
 * </p>
 *
 * @author kami
 * @since 2024-03-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("emp")
public class Emp implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 姓名
     */
    @TableField("name")
    private String name;

    /**
     * 性别, 说明: 1 男, 2 女
     */
    @TableField("gender")
    private Integer gender;

    /**
     * 图像
     */
    @TableField("image")
    private String image;

    /**
     * 职位, 说明: 1 班主任,2 讲师, 3 学工主管, 4 教研主管, 5 咨询师
     */
    @TableField("job")
    private Integer job;

    /**
     * 入职时间
     */
    @TableField("entrydate")
    private LocalDate entrydate;

    /**
     * 部门ID
     */
    @TableField("dept_id")
    private Integer deptId;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;


}
