package main

import (
	"encoding/csv"
	"fmt"
	"log"
	"os"
	"strconv"
)

func ReadCsvFile(filePath string) [][]string {
	f, err := os.Open(filePath)
	if err != nil {
		log.Fatal("Unable to read input file "+filePath, err)
	}
	defer f.Close()

	csvReader := csv.NewReader(f)
	csvReader.Comma = ';'
	records, err := csvReader.ReadAll()

	if err != nil {
		log.Fatal("Unable to parse file as CSV for "+filePath, err)
	}

	return records
}

func main() {
	records := ReadCsvFile("inflacao.csv")

	teste, _ := strconv.ParseFloat("2,5", 4)
	fmt.Println(teste)
	fmt.Println(records[1][2])
}
