package com.cts.AuditSeverity.repository;



import static org.junit.Assert.assertEquals;

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
import com.cts.AuditSeverity.service.AuditRequestResponseImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RequestRepositoryTest {
	@Autowired
	AuditRequestResponseImpl service;
	
	@MockBean
	RequestRepository requestRepository;
	
	@Test
	public void saveRequestTest() {
		AuditRequestModel requestModel = prepareRequestModel();
		Mockito.when(requestRepository.save(Mockito.any())).thenReturn(requestModel);
		assertEquals("Jon", requestModel.getOwnerName());
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

}
