package com.foodtracker.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.foodtracker.model.FoodLog;
import com.foodtracker.service.FoodTrackerService;

@Controller
@RequestMapping("/foodTracker")
public class FoodTrackerController {
	
    private static final Logger logger = LoggerFactory.getLogger(FoodTrackerService.class);

    @Autowired
    private FoodTrackerService foodService;
	
	@GetMapping("/landing")
	public String showLandingPage() {
		return "landingPage";
	}
	

    @GetMapping("/home")
    public String showHomePage() {
        return "homePage"; 
    }
    

    @GetMapping("/foodOption")
    public String showFoodOptions(String option, Model model) {
        List<FoodLog> foodLogs  = foodService.getFoodOptions(option);
        model.addAttribute("foodLogs", foodLogs );
        model.addAttribute("option", option); 
		logger.info("option"+foodLogs);

        return "foodPage"; 
    }
    
    @GetMapping("/reshuffle")
    public String reshuffleFoodOptions(String option, Model model) {
        logger.info("Received option: " + option);  
        List<FoodLog> reshuffledFoodItems = foodService.getReshuffledFoodItems(option);
        
        logger.info("Reshuffled Food Items: " + reshuffledFoodItems);
        
        model.addAttribute("foodItems", reshuffledFoodItems);
        model.addAttribute("option", option);  

        return "suggestionPage";  
    }

	
	

}
