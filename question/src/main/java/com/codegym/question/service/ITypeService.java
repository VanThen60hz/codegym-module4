package com.codegym.question.service;

import com.codegym.question.model.Type;

import java.util.List;

public interface ITypeService extends IGeneralService<Type>{
    List<Type> findAll();
}
