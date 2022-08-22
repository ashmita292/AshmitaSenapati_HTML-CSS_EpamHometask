package com.cts.AuditSeverity.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 *  QuestionsEntity POJO Class
 *
 */

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Generated
public class QuestionsEntity {

	/**
	 * Stores the QuestionId
	 */
	private Integer questionId;
	/**
	 * Stores the auditType
	 */
	private String auditType;
	/**
	 * Stores the question
	 */
	private String question;
	/**
	 * Stores the answers/response of the question
	 */
	private String response;
	
}
