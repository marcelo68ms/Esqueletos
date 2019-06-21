import 'package:heranca/cliente.dart';

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

    print('--------------- Dados do Cliente -----------------');


}
