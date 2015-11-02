package com.freeman.track.model;

import com.orm.SugarRecord;
import com.orm.dsl.Ignore;

public class User extends SugarRecord {
	String username;
	String password;
	int age;
	@Ignore
	String bio; // this will be ignored by SugarORM

	public User() {
	}

	public User(String username, String password, int age) {
		this.username = username;
		this.password = password;
		this.age = age;
	}
}