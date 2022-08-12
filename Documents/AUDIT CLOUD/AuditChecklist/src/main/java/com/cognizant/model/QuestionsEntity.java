package com.cognizant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**

 * @version 1.8
 * This class is an entity which we will be storing in the database.
 *  
 */

//@Data
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name="AuditQuestions")
public class QuestionsEntity {
	/**
	 * This will be the question id for the questions 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="questionId")
	private Integer questionId;
	/**
	 * This will be the auditType for the questions 
	 */
	@Column(name="auditType")
	private String auditType;
	/**
	 * This will be the questions 
	 */
	@Column(name="questions")
	private String question;
	/**
	 * This will be the response for the question
	 */
	@Column(name="response")
	private String response;
	
	public QuestionsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuestionsEntity(Integer questionId, String auditType, String question, String response) {
		super();
		this.questionId = questionId;
		this.auditType = auditType;
		this.question = question;
		this.response = response;
	}
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public String getAuditType() {
		return auditType;
	}
	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	
	
}
