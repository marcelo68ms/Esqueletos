package main

import "fmt"

func imprimeAprovados(aprovados ...string) {
	fmt.Println("Lista de Aprovados")
	for i, aprovado := range aprovados {
		fmt.Printf("%d) %s\n", i+1, aprovado)
	}
}

func main() {
	aprovados := []string{"Marcelo", "Mauro", "Alessandra"}
	imprimeAprovados(aprovados...)
}
