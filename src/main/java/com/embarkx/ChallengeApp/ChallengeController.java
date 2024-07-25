package com.embarkx.ChallengeApp;

import java.util.ArrayList;
import  java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChallengeController{
    
    private List<Challenge> challenges = new ArrayList<>();

    public ChallengeController(){
        Challenge c1 = new Challenge(1l, "Jan", "hi");
        challenges.add(c1);
    }

    @GetMapping("/challenges")
    public List<Challenge> getAllChallenges(){
        return challenges;
    }

}