package com.furb.prog.web.furb.service;

import com.furb.prog.web.furb.model.Comanda;
import com.furb.prog.web.furb.repository.ComandaRepository;
import io.swagger.annotations.ApiOperation;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComandaService {

    @Autowired
    private ComandaRepository repository;

    @ApiOperation(value="Retorna uma lista de Comandas")
    public List<Comanda> obterTodos() {
        return repository.findAll();
    }

    @ApiOperation(value="Retorna uma comanda única")
    public Comanda obterPorId(Long id) {
        return repository
                .findById(id)
                .orElse(null);
    }

    @ApiOperation(value="Salva uma comanda")
    public Comanda criarComanda(Comanda comanda) {
        return repository.save(comanda);
    }

    @ApiOperation(value="Deleta uma comanda")
    public String excluirComanda(Long id) {
        Comanda comanda = obterPorId(id);

        if (comanda != null) {
            repository.deleteById(id);

            return new JSONObject()
                    .put("success", new JSONObject().put("text", "comanda removida"))
                    .toString();
        }

        return null;
    }

}



