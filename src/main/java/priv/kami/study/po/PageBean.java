package priv.kami.study.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageBean {
    private Integer page;
    private Integer pageSize;
    private Long total;
    private List rows;
}
