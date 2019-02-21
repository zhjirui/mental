package com.sjs.mental.model;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 */
@Table(name = "t_menu")
public class Menu {

    @Id
    private String id;

    private String parentId;

    private String name;

    private String url;

    private String icon;

    private Double rank;

    private String status;

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getParentId() {return parentId;}

    public void setParentId(String parentId) {this.parentId = parentId;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getUrl() {return url;}

    public void setUrl(String url) {this.url = url;}

    public String getIcon() {return icon;}

    public void setIcon(String icon) {this.icon = icon;}

    public Double getRank() {return rank;}

    public void setRank(Double rank) {this.rank = rank;}

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}

}
