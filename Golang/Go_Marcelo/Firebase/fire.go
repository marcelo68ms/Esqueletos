// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

// Sample firestore_quickstart demonstrates how to connect to Firestore, and add and list documents.
package main

// [START firestore_setup_client_create]
import (
	"context"
	"fmt"
	"log"
	"time"

	"cloud.google.com/go/firestore"
	firebase "firebase.google.com/go"
	"google.golang.org/api/iterator"
	"google.golang.org/api/option"
)

type Leitura struct {
	AtivCodigo     string
	SegDesativa    string
	CliEmail       string
	SegValorCompra float64
	SegMaximo      float64
	SegMinimo      float64
}

func main_X() {
	// Get a Firestore client.
	ctx := context.Background()
	//client := createClient(ctx)
	client := Inicializa(ctx)
	defer client.Close()

	// [START firestore_setup_dataset_pt1]
	_, _, err := client.Collection("ativos").Add(ctx, map[string]interface{}{
		"first": "Ada",
		"last":  "Lovelace",
		"born":  1815,
	})
	if err != nil {
		log.Fatalf("Failed adding alovelace: %v", err)
	}
	// [END firestore_setup_dataset_pt1]

	// [START firestore_setup_dataset_pt2]
	_, _, err = client.Collection("ativos").Add(ctx, map[string]interface{}{
		"first":  "Alan",
		"middle": "Mathison",
		"last":   "Turing",
		"born":   1912,
	})
	if err != nil {
		log.Fatalf("Failed adding aturing: %v", err)
	}
	// [END firestore_setup_dataset_pt2]

	// [START firestore_setup_dataset_read]
	iter := client.Collection("ativos").Documents(ctx)
	for {
		doc, err := iter.Next()
		if err == iterator.Done {
			break
		}
		if err != nil {
			log.Fatalf("Failed to iterate: %v", err)
		}
		fmt.Println(doc.Data())
	}
	// [END firestore_setup_dataset_read]
	//if client != nil {
	//	client.Close()
	//}
}

// Inicializa - Efetua a conexão com a conta do projeto no Firebase
func Inicializa(ctx context.Context) *firestore.Client {

	//	ctx := context.Background()
	opt := option.WithCredentialsFile("/home/marcelo/Projetos/felicitatem/Fontes/SeguirAtivos/backend/felicitatem-5224a-firebase-adminsdk-68o8w-ba1383a048.json")

	app, err := firebase.NewApp(ctx, nil, opt)

	if err != nil {
		log.Fatal("Erro de inicialização: %s", err)
	}
	client, err := app.Firestore(ctx)
	if err != nil {
		log.Fatalln(err)
	}
	//defer client.Close()

	return client
}

func addLinha(client firestore.Client, ctx context.Context) {
	_, err := client.Collection("ativos").Doc("BBDC3").Set(ctx, map[string]interface{}{
		"nome":   "Banco Bradesco S/A",
		"status": "A",
	})
	if err != nil {
		// Handle any errors in an appropriate way, such as returning them.
		log.Printf("An error has occurred: %s", err)
	}
}

func altLinha(client firestore.Client, ctx context.Context) {
	_, err := client.Collection("ativos").Doc("BBDC3").Set(ctx, map[string]interface{}{
		"status": "I",
	}, firestore.MergeAll)

	if err != nil {
		// Handle any errors in an appropriate way, such as returning them.
		log.Printf("An error has occurred: %s", err)
	}
}

func delLinha(client firestore.Client, ctx context.Context) {
	_, err := client.Collection("ativos").Doc("BBDC3").Delete(ctx)
	if err != nil {
		// Handle any errors in an appropriate way, such as returning them.
		log.Printf("An error has occurred: %s", err)
	}
}

func main() {
	// Get a Firestore client.
	ctx := context.Background()
	//client := createClient(ctx)
	client := Inicializa(ctx)
	defer client.Close()

	//	addLinha(*client, ctx)
	//altLinha(*client, ctx)
	//delLinha(*client, ctx)
	//addLinhaCotacao(*client, ctx)
	//addLinhaSeguir(*client, ctx)
	CarregaTodosAtivos(*client, ctx)
	//fmt.Println(expoSeguirV2(*client, ctx))
	//lerDocumentos(*client, ctx)
}

func addLinhaCotacao(client firestore.Client, ctx context.Context) {
	_, err := client.Collection("cotacao").Doc(time.Now().String()).Set(ctx, map[string]interface{}{
		"ativo": "PETR4",
		"valor": 35.45,
	})
	if err != nil {
		// Handle any errors in an appropriate way, such as returning them.
		log.Printf("An error has occurred: %s", err)
	}
}

