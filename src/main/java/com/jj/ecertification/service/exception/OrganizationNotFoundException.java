package com.jj.ecertification.service.exception;

public class OrganizationNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -5461137596588305781L;

	public OrganizationNotFoundException(String msg) {
		super(msg);
	}
}
