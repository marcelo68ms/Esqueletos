import 'package:flutter/material.dart';

class Resultado extends StatelessWidget {
  final int pontuacao;
  final void Function() onReiniciarQuestionario;

  Resultado(this.pontuacao, this.onReiniciarQuestionario);

  String get fraseResultado {
    if (pontuacao < 8) {
      return 'Parabéns !';
    } else if (pontuacao < 12) {
      return 'Você é Bom !';
    } else if (pontuacao < 16) {
      return 'Impressionante';
    } else {
      return 'Magnífico !!';
    }
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Center(
          child: Text(
            fraseResultado,
            style: TextStyle(fontSize: 28),
          ),
        ),
        TextButton(
          onPressed: onReiniciarQuestionario,
          child: Text(
            'Reiniciar ?',
            style: TextStyle(fontSize: 18),
          ),
        )
      ],
    );
  }
}
