import 'package:flutter/material.dart';
import './questionario.dart';
import './resultado.dart';

main() => runApp(PerguntaApp());

class _PerguntaAppState extends State<PerguntaApp> {
  var _perguntaSelecionada = 0;
  var _pontuacaoTotal = 0;

  final List<Map<String, Object>> _perguntas = const [
    {
      'texto': 'Qual é a sua cor favorita ?',
      'respostas': [
        {'texto': 'Azul', 'ponto': 10},
        {'texto': 'Verde', 'ponto': 5},
        {'texto': 'Amarelo', 'ponto': 3},
        {'texto': 'Branco', 'ponto': 4},
        {'texto': 'Preto', 'ponto': 2},
      ],
    },
    {
      'texto': 'Qual é o seu animal favorito ?',
      'respostas': [
        {'texto': 'Cachorro', 'ponto': 10},
        {'texto': 'Gato', 'ponto': 7},
        {'texto': 'Pássaro', 'ponto': 8},
        {'texto': 'Papagaio', 'ponto': 9},
      ],
    },
    {
      'texto': 'Qual é o seu número favorito ?',
      'respostas': [
        {'texto': '5', 'ponto': 10},
        {'texto': '7', 'ponto': 7},
        {'texto': '3', 'ponto': 10},
        {'texto': '0', 'ponto': 1},
      ],
    },
  ];

  void _responder(int ponto) {
    if (temPerguntaSelecionada) {
      setState(() {
        _perguntaSelecionada++;
        _pontuacaoTotal += ponto;
      });
    }
  }

  void _reiniciarQuestionario() {
    setState(() {
      _perguntaSelecionada = 0;
      _pontuacaoTotal = 0;
    });
  }

  bool get temPerguntaSelecionada {
    return _perguntaSelecionada < _perguntas.length;
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Perguntas'),
        ),
        body: temPerguntaSelecionada
            ? Questionario(
                perguntas: _perguntas,
                perguntaSelecionada: _perguntaSelecionada,
                quandoResponder: _responder,
              )
            : Resultado(_pontuacaoTotal, _reiniciarQuestionario),
      ),
    );
  }
}

class PerguntaApp extends StatefulWidget {
  const PerguntaApp({super.key});

  @override
  _PerguntaAppState createState() {
    return _PerguntaAppState();
  }
}
