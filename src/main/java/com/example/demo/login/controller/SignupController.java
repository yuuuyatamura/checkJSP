package com.example.demo.login.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.model.SignupForm;
import com.example.demo.domain.model.User;
import com.example.demo.domain.repository.service.UserService;

@Controller
public class SignupController {

	@Autowired
	private UserService userService;
	
	//ラジオボタンの実装
	Map<String, String> radioMarriage;
	
	//ラジオボタンの初期化メソッド
	private Map<String, String> initRadioMarriage(){
		
		Map<String, String> radio = new LinkedHashMap<>();
		
		//既婚、未婚をMapに格納
		radio.put("既婚", "true");
		radio.put("未婚", "false");
		
		return radio;
	}
	
	//ユーザー登録画面用のGET用コントローラー
	//@ModelAttribute（自動でModelクラスにaddAttributeしてくれる）	
	@GetMapping("/signup")
	public String getSignUp(@ModelAttribute SignupForm form, Model model) {
		
		
		//ラジオボタンの初期化メソッドを呼び出し
		radioMarriage = initRadioMarriage();
		
		//ラジオボタン用のMapをModelに登録
		model.addAttribute("radioMarriage", radioMarriage);
		
		//signup.htmlに画面遷移
		return "login/signup";
	}
	
	//ユーザー登録画面のPOST用コントローラー
	@PostMapping("/signup")
	public String postSignUp(@ModelAttribute @Validated SignupForm form, BindingResult bindingresult, Model model) {
		
		//login.htmlにリダイレクト
		//リダイレクトすると遷移先のControllerクラスが呼ばれる
		
		//データバインド失敗の場合
		//入力チェックに引っかかった場合、ユーザー登録画面に戻る
		if(bindingresult.hasErrors()) {
			//GETリクエスト用のメソッドを呼び出して、ユーザー登録画面に戻る
			return getSignUp(form, model);
		}
		
		System.out.println(form);
		
		//insert用変数
		User user = new User();
		user.setUserId(form.getUserId());
		user.setPassword(form.getPassword());
		user.setUserName(form.getUserName());
		user.setBirthday(form.getBirthday());
		user.setAge(form.getAge());
		user.setMarriage(form.isMarriage());
		user.setRole("ROLE_GENERAL"); //ロール（一般）
		
		//ユーザー登録処理
		boolean result = userService.insert(user);
		//ユーザー登録結果の判定
		
		if(result == true) {
			System.out.println("insert成功");
		} else {
			System.out.println("insert失敗");
		}
		
		return "redirect:/login";
	}
}

