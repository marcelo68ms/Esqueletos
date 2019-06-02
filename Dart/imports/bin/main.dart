import 'dart:convert';

main(List<String> arguments) {
  String meuValor = 'Olá Mundo';
  List eBytes = utf8.encode(meuValor);
  String encoded = base64.encode(eBytes);

  print('Encoded: $encoded');

}
