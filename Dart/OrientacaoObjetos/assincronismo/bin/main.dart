import 'dart:async';
import 'dart:io';

int contator = 0;

// Inicio do exemplo sobre assincronimo
main() {
  Duration duracao = Duration(seconds: 2); 
  // Função que fica aguardando um callback 
  Timer.periodic(duracao, finalTempo);
  print('Iniciado ${getTempo()}');
  print('------------------------------------------------');

  String path = Directory.current.path + '/teste.txt';
  File arquivo = File(path);

  Future<RandomAccessFile> dadoArquivo = arquivo.open(mode: FileMode.append);
  dadoArquivo.then((RandomAccessFile raf) {
    print('O arquivo foi Aberto !');
    raf.writeString('Olá mundo !!').then((valor){
      print('Arquivo escrito com sucesso !');
    }).catchError(() => print('Ocorreu um erro !!')).whenComplete(() => raf.close());
  });
  print('-------------------------------------------------');

  exemploAwait();
}

// Função que efetua a espera e retorna a hora atual
void finalTempo(Timer tempo) {
  print('Espera: ${getTempo()}');
  contator ++;
  if (contator >= 5) {
    tempo.cancel();
  }
}

// Função retorna a hora atual
String getTempo() {
  DateTime dt = DateTime.now();
  return dt.toString();
}

// Função usando a técnica de Await
void exemploAwait() async {
  print('Começou  :D');
  incrementaArquivo();

  print(await lerArquivo());
  print('---------------------------------------');
} 

void incrementaArquivo() {
  File arquivo = File(Directory.current.path + '/teste.txt');
  DateTime dt = DateTime.now();
  arquivo.writeAsString(dt.toString() + '\r\n', mode: FileMode.append);
}

Future<String> lerArquivo() {
  File arquivo = File(Directory.current.path + '/teste.txt');
  return arquivo.readAsString();
}