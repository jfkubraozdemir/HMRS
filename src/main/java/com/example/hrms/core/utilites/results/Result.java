package com.example.hrms.core.utilites.results;

public class Result {
	private boolean success;
	//işlem bilgisi
		private String message;
	//sonuç mesajı(sadece true false döndürek istedim)

		public Result(boolean success) {
			this.success= success;
		}
		
		public Result(boolean success, String message) {
			this(success);
			this.message=message;
		} 
		public boolean isSuccess() {
			return this.success;
		}
		
		public String isMessage() {
			return  this.message;
		}
}
