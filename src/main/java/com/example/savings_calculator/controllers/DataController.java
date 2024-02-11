package com.example.savings_calculator.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {
	@GetMapping("/api/data")
	public String getData() {
		// データの取得処理を行う
		return "Hello from Java!";
	}

}
