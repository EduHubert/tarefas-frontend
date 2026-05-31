package br.unisinos.controletarefas.service;

import br.unisinos.controletarefas.entity.Categoria;
import br.unisinos.controletarefas.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// A anotação @Service diz ao Spring Boot: "Esta classe contém as regras de negócio". 
// O Spring vai gerenciar essa classe automaticamente na memória.
@Service
public class CategoriaService {

    // A anotação @Autowired faz a "Injeção de Dependência". 
    // Em vez de criarmos o repositório manualmente com "new CategoriaRepository()", 
    // o Spring instancia e entrega ele pronto para usarmos as funções do banco de dados.
    @Autowired
    private CategoriaRepository categoriaRepository;

    // Criar (Create): Recebe o objeto Categoria do Controller e manda o Repository salvar no banco.
    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Ler (Read - Todos): Retorna uma lista completa com todas as categorias do banco.
    // O método findAll() já vem pronto do JPA, executando um "SELECT * FROM categorias".
    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    // Ler (Read - Por ID): Usa o Optional porque a categoria pode existir ou não.
    // O Optional previne o sistema de quebrar com o erro "NullPointerException" caso o ID não seja encontrado.
    public Optional<Categoria> buscarPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    // Atualizar (Update): Primeiro, verifica se o ID informado realmente existe no banco (existsById).
    // Se existir, garantimos que o objeto receba o ID correto e salvamos por cima da versão antiga.
    // Se não existir, retorna nulo (o Controller tratará isso devolvendo o Erro 404 Not Found).
    public Categoria atualizar(Long id, Categoria categoriaAtualizada) {
        if (categoriaRepository.existsById(id)) {
            categoriaAtualizada.setId(id);
            return categoriaRepository.save(categoriaAtualizada);
        }
        return null; 
    }

    // Deletar (Delete): Verifica se a categoria existe antes de tentar apagar.
    // Retorna 'true' se apagou com sucesso, e 'false' se o ID não existia, ajudando o Controller a responder corretamente.
    public boolean excluir(Long id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}