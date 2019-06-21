import 'package:heranca/cliente.dart';
import 'package:heranca/funcionario.dart';

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
}
