import 'pessoa.dart';

main(List<String> args) {
  Pessoa pessoa = Pessoa(
    nome: 'Marcelo',
    sobrenome: 'Santos',
  );

  print('O nome é ${pessoa.nome}');
  print('o nome completo é ${pessoa.nomeCompleto}');
}
