package com.stoom.challenge.addresschallengeapi.exception;

import java.util.Date;
import java.util.List;

public class ValidationError extends ErrorDetails {
	
	private List<String> validationErrors;

	public ValidationError(Date timestamp, String message, String details, List<String> ValidationErrors) {
		super(timestamp, message, details);
		this.setValidationErrors(ValidationErrors);
	}

	public List<String> getValidationErrors() {
		return validationErrors;
	}

	public void setValidationErrors(List<String> validationErrors) {
		this.validationErrors = validationErrors;
	}
	
	

}
