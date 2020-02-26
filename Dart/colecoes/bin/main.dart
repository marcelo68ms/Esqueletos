import 'dart:collection';
import 'dart:io';

main(List<String> arguments) {

  // Coleção - List 
  List teste = [1, 2, 3, 4];
  print(teste.length);
  print(teste[0]);

  // Lista Genérica
  List coisas = new List();
  coisas.add(1);
  coisas.add('computador');
  coisas.add(true);
  print(coisas);

  // Lista de tipos determinados
  List<int> numeros = new List<int>();
  numeros.add(1);
  numeros.add(2);
  numeros.add(3);
  print(numeros);

  //-----------------------------------------
  // Coleção - Set
  // Set é uma coleção desordenado que não aceita valores duplicados
  Set<int> inteiro = new Set<int>();
  inteiro.add(0);
  inteiro.add(1);
  inteiro.add(2);
  inteiro.add(3);
  inteiro.add(1); // tentativa de duplicidade
  print(inteiro);

  //-----------------------------------------
  // Coleção - Queue
  // Fila - coleção ordenada sem index, que adiciona e removem itens do inicio e fim
  Queue fila = new Queue();
  fila.add(1);
  fila.add(2);
  fila.add(3);
  print(fila);

  fila.addFirst(0);
  fila.addLast(5);
  print(fila);
  
  fila.removeFirst();
  fila.remove(2);
  print(fila);

  //-----------------------------------------
  // Coleção - Map
  // Map = par chave e valor
  Map<int,String> ddd = Map();
  ddd[11] = 'São Paulo';
  ddd[13] = 'Litoral SP';
  ddd[21] = 'Rio de Janeiro';
  print(ddd);

  Map<String, dynamic> pessoa = Map();
  pessoa['nome'] = 'Mauro';
  pessoa['idade'] = 12;
  pessoa['altura'] = 1.53;
  print(pessoa);

  // Não permite repetições de chaves
  Map<String, String> pessoas = new Map<String, String>();
  pessoas.putIfAbsent('pai', () => 'Marcelo');
  pessoas.putIfAbsent('mae', () => 'Alessandra');
  pessoas.putIfAbsent('filho', () => 'Mauro');
  print(pessoas);

  print('Chaves do mapa = ${pessoas.keys}');
  print('Valores do Mapa = ${pessoas.values}');
  print('Apenas o pai = ${pessoas['pai']}');

  //-----------------------------------------
  // Lista Interativa
  List gente = ['Marcelo', 'Mauro', 'Alessandra'];
  print('Informe um Indice');
  int indiceGente = int.parse(stdin.readLineSync());
  print(gente[indiceGente]);
}
