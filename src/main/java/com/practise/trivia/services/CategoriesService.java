package com.practise.trivia.services;

import com.practise.trivia.repos.QuestionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriesService {
    @Autowired
    private QuestionsRepo questionRepository;

    public List<String> getAllCategories() {
        return ((List<String>) questionRepository
                .findAllCategories())
                .stream()
                .collect(Collectors.toList());
    }
}
