
import 'dart:io';
import 'dart:convert';

main() {
  print('SO: ${Platform.operatingSystem} ${Platform.version}');
  
  if (Platform.isLinux) {
    print('Rodando Linux');
  }

  print('Path: ${Platform.script.path}');
  print('Dart: ${Platform.executable}');
  print('\n----------------- Variáveis de Ambiente --------------------');
  Platform.environment.keys.forEach((key) {
    print('${key} - ${Platform.environment[key]}');
  });

  print('\n\n------------------------- Processos ------------------------');
  Process.run('ls',['-l']).then((ProcessResult results) {
    print(results.stdout);
    print('Código de saída: ${results.exitCode} ');
  });

  print('\n\n-------------------------------------------------------------');
  // Específico para Linux/Mac
  Process.start('cat', []).then((Process processo) {
    // Transformar a saída em Texto
    processo.stdout.transform(utf8.decoder).listen((dados) {
      print(dados);
    });
    processo.stdin.write('Olá mundo');
    Process.killPid(processo.pid);
  });
}
