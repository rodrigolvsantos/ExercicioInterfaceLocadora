package services;

import java.time.LocalDate;

import entities.Contract;
import entities.Instatllment;

public class ContractServices {

	private OnlineServicePayment onlinePayment;

	public ContractServices(OnlineServicePayment onlinePayment) {
		this.onlinePayment = onlinePayment;
	}

	public void processContract(Contract contract, int months) {
		
	double basicQuota = contract.getTotalValue()/months;	
	
	for (int i = 1; i<= months; i++ ) {
		/*Função para adicionar data mes a mes, ou dia a dia, etc*/
		LocalDate dueDate = contract.getDate().plusMonths(1);
		
		double interest = onlinePayment.interest(basicQuota, i);
		double fee = onlinePayment.paymentFee(basicQuota + interest);			
				
		double quota = basicQuota  + interest + fee;
		
		contract.getInstatllment().add(new Instatllment(dueDate,quota));
		
	}

}

}