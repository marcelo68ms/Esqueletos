function calcularTodosIMCs() {

    var trsPacientes = document.getElementsByClassName("paciente");

    for (var pacienteAtual = 0; pacienteAtual <= trsPacientes.length - 1; pacienteAtual++) {
        var pacienteTr = trsPacientes[pacienteAtual];
        var tdNome = pacienteTr.getElementsByClassName("info-nome")[0];
        var tdAltura = pacienteTr.getElementsByClassName("info-altura")[0];
        var tdPeso = pacienteTr.getElementsByClassName("info-peso")[0];
        var tdImc = pacienteTr.getElementsByClassName("info-imc")[0];

        var paciente = {nome: tdNome.textContent, peso: tdPeso.textContent, altura: tdAltura.textContent, 
                        pegaImc: function(){
                                    if (this.altura > 0) {
                                    var imc = this.peso / (this.altura * this.altura);
                                    return imc;
                                } else {
                                    console.log("Não posso efetuar o cálculo !");
                                }                          
                            }
                       };

        imc = paciente.pegaImc();

        tdImc.textContent = imc;

    }
}

var botao = document.getElementById("calcula-imcs");
//botao.onclick = calcularTodosIMCs;
botao.addEventListener("click", calcularTodosIMCs);