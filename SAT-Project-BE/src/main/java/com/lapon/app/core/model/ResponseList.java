package com.lapon.app.core.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author staff
 */
public class ResponseList<T> extends ResponseBase implements Serializable {
   @JsonIgnore
   private static final long serialVersionUID = 470266841345782890L;
   private List<T> data;

   public ResponseList() {

   }

   public ResponseList(ResponseHeader header, List<T> data) {
      this.setHeader(header);
      this.setData(data);
   }

   public List<T> getData() {
      return data;
   }

   public void setData(List<T> data) {
      this.data = data;
   }

}
