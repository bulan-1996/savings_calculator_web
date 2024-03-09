package com.example.savings_calculator.dao;

import com.example.savings_calculator.entity.User;

//カスタムメソッドクラス_repositoryと統合でも良いかも
public interface UserDao {
	void save(User user);
    User findByEmail(String email);
}
