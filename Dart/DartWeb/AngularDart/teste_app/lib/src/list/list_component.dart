import 'package:angular/angular.dart';
import 'list_service.dart';

@Component(
  selector: 'list',
  styleUrls: ['list_component.css'],
  templateUrl: 'list_component.html',
  directives: [NgFor],
  providers: [ClassProvider(ListService)]
) 

class ListComponent implements OnInit {
  // Injeção de Dependencia
  final ListService listService;
  ListComponent(this.listService);

  List linguagens = [];
  
  void ngOnInit() {
    linguagens = listService.getLinguagens();
  }
}