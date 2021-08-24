import 'package:flutter/material.dart';
import 'package:flutter_application_1/config/app_settings.dart';
import 'package:flutter_application_1/repository/favoritas_repository.dart';
import 'package:provider/provider.dart';
import 'config/hive_config.dart';
import 'meu_aplicativo.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();

  await HiveConfig.start();

  runApp(
    MultiProvider(
      providers: [
        ChangeNotifierProvider(
          create: (context) => FavoritasRepository(),
        ),
        ChangeNotifierProvider(
          create: (context) => AppSettings(),
        ),
      ],
      child: MeuAplicativo(),
    ),
  );
}
