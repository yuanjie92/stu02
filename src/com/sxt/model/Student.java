package com.sxt.model;

import java.util.Date;

public class Student {
	private int id;
	private String name;
	private Date birthday;
	private int gander;
	private String grade;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getGander() {
		return gander;
	}

	public void setGander(int gander) {
		this.gander = gander;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", birthday=" + birthday + ", gander=" + gander + ", grade="
				+ grade + "]";
	}

}
