import 'package:heranca/cliente.dart';
import 'package:heranca/funcionario.dart';
import 'package:heranca/gerente.dart';

main() {
  
  print('--------------- Dados do Cliente -----------------');
  var cliente1 = Cliente();
  cliente1.nome = 'Marcelo Santos';
  cliente1.cpf = '070.108.388-36';
  cliente1.endereco = 'Rua José Revel, 197';

  cliente1.entrada();
  print('Nome: ${cliente1.nome}');
  print('Endereço: ${cliente1.cpf}');
  cliente1.saida();

  print('--------------- Dados do Funcionário -----------------');
  var funcionario = Funcionario();
  funcionario.nome = 'Gerente do Banco';
  funcionario.nomeMae = 'Aberlinda';
  funcionario.fone = '6784-8373';
  
  funcionario.entrada();
  print('Nome: ${funcionario.nome}');
  print('Nome da Mãe: ${funcionario.nomeMae}');
  funcionario.saida();

  print('--------------- Dados do Gerente -----------------');
  var gerente1 = Gerente();
  gerente1.nome = 'Gerentão';
  gerente1.cpf = '195.352.498-27';
  gerente1.tabela = 1;
  gerente1.senha = 'senha*8';

  gerente1.entrada();
  print('Nome: ${gerente1.nome}');
  print('Senha: ${gerente1.senha}');
  gerente1.saida(); 
}
