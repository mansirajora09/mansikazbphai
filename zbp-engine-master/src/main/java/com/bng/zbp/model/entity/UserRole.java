package com.bng.zbp.model.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "role" ,catalog = "zbp")
public class UserRole implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String crdt;
	private String created_by;
	private String last_modified_by;
	private String last_modified_on;
    private String name;
    private String description;
    private String display_name;
    private Integer role_id;
    private Boolean is_active;
	//@OneToMany
	@OneToMany

	@JoinColumn(name ="role_id", insertable=false, updatable=false,referencedColumnName="id",nullable=false)

	//private <Submenu> submenu;
    private List<UserMysqlPerDAO> permission = new ArrayList<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCrdt() {
		return crdt;
	}
	public void setCrdt(String crdt) {
		this.crdt = crdt;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public String getLast_modified_by() {
		return last_modified_by;
	}
	public void setLast_modified_by(String last_modified_by) {
		this.last_modified_by = last_modified_by;
	}
	public String getLast_modified_on() {
		return last_modified_on;
	}
	public void setLast_modified_on(String last_modified_on) {
		this.last_modified_on = last_modified_on;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public Boolean getIs_active() {
		return is_active;
	}
	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}
	public List<UserMysqlPerDAO> getPermission() {
		return permission;
	}
	public void setPermission(List<UserMysqlPerDAO> permission) {
		this.permission = permission;
	}
	
   
}