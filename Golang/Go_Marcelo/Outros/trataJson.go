package main

import (
	"encoding/json"
	"fmt"
)

type Post struct {
	ID      uint   `json:"id"`
	Title   string `json:"title"`
	Author  string `json:"author"`
	Content string `json:"content"`
}

func mainz() {
	// create an instance of Post struct
	post := Post{}

	// convert a JSON string to a []byte first
	b := []byte(`{"id":1,"title":"Golang Tutorial","author":"Suraj Sharma","content":"Learn Golang by examples"}`)

	// use json.UnMarshal to convert the []byte of JSON data to struct
	// by passing pointer to post variable as a second argument

	err := json.Unmarshal(b, &post)

	if err != nil {
		fmt.Println("Unable to convert the JSON string to a struct")
	} else {
		// print the post
		fmt.Println(post)
	}
}
