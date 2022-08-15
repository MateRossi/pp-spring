package com.mrossi.padroesprojetospring.service.impl;

import com.mrossi.padroesprojetospring.model.Cliente;
import com.mrossi.padroesprojetospring.model.ClienteRepository;
import com.mrossi.padroesprojetospring.model.Endereco;
import com.mrossi.padroesprojetospring.model.EnderecoRepository;
import com.mrossi.padroesprojetospring.service.ClienteService;
import com.mrossi.padroesprojetospring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    //Singleton: Injetar os componentes do Spring com @Autowired (feito).
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    //Strategy: Implementar os métodos definidos na interface (feito).
    //Facade: Abstrair intergrações com subsistemas, provendo uma interface simples (viaCep - feito).

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        preencherCliente(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()) {
            preencherCliente(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    private void preencherCliente(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById((cep)).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
