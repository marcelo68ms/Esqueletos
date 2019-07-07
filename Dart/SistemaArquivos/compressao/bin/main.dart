import 'dart:convert';
import 'dart:io';

main() {
  String dado = '';
  for(int i = 0; i < 100; i++) {
    dado = dado + 'Olá mundo \r\n';
  }

  // Dados originais
  List original = utf8.encode(dado);

  // Dados comprimidos
  List comprimida = gzip.encode(original);

  print(original);
  print('-------------;----------------------------------');
  print(comprimida);

  // Dados Descompactados
  List descompactado = gzip.decode(comprimida);

  print('Original ${original.length} bytes');
  print('Comprimido ${comprimida.length} bytes');
  print('Descomprimido ${descompactado.length} bytes');

  String decoded = utf8.decode(descompactado);
  print(decoded);
  assert(dado == decoded);
}
