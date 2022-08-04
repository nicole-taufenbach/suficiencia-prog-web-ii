package com.furb.prog.web.furb.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class Comanda {

    private Long id;
    private Long idUsuario;
    private BigDecimal nomeUsuario;
    private String telefoneUsuario;
    private ArrayList<Produto> produtos;

}
