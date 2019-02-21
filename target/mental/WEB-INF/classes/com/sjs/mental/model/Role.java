package com.sjs.mental.model;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 */
@Table(name = "t_role")
public class Role {

    @Id
    private String id;

    private String name;

    private String code;

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getCode() {return code;}

    public void setCode(String code) {this.code = code;}

}
