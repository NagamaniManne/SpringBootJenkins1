package com.sathya.orm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductDetails {
	private int proId;
	private String proName;
	private double proPrice;
}
