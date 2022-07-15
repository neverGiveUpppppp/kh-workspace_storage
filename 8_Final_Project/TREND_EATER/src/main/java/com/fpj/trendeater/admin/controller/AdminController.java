package com.fpj.trendeater.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fpj.trendeater.admin.exception.AdminException;
import com.fpj.trendeater.admin.model.service.AdminService;
import com.fpj.trendeater.admin.model.vo.Admin;
import com.fpj.trendeater.member.model.vo.Member;

@SessionAttributes("adminUser")
@Controller
public class AdminController {

	@Autowired
	private AdminService aService;
	
	
	//김주희:로그인 폼
	@RequestMapping("admin")
	public String adminView(Model model) {
	
		return "adminLogin";
	
    }
	
    //김주희:어드민 로그인
    @RequestMapping("/adminlogin.ad")
    public String adminlogin(@ModelAttribute("admin")Admin admin,Model model,HttpSession session) {
      
   
       Admin admind = aService.adminlogin(admin);
   
      
       if(admind != null ) {
          session.setAttribute("adminUser",admind);
          return "redirect:member.ad";
       }else {         
          throw new AdminException("관리자 로그인에 실패하였습니다.");
       }
    }
	
    
    //김주희:회원 리스트 뷰페이지
    @RequestMapping("/member.ad")
    public String adminMember(Model model) {
       
       ArrayList<Member> member = aService.selectMember();
       int result = aService.memberCount();
       
       
       model.addAttribute("member",member);
       model.addAttribute("result",result);
       return "memberList";

    }
	
    
    //김주희:회원 상태 변경
    @RequestMapping("/memberstatus.ad")
    public String updateMember(@RequestParam("email")String email,@RequestParam("checked")String checked) {
       
       
       
       HashMap<String, String> map = new HashMap<>();
       map.put("email",email);
       map.put("checked",checked);

          
       int result = aService.updateMember(map);
       
       
       
       String res = Integer.toString(result);
       
       
       return res;
    }
    

/*************************************** QnA ************************************/
    // 문의사항 게시판 : 답변 쓰기
//    @RequestMapping("boardQnaAns.ad")
//    public String boardQnaAns() {
//    	
//    	
//    	
//    	
//    }
    
    
    
}




