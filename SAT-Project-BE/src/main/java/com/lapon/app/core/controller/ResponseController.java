package com.lapon.app.core.controller;

import java.util.List;

import com.lapon.app.core.model.ResponseHeader;
import com.lapon.constant.ReponseConstant;

public class ResponseController {

	protected <T> T testGeneric(T data) {
		return data;
	}

	protected <T> List testGeneric2(List<T> data) {
		return data;
	}

	protected ResponseHeader initHeaderSuccess(final Object data) {
		if (data != null) {
			return initHeader(ReponseConstant.Response.CODE200, null);
		} else {
			return initHeader(ReponseConstant.Response.CODE1001, null);
		}
	}

	protected ResponseHeader initHeader(ReponseConstant.Response resp, String text) {
		String code = resp.name();
		if (code.startsWith("CODE")) {
			code = code.substring(2);
		}
		ResponseHeader header = new ResponseHeader();
		header.setCode(code);
		header.setDesc(text);
		if (text!=null) {
			header.setDesc(resp.getValue());
		}
		return null;

	}

}
