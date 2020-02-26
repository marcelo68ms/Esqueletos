// Exemplo de uso do Switch
// Sempre precisamos do Break
void main() {
  String status = 'D';
  switch (status) {
    case 'B' :
      print("Aberto");
      break;
    case 'A' :
      print("Em Andamento");
      break;
    case 'F' :
      print("Fechado");
      break;
    default :
      print('Sem Status');
  }

}