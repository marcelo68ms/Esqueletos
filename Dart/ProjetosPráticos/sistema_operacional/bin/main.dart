
import 'dart:io';

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
  
}
