package main

import (
	"database/sql"
	"log"

	_ "github.com/go-sql-driver/mysql"
)

func main() {
	db, err := sql.Open("mysql", "root:root@/cursogo")
	if err != nil {
		panic(err)
	}
	defer db.Close()

	tx, _ := db.Begin()
	stmt, _ := tx.Prepare("Insert into usuarios(id, nome) values(?, ?)")

	stmt.Exec(2000, "Núbio")
	stmt.Exec(2001, "Babi")
	_, err = stmt.Exec(1, "Banana") // chave duplicada

	if err != nil {
		tx.Rollback()
		log.Fatal(err)
	}

	tx.Commit()
}
