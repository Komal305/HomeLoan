package com.cg.homeLoan.Exception;

public class CalculatorException extends Exception {

	private static final long serialVersionUID = -1178473179850029571L;
	
	public CalculatorException() {
		super();
		
	}

	public CalculatorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public CalculatorException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public CalculatorException(String message) {
		super(message);
	}

	public CalculatorException(Throwable cause) {
		super(cause);
		
	}

}
