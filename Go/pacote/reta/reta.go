package main

import "math"

// Inicializando com letra maiúscula, ele sera PÚBLICO (visibilidade dentro e fora do pacote)!
// Não poderão ter funções com o mesmo nome no pacote
// Inicializando com letra minúscula, ele sera PRIVADO (visibilidade apenas dentro do pacote)!
// O Go quando compila faz uma união dos arquivos do mesmo pacote

// Por Exemplo ...
// Ponto - gerará algo público
// ponto ou _ponto - gerará algo privado

// Ponto representa uma coordenada no plano cartesiano
type Ponto struct {
	x float64
	y float64
}

func catetos(a, b Ponto) (cx, cy float64) {
	cx = math.Abs(b.x - a.x)
	cy = math.Abs(b.y - a.y)
	return
}

// Distância é responsável pelo cálculo da distância linear entre dois pontos
func Distancia(a, b Ponto) float64 {
	cx, cy := catetos(a, b)
	return math.Sqrt(math.Pow(cx, 2) + math.Pow(cy, 2))
}
