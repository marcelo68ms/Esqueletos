package main

import (
	"fmt"
	"regexp"
	"strings"
)

type marketTimeValue struct {
	Open     string `json:"open"`
	Close    string `json:"close"`
	Timezone int    `json:"timezone"`
}

type assetGeral struct {
	Symbol        string          `json:"symbol"`
	Name          string          `json:"name"`
	CompanyName   string          `json:"company_name"`
	Document      string          `json:"document"`
	Description   string          `json:"description"`
	Website       string          `json:"website"`
	Region        string          `json:"region"`
	Currency      string          `json:"currency"`
	MarketTime    marketTimeValue `json:"market_time"`
	MarketCap     float64         `json:"market_cap"`
	Price         float64         `json:"price"`
	ChangePercent float64         `json:"change_percent"`
	UpdatedAt     string          `json:"updated_at"`
}

type resultsGeral struct {
	Asset assetGeral `json:"value"`
}

type CotacaoAsset2 struct {
	By            string       `json:"by"`
	ValidKey      bool         `json:"valid_key"`
	Results       resultsGeral `json:"results_geral"`
	ExecutionTime float64      `json:"execution_time"`
	FromCache     bool         `json:"from_cache"`
}

func maint() {
	// Finding regexp from the given string
	// Using FindString() method
	m := regexp.MustCompile(`geek`)
	fmt.Println(m.FindString("GeeksgeeksGeeks, geeks"))

	fmt.Println(strings.Replace("gfg gfg gfg", "g", "kc", 1))
	fmt.Println(strings.Replace("gfg gfg gfg", "fg", "TTTT", -1))
}
