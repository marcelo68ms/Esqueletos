import 'dart:io';

main() async {
  bool loop = true;
  var socket = await Socket.connect('127.0.0.1', 3000);

  while(loop) {
    print('Conectado! Pode digitar !');
    String texto = stdin.readLineSync();
    socket.write(texto);
  }
  await socket.close();
  exit(0);
}
