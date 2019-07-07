void main() {
  // chamada das funções como objetos
  var centimetrosParaMetros = conversor;
  print('Centimetros para metros: ${centimetrosParaMetros(200,100)} m ');

  var metrosParaKilometros = conversor;
  print('Metros para Kilometros: ${metrosParaKilometros(5000,1000)} km ');

  // Chamada das funções anônimas
  criarBotao('Botão Câmera', botaoCriado);

  criarBotao('Botão Novo', () {
    print('O botão foi criado usando função anônima !\n');
  });

  criarBotao('Botão Fechar', (){}, cor: 'Branco', largura: 22.5);

  criarBotao('Botão Novo', () => print('O botão foi criado usando função anônima !\n'));

}

// Funções como objetos
num conversor(num numero, num escala) {
  return numero/escala;
}

// Funções anônimas
void botaoCriado() {
  print('Botão criado ! \n');
}

// Função que cria o botão
void criarBotao(String texto, Function criadoFunc, {String cor, double largura}) {
  print(texto);
  // Se a cor não for definida, o botão será preto
  print(cor ?? 'Preto');
  // Se a largura não for definida a mesma será 10
  print(largura ?? 10);

  criadoFunc();
}

