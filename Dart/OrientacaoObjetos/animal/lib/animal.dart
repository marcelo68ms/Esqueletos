class Animal {
  String _nome = '';
  int _idade = 0;
  String _pelo = '';
 
 // Construtores
  Animal(this._nome, this._idade, this._pelo);

  // Criar os gets e sets
  String get nome => _nome;
  set nome(String value) => _nome = value;
  
  int get idade => _idade;
  set idade(int valor) => _idade = valor;

  String get pelo => _pelo
  set pelo(String value) => _pelo = value;

  // Métodos da classe
  dizAlo() => print('Olá, meu nome é $_nome e eu tenho $_idade anos, meu pêlo é $_pelo');

  _display(String mensagem) => print('Mensagem $mensagem ');

  digaAlgo(String mensagem) => _display(mensagem);
}
