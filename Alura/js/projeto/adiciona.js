// var tabela = document.getElementsByName("table")[0];
// document.querySelectorAll; // Retorna um Array

//tabela.textContent = tabela.textContent + pacienteNovo;


var botaoAdiciona = document.querySelector("#adicionar-paciente");

botaoAdiciona.addEventListener("click", function(event){
    
    event.preventDefault(); // impede comportamento padrão
    
    var campoNome = document.querySelector("#campo-nome");
    var campoPeso = document.querySelector("#campo-peso");
    var campoAltura = document.querySelector("#campo-altura");
    
    var pacienteNovo = "<tr class='pacivar botaoAdiciona = document.querySelector("#adicionar-paciente");

botaoAdiciona.addEventListener("click", function(event){
    
    event.preventDefault(); // impede comportamento padrão
    
    var campoNome = document.querySelector("#campo-nome");
    var campoPeso = document.querySelector("#campo-peso");
    var campoAltura = document.querySelector("#campo-altura");
    
    var pacienteNovo = "<tr class='paciente'>" +
				    "<td class='info-nome'>"+ campoNome.value +"</td>" +
				    "<td class='info-peso'>"+ campoPeso.value +"</td>" +
				    "<td class='info-altura'>"+ campoAltura.value +"</td>" +
				    "<td class='info-imc'></td>" +
                   "</tr>";

    var tabela = document.querySelector("table"); // Retorna o primeiro elemento
    tabela.innerHTML += pacienteNovo;  
    
    campoNome.value = "";
    campoAltura.value = "";
    campoPeso.value = "";
    calcularTodosIMCs();
});ente'>" +
				    "<td class='info-nome'>"+ campoNome.value +"</td>" +
				    "<td class='info-peso'>"+ campoPeso.value +"</td>" +
				    "<td class='info-altura'>"+ campoAltura.value +"</td>" +
				    "<td class='info-imc'></td>" +
                   "</tr>";

    var tabela = document.querySelector("table"); // Retorna o primeiro elemento
    tabela.innerHTML += pacienteNovo;  
    
    campoNome.value = "";
    campoAltura.value = "";
    campoPeso.value = "";
    calcularTodosIMCs();
});
