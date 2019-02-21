package com.sjs.mental.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 *
 */
@Table(name = "t_user")
public class User {

    @Id
    private String id;

    private String roleId;

    private String departmentId;

    private String username;

    @JsonIgnore
    private String password;

    private String name; //姓名

    private String phone; //电话

    private String birthday; //出生日期  yyyy-MM-dd

    private String gender;//性别 1=男 2=女

    private String status="Y"; //是否有效 Y or N

    private Date createTime=new Date();

    private Date updateTime=new Date();

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getRoleId() {return roleId;}

    public void setRoleId(String roleId) {this.roleId = roleId;}

    public String getDepartmentId() {return departmentId;}

    public void setDepartmentId(String departmentId) {this.departmentId = departmentId;}

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getPhone() {return phone;}

    public void setPhone(String phone) {this.phone = phone;}

    public String getBirthday() {return birthday;}

    public void setBirthday(String birthday) {this.birthday = birthday;}

    public String getGender() {return gender;}

    public void setGender(String gender) {this.gender = gender;}

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}

    public Date getCreateTime() {return createTime;}

    public void setCreateTime(Date createTime) {this.createTime = createTime;}

    public Date getUpdateTime() {return updateTime;}

    public void setUpdateTime(Date updateTime) {this.updateTime = updateTime;}

}
