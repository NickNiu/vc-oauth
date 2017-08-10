package com.vcg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;

@SpringBootApplication
@EnableRedisHttpSession
@EnableTransactionManagement
@EnableWebSecurity
@EnableAuthorizationServer
@EnableGlobalMethodSecurity(securedEnabled = true)
public class OAuthServerApplication {

    public static void main(String[] args) throws IOException {
        //pid
        String name = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
        FileWriter writer = new FileWriter(new File("OAuthServerApplication.pid"));
        writer.write(name);
        writer.close();
        SpringApplication.run(OAuthServerApplication.class, args);
    }

}
