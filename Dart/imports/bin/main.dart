import 'package:http/http.dart' as http;
import 'dart:convert';

main(List<String> arguments) {
  String meuValor = 'Olá Mundo';
  List eBytes = utf8.encode(meuValor);
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
