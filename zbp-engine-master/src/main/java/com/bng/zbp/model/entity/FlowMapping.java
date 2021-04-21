package com.bng.zbp.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flow_mapping", catalog = "zbp")
public class FlowMapping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;
	@Column(name = "flow_name")
	private String flowName;
	@Column(name = "tag")
	private String tag;
	@Column(name = "userid")
	private int userId;
	public int getId() {
		return id;
	}
	public String getFlowName() {
		return flowName;
	}
	public String getTag() {
		return tag;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
