package br.unisinos.controletarefas.controller;

import br.unisinos.controletarefas.entity.Categoria;
import br.unisinos.controletarefas.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// @RestController: Define que esta classe responde a requisições web e que o retorno dos métodos 
// será automaticamente convertido para o formato JSON no corpo da resposta HTTP.
@RestController
// @RequestMapping("/categorias"): Define a "URL base" para todos os métodos desta classe.
@RequestMapping("/categorias")
public class CategoriaController {

    // O Controller não acessa o banco. Ele chama o Service para executar as regras de negócio.
    @Autowired
    private CategoriaService categoriaService;

    // POST: Cria uma nova categoria
    // @RequestBody: Pega o JSON que o usuário enviou (via Postman/Swagger) e transforma no objeto Categoria do Java.
    @PostMapping
    public ResponseEntity<Categoria> criar(@RequestBody Categoria categoria) {
        Categoria novaCategoria = categoriaService.salvar(categoria);
        // Retorna o HTTP Status 200 (OK) junto com o objeto criado.
        return ResponseEntity.ok(novaCategoria);
    }

    // GET: Lista todas as categorias
    @GetMapping
    public ResponseEntity<List<Categoria>> listarTodas() {
        return ResponseEntity.ok(categoriaService.listarTodas());
    }

    // GET: Busca uma categoria específica pelo ID
    // @PathVariable: Captura o número que o usuário digitou na URL (ex: /categorias/5) e joga na variável 'id'.
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaService.buscarPorId(id);
        // Tratamento de erro: Se achou, mapeia para Status 200 (OK). Se o Optional estiver vazio, retorna 404 (Not Found).
        return categoria.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // PUT: Atualiza uma categoria existente
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @RequestBody Categoria categoria) {
        Categoria categoriaAtualizada = categoriaService.atualizar(id, categoria);
        if (categoriaAtualizada != null) {
            return ResponseEntity.ok(categoriaAtualizada); // Retorna 200 com os dados novos.
        }
        return ResponseEntity.notFound().build(); // Retorna Erro 404 se tentarem atualizar um ID inexistente.
    }

    // DELETE: Exclui uma categoria
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (categoriaService.excluir(id)) {
            // Se deletou com sucesso, retorna Status 204 (No Content), que é o padrão REST para deleções bem-sucedidas.
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build(); // Retorna 404 se o ID não existir.
    }
}