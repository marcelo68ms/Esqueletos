// Exemplo usado para efetuar testes no seu código
main() {
  
  try {
    String texto;
    assert(texto != null);

    int numero = 500;
    assert(numero < 100);

    String protocolo = 'http';
    assert(protocolo.contains('https'), 'O protocolo precisa ser https');

  } catch(e) {
    print(e);
  }

}