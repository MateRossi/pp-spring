package com.mrossi.padroesprojetospring.service;

import com.mrossi.padroesprojetospring.model.Cliente;
import org.springframework.stereotype.Service;

public interface ClienteService {

    Iterable<Cliente> buscarTodos();
    Cliente buscarPorId(Long id);
    void inserir(Cliente cliente);
    void atualizar(Long id, Cliente cliente);
    void deletar(Long id);
}
