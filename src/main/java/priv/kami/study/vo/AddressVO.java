package priv.kami.study.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "收货地址VO")
public class AddressVO {
    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("省")
    private String province;

    @ApiModelProperty("市")
    private String city;

    @ApiModelProperty("区")
    private String town;

    @ApiModelProperty("手机")
    private String mobile;

    @ApiModelProperty("街道")
    private String street;

    @ApiModelProperty("合同")
    private String contract;

    @ApiModelProperty("是否是默认地址")
    private Integer isDefault;

    @ApiModelProperty("备注")
    private String note;

    @ApiModelProperty("删除标识")
    private Integer isDelete;
}
