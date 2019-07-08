import 'dart:convert';
import 'dart:io';

main() async {
  var serverSocket = await ServerSocket.bind('127.0.0.1', 3000);
  print('Escutando mensagens na porta 3000');

  await for (var socket in serverSocket) {
    socket.listen((List valores){
      print('${socket.remoteAddress}:${socket.remotePort} = ${utf8.decode(valores)}');
      
    });
  }
}