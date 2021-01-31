import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:async';
import 'dart:convert';

// Constante que passa o endereço onde o serviço de cotação está exposto
const request = "https://api.hgbrasil.com/finance?format=json&key=2b474478";

/*
 * Método principal responsável pela execução da aplicação
 */
void main() async {
  runApp(MaterialApp(
    home: Home(),
    theme: ThemeData(hintColor: Colors.amber, primaryColor: Colors.white),
  ));
}

/*
 * Método responsável pela carga dos dados do serviço de cotação
 */
Future<Map> getData() async {
  http.Response response = await http.get(request);
  return json.decode(response.body);
}

/*
 * Classe responsável pela montagem da tela da aplicação do tipo StateFul
 */
class Home extends StatefulWidget {
  @override
  _HomeState createState() => _HomeState();
}

/*
 * Classe que agrupa os componentes visuais e suas regras
 */
class _HomeState extends State<Home> {
  final realController = TextEditingController();
  final dolarController = TextEditingController();
  final euroController = TextEditingController();
  final bitcoinController = TextEditingController();

  double dolar;
  double euro;
  double btc;

  // Método que trabalha com as mudanças do campo em real
  void _realMudou(String texto) {
    double real = double.parse(texto);
    dolarController.text = (real / dolar).toStringAsFixed(2);
    euroController.text = (real / euro).toStringAsFixed(2);
    bitcoinController.text = (real / btc).toStringAsFixed(8);
  }

  // Método que trabalha com as mudanças do campo em dolar
  void _dolarMudou(String texto) {
    double dolar = double.parse(texto);
    realController.text = (dolar * this.dolar).toStringAsFixed(2);
    euroController.text = (dolar * this.dolar / euro).toStringAsFixed(2);
    bitcoinController.text = (dolar * this.dolar / btc).toStringAsFixed(8);
  }

  // Método que trabalha com as mudanças do campo em Euro
  void _euroMudou(String texto) {
    double euro = double.parse(texto);
    realController.text = (euro * this.euro).toStringAsFixed(2);
    dolarController.text = (euro * this.euro / dolar).toStringAsFixed(2);
    bitcoinController.text = (euro * this.euro / btc).toStringAsFixed(8);
  }

  // Método que trabalha com as mudanças do campo em BTC
  void _bitcoinMudou(String texto) {
    double btc = double.parse(texto);
    realController.text = (btc * this.btc).toStringAsFixed(2);
    dolarController.text = (btc * this.btc / dolar).toStringAsFixed(2);
    euroController.text = (btc * this.btc / euro).toStringAsFixed(2);
  }

  // Método responsável pela efetiva montagem visual da tela
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.black,
      appBar: AppBar(
        title: Text("Cotação/Conversor"),
        backgroundColor: Colors.amber,
        centerTitle: true,
      ),
      body: FutureBuilder<Map>(
          future: getData(),
          builder: (context, snapshot) {
            switch (snapshot.connectionState) {
              case ConnectionState.none:
              case ConnectionState.waiting:
                return Center(
                    child: Text(
                  "Carregando Dados ...",
                  style: TextStyle(color: Colors.amber, fontSize: 25.0),
                  textAlign: TextAlign.center,
                ));
              default:
                if (snapshot.hasError) {
                  return Center(
                      child: Text(
                    "Erro de Comunicação ...",
                    style: TextStyle(color: Colors.amber, fontSize: 25.0),
                    textAlign: TextAlign.center,
                  ));
                } else {
                  dolar = snapshot.data["results"]["currencies"]["USD"]["buy"];
                  euro = snapshot.data["results"]["currencies"]["EUR"]["buy"];
                  btc = snapshot.data["results"]["currencies"]["BTC"]["buy"];

                  return SingleChildScrollView(
                    padding: EdgeInsets.all(10.0),
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.stretch,
                      children: <Widget>[
                        Icon(
                          Icons.monetization_on,
                          size: 150.0,
                          color: Colors.amber,
                        ),
                        buildTextField(
                          "Reais",
                          "RS\$ ",
                          realController,
                          _realMudou,
                        ),
                        Divider(),
                        buildTextField(
                          "Dólares",
                          "US\$ ",
                          dolarController,
                          _dolarMudou,
                        ),
                        Divider(),
                        buildTextField(
                          "Euros",
                          "EU\$ ",
                          euroController,
                          _euroMudou,
                        ),
                        Divider(),
                        buildTextField(
                          "Bitcoins",
                          "BTC ",
                          bitcoinController,
                          _bitcoinMudou,
                        ),
                      ],
                    ),
                  );
                }
            }
          }),
    );
  }
}

// Método que efetua a alteração dos campos textos
Widget buildTextField(
  String label,
  String prefix,
  TextEditingController control,
  Function funcao,
) {
  return TextField(
    controller: control,
    decoration: InputDecoration(
        labelText: label,
        labelStyle: TextStyle(color: Colors.amber),
        border: OutlineInputBorder(),
        prefixText: prefix),
    style: TextStyle(color: Colors.amber, fontSize: 25.0),
    onChanged: funcao,
    keyboardType: TextInputType.number,
  );
}
