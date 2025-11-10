package com.minierp.erp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe de Entidade (Model) que representa a tabela "pessoa" no banco de dados.
 * 
 * - Cada atributo da classe é um campo na tabela.
 * - O Hibernate, via JPA, faz o mapeamento objeto-relacional.
 * - Essa classe será usada pelo PessoaDao e PessoaBean.
 */
@Entity
@Table(name = "pessoa") // Define o nome da tabela no banco de dados
public class Pessoa {

    // Identificador único da pessoa (chave primária)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Campos básicos da entidade
    private String nome;
    private String email;
    private Integer idade;
    private String sexo;

    /**
     * Construtor padrão (obrigatório para JPA)
     * O Hibernate usa esse construtor internamente para criar os objetos
     */
    public Pessoa() {
    }

    /**
     * Construtor opcional para facilitar criação de objetos manualmente
     */
    public Pessoa(String nome, String email, Integer idade, String sexo) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.sexo = sexo;
    }

    // ================================================================
    // GETTERS e SETTERS
    // ================================================================

    /**
     * O getId() é usado para exibir o valor e identificar o registro.
     * O setId() é usado internamente pelo Hibernate ao salvar a entidade.
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Campo "nome" - armazena o nome da pessoa
     */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Campo "email" - usado para armazenar o email da pessoa
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Campo "idade" - idade da pessoa
     */
    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    /**
     * Campo "sexo" - Masculino (M), Feminino (F), Outro (O)
     */
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    // ================================================================
    // MÉTODOS AUXILIARES
    // ================================================================

    /**
     * Método auxiliar usado para exibir informações no log, console ou JSF.
     * Ex: #{pessoaBean.pessoa} -> exibirá nome + email.
     */
    @Override
    public String toString() {
        return "Pessoa [id=" + id + ", nome=" + nome + ", email=" + email + ", idade=" + idade + ", sexo=" + sexo + "]";
    }
}
