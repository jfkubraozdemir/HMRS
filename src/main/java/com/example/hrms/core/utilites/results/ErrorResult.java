package com.example.hrms.core.utilites.results;

public class ErrorResult extends Result {
	//işlem hatalı ama mesaj yok
    public ErrorResult() {
               super(false)	;
                              }
    //mesajı yolladım
    public ErrorResult(String message) {
  	  super(false,message);
    }
}
