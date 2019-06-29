package main

import (
	"fmt"
	"time"
)

// Channel (canal) - é a forma de comunicação entre as goroutines (ponto de sincronismo)
// channel é um tipo da linguagem, como os tipos de variáveis

func doisTresQuatroVezes(base int, c chan int) {
	time.Sleep(time.Second)
	c <- 2 * base

	time.Sleep(time.Second)
	c <- 3 * base

	time.Sleep(time.Second)
	c <- 4 * base
}

func main() {

	c := make(chan int)
	go doisTresQuatroVezes(2, c)
	fmt.Println("A")

	a, b := <-c, <-c // recebendo dados do canal
	fmt.Println("B")

	fmt.Println(a, b)
	fmt.Println(<-c)
}
