import 'dart:convert';
import 'dart:io';
import 'package:archive/archive.dart';
import 'package:path/path.dart' as pkpath;

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
  print('------------------------------------------------');
  print(comprimida);

  // Dados Descompactados
  List descompactado = gzip.decode(comprimida);

  print('Original ${original.length} bytes');
  print('Comprimido ${comprimida.length} bytes');
  print('Descomprimido ${descompactado.length} bytes');

  String decoded = utf8.decode(descompactado);
  print(decoded);
  assert(dado == decoded);

  // Efetua uma nova compressão e efetua uma comparativo entre zlib e gzip
  int zlib_comp = testeCompressao(zlib);
  int gzip_comp = testeCompressao(gzip);

  print('zlib = ${zlib_comp} bytes');
  print('gzip = ${gzip_comp} bytes');
  print('------------------------------------------------');

  List<String> arquivos = List<String>();
  // Trabalha com diretórios a partir da localização atual
  Directory.current.listSync().forEach((FileSystemEntity fse) {
    if(fse.statSync().type == FileSystemEntityType.file) {
      arquivos.add(fse.path);
    } 
  });
  String zipFile = '${Directory.current.path}/comprimido.zip';
  zip(arquivos, zipFile);

  unzip(zipFile, '${Directory.current.path}/descomprimido');
}

// Funcão responsável pela criação do arquivo ZIP
void zip(List<String> arquivos, String arquivo) {
  Archive archive = Archive();
  arquivos.forEach((String path){
    File arquivo = File(path);
    ArchiveFile archiveFile = ArchiveFile(pkpath.basename(path), arquivo.lengthSync(), arquivo.readAsBytesSync());
    archive.addFile(archiveFile);
  });

  ZipEncoder encoder = ZipEncoder();
  File f = File(arquivo);
  f.writeAsBytesSync(encoder.encode(archive));
  print('Compressão bem sucessida');
}

// Responsável por descompactar os arquivos de um ZIP para um diretório.
void unzip(String zip, String path) {
  File file = File(zip);
  Archive archive = ZipDecoder().decodeBytes(file.readAsBytesSync());
  archive.forEach((ArchiveFile archiveFile){
    File file = File(path + '/' + archiveFile.name);
    file.createSync(recursive: true);
    file.writeAsBytesSync(archiveFile.content);
  });
  print('Arquivo Descomprimido');
}

// Gerar informações para comprimir
String gerarDado() {
  String dado = '';
  for(int i = 0; i < 1000; i++) {
    dado = dado + 'Olá mundo \r\n';
  }
  return dado;
}

// Efetua a compressão das informações 
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
