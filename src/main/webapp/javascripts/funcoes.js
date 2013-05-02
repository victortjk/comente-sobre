function retiraFormatacao (cpf) {
    //Retira formatacao do CPF
    cpf = cpf.replace('-', '');//retiro o traço
    cpf = cpf.replace(/\./g, '');//retiro todos os pontos
    return cpf;
}

