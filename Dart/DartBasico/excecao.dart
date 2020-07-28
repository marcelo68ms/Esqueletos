main() {
  int idade;
  int idadecachorro = 7;

  // o 'try' define o inicio do código protegido
  try {
    if (idadecachorro != 7)
      throw new Exception('Os anos de cachorro precisam ser 7 !');
    if (idade == null) throw new NullThrownError();

    print(idade * idadecachorro);
    // Teste para o tipo de erro fora do código protegido
  } on NullThrownError {
    print('O valor está nulo');
    // Captura o erro
  } catch (e) {
    print('Ops, houve um erro com a mensagem: \n\n\n${e.toString()}');
    // Sempre executa com erro ou sem erro
  } finally {
    print('Pronto, executado !!');
  }
}
