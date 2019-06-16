class Pessoa {
  String nome;
  int idade;
  double altura;
  double saldo = 10.15;

  void aniversario() {
    idade++;
  }

  void dorme() {
    print('$nome está dormindo');
  }

  double diferencaSaldo(double saldo) {
    // this é o item da classe e não a do método
    return this.saldo - saldo;
  }
}

main() {
  Pessoa pessoa1 = new Pessoa();
  pessoa1.nome = 'Marcelo';
  pessoa1.idade = 50;
  pessoa1.altura = 1.70;

  pessoa1.dorme();

}