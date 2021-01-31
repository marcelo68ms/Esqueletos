// Classe
import 'package:interfaces/televisao.dart';

class SmartTV implements Televisao {
  bool netflix = true;

  @override
  void volumeDown() {
    print('Baixei o Volume');
  }

  @override
  void volumeUp() {
    print('Aumentei o volume');
  }
  
  void conexaoInternet() {
    print('Tem Internet');
  }
}