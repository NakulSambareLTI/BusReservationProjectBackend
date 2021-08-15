package com.example.demo.layer3;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import com.example.demo.layer2.WalletEntity;



/**
 * 
 * @author vasavi
 * This class is used to interact with the database and performs actions related to wallet
 *
 */

@Repository
public class WalletRepoImpl extends BaseRepository implements WalletRepo {

/*	@Transactional
	public Boolean updateBalance(String userMailId, Long amount) throws WalletException {
		Boolean balanceUpdated = Boolean.FALSE;
		try {
			  //"UPDATE Employee e SET e.salary = e.salary + :increment " + "WHERE e.dept = :dept"
		             
			getEntityManager().createQuery("update WalletEntity wallet set wallet.walletAmount = :amount"
					+ " where wallet.registeredEmail= :email")
			.setParameter("amount", amount).setParameter("email", userMailId).executeUpdate();
			balanceUpdated = Boolean.TRUE;
		} catch (Exception e) {
			throw new WalletException("Error while updating the balance in the wallet");
		}
		return balanceUpdated;
	} */
	@Transactional
	public Boolean updateBalance(String userMailId,String pin,Long amount) throws WalletException {
		Boolean balanceUpdated = Boolean.FALSE;
		try {
			  //"UPDATE Employee e SET e.salary = e.salary + :increment " + "WHERE e.dept = :dept"
		             
			getEntityManager().createQuery("update WalletEntity wallet set wallet.walletAmount = :amount"
					+ " where wallet.registeredEmail= :email and wallet.walletPin=: pin")
			.setParameter("amount", amount).setParameter("email", userMailId).setParameter("pin", pin).executeUpdate();
			balanceUpdated = Boolean.TRUE;
		} catch (Exception e) {
			throw new WalletException("Error while updating the balance in the wallet");
		}
		return balanceUpdated;
	}

/*	@Transactional
	public Boolean createWallet(String userMailId, String pin, Long amount ) throws WalletException {
		Boolean walletCreated = Boolean.FALSE;
		try {
			WalletEntity walletEntity = new WalletEntity();
			walletEntity.setRegisteredEmail(userMailId);
			if(null != amount) {
				walletEntity.setWalletAmount(amount);
			} 
			walletEntity.setWalletPin(pin);
			getEntityManager().persist(walletEntity);
			walletCreated = Boolean.TRUE;
		} catch (DuplicateKeyException e) {
                throw new WalletException("Account already exists with this email id");
		} catch (Exception e) {
                throw new WalletException("Error while creating the wallet");
		}
		return walletCreated;
	} */
	

	@Transactional
	public Boolean createWallet(String userMailId, String pin) throws WalletException {
		Boolean walletCreated = Boolean.FALSE;
		try {
			WalletEntity walletEntity = new WalletEntity();
			walletEntity.setRegisteredEmail(userMailId);
			walletEntity.setWalletPin(pin);
			getEntityManager().persist(walletEntity);
			walletCreated = Boolean.TRUE;
		} catch (DuplicateKeyException e) {
                throw new WalletException("Account already exists with this email id");
		} catch (Exception e) {
                throw new WalletException("Error while creating the wallet");
		}
		return walletCreated;
	}

	@Transactional
	public Long getBalance(String userMailId) throws WalletException {
		Long balance = null;
		try {
			Query query = getEntityManager().createQuery("From WalletEntity wallet where wallet.registeredEmail=:email").setParameter("email", userMailId);
			balance = ((WalletEntity)query.getSingleResult()).getWalletAmount();
		} catch (Exception e) {
			throw new WalletException("Error while retriving the wallet Balance");
		}
		return balance;
	}
	
	@Transactional
	public void addMoneyToWallet(String mailID) throws NumberNotFoundException{
			EntityManager entityManager = getEntityManager();
			Query query = entityManager.createQuery("update WalletEntity c set c.walletAmount = (select r.totalAmountPaid from PaymentDetails r where r.registeredEmail = :mail) + c.walletAmount where c.registeredEmail = :mail");
			query.setParameter("mail", mailID);
			query.executeUpdate();
		}

}
