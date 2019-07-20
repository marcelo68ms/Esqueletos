import 'dart:convert';
import 'dart:html';

import 'package:http/http.dart' as http;

void main() {
  // Monitorar o click do botão da página
  querySelector('#busca').onClick.listen((a) async {

    // Captura o valor digitado no campo CEP
    String cep = (querySelector('#cep') as InputElement).value;

    // Efetua o consumo do servivo Rest 
    String url = 'http://viacep.com.br/ws/$cep/json/';
    var response = await http.get(url);
    var body = json.decode(response.body);
    print(body);

  });
}
