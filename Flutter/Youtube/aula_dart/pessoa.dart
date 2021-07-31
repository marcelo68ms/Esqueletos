class Pessoa {
  //String? podeNulo;
  //late String receberaValorMaisTarde;
  //late String _nome; // Private
  String nome;
  String sobrenome;

  get nomeCompleto => this.nome + ' ' + this.sobrenome;

  //get nome => this._nome;
  //set nome(n) => this.nome = n;

  Pessoa(
      {required this.nome,
      required this.sobrenome}); // o construtor obriga um valor
}
