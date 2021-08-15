package com.example.demo.layer3;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.AdminProfile;

@Repository
public class AdminRepositoryImplementation extends BaseRepository implements AdminRepository {

	@Transactional
	public boolean checkAdminForLogin(String email, String password) {
		// TODO Auto-generated method stub
		boolean res=false;
		EntityManager entityManager = getEntityManager();
		AdminProfile ap=entityManager.find(AdminProfile.class, email);
		if ( ap!=null && ap.getAdminPassword().equals(password)) {
			res=true;
			
		}
		return res;
		

	}

}
