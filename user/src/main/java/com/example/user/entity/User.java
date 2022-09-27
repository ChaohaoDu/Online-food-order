package com.example.user.entity;

import java.util.Date;
import lombok.Data;

@Data
public class User {
	private long id;
	private String username;
	private String password;
	private String nickname;
	private String gender;
	private String telephone;
	private Date registerdate;
	private String address;
}
