package com.lapon.config;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Component
public class StringToDateConverter implements Converter<String, Date> {

   protected static final SimpleDateFormat formater1 = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
   protected static final SimpleDateFormat formater2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.US);

   public Date convert(String src) {
      Date date = null;
      if (src == null) {
         return null;
      }
      try {
         date = formater1.parse(src);
      } catch (Exception e) {
         date = null;
      }
      try {
         if (date == null) {
            date = formater2.parse(src);
         }
      } catch (Exception e2) {
         date = null;
      }

      return date;
   }
}