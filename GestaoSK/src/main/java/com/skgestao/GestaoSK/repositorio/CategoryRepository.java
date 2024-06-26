package com.skgestao.GestaoSK.repositorio;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.skgestao.GestaoSK.model.Category;

public interface CategoryRepository  extends CrudRepository<Category, Integer> {

    Object findAll(Sort id);
}
