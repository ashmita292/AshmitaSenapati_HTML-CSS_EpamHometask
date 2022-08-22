package com.cognizant.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.feignclient.AuthClient;
import com.cognizant.model.QuestionsEntity;
import com.cognizant.pojo.AuditType;
import com.cognizant.service.ITokenService;
import com.cognizant.service.QuestionsServiceImpl;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * This class is handling all the end points for Audit Checklist microservice. 
 * This controller has mappings as-
 * 			getmapping-getChecklist()
 *
 */
@CrossOrigin(origins = "*")
@RestController 
@Slf4j
@RequestMapping("/audit-checklist")
public class AuditCheckListController {

	@Autowired
	AuthClient authClient;
	
	
	@Autowired
	ITokenService tokenService;
	
	@Autowired
	Environment env;
	
	@Autowired
	QuestionsServiceImpl questionsService;
	
	/**
	 * 
	 * @param token
	 * @param auditType
	 * @return responseEntity - questionsList
	 */
	@GetMapping("/getChecklist")
	public ResponseEntity<?> getChecklist(@RequestHeader(name = "Authorization",required = true)String token,@RequestParam AuditType auditType){
		
		List<QuestionsEntity> questionsList = new ArrayList<>();
		ResponseEntity<?> responseEntity;
			questionsList = questionsService.getQuestions(auditType.getAuditType());
			responseEntity = new ResponseEntity<List<QuestionsEntity>>(questionsList,HttpStatus.OK);
			log.debug(env.getProperty("string.res"),responseEntity);
			log.info(env.getProperty("string.end"));
			return responseEntity;
		
	}
	
		
}
