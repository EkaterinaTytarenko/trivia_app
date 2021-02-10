package com.practise.trivia;

import com.practise.trivia.dtos.QuestionDTO;
import com.practise.trivia.services.CategoriesService;
import com.practise.trivia.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
public class IndexController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CategoriesService categoriesService;

    @GetMapping("/index")
    @ResponseBody
    public List<String> getAllCategories() {

        List<String> categories = categoriesService.getAllCategories();
        return categories;
    }

    @PostMapping("/index")
    @ResponseBody
    public List<QuestionDTO> loadQuestions(@RequestBody Map<String,String> userForm) {
        return questionService.getQuestions(userForm);
    }

}