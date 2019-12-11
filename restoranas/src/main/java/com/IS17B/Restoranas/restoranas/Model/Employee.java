package com.IS17B.Restoranas.restoranas.Model;

    public class Employee {
        private Integer id;
        private String firstName;
        private String lastName;
        private String email;
        private Integer phoneNumber;
        private Double salary;

        public Employee(){

        }

        public Employee(Integer id, String firstName, String lastName, String email,
                        Integer phoneNumber, Double salary) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.salary = salary;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
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

        public Integer getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(Integer phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }
        @Override
        public String toString(){
            return "ID: "+ id + " FirstName: " + firstName + " LastName: " + lastName +
                    " Email: " + email + "Phone Number: " + phoneNumber + " Salary: " + salary;
        }

    }
