class Animal {
  String _nome = '';
  int _idade = 0;
  String _pelo = '';
 
  Animal(this._nome, this._idade, this._pelo);
  
  dizAlo() => print('Olá, meu nome é $_nome e eu tenho $_idade anos, meu pêlo é $_pelo');

  _display(String mensagem) => print('Mensagem $mensagem ');

  digaAlgo(String mensagem) => _display(mensagem);
}
