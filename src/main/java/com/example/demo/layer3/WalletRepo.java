package com.example.demo.layer3;

public interface WalletRepo {
	//public Boolean updateBalance(String userMailId, Long amount) throws WalletException;
	//public Boolean createWallet(String userMailId,String pin,Long amount) throws WalletException;
	
	/**
	 * 
	 * @param userMailId : This is the mailId of the registered user to confirm the user 
	 * @param pin : This used to confirm the walletPin
	 * @param amount: This is the amount that the user wants to add or deduct
	 * @return checks whether the userMailId and pin matches with the registeredMailId and walletPin in the database and updates the balance and returns true or false
	 * @throws WalletException : If the userMailId and pin doesn't match with the registeredMailId and walletPin it throws the exception 
	 */
	public Boolean updateBalance(String userMailId,String pin ,Long amount) throws WalletException;
	
	/**
	 * 
	 * @param userMailId: This is the mailId of the user who wants to create a wallet
	 * @param pin: This is the pin for the wallet
	 * @return : returns true if wallet is created successfully or false if not 
	 * @throws WalletException : If the userMailId already exists it throws the exception
	 */
	public Boolean createWallet(String userMailId,String pin) throws WalletException;
	
	/**
	 * 
	 * @param userMailId : This is used to verify the user
	 * @return : returns the Total amount present in the wallet
	 * @throws WalletException : if the userMailId doesn't match with the registeredmailId it throws the exception
	 */
    public Long getBalance(String userMailId) throws WalletException;
    
    void deleteMoneyToWallet(String mailID) throws NumberNotFoundException;
    
    public void deleteMoneyFromWallet(String mailID) throws NumberNotFoundException;

}
