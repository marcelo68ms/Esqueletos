import 'package:heranca/pessoa.dart';

class Funcionario extends Pessoa {
  int _matricula;
  String fone;
  String nomeMae;

  int get matricula => _matricula;
}