package com.example.menu.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MenuVO {
	private int code;
	private String msg;
	private int count;
	private List<Menu> data;
}
