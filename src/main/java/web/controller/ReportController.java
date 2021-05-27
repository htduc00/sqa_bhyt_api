package web.controller;

import java.sql.Date;
import java.text.Collator;
import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.model.Bhyt;
import web.model.Bill;
import web.model.Revenue;
import web.model.Thanhpho;
import web.model.User;
import web.repo.BhytRepo;
import web.repo.BillRepo;
import web.repo.PaymentRepo;
import web.repo.SalaryRepo;
import web.repo.ThanhphoRepo;
import web.repo.UserRepo;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/report")
public class ReportController {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private BillRepo billRepo;
	
	@Autowired
	private BhytRepo bhytRepo;
	
	@Autowired
	private ThanhphoRepo thanhphoRepo;
	
	@GetMapping("/new_join/TP={id}/filter={index}")
	public List<User> newJoin(@PathVariable int id, @PathVariable int index){
		List<User> newJoin = new ArrayList<User>();
		int month = LocalDate.now().getMonthValue();
		int year = LocalDate.now().getYear();
		
		YearMonth yearMonth = YearMonth.of(year, month);
		Year year1 = Year.of(year); 
		Date fromDate;
		Date toDate;
		if(index == 1){
			fromDate = Date.valueOf(yearMonth.atDay(1));
			toDate = Date.valueOf(yearMonth.atEndOfMonth());
		}else{
			fromDate = Date.valueOf(year1.atDay(1));
			toDate = Date.valueOf(year1.atMonth(12).atEndOfMonth());
		}
		List<Bhyt> list = bhytRepo.findAllByJoinDate(fromDate, toDate);
		for(Bhyt item : list) {
			if(id != 0 && item.getUser().getThanhpho().getId() == id)
				newJoin.add(item.getUser());
			else if(id == 0 )
				newJoin.add(item.getUser());
		}
		return newJoin;
	}
	
	@GetMapping("/paid/TP={id}/year={year}")
	public List[] listPaid(@PathVariable int id, @PathVariable int year){
		List<User> dadong = new ArrayList<User>();
		List<User>  chuadong= new ArrayList<User>();
		
		List<Bill> listBill = billRepo.findByYear(year);
		List<User> listUser = new ArrayList<User>();
		if(id == 0) {
			listUser = userRepo.findAll();
		}else {
			listUser = userRepo.findByThanhpho(thanhphoRepo.findById(id).get());
		}
		for(Bill item:listBill) {
			if(id != 0 && item.getUser().getThanhpho().getId() == id) {
				dadong.add(item.getUser());
			}else if(id == 0) {
				dadong.add(item.getUser());
			}
		}
		for(User item : listUser) {
			if(!dadong.contains(item))
				chuadong.add(item);	
		}
		return new List[] { dadong ,chuadong };
	}
	@GetMapping("/revenue/year={year}/sort={value}")
	public List<Revenue> totalRevenue(@PathVariable int year, @PathVariable int value){
		List<Revenue> list  = new ArrayList<Revenue>();
		List<Thanhpho> listTp = thanhphoRepo.findAll();
		for(Thanhpho item : listTp) {
			long totalRevenue=0;
			List<Bill> listBill = billRepo.findByYear(year);
			//List<User> listUser = new ArrayList<>();
			for(Bill billItem : listBill) {
				if(billItem.getUser().getThanhpho().equals(item))
					//listUser.add(billItem.getUser());
					totalRevenue += billItem.getValue();
			}

//			for(User userItem : listUser) {
//						if( userItem.getGroupDetail().getId() == 1 || 
//							userItem.getGroupDetail().getId() == 3 || 
//							userItem.getGroupDetail().getId() == 7 ||
//							userItem.getGroupDetail().getId() == 6){
//							totalRevenue += userItem.getIncome()* 12 * paymentRepo.findByGroupDetail(userItem.getGroupDetail()).getCost()/100;
//						}else if(userItem.getGroupDetail().getId() == 2
//								|| userItem.getGroupDetail().getId() == 4 
//								|| userItem.getGroupDetail().getId() == 5 
//								|| (userItem.getGroupDetail().getId() >=8 && userItem.getGroupDetail().getId() <= 20)) {
//							totalRevenue += 12 * paymentRepo.findByGroupDetail(userItem.getGroupDetail()).getCost()/100 
//									* salaryRepo.findById(1).get().getValue();
//						}else if(userItem.getGroupDetail().getId() >= 21 && userItem.getGroupDetail().getId() <=23) {
//							totalRevenue += 12 * paymentRepo.findByGroupDetail(userItem.getGroupDetail()).getCost()/100 
//									* (100-userItem.getGroupDetail().getSupport())/100
//									* salaryRepo.findById(1).get().getValue();
//						}else {
//							List<Bhyt> listFamily = bhytRepo.findByFamily(userItem.getBhyt().getFamily());
//							String[] familyCost = paymentRepo.findByGroupDetail(userItem.getGroupDetail()).getFamilyCost().split(",");
//							long one = (long) paymentRepo.findByGroupDetail(userItem.getGroupDetail()).getCost()/100
//									*salaryRepo.findById(1).get().getValue();
//							totalRevenue += one;
//							int index = 0;
//							for(Bhyt bhytItem : listFamily) {
//								totalRevenue += one * Integer.parseInt(familyCost[index])/100;
//								if(index <= 2)
//									index ++;
//							}
//						}
//				}
			Revenue revenue = new Revenue(item,totalRevenue);
			list.add(revenue);
		}
		if(value == 1) {
			List<String> x = new ArrayList<>();
			for(Revenue item : list) {
				x.add(item.getThanhpho().getName());
			}
			Collator collate = Collator.getInstance(new Locale("vi"));
			Collections.sort(x, collate);
			List<Revenue> y = new ArrayList<>();
			for(String item : x) {
				for(Revenue item1 : list) {
					if(item.equalsIgnoreCase(item1.getThanhpho().getName())){
						y.add(item1);
						break;
					}
				}
			}
			return y;
		}else{
			  Collections.sort(list, new Comparator<Revenue>() {
			      @Override
			      public int compare(final Revenue r1, final Revenue r2) {
			          return (int)(r2.getRevanue() - r1.getRevanue());
			      }
			  });
			  return list;
		}	  
	}
}
