import 'dart:io';

main() {
  mostraResultado(perguntaUsuario());
}

int perguntaUsuario() {
  print('Informe um número');
  return int.parse(stdin.readLineSync(),onError: (String err) {
    print('Tem certeza que "$err" é um número ?');
    return 0;
  });
}

void mostraResultado(int max) {
  double half = max / 2;

  for(int i = 1; i < max; i++) {
    print(i);

    if (i == half.round())
      print('Opa, estamos no meio do caminho :D');
  }  
}