package main

import "fmt"

func inc1(n int) {
	n++
}

// revisão: um ponteiro é representado por um *
func inc2(n *int) {
	// revisão: * é usado indicando que é um ponteiro (desreferencia o ponteiro)

	*n++
}

func main() {

	n := 1
	inc1(n) // Passagem por valor
	fmt.Println(n)

	inc2(&n) // Passagem por referência, nesse caso usamos o &
	fmt.Println(n)
}
