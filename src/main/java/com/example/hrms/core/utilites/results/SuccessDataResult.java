package com.example.hrms.core.utilites.results;



public class SuccessDataResult<T> extends DataResult<T>{

	public SuccessDataResult(T data, String message) {
		super(data, true,message);
		
	}
//başarılı olması durumunda  true bilgisini göndermiş olduk
	public SuccessDataResult(T data) {
		super(data, true);
	}
	
//data döndürmek istemiyorum
	public SuccessDataResult(String message) {
		super(null,true,message);
	}
	//null ve true bilgisi gösterdim
	public SuccessDataResult() {
		super(null,true);
	}
}
