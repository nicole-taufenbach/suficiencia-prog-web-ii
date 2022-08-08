package com.furb.prog.web.furb.controller;

import com.furb.prog.web.furb.dao.ComandaDAO;
import com.furb.prog.web.furb.dao.ComandaProdutoDAO;
import com.furb.prog.web.furb.model.Comanda;
import com.furb.prog.web.furb.service.ComandaService;
import com.furb.prog.web.furb.service.ProdutoService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/RestAPIFurb/comandas")
@Api(value="Web Service REST da Prova de Suficiencia Prog Web II")
public class ComandaController {

    @Autowired
    private ComandaService comandaService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ComandaDAO>> listar() {
        List<Comanda> comandas = comandaService.obterTodos();

        List<ComandaDAO> collect = comandas.stream()
                .map(comanda -> modelMapper.map(comanda, ComandaDAO.class))
                .toList();

        if (!comandas.isEmpty()) {
            return ResponseEntity.ok().body(collect);
        }

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComandaProdutoDAO> detalhar(@PathVariable Long id) {
        Comanda comanda = comandaService.obterPorId(id);

        if (comanda != null) {
            return ResponseEntity.ok().body(modelMapper.map(comanda, ComandaProdutoDAO.class));
        }

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Comanda> cadastrar(@RequestBody Comanda comanda) {
        AtomicBoolean isProdutoRepetido = new AtomicBoolean(false);
        comanda.getProdutos().forEach(produto -> {
            if (produtoService.obterPorId(produto.getId()) != null) {
                isProdutoRepetido.set(true);
            }
        });

        if (isProdutoRepetido.get()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O ID inserido do produto já existe");
        }

        Comanda save = comandaService.criarComanda(comanda);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> remover(@PathVariable Long id) {
        String comanda = comandaService.excluirComanda(id);
        if (comanda != null) {
            return ResponseEntity.ok().body(comanda);
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O ID inserido não existe");
    }

}