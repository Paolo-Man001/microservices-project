package com.paolomanlunas.photoappapiuserservice.users.ui.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel {
   @NotNull(message = "First Name cannot be empty.")
   @Size(min = 2, message = "First Name must be at least 2 characters.")
   private String firstName;

   @NotNull(message = "Last Name cannot be empty.")
   @Size(min = 2, message = "First Name must be at least 2 characters.")
   private String lastName;

   @NotNull(message = "Password cannot be empty.")
   @Size(min = 8, max = 16, message = "Password must be at least 8, but not more than 16 characters.") // number-Constraint for password characters
   private String password;

   @NotNull(message = "Email cannot be empty.")
   @Email
   private String email;

   // GET-SET
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

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }
}
