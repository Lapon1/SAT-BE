package com.lapon.constant;

public interface ReponseConstant {

	public static enum Response {
		CODE200("Success"), CODE1001("พบปัญหาในการทำงาน"), CODE1005("พบปัญหาในการค้นหาข้อม฿ล");

		private final String value;

		private Response(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}
	};

}
