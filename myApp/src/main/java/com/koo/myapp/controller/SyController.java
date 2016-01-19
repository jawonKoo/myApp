package com.koo.myapp.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koo.myapp.member.bean.MemberBean;
import com.koo.myapp.member.dao.MemberDao;
import com.koo.myapp.member.service.MemberServiceImpl;

@Controller
public class SyController {

	private static final Logger logger = LoggerFactory.getLogger(SyController.class);
	
	@Autowired
	MemberServiceImpl memberService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Locale locale, Model model) {
		logger.info("LoginController The client locale is {}.", locale);
		
		return "system/register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String insertMember(MemberBean memberBean, Model model) throws Exception {
	
		logger.info("memberBean.Phonenum :" + memberBean.getPhoneNum());
		logger.info("memberBean.Nickname :" + memberBean.getNickname());
		logger.info("memberBean.Password :" + memberBean.getPassword());
		
		int resultCnt = memberService.insertMember(memberBean);
		
		String result = "";
		
		if(resultCnt == 0){
			result = "failure";
		}else{
			result = "success";
		}
		
		model.addAttribute("result", result);
		model.addAttribute("memberBean", memberBean);
		
		return "login";
		
	}
	
	@RequestMapping(value = "/saveMobile")
	public String saveMobile(MemberBean memberBean) throws Exception {
		
		logger.info("memberBean.Phonenum :" + memberBean.getPhoneNum());
		logger.info("memberBean.Nickname :" + memberBean.getNickname());
		logger.info("memberBean.Password :" + memberBean.getPassword());
		
		int resultCnt = memberService.insertMember(memberBean);
		
		String result = "";
		
		if(resultCnt == 0){
			result = "failure";
		}else{
			result = "success";
		}
		
		return null;
	}
	
}
