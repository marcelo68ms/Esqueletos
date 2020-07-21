import 'package:angular/angular.dart';
import 'src/hello_world/hello_world_component.dart';
import 'src/list/list_component.dart';

@Component(
  selector: 'my-app',
  styleUrls: ['app_component.css'],
  templateUrl: 'app_component.html',
  directives: [HelloWorldComponent, ListComponent],
)
class AppComponent {
  // Nothing here yet. All logic is in TodoListComponent.
}
