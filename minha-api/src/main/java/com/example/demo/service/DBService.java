package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Produto;
import com.example.demo.repositories.ProdutoRepository;

@Service
public class DBService {	

	@Autowired
	private ProdutoRepository repo;
	
	public void inicializarBancoDado() {
		Produto produto = new Produto(null, "Notebook", "K45A", 10, 3000.00);
		repo.save(produto);
	}
}
