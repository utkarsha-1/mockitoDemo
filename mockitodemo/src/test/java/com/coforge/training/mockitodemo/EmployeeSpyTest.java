package com.coforge.training.mockitodemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

/*@Spy is used to create a spy instance.
 *  We can use it instead spy(Object) method.
 *  Mockito provides option to create spy on real objects. When spy is called, 
 *  then actual method of real object is called.
*/
@RunWith(MockitoJUnitRunner.class)
public class EmployeeSpyTest {
	private Employee spyEmp;
	private Employee emp;
	
	private static final String FIRST_NAME = "Joe";
	private static final String LAST_NAME = "Gosling";
	private static final int AGE = 35;
	
	@Before
	public void setup() {
	MockitoAnnotations.initMocks(this);
	emp = new Employee(FIRST_NAME, LAST_NAME, AGE);
	spyEmp = spy(emp);
	}
	
	/*@Before
	public void buildSpy() {
	emp = new Employee(FIRST_NAME, LAST_NAME, AGE);
	spyEmp = spy(emp); //created a spy object of employee using static method spy()
	}*/
	@Test
	public void verifySpyEffectOnRealInstance() {
	spyEmp.setAge(35);
	assertTrue(emp.getAge() == spyEmp.getAge());
	}
	
	//first Name Test
	@Test
	@DisplayName("My own Test")
	public void verifySpyEffectOnRealInstance1() {
	spyEmp.setFirstName("Joe");
	assertTrue(emp.getFirstName() == spyEmp.getFirstName());
	}
	
	//Second Name Test
	@Test
	@DisplayName("My second own Test")
	public void verifySpyEffectOnRealInstance2() {
	spyEmp.setLastName("Gosling");
	assertTrue(emp.getLastName() == spyEmp.getLastName());
	}
	
	@Test
	public void fullname()
	{
	String fName=spyEmp.getFullName();
	System.out.println("Full Name: "+fName);
	assertEquals(FIRST_NAME + " "+LAST_NAME, spyEmp.getFullName());
	}

}
