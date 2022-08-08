package com.furb.prog.web.furb.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "comandas")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long idUsuario;

    @Column(nullable = false)
    private String nomeUsuario;

    @Column(nullable = false)
    private String telefoneUsuario;

    @Column(nullable = false)
    @OneToMany(cascade = CascadeType.ALL)
    private List<Produto> produtos;

}
