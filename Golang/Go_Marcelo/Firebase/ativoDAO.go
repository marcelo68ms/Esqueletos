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

	rows, erro := db.Query(qryBuscaAtivos)

	if erro != nil {
		fmt.Printf("Problema na leitura das tabelas - %v", erro)
	}

	defer rows.Close()

	for rows.Next() {
		var ativo Ativos
		erro := rows.Scan(&ativo.Ativcod, &ativo.AtivNome, &ativo.AtivStatus)

		if erro != nil {
			fmt.Printf("Problema na leitura do banco - %v", erro)
		}
		// ----
		doc := make(map[string]map[string]interface{})
		doc["assets"] = make(map[string]interface{})

		doc["assets"][ativo.Ativcod] = map[string]interface{}{
			"codigo": ativo.Ativcod,
			"nome":   ativo.AtivNome,
			"status": ativo.AtivStatus,
		}
		_, err := client.Collection("ativos").Doc("acao").Set(ctx, doc, firestore.MergeAll)

		if err != nil {
			// Handle any errors in an appropriate way, such as returning them.
			log.Printf("An error has occurred: %s", err)
		}

	}
}

/*
// AdicionarCotacao - Adiciona as cotações que deverão ser seguidas
func AdicionarCotacao(client firestore.Client, ctx context.Context, cotacao []Cotacao) {
	ano := "2023"
	mes := "03"

	for _, record := range cotacao {
		doc := make(map[string]map[string]interface{})
		doc["assets"] = make(map[string]interface{})

		doc["assets"][record.AtivCodigo] = map[string]interface{}{
			"ativo":        record.AtivCodigo,
			"valor":        record.CotValorAtivo,
			"dataHora":     record.CotDataHora,
			"nome":         record.AtivNome,
			"url":          record.UrlIcone,
			"lucroPorAcao": record.LucroPorAcao,
		}
		if record.CotValorAtivo > 0 {
			_, err := client.Collection("principal").Doc(ano+"-"+mes).Set(ctx, doc, firestore.MergeAll)

			if err != nil {
				// Handle any errors in an appropriate way, such as returning them.
				log.Printf("[cotacaoDAO] - [AdicionarCotacao] - %v", err)
			}
		}
	}
	log.Printf("[cotacaoDAO] - [AdicionarCotacao] - %v", util.DataHoraHoje())
}
*/

// Conexao - Devolve a conexão do banco de dados
// user:password@tcp([de:ad:be:ef::ca:fe]:80)/dbname?timeout=90s&collation=utf8mb4_unicode_ci
func Conexao() *sql.DB {
	//db, err := sql.Open("mysql", "root:root@tcp(192.168.10.02:3306)/dbInveste")
	db, err := sql.Open("mysql", "root:root@/dbInveste")
	if err != nil {
		panic(err)
	}
	return db
}

func addAtivo(client firestore.Client, ctx context.Context, ativo Ativos) {
	//
	_, err := client.Collection("ativos").Doc(ativo.Ativcod).Set(ctx, map[string]interface{}{
		"codigo": ativo.Ativcod,
		"nome":   ativo.AtivNome,
		"status": ativo.AtivStatus,
	})
	if err != nil {
		// Handle any errors in an appropriate way, such as returning them.
		log.Printf("An error has occurred: %s", err)
	}
}
