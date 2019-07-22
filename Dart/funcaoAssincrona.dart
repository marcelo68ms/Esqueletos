// Executa o main de forma assincona 
main() async {
  print('Começou');
  load();
  load2();
  print('Continuou');
  var dados = await load3();
  print(dados);
}

// Executa uma função de forma assincrona
load() async {
  await Future.delayed(const Duration(seconds: 2));
  print('Carga 1');
}

// Executa uma função de forma assincrona
load2() async {
  await Future.delayed(const Duration(seconds: 1));
  print('Carga 2');
}

// Executa uma função de forma assincrona
load3() async {
  await Future.delayed(const Duration(seconds: 3));
  return 'Carga 3';
}