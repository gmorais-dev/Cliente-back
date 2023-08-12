package com.cliente.aplicacao.repository;

import com.cliente.aplicacao.model.Cliente;
import com.cliente.aplicacao.model.telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByCpf(int cnpjcpf);
    


}
