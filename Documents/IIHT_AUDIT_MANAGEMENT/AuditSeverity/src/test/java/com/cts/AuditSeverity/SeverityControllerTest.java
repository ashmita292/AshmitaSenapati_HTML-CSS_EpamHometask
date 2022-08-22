package com.cts.AuditSeverity;

import static org.junit.Assume.assumeTrue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.AuditSeverity.fiegnclient.AuthClient;
import com.cts.AuditSeverity.pojo.AuditDetails;
import com.cts.AuditSeverity.pojo.AuditRequest;
import com.cts.AuditSeverity.repository.RequestRepository;
import com.cts.AuditSeverity.service.AuditRequestResponseImpl;
import com.cts.AuditSeverity.service.ITokenService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SeverityControllerTest {

	@MockBean
	private AuditRequestResponseImpl service;
	@MockBean
	AuthClient authClient;
	@MockBean
	ITokenService tokenService;
	@MockBean
	RequestRepository requestRepository;
	@Autowired
	SeverityController severityController;

	@Autowired
	private MockMvc mvc;

	@Test
	public void testAuditSeverity() throws Exception {
		Mockito.when(tokenService.checkTokenValidity("token")).thenReturn(true);
		mvc.perform(MockMvcRequestBuilders.post("/ProjectExecutionStatus").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andReturn();

	}

	@Test
	public void testForActualNoAnswers() {
		int actualNoAnswers = 3;
		assumeTrue(isExpectedNO(actualNoAnswers));

	}

	private boolean isExpectedNO(int actualNoAnswers) {
		int accNoAnswers = 3;
		return accNoAnswers >= actualNoAnswers;
	}

	@Test
	public void testAuditSeverityTokenFails() {
		Mockito.when(tokenService.checkTokenValidity("token")).thenReturn(false);
		Assert.assertEquals(HttpStatus.FORBIDDEN,
				severityController
						.auditSeverity("token",
								new AuditRequest("P", "Q", "R", new AuditDetails("Internal", null, null)))
						.getStatusCode());

	}



	

}
