package main

import (
	"fmt"
)

func main() {
	// var aprovados map[int]string
	// Mapas devem ser inicializados
	aprovados := make(map[int]string)

	aprovados[19536271827] = "Maria"
	aprovados[19092434827] = "Pedro"
	aprovados[24567645827] = "Ana"
	fmt.Println(aprovados)

	for cpf, nome := range aprovados {
		fmt.Printf("%s (CPF: %d)\n", nome, cpf)
	}

	fmt.Println(aprovados[19092434827])

	delete(aprovados, 19092434827)

	for cpf, nome := range aprovados {
		fmt.Printf("%s (CPF: %d)\n", nome, cpf)
	}
}
