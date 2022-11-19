import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class conta {
	/**
	 * Cenário: 1 (saque cliente especial)
	 * 
	 * Cliente da categoria "especial" deseja realizar um saque = 100 do saldo da conta = -200
	 * 
	 * Este tem a disposição a realização de um saque (com previlégios)
	 * 
	 * Mesmo se o cliente possuir saldo negativo este ainda pode sacar dinheiro (Saque = 100 dá conta de saldo = -200, espera se que fica com saldo de -300)
	 *  
	 */
	
	/**
	*Variaveis inteiros para armazenar Saque e Saldo e extrato da conta
	*/
	
	int saque;
	int saldo;
	int contaExtrato;
	
	/**
	 * Booleano (para saber se o cliente é comum ou especial) 
	 */
	
	boolean cliEspecial = true;
	
	/**If para determinar o tipo de cliente para os cenarios 1 e 2 */
	
	public void tipoCliente() {

	}
	
	@Given("^um cliente especial com saldo atual de -(\\d+) reais$")
	public void um_cliente_especial_com_saldo_atual_de_reais(int contaExtrato) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		/**Variavel "saldo" vai receber o valor do parametro "contaExtrato", assumindo o valor determinado no "Conta_BDD.feature" Cenário 1 */
		
		
		/**If para testar se o cliente é do tipo especial. Senão o cucumber retornará como erro*/
		
		if(this.cliEspecial == true) {
			this.saldo = contaExtrato;
		}else {throw new PendingException();}
	}
	
	/**
	 * Solicitação de saque pelo cliente
	 *
	 */

	@When("^for solicitado um saque no valor de (\\d+) reais$")
	public void for_solicitado_um_saque_no_valor_de_reais(int saque) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		/**Variavel "saque" vai receber o valor do parametro "saque", assumindo o valor estabelecido no "Conta_BDD.feature" Cenário 1 */
		
		
		
		/**If para testar se o cliente é do tipo especial. Senão o cucumber retornará erro*/
		
		if (this.cliEspecial == true) {
			this.saque =saque;
		} else {throw new PendingException();}
	}
	
	/**
	 * Efetuação do saque mesmo se o cliente especial tiver saldo negativo 
	 * Saque realiziado = atualização do saldo do cliente (caso saldo esteja negativo, negativalo ainda mais)
	 *
	 */

	@Then("^deve efetuar o saque e atualizar o saldo da conta para -(\\d+) reias$")
	public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reias(int saque) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		/**If para se o cliente é do tipo especial, Realizar a atualização do extrato do cliente especial*
		 * Senão o cucumber deverá retornar erro
		 */
		
		if (this.cliEspecial == true) {
			saldo = this.contaExtrato - (this.saque);
		} else {throw new PendingException();}
	}
	
	/**
	 * Cenário: 2 (saque cliente comum)
	 * 
	 * Cliente da categoria "comum" deseja realizar um saque (saque= 200 do saldo da conta = -300, espera se que retorne "saldo insulficiente")
	 * 
	 * Este tem a disposição a realização de um saque (sem privilégios)
	 * 
	 * Caso este cliente deseje realizar um saque com um valor maior que o saldo, este cliente não podera realizar o saque (saldo insulficiente)
	 *  
	 */

	@Given("^um cliente comum com saldo atual de -(\\d+) reais$")
	public void um_cliente_comum_com_saldo_atual_de_reais(int contaExtrato) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		/**Variavel "saldo" vai receber o valor do parametro "contaExtrato", assumindo o valor determinado no "Conta_BDD.feature" Cenário 2 */
		
		
		
		/**If para testar se o cliente é do tipo comum. Senão o cucumber retornará como erro*/
		
		if(this.cliEspecial == false) {
			this.saldo = contaExtrato;
		}else {throw new PendingException();}
	}
	
	/**
	 * Solicitação de saque pelo cliente
	 *
	 */

	@When("^solicitar um saque de (\\d+) reais$")
	public void solicitar_um_saque_de_reais(int saque) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		/**Variavel saque vai receber o valor do parametro "saque", assumindo o valor estabelecido no cenario 2 no "Conta_BDD.feature"*/
		
		
		
		/**If para testar se caso o valor do saque seja o valor estabelecido no segundo cenario da "Conta_BDD.feature"
		 *Senão o cucumber retornará como erro*/
		
		if (this.cliEspecial == false) {
			this.saque = saque;
		} else {throw new PendingException();}
	}
	
	/**
	 * Efetuação do saque apenas se este tiver o valor na conta, caso o saque seja maior que saldo o saque não é realizado ("saldo insulficiente") 
	 */

	@Then("^nao deve efetuar o saque e deve retornar a mensagem saldo insulficiente$")
	public void nao_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_saldo_insulficiente() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		/**If para testar se caso o valor saque for menor do valor do extrato e se o estrato é maior que 0 e o cliente do tipo comum.
		 * Já o Else if retornará o esperado para um cliente comum com um saque maior que o extrato ("Saldo insulficiente")
		 * e o else, o cucumber retornará erro 
		 */
		
		if (this.cliEspecial == false && this.saque < this.contaExtrato && this.contaExtrato > 0) {

		} else if (this.saque > this.contaExtrato) {
			System.out.println("Saldo insuficiente");
		} else
			throw new PendingException();
	}

}
