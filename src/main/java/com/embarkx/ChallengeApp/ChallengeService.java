package com.embarkx.ChallengeApp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class ChallengeService {
    private List<Challenge> challenges = new ArrayList<>();
    private Long nextId = 1L;

    public ChallengeService(){
        Challenge c1 = new Challenge(1l, "Jan", "hi");
        challenges.add(c1);
    }

    public List<Challenge> getAllChallenges(){
        return challenges;
    }

    public boolean addChallenge(Challenge challenge){
        if (challenge != null){
            challenge.setId(nextId++); //auto genetated ID
            challenges.add(challenge);
            return true;
        }else{
            return false;
        }
    }

    public Challenge getChallenges(String month) {
        for (Challenge challenge: challenges){
            if (challenge.getMonth().equalsIgnoreCase(month)){
                return challenge;
            }
        }
        return null;
    }

    public boolean updateChallenge(Long id, Challenge updatedChallenge) {
        for (Challenge challenge: challenges){
            if (challenge.getId().equals(id)){
                challenge.setMonth(updatedChallenge.getMonth());
                challenge.setDescription(updatedChallenge.getDescription());
                return true;
            }
        }
        return false;
    }

    public boolean deleteChallenge(Long id) {
        return challenges.removeIf(challenge -> challenge.getId().equals(id));
    }
        
    
}
