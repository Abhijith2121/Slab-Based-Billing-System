package com.electricity.bill.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class CustomerDto {
	
	    private Long id;
	    
	    @NotBlank(message="First name is required")
	    private String firstName;
	    
	    @NotBlank(message="Last name is required")
	    private String lastName;
	    
	    @NotBlank(message="Email is required")
	    private String email;
	    
	    
		public CustomerDto(Long id, String firstName, String lastName, String email) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
		}
		
		
		public CustomerDto() {
			super();
			
		}


		public Long getId() {
			return id;
		}
		public void setId(Long id) {
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
	    
	    
	    
	    
}
