package com.tpk.JooqAccessLayer;

import com.tpk.JooqAccessLayer.service.JooqService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MSSQLServerContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
class JooqAccessLayerApplicationTests {

	@Autowired
	private JooqService jooqService;

	@Container
	private static final MSSQLServerContainer<?> SQLSERVER_CONTAINER = new MSSQLServerContainer<>(
			"mcr.microsoft.com/mssql/server:2022-latest")
			.withInitScript("init.sql").acceptLicense();

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
		dynamicPropertyRegistry.add("spring.datasource.url", SQLSERVER_CONTAINER::getJdbcUrl);
		dynamicPropertyRegistry.add("spring.datasource.username", SQLSERVER_CONTAINER::getUsername);
		dynamicPropertyRegistry.add("spring.datasource.password", SQLSERVER_CONTAINER::getPassword);
	}

	static {
		SQLSERVER_CONTAINER.start();
	}

	@Test
	void findUsersAllNotNull() {
		var result = jooqService.findAll();
		Assertions.assertNotNull(result);
	}

	@Test
	void findByUsernameNotNull() {
		String search = "user";
		var result = jooqService.findByUsername(search);
		Assertions.assertNotNull(result);
	}

	@Test
	void findByUsernameSQLNotNull() {
		String search = "user";
		var result = jooqService.findByUsernameSQL(search);
		Assertions.assertNotNull(result);
	}

	@AfterAll
    static void stopContainer(){
		SQLSERVER_CONTAINER.stop();
	}

}
