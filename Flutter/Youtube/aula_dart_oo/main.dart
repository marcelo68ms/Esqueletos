import 'cartao.dart';
import 'cliente.dart';
import 'compra.dart';
import 'conta.dart';
import 'fatura.dart';

main() {
  var conta = Conta(
    cliente: Cliente(
      id: '12',
      cpf: '123.456.789-00',
      nome: 'Marcelo',
      sobrenome: 'Santos',
    ),
    cartao: Cartao(
      numero: '892893829',
      limite: 8600.23,
      mes: 06,
      ano: 2025,
      codigo: 123,
    ),
    faturas: [
      Fatura(
        compras: [
          Compra(
            valor: 12.5,
            descricao: 'Café',
            data: '12/06',
          ),
          Compra(
            valor: 8.7,
            descricao: 'Açucar',
            data: '13/06',
          ),
        ],
        mes: 6,
        ano: 2021,
      )
    ],
  );
}
