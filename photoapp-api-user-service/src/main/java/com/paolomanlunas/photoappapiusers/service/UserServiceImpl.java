package com.paolomanlunas.photoappapiusers.service;

import com.paolomanlunas.photoappapiusers.data.UserEntity;
import com.paolomanlunas.photoappapiusers.data.UsersRepository;
import com.paolomanlunas.photoappapiusers.shared.UserDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

   UsersRepository usersRepository;

   @Autowired
   public UserServiceImpl(UsersRepository usersRepository) {
      this.usersRepository = usersRepository;
   }

   @Override
   public UserDTO createUser(UserDTO userDetails) {

      // set a Unique UUID
      userDetails.setUserId(UUID.randomUUID().toString());
      // ModelMapper to map data to ModelDTO then copy to ModelEntity
      ModelMapper modelMapper = new ModelMapper();
      modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);   // ModelMapper MUST match the properties/fields in the destination-object(UserEntity)

      UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);          // map Data then copy into UserEntity-variable
      /* TEMPORARY PASSWORD:
      *     Encrypted Password is Temporary
      * */
      userEntity.setEncryptedPassword("test");

      usersRepository.save(userEntity);   // save() method will take the Entity to persist into DB

      return null;
   }
}
