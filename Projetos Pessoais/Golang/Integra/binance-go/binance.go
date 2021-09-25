package main

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"log"
	"net/http"
	"strconv"
	"time"

	"github.com/marcelo68ms/binance-go"
	"github.com/marcelo68ms/binance-go/account"
	"github.com/marcelo68ms/binance-go/market"
)

const apiKey string = "HfphXtx12kQwKtWI2Ia4nTt4njh15GP48kyrdo7oEXuh7smIdeySyhSeH4RihvXB"
const secretKey string = "jiodAdP4FO3BFM16FCxqR2XyVVcgnVHFaMkHoey4t7IWKoa4aWfjcmNTwhmiAqAe"

// https://github.com/marcelo68ms/binance-go

const millisInSecond = 1000
const nsInSecond = 1000000

// fromUnixMilli - Converts Unix Epoch from milliseconds to time.Time
func fromUnixMilli(ms int64) time.Time {
	return time.Unix(ms/int64(millisInSecond), (ms%int64(millisInSecond))*int64(nsInSecond))
}

func informacoesConta() {
	binanceClient := binance.Client{}
	binanceClient.Init(apiKey, secretKey)
	p, err := binanceClient.Account.Info()
	if err != nil {
		fmt.Printf("err = %v", err)
		return
	}
	fmt.Printf("%v", p)

	fmt.Println(p.Balances[0])
	fmt.Println(p.Balances[13])

}

func horarioBinance() {
	serverTime := binance.General().ServerTime()
	novadata := serverTime.Format("2006-01-02 15:04:05")
	log.Printf("%v", serverTime)
	fmt.Println(novadata)
}

func carregaSaldo() {

	binanceClient := binance.Client{}
	binanceClient.Init(apiKey, secretKey)
	dadosSaldo, _ := binanceClient.Account.Info()
	balance := dadosSaldo.Balances

	var btcLivre string
	var btcBloc string
	var dolarLivre string
	var dolarBloc string

	for _, num := range balance {
		if num.Asset == "BTC" {
			btcLivre = num.Free
			btcBloc = num.Locked
		}

		if num.Asset == "USDT" {
			dolarLivre = num.Free
			dolarBloc = num.Locked
		}
	}

	//valor, _ := strconv.ParseFloat(btcLivre, 64)
	//valor = valor * 0.5

	fmt.Print("BTC - Livre: ")
	fmt.Println(btcLivre)
	fmt.Print("BTC - Bloc: ")
	fmt.Println(btcBloc)
	fmt.Print("BTC - Dolar Livre: ")
	fmt.Println(dolarLivre)
	fmt.Print("BTC - Dolar Bloc: ")
	fmt.Println(dolarBloc)
	//fmt.Println(valor)

}

func ticketPreco() {
	p, err := binance.Market().Prices()
	if err != nil {
		log.Printf("err = %v", err)
		return
	}
	log.Printf("%v", p)
}

func ordensAbertas() {

	binanceClient := binance.Client{}
	binanceClient.Init(apiKey, secretKey)
	params := account.Params{
		Symbol: "BTCUSDT",
	}

	p, err := binanceClient.Account.OpenOrders(params)
	if err != nil {
		log.Printf("err = %v", err)
		return
	}

	for _, num := range p {
		data1 := num.Time
		moeda := num.Symbol
		id := num.OrderID
		status := num.Status
		qtd := num.OrigQty
		preco := num.Price
		tipo := num.Type
		operacao := num.Side

		data2 := fromUnixMilli(data1)
		data := data2.Format("2006-01-02 15:04:05")

		fmt.Print("Data Final: ")
		fmt.Println(data)

		fmt.Print("Moeda: ")
		fmt.Println(moeda)
		fmt.Print("Id: ")
		fmt.Println(id)
		fmt.Print("Status: ")
		fmt.Println(status)
		fmt.Print("Qtd: ")
		fmt.Println(qtd)
		fmt.Print("Preço: ")
		fmt.Println(preco)
		fmt.Print("Tipo: ")
		fmt.Println(tipo)
		fmt.Print("Operação: ")
		fmt.Println(operacao)
	}
}

// compraBTCImediato Efetiva a compra de BTCs de forma imadiata
func compraBTCImediato(api, secret, moeda string, qtd float64) string {
	// BUY
	// "BTCUSDT"
	binanceClient := binance.Client{}
	binanceClient.Init(api, secret)
	params := account.MarketBuyParams{
		Params: account.Params{
			Symbol:     moeda,
			RecvWindow: 6000,
		},
		// Qtd em BTCs
		Quantity: qtd,
	}

	ordem, err := binanceClient.Account.MarketBuy(params)
	if err != nil {
		log.Printf("err = %v", err)
	}
	return ordem.ClientOrderID
}

