package com.example.savings_calculator.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.savings_calculator.dto.CompoundInterestCalculationsDTO;
import com.example.savings_calculator.service.CompoundInterestCalculationsService;

/**
 * compound_interest_calculationsテーブルController
 * 
 */
@RestController
public class CompoundInterestCalculationsController {
	private final CompoundInterestCalculationsService compoundInterestCalculationsService;
	
	public CompoundInterestCalculationsController(CompoundInterestCalculationsService compoundInterestCalculationsService) {
		 this.compoundInterestCalculationsService = compoundInterestCalculationsService;
	}
	
	@PostMapping("api/compoundInterestCalculationsSave")
	public void receiveCompoundInterestCalculations(@RequestBody CompoundInterestCalculationsDTO compoundInterestCalculationsDTO) {
		// 画面から受け取った情報をCompoundInterestCalculationsServiceに渡す
		compoundInterestCalculationsService.saveCompoundInterestCalculations(compoundInterestCalculationsDTO);
	}
	
	@GetMapping("api/compoundInterestCalculationsGet")
	public ResponseEntity<Map<String, String>> getCalculationByUserIdAndName(@RequestParam("userId") int userId,@RequestParam("name") String name) { 
		CompoundInterestCalculationsDTO compoundInterestCalculationsDTO = compoundInterestCalculationsService.getCalculationByUserIdAndName(userId,name);
		if(compoundInterestCalculationsDTO != null) {
			Map<String, String> response = new HashMap<>();
			response.put("name", compoundInterestCalculationsDTO.getName()); 
			response.put("annualInterestRate", String.valueOf(compoundInterestCalculationsDTO.getAnnualInterestRate())); 
			response.put("investmentYears", String.valueOf(compoundInterestCalculationsDTO.getInvestmentYears())); 
			response.put("monthlyInvestment", String.valueOf(compoundInterestCalculationsDTO.getMonthlyInvestment())); 
			response.put("initialCapital", String.valueOf(compoundInterestCalculationsDTO.getInitialCapital())); 
			return ResponseEntity.ok(response);
		} else {
			// nullの場合、クライアントにエラーを通知する
        	return ResponseEntity.notFound().build();
		}
	}
}
