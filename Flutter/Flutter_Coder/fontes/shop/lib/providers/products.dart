import 'dart:math';

import 'package:flutter/foundation.dart';
import 'package:shop/data/dummy_data.dart';
import 'package:shop/providers/product.dart';

class Products with ChangeNotifier {
  List<Product> _items = DUMMY_PRODUCTS;

  //bool _showFavoriteOnly = false;

  List<Product> get items => [..._items];

  List<Product> get favoritesItems {
    return _items.where((prod) => prod.isFavorite).toList();
  }

  void addProduct(Product newProduct) {
    _items.add(Product(
        id: Random().nextDouble().toString(),
        title: newProduct.title,
        description: newProduct.description,
        price: newProduct.price,
        imageUrl: newProduct.imageUrl));
    notifyListeners();
  }

  int get itemsCount {
    return _items.length;
  }

/*
  void showFavoriteOnly() {
    _showFavoriteOnly = true;
    notifyListeners();
  }

  void showAll() {
    _showFavoriteOnly = false;
    notifyListeners();
  }
*/

}
