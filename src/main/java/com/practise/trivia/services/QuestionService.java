package com.practise.trivia.services;

import com.practise.trivia.dtos.QuestionDTO;
import com.practise.trivia.entities.Question;
import com.practise.trivia.repos.QuestionsRepo;
import org.hibernate.mapping.Collection;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    @Autowired
    private QuestionsRepo questionRepository;

    @Autowired
    private ModelMapper modelMapper;

    private QuestionDTO convertToDto(Question question){
        QuestionDTO questionDTO = modelMapper.map(question, QuestionDTO.class);
        return questionDTO;
    }

    public List<QuestionDTO> getQuestions(Map<String,String> params) {

        List<String>difficulties=Arrays.asList(params.get("difficulties").split(","));
        List<String>categories=Arrays.asList(params.get("categories").split(","));
        List<String>types=Arrays.asList(params.get("types").split(","));
        Integer number=Integer.parseInt(params.get("number"));

        List<QuestionDTO> questions = questionRepository
                .findQuestions(difficulties,categories,types,number)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        return questions;
    }
}
