package com.employee.employeeapp.dto;

import java.util.Objects;

public class RequestDto {

	public String id;

	public Object data;

	public RequestDto() {
		// TODO Auto-generated constructor stub
	}

	public RequestDto(String id, Object data) {
		super();
		this.id = id;
		this.data = data;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestDto other = (RequestDto) obj;
		return Objects.equals(data, other.data) && Objects.equals(id, other.id);
	}

}
