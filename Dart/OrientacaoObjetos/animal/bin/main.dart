import 'package:animal/animal.dart';

main(List<String> arguments) {
  Animal gato = Animal('Meggy', 6, 'Mesclado');
  
  gato.idade = 4;

  gato.dizAlo();
  gato.digaAlgo('Miau !!');
}
