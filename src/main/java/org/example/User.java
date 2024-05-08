package org.example;

import java.util.Scanner;

public class User {
        static User currentUser;
        private String password;
        private static int matricNumber = 10000;
        private String userName;

    public void logout(){
        System.out.println("Enter 'L' to logout + (Enter 'C' to continue exam)");
        Scanner in = new Scanner(System.in);
        String enter = in.nextLine();
        System.out.println(userName + "! Your online quiz has ended. Thank you! ");
    }
    public void selectOption() {
        char option = '\0';
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\t\t1. Login\n");
        System.out.println("\t\t\t2. Register account\n");
        System.out.print("\t\t\tChoice: ");
        int choice = sc.nextInt();

        System.out.println("Enter username: ");
        this.userName = sc.next();

        System.out.println("Enter password: ");
        this.password = sc.next();

        System.out.println("---------------- Welcome to your online Examination portal ---------------------------");

        setMatricNumber();
        System.out.println("******************************************************************************");
        System.out.println("Hello " + userName + "     Matriculation Number: " + matricNumber);
        System.out.println("-------------------------************************************----------------------------------");

    }

        public User() {
            this.matricNumber = matricNumber;
            this.userName = getUserName();

        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

    public static int getMatricNumber() {
        return matricNumber;
    }

    public void setMatricNumber() {
       matricNumber++;
    }

            @Override
        public String toString() {
            return "User{" +
                    "userName='" + userName + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
}
