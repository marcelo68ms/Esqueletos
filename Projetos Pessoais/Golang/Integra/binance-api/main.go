package main

import (
	"fmt"
	"log"
	"time"

	"github.com/xenking/binance-api"
	"github.com/xenking/binance-api/ws"
)

const key = "HfphXtx12kQwKtWI2Ia4nTt4njh15GP48kyrdo7oEXuh7smIdeySyhSeH4RihvXB"
const secret = "jiodAdP4FO3BFM16FCxqR2XyVVcgnVHFaMkHoey4t7IWKoa4aWfjcmNTwhmiAqAe"

// layout - Máscara para formatação da data e hora
const layout string = "2006-01-02 15:04:05"

func main() {
	//initApi()
	chamadaWS()
}

func initApi() {
	client := binance.NewClient(key, secret)

	err := client.Ping()
	if err != nil {
		panic(err)
	}

	prices, err := client.Prices()
	if err != nil {
		panic(err)
	}

	for _, p := range prices {
		log.Printf("symbol: %s, price: %s", p.Symbol, p.Price)
	}

}

func chamadaWS() {
	// Create default client
	/*client := binance.NewClient("API-KEY", "SECRET")

	// Send ping request
	err := client.Ping()

	*/
	// Create client with custom request window size
	//	client := binance.NewClient(api, secret).ReqWindow(5000)

	// Create websocket client
	wsClient := ws.NewClient()

	// Connect to Klines websocket
	ws, erro := wsClient.Klines("BTCUSDT", binance.KlineInterval1min)
	if erro != nil {
		panic(erro)
	}

	// Read ws
	msg, err := ws.Read()
	if err != nil {
		panic(err)
	}

	fmt.Println(msg)
	//	fmt.Println(msg.Time)

	timestamp := msg.Time
	t := time.Unix(int64(timestamp), 0)
	t2 := time.Unix(0, int64(timestamp))

	fmt.Println(t.Format(layout))
	fmt.Println(t2.Format(layout))

	//	newTimestamp := time.Date(t.Year(), t.Month(), t.Day(), 0, 0, 0, 0, time.UTC).Unix()
	//	fmt.Println(newTimestamp)

}
