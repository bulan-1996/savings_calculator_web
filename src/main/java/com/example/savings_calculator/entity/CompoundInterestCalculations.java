package com.example.savings_calculator.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/***
 * compound_interest_calculationsのエンティティ
 */
@Entity
@Table(name = "compound_interest_calculations") //テーブル名を指定
public class CompoundInterestCalculations {
	// @idはprivary Keyに付与する
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int userId;
	private String name;
	private int annualInterestRate;
	private int investmentYears;
	private int monthlyInvestment;
	private int initialCapital;
	@Column(name = "created_at", nullable = false, updatable = false)
	@CreationTimestamp
	private Timestamp createdAt;
	@Column(name = "updated_at")
	@UpdateTimestamp
	private Timestamp updatedAt;
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
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
}
