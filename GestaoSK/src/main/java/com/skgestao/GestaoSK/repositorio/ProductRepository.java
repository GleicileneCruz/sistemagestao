package com.skgestao.GestaoSK.repositorio;

import org.springframework.data.repository.CrudRepository;
import com.skgestao.GestaoSK.model.Products;

public interface ProductRepository  extends CrudRepository<Products, Integer> {


}
