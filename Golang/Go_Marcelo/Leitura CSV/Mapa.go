package main

import "strconv"

type Inflacao struct {
	Pais       string
	Atual      float64
	Anterior   float64
	Referencia string
}

func CarregaInflacao(leitura [][]string) []Inflacao {
	inflacaoGeral := make([]Inflacao, 0)

	for _, record := range leitura {
		var user Inflacao

		user.Pais = record[0]
		user.Atual, _ = strconv.ParseFloat(record[1], 64)
		user.Anterior, _ = strconv.ParseFloat(record[2], 64)
		user.Referencia = record[3]

		inflacaoGeral = append(inflacaoGeral, user)
	}

	return inflacaoGeral
}
