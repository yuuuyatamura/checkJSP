package com.example.demo.domain.model;

import java.util.Date;

//import javax.validation.constraints.AssertFalse;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
//
//import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

@Data
public class SignupForm {

	//必須入力、メールアドレス形式
//	@NotBlank
//	@Email
	private String userId; //ユーザーID
	
	//必須入力、長さ4から100桁まで、半角英数字のみ
//	@NotBlank
//	@Length(min = 4, max =100)
//	@Pattern(regexp = "[a-zA-Z0-9]+$")
	private String password; //パスワード
//	@NotBlank
	private String userName; //ユーザー名
	
	//ポイント: @DataTimeFormat
//	@NotNull
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date birthday; //誕生日
//	@Min(20)
//	@Max(100)
	private int age; //年齢
//	@AssertFalse
	private boolean marriage; //結婚ステータス
	
}
