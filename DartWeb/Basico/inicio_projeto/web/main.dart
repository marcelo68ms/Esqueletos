import 'dart:html';

void main() {
  querySelector('#output').text = 'Your Dart app is running.';

  querySelector('#output').onClick.listen((a){
    querySelector('#output').text = 'Hello Word';  
    print('Houve um clique');
  });
}
