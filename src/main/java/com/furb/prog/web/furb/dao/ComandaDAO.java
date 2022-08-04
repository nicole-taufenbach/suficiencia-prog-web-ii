package com.furb.prog.web.furb.dao;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;

@Getter
@Setter
public class ComandaDAO {

        private Long id;
        private Long idUsuario;
        private BigDecimal nomeUsuario;
        private String telefoneUsuario;
        private ArrayList<ProdutoDAO> produtos;

}
