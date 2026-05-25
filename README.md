### Cucumber Test Saque BDD JUnit
### Descrição
  Este projeto tem como visão realizar cenários de testes que abrange dois testes relacionados a uma operação bancária (saque bancário) usando cucumber e JUnit como ferramenta de teste.
### Mecânicas
  O uso do "runner.java" do cucumber-JUnit para testar os cenários e também o uso do cucumber para a aplicação do BDD (Behavior Driven Development) em java. O arquivo "Conta_BDD.feature" conta com os cenários e o que é esperado deles. Já o arquivo "runner.java" executara o teste e retornara o que passou ou não no teste.
  
  ### O que é esperado dos cenários
  <div align="center">
<img src="https://cdn.discordapp.com/attachments/1040755969589788675/1040756101093789808/Junit1.png?ex=6a161fa6&is=6a14ce26&hm=8b679946e64f969f75c6b3fcad75fc678cf4cd0c0e772e0243b04cead5c35e17">
</div>

### Os cenários testes (com código comentado)
<div align="center">
<img src="https://cdn.discordapp.com/attachments/1040755969589788675/1040764281400070174/image.png?ex=6a162745&is=6a14d5c5&hm=19d3e055be615f84a7ea8132981b73ad86f40f88085c8f7dd9b03b14575ef061">
</div>
  
  ### Código Runner.java
  <div align="center">
<img src="https://cdn.discordapp.com/attachments/1040755969589788675/1040763507722961046/image.png?ex=6a16268c&is=6a14d50c&hm=ee8cf62bef92f3f9d59b2c40502df0c39b9780c3001b31b08ce0f5c80e0ee8f1">
</div>

### Execução do Runner.java
Vale lembrar que dependendo do do tipo do cliente declarado no "conta.java" na variavel booleana "cliEspecial" (caso a variavel seja TRUE sera cliente especial e FALSO sera cliente comum) o resultado do "runner.java" sera diferente dependendo disto. Alem disto, caso o "dryRun" no runner.java seja alterada para TRUE ele não retornara erro.
### cliEspecial = true (cliente especial)
<div align="center">
<img src="https://cdn.discordapp.com/attachments/1040755969589788675/1043330086067241030/image.png?ex=6a15999c&is=6a14481c&hm=3b62ef42f573091c185fb4dec38c2d2534e5a562b1b4b5df1f87880720898ae2">
</div>

### cliEspecial = false (cliente comum)
<div align="center">
<img src="https://cdn.discordapp.com/attachments/1040755969589788675/1043330476561154078/image.png?ex=6a1599f9&is=6a144879&hm=6d1ac846d3f0efa348d154c04869ac99cd21e5f7a0853014d377d02e70e53ddc">
</div>


### Como usar
  Baixe o projeto (crie uma pasta "disciplinaqualidade" e coloque os arquivos dentro para evitar problemas com o nome do projeto na hora de executar) e abra-o em uma IDE (recomendado Eclipse) porem antes sera necessário baixar algumas dependências (java 8, cucumber-junit plugin), após o projeto       aberto e as dependências instaladas basta executar o "Runner.java". 
### Ajuda
  Basta entrar em contato direto com o criador deste repositorio no github.
### Contribuidores (quem mantem o projeto)
  VnFroes
