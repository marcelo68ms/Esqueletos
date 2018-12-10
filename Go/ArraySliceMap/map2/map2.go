package main

import (
	"fmt"
)

func main() {
	funcsESalarios := map[string]float64{
		"José João":      11425.5,
		"Gabriela Silva": 9768.3,
		"Pedro Marim":    9500.0,
	}

	funcsESalarios["Rafael Filho"] = 1350.0
	delete(funcsESalarios, "Inexistente")

	for nome, salario := range funcsESalarios {
		fmt.Println(nome, salario)
	}
}