func addLinhaSeguir(client firestore.Client, ctx context.Context) {

	data := time.Now()

	ativo := "XPML11"
	valorBase := 97.80
	maximo := (valorBase * 1.12)
	minimo := valorBase - (valorBase * 0.03)

	_, err := client.Collection("seguidos").Doc("marcelo68ms@gmail.com|"+ativo).Set(ctx, map[string]interface{}{
		"ativo":           ativo,
		"dataDesativacao": data.Format("2006-01-02 15:04:05"),
		"email":           "marcelo68ms@gmail.com",
		"valorCompra":     valorBase,
		"valorMaximo":     maximo,
		"valorMinimo":     minimo,
	})
	if err != nil {
		// Handle any errors in an appropriate way, such as returning them.
		log.Printf("An error has occurred: %s", err)
	}
}

func expoeTodosAtivos(client firestore.Client, ctx context.Context) {

	// [START firestore_setup_dataset_read]
	iter := client.Collection("ativos").Documents(ctx)
	for {
		doc, err := iter.Next()
		if err == iterator.Done {
			break
		}
		if err != nil {
			log.Fatalf("Failed to iterate: %v", err)
		}
		fmt.Println(doc.Data())
	}
}

func expoSeguir(client firestore.Client, ctx context.Context) []Leitura {
	var ativos []Leitura

	iter := client.Collection("seguidos").Documents(ctx)
	for {
		doc, err := iter.Next()
		if err == iterator.Done {
			break
		}
		if err != nil {
			log.Fatalf("Failed to iterate: %v", err)
		}
		todos := doc.Data()
		/*
			for k, v := range todos {
				switch c := v.(type) {
				case string:
					fmt.Printf("Item %q is a string, containing %q\n", k, c)
				case float64:
					fmt.Printf("Looks like item %q is a number, specifically %f\n", k, c)
				default:
					fmt.Printf("Not sure what type item %q is, but I think it might be %T\n", k, c)
				}
			}
		*/
		var leitura Leitura
		for campo, item := range todos {

			switch valor := item.(type) {
			case string:
				if campo == "ativo" {
					leitura.AtivCodigo = valor
				}
				if campo == "email" {
					leitura.CliEmail = valor
				}
				if campo == "dataDesativacao" {
					leitura.SegDesativa = valor
				}
			case float64:
				if campo == "valorCompra" {
					leitura.SegValorCompra = valor
				}
				if campo == "valorMaximo" {
					leitura.SegMaximo = valor
				}
				if campo == "valorMinimo" {
					leitura.SegMinimo = valor
				}

			default:
				fmt.Printf("Not sure what type item %q is, but I think it might be %T\n", campo, valor)
			}

		}
		ativos = append(ativos, leitura)
	}
	return ativos
}

func expoSeguirV2(client firestore.Client, ctx context.Context) []Leitura {
	var ativos []Leitura

	iter := client.Collection("seguidos").Documents(ctx)
	for {
		doc, err := iter.Next()
		if err == iterator.Done {
			break
		}
		if err != nil {
			log.Fatalf("Failed to iterate: %v", err)
		}

		var leitura Leitura
		var mediano interface{}

		mediano, _ = doc.DataAt("ativo")
		leitura.AtivCodigo = fmt.Sprintf("%v", mediano)

		mediano, _ = doc.DataAt("email")
		leitura.CliEmail = fmt.Sprintf("%v", mediano)

		mediano, _ = doc.DataAt("dataDesativacao")
		leitura.SegDesativa = fmt.Sprintf("%v", mediano)

		mediano, _ = doc.DataAt("valorCompra")
		leitura.SegValorCompra = mediano.(float64)

		mediano, _ = doc.DataAt("valorMaximo")
		leitura.SegMaximo = mediano.(float64)

		mediano, _ = doc.DataAt("valorMinimo")
		leitura.SegMinimo = mediano.(float64)

		ativos = append(ativos, leitura)
	}
	return ativos
}

// ------------------------------------------------------------------------------------------------
func lerDocumentos(client firestore.Client, ctx context.Context) {
	itens := client.Collection("seguidos").Doc("marcelo68ms@gmail.com|AMER3").Snapshots(ctx)
	defer itens.Stop()

	doc, err := itens.Next()

	if err != nil {

	}
	fmt.Println(doc.Data())
	x, _ := doc.DataAt("ativo")
	fmt.Println(x)
}
