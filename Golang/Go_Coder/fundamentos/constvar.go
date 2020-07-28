package main

import (
	"fmt"
	"math"
)

func main() {
	const PI float64 = 3.1415
	var raio = 3.2 // tipo float64

	// forma reduzida de criar variáveis e constantes
	area := PI * math.Pow(raio, 2)

	fmt.Println("A área da ", area)

	const (
		a = 34
		b = 4.54
	)

	var (
		c = 78
		d = 87.17
	)

	fmt.Println(a, b, c, d)

	var e, f bool = true, false

	fmt.Println(e, f)

	g, h, i := 2, false, "epa !"

	fmt.Println(g, h, i)

}
