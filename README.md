### Cucumber Test Saque BDD JUnit
### Descrição
  Este projeto tem como visão realizar cenários de testes que abrange dois testes relacionados a uma operação bancária (saque bancário) usando cucumber e JUnit como ferramenta de teste.
### Mecânicas
  O uso do "runner.java" do cucumber-JUnit para testar os cenarios e tambem o uso do cucumber para a aplicação do BDD (Behavior Driven Development) em java. O arquivo "Conta_BDD.feature" conta com os cenários e o que é esperado deles. Ja o arquivo "runner.java" executara o teste e retornara oq passou ou nao neste.
  
  ### O que e esperado dos cenarios
  <div align="center">
<img src="https://cdn.discordapp.com/attachments/1040755969589788675/1040764281400070174/image.png">
</div>

### Os cenarios testes (com codigo comentado)
<div align="center">
<img src="https://cdn.discordapp.com/attachments/1040755969589788675/1040764735987122279/image.png">
</div>
  
  ### Codigo Runner.java
  <div align="center">
<img src="https://cdn.discordapp.com/attachments/1040755969589788675/1040764428913737818/image.png">
</div>

### Execução do Runner.java
Vale lembrar que dependendo do do tipo do cliente declarado no "conta.java" na variavel booleana "cliEspecial" caso a variavel seja TRUE sera cliente especial e FALSO sera comum o resultado do "runner.java" sera diferente dependendo disto. Caso o "dryRun" no runner.java seja alterada para TRUE ele nao retornara erro.
### cliEspecial = true (cliente especial)
<div align="center">
<img src="https://cdn.discordapp.com/attachments/1040755969589788675/1040763507722961046/image.png">
</div>

### cliEspecial = false (cliente comum)
<div align="center">
<img src="https://cdn.discordapp.com/attachments/1040755969589788675/1040773113031426128/image.png">
</div>


### Como usar
  Baixe o projeto (crie uma pasta "disciplinaqualidade" e coloque os arquivos dentro para evitar problemas com o nome do projeto na hora de executar) e abra-o em uma IDE (recomendado Eclipse) porem antes sera necessário baixar algumas dependências (java 8, cucumber plugin), após o projeto       aberto e as dependências instaladas basta executar o "Runner.java". 
### Ajuda
  Basta entrar em contato direto com o criador deste repositorio no github.
### Contribuidores (quem mantem o projeto)
  VnFroes
