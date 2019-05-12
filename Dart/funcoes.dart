void main() {
  boasVindas();
  print(simulador(4.67, 16.9));
  print(calcArea(23.103));
}

double simulador(double a, double b) {
  return a*b;
}

void boasVindas() {
  String nome = 'Mauro';
  print('Bem Vindo, ' + nome);
}

double calcArea(double raio) => 3.14 * raio * raio;