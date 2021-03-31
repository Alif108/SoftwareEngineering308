package bank_management;

import static bank_management.Bank.decreaseFund;
import static bank_management.Bank.increaseFund;

abstract class Account
{
    String name;
    float amount;
    float interest_rate;
    float loan_interest_rate;
    int max_loan_limit;
    float loan;
    boolean loan_request_flag;
    boolean loan_deduct_flag;
    float requested_loan_amount;

    abstract public void create_account(String name, int acc_type, float init_deposit);
    
    abstract public void deposit(float deposit_amount);
    
    abstract public void withdraw(float wd_amount);
    
    abstract public int get_acc_type();
    
    abstract public void service_charge();
    
    public boolean get_loan_req_flag()
    {
        return this.loan_request_flag;
    }
    
    public void request_loan(float loan_amount)
    {
        if(loan_amount < this.max_loan_limit)
        {
            this.loan_request_flag = true;                // loan request approval pending
            this.requested_loan_amount = loan_amount;
            System.out.println("Loan request successful, sent for approval");
        }
        else
            System.out.println("Maximum Loan Request Limit of " + this.max_loan_limit + "$ Exceeded");
    }
    
    public void loan_approved()
    {
        this.loan += this.requested_loan_amount;        //loan increased
        this.amount += this.requested_loan_amount;      //amount in bank increased by loan
        this.loan_deduct_flag = true;                   //this loan should be deducted after a year
        this.loan_request_flag = false;                 //no loan request pending
        this.requested_loan_amount = 0;                 //requested loan amount is 0 now
        
        System.out.println("Loan for " + this.name + " approved");
    }
    
    public float query_deposit()
    {
        System.out.println("Current Balance for " + this.name + " is: " + this.amount + "$");
        
        if(this.loan != 0)
            System.out.println("Loan: " + this.loan);
            
        return this.amount;
    }
//    
//    public void increase_year()
//    {
//        this.year++;
//    }
    
    public void deduct_loan()
    {
        this.amount -= (this.loan + this.loan * this.loan_interest_rate);
        this.loan = 0;
        this.loan_deduct_flag = false;          // no loan to be deducted anymore
    }
    
    public void add_interest()
    {
        this.amount += this.amount * this.interest_rate;
    }
    
    public String getName()
    {
        return this.name;
    }
            
    public void set_interest_rate(float rate)
    {
        this.interest_rate = rate;
    }
//    
//    public int get_year()
//    {
//        return this.year;
//    }
    
    public void open()
    {
//        this.active = true;
        System.out.println("Welcome back, " + this.name);
    }
    
    public void close()
    {
//        this.active = false;
        System.out.println("Transaction closed for " + this.name);
    }
}
    
class Savings extends Account
{

    @Override
    public void create_account(String name, int acc_type, float init_deposit) 
    {
        this.name = name;
        this.amount = init_deposit;
        this.loan_interest_rate = (float) 0.1;
        this.loan = 0;
        this.loan_request_flag = false;
        this.loan_deduct_flag = false;
        this.requested_loan_amount = 0;
        this.max_loan_limit = 10000;
        this.interest_rate = (float) 0.1;
        
        System.out.println("Savings Account for " + this.name + " created; initial balance " + this.amount);
    }

    @Override
    public void deposit(float deposit_amount) {

        this.amount += deposit_amount;
        increaseFund(deposit_amount);
        System.out.println(deposit_amount + " deposited; current balance " + this.amount +"$");

    }

    @Override
    public void withdraw(float wd_amount) 
    {
        if( (this.amount - wd_amount) < 1000)
            System.out.println("This Withdrawal results in a deposit less than 1000$");

        else
        {
            if(wd_amount < this.amount)
            {
                this.amount -= wd_amount;
                decreaseFund(wd_amount);
                System.out.println("Withdrawal of " + wd_amount + "$ successful");
            }
            else
            {
                System.out.println("Invalid Transaction; current balance " + this.amount + "$");
            }
        }
    }

    @Override
    public void service_charge() 
    {
        if(this.amount > 500)
        {
            this.amount -= 500;
        }
        else
            this.amount = 0;
    }

    @Override
    public int get_acc_type() 
    {
        return 0;
    }   
}

class Student extends Account
{

    @Override
    public void create_account(String name, int acc_type, float init_deposit) {
        this.name = name;
        this.amount = init_deposit;
        this.loan_interest_rate = (float) 0.1;
        this.loan = 0;
        this.loan_request_flag = false;
        this.loan_deduct_flag = false;
        this.requested_loan_amount = 0;
        this.max_loan_limit = 1000;
        this.interest_rate = (float) 0.05;
        
        
        System.out.println("Student Account for " + this.name + " created; initial balance " + this.amount);
    }

    @Override
    public void deposit(float deposit_amount) 
    {
        this.amount += deposit_amount;
        increaseFund(deposit_amount);
        System.out.println(deposit_amount + " deposited; current balance " + this.amount +"$");
    }

    @Override
    public void withdraw(float wd_amount) {
        
        if(wd_amount > 10000)
            System.out.println("Student account cannot withdraw more than 10,000$ in one transaction");
        
        else
        {
            if(wd_amount < this.amount)
            {
                this.amount -= wd_amount;
                decreaseFund(wd_amount);
                System.out.println("Withdrawal of " + wd_amount + "$ successful");
            }
            else
            {
                System.out.println("Invalid Transaction; current balance " + this.amount + "$");
            }
        }
    }

    @Override
    public void service_charge() 
    {
        return;
    }

    @Override
    public int get_acc_type() {
        return 1;
    }
}

class FixedDeposit extends Account
{

    @Override
    public void create_account(String name, int acc_type, float init_deposit) {
        this.name = name;
        this.amount = init_deposit;
        //this.year = 0;
        this.loan_interest_rate = (float) 0.1;
        this.loan = 0;
        this.loan_request_flag = false;
        this.loan_deduct_flag = false;
        this.requested_loan_amount = 0;
        this.max_loan_limit = 100000;
        this.interest_rate = (float) 0.15;
        
        
        System.out.println("Fixed Deposit Account for " + this.name + " created; initial balance " + this.amount);
    }

    @Override
    public void deposit(float deposit_amount) {
        if(deposit_amount<50000)
        {
            System.out.println("Fixed Deposit Accounts cannot deposit less than 50000$");
        }
        else
        {
            this.amount += deposit_amount;
            increaseFund(deposit_amount);
            System.out.println(deposit_amount + " deposited; current balance " + this.amount +"$");
        }
    }

    @Override
    public void withdraw(float wd_amount) 
    {
        
        if(Bank.year < 1)
        {
            System.out.println("Your (Fixed Deposit) account has not reached a maturity period of one year");
        }
        else
        {
            if(wd_amount < this.amount)
            {
                this.amount -= wd_amount;
                decreaseFund(wd_amount);
                System.out.println("Withdrawal of " + wd_amount + "$ successful");
            }
            else
            {
                System.out.println("Invalid Transaction; current balance " + this.amount + "$");
            }
        }
    }

    @Override
    public void service_charge() 
    {
        if(this.amount > 500)
        {
            this.amount -= 500;
        }
        else
            this.amount = 0;
    }

    @Override
    public int get_acc_type() {
        return 2;
    }
}
 