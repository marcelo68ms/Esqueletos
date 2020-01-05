import 'package:flutter/material.dart';

void main() => runApp(AppInic());

class AppInic extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    //return Container(
    // Sempre tem que retornar um MaterialApp
    return MaterialApp(
      title: 'Inicial',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: HomePage(),
    );
  }
}

class HomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          leading: Text("Oi"),
          title: Text("Todo List"),
          actions: <Widget>[
            Icon(Icons.plus_one),
          ],
        ),
        body: Container(
          child: Center(
            child: Text("Olá Mundo"),
          ),
        ));
  }
}
