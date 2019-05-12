void main() {
  
  // Laço com For
  for (int i = 0; i < 10; i++) {
    print(i);
  }

  List listaProdutos = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'Feijão', 8.65, true];
  for (var item in listaProdutos) {
    print(item);
  }

  for(int i = 0; i < listaProdutos.length; i++) {
    print(listaProdutos);
  }

  // Laços com While
  int idade = 10;
  while(idade < 18) {
    print(idade.toString());
    idade++;
  }

  // Laços doWhile
  int idade2 = 20;
  do {
    print(idade2.toString());
    idade2++;    
  } while (idade2 < 28);
}