package com.practise.trivia.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@JsonSerialize
public class QuestionDTO {

    /*@JsonSerialize
    private Integer id;*/

    @JsonSerialize
    private String question;

    @JsonSerialize
    private String correct_answer;

    @JsonSerialize
    private String incorrect_answers;

}
