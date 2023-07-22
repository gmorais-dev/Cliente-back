package com.cliente.aplicacao.Controller;

import com.cliente.aplicacao.model.Cliente;
import com.cliente.aplicacao.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public class ClienteController {
    @RestController
    @RequestMapping("/clientes")
    public  class ClienteController {

        @Autowired
        private ClienteRepository clienteRepository;
    }
    @GetMapping
    public List<Cliente> consultarClientes(@RequestParam(required = false) String nome,
                                           @RequestParam(required = false) boolean ativo) {
        if (nome != null && ativo) {
            return clienteRepository.findByNomeAndAtivo(nome, true);
        } else if (nome != null) {
            return clienteRepository.findByNome(nome);
        } else if (ativo) {
            return clienteRepository.findByAtivo(true);
        } else {
            return clienteRepository.findAll();
        }
    }
}
