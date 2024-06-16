package com.example.Test_Service.Service;

import com.example.Test_Service.DTO.Response;
import com.example.Test_Service.Entity.Test;
import com.example.Test_Service.Feign.DataInterface;
import com.example.Test_Service.Repo.TestRepo;
import com.example.Test_Service.Wrapper.QuestionsReturn;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    DataInterface dataInterface;

    @Autowired
    TestRepo testRepo;

    public ResponseEntity<List<Integer>> createTest(String category, Integer num, String title) {
        List<Integer> questionIds = dataInterface.generateId(category,num).getBody();
        Test test = new Test();
        test.setTitle(title);
        test.setQuestionIds(questionIds);
        testRepo.save(test);
        return new ResponseEntity<>(questionIds, HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionsReturn>> getQuestionsById(Integer id) {
        Test test = testRepo.findById(id.longValue()).get();
        List<QuestionsReturn> questionsReturns = dataInterface.generateQuestions(test.getQuestionIds()).getBody();
        return new ResponseEntity<>(questionsReturns,HttpStatus.OK);
    }

    public ResponseEntity<Integer> getResult(List<Response> response) {
        Integer result = dataInterface.getScore(response).getBody();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
