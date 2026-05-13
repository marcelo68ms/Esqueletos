package main

import "fmt"

// https://www.golangprograms.com/remove-duplicate-values-from-slice.html

func unique(intSlice []int) []int {
	keys := make(map[int]bool)
	list := []int{}
	for _, entry := range intSlice {
		if _, value := keys[entry]; !value {
			keys[entry] = true
			list = append(list, entry)
		}
	}
	return list
}

func mainx() {
	intSlice := []int{1, 1, 5, 3, 6, 9, 9, 9, 4, 2, 3, 1, 5}
	fmt.Println(intSlice)
	uniqueSlice := unique(intSlice)
	fmt.Println(uniqueSlice)

	strSlice := []string{"maria", "jose", "carlos", "maria", "souza", "maria", "carlos", "big"}
	fmt.Println(strSlice)
	novoSlice := uniqueStr(strSlice)
	fmt.Println(novoSlice)
}

func uniqueStr(strSlice []string) []string {
	keys := make(map[string]bool)
	list := []string{}
	for _, entry := range strSlice {
		if _, value := keys[entry]; !value {
			keys[entry] = true
			list = append(list, entry)
		}
	}
	return list
}
