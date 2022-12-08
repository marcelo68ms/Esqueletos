package main

import (
	"context"
	"database/sql"
	"fmt"
	"log"

	_ "github.com/go-sql-driver/mysql"

	"cloud.google.com/go/firestore"
)

type Ativos struct {
	Ativcod    string
	AtivNome   string
	AtivStatus string
}

const qryBuscaAtivos string = "SELECT AtivCodigo, AtivNome, AtivStatus FROM dbInveste.TblAtivos ORDER BY AtivCodigo;"

func CarregaTodosAtivos(client firestore.Client, ctx context.Context) {
	db := Conexao()
	defer db.Close()

	rows, _ := db.Query(qryBuscaAtivos)

	defer rows.Close()

	for rows.Next() {
		var ativo Ativos
		erro := rows.Scan(&ativo.Ativcod, &ativo.AtivNome, &ativo.AtivStatus)

		if erro != nil {
			fmt.Printf("Problema na leitura do banco - %v", erro)
		}
		// ----
		addAtivo(client, ctx, ativo)

	}
}

// Conexao - Devolve a conexão do banco de dados
func Conexao() *sql.DB {
	db, err := sql.Open("mysql", "root:root@/dbInveste")
	if err != nil {
		panic(err)
	}
	return db
}

func addAtivo(client firestore.Client, ctx context.Context, ativo Ativos) {
	_, err := client.Collection("ativos").Doc(ativo.Ativcod).Set(ctx, map[string]interface{}{
		"nome":   ativo.AtivNome,
		"status": ativo.AtivStatus,
	})
	if err != nil {
		// Handle any errors in an appropriate way, such as returning them.
		log.Printf("An error has occurred: %s", err)
	}
}
