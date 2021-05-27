package web;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
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

@WebMvcTest(ConfigController.class)
public class ConfigControllerTests {
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
    private ObjectMapper mapper;
	
	@MockBean
	private ConfigController configController;
	
	
	@Test
	public void test_get_group_details() throws Exception{
		GroupDetail g1 = new GroupDetail(1);
		GroupDetail g2 = new GroupDetail(2);
		Mockito.when(configController.getGroupDetails(1)).thenReturn(Arrays.asList(g1,g2));
		mockMvc.perform(MockMvcRequestBuilders
	            .get("/config/group_details/group=1")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", hasSize(2)));
	}
	@Test
	public void test_get_group_detail() throws Exception{
		GroupDetail g1 = new GroupDetail(22);
		g1.setDes("Hoc sinh, sinh vien");
		Mockito.when(configController.getGroupDetail(22)).thenReturn(g1);
		mockMvc.perform(MockMvcRequestBuilders
	            .get("/config/group_detail/22")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", notNullValue()))
	            .andExpect(jsonPath("$.des", is("Hoc sinh, sinh vien")));
	}
	
	@Test
	public void test_get_salary() throws Exception{
		Salary s = new Salary(1,"Tien luong co so", 1490000);
		Mockito.when(configController.getSalary(1)).thenReturn(s);
		mockMvc.perform(MockMvcRequestBuilders
	            .get("/config/salary/1")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", notNullValue()))
	            .andExpect(jsonPath("$.des", is("Tien luong co so")))
				.andExpect(jsonPath("$.value", is(1490000)));
	}
	@Test 
	public void test_update_salary_success() throws Exception{
		Salary s = new Salary(1490000);
		Mockito.when(configController.updateSalary(s, 1)).thenReturn(s);
		mockMvc.perform(MockMvcRequestBuilders
	            .put("/config/salary/{id}",1)
	            .content(mapper.writeValueAsString(s))
	            .contentType(MediaType.APPLICATION_JSON)
	            .accept(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$.value", is(1490000)));
	}
	@Test 
	public void test_update_payment_success() throws Exception{
		Payment p = new Payment(Float.parseFloat("4.6"), null);
		Mockito.when(configController.updatePayment(p, 1)).thenReturn(p);
		mockMvc.perform(MockMvcRequestBuilders
	            .put("/config/payment/{id}",1)
	            .content(mapper.writeValueAsString(p))
	            .contentType(MediaType.APPLICATION_JSON)
	            .accept(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$.cost", is(4.6)));
	}
}