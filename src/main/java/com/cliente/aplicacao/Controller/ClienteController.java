package com.cliente.aplicacao.Controller;

import com.cliente.aplicacao.model.Cliente;
import com.cliente.aplicacao.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;




public class ClienteController 
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
            return clienteRepository.findByAtivo(ativo);
        } else {
            return clienteRepository.findAll();
        }
    }
    @postmapping 
    public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
        if (clienteRepository.findByCpfCnpj(cliente.getCpfCnpj()) != null) {
            throw new IllegalArgumentException("Já existe um cliente cadastrado com o CPF/CNPJ informado");
        }
        return clienteRepository.save(cliente);
    }
    @putmapping 
     public Cliente atualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado com o ID: " + id));
        cliente.setNome(clienteAtualizado.getNome());
        cliente.setTipo(clienteAtualizado.getTipo());
        cliente.setCpfCnpj(clienteAtualizado.getCpfCnpj());
        cliente.setRgIe(clienteAtualizado.getRg());
        cliente.setDataCadastro(clienteAtualizado.getDataCadastro());
        cliente.setAtivo(clienteAtualizado.isAtivo());
        cliente.setTelefones(clienteAtualizado.getTelef());

        }
        
        
@DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Long id) {
        Cliente cliente = clienteRepository.findById(id);
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado com o ID: " + id));

        clienteRepository.delete(cliente);



        


}
