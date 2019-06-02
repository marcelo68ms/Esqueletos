package main

import (
	"fmt"
	"time"
)

func fale(pessoa, texto string, qtde int) {
	for i := 0; i < qtde; i++ {
		time.Sleep(time.Second)
		fmt.Printf("%s: %s (interação %d)\n", pessoa, texto, i+1)
	}
}

func main() {
	//fale("Maria", "Por que vc não fala comigo ?", 3)
	//fale("João", "Só posso falar depois de vc !", 1)

	//go fale("Maria", "Ei ... ", 15)
	//go fale("João", "Opa ... ", 15)

	go fale("Maria", "Ei ... ", 15)
	fale("João", "Opa ... ", 15)

	// A Goroutine só é válida e executada enquanto o método principal esteja rodando.
}
