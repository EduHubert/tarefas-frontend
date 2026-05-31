package br.unisinos.controletarefas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// ==========================================
// CLASSE PRINCIPAL (PONTO DE ENTRADA)
// ==========================================

// @SpringBootApplication: Esta é a anotação mais poderosa do framework. 
// Ela é, na verdade, um "pacote 3 em 1" que faz a mágica acontecer por baixo dos panos:
// 1. @Configuration: Permite que esta classe registre configurações extras do sistema.
// 2. @EnableAutoConfiguration: Diz ao Spring Boot para configurar automaticamente o banco de dados (PostgreSQL) e o servidor web (Tomcat) baseado no que temos no arquivo pom.xml.
// 3. @ComponentScan: Diz ao Spring para varrer todas as pastas do projeto procurando por componentes (nossos @RestController, @Service, @Repository) para gerenciá-los na memória.
@SpringBootApplication
public class ControleTarefasApplication {

    // O método 'main' é o ponto de partida padrão de qualquer programa escrito em Java.
    // É a primeira coisa que o computador executa quando damos o "Play".
    public static void main(String[] args) {
        
        // SpringApplication.run(): Este é o comando que "liga a chave de ignição" do projeto.
        // Ele faz o seguinte:
        // - Inicia o contexto da aplicação Spring.
        // - Sobe o servidor web embutido (o Apache Tomcat) na porta 8080.
        // - Fica "escutando" para receber as requisições HTTP (GET, POST, etc.) que chegam do Postman ou Swagger.
        SpringApplication.run(ControleTarefasApplication.class, args);
    }
}