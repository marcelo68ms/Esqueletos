import 'package:flutter/material.dart';

// Método responsável para executar a aplicação
void main() {
  runApp(MaterialApp(title: "Contador de Pessoas", home: Home()));
}

/*
 * Classe principal para a montagem da interface da aplicação
 */
class Home extends StatefulWidget {
  @override
  _HomeState createState() => _HomeState();
}

/*
 *  Classe responsável por agrupar os métodos de montagem da interface
 */
class _HomeState extends State<Home> {
  int _people = 0;
  String _infoText = "Pode Entrar !";

  // Método responsável por apresentar a mensagem da aplicação
  void _changePeople(int delta) {
    setState(() {
      _people += delta;
      if (_people < 0) {
        _infoText = "Mundo invertido !";
      } else if (_people <= 10) {
        _infoText = "Pode Entrar !";
      } else {
        _infoText = "Lotado !!";
      }
    });
  }

  // Método responsável pela construção da interface do aplicativo
  @override
  Widget build(BuildContext context) {
    return Stack(
      children: <Widget>[
        Image.asset(
          "images/lanchonete.jpg",
          fit: BoxFit.cover,
          height: 1000.0,
        ),
        Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Text(
              "Pessoas: $_people",
              style:
                  TextStyle(color: Colors.white, fontWeight: FontWeight.bold),
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
                Padding(
                  padding: EdgeInsets.all(10.0),
                  child: FlatButton(
                    child: Text(
                      "+1",
                      style: TextStyle(fontSize: 40.00, color: Colors.white),
                    ),
                    onPressed: () {
                      _changePeople(1);
                    },
                  ),
                ),
                Padding(
                  padding: EdgeInsets.all(10.0),
                  child: FlatButton(
                    child: Text(
                      "-1",
                      style: TextStyle(fontSize: 40.00, color: Colors.white),
                    ),
                    onPressed: () {
                      _changePeople(-1);
                    },
                  ),
                )
              ],
            ),
            Text(
              _infoText,
              style: TextStyle(
                  color: Colors.white,
                  fontSize: 30.0,
                  fontStyle: FontStyle.italic),
            ),
          ],
        )
      ],
    );
  }
}
