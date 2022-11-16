import 'package:crypto/pages/moedas_page.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(const CryptoWallet());
}

class CryptoWallet extends StatelessWidget {
  const CryptoWallet({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Crypto Moedas',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(primarySwatch: Colors.indigo),
      home: const MoedasPage(),
    );
  }
}
