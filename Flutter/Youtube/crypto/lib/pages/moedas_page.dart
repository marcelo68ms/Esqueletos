import 'package:crypto/repository/moeda_repository.dart';
import 'package:flutter/material.dart';

class MoedasPage extends StatelessWidget {
  const MoedasPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    final tabela = MoedaRepository.tabela;
    return Scaffold(
        appBar: AppBar(
          title: const Text('Crypto Moedas'),
        ),
        body: ListView.separated(
          itemBuilder: (BuildContext context, int moeda) {
            return ListTile(
              leading: Image.asset(tabela[moeda].icone),
              title: Text(tabela[moeda].nome),
              trailing: Text(tabela[moeda].preco.toString()),
            );
          },
          padding: EdgeInsets.all(16),
          separatorBuilder: (_, __) => Divider(),
          itemCount: tabela.length,
        ));
  }
}
