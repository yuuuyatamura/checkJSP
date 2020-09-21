package com.example.demo.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	// ログイン画面のGET用コントローラー
	@GetMapping("/login")
	public String getLogin(Model model) {
		//login.htmlに画面遷移
		return "login/login";
		//src/main/resources/templatesからのパスで指定する
	}
	
	//ログイン画面のPOST用コントローラー.
	@PostMapping("/login") 
	public String postLogin(Model model){
		//ホーム画面に遷移
		
		return"redirect:/home";
	}
}

