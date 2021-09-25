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
	pass := "B7556E35AAA2E5E81B68EE748AF1CE7D024A"
	to := "marcelo68ms@gmail.com"

	msg := "From: " + from + "\n" +
		"To: " + to + "\n" +
		"Subject: [Odorico] - Negociação de Moedas\n\n" +
		body

	err := smtp.SendMail("smtp.elasticemail.com:2525",
		smtp.PlainAuth("", from, pass, "smtp.elasticemail.com"),
		from, []string{to}, []byte(msg))

	if err != nil {
		log.Printf("smtp error: %s", err)
		return
	}

}
