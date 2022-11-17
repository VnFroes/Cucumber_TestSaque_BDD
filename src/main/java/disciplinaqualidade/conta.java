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
	
	@Given("um cliente especial com saldo atual de {int} reais")
	public void um_cliente_especial_com_saldo_atual_de_reais(Integer contaExtrato) {
	    // Write code here that turns the phrase above into concrete actions
		 throw new io.cucumber.java.PendingException();
	}
	
	/**
	 * Solicitação de saque pelo cliente especial
	 *
	 */

	@When("for solicitado um saque no valor de {int} reais")
	public void for_solicitado_um_saque_no_valor_de_reais(Integer saque) {
	    // Write code here that turns the phrase above into concrete actions
		 throw new io.cucumber.java.PendingException();
	}
	
	/**
	 * Efetuação do saque mesmo se o cliente especial tiver saldo negativo 
	 * Saque realiziado = atualização do saldo do cliente (caso saldo esteja negativo, negativalo ainda mais)
	 */

	@Then("deve efetuar o saque e atualizar o saldo da conta para {int} reias")
	public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reias(Integer saldo) {
	    // Write code here that turns the phrase above into concrete actions
         throw new io.cucumber.java.PendingException();
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
          throw new io.cucumber.java.PendingException();
	}
	
	/**
	 * Solicitação de saque pelo cliente comum
	 *
	 */

	@When("solicitar um saque de {int} reais")
	public void solicitar_um_saque_de_reais(Integer saque) {
	    // Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
	
	/**
	 * Efetuação do saque apenas se este tiver o valor na conta, caso o saque seja maior que saldo, o saque não é realizado ("saldo insulficiente") 
	 */

	@Then("nao deve efetuar o saque e deve retornar a mensagem saldo insulficiente")
	public void nao_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_saldo_insulficiente() {
	    // Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
