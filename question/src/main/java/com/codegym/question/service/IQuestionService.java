package com.codegym.question.service;

import com.codegym.question.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IQuestionService extends IGeneralService<Question>{
    Page<Question> findByTittleContainingAndType_NameContaining(String title, String name, Pageable pageable);
}
