package com.tpk.JooqAccessLayer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestJooqAccessLayerApplication {

	public static void main(String[] args) {
		SpringApplication.from(JooqAccessLayerApplication::main).with(TestJooqAccessLayerApplication.class).run(args);
	}

}
