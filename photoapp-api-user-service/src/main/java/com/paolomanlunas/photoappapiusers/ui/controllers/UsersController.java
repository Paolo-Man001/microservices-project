package com.paolomanlunas.photoappapiusers.ui.controllers;

import com.paolomanlunas.photoappapiusers.ui.model.CreateUserRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController {

   // Get access to Environment variable:
   private final Environment env;

   @Autowired
   public UsersController(Environment env) {
      this.env = env;
   }

   @GetMapping("/status/check")
   public String status() {
      return "Users API Service is Working on PORT: " + env.getProperty("local.server.port");
   }

   @PostMapping()
   public String createUser(@Valid @RequestBody CreateUserRequestModel userDetails) {
      return "Create user method is called.";
   }
}
