import 'dart:io';

main() {
  String path = '/home/marcelo';
  Directory dir = Directory(path);

  if(dir.existsSync()) {
    print('A pasta Existe !!');
  } else {
    print('A pasta não existe !!');
  }

  print('\n\n-----------------------------------\n\n');

  // Como criar e remover um diretório no sistema de arquivos temporários

  dir = Directory.systemTemp.createTempSync();

  print(dir.path);

  if(dir.existsSync()) {
    print('Removendo a pasta ${dir.path}');
    dir.deleteSync();
  }
}
