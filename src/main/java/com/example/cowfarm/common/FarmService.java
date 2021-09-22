package com.example.cowfarm.common;

import com.example.cowfarm.solution1.FarmS1;
import com.example.cowfarm.solution2.FarmS2;

import java.util.HashMap;
import java.util.Map;

import static com.example.cowfarm.util.Constants.SOLUTION_TYPE_ONE;
import static com.example.cowfarm.util.Constants.SOLUTION_TYPE_TWO;

public class FarmService {

    private Map<String, Farm> availableFarms;

    public FarmService() {
        availableFarms = new HashMap<>();
        availableFarms.put(SOLUTION_TYPE_ONE, new FarmS1());
        availableFarms.put(SOLUTION_TYPE_TWO, new FarmS2());
    }

    public Farm provideFarm(String farmId) {
        return availableFarms.get(farmId);
    }
}
