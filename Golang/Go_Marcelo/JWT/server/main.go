package main

import (
	"fmt"
	"log"
	"net/http"

	"github.com/dgrijalva/jwt-go"
)

// fraseSecreta usada para a criptografia da senha
var fraseSecreta = []byte("A_ilha_de_Tortuga_so_pode_ser_achada_por_aqueles_que_sabem_onde_ela_fica!")

func homePage(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "Informação Super Secreta")
}

func isAuthorized(endpoint func(http.ResponseWriter, *http.Request)) http.Handler {
	return http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		if r.Header["Token"] != nil {
			token, err := jwt.Parse(r.Header["Token"][0], func(token *jwt.Token) (interface{}, error) {
				if _, ok := token.Method.(*jwt.SigningMethodHMAC); !ok {
					return nil, fmt.Errorf("Erro de processamento")
				}
				return fraseSecreta, nil
			})
			if err != nil {
				fmt.Fprintf(w, err.Error())
			}
			if token.Valid {
				endpoint(w, r)
			}

		} else {
			fmt.Fprintf(w, "Não Autorizado")
		}
	})
}

func handleRequest() {
	http.Handle("/", isAuthorized(homePage))
	log.Fatal(http.ListenAndServe(":3003", nil))
}

func main() {
	fmt.Println("Um Servidor Simples")
	handleRequest()
}
