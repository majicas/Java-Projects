package emailapp;

import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String alternateEmail;
    private String email;
    private String companyEmailDomain = "xyz.com";
    private int mailBoxCapacity = 500;
    private int defaultPasswordLenght = 8;



//  constructor
    public Email(String firstname, String lastname){
        this.firstName = firstname;
        this.lastName = lastname;
//        System.out.println("Email Created: " + this.firstName + " " + this.lastName);

        this.department = setDepartment();
//        System.out.println("Department: " + this.department);

        this.password = passwordGenerator(defaultPasswordLenght);
        System.out.println("Your password is: " + this.password);

        email = firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + department + "." + companyEmailDomain;
//        System.out.println("Your email is: " + email);
    }

    private String setDepartment()
    {
        System.out.print("Enter the Department\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter Department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        switch (depChoice)
        {
            case 1: department = "Sales";
            break;
            case 2: department = "Dev";
            break;
            case 3: department = "Accounting";
            break;
            default: department = "None";
        }

        return department;
    }

    public String passwordGenerator(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ123456789#!@$%";
        char[] password = new char[length];
        for(int i = 0; i < length; i++)
        {
            int rand = (int)(Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
            return new String(password);
    }

    public void setMailBoxCapacity(int capacity){
        this.mailBoxCapacity = capacity;
    }

    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    public void changePassword(String password){
        this.password = password;
    }

    public int getMailBoxCapacity(){
        return mailBoxCapacity;
    }

    public String getAlternateEmail(){
        return alternateEmail;
    }

    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "Display Name: " + firstName + " " + lastName + "\nCompany Email: " + email + "\nMailbox Capacity: " + mailBoxCapacity + "gb";
    }



}
