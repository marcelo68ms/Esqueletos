import 'package:mysql1/mysql1.dart';

// Função que efetua a conexão com o banco de dados
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
