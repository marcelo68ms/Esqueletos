package main

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"
	"strings"
)

type CotacaoAsset struct {
	By       string `json:"by"`
	ValidKey bool   `json:"valid_key"`
	Results  struct {
		Asset struct {
			Symbol      string `json:"symbol"`
			Name        string `json:"name"`
			CompanyName string `json:"company_name"`
			Document    string `json:"document"`
			Description string `json:"description"`
			Website     string `json:"website"`
			Region      string `json:"region"`
			Currency    string `json:"currency"`
			MarketTime  struct {
				Open     string `json:"open"`
				Close    string `json:"close"`
				Timezone int    `json:"timezone"`
			} `json:"market_time"`
			MarketCap     float64 `json:"market_cap"`
			Price         float64 `json:"price"`
			ChangePercent float64 `json:"change_percent"`
			UpdatedAt     string  `json:"updated_at"`
		} `json:"valores"`
	} `json:"results"`
	ExecutionTime float64 `json:"execution_time"`
	FromCache     bool    `json:"from_cache"`
}

func main() {

	post := CotacaoAsset{}

	// Obtém o feed de rss através da url
	resp, err := http.Get("https://api.hgbrasil.com/finance/stock_price?key=2b474478&symbol=TASA3")

	if err != nil {
		s := err.Error()
		fmt.Printf("%q\n", s)
		return
	}

	// Sinaliza que a última ação a ser feita no programa é o fechamento da resposta
	defer resp.Body.Close()

	// Verifica se o código de status é 200, indicando assim o sucesso da solicitação
	if resp.StatusCode != 200 {
		println(resp.StatusCode)
		return
	}

	// Por fim escreve o conteúdo do feed de rss
	bodyBytes, err2 := ioutil.ReadAll(resp.Body)

	if err2 != nil {
		s := err2.Error()
		fmt.Printf("%q\n", s)
		return
	}

	novo := strings.Replace(string(bodyBytes), "TASA3", "valores", 1)
	antes := []byte(novo)

	err3 := json.Unmarshal(antes, &post)

	if err3 != nil {
		fmt.Println("Unable to convert the JSON string to a struct")
	} else {
		// print the post
		fmt.Println(string(bodyBytes))
		fmt.Println(post.Results.Asset.CompanyName)
	}
}
