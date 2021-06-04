package com.java.aplication1.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.java.aplication1.app.model.offices.Employee;
import com.java.aplication1.app.model.offices.HumanResourses;
import com.java.aplication1.app.model.watesrage.DecreaseRate;
import com.java.aplication1.app.model.watesrage.IncreasesRate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.var;

@SpringBootTest
class AppApplicationTests {

	@Test
	void contextLoads() {
		
		// Metodo convencional para valores estaticos
		double n1 = 5;
		double n2 = 6;
		double n3 = 4;
		double n4 = 7;
		double mediaEstatica = (n1+n2+n3+n4)/4;
		System.out.println(mediaEstatica);

		// Metodo convecional para valores de entrada
		Scanner in = new Scanner(System.in);
		double mediaConvencional = 0;
		double contador = 0;
		for(int i = 0; i < 5; i++){
			double n = in.nextDouble();
			mediaConvencional += n;
			contador++;
		}
		System.out.println(mediaConvencional/contador);

		// Metodo que serve para ambos os casos e de forma bela
		List<Double> real = new ArrayList<>();
		real.add(5d);
		real.add(6d);
		real.add(4d);
		real.add(7d);
		double media = real.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
		System.out.println(media);

	}

}
