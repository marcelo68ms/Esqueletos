package main

import (
	"fmt"
)

func main() {
	fmt.Print("Linha")
	fmt.Print(" número 1.")

	fmt.Println("Nova")
	fmt.Println("Linha.")

	x := 3.1415

	fmt.Println("O valor de PI é ", x)
	xs := fmt.Sprint(x)

	fmt.Println("O Valor é " + xs)
	fmt.Printf("O valor de x é %.2f.", x)

	a := 1
	b := 1.9999
	c := false
	d := "opa"
	fmt.Printf("\n%d %f %.1f %t %s", a, b, b, c, d)
	fmt.Printf("\n%v %v %v %v", a, b, c, d)
}
