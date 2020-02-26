import 'dart:io';

main() {
  mostraResultado(perguntaUsuario());
}

// Função que captura informações do prompt
int perguntaUsuario() {
  print('Informe um número');
  return int.parse(stdin.readLineSync(),onError: (String err) {
    print('Tem certeza que "$err" é um número ?');
    return 0;
  });
}

// Função que mostra os números digitados e ainda mostra a metade do loop
void mostraResultado(int max) {
  double half = max / 2;

  for(int i = 1; i < max; i++) {
    print(i);

    if (i == half.round())
      print('Opa, estamos no meio do caminho :D');
  }  
}