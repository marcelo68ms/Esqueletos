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

	firebase "firebase.google.com/go"
	"google.golang.org/api/iterator"
	"google.golang.org/api/option"

	"cloud.google.com/go/firestore"
)

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
	opt := option.WithCredentialsFile("/home/marcelo/Trabalho/Empresas/TopSeed/felicitatem/Fontes/SeguirAtivos/backend/felicitatem-5224a-firebase-adminsdk-68o8w-ba1383a048.json")

	app, err := firebase.NewApp(ctx, nil, opt)

	if err != nil {
		log.Fatal("Erro de inicialização: %v", err)
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
	delLinha(*client, ctx)
}
