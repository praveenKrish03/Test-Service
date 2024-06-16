package com.example.Test_Service.Feign;

import com.example.Test_Service.DTO.Response;
import com.example.Test_Service.Wrapper.QuestionsReturn;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@FeignClient("STUDENT-QUESTIONS")
public interface DataInterface {

        @GetMapping("questions/generateIds")
        public ResponseEntity<List<Integer>> generateId(String category, Integer num) ;

        @GetMapping("questions/generateQuestions")
        public ResponseEntity<List<QuestionsReturn>> generateQuestions(List<Integer> request);

        @GetMapping("questions/getScore")
        public ResponseEntity<Integer> getScore(List<Response> response) ;

}
