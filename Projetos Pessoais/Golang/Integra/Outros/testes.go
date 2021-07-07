package main

import (
	"fmt"
	"math"
	"runtime"
	"strconv"
)

// ajustaPrecisaoFloat Acerta a precisão de um Float64 conforme a necessidade
func ajustaPrecisaoFloat(numero float64, precisao int) float64 {
	sPrecisao := strconv.Itoa(precisao)
	temporal := fmt.Sprintf("%."+sPrecisao+"f", numero)
	retorno, _ := strconv.ParseFloat(temporal, 64)
	return retorno
}

// printMemUsage
func printMemUsage() {
	var m runtime.MemStats
	runtime.ReadMemStats(&m)
	fmt.Printf("Alloc = %v MiB", bToMb(m.Alloc))
	fmt.Printf("\tTotalAlloc = %v MiB", bToMb(m.TotalAlloc))
	fmt.Printf("\tSys = %v MiB", bToMb(m.Sys))
	fmt.Printf("\tNumGC = %v\n", m.NumGC)
}

func bToMb(b uint64) uint64 {
	return b / 1024 / 1024
}

func truncar() {
	var x float64
	x = 12.34568745
	fmt.Println(math.Floor(x*1000000) / 1000000)
}

func main() {
	printMemUsage()
}
