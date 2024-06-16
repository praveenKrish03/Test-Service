package com.example.Test_Service.Controller;

import com.example.Test_Service.DTO.Response;
import com.example.Test_Service.Service.TestService;
import com.example.Test_Service.Wrapper.QuestionsReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @PostMapping("/createTest")
    public ResponseEntity<List<Integer>> createTest
            (@RequestParam String category, Integer num, String title) {
       return testService.createTest(category,num,title);
    }

    @GetMapping("/getQuetionsById/{id}")
    public ResponseEntity<List<QuestionsReturn>> getQuestionByIds(@PathVariable Integer id) {
        return testService.getQuestionsById(id);
    }

    @PostMapping("/submit")
        public ResponseEntity<Integer> submitQuestions(@RequestBody List<Response> response) {
            return testService.getResult(response);
        }
}
