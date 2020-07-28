
void main() {
  boasVindas();
  print(simulador(4.67, 16.9));
  print(calcArea(23.103));

  print(centimentrosParaMetros(1500));
  print(nomeCompleto('Marcelo', 'Santos'));
  print(nomeCompleto('Alessandra'));
  agora('Leka');
  agora('Leka', true);
  // Chamada de uma função com parâmetros nomeados
  dadosPessoa(peso: 84, nome: 'Marcelo', altura: 1.70, idade: 50, cor: 'Pardo');
}

// Exemplo de função com retorno de um double
double simulador(double a, double b) {
  return a*b;
}

// Função de retorno de imagem de boas vindas
void boasVindas() {
  String nome = 'Mauro';
  print('Bem Vindo, ' + nome);
}

// Função que calcula a área de forma simplificada porque é resolvida em uma linha
double calcArea(double raio) => 3.14 * raio * raio;

// Função de conversão 
double centimentrosParaMetros(num cm) {
  return cm / 100;
}

// Exemplo de função com Parâmetros Opcionais
String nomeCompleto(String primeiro, [ultimo = '']) {
  return '$primeiro $ultimo';
}

// Função com parâmetros opcionais
void agora(String texto,[bool hora = false]) {
  // Captura a hora atual
  var agora = new DateTime.now();
  // Formata a hora para um formato mais amigável
  String horaFormatada = ', a hora atual é: ${agora.hour}:${agora.minute}';
  print('$texto, hoje é dia ${agora.day}/${agora.month}/${agora.year}${hora ? horaFormatada : ''}');
}

// Parâmetros nomeados
void dadosPessoa({String nome, double peso, double altura, String cor, int idade}) {
  print('$nome tem $idade anos, sua altura é de $altura e seu peso é de $peso, sua cor de pele é $cor');
}