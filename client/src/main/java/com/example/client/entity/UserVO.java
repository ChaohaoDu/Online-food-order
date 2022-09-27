package com.example.client.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserVO {
	private int code;
	private String msg;
	private int count;
	private List<User> data;
}
