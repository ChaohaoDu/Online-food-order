package com.example.order.entity;

import java.util.Date;
import lombok.Data;

@Data
public class Order {
	private long id;
	private User user;
	private Menu menu;
	private Admin admin;
	private Date date;
	private int state;
}
