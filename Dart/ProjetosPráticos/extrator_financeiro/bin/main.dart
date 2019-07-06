import 'dart:convert';
import 'dart:io';
import 'package:http/http.dart' as http;

main() {
  menu();
}

void menu() {
  print('---- Inicio ----');
  print('\nSelecione uma das opções abaixo:');
  print('1 - Ver a cotação de hoje');
  print('2 - Registrar a cotação de hoje');
  print('3 - Ver a lista de cotações registradas');

  String opcao = stdin.readLineSync();
  switch (int.parse(opcao)) {
    case 1:
      cotacao();
      break;
    case 2:
      registrar();
      break;
    case 3:
      listarDados();
      break;
    default:
      {
        print('\n\nOps, opção inválida !');
        menu();
        break;
      }
  }
}

cotacao() async {
  var data = await getData();
  print('--------- HG Brasil - Cotação --------');
  print('${data['date']} -> ${data['data']}');
}

Future getData() async {
  String url = 'https://api.hgbrasil.com/finance?key=2b474478';
  http.Response resposta = await http.get(url);
  if (resposta.statusCode == 200) {
    var dado = json.decode(resposta.body)['results']['currencies'];
    var usd = dado['USD'];
    var eur = dado['EUR'];
    var gbp = dado['GBP'];
    var ars = dado['ARS'];
    var btc = dado['BTC'];

    Map mapaFormatado = Map();
    mapaFormatado['date'] = agora(); // Data de Hoje
    mapaFormatado['data'] =
        '${usd['name']}: ${usd['buy']} | ${eur['name']}: ${eur['buy']} | ${gbp['name']}: ${gbp['buy']} | ${ars['name']}: ${ars['buy']} | ${btc['name']}: ${btc['buy']}';

    return mapaFormatado;
  } else {
    throw ('Falhou !');
  }
}

String agora() {
  var agora = DateTime.now();
  return '${agora.day.toString().padLeft(2, '0')}/${agora.month.toString().padLeft(2, '0')}/${agora.year.toString()}';
}

registrar() async {
  var hgData = await getData();
  dynamic fileData = lerArquivo();
  bool existe = false;
  
  fileData = (fileData != null && fileData.length > 0 ? json.decode(fileData) : List());

  fileData.forEach((data) {
    if(data['date'] == agora())
      existe = false;
  });

  if(!existe) {
    fileData.add({"date": agora(), "data": "${hgData['data']}"});

    Directory dir = Directory.current;
    File arquivo = File(dir.path + '/cotacao.txt');
    RandomAccessFile raf = arquivo.openSync(mode: FileMode.write);
    raf.writeStringSync(json.encode(fileData).toString());
    raf.flushSync();
    raf.closeSync();
    
    print('\n\n-------------- Dados salvos --------------');
  } else {
    print('\n\n ------------- Registro não adicionado, já existe dados de hoje --------------');
  }
}

String lerArquivo() {
  Directory dir = Directory.current;
  File arquivo = File(dir.path + '/cotacao.txt');

  if(!arquivo.existsSync()) {
    print('Arquivo Inexiste');
    return null;
  } 
  return arquivo.readAsStringSync();
}

void listarDados() {
  dynamic fileData = lerArquivo();
  fileData = (fileData != null && fileData.length > 0 ? json.decode(fileData) : List());

  print('\n\n------------------ Listagem dos Dados --------------------------');

  fileData.forEach((data) {
    print('${data['date']} -> ${data['data']} ');
  } 
  );
}