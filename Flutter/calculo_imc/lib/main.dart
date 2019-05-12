import 'package:flutter/material.dart';

// Método principal responsável pela execução do aplicativo
void main() {
  runApp(MaterialApp(
    home: Home(),
  ));
}

/**
 * Classe responsável pela chamada da montagem da interface
 */
class Home extends StatefulWidget {
  @override
  _HomeState createState() => _HomeState();
}

/**
 * Classe responsável pela inclusão dos componentes da interface
 */
class _HomeState extends State<Home> {
  TextEditingController pesoControler = TextEditingController();
  TextEditingController alturaControler = TextEditingController();

  // Chave Global para usar no formulário
  GlobalKey<FormState> _formKey = GlobalKey<FormState>();

  String _infoText = "Informe seus dados !";

  // Método responsável por inicializar as variáveis dos campos da tela
  void _resetFields() {
    pesoControler.text = "";
    alturaControler.text = "";
    setState(() {
      _infoText = "Informe seus dados !";
    });
  }

  // Método responsável por efetuar literalmente o cálculo do IMC
  void _calculaIMC() {
    setState(() {
      double peso = double.parse(pesoControler.text);
      double altura = double.parse(alturaControler.text) / 100;
      double imc = peso / (altura * altura);
      if (imc < 18.6) {
        _infoText = "Abaixo do Peso (${imc.toStringAsPrecision(4)})";
      } else if (imc >= 18.6 && imc < 24.9) {
        _infoText = "Peso Ideal (${imc.toStringAsPrecision(4)})";
      } else if (imc >= 24.9 && imc < 29.9) {
        _infoText = "Levemente acima do peso (${imc.toStringAsPrecision(4)})";
      } else if (imc >= 29.9 && imc < 34.9) {
        _infoText = "Obesidade Grau I (${imc.toStringAsPrecision(4)})";
      } else if (imc >= 34.9 && imc < 39.9) {
        _infoText = "Obesidade Grau II (${imc.toStringAsPrecision(4)})";
      } else if (imc >= 39.9) {
        _infoText = "Obesidade Grau III (${imc.toStringAsPrecision(4)})";
      }
    });
  }

  // Método responsável por agrupar os componentes gráficos do aplicativo
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("Calculadora de IMC"),
          centerTitle: true,
          backgroundColor: Colors.green,
          actions: <Widget>[
            IconButton(
              icon: Icon(Icons.refresh),
              onPressed: _resetFields,
            )
          ],
        ),
        backgroundColor: Colors.white,
        body: SingleChildScrollView(
            padding: EdgeInsets.fromLTRB(10.0, 0, 10.0, 0),
            child: Form(
              key: _formKey,
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.stretch,
                children: <Widget>[
                  Icon(Icons.account_circle, size: 120.0, color: Colors.green),
                  TextFormField(
                    keyboardType: TextInputType.number,
                    decoration: InputDecoration(
                        labelText: "Peso (kg)",
                        labelStyle: TextStyle(color: Colors.green)),
                    textAlign: TextAlign.center,
                    style: TextStyle(color: Colors.green, fontSize: 25.0),
                    controller: pesoControler,
                    validator: (value) {
                      if (value.isEmpty) {
                        return "Insera seu Peso !";
                      }
                    },
                  ),
                  TextFormField(
                    keyboardType: TextInputType.number,
                    decoration: InputDecoration(
                        labelText: "Altura (cm)",
                        labelStyle: TextStyle(color: Colors.green)),
                    textAlign: TextAlign.center,
                    style: TextStyle(color: Colors.green, fontSize: 25.0),
                    controller: alturaControler,
                      validator: (value) {
                        if (value.isEmpty) {
                          return "Insera sua Altura !";
                        }
                      }
                  ),
                  Padding(
                      padding: EdgeInsets.only(top: 10, bottom: 10),
                      child: Container(
                          height: 50.0,
                          child: RaisedButton(
                            onPressed: () {
                              if (_formKey.currentState.validate()) {
                                _calculaIMC();
                              }
                            },
                            child: Text("Calcular",
                                style: TextStyle(
                                    color: Colors.white, fontSize: 25.0)),
                            color: Colors.green,
                          ))),
                  Text(
                    _infoText,
                    textAlign: TextAlign.center,
                    style: TextStyle(color: Colors.green, fontSize: 25.0),
                  )
                ],
              ),
            )));
  }
}
