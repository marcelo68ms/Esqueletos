import 'package:flutter/material.dart';

class Resposta extends StatelessWidget {
  final String respostatxt;

  final void Function() onSelecao;

  Resposta(this.respostatxt, this.onSelecao);

  @override
  Widget build(BuildContext context) {
    return Container(
      width: double.infinity,
      child: RaisedButton(
        textColor: Colors.white,
        color: Colors.blue,
        child: Text(respostatxt),
        onPressed: onSelecao,
      ),
    );
  }
}
