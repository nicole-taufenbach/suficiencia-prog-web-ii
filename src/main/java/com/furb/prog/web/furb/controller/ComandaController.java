package com.furb.prog.web.furb.controller;

import com.furb.prog.web.furb.dao.ComandaDAO;
import com.furb.prog.web.furb.service.ComandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/comandas")
public class ComandaController {

    @Autowired
    private ComandaService service;

    @GetMapping
    public Page<ComandaDAO> listar(@PageableDefault(size = 10) Pageable paginacao) {
        return service.obterTodos(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComandaDAO> detalhar(@PathVariable Long id) {
        ComandaDAO dto = service.obterPorId(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ComandaDAO> cadastrar(@RequestBody ComandaDAO dto, UriComponentsBuilder uriBuilder) {
        ComandaDAO pagamento = service.criarComanda(dto);
        URI endereco = uriBuilder.path("/pagamentos/{id}").buildAndExpand(pagamento.getId()).toUri();

        return ResponseEntity.created(endereco).body(pagamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ComandaDAO> remover(@PathVariable Long id) {
        service.excluirComanda(id);
        return ResponseEntity.noContent().build();
    }

}
