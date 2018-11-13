package com.stackroute.recommendation.controller;

import com.stackroute.recommendation.domain.Challenge;
import com.stackroute.recommendation.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/challenge/recommendation")
public class RecommendationController {
    private RecommendationService recommendationService;

    @Autowired
    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping()
    public ResponseEntity<?> getRecommendedChallenge() {
        ResponseEntity responseEntity;
        List<Challenge> challengeList = recommendationService.getRecommendedChallenges();
        responseEntity = new ResponseEntity<List<Challenge>>(challengeList, HttpStatus.OK);
        return responseEntity;
    }
}


            //responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT)







