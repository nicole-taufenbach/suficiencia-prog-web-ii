package com.furb.prog.web.furb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double preco;


}
