package com.example.demo.trySpring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//ポイント1:@Controller
@Controller
public class HelloController {

//ポイント2:@GetMapping
	@GetMapping("/hello")
	public String getHello() {
		//hello.htmlに画面遷移
		return "hello";
	}
	
	//ポイント1:@PostMapping
	//ポイント2:@RequestMapping
	@PostMapping("/hello")
	public String postRequest(@RequestParam("text1")String str,Model model) {
		//ポイント3:moldel.addAttribute
		//画面から受け取った文字列をModelに登録
		model.addAttribute("sample", str);
		
		//helloResponse.htmlに画面遷移
		return "helloResponse";
	}
}
