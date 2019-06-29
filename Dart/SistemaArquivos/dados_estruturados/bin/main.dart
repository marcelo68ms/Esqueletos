
import 'dart:convert';
import 'dart:io';

main() {
  Map<String, String> dado = Map();
  dado.putIfAbsent('1', ()=> 'Alessandra');
  dado.putIfAbsent('2', ()=> 'Marcelo');
  dado.putIfAbsent('3', ()=> 'Mauro');
  dado.putIfAbsent('4', ()=> 'Murilo');
  dado.putIfAbsent('5', ()=> 'Núbio');

  Directory dir = Directory.current;
  File arquivo = File(dir.path + '/json.txt');

  escreveArquivo(arquivo, json.encode(dado).toString());

}

void escreveArquivo(File arquivo, String dado) {
  RandomAccessFile raf = arquivo.openSync(mode: FileMode.write);
  raf.writeStringSync(dado);
  raf.flushSync();
  raf.closeSync();
}
