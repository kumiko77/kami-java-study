package priv.kami.study.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserDTO {

//    @ApiModelProperty("id")
//    @TableId(type = IdType.AUTO)
//    private Integer id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("性别")
    private Integer sex;

//    @ApiModelProperty("余额")
//    private Integer balance;

    @ApiModelProperty("状态")
    private Integer status;
}
