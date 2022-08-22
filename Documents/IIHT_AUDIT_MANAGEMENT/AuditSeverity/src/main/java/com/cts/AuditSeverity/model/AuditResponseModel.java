package com.cts.AuditSeverity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
//@NoArgsConstructor
@Generated
@Entity
@Table(name="auditresponse")
public class AuditResponseModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ResponseId")
	private int responseId;
	
	@Column(name="ExecutionStatus")
	private String executionStatus;
	
	@Column(name="ActionDuration")
	private String actionDuration;
	
	public AuditResponseModel(String projectExecutionStatus, String remedialActionDuration) {

		this.executionStatus = projectExecutionStatus;
		this.actionDuration = remedialActionDuration;
	}

	public AuditResponseModel() {
		super();
	}

	public int getResponseId() {
		return responseId;
	}

	public void setResponseId(int responseId) {
		this.responseId = responseId;
	}

	public String getExecutionStatus() {
		return executionStatus;
	}

	public void setExecutionStatus(String executionStatus) {
		this.executionStatus = executionStatus;
	}

	public String getActionDuration() {
		return actionDuration;
	}

	public void setActionDuration(String actionDuration) {
		this.actionDuration = actionDuration;
	}
	

	
	
}