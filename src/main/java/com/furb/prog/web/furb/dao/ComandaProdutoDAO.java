package com.furb.prog.web.furb.dao;

import lombok.Data;

import java.util.List;

@Data
public class ComandaProdutoDAO {

    private Long idUsuario;
    private String nomeUsuario;
    private String telefoneUsuario;
    private List<ProdutoDAO> produtos;

}
