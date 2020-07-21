import 'package:heranca/administrador.dart';
import 'package:heranca/pessoa.dart';

class Gerente extends Pessoa with Administrador {
  int tabela;

  void entrada() {
    super.entrada();
    print('Não bate o ponto');
  }
}