package com.saludespe.servicio.trabajosocial;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {"eureka.client.enabled=false"})
class SaludespeServicioTrabajosocialApplicationTests {

    @Test
    void contextLoads() {
    }

}
