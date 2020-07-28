package main

import "fmt"

func fatorial(n int) (int, error) {
	switch {
	case n < 0:
		return -1, fmt.Errorf("número inválido: %d", n)
	case n == 0:
		return 1, nil
	default:
		fatorialAnterior, _ := fatorial(n - 1)
		return n * fatorialAnterior, nil
	}

}

// Fatorial simples, sem permitir negativo
func fatorialSimples(n uint) uint {
	switch {
	case n == 0:
		return 1
	default:
		return n * fatorialSimples(n-1)
	}
}

func main() {
	resultado, _ := fatorial(5)
	fmt.Println(resultado)

	_, err := fatorial(-4)
	if err != nil {
		fmt.Println(err)
	}

	// Uma solução mais simples uint
	fmt.Println(fatorialSimples(7))
}
