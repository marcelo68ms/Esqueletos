import 'package:flutter/material.dart';
import 'package:share/share.dart';

class GifPage extends StatelessWidget {
  final Map _gifData;

  GifPage(this._gifData);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(_gifData["title"]),
        foregroundColor: Colors.black,
        actions: [
          IconButton(
              onPressed: () {
                Share.share(_gifData["images"]["fixed_heigth"]["url"]);
              },
              icon: Icon(Icons.share))
        ],
      ),
      backgroundColor: Colors.black,
      body: Center(
        child: Image.network(_gifData["images"]["fixed_heigth"]["url"]),
      ),
    );
  }
}
