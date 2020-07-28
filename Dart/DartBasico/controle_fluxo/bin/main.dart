import 'dart:io';

main(List<String> arguments) {

  // Trabalho com o if/else
  print('Qual é a sua idade ?');
  int idade = int.parse(stdin.readLineSync());

  if (idade < 18) {
    print('Você é menor de idade !');
    print('Sua idade é $idade');
  } else {
    print('Você é maior de idade');
  }

  // Escopo de variável
  if (idade == 43) {
    print('Você tem 43 anos !');
  } else {
    // essa variável só é vista dentro desse parênteses
    bool temDebito = true;
    print('Você tem $idade anos e ${temDebito ? '' : 'não '}tem dívidas');
  }

  // Switch e sua estrutura
  idade = 65;
  switch(idade) {
    case 18:
      print('Você pode tirar a CNH');
      break;
    case 21:
      print('Você possui a maioridade');
      break;
    case 65:
      print('Você pode se aposentar');
      break;
    default:
      print('Nada de especial para sua idade');
      break;
  }

  // Loops
  // For
  for (int i = 0; i < 10; i += 2) {
    print('for: $i');
  }

  // For com listas
  List letras = ['a', 'b', 'c', 'd' ];
  for (int i = 0; i < letras.length; i ++) {
    print('for: $i - ${letras[i]}');
  }

  // For com listas simplificado
  for(String l in letras) {
    print('For in: $l');
  }

  // While
  int j = 0;
  while(j < 10) {
    print('while: $j');
    j++;
  }

  // do while
  int k = 0;
  do {
    print('Do while: $k');
    k++;
  } while(k < 10);

  // for each
  List pessoas = ['Marcelo', 'Alessandra', 'Mauro', 'Núbio', 'Margô'];
  print(pessoas);
  for (String l in pessoas) {
    print(l);
  }

  // Sintaxe do For each
  pessoas.forEach((pessoa) {
    print(pessoa);
  });

  pessoas.forEach((pessoa) => print(pessoa));
}
