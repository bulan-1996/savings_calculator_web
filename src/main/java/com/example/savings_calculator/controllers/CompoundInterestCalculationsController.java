package com.example.savings_calculator.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
}
