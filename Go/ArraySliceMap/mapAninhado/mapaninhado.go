package main

import (
	"fmt"
)

func main() {
	funcsPorLetra := map[string]map[string]float64{
		"G": {
			"Gabriela Silva":  4589.90,
			"Gustavo Pereira": 3456.90,
		},
		"J": {
			"José João":      11234.54,
			"Janaina Santos": 8782.23,
		},
		"P": {
			"Pedro Junior": 2300.34,
		},
	}

	fmt.Println(funcsPorLetra)

	for letra, funcs := range funcsPorLetra {
		fmt.Println(letra, funcs)
	}

	delete(funcsPorLetra, "P")

	for letra, funcs := range funcsPorLetra {
		fmt.Println(letra, funcs)
	}

}
