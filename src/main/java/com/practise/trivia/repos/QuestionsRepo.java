package com.practise.trivia.repos;

import com.practise.trivia.entities.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface QuestionsRepo extends CrudRepository<Question, Integer> {

    @Query(value="select distinct category from Question")
    public Iterable<String> findAllCategories();

    @Query(value="select * from questions  " +
            "where category in :categories and type in :types and difficulty in :difficulties " +
            "order by rand() limit :num",nativeQuery = true)
    public Collection<Question> findQuestions(@Param("difficulties") Collection<String> difficulties, @Param("categories") Collection<String> categories,
                                              @Param("types") Collection<String> types, @Param("num") Integer number);
}
