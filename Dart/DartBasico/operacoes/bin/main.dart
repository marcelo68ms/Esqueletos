
main(List<String> arguments) {
  int num1 = 101;
  int num2 = 2;
  dynamic res = 0;

  // Adição
  res = num1 + num2;
  print('Adição: $res');

  // Subtração
  res = num1 - num2;
  print('Subtração: $res');

  // Multiplição
  res = num1 * num2;
  print('Multiplicação: $res');

  // Divisão
  res = num1 / num2;
  print('Divisão: $res');

  // Divisão apenas inteiro
  res = num1 ~/ num2;
  print('Divisão retornando apenas o inteiro: $res');

  // Divisão apenas o resto
  res = num1 % num2;
  print('Divisão retornando apenas o resto: $res');

  // Incrementadores
  num1++;
  print('Incrementando: $res');

  num1--;
  print('Decrementando: $res');

  // Comparadores artiméticos
  // >  maior que 
  // >= maior ou igual
  // <  menor que
  // <= menor ou igual
  // == igual a
  // != diferente

  bool testeComp = (10 != 20);
  print(testeComp);

  // Operador OU/OR 
  // true com true   --> true
  // true com false  --> true
  // false com true  --> true
  // false com false --> false
  // ||

  bool testeOr = (true || false);
  print(testeOr);

  // Operador E/AND 
  // true com true   --> true
  // true com false  --> false
  // false com true  --> false
  // false com false --> false
  // &&
  bool testeAnd = (true && false);
  print(testeAnd);
}
