import 'dart:convert';
import 'dart:io';

main() {
  var dado = '---- Informação enviada via protocolo UDP ----';
  List<int> dataToSend = utf8.encode(dado);
  int porta = 3000;

  // Servidor
  RawDatagramSocket.bind(InternetAddress.loopbackIPv4, porta).then((RawDatagramSocket udpSocket){
    udpSocket.listen((RawSocketEvent event) {
      if(event == RawSocketEvent.read) {
        print('Servidor Operacional');
        Datagram dg = udpSocket.receive();
        print(utf8.decode(dg.data));
      }
    });

    // Cliente
    udpSocket.send(dataToSend, InternetAddress.loopbackIPv4, porta);
  });
}
