import 'package:sqljocky5/sqljocky.dart';

createConnecton() {
  return ConnectionSettings(
    user: "root",
    password: "root",
    host: "localhost",
    port: 3306,
    db: "dbDart",
  );
}
