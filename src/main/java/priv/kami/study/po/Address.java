package priv.kami.study.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author kami
 * @since 2024-03-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("address")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("user_id")
    private Long userId;

    @TableField("province")
    private String province;

    @TableField("city")
    private String city;

    @TableField("town")
    private String town;

    @TableField("mobile")
    private String mobile;

    @TableField("street")
    private String street;

    @TableField("contract")
    private String contract;

    @TableField("is_default")
    private Integer isDefault;

    @TableField("note")
    private String note;

    @TableField("is_delete")
    private Integer isDelete;
}
