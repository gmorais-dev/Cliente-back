package com.cliente.aplicacao.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Cliente{



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String nome;
        private int cpf;
        private int Cnpj;
        private int Rg;
        private Date DataCadastro;
        private boolean ativo;

        public Cliente(long id, String nome, int cpf, int cnpj, int rg, Date dataCadastro, boolean ativo, List<telefone> telefones) {
            this.id = id;
            this.nome = nome;
            this.cpf = cpf;
            Cnpj = cnpj;
            Rg = rg;
            DataCadastro = dataCadastro;
            this.ativo = ativo;
            this.telefone = telefones;
        }

    @OneToMany(mappedBy = "cliente", cascade =  CascadeType.ALL)
    @JsonIgnoreProperties("cliente")
    private List<telefone> telefone;


        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getCpf() {
            return cpf;
        }

        public void setCpf(int cpf) {
            this.cpf = cpf;
        }

        public int getCnpj() {
            return Cnpj;
        }

        public void setCnpj(int cnpj) {
            Cnpj = cnpj;
        }

        public int getRg() {
            return Rg;
        }

        public void setRg(int rg) {
            Rg = rg;
        }

        public Date getDataCadastro() {
            return DataCadastro;
        }

        public void setDataCadastro(Date dataCadastro) {
            DataCadastro = dataCadastro;
        }

        public boolean isAtivo() {
            return ativo;
        }

        public void setAtivo(boolean ativo) {
            this.ativo = ativo;
        }



    }


