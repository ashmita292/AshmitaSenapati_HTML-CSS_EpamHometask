package com.cognizant.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * This POJO class is used for Audit Type
 * 
 *
 */
//@Data
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class AuditType {

	String auditType;

	public AuditType(String auditType) {
		super();
		this.auditType = auditType;
	}

	public AuditType() {
		super();
	}

	public String getAuditType() {
		return auditType;
	}

	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}

}
