import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:propaganda_google/extensions.dart';

class NewPage extends StatelessWidget {
  final String title;

  const NewPage({
    Key? key,
    required this.title,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
              title: Text(title),
              systemOverlayStyle: SystemUiOverlayStyle.light)
          .withBottomAdmobBanner(context),
      body: Container(
        color: Colors.green,
      ),
    );
  }
}
