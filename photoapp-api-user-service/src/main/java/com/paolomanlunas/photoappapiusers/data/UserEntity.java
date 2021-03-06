package com.paolomanlunas.photoappapiusers.data;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "users")  // 'users' indicates error since we are not using datasource - only h2 (for now)
public class UserEntity implements Serializable {
   private static final long serialVersionUID = -8056457250635842509L;

   @Id
   @GeneratedValue
   private long id;           // Database Id

   @Column(nullable = false, length = 50)
   private String firstName;

   @Column(nullable = false, length = 50)
   private String lastName;

   @Column(nullable = false, length = 150, unique = true)
   private String email;

//   private String password;   // We DO NOT want to store passwords in DB's

   @Column(nullable = false, unique = true)
   private String userId;

   @Column(nullable = false, unique = true)
   private String encryptedPassword;

   /* GETTERS - SETTERS */
   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getUserId() {
      return userId;
   }

   public void setUserId(String userId) {
      this.userId = userId;
   }

   public String getEncryptedPassword() {
      return encryptedPassword;
   }

   public void setEncryptedPassword(String encryptedPassword) {
      this.encryptedPassword = encryptedPassword;
   }
}
