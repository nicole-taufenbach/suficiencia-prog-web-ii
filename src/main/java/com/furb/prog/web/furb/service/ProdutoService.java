package com.furb.prog.web.furb.service;

import com.furb.prog.web.furb.model.Produto;
import com.furb.prog.web.furb.repository.ProdutoRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @ApiOperation(value="Retorna um produto unico")
    public Produto obterPorId(Long id) {
        return repository
                .findById(id)
                .orElse(null);
    }

}
