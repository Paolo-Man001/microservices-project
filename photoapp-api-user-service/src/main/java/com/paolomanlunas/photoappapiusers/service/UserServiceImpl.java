package com.paolomanlunas.photoappapiusers.service;

import com.paolomanlunas.photoappapiusers.shared.UserDTO;

import java.util.UUID;

public class UserServiceImpl implements UserService {
   @Override
   public UserDTO createUser(UserDTO userDetails) {

      // set a Unique UUID
      userDetails.setUserId(UUID.randomUUID().toString());

      return null;
   }
}
