import 'package:http/http.dart' as http;
import 'dart:convert';

main(List<String> arguments) {
  String meuValor = 'Olá Mundo';
  // Efetua a transformação para UTF8
  List eBytes = utf8.encode(meuValor);
  // Efetua a transformação para dados encriptados
  String encoded = base64.encode(eBytes);

  print('Encoded: $encoded');

  List dBytes = base64.decode(encoded);
  String decoded = utf8.decode(dBytes);

  print('Decoded: $decoded');

  var url = 'https://www.google.com';

  http.get(url).then((response) {
    print('Código de status da requisição: ${response.statusCode}');
  }); 
}
