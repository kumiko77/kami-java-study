package priv.kami.study.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import priv.kami.study.config.pageConfig;

import java.util.List;

@Data
public class PageResult<T> {
    @JsonProperty("存储查询出来的数据")
    private List<T> list;

    @JsonProperty("分页信息数据")
    private pageConfig page;

}
