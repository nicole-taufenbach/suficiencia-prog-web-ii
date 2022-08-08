package com.furb.prog.web.furb.repository;

import com.furb.prog.web.furb.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long>  {



}
