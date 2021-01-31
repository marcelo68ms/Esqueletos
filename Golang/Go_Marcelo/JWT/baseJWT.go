package main

import (
	"fmt"
	"time"

	"github.com/dgrijalva/jwt-go"
)

// fraseSecreta usada para a criptografia da senha
const fraseSecreta string = "A_ilha_de_Tortuga_so_pode_ser_achada_por_aqueles_que_sabem_onde_ela_fica!"

func main() {
	fmt.Println("Caso simples de Geração de JWT")
	token, err := criarJWT()
	if err != nil {
		fmt.Println("Erro na geração do Token")
	}
	fmt.Println(token)
}

func criarJWT() (string, error) {
	var err error
	atClaims := jwt.MapClaims{}
	atClaims["authorized"] = true
	atClaims["user"] = "usuario.UsEmail"
	atClaims["group"] = 1
	atClaims["name"] = "usuario.UsNome"
	atClaims["exp"] = time.Now().Add(time.Minute * 15).Unix()
	at := jwt.NewWithClaims(jwt.SigningMethodHS256, atClaims)

	token, err := at.SignedString([]byte(fraseSecreta))

	if err != nil {
		//fmt.Errorf("Erro na geração do JWT: %s", err.Error())
		return "", err
	}
	return token, nil
}
