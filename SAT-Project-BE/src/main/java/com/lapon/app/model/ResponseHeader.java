package com.lapon.app.model;

public class ResponseHeader {
	private String code;
	private String desc;

	public ResponseHeader() {
	}

	public ResponseHeader(String code, String desc) {
		super();
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
