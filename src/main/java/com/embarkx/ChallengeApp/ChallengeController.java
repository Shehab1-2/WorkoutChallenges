package com.embarkx.ChallengeApp;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/challenges")
@CrossOrigin(origins="http://localhost:3000/")
public class ChallengeController {
    private final ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService; // Spring Boot manages this class dependency and initializes it
    }

    @GetMapping //("/challenges")
    public ResponseEntity<List<Challenge>> getAllChallenges() {
        List<Challenge> challenges = challengeService.getAllChallenges();
        return new ResponseEntity<>(challenges, HttpStatus.OK);
    }

    @PostMapping //("/challenges")
    public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge) {
        boolean isChallengeAdded = challengeService.addChallenge(challenge);

        if (isChallengeAdded) {
            return new ResponseEntity<>("Challenge Added Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Challenge Not Added Successfully", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{month}")
    public ResponseEntity<Challenge> getAChallenges(@PathVariable String month) {
        Challenge challenge = challengeService.getChallenges(month);

        if (challenge != null) {
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id, @RequestBody Challenge updatedChallenge){
        boolean isChallengeUpdated = challengeService.updateChallenge(id, updatedChallenge);

        if (isChallengeUpdated) {
            return new ResponseEntity<>("Challenge Updated Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Challenge Not Updated Successfully", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id){
        boolean isChallengeDeleted = challengeService.deleteChallenge(id);

        if (isChallengeDeleted) {
            return new ResponseEntity<>("Challenge Deleted Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Challenge Not Deleted", HttpStatus.NOT_FOUND);
        }
    }
}

