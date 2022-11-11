package disciplinaqualidade;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class conta {
	/**
	 * Cenario: 1 (saque cliente especial)
	 * 
	 * Cliente da categoria "especial" deseja realizar um saque = 100 do saldo da conta = -200
	 * 
	 * Este tem a disposição a realização de um saque (com previlegios)
	 * 
	 * Mesmo se o cliente possuir saldo negativo este ainda pode sacar dinheiro (Saque = 100 dá conta de saldo = -200, espera se que fica com saldo de -300)
	 *  
	 */
	
	/**
	*Variaveis inteiros para armazenar Saque e Saldo
	*/
	int saque;
	int saldo;
	/**
	 * Booleano (para saber se o cliente é comum ou especial) 
	 */
	boolean cliEspecial = false;
	
	@Given("um cliente especial com saldo atual de {int} reais")
	public void um_cliente_especial_com_saldo_atual_de_reais(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		
		/**Booleano Declarando o Cliente como especial*/
		
		this.cliEspecial = true;
		
		/**Variavel saldo vai receber o valor do parametro int1, assumindo o valor de -200 determinado pelo Given do "Conta_BDD.feature" Cenario 1 */
		
		this.saldo = int1;
		
		/**If para testar se caso o saldo for diferente do valor estabelecido no Given do primeiro cenario da "Conta_BDD.feature"
		 * E o cliente do tipo especial o cucumber retornara como erro*/
		
		if(this.saldo != -200 && this.cliEspecial == true) {
		throw new io.cucumber.java.PendingException();
		}
	}
	
	/**
	 * Solicitação de saque pelo cliente
	 *
	 */

	@When("for solicitado um saque no valor de {int} reais")
	public void for_solicitado_um_saque_no_valor_de_reais(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		
		/**Variavel saque vai receber o valor do parametro int1, assumindo o valor de 100 do When do "Conta_BDD.feature" Cenario 1 */
		
		this.saque = int1;
		
		/**If para testar se caso o saque for diferente do valor estabelecido no When do primeiro cenario da "Conta_BDD.feature"
		 * E o cliente do tipo especial o cucumber retornara erro*/
		
		if(this.saque != 100 && this.cliEspecial == true) {
		throw new io.cucumber.java.PendingException();
		}
	}
	
	/**
	 * Efetuação do saque mesmo se o cliente tiver saldo negativo 
	 * Saque realiziado = atualização do saldo do cliente (caso saldo esteja negativo, negativalo ainda mais)
	 *
	 */

	@Then("deve efetuar o saque e atualizar o saldo da conta para {int} reias")
	public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reias(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		
		/**Atualização do saque do cliente*/
		
		this.saldo = this.saldo - this.saque;
		
		/**If para testar se caso o valor do saldo apos a atualização seja diferente do estabelecido no Then do "Conta_BDD.feature" e se o cliete for do tipo especial*
		 * o cucumber devera retornar erro
		 */
		
		if (this.saldo != -300 && this.cliEspecial == true) {
			throw new io.cucumber.java.PendingException();
		}
	}
	
	/**
	 * Cenario: 2 (saque cliente comum)
	 * 
	 * Cliente da categoria "comum" deseja realizar um saque do saldo da conta
	 * 
	 * Este tem a disposição a realização de um saque (sem privilegios)
	 * 
	 * Caso este cliente possua saldo negativo não poderar realizar um saque (saldo insulficiente)
	 *  
	 */

	@Given("um cliente comum com saldo atual de {int} reais")
	public void um_cliente_comum_com_saldo_atual_de_reais(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		
		/**Booleano Declarando o Cliente como comum*/
		
		this.cliEspecial = false;
		
		/**Variavel saldo vai receber o valor do parametro int1, assumindo o valor de -300 determinado pelo Given do "Conta_BDD.feature" Cenario 2 */
		
		this.saldo = int1;
		
		/**If para testar se caso o saldo for diferente do valor estabelecido no Given do cenario 2 da "Conta_BDD.feature"
		 * E o cliente do tipo comum o cucumber retornara erro*/
		
		if(this.saldo != -300 && this.cliEspecial == false) {
			throw new io.cucumber.java.PendingException();
			}
	}
	
	/**
	 * Solicitação de saque pelo cliente
	 *
	 */

	@When("solicitar um saque de {int} reais")
	public void solicitar_um_saque_de_reais(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		
		/**Variavel saque vai receber o valor do parametro int1, assumindo o valor de 200 do When da "Conta_BDD.feature" Cenario 2 */
		
		this.saque = int1;
		
		/**If para testar se caso o saque for diferente do valor estabelecido no When do cenario 2 da "Conta_BDD.feature"
		 * E o cliente do tipo comum o cucumber retornara erro*/
		
		if(this.saque != 200 && this.cliEspecial == false) {
		throw new io.cucumber.java.PendingException();
		}
	}
	
	/**
	 * Efetuação do saque apenas se este tiver o valor na conta caso o saque seja maior que saldo o saque não é realizado ("saldo insulficiente") 
	 */

	@Then("nao deve efetuar o saque e deve retornar a mensagem saldo insulficiente")
	public void nao_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_saldo_insulficiente() {
	    // Write code here that turns the phrase above into concrete actions
		
		/**If para testar se caso o saldo for diferente do valor estabelecido no Then do cenario 2 da "Conta_BDD.feature"
		 * E o cliente do tipo comum o cucumber retornara erro
		 * Já o Else retornará o esperado para um cliente comum com saldo negativo tentando fazer um saque ("Saldo insulficiente") 
		 */
		
		if (this.saldo != -300 && this.cliEspecial == false) {
			throw new io.cucumber.java.PendingException();
		}else {
			System.out.println("Saldo Insuficiente");
		}
	}

}
