package main

import (
	"fmt"
	"io/ioutil"
	"log"
	"net/http"
	"time"

	"github.com/dgrijalva/jwt-go"
)

// fraseSecreta usada para a criptografia da senha
const fraseSecreta string = "A_ilha_de_Tortuga_so_pode_ser_achada_por_aqueles_que_sabem_onde_ela_fica!"

func main() {
	fmt.Println("Caso simples de Geração de JWT - Cliente")
	handleRequest()
}

func criarJWT() (string, error) {
	var err error
	atClaims := jwt.MapClaims{}
	atClaims["authorized"] = true
	atClaims["user"] = "usuario.UsEmail"
	atClaims["group"] = 1
	atClaims["name"] = "usuario.UsNome"
	atClaims["exp"] = time.Now().Add(time.Minute * 45).Unix()
	at := jwt.NewWithClaims(jwt.SigningMethodHS256, atClaims)

	token, err := at.SignedString([]byte(fraseSecreta))

	if err != nil {
		//fmt.Errorf("Erro na geração do JWT: %s", err.Error())
		return "", err
	}
	return token, nil
}

func homePage(w http.ResponseWriter, r *http.Request) {
	validToken, err := criarJWT()
	if err != nil {
		fmt.Fprintf(w, err.Error())
	}

	cliente := &http.Client{}
	req, _ := http.NewRequest("GET", "http://localhost:3003/", nil)
	req.Header.Set("Token", validToken)
	res, err := cliente.Do(req)
	if err != nil {
		fmt.Fprintf(w, "Erro: %s", err.Error())
	}

	body, err := ioutil.ReadAll(res.Body)
	if err != nil {
		fmt.Fprintf(w, err.Error())
	}

	fmt.Fprintf(w, string(body))
}

func handleRequest() {
	http.HandleFunc("/", homePage)
	log.Fatal(http.ListenAndServe(":3002", nil))
}
