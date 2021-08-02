import 'package:flutter/material.dart';
import 'package:flutter_application_1/repository/moeda_repository.dart';

class MoedasPage extends StatelessWidget {
  const MoedasPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    final tabela = MoedaRepository.moedas;
    return Scaffold(
        appBar: AppBar(
          title: Text('Crypto Moedas'),
        ),
        body: ListView.separated(
            itemBuilder: (BuildContext contexto, int moeda) {
              return ListTile(
                //ListTile é o retorno de apenas uma linha da tabela
                leading: Image.asset(tabela[moeda].icone),
                title: Text(tabela[moeda].nome),
                trailing: Text(tabela[moeda].preco.toString()),
              );
            },
            padding: EdgeInsets.all(16),
            separatorBuilder: (_, __) => Divider(),
            itemCount: tabela.length));
  }
}
