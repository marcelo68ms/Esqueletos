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

  String opcao = stdin.readLineSync();
  switch (int.parse(opcao)) {
    case 1:
      hoje();
      break;
    default:
      {
        print('\n\nOps, opção inválida !');
        menu();
        break;
      }
  }
}

hoje() async {
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
