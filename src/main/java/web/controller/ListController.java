package web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.model.Phuong;
import web.model.Quan;
import web.model.Thanhpho;
import web.model.User;
import web.repo.PhuongRepo;
import web.repo.QuanRepo;
import web.repo.ThanhphoRepo;
import web.repo.UserRepo;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/list")
public class ListController {
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ThanhphoRepo thanhphoRepo;
	@Autowired
	private QuanRepo quanRepo;
	@Autowired
	private PhuongRepo phuongRepo;
	
	
	@GetMapping("/Thanhpho")
	public List<Thanhpho> getAllTP(){
		List<Thanhpho> list = thanhphoRepo.findAll();
		return list;
	}
	@GetMapping("/Quan/Thanhpho={id}")
	public List<Quan> getAllByTP(@PathVariable int id){
		if(id==0)
			return null;
		Thanhpho tp = thanhphoRepo.findById(id).get();
		List<Quan> list = quanRepo.findByThanhpho(tp);
		return list;
	}
	@GetMapping("/Phuong/Quan={id}")
	public List<Phuong> getByQ(@PathVariable int id){
		if(id==0)
			return null;
		Quan quan = quanRepo.findById(id).get();
		List<Phuong> list = phuongRepo.findByQuan(quan);
		return list;
	}
	
	@GetMapping("/join/Thanhpho={id}/Quan={id1}/Phuong={id2}")
	public List<User> getByTP(@PathVariable int id ,@PathVariable int id1,@PathVariable int id2){
		List<User> list = new ArrayList<User>();
		if(id == 0 && id1 == 0 && id2 == 0 )
			list= userRepo.findAll();
		else if( id!= 0 && id1 == 0 && id2 == 0 ) {
			Thanhpho tp = thanhphoRepo.findById(id).get();
			list = userRepo.findByThanhpho(tp);
		}
		else if(id!= 0 && id1 !=0 && id2 ==0) {
			Quan quan = quanRepo.findById(id1).get();
			list = userRepo.findByQuan(quan);
		}
		else if(id!= 0 && id1 !=0 && id2 !=0) {
			Phuong phuong = phuongRepo.findById(id2).get();
			list = userRepo.findByPhuong(phuong);
		}
		return list;
	}
//	@GetMapping("/join/Phuong/{id}")
//	public List<User> getByP(@PathVariable int id){
//		Phuong p = phuongRepo.findById(id).get();
//		List<User> list= userRepo.findAllByP(p);
//		return list;
//	}
//	@GetMapping("/join/Quan/{id}")
//	public List<User> getByQ(@PathVariable int id){
//		Quan q = quanRepo.findById(id).get();
//		List<User> list= userRepo.findAllByQ(q);
//		
//		return list;
//	}
//	@GetMapping("/join/hospital={id}/")
//	public List<User> getByTPQP(@PathVariable int id ){
//		return null;
//	}
}
