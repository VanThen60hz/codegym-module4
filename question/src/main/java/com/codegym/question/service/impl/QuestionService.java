package com.codegym.question.service.impl;

import com.codegym.question.model.Question;
import com.codegym.question.repository.IQuestionRepository;
import com.codegym.question.service.IQuestionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService implements IQuestionService {

    private final IQuestionRepository questionRepository;

    public QuestionService(IQuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Iterable<Question> findAll() {
        return null;
    }

    @Override
    public Optional<Question> findById(int id) {
        return questionRepository.findById(id);
    }

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void remove(int id) {
        questionRepository.deleteById(id);
    }

    @Override
    public Page<Question> findByTittleContainingAndType_NameContaining(String title, String name, Pageable pageable) {
        return questionRepository.findByTitleContainingAndType_NameContaining(title, name, pageable);
    }
}
