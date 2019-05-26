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

}
