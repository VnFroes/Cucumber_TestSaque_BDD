package disciplinaqualidade;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class conta {
	/**
	 * Cenario: 1 (saque cliente especial)
	 * 
	 * Cliente da categoria "especial" deseja realizar um saque do saldo da conta
	 * 
	 * Este tem a disposição a realização de um saque (com previlegios)
	 * 
	 * Mesmo se o cliente possuir saldo negativo este ainda pode sacar dinheiro
	 * 
	 *  @param db 1 e 4 = saldo / db 2 e 5 = saque / db 3 = saldo - saque (o que resta na conta) /  
	 */
	
	/**
	*Variaveis inteiros / Booleano (para saber se o cliente é comum ou especial) 
	*/
	double saque;
	double saldo;
	boolean cliComum = false;
	boolean cliEspecial = false;
	
	@Given("um cliente especial com saldo atual de {double} reais")
	public void um_cliente_especial_com_saldo_atual_de_reais(double db1) {
	    // Write code here that turns the phrase above into concrete actions
		this.cliEspecial = true;
		this.saldo = db1;
		if(this.saldo != -200 && !this.cliEspecial)
		throw new io.cucumber.java.PendingException();
	}
	
	/**
	 * Solicitação de saque pelo cliente
	 *
	 */

	@When("for solicitado um saque no valor de {double} reais")
	public void for_solicitado_um_saque_no_valor_de_reais(double db2) {
	    // Write code here that turns the phrase above into concrete actions
		this.saque = db2;
		if(this.saque != 100 && !this.cliEspecial)
		throw new io.cucumber.java.PendingException();
	}
	
	/**
	 * Efetuação do saque mesmo se o cliente tiver saldo negativo 
	 * Saque realiziado = atualização do saldo do cliente (caso saldo esteja negativo, negativalo ainda mais)
	 *
	 */

	@Then("deve efetuar o saque e atualizar o saldo da conta para {double} reias")
	public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reias(double db3) {
	    // Write code here that turns the phrase above into concrete actions
		if(this.saldo - this.saque != db3 && !this.cliEspecial)
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

	@Given("um cliente comum com saldo atual de {double} reais")
	public void um_cliente_comum_com_saldo_atual_de_reais(double db4) {
	    // Write code here that turns the phrase above into concrete actions
		this.cliComum = true;
		this.saldo = db4;
		if(this.saldo != -300 && !this.cliComum)
		throw new io.cucumber.java.PendingException();
	}
	
	/**
	 * Solicitação de saque pelo cliente
	 *
	 */

	@When("solicitar um saque de {double} reais")
	public void solicitar_um_saque_de_reais(double db5) {
	    // Write code here that turns the phrase above into concrete actions
		this.saque = db5;
		if(this.saque != 200 && !this.cliComum)
		throw new io.cucumber.java.PendingException();
	}
	
	/**
	 * Efetuação do saque apenas se este tiver o valor na conta caso o saque seja maior que saldo o saque não é realizado ("saldo insulficiente") 
	 * Saque realiziado = atualização do saldo do cliente
	 * 
	 */

	@Then("nao deve efetuar o saque e deve retornar a mensagem saldo insulficiente")
	public void nao_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_saldo_insulficiente() {
	    // Write code here that turns the phrase above into concrete actions
		if(!this.cliComum) {
			throw new io.cucumber.java.PendingException();			
		} else {
			System.out.println("Saldo Insuficiente");
		}
	}

}
