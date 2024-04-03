package priv.kami.study.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class pageConfig {
    @JsonProperty("当前页数，即需要查询的页码")
    private Long page;

    @JsonProperty("每页数据条数")
    private Long pageSize;

    @JsonProperty("数据总条数")
    private Long total;

    @JsonProperty("总页数，即数据总条数除以每页数据条数的结果")
    private Long pageCount;

    @JsonProperty("分页查询时需要从哪一条数据开始查询")
    private Long startIndex;

    @JsonProperty("排序字段和排序方式")
    private String orderBy;

}
