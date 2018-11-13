package com.stackroute.recommendation.repository;

import com.stackroute.recommendation.domain.Challenge;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChallengeRepository extends Neo4jRepository<Challenge,String> {
    @Query ("Match (challenge:Challenge)-[r:isAttemptedBy]->(u:User) where u.name='Tarun' return challenge")
    List<Challenge> getAttemptedChallenges();
    @Query ("Match (challenge:Challenge) where challenge.level=1 return challenge")
    //Get me the basic level challenges
    List<Challenge> getBasicChallenges();
    @Query ("Match (challenge:Challenge) where challenge.level=2 return challenge")
    //Get me the Intermediate challenges based query
    List<Challenge> getIntermediateChallenges();
    @Query ("Match (challenge:Challenge) where challenge.level=3 return challenge")
    //Get me the Advanced challenges based query
    List<Challenge> getAdvancedChallenges();



}
