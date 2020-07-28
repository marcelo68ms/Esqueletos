package main

import "fmt"

type carro struct {
	nome             string
	velocidadeMaxima int
}

type ferrari struct {
	carro       // campos anonimos
	turboLigado bool
}

func main() {
	f := ferrari{}
	f.nome = "F40"
	f.velocidadeMaxima = 340
	f.turboLigado = true

	fmt.Printf("A Ferrai %s está com o turbo ligado ? %v\n", f.nome, f.turboLigado)
	fmt.Println(f)
}
