package com.situ.mall.common;

import java.io.Serializable;

public class ServerResponse<T> implements Serializable{
	// 当前状态(程序员判断状态):成功，失败，未登陆，没有权限
	private Integer status;
	
	// 描述信息(主要是给用户看的提示信息)
	private String message;
	
	// 后台返回给前端的数据
	private T data;

	public ServerResponse() {
		super();
	}
	
	public ServerResponse(Integer status) {
		super();
		this.status = status;
	}

	public ServerResponse(Integer status, T data) {
		super();
		this.status = status;
		this.data = data;
	}

	public ServerResponse(Integer status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public ServerResponse(Integer status, String message, T data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}
	
	// 只是告诉前台：成功这个状态
	public static<T> ServerResponse<T> createSuccess(){
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
	}
	// 只是告诉前台：status,msg
		public static <T> ServerResponse<T> createSuccess(String msg) {
			return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), msg);
		}

		// 只是告诉前台：status,msg,data
		public static <T> ServerResponse<T> createSuccess(String msg, T data) {
			return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), msg, data);
		}

		// 只是告诉前台：失败这个状态
		public static <T> ServerResponse<T> createError() {
			return new ServerResponse<>(ResponseCode.ERROR.getCode());
		}

		// 只是告诉前台：status,msg
		public static <T> ServerResponse<T> createError(String msg) {
			return new ServerResponse<>(ResponseCode.ERROR.getCode(), msg);
		}

		// 只是告诉前台：status,msg,data
		public static <T> ServerResponse<T> createError(String msg, T data) {
			return new ServerResponse<>(ResponseCode.ERROR.getCode(), msg, data);
		}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ServerResponse [status=" + status + ", message=" + message + ", data=" + data + "]";
	}
	
	
	
	
	
	
}
