void main() {
  String nome = "Marcelo";
  nome = "Santos";
  print(nome); 

  int idade = 25;
  double altura = 1.70;
  bool simnao = true;

  if (idade < 30) {
    print('Jovem');
  }
  print(idade);
  print(altura);
  print(simnao);

  // Listas - List
  List listaProdutos = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'Feijão', 8.65, true];
  print(listaProdutos);
  print(listaProdutos.length);
  print(listaProdutos[10]);

  // Listas - Maps
  Map usuario = {
    'nome': 'Marcelo',
    'idade': 50,
    'altura': 1.7,
    'twiter': true,
    45:'numero quarenta'
  };
  print(usuario);
  print(usuario.length);
  print(usuario['idade']);
  print(usuario[45]);

  // Variáveis Alternativas
 
  // var = qualquer tipo de dado
  var qualquer = 67.3;
  print(qualquer);

  var listagem = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'Feijão', 8.65, true];
  print(listagem);

  dynamic flutua;
  flutua = 'Nome';

  print(flutua);
  flutua = 23.5;

  print(flutua);
}