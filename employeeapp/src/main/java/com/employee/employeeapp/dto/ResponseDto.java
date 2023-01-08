/**
 * 
 */
package com.employee.employeeapp.dto;

import java.util.List;
import java.util.Objects;

/**
 * @author saura
 *
 */
public class ResponseDto {

	public String id;

	public Object data;

	public List<String> errors;

	/**
	 * 
	 */
	public ResponseDto() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param data
	 * @param errors
	 */
	public ResponseDto(String id, Object data, List<String> errors) {
		super();
		this.id = id;
		this.data = data;
		this.errors = errors;
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

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, errors, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponseDto other = (ResponseDto) obj;
		return Objects.equals(data, other.data) && Objects.equals(errors, other.errors) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "ResponseDto [id=" + id + ", data=" + data + ", errors=" + errors + "]";
	}

}
