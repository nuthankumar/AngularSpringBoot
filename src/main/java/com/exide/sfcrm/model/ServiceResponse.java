/**
 * 
 */
package com.exide.sfcrm.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author saurabhp
 *
 */
public class ServiceResponse <T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private Boolean success = true;
    private String message;
    private String errorMsg;
    private T data;
    private Integer count;
    private List<String> errorList;
    
    
	/**
	 * @return the success.
	 */
	public Boolean getSuccess() {
		return this.success;
	}
	/**
	 * @param success the success to set.
	 */
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	/**
	 * @return the message.
	 */
	public String getMessage() {
		return this.message;
	}
	/**
	 * @param message the message to set.
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the errorMsg.
	 */
	public String getErrorMsg() {
		return this.errorMsg;
	}
	/**
	 * @param errorMsg the errorMsg to set.
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	/**
	 * @return the data.
	 */
	public T getData() {
		return this.data;
	}
	/**
	 * @param data the data to set.
	 */
	public void setData(T data) {
		this.data = data;
	}
	/**
	 * @return the count.
	 */
	public Integer getCount() {
		return this.count;
	}
	/**
	 * @param count the count to set.
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
	/**
	 * @return the errorList.
	 */
	public List<String> getErrorList() {
		return this.errorList;
	}
	/**
	 * @param errorList the errorList to set.
	 */
	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}
    
}


