package web;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import web.controller.ConfigController;
import web.model.*;
import web.repo.GroupDetailRepo;
import web.repo.GroupRepo;
import web.repo.PaymentRepo;
import web.repo.SalaryRepo;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ConfigControllerTests {
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
    private ObjectMapper mapper;
	
//	@MockBean
//	private ConfigController configController;
	
	@Autowired
	private SalaryRepo salaryRepo;
	
	@Autowired
	private PaymentRepo paymentRepo;
	
	@Autowired
	private GroupDetailRepo groupDetailRepo;
	
	@Autowired
	private GroupRepo groupRepo;  
	
	
	@Test
	public void test_get_group_details() throws Exception{
//		GroupDetail g1 = new GroupDetail(1);
//		GroupDetail g2 = new GroupDetail(2);
//		Mockito.when(configController.getGroupDetails(1)).thenReturn(Arrays.asList(g1,g2));
		mockMvc.perform(MockMvcRequestBuilders
	            .get("/config/group_details/group=1")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", hasSize(2)));
	}
	@Test
	public void test_get_group_detail() throws Exception{
//		GroupDetail g1 = new GroupDetail(22);
//		g1.setDes("Hoc sinh, sinh vien");
//		Mockito.when(configController.getGroupDetail(22)).thenReturn(g1);
		mockMvc.perform(MockMvcRequestBuilders
	            .get("/config/group_detail/22")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", notNullValue()))
	            .andExpect(jsonPath("$.des", is("Học sinh, sinh viên")));
	}
	
	@Test
	public void test_get_salary() throws Exception{
//		Salary s = new Salary(1,"Tien luong co so", 1490000);
//		Mockito.when(configController.getSalary(1)).thenReturn(s);
		mockMvc.perform(MockMvcRequestBuilders
	            .get("/config/salary/1")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", notNullValue()))
	            .andExpect(jsonPath("$.des", is("Tiền lương cơ sở")))
				.andExpect(jsonPath("$.value", is(2590000)));
	}
	@Test 
	public void test_update_salary_success() throws Exception{
		Salary s = new Salary(1490000);
		//Mockito.when(configController.updateSalary(s, 1)).thenReturn(s);
		mockMvc.perform(MockMvcRequestBuilders
	            .put("/config/salary/{id}",1)
	            .content(mapper.writeValueAsString(s))
	            .contentType(MediaType.APPLICATION_JSON)
	            .accept(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk());
		Optional<Salary> salary = salaryRepo.findById(1);
		assertNotNull(salary);
		assertEquals(salary.get().getValue(),1490000);
		
	}
	@Test 
	public void test_update_payment_success() throws Exception {
		Payment p = new Payment(Float.parseFloat("4.6"), null);
//		Mockito.when(configController.updatePayment(p, 1)).thenReturn(p);
		mockMvc.perform(MockMvcRequestBuilders
	            .put("/config/payment/{id}",1)
	            .content(mapper.writeValueAsString(p))
	            .contentType(MediaType.APPLICATION_JSON)
	            .accept(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk());
		
		Optional<Payment> payment = paymentRepo.findById(1);
		assertNotNull(payment);
		assertEquals(new Float(payment.get().getCost()), new Float(4.6));
	}
}
