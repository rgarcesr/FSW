package com.example.switchyard.switchyard_soap_demo;

import java.util.List;

public interface PersonLocator {
	List<Person> findByLastName (String lastName);
}
