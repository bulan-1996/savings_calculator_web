package com.example.savings_calculator.service;

import javax.sql.DataSource;

import org.springframework.stereotype.Service;

import com.example.savings_calculator.dto.CompoundInterestCalculationsDTO;
import com.example.savings_calculator.entity.CompoundInterestCalculations;
import com.example.savings_calculator.repository.CompoundInterestCalculationsRepository;

/***
 *  compound_interest_calculationsテーブルService
 * 
 */
@Service
public class CompoundInterestCalculationsService {
	private final CompoundInterestCalculationsRepository compoundInterestCalculationsRepository;
	private final DataSource dataSource;
	
	// compoundInterestCalculationsRepositoryインスタンスを注入
	public CompoundInterestCalculationsService(CompoundInterestCalculationsRepository compoundInterestCalculationsRepository, DataSource dataSource) {
        this.compoundInterestCalculationsRepository = compoundInterestCalculationsRepository;
        this.dataSource = dataSource;
    }
	// 積立計算機の情報をデータベースに保存する処理
	public void saveCompoundInterestCalculations(CompoundInterestCalculationsDTO compoundInterestCalculationsDTO) {
		// 既に存在するデータであるか確認のため、DB検索を実施する。
		int userId = compoundInterestCalculationsDTO.getUserId();
		String name = compoundInterestCalculationsDTO.getName();
		int annualInterestRate = compoundInterestCalculationsDTO.getAnnualInterestRate();
		int investmentYears = compoundInterestCalculationsDTO.getInvestmentYears();
		int monthlyInvestment = compoundInterestCalculationsDTO.getMonthlyInvestment();
		int initialCapital = compoundInterestCalculationsDTO.getInitialCapital();
		// userIdとnameが一致するものは更新
		CompoundInterestCalculations alreadyExists = compoundInterestCalculationsRepository.findByUserIdAndName(userId,name);
		
		// idを取得して同一のものが既に存在した際に更新処理を行う
		if(alreadyExists != null) {
			alreadyExists.setUserId(userId);//userId
			alreadyExists.setName(name); //name
			alreadyExists.setAnnualInterestRate(annualInterestRate); //annualInterestRate
			alreadyExists.setInvestmentYears(investmentYears); //investmentYears
			alreadyExists.setMonthlyInvestment(monthlyInvestment); //monthlyInvestment
			alreadyExists.setInitialCapital(initialCapital); //
			compoundInterestCalculationsRepository.save(alreadyExists);
		} else {
			//compound_interest_calculationsテーブルに新規追加
			CompoundInterestCalculations compoundInterestCalculations = new CompoundInterestCalculations();
			compoundInterestCalculations.setUserId(userId); //userId
			compoundInterestCalculations.setName(name); //name
			compoundInterestCalculations.setAnnualInterestRate(annualInterestRate); //annualInterestRate
			compoundInterestCalculations.setInvestmentYears(investmentYears); //investmentYears
			compoundInterestCalculations.setMonthlyInvestment(monthlyInvestment); //monthlyInvestment
			compoundInterestCalculations.setInitialCapital(initialCapital); //initialCapital
			compoundInterestCalculationsRepository.save(compoundInterestCalculations);
			
		}
	}
	
	public CompoundInterestCalculationsDTO getCalculationByUserIdAndName(int userId, String name) {
		CompoundInterestCalculations compoundInterestCalculations = compoundInterestCalculationsRepository.findByUserIdAndName(userId,name);
		return convertToDto(compoundInterestCalculations);
	}
	
	private CompoundInterestCalculationsDTO convertToDto(CompoundInterestCalculations compoundInterestCalculations) {
		CompoundInterestCalculationsDTO compoundInterestCalculationsDTO = new CompoundInterestCalculationsDTO();
		compoundInterestCalculationsDTO.setId(compoundInterestCalculations.getId());
		compoundInterestCalculationsDTO.setUserId(compoundInterestCalculations.getUserId());
		compoundInterestCalculationsDTO.setName(compoundInterestCalculations.getName());
		compoundInterestCalculationsDTO.setAnnualInterestRate(compoundInterestCalculations.getAnnualInterestRate());
		compoundInterestCalculationsDTO.setInvestmentYears(compoundInterestCalculations.getInvestmentYears());
		compoundInterestCalculationsDTO.setMonthlyInvestment(compoundInterestCalculations.getMonthlyInvestment());
		compoundInterestCalculationsDTO.setInitialCapital(compoundInterestCalculations.getInitialCapital());
		return compoundInterestCalculationsDTO;
	}
}
