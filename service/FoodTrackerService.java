package com.foodtracker.service;

import java.util.ArrayList;
import java.util.Collections;

import java.util.List;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.juli.logging.Log;
import org.hibernate.mapping.Collection;
import org.springframework.stereotype.Service;

import com.foodtracker.model.FoodLog;

@Service
public class FoodTrackerService {
	
    private static final Logger logger = LoggerFactory.getLogger(FoodTrackerService.class);


	public List<FoodLog> getFoodOptions(String option) {
		// TODO Auto-generated method stub

		List<FoodLog> FoodLogs = new ArrayList<>();
		logger.info("option"+option);


		switch (option.toLowerCase()) {
		

		case "weight-loss":
			FoodLogs.add(new FoodLog("Grilled Chicken", "Healthy", 150,"grill.jpg"));
			FoodLogs.add(new FoodLog("Caesar Salad", "Healthy", 200,"salad.jpg"));
			FoodLogs.add(new FoodLog("Steamed Broccoli", "Healthy", 50,"broccoli.jpg"));
			FoodLogs.add(new FoodLog("Quinoa", "Healthy", 120,"quinoa.webp"));
			FoodLogs.add(new FoodLog("Avocado Toast", "Healthy", 250,"avacado.jpg"));
			FoodLogs.add(new FoodLog("Egg White Omelette", "Healthy", 180,"egg.jpg"));
			break;
			
		case "weight-gain":
            FoodLogs.add(new FoodLog("Grilled Chicken", "Healthy Weight Gain", 250,"grill.jpg"));
            FoodLogs.add(new FoodLog("Caesar Salad (with Dressing)", "Healthy Weight Gain", 350,"salad.jpg"));
            FoodLogs.add(new FoodLog("Steamed Broccoli with Olive Oil", "Healthy Weight Gain", 120,"broccoli.jpg"));
            FoodLogs.add(new FoodLog("Egg White Omelette with Cheese", "Healthy Weight Gain", 300,"egg.jpg"));
            FoodLogs.add(new FoodLog("Grilled Fish with Avocado", "Healthy Weight Gain", 400,"fish.jpg"));
            FoodLogs.add(new FoodLog("Peanut Butter Smoothie", "Healthy Weight Gain", 500,"peanut.jpg"));
            FoodLogs.add(new FoodLog("Whole Grain Pasta", "Healthy Weight Gain", 350,"pasta.jpg"));
            FoodLogs.add(new FoodLog("Brown Rice and Chicken", "Healthy Weight Gain", 400,"rice.jpg"));
            FoodLogs.add(new FoodLog("Almonds and Cashews", "Healthy Weight Gain", 200,"almond.jpg"));
            FoodLogs.add(new FoodLog("Sweet Potato", "Healthy Weight Gain", 180,"potato.jpg"));
            break;
            
            
		case "optional":
			FoodLogs.add(new FoodLog("Milkshake", "Junk", 300,"milk.jpg"));
			FoodLogs.add(new FoodLog("French Fries", "Junk", 350,"fries.jpg"));
			FoodLogs.add(new FoodLog("Chocolate Cake", "Junk", 500,"cake.jpg"));
			FoodLogs.add(new FoodLog("Burger", "Junk", 500,"burger.jpg"));
			FoodLogs.add(new FoodLog("Grilled Chicken", "Healthy", 150,"grill.jpg"));
			FoodLogs.add(new FoodLog("Avocado Toast", "Healthy", 250,"avacado.jpg"));
			FoodLogs.add(new FoodLog("Egg White Omelette", "Healthy", 180,"egg.jpg"));
			FoodLogs.add(new FoodLog("Caesar Salad", "Healthy", 200,"salad.jpg"));
			break;
			
		case "cheat-day":
			FoodLogs.add(new FoodLog("Pizza", "Junk", 400,"pizza.jpg"));
			FoodLogs.add(new FoodLog("French Fries", "Junk", 350,"fries.jpg"));
			FoodLogs.add(new FoodLog("Chocolate Cake", "Junk", 500,"cake.jpg"));
			FoodLogs.add(new FoodLog("Burger", "Junk", 500,"burger.jpg"));
			FoodLogs.add(new FoodLog("Milkshake", "Junk", 300,"milk.jpg"));
			break;
			
		case "protein-focused":
			FoodLogs.add(new FoodLog("Chicken Breast", "Protein", 200,"cbreast.jpg"));
			FoodLogs.add(new FoodLog("Egg White Omelette", "Protein", 180,"egg.jpg"));
			FoodLogs.add(new FoodLog("Tofu Stir Fry", "Protein", 220,"tofu.jpg"));
			FoodLogs.add(new FoodLog("Salmon", "Protein", 250,"salmon.jpg"));
			FoodLogs.add(new FoodLog("Greek Yogurt", "Protein", 150,"yogurt.jpg"));
			break;
			
		case "low-carb":
			FoodLogs.add(new FoodLog("Grilled Chicken", "Low Carb", 150,"grill.jpg"));
			FoodLogs.add(new FoodLog("Caesar Salad (No Dressing)", "Low Carb", 120,"salad.jpg"));
			FoodLogs.add(new FoodLog("Egg Salad", "Low Carb", 200,"eggsalad.jpg"));
			FoodLogs.add(new FoodLog("Zucchini Noodles", "Low Carb", 90,"pasta.jpg"));
			FoodLogs.add(new FoodLog("Grilled Salmon", "Low Carb", 250,"salmon.jpg"));
			break;
		default:
			FoodLogs.add(new FoodLog("No Option Selected", "N/A", 0,""));
			break;
		}
		
		logger.info("list"+FoodLogs);
		return FoodLogs;
	}
	
	
	

	public List<FoodLog> getReshuffledFoodItems(String option) {
	    List<FoodLog> suggestedFood = new ArrayList<>();
	    suggestedFood = getFoodOptions(option);
	    if (suggestedFood.size() <= 3) {
	        return new ArrayList<>(suggestedFood);
	    }
	   
	    Collections.shuffle(suggestedFood); 
	    return suggestedFood.subList(0, 3); 
	}



}
