package com.furb.prog.web.furb.service;

import com.furb.prog.web.furb.dao.ComandaDAO;
import com.furb.prog.web.furb.model.Comanda;
import com.furb.prog.web.furb.repository.ComandaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ComandaService {

    @Autowired
    private ComandaRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<ComandaDAO> obterTodos(Pageable paginacao) {
        return repository
                .findAll(paginacao)
                .map(p -> modelMapper.map(p, ComandaDAO.class));
    }

    public ComandaDAO obterPorId(Long id) {
        Comanda comanda = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return modelMapper.map(comanda, ComandaDAO.class);
    }

    public ComandaDAO criarComanda(ComandaDAO dao) {
        Comanda comanda = modelMapper.map(dao, Comanda.class);
        repository.save(comanda);

        return modelMapper.map(comanda, ComandaDAO.class);
    }

    public void excluirComanda(Long id) {
        repository.deleteById(id);
    }

}
