package com.cts.AuditSeverity.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * 
 * AuditRequest POJO class
 *
 */
//@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuditRequest {

	/**
	 * Stores the Project Name
	 */
	private String projectName;
	/**
	 * Stores project Manager Name
	 */
	private String projectManagerName;
	/**
	 * Stores Application Owner Name
	 */
	private String applicationOwnerName;
	/**
	 * Stores the Audit Details of the project
	 */
	private AuditDetails auditDetails;
	
}
