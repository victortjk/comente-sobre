function retiraFormatacao (cpf) {
    //Retira formatacao do CPF
    cpf = cpf.replace('-', '');//retiro o tra�o
    cpf = cpf.replace(/\./g, '');//retiro todos os pontos
    return cpf;
}

