package com.example.switchyard.switchyard_example1;

import org.switchyard.component.bean.Service;

@Service(HelloWorldService.class)
public class HelloWorldServiceBean implements HelloWorldService {

	@Override
	public String diceHola(String nombre) {
		return "Hola " + nombre + "!";
	}

}
