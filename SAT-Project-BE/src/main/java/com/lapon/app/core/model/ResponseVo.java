package com.lapon.app.core.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author aon
 */

public class ResponseVo<T> extends ResponseBase implements Serializable {
   @JsonIgnore
   private static final long serialVersionUID = 5282106190451823196L;
   
   private T data;

   public ResponseVo() {

   }

   public ResponseVo(ResponseHeader header, T data) {
      this.setHeader(header);
      this.setData(data);
   }

   public T getData() {
      return data;
   }

   public void setData(T data) {
      this.data = data;
   }
}
