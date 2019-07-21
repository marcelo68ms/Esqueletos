import 'package:angular/angular.dart';

@Component(
  selector: 'list',
  styleUrls: ['list_component.css'],
  templateUrl: 'list_component.html',
  directives: [NgFor],
) 

class ListComponent {
  List linguagens = ['Dart', 'Java', 'C', 'Cobol', 'Go Lang'];
}