// ignore_for_file: prefer_const_constructors, prefer_const_literals_to_create_immutables

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_application_1/models/moeda.dart';
import 'package:intl/intl.dart';

class MoedaDetalhePage extends StatefulWidget {
  final Moeda moeda;

  const MoedaDetalhePage({Key? key, required this.moeda}) : super(key: key);

  @override
  _MoedaDetalhePageState createState() => _MoedaDetalhePageState();
}

class _MoedaDetalhePageState extends State<MoedaDetalhePage> {
  // Efetua a formatação de números
  NumberFormat real = NumberFormat.currency(locale: 'pt_BR', name: 'R\$');

  // Ele controla a situação do formulário
  final _form = GlobalKey<FormState>();

  // É onde o valor do formulário é gravado
  final _valor = TextEditingController();
  double quantidade = 0;

  comprar() {
    if (_form.currentState!.validate()) {
      // Salvar a informação

      Navigator.pop(context);

      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(
          content: Text('Compra realizada com sucesso!!'),
        ),
      );
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.moeda.nome),
      ),
      body: Padding(
        padding: EdgeInsets.all(24),
        child: Column(
          children: [
            Padding(
              padding: EdgeInsets.only(bottom: 24),
              child: Row(
                children: [
                  SizedBox(
                    child: Image.asset(widget.moeda.icone),
                    width: 50,
                  ),
                  Container(
                    width: 10,
                  ),
                  Text(
                    real.format(widget.moeda.preco),
                    style: TextStyle(
                      fontSize: 26,
                      fontWeight: FontWeight.w600,
                      letterSpacing: -1,
                      color: Colors.grey[800],
                    ),
                  ),
                ],
                mainAxisAlignment: MainAxisAlignment.center,
                crossAxisAlignment: CrossAxisAlignment.center,
              ),
            ),
            (quantidade > 0)
                ? SizedBox(
                    width: MediaQuery.of(context).size.width,
                    child: Container(
                      child: Text(
                        '$quantidade  ${widget.moeda.sigla}',
                        style: TextStyle(
                          fontSize: 20,
                          color: Colors.teal,
                        ),
                      ),
                      margin: EdgeInsets.only(bottom: 24),
                      padding: EdgeInsets.all(12),
                      alignment: Alignment.center,
                      decoration:
                          BoxDecoration(color: Colors.teal.withOpacity(0.05)),
                    ),
                  )
                : Container(
                    margin: EdgeInsets.only(bottom: 24),
                  ),
            Form(
              child: TextFormField(
                autocorrect: false,
                controller: _valor,
                style: TextStyle(fontSize: 22),
                decoration: InputDecoration(
                  border: OutlineInputBorder(),
                  labelText: 'Valor',
                  prefixIcon: Icon(Icons.monetization_on_outlined),
                  suffix: Text(
                    'Reais',
                    style: TextStyle(fontSize: 14),
                  ),
                ),
                keyboardType: TextInputType.number,
                inputFormatters: [
                  FilteringTextInputFormatter.digitsOnly,
                ],
                validator: (value) {
                  if (value!.isEmpty) {
                    return 'Informe o valor da compra!';
                  } else if (double.parse(value) < 50) {
                    return 'Valor mínimo de compra é R\$ 50 reais!';
                  }
                  return null;
                },
                onChanged: (value) {
                  setState(() {
                    quantidade = (value.isEmpty)
                        ? 0
                        : double.parse(value) / widget.moeda.preco;
                  });
                },
              ),
              key: _form,
            ),
            Container(
              alignment: Alignment.bottomCenter,
              margin: EdgeInsets.only(top: 24),
              child: ElevatedButton(
                onPressed: comprar,
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Icon(Icons.check),
                    Padding(
                      padding: EdgeInsets.all(14),
                      child: Text(
                        'Compra',
                        style: TextStyle(fontSize: 20),
                      ),
                    ),
                  ],
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
