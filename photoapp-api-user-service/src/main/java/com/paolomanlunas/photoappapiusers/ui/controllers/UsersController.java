package com.paolomanlunas.photoappapiusers.ui.controllers;

import com.paolomanlunas.photoappapiusers.service.UserServiceImpl;
import com.paolomanlunas.photoappapiusers.shared.UserDTO;
import com.paolomanlunas.photoappapiusers.ui.model.CreateUserRequestModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController {

   // Get access to Environment variable:
   private final Environment env;

   private final UserServiceImpl userService;

   @Autowired
   public UsersController(Environment env, UserServiceImpl userService) {
      this.env = env;
      this.userService = userService;
   }

   @GetMapping("/status/check")
   public String status() {
      return "Users API Service is Working on PORT: " + env.getProperty("local.server.port");
   }

   @PostMapping()
   public String createUser(@Valid @RequestBody CreateUserRequestModel userDetails) {

      ModelMapper modelMapper = new ModelMapper();
      modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

      UserDTO userDTO = modelMapper.map(userDetails, UserDTO.class);
      userService.createUser(userDTO);

      return "Create user method is called.";
   }
}
