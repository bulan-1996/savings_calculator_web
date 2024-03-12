package com.example.savings_calculator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.savings_calculator.entity.CompoundInterestCalculations;

/**
 * compound_interest_calculationsのrepository
 */
//エンティティの型に合わせて第二引数を変更する必要があります。
//基本的なCRUD操作のみ
@Repository
public interface CompoundInterestCalculationsRepository extends JpaRepository<CompoundInterestCalculations, Integer>{
	CompoundInterestCalculations findByUserIdAndName(int userId, String name);
	List<CompoundInterestCalculations> findAllByUserId(int userId);
	void deleteByUserIdAndName(int userId, String name);
}
