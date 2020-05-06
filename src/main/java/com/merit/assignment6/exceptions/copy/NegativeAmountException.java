package com.merit.assignment6.exceptions.copy;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
 public class NegativeAmountException extends Exception {
	
	public NegativeAmountException(String msg) {
	super(msg);

}
}
