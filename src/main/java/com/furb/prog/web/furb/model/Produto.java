package com.furb.prog.web.furb.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Produto {

    private Long id;
    private String nome;
    private Double preco;

}
