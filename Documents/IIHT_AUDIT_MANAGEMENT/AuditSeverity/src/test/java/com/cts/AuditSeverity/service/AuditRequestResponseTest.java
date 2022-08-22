package com.cts.AuditSeverity.service;



import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.AuditSeverity.model.AuditDetailModel;
import com.cts.AuditSeverity.model.AuditRequestModel;
import com.cts.AuditSeverity.model.AuditResponseModel;
import com.cts.AuditSeverity.pojo.AuditDetails;
import com.cts.AuditSeverity.pojo.AuditRequest;
import com.cts.AuditSeverity.pojo.AuditResponse;
import com.cts.AuditSeverity.repository.RequestRepository;
import com.cts.AuditSeverity.repository.ResponseRepository;
/**
 * 
 * 			Test class to test AuditRequestResponse
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=AuditRequestResponseImpl.class)

public class AuditRequestResponseTest {

	@Autowired
	AuditRequestResponseImpl auditRequestResponseImpl;
	@MockBean
	RequestRepository requestRepository;
	@MockBean
	ResponseRepository responseRepository;

	
	@Test
	public void saveRequestTest() {
		AuditRequest request = prepareAuditRequest();
		AuditRequestModel requestModel = prepareRequestModel();
		Mockito.when(requestRepository.save(Mockito.any())).thenReturn(requestModel);
		AuditRequestModel model=auditRequestResponseImpl.saveRequest(request);
		
		assertEquals(request.getApplicationOwnerName(), model.getOwnerName());
	}
	
	@Test
	public void saveResponseTest() {
		AuditResponse response = prepareAuditResponse();
		AuditResponseModel responseModel = prepareAuditResponseModel();
		Mockito.when(responseRepository.save(Mockito.any())).thenReturn(responseModel);
		AuditResponseModel model=auditRequestResponseImpl.saveResponse(response);
		assertEquals(response.getProjectExecutionStatus(), model.getExecutionStatus());
	} 
	
	private AuditRequestModel prepareRequestModel() {
		AuditRequestModel requestModel = new AuditRequestModel();
		requestModel.setAuditDetail(prepareAuditDetailModel());
		requestModel.setManagerName("Anne");
		requestModel.setOwnerName("Jon");
		requestModel.setProjectName("project");
		requestModel.setRequestId(1);
		
		return requestModel;
	}
	
	private AuditDetailModel prepareAuditDetailModel() {
		AuditDetailModel auditDetailModel = new AuditDetailModel();
		auditDetailModel.setAuditType("Internal");
		auditDetailModel.setAuditDate(new Date());
		return auditDetailModel;
	}
	
	private AuditDetails prepareAuditDetail() {
		AuditDetails auditDetails = new AuditDetails();
		auditDetails.setAuditType("Internal");
		auditDetails.setAuditDate(new Date());
		auditDetails.setAuditQuestions(new ArrayList<>());
		return auditDetails;
	}
	
	private AuditRequest prepareAuditRequest() {
		AuditRequest request = new AuditRequest();
		request.setAuditDetails(prepareAuditDetail());
		request.setApplicationOwnerName("Jon");
		request.setProjectManagerName("Anne");
		request.setProjectName("project");
		return request;
	}
	private AuditResponse prepareAuditResponse() {
		AuditResponse response = new AuditResponse();
		response.setAuditId(1);
		response.setProjectExecutionStatus("GREEN");
		response.setRemedialActionDuration("2weeks");
		return response;
	}
	private AuditResponseModel prepareAuditResponseModel() {
		AuditResponseModel responseModel = new AuditResponseModel();
		responseModel.setExecutionStatus("GREEN");
		responseModel.setActionDuration("2weeks");
		return responseModel;
	}
	
	
}
