package com.paolomanlunas.photoappapiusers.ui.controllers;

import com.paolomanlunas.photoappapiusers.service.UserServiceImpl;
import com.paolomanlunas.photoappapiusers.shared.UserDTO;
import com.paolomanlunas.photoappapiusers.ui.model.CreateUserRequestModel;
import com.paolomanlunas.photoappapiusers.ui.model.CreateUserResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

   /**
    * ResponseEntity - allows us to return HttpStatusCode.
    * Http Code is better to indicate success,fail, etc.. for POST req.
    * instead of String of text.
    */
   @PostMapping(
           consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
           produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
   public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel userDetails) {
      ModelMapper modelMapper = new ModelMapper();
      modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

      UserDTO userDTO = modelMapper.map(userDetails, UserDTO.class);
      UserDTO createdUser = userService.createUser(userDTO);            // this will be mapped to the CreateUserResponseModel

      // Response-body is TypeOf-CreateUserResponseModel: which will be the return-object-type
      CreateUserResponseModel returnValue = modelMapper.map(createdUser, CreateUserResponseModel.class);
      // CREATED is Code 201 - means a te Http Request is Successful and a Resource has been Created.
      return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
   }
}
