package priv.kami.study.req.Login;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LoginReq {
    @ApiModelProperty(value = "账号")
    private String phoneNumber;

    @ApiModelProperty(value = "密码")
    private String password;
}