// vendaBTCImediado Efetua a venda de BTC de forma imediata
func vendaBTCImediado(api, secret, moeda string, qtd float64) string {
	// SELL
	// "BTCUSDT"

	binanceClient := binance.Client{}
	binanceClient.Init(api, secret)
	params := account.MarketSellParams{
		Params: account.Params{
			Symbol: moeda,
		},
		// BTC
		Quantity: qtd,
	}

	ordem, err := binanceClient.Account.MarketSell(params)
	if err != nil {
		log.Printf("err = %v", err)
	}
	return ordem.ClientOrderID
}

// AjustaPrecisaoFloat Acerta a precisão de um Float64 conforme a necessidade
func AjustaPrecisaoFloat(numero float64, precisao int) float64 {
	sPrecisao := strconv.Itoa(precisao)
	temporal := fmt.Sprintf("%."+sPrecisao+"f", numero)
	//fmt.Println(temporal)
	retorno, _ := strconv.ParseFloat(temporal, 64)
	return retorno
}

func buscaPreco() {
	// Cotacao será o responsável pelo envio dos valores de cotação
	type Cotacao struct {
		Symbol string `json:"symbol"`
		Price  string `json:"price"`
	}

	var (
		urlBase     = "https://api.binance.com/api/"
		precoAssent = urlBase + "v3/ticker/price"
		//dolarBTC    = precoAssent + "?symbol=BTCUSDT"
		dolarBTC = precoAssent + "?symbol=BTCUSDT"
		//dolarBTC   = precoAssent + "?symbol=BNBUSDT"
		precoAtivo Cotacao
	)

	response, err := http.Get(dolarBTC)
	if err != nil {
		fmt.Println("Erro na busca do Serviço de Preços !!")
	} else {
		data, nerro := ioutil.ReadAll(response.Body)
		fmt.Print(data)
		if nerro != nil {
			fmt.Printf("Erro 1 --> %v", nerro)
		}

		erro := json.Unmarshal([]byte(data), &precoAtivo)
		if erro != nil {
			fmt.Printf("Erro 2 --> %v", erro)
		}
	}
	fmt.Println(precoAtivo.Symbol)
	fmt.Println(precoAtivo.Price)
}

func consultaOrdem() {
	binanceClient := binance.Client{}
	binanceClient.Init(apiKey, secretKey)
	params := account.OrderStatusParams{
		Params: account.Params{
			Symbol: "BTCUSDT",
		},
		OrderID: "690013300",
	}

	p, err := binanceClient.Account.OrderStatus(params)
	if err != nil {
		log.Printf("err = %v", err)
		return
	}
	log.Printf("%+v", p)
}

// compraBTC Efetiva a compra de BTCs de forma imadiata
func compraBTC(moeda string, qtd, preco float64) string {
	// BUY
	// "BTCUSDT"
	binanceClient := binance.Client{}
	binanceClient.Init(apiKey, secretKey)
	params := account.BuyParams{
		Params: account.Params{
			Symbol:     moeda,
			RecvWindow: 6000,
		},
		Price: preco,
		// Qtd em BTCs
		Quantity: qtd,
	}

	ordem, err := binanceClient.Account.Buy(params)
	if err != nil {
		log.Printf("err = %v", err)
	}
	return ordem.ClientOrderID
}

func livrosNegociacoes() {
	orderBookParams := market.OrderBookParams{
		Symbol: "BTCUSDT",
	}

	p, err := binance.Market().OrderBook(orderBookParams)
	if err != nil {
		log.Printf("err = %v", err)
		return
	}
	log.Printf("%v", p.Asks)
	log.Printf("%v", p.LastUpdateID)
	log.Printf("%v", p.Bids)
}

func novoPreco() {
	p, err := binance.Market().Prices()

	if err != nil {
		log.Printf("err = %v", err)
		return
	}
	//log.Printf("%v", p)
	log.Printf("%v", p["BTCUSDT"].Price)
}

func main() {
	//carregaSaldo()
	//	ticketPreco()
	//compraBTC("BTCUSDT", 0.013530, 8336.02)
	//ordensAbertas()
	// livrosNegociacoes()
	//ordemCompra()
	//	res := VendaBTCImediado(apiKey, secretKey, "BTCUSDT", 0.003)
	//	VendaBTCImediado(apiKey, secretKey, "BTCUSDT", 0.003)
	//CompraBTCImediato(apiKey, secretKey, "BTCUSDT", 0.023553)
	//fmt.Println(AjustaPrecisaoFloat(8.64736548202, 8))
	//	fmt.Println(res)
	//informacoesConta()
	buscaPreco()
	//carregaSaldo()
	//consultaOrdem()
	novoPreco()
}
