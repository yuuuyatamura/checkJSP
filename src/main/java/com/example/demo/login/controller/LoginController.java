package com.example.demo.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	// ログイン画面のGET用コントローラー
	@GetMapping("/login")
	public String getLogin(Model model) {
		//login.htmlに画面遷移
		return "login/login";
		//src/main/resources/templatesからのパスで指定する
	}
}
