package web;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import web.controller.ReportController;
import web.model.*;


@WebMvcTest({ReportController.class})
public class ReportControllerTests {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ReportController reportController;
		
	
	@Test
	//case 1: tp_id = 0 , filter = 1
	public void test_new_join_case1() throws Exception{
		User u1 = new User("001099000125","ABC");
		User u2 = new User("001099000185","Duc Hoang");
		User u3 = new User("001099000188","Hoang Trung Duc");
		User u4 = new User("002100325109","AJSKHUQKEY");
		
		Mockito.when(reportController.newJoin(0,1)).thenReturn(new ArrayList<User>());
		mockMvc.perform(MockMvcRequestBuilders
	            .get("/report/new_join/TP=0/filter=1")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", hasSize(0)));
		
	}
	@Test
	//case 2: tp_id = 0 , filter = 2
	public void test_new_join_case2() throws Exception{
		User u1 = new User("001099000125","ABC");
		User u2 = new User("001099000185","Duc Hoang");
		User u3 = new User("001099000188","Hoang Trung Duc");
		User u4 = new User("002100325109","AJSKHUQKEY");
		
		Mockito.when(reportController.newJoin(0,2)).thenReturn(Arrays.asList(u1,u2,u3));
		mockMvc.perform(MockMvcRequestBuilders
	            .get("/report/new_join/TP=0/filter=2")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", hasSize(3)))
	            .andExpect(jsonPath("$[0].name", is("ABC")));
		
	}
	@Test
	//case 3: tp_id != 0 , filter = 1
	public void test_new_join_case3() throws Exception{
		User u1 = new User("001099000125","ABC");
		User u2 = new User("001099000185","Duc Hoang");
		User u3 = new User("001099000188","Hoang Trung Duc");
		User u4 = new User("002100325109","AJSKHUQKEY");
		
		Mockito.when(reportController.newJoin(1,1)).thenReturn(new ArrayList<User>());
		mockMvc.perform(MockMvcRequestBuilders
	            .get("/report/new_join/TP=1/filter=1")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", hasSize(0)));
		
	}
	@Test
	//case 4: tp_id != 0 , filter = 2
	public void test_new_join_case4() throws Exception{
		User u1 = new User("001099000125","ABC");
		User u2 = new User("001099000185","Duc Hoang");
		User u3 = new User("001099000188","Hoang Trung Duc");
		User u4 = new User("002100325109","AJSKHUQKEY");
		
		Mockito.when(reportController.newJoin(1,2)).thenReturn(Arrays.asList(u1,u2,u3));
		mockMvc.perform(MockMvcRequestBuilders
	            .get("/report/new_join/TP=1/filter=2")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", hasSize(3)))
	            .andExpect(jsonPath("$[0].name", is("ABC")));
		
	}
	@Test
	//case 1: tpid = 0 , year = 2021 
	public void test_list_paid_case1() throws Exception{
		User u1 = new User("001099000125","ABC");
		User u2 = new User("001099000185","Duc Hoang");
		User u3 = new User("001099000188","Hoang Trung Duc");
		User u4 = new User("002100325109","AJSKHUQKEY");
		List[] list = {Arrays.asList(u1,u2), Arrays.asList(u3,u4)}; 
		Mockito.when(reportController.listPaid(0, 2021)).thenReturn(list);
		mockMvc.perform(MockMvcRequestBuilders
	            .get("/report/paid/TP=0/year=2021")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0][0].name", is("ABC")));
	}
	@Test
	//case 2: tpid = 1 , year = 2021 
	public void test_list_paid_case2() throws Exception{
		User u1 = new User("001099000125","ABC");
		User u2 = new User("001099000185","Duc Hoang");
		User u3 = new User("001099000188","Hoang Trung Duc");
		User u4 = new User("002100325109","AJSKHUQKEY");
		List[] list = {Arrays.asList(u1,u2), Arrays.asList(u3,u4)}; 
		Mockito.when(reportController.listPaid(1, 2021)).thenReturn(list);
		mockMvc.perform(MockMvcRequestBuilders
	            .get("/report/paid/TP=1/year=2021")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0][0].name", is("ABC")));
	}
	@Test
	//case 3: tpid = 1 , year = 2020 
	public void test_list_paid_case3() throws Exception{
		User u1 = new User("001099000125","ABC");
		User u2 = new User("001099000185","Duc Hoang");
		User u3 = new User("001099000188","Hoang Trung Duc");
		User u4 = new User("002100325109","AJSKHUQKEY");
		List[] list = {new ArrayList<User>(), Arrays.asList(u1,u2,u3,u4)}; 
		Mockito.when(reportController.listPaid(1, 2020)).thenReturn(list);
		mockMvc.perform(MockMvcRequestBuilders
	            .get("/report/paid/TP=1/year=2020")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[1][0].name", is("ABC")));
	}
	
	
	@Test
	// case 1: year = 2021, sort = A-Z (1)
	public void test_total_revenue_case1() throws Exception{
		Revenue r1 = new Revenue(new Thanhpho(1,"Ha Noi"), 2500000);
		Revenue r2 = new Revenue(new Thanhpho(2,"Da Nang"), 0); 
		Revenue r3 = new Revenue(new Thanhpho(3,"Hai Phong"), 0); 
		Revenue r4 = new Revenue(new Thanhpho(4,"Da Lat"), 0); 
		Revenue r5 = new Revenue(new Thanhpho(5,"Can Tho"), 0); 
		Revenue r6 = new Revenue(new Thanhpho(6,"Ninh Binh"), 0);
		
		Mockito.when(reportController.totalRevenue(2021, 1)).thenReturn(Arrays.asList(r5,r4,r2,r3,r1,r6));
		mockMvc.perform(MockMvcRequestBuilders
	            .get("/report/revenue/year=2021/sort=1")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", hasSize(6)))
				.andExpect(jsonPath("$[0].thanhpho.name", is("Can Tho")));
	}
	@Test
	// case 2: year = 2021, sort = top revenue (2)
	public void test_total_revenue_case2() throws Exception{
		Revenue r1 = new Revenue(new Thanhpho(1,"Ha Noi"), 2500000);
		Revenue r2 = new Revenue(new Thanhpho(2,"Da Nang"), 0); 
		Revenue r3 = new Revenue(new Thanhpho(3,"Hai Phong"), 0); 
		Revenue r4 = new Revenue(new Thanhpho(4,"Da Lat"), 0); 
		Revenue r5 = new Revenue(new Thanhpho(5,"Can Tho"), 0); 
		Revenue r6 = new Revenue(new Thanhpho(6,"Ninh Binh"), 0);
		
		Mockito.when(reportController.totalRevenue(2021, 2)).thenReturn(Arrays.asList(r1,r2,r3,r4,r5,r6));
		mockMvc.perform(MockMvcRequestBuilders
	            .get("/report/revenue/year=2021/sort=2")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", hasSize(6)))
				.andExpect(jsonPath("$[0].thanhpho.name", is("Ha Noi")));
	}
}
