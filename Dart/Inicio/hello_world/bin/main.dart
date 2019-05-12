
main(List<String> arguments) {
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
}
