package com.ardaatay.hrms.core.utilities.verification;

public class EmailVerification implements Verification {
	
	@Override
	public Boolean run(String code) {
		return true;
	}
}
