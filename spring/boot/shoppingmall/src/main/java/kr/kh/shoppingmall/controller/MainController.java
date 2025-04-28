package kr.kh.shoppingmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.kh.shoppingmall.model.vo.MemberVO;
import kr.kh.shoppingmall.service.MemberService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class MainController {
	
	@Autowired
	MemberService memberService;

	@GetMapping("/")
	public String main() {
		return "index";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "user/signup";
	}
	@PostMapping("/signup")
	public String signupPost(MemberVO member) {
		System.out.println(member);
		if(memberService.signup(member)){
			return "redirect:/";
		}
		return "redirect:/signup";
	}
	
	
}
