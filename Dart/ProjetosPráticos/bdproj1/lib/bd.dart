import 'package:mysql1/mysql1.dart';

createConnecton() async {
  
  var stringConexao = ConnectionSettings(
    user: "root",
    password: "root",
    host: "localhost",
    port: 3306,
    db: "dbDart",
  );

  return await MySqlConnection.connect(stringConexao);
}
