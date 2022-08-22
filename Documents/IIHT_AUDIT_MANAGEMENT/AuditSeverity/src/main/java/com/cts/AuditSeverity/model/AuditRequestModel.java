package com.cts.AuditSeverity.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Generated
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="auditrequest")
public class AuditRequestModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RequestId")
	private int requestId;
	
	@OneToOne(cascade = CascadeType.ALL)
	private AuditDetailModel auditDetail;
	
	@Column(name="ProjectName")
	@NotBlank(message="Project name cannot be blank")
	private String projectName;
	
	@Column(name="ManagerName")
	@NotBlank(message="Manager name cannot be blank")
	private String managerName;
	
	@Column(name="OwnerName")
	@NotBlank(message="Owner name cannot be blank")
	private String ownerName;
	
	
	
		
}