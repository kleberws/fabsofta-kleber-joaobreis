export class Usuario {
  id: number;
  nome: string;
  email: string;
  senha: string;
  tipo: string;
  dataDeNascimento: string; 
  constructor(
    id: number,
    nome: string,
    email: string,
    senha: string,
    tipo: string,
    dataDeNascimento: string
  ) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.senha = senha;
    this.tipo = tipo;
    this.dataDeNascimento = dataDeNascimento;
  }
}