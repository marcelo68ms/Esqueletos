import 'package:crypto/models/moeda_dao.dart';

class MoedaRepository {
  static List<Moeda> tabela = [
    Moeda(
      icone: 'images/btc.png',
      nome: 'Bitcoin',
      sigla: 'BTC',
      preco: 18000.30,
    ),
    Moeda(
      icone: 'images/cardano.png',
      nome: 'Cardano',
      sigla: 'ADA',
      preco: 12.32,
    ),
    Moeda(
      icone: 'images/dash.png',
      nome: 'Dash',
      sigla: 'DSH',
      preco: 125.12,
    ),
    Moeda(
      icone: 'images/eos.png',
      nome: 'EOS',
      sigla: 'EOS',
      preco: 0.13,
    ),
    Moeda(
      icone: 'images/ether.png',
      nome: 'Ether',
      sigla: 'ETH',
      preco: 0.99,
    ),
    Moeda(
      icone: 'images/litecoin.png',
      nome: 'Litecoin',
      sigla: 'LTC',
      preco: 8750.35,
    ),
    Moeda(
      icone: 'images/tether.png',
      nome: 'Tether',
      sigla: 'TER',
      preco: 1.01,
    ),
    Moeda(
      icone: 'images/xlm.png',
      nome: 'XLM',
      sigla: 'XLM',
      preco: 14.15,
    ),
    Moeda(
      icone: 'images/xrp.png',
      nome: 'XRP',
      sigla: 'XRP',
      preco: 60.37,
    ),
  ];
}
