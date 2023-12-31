/*package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public BankAccount(String name,double balance) {
        this.name = name;
        this.balance = balance;
    }

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;

    }


    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if(sum>digits*9){
            throw new Excecption("Account Number can not be generated");
        }
        String s = "";
        for(int i = 1;i<=digits;i++){
            if(sum>9){
                s = 9+s;
                sum=-9;
            }
            else if(i == digits){

                s = sum+s;
            }
            else{

                s = sum-1+s;
                sum = 1;

            }
        }
        return s;


        //return null;
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance+=amount;


    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(balance-amount<minBalance){
            throw new Exception("Insufficient Balance");

        }
        else{
            balance-=amount;
        }

    }

}*/
package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name=name;
        this.balance=balance;
        this.minBalance=minBalance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public static String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if (sum < 0 || sum > 9 * digits) {
            throw new Exception("Account Number can not be generated");
        }else {

            StringBuilder accountNumber = new StringBuilder();

//            for (int i = 0; i < digits; i++) {
//                int maxDigitValue = Math.min(9, sum);
//                int digit = (i == digits - 1) ? sum : (int) (Math.random() * (maxDigitValue + 1));
//                sum -= digit;
//                accountNumber.append(digit);
//            }
            while(sum>9){
                accountNumber.append("9");
                sum-=9;
            }
            while(accountNumber.length()<digits){
                accountNumber.append(sum);
                sum=0;
            }
            return accountNumber.toString();
        }
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance+=amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        double rem=this.balance-amount;
        if(rem<this.minBalance){
            throw new Exception("Insufficient Balance");
        }else{
            this.balance=rem;
        }

    }

}