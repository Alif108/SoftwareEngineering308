package bank_management;

import static bank_management.Bank.accounts;
import static bank_management.Bank.get_fund;

abstract class Employee
{
    String name;
//    boolean active;
    
    abstract String get_type();
    
    public void Lookup(String name)
    {
        for(int i=0; i<accounts.size(); i++)
        {
            if(accounts.get(i).getName().equals(name))
            {
                accounts.get(i).query_deposit();
                return;
            }
        }
        System.out.println("No Accounts named " + name + " found");
    }
    
    public Employee(String emp_name)
    {
//        this.active = false;
        this.name = emp_name;
    }
    
    public String get_name()
    {
        return this.name;
    }
    
    public void open()
    {
//        this.active = true;
        System.out.println(this.name + " active");
    }
    
    public void close()
    {
//        this.active = false;
        System.out.println("Operations for " + this.name + " closed");
    }
    
//    public boolean get_active_status()
//    {
//        return this.active;
//    }
}

// class Managing Director
class Managing_Director extends Employee
{

    public Managing_Director(String emp_name) 
    {
        super(emp_name);
    }
    
    @Override
    public void open()
    {
//      this.active = true;
      System.out.println(this.name + " active");
      
      for(int i=0; i<accounts.size(); i++)
          if(accounts.get(i).get_loan_req_flag())
          {
              System.out.println("There are loan approvals pending");
              break;
          }
    }
     
   public void approveLoan()
    {
        for(int i=0; i<accounts.size(); i++)
        {
            if(accounts.get(i).get_loan_req_flag())                //if account has loan request for approval
            {
                accounts.get(i).loan_approved();
                //System.out.println("Loan for " + accounts.get(i).getName() + " approved");
            }
        }
    }
   
   public void change_interest_rate(int type, float rate)           //change interest rate of a particular type of account
   {
       for(int i=0; i<accounts.size(); i++)
       {
           if(accounts.get(i).get_acc_type() == type)
               accounts.get(i).set_interest_rate(rate);
       }
   }
   
   public float see_internal_fund()
   {
       float internal_fund = get_fund();
       System.out.println("Fund of the Bank is: " + internal_fund);
       return internal_fund;
   }

    @Override
    String get_type() 
    {
        return "MD";
    }
}

class Officer extends Employee
{
    
    public Officer(String emp_name) 
    {
        super(emp_name);
    }
    
    @Override
    public void open()
    {
//      this.active = true;
      System.out.println(this.name + " active");
      
      for(int i=0; i<accounts.size(); i++)
          if(accounts.get(i).get_loan_req_flag())
          {
              System.out.println("There are loan approvals pending");
              break;
          }
    }
    
    public void approveLoan()
    {
        for(int i=0; i<accounts.size(); i++)
        {
            if(accounts.get(i).get_loan_req_flag())                     //if account has loan request for approval
            {
                accounts.get(i).loan_approved();
            }
        }
    }
    
    @Override
    String get_type()
    {
        return "Officer";
    }
}

class Cashier extends Employee
{
    
    public Cashier(String emp_name) {
        super(emp_name);
    }
    
    @Override
    String get_type()
    {
        return "Cashier";
    }
}