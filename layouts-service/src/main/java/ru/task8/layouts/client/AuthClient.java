package ru.task8.layouts.client;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "auth-service", url = "${auth-service.url:}")
public interface AuthClient {
    @GetMapping("/api/auth/whoami")
    Map<String, String> whoami(@RequestHeader("Authorization") String authHeader);
}
