package com.sjs.mental.model;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 */
@Table(name = "t_department")
public class Department {

    @Id
    private String id;

    private String parentId;

    private String name;

    private String code;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRemark() {return remark;}

    public void setRemark(String remark) {this.remark = remark;}

}
