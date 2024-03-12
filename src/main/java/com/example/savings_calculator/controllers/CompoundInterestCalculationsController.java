package com.example.savings_calculator.controllers;

import java.util.HashMap;
import java.util.List;
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
	public void saveCompoundInterestCalculations(@RequestBody CompoundInterestCalculationsDTO compoundInterestCalculationsDTO) {
		// 画面から受け取った情報をCompoundInterestCalculationsServiceに渡す
		compoundInterestCalculationsService.saveCompoundInterestCalculations(compoundInterestCalculationsDTO);
	}
	
	@PostMapping("api/compoundInterestCalculationsDelete")
	public void deleteCompoundInterestCalculations(@RequestBody CompoundInterestCalculationsDTO compoundInterestCalculationsDTO) {
		// 画面から受け取った情報をCompoundInterestCalculationsServiceに渡す
		compoundInterestCalculationsService.deleteCompoundInterestCalculations(compoundInterestCalculationsDTO);
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
	
	/***
	 * UserIdを使用してリスト取得する。
	 * @param userId
	 * @return
	 */
	@GetMapping("api/compoundInterestCalculationsGetList")
	public ResponseEntity<List<CompoundInterestCalculationsDTO>> getCalculationListByUserId(@RequestParam("userId") int userId) {
		List<CompoundInterestCalculationsDTO> compoundInterestCalculationsDTOList = compoundInterestCalculationsService.getCalculationByUserId(userId);
		if(!compoundInterestCalculationsDTOList.isEmpty()) {
			return ResponseEntity.ok(compoundInterestCalculationsDTOList);
		} else {
			// nullの場合、クライアントにエラーを通知する
        	return ResponseEntity.notFound().build();
		}
	}
}
