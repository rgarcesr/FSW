package com.example.switchyard.switchyard_example1;

import java.io.IOException;

import javax.xml.namespace.QName;

import org.switchyard.remote.RemoteInvoker;
import org.switchyard.remote.RemoteMessage;
import org.switchyard.remote.http.HttpInvoker;

public class RemoteClienteDemo {
	
	private static final QName SERVICE = new QName("urn:com.example.switchyard:switchyard-example1:1.0", "HelloWorldService");
	private static final String URL = "http://localhost:8080/switchyard-remote";

	public static void main(String[] args) throws IOException {
		RemoteInvoker invoker = new HttpInvoker(URL);
		RemoteMessage message = new RemoteMessage();
		message.setService(SERVICE).setOperation("diceHola").setContent("Mi mensaje");
		
		RemoteMessage reply = invoker.invoke(message);
		
		if (reply.isFault() ) {
			System.err.println("Ops... error" + reply.getContent());
		} else {
			String contenido = (String) reply.getContent();
			System.out.println("Respuesta[" + contenido + "]");
		}

	}

}
