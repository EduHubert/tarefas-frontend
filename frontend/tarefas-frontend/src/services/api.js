import axios from 'axios';

// Cria uma instância do axios com a URL base do seu Spring Boot
const api = axios.create({
  baseURL: 'http://localhost:8080', 
  headers: {
    'Content-Type': 'application/json'
  }
});

export default api;