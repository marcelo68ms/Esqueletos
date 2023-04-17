package main

import (
	"log"
	"net/smtp"
)

func main() {
	send("Sou o 'Odorico', estou aprendendo a fazer Trade, seja paciente comigo")
}

func send(body string) {
	from := "marcelo68ms@gmail.com"
	pass := "vtbvtkzdiqukkxkz"
	to := "marcelo68ms@yahoo.com.br"

	msg := "From: " + from + "\n" +
		"To: " + to + "\n" +
		"Subject: [Odorico] - Negociação de Moedas\n\n" +
		body

	err := smtp.SendMail("smtp.gmail.com:587",
		smtp.PlainAuth("", from, pass, "smtp.gmail.com"),
		from, []string{to}, []byte(msg))

	if err != nil {
		log.Printf("smtp error: %s", err)
		return
	}

}
