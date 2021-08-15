package com.example.demo.layer4;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer3.WalletException;
import com.example.demo.layer3.WalletRepo;


/**
 * 
 * @author vasavi
 * This class contains the actual business logic
 *
 */

@Service
public class WalletServiceImpl implements WalletService {
	
	@Autowired
	WalletRepo walletRepo;

	/*public Boolean addBalance(String userMailId, Long amount) throws WalletException {
		Boolean balanceAdded = Boolean.FALSE;
		Long balance;
		try {
			balance = walletRepo.getBalance(userMailId);
			walletRepo.updateBalance(userMailId, balance+amount);
			balanceAdded=Boolean.TRUE;
		} catch (Exception e) {
			throw new WalletException("Error while adding the money to wallet");
		}
		
		return balanceAdded;
	} */
	
	public Boolean addBalance(String userMailId,String pin,Long amount) throws WalletException {
		Boolean balanceAdded = Boolean.FALSE;
		Long balance;
		try {
			balance = walletRepo.getBalance(userMailId);
			walletRepo.updateBalance(userMailId,pin,balance+amount);
			balanceAdded=Boolean.TRUE;
		} catch (Exception e) {
			throw new WalletException("Error while adding the money to wallet");
		}
		
		return balanceAdded;
	} 

	public Boolean processWalletPayment(String userMailId,String pin,Long amount) throws WalletException {
		Boolean paymentSuccessful = Boolean.FALSE;
		Long balance;
		try {
			balance = walletRepo.getBalance(userMailId);
			if(balance>=amount) {
				walletRepo.updateBalance(userMailId,pin,balance-amount);
				paymentSuccessful = Boolean.TRUE;
			} else {
				throw new WalletException("Insufficient funds in the wallet");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return paymentSuccessful;
	}

/*	public Boolean createWallet(String userMailId, String pin, Long amount) throws WalletException {
		return walletRepo.createWallet(userMailId, pin, amount);
	} */
	
	public Boolean createWallet(String userMailId, String pin) throws WalletException {
		System.out.println("Create wallet ");
		return walletRepo.createWallet(userMailId, pin);
	}

	public Long getBalance(String userMailId) throws WalletException {
		return walletRepo.getBalance(userMailId);
	}

}
