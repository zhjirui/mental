package com.sjs.mental.common;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class PageBeanDataTables {

    public PageBeanDataTables(){}

    public PageBeanDataTables( List data,Long recordsTotal){
        //this.draw = draw;
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsTotal;
        this.data = data;
    }

    private Long draw=0L;

    private Long  recordsTotal=0L;

    private Long recordsFiltered=0L;

    private List data;

    public Long getDraw() {
        return draw;
    }

    public void setDraw(Long draw) {
        this.draw = draw;
    }

    public Long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
