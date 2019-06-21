class Cliente {
  int cpf;
  String nome;
  String fone;
  bool ativo = false;

/*
  Cliente(String nome, int cpf, String fone) {
    this.nome = nome;
    this.cpf = cpf;
    this.fone = fone;
  }
*/
  Cliente(this.nome, this.cpf, this.fone);

  Cliente.recepcao(this.nome, this.fone) {
    print('$nome foi registrado com sucesso');
  }

  void disabilita() {
    this.ativo = false;
  }

  void habilita() {
    this.ativo = true;
  }
}

main() {
  Cliente cliente = Cliente('Marcelo', 1920, '4028-5257');

  Cliente novoCliente = Cliente.recepcao('Alessandra', '4028-5257');

  print(cliente.nome);
  print(novoCliente.nome);
}