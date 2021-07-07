package main

import (
	"context"
	"fmt"

	"github.com/adshao/go-binance"
)

func main() {
	// go get github.com/adshao/go-binance
	var (
		apiKey    = "HfphXtx12kQwKtWI2Ia4nTt4njh15GP48kyrdo7oEXuh7smIdeySyhSeH4RihvXB"
		secretKey = "jiodAdP4FO3BFM16FCxqR2XyVVcgnVHFaMkHoey4t7IWKoa4aWfjcmNTwhmiAqAe"
	)
	client := binance.NewClient(apiKey, secretKey)

	// get account
	res, err := client.NewGetAccountService().Do(context.Background())
	if err != nil {
		fmt.Println(err)
		return
	}
	fmt.Println(res)
}
