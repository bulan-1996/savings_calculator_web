package com.example.savings_calculator.dto;

/***
 *  CompoundInterestCalculationsDTO
 * 
 */
public class CompoundInterestCalculationsDTO {
	/***
	 * id:
	 * userId:userテーブルのユーザーid
	 * name:名称
	 * annualInterestRate:利率(年率)
	 * investmentYears:積立期間(年)
	 * monthlyInvestment:毎月の積立金額
	 * initialCapital:積立前元金
	 */
	private int id;
	private int userId;
	private String name;
	private int annualInterestRate;
	private int investmentYears;
	private int monthlyInvestment;
	private int initialCapital;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAnnualInterestRate() {
		return annualInterestRate;
	}
	public void setAnnualInterestRate(int annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	public int getInvestmentYears() {
		return investmentYears;
	}
	public void setInvestmentYears(int investmentYears) {
		this.investmentYears = investmentYears;
	}
	public int getMonthlyInvestment() {
		return monthlyInvestment;
	}
	public void setMonthlyInvestment(int monthlyInvestment) {
		this.monthlyInvestment = monthlyInvestment;
	}
	public int getInitialCapital() {
		return initialCapital;
	}
	public void setInitialCapital(int initialCapital) {
		this.initialCapital = initialCapital;
	}
	
	
}
