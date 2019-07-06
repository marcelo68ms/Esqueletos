
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
    
}
