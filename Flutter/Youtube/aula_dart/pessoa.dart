class Pessoa {
  //String? podeNulo;
  //late String receberaValorMaisTarde;   // a carga será feita posteiormente
  //late String _nome; // Private // a carga será feita posteiormente
  String nome;
  String sobrenome;

  get nomeCompleto => this.nome + ' ' + this.sobrenome;

  //get nome => this._nome;
  //set nome(n) => this.nome = n;

  Pessoa(
      {required this.nome,
      required this.sobrenome}); // o construtor obriga um valor
}
