package main

import (
	"fmt"
	"math"
	"reflect"
)

func main() {
	// Tipos Númericos Inteiros
	fmt.Println(1, 2, 1000)
	fmt.Println("Literal inteiro é", reflect.TypeOf(32000))

	// Sem sinal (só positivos) ... uint8 uint16 uint32 uint64
	var b byte = 255
	fmt.Println("O byte é", reflect.TypeOf(b))

	// Inteiros com sinal int8 int16, int32 int64
	i1 := math.MaxInt64
	fmt.Println("O valor máximo de int é", i1)
	fmt.Println("O tipo de i1 é", reflect.TypeOf(i1))

	var i2 rune = 'a' // Representa um mapeamento da tabela Unicode (int32)
	fmt.Println("O rune é", reflect.TypeOf(i2))
	fmt.Println(i2)

	// Números Reais (com ponto flutuante) float32, float64
	var x float32 = 49.99
	fmt.Println("O tipo de x é", reflect.TypeOf(x))
	fmt.Println("O tipo literal de x é", reflect.TypeOf(49.99)) // Tipo float64

	// Tipos Boolean
	bo := true
	fmt.Println("O tipo de bo é", reflect.TypeOf(bo))
	fmt.Println(!bo)

	// Tipo String
	s1 := "Olá Go Lang"
	fmt.Println(s1 + "!")
	fmt.Println("O tamanho de s1 é", len(s1))

	// Strings com multiplas linhas
	s2 := `Olá
	Estou experimentando
	uma String dividida 
	em multiplas
	linhas`
	fmt.Println(s2)
	fmt.Println("O tamanho dessa String é", len(s2))

	// Tipo Char é um int32
	char := 'a'
	fmt.Println("O tipo de char é", reflect.TypeOf(char))

}
