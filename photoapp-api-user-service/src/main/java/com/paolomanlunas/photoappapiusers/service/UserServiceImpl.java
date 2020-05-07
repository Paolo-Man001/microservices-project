package com.paolomanlunas.photoappapiusers.service;

import com.paolomanlunas.photoappapiusers.data.UserEntity;
import com.paolomanlunas.photoappapiusers.shared.UserDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;

import java.util.UUID;

public class UserServiceImpl implements UserService {
   @Override
   public UserDTO createUser(UserDTO userDetails) {

      // set a Unique UUID
      userDetails.setUserId(UUID.randomUUID().toString());

      // ModelMapper to map data to ModelDTO then copy to ModelEntity
      ModelMapper modelMapper = new ModelMapper();
      modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);   // ModelMapper MUST match the properties/fields in the destination-object(UserEntity)
      UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);          // save into variable-typeof-UserEntity

      return null;
   }
}
