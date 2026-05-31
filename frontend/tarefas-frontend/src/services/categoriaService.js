import api from './api';

export default {
  // Equivalente ao GET /categorias
  listarTodas() {
    return api.get('/categorias');
  },

  // Equivalente ao GET /categorias/{id}
  buscarPorId(id) {
    return api.get(`/categorias/${id}`);
  },

  // Equivalente ao POST /categorias
  salvar(categoria) {
    return api.post('/categorias', categoria);
  },

  // Equivalente ao PUT /categorias/{id}
  atualizar(id, categoria) {
    return api.put(`/categorias/${id}`, categoria);
  },

  // Equivalente ao DELETE /categorias/{id}
  deletar(id) {
    return api.delete(`/categorias/${id}`);
  }
};