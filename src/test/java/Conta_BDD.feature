
@tag
Feature: cliente faz saque de dinheiro como um cliente, eu gostaria de sacar dinheiro num caixa eletronico,
  para que eu nao tenha que esperar na fila do banco
   
   #Cenario 1 (Saque Cliente Especial)
 
  @tag1
  Scenario: cliente especial com saldo negativo
    Given um cliente especial com saldo atual de -200 reais
    When for solicitado um saque no valor de 100 reais
    Then deve efetuar o saque e atualizar o saldo da conta para -300 reias
    
    #Cenario 2 (Saque Cliente comum)
    
  @tag2
  Scenario: cliente comum com saldo negativo
    Given um cliente comum com saldo atual de -300 reais
    When solicitar um saque de 200 reais
    Then nao deve efetuar o saque e deve retornar a mensagem saldo insulficiente
