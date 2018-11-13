package com.stackroute.recommendation.service;

import com.stackroute.recommendation.domain.Challenge;
import com.stackroute.recommendation.repository.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {
    ChallengeRepository challengeRepository;

    @Autowired
    public RecommendationServiceImpl(ChallengeRepository challengeRepository){
        this.challengeRepository=challengeRepository;
    }

    @Override
    public List<Challenge> getRecommendedChallenges() {

        int countBasic=0;
        int countIntermediate=0;
        int countAdvanced=0;

        //int size=challengeRepository.getAttemptedChallenges().size();
        List<Challenge> attemptedChallengeList=challengeRepository.getAttemptedChallenges();
        List<Challenge> recommendedChallengeList=null;
        //List<Challenge> completeChallengeList=(List<Challenge>)challengeRepository.findAll();
        for(int i=0;i<=attemptedChallengeList.size();i++)
        {
            if(attemptedChallengeList.get(i).getLevel()==1)
                countBasic=countBasic+1;
            else
                if(attemptedChallengeList.get(i).getLevel()==2)
                    countIntermediate=countIntermediate+1;
                else
                    countAdvanced=countAdvanced+1;
        }
        if(countBasic<=3)
            for(int i=0;i<=3;i++)
            recommendedChallengeList.set(i,challengeRepository.getBasicChallenges().get(i));
        else if(countBasic>3 && countIntermediate<=2)
            for(int i=0;i<=3;i++)
                recommendedChallengeList.set(i,challengeRepository.getIntermediateChallenges().get(i));
          else
            for(int i=0;i<=3;i++)
                recommendedChallengeList.set(i,challengeRepository.getAdvancedChallenges().get(i));


        return recommendedChallengeList;
    }
}
