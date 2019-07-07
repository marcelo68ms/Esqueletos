import 'dart:async';

int contator = 0;

// Inicio do exemplo sobre assincronimo
main() {
  Duration duracao = Duration(seconds: 2);
  Timer.periodic(duracao, finalTempo);
  print('Iniciado ${getTempo()}');
}

void finalTempo(Timer tempo) {
  print('Espera: ${getTempo()}');
  contator ++;
  if (contator >= 5) {
    tempo.cancel();
  }
}

String getTempo() {
  DateTime dt = DateTime.now();
  return dt.toString();
}