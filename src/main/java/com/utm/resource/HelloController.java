package com.utm.resource;

import com.utm.dto.ClientDTO;
import com.utm.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private ClientServiceImpl clientService;

    @GetMapping("/test")
    public String test() {
        return "test text";
    }

    @GetMapping("/some_client")
    public ClientDTO someClient() throws Exception {
        throw new Exception("шось там");
    }
}
