package com.lapon.app.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ResponseHeader implements java.io.Serializable {
   @JsonIgnore
   private static final long serialVersionUID = 8054547085063979836L;
   
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
