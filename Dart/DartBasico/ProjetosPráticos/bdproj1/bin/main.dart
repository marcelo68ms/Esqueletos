import 'package:bdproj1/bd.dart' as bd;
import 'package:mysql1/mysql1.dart';

main() async {
  var conn = await bd.createConnecton();

  await createTable(conn);
//  await insertData(conn);
  await listData(conn);
  await conn.close();
}

// Função responsável por criar uma tabela no banco de dados
Future<void> createTable(MySqlConnection conn) async {
  print('Criando Tabela ...');
  await conn.query('CREATE TABLE IF NOT EXISTS pessoa (id INTEGER NOT NULL auto_increment, nome VARCHAR(150), idade INTEGER, email VARCHAR(200), PRIMARY KEY(id))');
  print('Tabela criada com sucesso');
}

// Função responsável por inserir informações na tabela
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

// Função responsável por listar as informações da tabela
Future<void> listData(MySqlConnection conn) async {
  print('Listando Dados ... ');

  Results result = await conn.query('select * from pessoa');
  result.forEach((Row row) => print('ID: ${row[0]}, Nome: ${row[1]}, Idade: ${row[2]}, Email: ${row[3]}'));

}

// Função que remove uma tabela do banco de dados
Future<void> dropTable(MySqlConnection conn) async {
  print('Removendo a tabela do banco de dados');
  await conn.query('drop table pessoa');
}

// Função responsável por remover informações de uma tabela
Future<void> removeData(MySqlConnection conn) async {
  int data = 2;
  print('Removendo dados do banco de dados');
  await conn.query('delete from pessoa where id = ?', [data]);  
}

// Função responsável por atualizar as informações de uma tabela
Future<void> updateData(MySqlConnection conn) async {
  int id = 2;
  String email = 'measervicos@gmail.com';
  print('Alterando dados do banco de dados');
  await conn.query('update pessoa set email = ? where id = ?', [email, id]);    
}