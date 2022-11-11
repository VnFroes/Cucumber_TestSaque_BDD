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
	*Variaveis inteiros para armazenar Saque e Saldo e extrato da conta
	*/
	int saque;
	int saldo;
	int contaExtrato;
	/**
	 * Booleano (para saber se o cliente é comum ou especial) 
	 */
	boolean cliEspecial = true;
	
	/**If para determianr o tipo de cliente para os cenarios 1 e 2 */
	
	public void tipoCliente() {

		if (this.cliEspecial == true) {
			um_cliente_especial_com_saldo_atual_de_reais(contaExtrato);
			for_solicitado_um_saque_no_valor_de_reais(saque);
			deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reias(saldo);
		} 
		
		else {
			um_cliente_comum_com_saldo_atual_de_reais(contaExtrato);
			solicitar_um_saque_de_reais(saque);
			nao_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_saldo_insulficiente();
		}
	}
	
	@Given("um cliente especial com saldo atual de {int} reais")
	public void um_cliente_especial_com_saldo_atual_de_reais(Integer contaExtrato) {
	    // Write code here that turns the phrase above into concrete actions
		
		/**Variavel saldo vai receber o valor do parametro "contaExtrato", assumindo o valor determinado pelo Given do "Conta_BDD.feature" Cenario 1 */
		
		this.saldo = contaExtrato;
		
		/**If para testar se caso o valor do saldo seja o valor estabelecido no Given do primeiro cenario da "Conta_BDD.feature"
		 * E o cliente do tipo especia. Senão o cucumber retornara como erro*/
		
		if(this.cliEspecial == true && contaExtrato instanceof Integer) {
		}else {throw new io.cucumber.java.PendingException();}
	}
	
	/**
	 * Solicitação de saque pelo cliente
	 *
	 */

	@When("for solicitado um saque no valor de {int} reais")
	public void for_solicitado_um_saque_no_valor_de_reais(Integer saque) {
	    // Write code here that turns the phrase above into concrete actions
		
		/**Variavel saque vai receber o valor do parametro "saque", assumindo o valor estabelecido no "Conta_BDD.feature" Cenario 1 */
		
		this.saque =saque;
		
		/**If para testar se caso o valor do saque seja o valor estabelecido no primeiro cenario da "Conta_BDD.feature"
		 * E o cliente do tipo especial. Senão o cucumber retornara erro*/
		
		if (saque instanceof Integer && this.cliEspecial == true) {
		} else {throw new io.cucumber.java.PendingException();}
	}
	
	/**
	 * Efetuação do saque mesmo se o cliente especial tiver saldo negativo 
	 * Saque realiziado = atualização do saldo do cliente (caso saldo esteja negativo, negativalo ainda mais)
	 *
	 */

	@Then("deve efetuar o saque e atualizar o saldo da conta para {int} reias")
	public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reias(Integer saldo) {
	    // Write code here that turns the phrase above into concrete actions
		
		/**If para testar se caso o valor do saldo seja o valor estabelecido no "Conta_BDD.feature" 
		 * e se o cliete for do tipo especial. Realizar a atualização do extrato do cliente especial*
		 * Senão o cucumber devera retornar erro
		 */
		
		if (saldo instanceof Integer && this.cliEspecial == true) {
			saldo = this.contaExtrato - (this.saque);
		} else {throw new io.cucumber.java.PendingException();}
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
	public void um_cliente_comum_com_saldo_atual_de_reais(Integer contaExtrato) {
	    // Write code here that turns the phrase above into concrete actions

		/**Variavel saldo vai receber o valor do parametro "contaExtrato", assumindo o valor determinado no "Conta_BDD.feature" Cenario 2 */
		
		this.saldo = contaExtrato;
		
		/**If para testar se caso o saldo seja o valor estabelecido no segundo cenario da "Conta_BDD.feature"
		 * E o cliente do tipo comum. Senão o cucumber retornara como erro*/
		
		if(this.cliEspecial == false && contaExtrato instanceof Integer) {
		}else {throw new io.cucumber.java.PendingException();}
	}
	
	/**
	 * Solicitação de saque pelo cliente
	 *
	 */

	@When("solicitar um saque de {int} reais")
	public void solicitar_um_saque_de_reais(Integer saque) {
	    // Write code here that turns the phrase above into concrete actions
		
		/**Variavel saque vai receber o valor do parametro "saque", assumindo o valor estabelecido no cenario 2 no "Conta_BDD.feature"*/
		
		this.saque = saque;
		
		/**If para testar se caso o valor do saque seja o valor estabelecido no segundo cenario da "Conta_BDD.feature"
		 *Senão o cucumber retornara como erro*/
		
		if (saque instanceof Integer) {
		} else {throw new io.cucumber.java.PendingException();}
	}
	
	/**
	 * Efetuação do saque apenas se este tiver o valor na conta, caso o saque seja maior que saldo o saque não é realizado ("saldo insulficiente") 
	 */

	@Then("nao deve efetuar o saque e deve retornar a mensagem saldo insulficiente")
	public void nao_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_saldo_insulficiente() {
	    // Write code here that turns the phrase above into concrete actions
		
		/**If para testar se caso o valor saque for menor do valor do extrato e se o estrato é maior que 0 e o cliente do tipo comum.
		 * Já o Else if retornará o esperado para um cliente comum com um saque maior que o extrato ("Saldo insulficiente")
		 * e o else, o cucumber retornara erro 
		 */
		
		if (this.cliEspecial == false && this.saque < this.contaExtrato && this.contaExtrato > 0) {

		} else if (this.saque > this.contaExtrato) {
			System.out.print("Saldo insuficiente");
		} else
			throw new io.cucumber.java.PendingException();
	}

}
