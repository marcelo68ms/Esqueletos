import 'package:flutter_application_1/models/moeda.dart';

class MoedaRepository {
  static List<Moeda> moedas = [
    Moeda(
      icone: 'images/btc.png',
      nome: 'Bitcoin',
      sigla: 'BTC',
      preco: 38000,
    ),
    Moeda(
      icone: 'images/cardano.png',
      nome: 'Cardano',
      sigla: 'ADA',
      preco: 3000,
    ),
    Moeda(
      icone: 'images/dash.png',
      nome: 'Dash',
      sigla: 'DAS',
      preco: 8000,
    ),
    Moeda(
      icone: 'images/eos.png',
      nome: 'EOS',
      sigla: 'EOS',
      preco: 600,
    ),
    Moeda(
      icone: 'images/ether.png',
      nome: 'Etherium',
      sigla: 'ETH',
      preco: 2400,
    ),
    Moeda(
      icone: 'images/litecoin.png',
      nome: 'Litecoin',
      sigla: 'LTC',
      preco: 600,
    ),
    Moeda(
      icone: 'images/tether.png',
      nome: 'Tether',
      sigla: 'TUSD',
      preco: 1,
    ),
    Moeda(
      icone: 'images/xlm.png',
      nome: 'XLM',
      sigla: 'XLM',
      preco: 2.45,
    ),
    Moeda(
      icone: 'images/xrp.png',
      nome: 'XRP',
      sigla: 'XRP',
      preco: 1.34,
    ),
  ];
}
