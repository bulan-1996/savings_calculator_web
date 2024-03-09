package com.example.savings_calculator.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.savings_calculator.dto.UserDTO;
import com.example.savings_calculator.service.UserService;

/*
 * UserテーブルController
 * */
@RestController
public class UserController {
	
	private final UserService userService;
	/*
	 * Spring Bootでは、コンストラクタに@Autowiredアノテーションが付けられている場合、
	 * Springが自動的にBeanをインジェクションするので@Autowiredはここには不要である。
	 * */
    public UserController(UserService userService) {
        this.userService = userService;
    }
	
	@PostMapping("api/user")
	public void receiveUserData(@RequestBody UserDTO userDTO) {		
		// 画面から受け取った情報をUserServiceに渡す
		userService.saveUser(userDTO);
	}
	
	/**
	 * emailアドレスの情報を元にしてUserテーブルの情報を取得
	 * @param email
	 * @return HTTPの結果 userテーブルのidを返す
	 */
	@GetMapping("api/userId")
	public ResponseEntity<Map<String, Integer>> getUserByEmail(@RequestParam("email") String email) {
        UserDTO userDTO = userService.getUserByEmail(email);
        if (userDTO != null) {
        	Map<String, Integer> response = new HashMap<>();
        	response.put("id", userDTO.getId());  	
        	return ResponseEntity.ok(response);
        } else {
        	// userIdがnullの場合、クライアントにエラーを通知する
        	return ResponseEntity.notFound().build();
        }
    }
}
