package com.example.demo.layer4;

import com.example.demo.layer3.WalletException;

public interface WalletService {
	//public Boolean addBalance(String userMailId, Long amount) throws WalletException;
  //  public Boolean processWalletPayment(String userMailId, Long amount) throws WalletException;
	//public Boolean createWallet(String userMailId,String pin,Long amount) throws WalletException;
	
	public Boolean addBalance(String userMailId,String pin,Long amount) throws WalletException;
	
    public Boolean processWalletPayment(String userMailId,String pin,Long amount) throws WalletException;

	public Boolean createWallet(String userMailId,String pin) throws WalletException;

	public Long getBalance(String userMailId) throws WalletException;
}
