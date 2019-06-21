class Pessoa {
  String nome;
  String cpf;

  String _dataHora() {
    DateTime hoje = DateTime.now();
    String saida = '${hoje.day.toString().padLeft(2,'0')}/${hoje.month.toString().padLeft(2,'0')}/${hoje.year.toString()}';
    saida += ' ${hoje.hour.toString().padLeft(2,'0')}:${hoje.minute.toString().padLeft(2,'0')}:${hoje.second.toString().padLeft(2,'0')}';
    return saida;
  } 

  void entrada() {
    print('Entrada ${_dataHora()}');
  }

  void saida() {
    print('Saída ${_dataHora()}');
  }
}