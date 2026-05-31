package br.unisinos.controletarefas.entity;

import jakarta.persistence.*;

// @Entity: Esta é a anotação mais importante do ORM. Ela avisa o Spring/Hibernate 
// que esta classe não é apenas um código Java comum, mas sim a representação de uma tabela no banco de dados.
@Entity
// @Table: Permite escolher o nome exato que a tabela terá no PostgreSQL (neste caso, "categorias" no plural).
@Table(name = "categorias")
public class Categoria {

    // @Id: Define que este campo será a Chave Primária (Primary Key - PK) da tabela.
    @Id
    // @GeneratedValue: Diz que o ID será gerado automaticamente. O "GenerationType.IDENTITY" 
    // é a estratégia perfeita para PostgreSQL, dizendo para ele usar o "AUTO_INCREMENT" do próprio banco.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column: Configura as regras da coluna no banco. "nullable = false" significa que o banco 
    // vai proibir o cadastro de uma categoria sem nome (NOT NULL).
    @Column(nullable = false)
    private String nome;

    // Construtor vazio: É uma exigência estrita do JPA/Hibernate. Ele precisa desse construtor 
    // para conseguir criar os objetos na memória quando busca os dados do banco.
    public Categoria() {}

    // Getters e Setters: Seguem o princípio da Encapsulação (Orientação a Objetos).
    // Eles permitem que o Service e o Controller leiam e modifiquem os dados de forma segura.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}