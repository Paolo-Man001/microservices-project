package com.paolomanlunas.photoappapiusers.service;

import com.paolomanlunas.photoappapiusers.data.UserEntity;
import com.paolomanlunas.photoappapiusers.data.UsersRepository;
import com.paolomanlunas.photoappapiusers.shared.UserDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

   UsersRepository usersRepository;
   BCryptPasswordEncoder bCryptPasswordEncoder;

   @Autowired
   public UserServiceImpl(UsersRepository usersRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
      this.usersRepository = usersRepository;
      this.bCryptPasswordEncoder = bCryptPasswordEncoder;
   }

   @Override
   public UserDTO createUser(UserDTO userDetails) {

      userDetails.setUserId(UUID.randomUUID().toString());     // set a Unique UUID
      userDetails.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));

      ModelMapper modelMapper = new ModelMapper();    // ModelMapper to map data to ModelDTO then copy to ModelEntity
      modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);   // ModelMapper MUST match the properties/fields in the destination-object(UserEntity)

      UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);          // map Data then copy into UserEntity-variable

      usersRepository.save(userEntity);   // save() method will take the Entity to persist into DB

      UserDTO returnValue = modelMapper.map(userEntity, UserDTO.class);

      return returnValue;
   }
}
