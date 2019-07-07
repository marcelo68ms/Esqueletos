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

  int zlib_comp = testeCompressao(zlib);
  int gzip_comp = testeCompressao(gzip);

  print('zlib = ${zlib_comp} bytes');
  print('gzip = ${gzip_comp} bytes');

}

String gerarDado() {
  String dado = '';
  for(int i = 0; i < 1000; i++) {
    dado = dado + 'Olá mundo \r\n';
  }
  return dado;
}

int testeCompressao(var codec) {
  String dado = gerarDado();
  
  List original = utf8.encode(dado);
  List comprimido = codec.encode(original);
  List descomprimido = codec.decode(comprimido);

  print('Testando ${codec.toString()}');  
  print('Original ${original.length} bytes');
  print('Comprimido ${comprimido.length} bytes');
  print('Descomprimido ${descomprimido.length} bytes');

  String decoded = utf8.decode(descomprimido);
  assert(dado == decoded);
  return comprimido.length;
}
