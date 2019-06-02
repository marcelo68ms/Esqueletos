
void main() {
  boasVindas();
  print(simulador(4.67, 16.9));
  print(calcArea(23.103));

  print(centimentrosParaMetros(1500));
  print(nomeCompleto('Marcelo', 'Santos'));
  print(nomeCompleto('Alessandra'));
  agora('Leka');
  agora('Leka', true);
}

double simulador(double a, double b) {
  return a*b;
}

void boasVindas() {
  String nome = 'Mauro';
  print('Bem Vindo, ' + nome);
}

double calcArea(double raio) => 3.14 * raio * raio;

double centimentrosParaMetros(num cm) {
  return cm / 100;
}

String nomeCompleto(String primeiro, [ultimo = '']) {
  return '$primeiro $ultimo';
}

void agora(String texto,[bool hora = false]) {
  var agora = new DateTime.now();
  String horaFormatada = ', a hora atual é: ${agora.hour}:${agora.minute}';
  print('$texto, hoje é dia ${agora.day}/${agora.month}/${agora.year}${hora ? horaFormatada : ''}');
}