package com.example.hrms.core.utilites.results;

public class DataResult<T> extends Result {
	//mesajları yazmak yerine extends ettim

		private T data;
		
		public DataResult(T data ,  boolean success, String message) {
			super(success, message);
			this.data=data;
		}

		//benim data da döndürmem de gerekli (ürün , categori... veri tipi)
		//	public DataResult(T data ,  boolean success, String message) { data yı base sınıfa gönderdim

		public DataResult(T data ,  boolean success) {
			super(success);
			this.data=data;
		}
		//datayı okumak için getter
		public T getData() {
			return this.data;

}
}
