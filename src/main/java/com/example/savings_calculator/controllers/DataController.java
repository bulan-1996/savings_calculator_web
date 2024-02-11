package com.example.savings_calculator.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {
	@Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
	
	@GetMapping("/api/data")
	public String getData() {
//		String url = "jdbc:mysql://localhost:3306/savings_calculator";
//		String user = "root"; //ユーザー名
//		String password = "rootpass"; //パスワード
		String query = "SELECT * FROM sample";
		
		try {
			// JDBCドライバーのロード
			Class.forName(driverClassName);
			// データベースに接続
			Connection connection = DriverManager.getConnection(url, user, password);
			// SQLクエリを実行して結果を取得
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			// JSON形式にデータを変換
			StringBuilder jsonData = new StringBuilder();
			jsonData.append("[");
			while (resultSet.next()) {
				jsonData.append("\"id\": \"" + resultSet.getString("id") + "\",");
				jsonData.append("\"value\": \"" + resultSet.getString("value") + "\","); // 列2のデータ
				// 必要なだけ列を追加する
				jsonData.append("},");
			}
			//余分なカンマを削除
			if(jsonData.charAt(jsonData.length() -1) == ',') {
				jsonData.deleteCharAt(jsonData.length() - 1);
			}
			jsonData.append("]");
			
			// 接続を閉じる
			resultSet.close();
			statement.close();
			connection.close();
			
			// JSONデータを返却
			return jsonData.toString();
		}catch (Exception e) {
			e.printStackTrace();
			return "Error retrieving data";
		}
	}

}
