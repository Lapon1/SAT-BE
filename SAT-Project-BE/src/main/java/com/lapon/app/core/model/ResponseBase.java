package com.lapon.app.core.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ResponseBase implements Serializable {
  @JsonIgnore
  private static final long serialVersionUID = -4549940090380658147L;
  private ResponseHeader header;
  
  public ResponseHeader getHeader() {
    return header;
  }
  public void setHeader(ResponseHeader header) {
    this.header = header;
  }

}
