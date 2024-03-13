package priv.kami.study.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "用户VO实体")
public class UserVO {
    @ApiModelProperty("用户id")
    private Long id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("性别")
    private Integer sex;

    @ApiModelProperty("余额")
    private Integer balance;

    @ApiModelProperty("状态")
    private Integer status;
}
