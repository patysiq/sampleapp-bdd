#language: pt

Funcionalidade: Acessar site SampleApp e realizar testes

  Cenario: Acessar o item de vagas de tecnologia
    Dado que eu estou no site da SampleApp
    E preencho o formulário, aba "Enter Vehicle Data"
    E preencho o formulário Enter Vehicle Data
    E clico em next button
    E preencho o formulário, aba "Enter Insurant Data"
    E preencho o formulário, aba Enter Insurant Data
    E clico em next 0
    E preencho o formulário, aba "Enter Product Data"
    E preencho o formulário, aba Enter Product Data
    E clico em next 1
    E preencho o formulário, aba "Select Price Option"
    E preencho o formulário, aba Select Price Option
    E clico em next 2
    E preencho o formulário, aba "Send Quote"
    E preencho o formulário, aba Send Quote
    E clico em Send
    Entao verifico a mensagem "Sending e-mail success!"
