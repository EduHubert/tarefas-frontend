package br.unisinos.controletarefas.entity;

import jakarta.persistence.*;

// Representa a tabela principal do nosso sistema no banco de dados.
@Entity
@Table(name = "tarefas")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    // Define que o campo descrição pode ter até 500 caracteres (o padrão do JPA é 255).
    @Column(length = 500)
    private String descricao;

    @Column(nullable = false)
    private Boolean concluida = false; // Define um valor padrão: Toda tarefa nasce pendente (false).

    // --- RELACIONAMENTOS (Requisito fundamental do trabalho) ---
    
    // @ManyToOne: Significa "Muitos para Um". Lemos assim: "Muitas Tarefas podem pertencer a Uma Categoria".
    @ManyToOne
    // @JoinColumn: Diz ao ORM para criar uma coluna física chamada "categoria_id" na tabela "tarefas".
    // Essa coluna será uma Chave Estrangeira (Foreign Key - FK) apontando para o ID da tabela de categorias.
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    // @ManyToOne: "Muitas Tarefas podem ter Uma mesma Prioridade".
    @ManyToOne
    // Cria a Chave Estrangeira "prioridade_id" e a torna obrigatória (nullable = false), 
    // ou seja, o banco não aceita criar tarefa sem definir a prioridade.
    @JoinColumn(name = "prioridade_id", nullable = false)
    private Prioridade prioridade;

    public Tarefa() {}

    // Getters e Setters (Encapsulamento padrão)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    
    public Boolean getConcluida() { return concluida; }
    public void setConcluida(Boolean concluida) { this.concluida = concluida; }
    
    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    
    public Prioridade getPrioridade() { return prioridade; }
    public void setPrioridade(Prioridade prioridade) { this.prioridade = prioridade; }
}