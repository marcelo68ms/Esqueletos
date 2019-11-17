import 'dart:convert';
import 'dart:html';
import 'package:http/http.dart' as http;
import 'package:dialog/dialog.dart';

void main() {
  List cidades = List();
  cidades.add('Santos, SP');
  cidades.add('Itanhaém, SP');
  cidades.add('Blumenau, SC');
  cidades.add('Natal, RN');
  cidades.add('Salto, SP');
  cidades.add('Fortaleza, CE');

  loadData(cidades);

  querySelector('#busca').onClick.listen((a) async {
    var meuPrompt = await prompt('Qual a cidade você deseja buscar ?');
    if (meuPrompt.toString().length > 0) 
      loadData([meuPrompt.toString()]);
    else
      alert('Nenhuma cidade Informada');
  });
}

Future getWeather(String cidade) {
  String url = 'https://api.hgbrasil.com/weather?format=json-cors&key=2b474478&city_name=$cidade';
  return http.get(url);
}

void loadData(List cidades) {
  var empty = querySelector('#empty');

  if (empty !=null)
    empty.remove();
  
  cidades.forEach((cidade) {
    inserirDados(getWeather(cidade));
  });
}

void inserirDados(Future dado) async {
  var inserirDados = await dado;
  var body = json.decode(inserirDados.body);

  if (body['results']['forecast'].length > 0) {
    String html = '<div class="row">';
    html += htmlFormatado(body['results']['city_name']);
    html += htmlFormatado(body['results']['temp']);
    html += htmlFormatado(body['results']['description']);
    html += htmlFormatado(body['results']['wind_speedy']);
    html += htmlFormatado(body['results']['sunrise']);
    html += htmlFormatado(body['results']['sunset']);
    html += '</div>';

    querySelector('.table').innerHtml += html;  
  }
}

String htmlFormatado(var dado) {
  return '<div class="cell">$dado</div>';
}