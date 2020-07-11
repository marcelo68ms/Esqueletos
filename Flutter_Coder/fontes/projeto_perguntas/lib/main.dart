import 'package:flutter/material.dart';
import './questao.dart';
import './resposta.dart';

main() => runApp(PerguntaApp());

class _PerguntaAppState extends State<PerguntaApp> {
  var _perguntaSelecionada = 0;

  final List<Map<String, Object>> _perguntas = const [
    {
      'texto': 'Qual é a sua cor favorita ?',
      'respostas': ['Azul', 'Verde', 'Amarelo', 'Branco', 'Preto'],
    },
    {
      'texto': 'Qual é o seu animal favorito ?',
      'respostas': ['Cachorro', 'Gato', 'Pássaro', 'Papagaio'],
    },
    {
      'texto': 'Qual é o seu número favorito ?',
      'respostas': ['5', '7', '3', '0'],
    },
  ];

  void _responde() {
    if (temPerguntaSelecionada) {
      setState(() {
        _perguntaSelecionada++;
      });
    }
  }

  bool get temPerguntaSelecionada {
    return _perguntaSelecionada < _perguntas.length;
  }

  @override
  Widget build(BuildContext context) {
    List<String> respostas = temPerguntaSelecionada
        ? _perguntas[_perguntaSelecionada]['respostas']
        : null;

    return MaterialApp(
        home: Scaffold(
      appBar: AppBar(
        title: Text('Perguntas'),
      ),
      body: temPerguntaSelecionada
          ? Column(
              children: [
                Questao(_perguntas[_perguntaSelecionada]['texto']),
                ...respostas.map((t) => Resposta(t, _responde)).toList(),
              ],
            )
          : Center(
              child: Text(
                'Parabéns !',
                style: TextStyle(fontSize: 28),
              ),
            ),
    ));
  }
}

class PerguntaApp extends StatefulWidget {
  _PerguntaAppState createState() {
    return _PerguntaAppState();
  }
}
