package com.praveen.javacore.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * ============================================================================
 * QUESTION: turn product IDs like "TECH-123" into
 *           {TECH=[123,456,789], FURN=[99,01], CLOTH=[10]} (drop invalid IDs).
 * ----------------------------------------------------------------------------
 * EASY WAY: filter ids containing "-", then groupingBy(prefix before "-") with
 * a downstream mapping(suffix after "-", toList()). The split("-")[0]/[1] give
 * category and model. Classic "group + transform each group" combo.
 * COMPLEXITY: Time O(N), Space O(distinct categories).
 * ============================================================================
 */
public class StreamChallengeThree {
	public static void main(String[] args) {
        List<String> productIds = Arrays.asList(
            "TECH-123", "FURN-99", "TECH-456", "CLOTH-10", "FURN-01", "INVALID_ID", "TECH-789"
        );

        // TODO: Transform this list into a Map<String, List<String>>
        // Expected result: {TECH=[123, 456, 789], FURN=[99, 01], CLOTH=[10]}
        
        Map<String, List<String>> productsByCategory = productIds.stream()
        	    // 1. Filter out invalid IDs
        	    .filter(id -> id.contains("-"))
        	    
        	    // 2. Group by the Category (prefix)
        	    .collect(Collectors.groupingBy(
        	        id -> id.split("-")[0], 
        	        
        	        // 3. Downstream: Transform the ID to just the Model (suffix)
        	        Collectors.mapping(
        	            id -> id.split("-")[1], 
        	            Collectors.toList()
        	        )
        	    ));
        						System.out.println(productsByCategory);					
    }
}