import 'package:bdproj1/bd.dart' as bd;
import 'package:mysql1/mysql1.dart';

main() async {
  var conn = await bd.createConnecton();

  await createTable(conn);
  await insertData(conn);
  await conn.close();
}

Future<void> createTable(MySqlConnection conn) async {
  print('Criando Tabela ...');
  await conn.query('CREATE TABLE IF NOT EXISTS pessoa (id INTEGER NOT NULL auto_increment, nome VARCHAR(150), idade INTEGER, email VARCHAR(200), PRIMARY KEY(id))');
  print('Tabela criada com sucesso');
}

Future<void> insertData(MySqlConnection conn) async {
  print('Inserindo informações');
  var data = [
    ['Alessandra Paula', 'mulhereacessorios@gmail.com', 43],
    ['Marcelo Santos', 'marcelo68ms@gmail.com', 50],
    ['MauroAlexandre', 'mauro06aps@gmail.com', 43]
  ];

  await conn.queryMulti('INSERT INTO pessoa (NOME, EMAIL, IDADE) VALUES(?, ?, ?)', data);
  print('Dados inseridos com Sucesso !!');
}