import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8081/api', // Base URL of the Spring Boot API
});

export default api;
