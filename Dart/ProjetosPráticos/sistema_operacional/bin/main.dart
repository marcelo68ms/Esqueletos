
import 'dart:io';
import 'dart:convert';

main() {
  // Mostra qual sistema operacional está sendo usado
  print('SO: ${Platform.operatingSystem} ${Platform.version}');
  
  if (Platform.isLinux) {
    print('Rodando Linux');
  }

  // Mostra dados sobre a plataforma onde está sendo executada
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

  // Executa comandos gerais do SO
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
