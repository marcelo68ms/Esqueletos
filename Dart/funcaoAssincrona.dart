main() async {
  print('Começou');
  load();
  load2();
  print('Continuou');
  var dados = await load3();
  print(dados);
}

load() async {
  await Future.delayed(const Duration(seconds: 2));
  print('Carga 1');
}

load2() async {
  await Future.delayed(const Duration(seconds: 1));
  print('Carga 2');
}

load3() async {
  await Future.delayed(const Duration(seconds: 3));
  return 'Carga 3';
}