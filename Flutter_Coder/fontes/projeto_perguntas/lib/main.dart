import 'package:flutter/material.dart';
import './questao.dart';

main() => runApp(PerguntaApp());

class _PerguntaAppState extends State<PerguntaApp> {
  var _perguntaSelecionada = 0;

  void _responde() {
    setState(() {
      _perguntaSelecionada++;
    });
    print(_perguntaSelecionada);
  }

  @override
  Widget build(BuildContext context) {
    final List<String> perguntas = [
      'Qual é a sua cor favorita ?',
      'Qual é o seu animal favorito ?',
      'Qual é o seu número favorito ?',
    ];

    return MaterialApp(
        home: Scaffold(
      appBar: AppBar(
        title: Text('Perguntas'),
      ),
      body: Column(
        children: [
          Questao(perguntas[_perguntaSelecionada]),
          RaisedButton(
            child: Text('Resposta 1'),
            onPressed: _responde,
          ),
          RaisedButton(
            child: Text('Resposta 2'),
            onPressed: _responde,
          ),
          RaisedButton(
            child: Text('Resposta 3'),
            onPressed: _responde,
          ),
        ],
      ),
    ));
  }
}

class PerguntaApp extends StatefulWidget {
  _PerguntaAppState createState() {
    return _PerguntaAppState();
  }
}
