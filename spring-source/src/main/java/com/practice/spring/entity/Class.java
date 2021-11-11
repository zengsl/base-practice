package com.practice.spring.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zengsl
 */
public class Class implements Serializable {


	private int classId;

	private String className;

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Class{");
		sb.append("classId=").append(classId);
		sb.append(", className='").append(className).append('\'');
		sb.append('}');
		return sb.toString();
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
}
