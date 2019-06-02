main() {

  int idade;
  int idadecachorro = 7;

  try {
    if (idadecachorro != 7)
      throw new Exception('Os anos de cachorro precisam ser 7 !');
    if (idade == null) 
      throw new NullThrownError();

    print(idade * idadecachorro);
  } on NullThrownError {
    print('O valor está nulo');  
  } catch(e) {
    print('Ops, houve um erro com a mensagem: \n\n\n${e.toString()}');
  } finally {
    print('Pronto, executado !!');
  }
}