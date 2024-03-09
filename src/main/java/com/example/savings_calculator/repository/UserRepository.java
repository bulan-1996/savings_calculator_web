package com.example.savings_calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.savings_calculator.entity.User;

//エンティティの型に合わせて第二引数を変更する必要があります。
//基本的なCRUD操作のみ
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByEmail(String email);
}
