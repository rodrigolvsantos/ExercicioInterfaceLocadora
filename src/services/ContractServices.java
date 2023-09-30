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
		
		contract.getInstatllment().add(new Instatllment(LocalDate.of(2018, 7, 25),206.04));
		contract.getInstatllment().add(new Instatllment(LocalDate.of(2018, 7, 25),208.08));
	}

}
