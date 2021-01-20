package main

import (
	"fmt"

	"golang.org/x/crypto/bcrypt"
)

// fraseSecreta usada para a criptografia da senha
const fraseSecreta string = "A_ilha_de_Tortuga_so_pode_ser_achada_por_aqueles_que_sabem_onde_ela_fica!"

func main() {
	fmt.Println("Teste de criptografia")
	fmt.Println(senhaCriptografada("senha.."))

	fmt.Println(isSenhaReal(senhaCriptografada("senha.")))
}

// senhaCriptografada Retorna a senha criptografada
func senhaCriptografada(senha string) string {
	senhaInicialByte := []byte(senha)
	senhaByte, _ := bcrypt.GenerateFromPassword(senhaInicialByte, bcrypt.MaxCost)
	return string(senhaByte)
}

func isSenhaReal(senha string) error {
	senhaInicialByte := []byte(senha)
	senhaComp := []byte("senha..")
	erro := bcrypt.CompareHashAndPassword(senhaInicialByte, senhaComp)
	/*if erro != nil {
		return true
	} */
	return erro
}
