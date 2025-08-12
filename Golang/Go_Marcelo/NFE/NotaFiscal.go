package main

import (
	"encoding/json"
	"fmt"
	"net/http"

	"github.com/frones/nfe"
)

func main() {
	client, err := nfe.NewHTTPClient("~/client.pem", "~/key.pem")
	if err != nil {
		fmt.Printf("Erro na criação do HTTP Client e leitura do certificado. Detalhes: %v\n", err)
		return
	}
	ret, xmlfile, err := nfe.ConsultaNFe("12345678901234567890123456789012345678901234", nfe.Homologacao, client, func(req *http.Request) { req.Header.Set("User-Agent", "MyUA/1.0") })
	if err != nil {
		fmt.Printf("Erro na consulta da chave de acesso. Detalhes: %v\n", err)
		return
	}

	fmt.Printf("Objeto RetConsSitNFe: %v\n", ret)
	fmt.Printf("Arquivo XML: %v\n", string(xmlfile))

	jsonfile, err := json.Marshal(ret)
	if err != nil {
		fmt.Printf("Erro na serialização do json. Detalhes: %v\n", err)
		return
	}
	fmt.Printf("Arquivo JSON: %v\n", string(jsonfile))
}
