package com.example.savings_calculator.dto;

public class UserDTO {
	/*
	 * id: DBのidをセット
	 * firebase APIで取得したユーザー情報
	 * displayName: ユーザーの表示名
	 * email: ユーザーのメールアドレス
	 * emailVerified: メールアドレスが確認済みかどうかのフラグ
	 * uid: ユーザーの一意のID
	 * */
	private int id;
	private String displayName;
	private String email;
	private Boolean emailVerified;
	private String uid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getEmailVerified() {
		return emailVerified;
	}
	public void setEmailVerified(Boolean emailVerified) {
		this.emailVerified = emailVerified;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	
}
