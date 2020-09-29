import 'package:flutter/material.dart';
import 'package:shop/models/product.dart';
import 'package:shop/providers/counter_provider.dart';

class ProductDetailScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final Product product =
        ModalRoute.of(context).settings.arguments as Product;

    return Scaffold(
      appBar: AppBar(
        title: Text(product.title),
      ),
      body: Column(
        children: [
          RaisedButton(
            onPressed: () {
              CounterProvider.of(context).state.inc();
              print(CounterProvider.of(context).state.value);
            },
            child: Text('+'),
          )
        ],
      ),
    );
  }
}
