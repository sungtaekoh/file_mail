package com.care.root.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.service.MailService;

@Controller
public class MailController {
	@Autowired MailService ms;
	@GetMapping("sendmail")
	public void sendMail(HttpServletResponse response) throws Exception {
		
		StringBuffer sb = new StringBuffer();
		sb.append("<h1>제품소개</h1>");
		sb.append("<a href=\"https://tv.naver.com/v/23369153\">");
		sb.append("<img src=\"https://search.pstatic.net/sunny/?src=https%3A%2F%2Fdata.whicdn.com%2Fimages%2F359067526%2Foriginal.jpg&type=a340\">");
		sb.append("</a>");
		
		String msg = sb.toString();
		
		ms.sendMail("choheewon@hanmail.net","(제목)광고",msg);
		//ms.sendMail("choheewon@hanmail.net","(제목)테스트 메일","(내용)안녕하세요");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("메일이 전송되었습니다");
	}
	
	@GetMapping("auth_form")
	public String authForm() {
		return "auth";
	}
	@GetMapping("auth")
	public String auth(HttpServletRequest request) {
		ms.auth(request);
		return "redirect:https://www.daum.net/";
	}
	@GetMapping("auth_check")
	public String authCheck(@RequestParam String userid,
							@RequestParam String userkey,
							HttpSession session) {
		String sessionKey = (String)session.getAttribute(userid);
		if(sessionKey != null) {
			if(sessionKey.equals(userkey)) {
				session.setAttribute("userid", userid);
			}
		}
		return "redirect:auth_form";
	}
}











