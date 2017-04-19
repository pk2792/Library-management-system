package com.lms.model;

public class BoqHD {
	
	private String project_id ,
	  boq_hd_id,
	  description ,
	  parent_id,parent_name;

	public String getParent_name() {
		return parent_name;
	}

	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}

	public String getProject_id() {
		return project_id;
	}

	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}

	public String getBoq_hd_id() {
		return boq_hd_id;
	}

	public void setBoq_hd_id(String boq_hd_id) {
		this.boq_hd_id = boq_hd_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	
	

}
