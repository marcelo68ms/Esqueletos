import 'dart:io';

main(List<String> arguments) {
  // Constantes
  // Cria uma constante em tempo de compilação
  const PI = 3.1415916;
  print('O valor de PI é $PI');

  // Cria uma constante em tempo de execução
  final marcelo = new Pessoa();
  print(marcelo);

  // Int - inteiro
  int pessoas = 5;
  print(pessoas);
  
  // Double - decimais
  double decimal = 20.2;
  print(decimal);

  // Num - qualquer tipo de número
  num idade = 50;
  print(idade);

  // Conversão de tipos - 
  int teste = int.parse('45');
  print(teste);

  double teste2 = double.parse('23.23');
  print(teste2);

  // Captura de Erro
  int erro = int.parse('12.09', onError: (source){
    return 0;
  });
  print(erro);

  int erro2 = int.parse('12.09', onError: (source) => 0);
  print('Ops, de erro! $erro2');

  // Cálculos
  int anosCachorro = 7;
  int idadeCachorro = idade * anosCachorro;
  print('A sua idade em anos de cachorro é $idadeCachorro anos'); 

  // Booleanos
  bool conducao = true;
  print('condicao = $conducao');

  // Como saber o tipo de uma variável
  print(conducao.runtimeType);
  print(erro.runtimeType);

  // String - Váriaveis Texto
  String nome = 'Marcelo Santos';
  print('Olá, $nome');

  // Cria uma variável do tipo dinânica. Ela aceita qualquer tipo, porém uma vez atribuito o tipo
  // o mesmo vale daí para sempre
  var nomeDivido = nome.split(' ');
  print('Primeiro nome: ${nomeDivido[0]}');
  print('Segundo nome: ${nomeDivido[1]}');

  print(nomeDivido.runtimeType);

  String apelido = nome.substring(0,3);
  print(apelido);

  String sopa = 'Sopa de Letrinhas';
  int index = sopa.indexOf(' de ');
  print('A sopa é: ${sopa.substring(index).trim()}');
  print(index);
  print('O tamanho é de ${sopa.length}');

  String presidente = "#BolsonaroNossoPresidente";
  print('Contém hashtag: ${presidente.contains('#')}');


  // Interações com o usuário
  print('Qual é o seu nome ?');
  String nomeUsuario = stdin.readLineSync();

  nomeUsuario.isEmpty ? print('Nenhum nome foi informado !') : print('O nome informado foi $nomeUsuario');
}

class Pessoa {

}