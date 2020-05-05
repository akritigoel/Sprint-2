package org.com.onlinetest.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.com.onlinetest.dao.StudentDao;
import org.com.onlinetest.dao.TestDao;
import org.com.onlinetest.exception.RecordNotFoundException;
import org.com.onlinetest.model.Question;
import org.com.onlinetest.model.Student;
import org.com.onlinetest.model.Assessment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	private StudentDao stdDao;
	
	

//add student
	public Student addStudent(Student std)
	   {
		  
		   return  stdDao.save(std);
		   
	   }
	 
	 
//Update student	
	 public String updateStudent( BigInteger stdId,  Student stdDetails)
	    		throws RecordNotFoundException  {
	    	Student student = stdDao.findById(stdId).
	    	orElseThrow(() -> new RecordNotFoundException("Student not found for the give id " +stdId));
	             stdDao.save(stdDetails);
	    	return "Student Updated Successfully...";
	    }
	 
//Delete student	  
	 public String deleteStudent(BigInteger stdId) throws RecordNotFoundException
	    {
		 Optional<Student> findById = stdDao.findById(stdId);
			if (findById.isPresent()) {
				stdDao.deleteById(stdId);
				return "deleted";
			} else {
				return "!!   Id Is Invalid   !!";
			}
	    }
//get All student
	 public List<Student> getAllStudent(BigInteger stdId){
	    	
		    System.out.println("All Students are:");
	    	return stdDao.findAll();
	    	
	    }

// get student By Id
	 public ResponseEntity<Student> getStudentById( BigInteger stdId) throws RecordNotFoundException {
	    	Student stdStudent=stdDao.findById(stdId).
	   	 orElseThrow(() -> new RecordNotFoundException("Test not found for the given id" +stdId));
	    	return ResponseEntity.ok().body(stdStudent);
	    }
	 
	 

	 
	//login
	 public BigInteger checkLogin(String loginName,String password) {
		 Optional<BigInteger> findById=stdDao.checkLogin(loginName,password);
		 if(findById.isPresent()) {
			 BigInteger id=findById.get();
			 return id;
		 }
		 else return null;
	 }
	 
    
	 

}
