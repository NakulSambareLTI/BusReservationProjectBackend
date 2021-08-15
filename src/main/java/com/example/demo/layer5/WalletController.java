package com.example.demo.layer5;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.EmailUtility.EmailUtility;
import com.example.demo.layer2.WalletEntity;
import com.example.demo.layer3.WalletException;
import com.example.demo.layer4.WalletService;





@CrossOrigin(origins="*")
@RestController
@RequestMapping("/CustomerWallet")

public class WalletController {

	@Autowired
	WalletService walletService;
	
	@Autowired
	EmailUtility emailUtility;
	

	
	@PostMapping(path="/createWallet")
	public Boolean createWallet(@RequestBody WalletEntity wallet)
			throws WalletException {
		//System.out.println();
		System.out.println("wallet created"+wallet.getRegisteredEmail()+"    "+ wallet.getWalletPin());
		return walletService.createWallet(wallet.getRegisteredEmail(), wallet.getWalletPin());
	} 
	
	@PostMapping
	@ResponseBody
	@RequestMapping(path = "/addBalance")
	public Boolean addBalance(@RequestBody WalletEntity wallet) throws WalletException {
		System.out.println("AmountAdded successfully:  "+wallet.getRegisteredEmail()+"  "+ wallet.getWalletPin()+"    "+wallet.getWalletAmount());
		return walletService.addBalance(wallet.getRegisteredEmail(), wallet.getWalletPin(),wallet.getWalletAmount());
	}

	@GetMapping
	@ResponseBody
	@RequestMapping(value = "/getBalance/{userMailId}")
	public Long getBalance(@PathVariable String userMailId) throws WalletException {
		return walletService.getBalance(userMailId);
	}

	@PostMapping
	@ResponseBody
	@RequestMapping(value = "/processWalletPayment/{userMailId}/{pin}/{amount}")
	public Boolean processWalletPayment(@PathVariable String userMailId,@PathVariable String pin ,@PathVariable Long amount)
			throws WalletException {
		return walletService.processWalletPayment(userMailId,pin,amount);
	}
	
	@PostMapping
	@ResponseBody
	@RequestMapping(value = "/sendNotification/{userMailId}/{subject}/{body}")
	public Boolean sendNotification(@PathVariable String userMailId, @PathVariable String subject,
			@PathVariable String body)
			throws WalletException {
		return emailUtility.sendEmail(userMailId, subject, body);
	}
	
	
	
	
	
}
