package priv.kami.study.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data

public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer age;

    private Integer sex;

    private Integer balance;

    private Integer status;
}
