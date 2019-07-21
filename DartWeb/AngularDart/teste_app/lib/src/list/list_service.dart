import 'package:angular/core.dart';

@Injectable()

class ListService {
  List getLinguagens() {
    return ['Dart', 'Java', 'C', 'Cobol', 'Go Lang'];
  }
}