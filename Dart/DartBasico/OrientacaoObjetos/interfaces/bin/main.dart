// No Dart não tem uma sintaxe específica para implementar interfaces
// Uma interface no Dart é uma classe onde é obrigatório reescrever todos
// os métodos implementados na classe superior

import 'package:interfaces/smarttv.dart';

main() {
 
  var tv = SmartTV();
  tv.volumeUp();
  tv.volumeDown();
  tv.conexaoInternet();

}
