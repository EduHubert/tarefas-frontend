package br.unisinos.controletarefas.entity;

import jakarta.persistence.*;

// Define a classe como uma entidade gerenciada pelo ORM (Hibernate).
@Entity
@Table(name = "prioridades") // Nomeia a tabela no banco relacional.
public class Prioridade {

    @Id // Define o campo como Chave Primária.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremento gerenciado pelo SGBD.
    private Long id;

    @Column(nullable = false) // Torna o preenchimento do nível (ex: Alta, Baixa) obrigatório.
    private String nivel;

    // Construtor padrão sem argumentos exigido pela especificação do JPA.
    public Prioridade() {}

    // Métodos de acesso (Getters e Setters) para proteção e manipulação dos dados encapsulados.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}