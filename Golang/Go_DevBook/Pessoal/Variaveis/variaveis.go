package main

import (
	"errors"
	"fmt"
)

func main() {
	var hum string = "hum"
	dois := "dois"

	var errado error = errors.New("Erro Interno")

	fmt.Println(hum)
	fmt.Println(dois)
	fmt.Println(errado)
}
