package com.cts.AuditSeverity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.AuditSeverity.exception.InputsNotFoundException;
import com.cts.AuditSeverity.fiegnclient.AuthClient;
import com.cts.AuditSeverity.pojo.AuditRequest;
import com.cts.AuditSeverity.pojo.AuditResponse;
import com.cts.AuditSeverity.pojo.QuestionsEntity;
import com.cts.AuditSeverity.service.IAuditRequestResponse;
import com.cts.AuditSeverity.service.ITokenService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * This class is handling all the end points for Audit Checklist microservice.
 * This controller has mappings as-postmapping-auditSeverity()
 *
 */

@CrossOrigin(origins = "*")
@RestController
@Slf4j
@RequestMapping("/audit-severity")
public class SeverityController {

	@Autowired
	private IAuditRequestResponse service;

	@Autowired
	AuthClient authClient;

	@Autowired
	ITokenService tokenService;

	@Autowired
	Environment env;

	/**
	 * 
	 * @param token
	 * @param auditRequest
	 * @return ResponseEntity<Response>
	 */
	@PostMapping("/ProjectExecutionStatus")
	public ResponseEntity<?> auditSeverity(@RequestHeader(name = "Authorization", required = true) String token,
			@RequestBody AuditRequest auditRequest) {
		final int accNoAnswers = 3;
		int actualNoAnswers = 0;
		ResponseEntity<?> responseEntity = null;

		List<QuestionsEntity> questionsList = auditRequest.getAuditDetails().getAuditQuestions();

		if (tokenService.checkTokenValidity(token)) {
			if (auditRequest.getProjectName() == null || auditRequest.getProjectManagerName() == null
					|| auditRequest.getApplicationOwnerName() == null || auditRequest.getAuditDetails() == null) {
				throw new InputsNotFoundException("All fields are required!");
			} else {

				questionsList = auditRequest.getAuditDetails().getAuditQuestions();
				for (QuestionsEntity answer : questionsList) {
					if (answer.getResponse().equalsIgnoreCase("No")) {
						actualNoAnswers++;
					}
				}

				if (actualNoAnswers <= accNoAnswers) {
					responseEntity = new ResponseEntity<AuditResponse>(
							new AuditResponse(env.getProperty("project.status.green"),
									env.getProperty("remedial.action.no")),
							HttpStatus.OK);
					AuditResponse response = (AuditResponse) responseEntity.getBody();
					service.saveResponse(response);
				} else if (auditRequest.getAuditDetails().getAuditType().equalsIgnoreCase("Internal")) {
					responseEntity = new ResponseEntity<AuditResponse>(
							new AuditResponse(env.getProperty("project.status.red"),
									env.getProperty("remedial.action.yes.one")),
							HttpStatus.OK);
					AuditResponse response = (AuditResponse) responseEntity.getBody();
					service.saveResponse(response);
				}
				service.saveRequest(auditRequest);
				return responseEntity;
			}
		} else {
			log.error(env.getProperty("string.token.exp"));
			log.info(env.getProperty("string.end"));

			responseEntity = new ResponseEntity<String>(env.getProperty("string.token.exp"), HttpStatus.FORBIDDEN);
			return responseEntity;
		}
	}
}
