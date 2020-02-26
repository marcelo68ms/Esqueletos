import 'package:animal/animal.dart';

main(List<String> arguments) {
  Animal gato = Animal('Meggy', 6, 'Mesclado');
  
  gato.idade = 4;

  gato.dizAlo();
  gato.digaAlgo('Miau !!');

  print(Circle.pi);
  Circle.pi = 6.17;
  print(Circle.pi);
}

class Circle {
  static double pi = 3.1415;

  static void calculaArea() {
    print('Cálcula de área');
  }
}