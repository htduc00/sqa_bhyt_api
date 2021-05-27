package web;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import web.controller.ConfigController;
import web.controller.ListController;
import web.controller.ReportController;
import web.model.*;
import web.repo.PhuongRepo;
import web.repo.QuanRepo;
import web.repo.ThanhphoRepo;
import web.repo.UserRepo;

@WebMvcTest({ListController.class})
class ListControllerTests{
	
   @Autowired
   private MockMvc mockMvc;
   @MockBean
   private UserRepo userRepo;
   @MockBean
   private ThanhphoRepo thanhphoRepo;
   @MockBean
   private QuanRepo quanRepo;
   @MockBean
   private PhuongRepo phuongRepo;
   
	@Test
	public void getListTP() throws Exception{
	   Thanhpho tp1 = new Thanhpho(1,"Ha Noi");
	   Thanhpho tp2 = new Thanhpho(2,"Da Nang");
	   Thanhpho tp3 = new Thanhpho(3,"Hai Phong");
	   Thanhpho tp4 = new Thanhpho(4,"Da Lat");
	   Thanhpho tp5 = new Thanhpho(5,"Can Tho");
	   Thanhpho tp6 = new Thanhpho(6,"Ninh Binh");
		List<Thanhpho> records = new ArrayList<>(Arrays.asList(tp1,tp2,tp3,tp4,tp5,tp6));
		Mockito.when(thanhphoRepo.findAll()).thenReturn(records);
		mockMvc.perform(MockMvcRequestBuilders
	            .get("/list/Thanhpho")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", hasSize(6)))
	            .andExpect(jsonPath("$[0].name", is("Ha Noi")));
	}
	@Test
	public void getListQuanByTP() throws Exception{
		Quan q1 = new Quan(1,"Hoang Mai");
		Quan q2 = new Quan(2,"Cau Giay");
		Quan q3 = new Quan(3,"Hai Ba Trung");
		Quan q4 = new Quan(4,"Ba Vi");
		List<Quan> records = new ArrayList<>(Arrays.asList(q1,q2,q3,q4));
		Thanhpho tp = new Thanhpho(1,"Ha Noi");
		Mockito.when(thanhphoRepo.findById(tp.getId())).thenReturn(Optional.of(tp));
		Mockito.when(quanRepo.findByThanhpho(tp)).thenReturn(records);
		mockMvc.perform(MockMvcRequestBuilders
		           .get("/list/Quan/Thanhpho=1")
		           .contentType(MediaType.APPLICATION_JSON))
		           .andExpect(status().isOk())
		           .andExpect(jsonPath("$", hasSize(4)))
		           .andExpect(jsonPath("$[0].name", is("Hoang Mai")));

	}
	
	@Test
	public void getListPhuongByQuan() throws Exception{
		Phuong p1 = new Phuong(1,"Dai Kim");
		Phuong p2 = new Phuong(2,"Hoang Liet");
		Phuong p3 = new Phuong(3,"Dinh Cong");
		Phuong p4 = new Phuong(4,"Hoang Van Thu");
		Phuong p5 = new Phuong(5,"Tan Mai");
		Phuong p6 = new Phuong(6,"Linh Nam");
		Phuong p7 = new Phuong(7,"Giap Bat");
		List<Phuong> records = new ArrayList<>(Arrays.asList(p1,p2,p3,p4,p5,p6,p7));
		Quan q = new Quan(1,"Hoang Mai");
		Mockito.when(quanRepo.findById(q.getId())).thenReturn(Optional.of(q));	
		Mockito.when(phuongRepo.findByQuan(q)).thenReturn(records);
		mockMvc.perform(MockMvcRequestBuilders
	            .get("/list/Phuong/Quan=1")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", hasSize(7)))
	            .andExpect(jsonPath("$[0].name", is("Dai Kim")));
	}
	
	@Test
	// 4 id case: 
//		== 0, == 0, == 0
//		!= 0, == 0, == 0
//		!= 0, != 0, == 0
//		!= 0, != 0, != 0
	public void getListByAllCase1() throws Exception{
		User u1 = new User("001099000125","ABC");
		User u2 = new User("001099000185","Duc Hoang");
		User u3 = new User("001099000188","Hoang Trung Duc");
		User u4 = new User("002100325109","AJSKHUQKEY");
		
		Thanhpho tp = new Thanhpho(1,"Ha Noi");
		Quan q = new Quan(1,"Hoang Mai");
		Phuong p = new Phuong(1,"Dai Kim");
		Mockito.when(userRepo.findAll()).thenReturn(Arrays.asList(u1,u2,u3,u4));
		Mockito.when(thanhphoRepo.findById(tp.getId())).thenReturn(Optional.of(tp));
		Mockito.when(quanRepo.findById(q.getId())).thenReturn(Optional.of(q));	
		Mockito.when(phuongRepo.findById(p.getId())).thenReturn(Optional.of(p));
		
		Mockito.when(userRepo.findByThanhpho(tp)).thenReturn(Arrays.asList(u1,u2,u3,u4));
		Mockito.when(userRepo.findByQuan(q)).thenReturn(Arrays.asList(u1,u2,u3,u4));
		Mockito.when(userRepo.findByPhuong(p)).thenReturn(Arrays.asList(u1,u3));
		
		mockMvc.perform(MockMvcRequestBuilders
	            .get("/list/join/Thanhpho=0/Quan=0/Phuong=0")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", hasSize(4)))
	            .andExpect(jsonPath("$[0].name", is("ABC")));
		
		
	}
	@Test
	public void getListByAllCase2() throws Exception{
		User u1 = new User("001099000125","ABC");
		User u2 = new User("001099000185","Duc Hoang");
		User u3 = new User("001099000188","Hoang Trung Duc");
		User u4 = new User("002100325109","AJSKHUQKEY");
		
		Thanhpho tp = new Thanhpho(1,"Ha Noi");
		Quan q = new Quan(1,"Hoang Mai");
		Phuong p = new Phuong(1,"Dai Kim");
		Mockito.when(userRepo.findAll()).thenReturn(Arrays.asList(u1,u2,u3,u4));
		Mockito.when(thanhphoRepo.findById(tp.getId())).thenReturn(Optional.of(tp));
		Mockito.when(quanRepo.findById(q.getId())).thenReturn(Optional.of(q));	
		Mockito.when(phuongRepo.findById(p.getId())).thenReturn(Optional.of(p));
		
		Mockito.when(userRepo.findByThanhpho(tp)).thenReturn(Arrays.asList(u1,u2,u3,u4));
		Mockito.when(userRepo.findByQuan(q)).thenReturn(Arrays.asList(u1,u2,u3,u4));
		Mockito.when(userRepo.findByPhuong(p)).thenReturn(Arrays.asList(u1,u3));
		
		mockMvc.perform(MockMvcRequestBuilders
	            .get("/list/join/Thanhpho=1/Quan=0/Phuong=0")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", hasSize(4)))
	            .andExpect(jsonPath("$[0].name", is("ABC")));
		
		
	}
	@Test
	public void getListByAllCase3() throws Exception{
		User u1 = new User("001099000125","ABC");
		User u2 = new User("001099000185","Duc Hoang");
		User u3 = new User("001099000188","Hoang Trung Duc");
		User u4 = new User("002100325109","AJSKHUQKEY");
		
		Thanhpho tp = new Thanhpho(1,"Ha Noi");
		Quan q = new Quan(1,"Hoang Mai");
		Phuong p = new Phuong(1,"Dai Kim");
		Mockito.when(userRepo.findAll()).thenReturn(Arrays.asList(u1,u2,u3,u4));
		Mockito.when(thanhphoRepo.findById(tp.getId())).thenReturn(Optional.of(tp));
		Mockito.when(quanRepo.findById(q.getId())).thenReturn(Optional.of(q));	
		Mockito.when(phuongRepo.findById(p.getId())).thenReturn(Optional.of(p));
		
		Mockito.when(userRepo.findByThanhpho(tp)).thenReturn(Arrays.asList(u1,u2,u3,u4));
		Mockito.when(userRepo.findByQuan(q)).thenReturn(Arrays.asList(u1,u2,u3,u4));
		Mockito.when(userRepo.findByPhuong(p)).thenReturn(Arrays.asList(u1,u3));
		
		mockMvc.perform(MockMvcRequestBuilders
	            .get("/list/join/Thanhpho=1/Quan=1/Phuong=0")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", hasSize(4)))
	            .andExpect(jsonPath("$[0].name", is("ABC")));
		
		
	}
	@Test
	public void getListByAllCase4() throws Exception{
		User u1 = new User("001099000125","ABC");
		User u2 = new User("001099000185","Duc Hoang");
		User u3 = new User("001099000188","Hoang Trung Duc");
		User u4 = new User("002100325109","AJSKHUQKEY");
		
		Thanhpho tp = new Thanhpho(1,"Ha Noi");
		Quan q = new Quan(1,"Hoang Mai");
		Phuong p = new Phuong(1,"Dai Kim");
		Mockito.when(userRepo.findAll()).thenReturn(Arrays.asList(u1,u2,u3,u4));
		Mockito.when(thanhphoRepo.findById(tp.getId())).thenReturn(Optional.of(tp));
		Mockito.when(quanRepo.findById(q.getId())).thenReturn(Optional.of(q));	
		Mockito.when(phuongRepo.findById(p.getId())).thenReturn(Optional.of(p));
		
		Mockito.when(userRepo.findByThanhpho(tp)).thenReturn(Arrays.asList(u1,u2,u3,u4));
		Mockito.when(userRepo.findByQuan(q)).thenReturn(Arrays.asList(u1,u2,u3,u4));
		Mockito.when(userRepo.findByPhuong(p)).thenReturn(Arrays.asList(u1,u3));
		
		mockMvc.perform(MockMvcRequestBuilders
	            .get("/list/join/Thanhpho=1/Quan=1/Phuong=1")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", hasSize(2)))
	            .andExpect(jsonPath("$[0].name", is("ABC")));
		
		
	}
}
