package com.foodtracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodLog {
	
	
	private String name;
	private String type;
	private int calorieCount;
    private String image; 

}
