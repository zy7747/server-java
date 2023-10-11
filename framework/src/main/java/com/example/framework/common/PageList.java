package com.example.framework.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class PageList<T> {
    @ApiModelProperty(value = "当前页")
    private long page;

    @ApiModelProperty(value = "每页条数")
    private long total;

    @ApiModelProperty(value = "页容量")
    private long size;

    @ApiModelProperty(value = "回参")
    private List<T> list;

    public PageList() {
        super();
    }

    public static <T> PageList<T> setPages(IPage<T> pageResp) {
        PageList<T> p = new PageList<>();
        p.setPage(pageResp.getCurrent());
        p.setTotal(pageResp.getTotal());
        p.setSize(pageResp.getSize());
        p.setList(pageResp.getRecords());
        return p;
    }
}
