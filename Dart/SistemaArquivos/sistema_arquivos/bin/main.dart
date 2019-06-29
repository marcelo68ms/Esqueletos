import 'dart:io';

main() {
  String path = '/home/marcelo';
  Directory dir = Directory(path);

  if(dir.existsSync()) {
    print('A pasta Existe !!');
  } else {
    print('A pasta não existe !!');
  }

  print('-----------------------------------------------');

  // Como criar e remover um diretório no sistema de arquivos temporários

  dir = Directory.systemTemp.createTempSync();

  print(dir.path);

  if(dir.existsSync()) {
    print('Removendo a pasta ${dir.path}');
    dir.deleteSync();
  }

  print('-----------------------------------------------');

  dir = Directory.current;
  print('Path atual: ${dir.path}');

  List<FileSystemEntity> listaPastas = dir.listSync(recursive: true);
  print('Itens na lista: ${listaPastas.length}');

  // Varre todos os arquivos da lista capturada
  listaPastas.forEach((FileSystemEntity valor) {
  // Captura os dados dos arquivos 
  FileStat stat = valor.statSync();

  print('Path: ${valor.path}');
  print('Tipo: ${stat.type}');
  print('Alterado em: ${stat.changed}');
  print('Modificado em: ${stat.modified}');
  print('Acessado em: ${stat.accessed}');
  print('Modo de Pemissão: ${stat.mode}');
  print('Tamanho: ${stat.size} bytes.\n');

  print('-----------------------------------------------');

  // Ler dados de um arquivo texto
  File arquivo = File(dir.path + '/meu_arquivo.txt');
  lerArquivo(arquivo);
  });
}

void lerArquivo(File arquivo) {
  if (!arquivo.existsSync()) {
    print('Aquivo não existe');
    return;
  }

  print('Iniciando a leitura do arquivo');
  print(arquivo.readAsStringSync());

  print('Lendo os bytes ...');
  List valores = arquivo.readAsBytesSync();
  valores.forEach((valor) => print(valor));

}