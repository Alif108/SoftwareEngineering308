package bank_management;


import java.util.ArrayList;
import static bank_management.Bank.accounts;
import static bank_management.Bank.decreaseFund;
import static bank_management.Bank.get_fund;
import static bank_management.Bank.increaseFund;
import java.util.Scanner;


class Bank
{
    static float fund;
    static ArrayList<Account> accounts;
    private ArrayList<Employee> employees;
//    private Managing_Director md;
    static int year;
    
    public Bank()
    {
        Bank.fund = 1000000;
        accounts = new ArrayList<Account>();
        employees = new ArrayList<Employee>();
        
        Managing_Director md = new Managing_Director("MD");
        employees.add(md);
        
        Officer o1 = new Officer("O1");
        Officer o2 = new Officer("O2");
        employees.add(o1);
        employees.add(o2);
        
        for(int i=0; i<5; i++)
        {
            Cashier c = new Cashier("C" + String.valueOf(i+1));
            employees.add(c);
        }
        
//        Cashier c1 = new Cashier("C1");
//        Cashier c2 = new Cashier("C2");
//        Cashier c3 = new Cashier("C3");
//        Cashier c4 = new Cashier("C4");
//        Cashier c5 = new Cashier("C5");
//        employees.add(c1);
//        employees.add(c2);
//        employees.add(c3);
//        employees.add(c4);
//        employees.add(c5);
        
        this.year = 0;
        
        System.out.println("Bank Created; MD, S1, S2, C1, C2, C3, C4, C5 created");
    }
    
    public boolean search_account(String name)                          
    {
        boolean found = false;
        
        for(int i=0; i<accounts.size(); i++)
        {
            if(accounts.get(i).getName().equals(name))
            {
                found = true;
                break;
            }
        }
        return found;
    }
    
    public boolean add_acc(String name, int acc_type, float init_deposit)
    {
        if(acc_type == 2 && init_deposit < 100000 )
        {
                System.out.println("First deposit for Fixed Deposit Account should be at least 100000$");
                return false;
        }
        
        if(!search_account(name))
        {
            Account acc = null;
            
            if(acc_type == 0)
                acc = new Savings();
            else if(acc_type == 1)
                acc = new Student();
            else
                acc = new FixedDeposit();
            
            acc.create_account(name, acc_type, init_deposit);
            accounts.add(acc);
            Bank.fund += init_deposit;
            return true;
        }
        else
        {
            System.out.println("Name Already Exists");
            return false;
        }
    }
    
    public void add_employee(String name, String type)
    {
        if(type.equals("Managing Director"))
        {
            Managing_Director md = new Managing_Director(name);
            employees.add(md);
        }
        else if(type.equals("Officer"))
        {
            Officer o = new Officer(name);
            employees.add(o);
        }
        else
        {
            Cashier c = new Cashier(name);
            employees.add(c);
        }
    }
    
    public Employee get_employee(String name)
    {
        Employee emp = null;
        
        for(int i=0; i<employees.size(); i++)
        {
            if(employees.get(i).get_name().equals(name))
            {
                emp = employees.get(i);
//                String type = emp.get_type();
//                
//                if(type.equals("MD"))
//                    return (Managing_Director) emp;
//                
//                else if(type.equals("Officer"))
//                    return (Officer) emp;
//                    
//                else if(type.equals("Cashier"))
//                    return (Cashier) emp;
            }
        }
 
        return emp;
    }
    
    public Account get_account(String name)
    {
        Account acc = null;
        for(int i=0; i<accounts.size(); i++)
        {
            if(accounts.get(i).getName().equals(name))
            {
                acc = accounts.get(i);
                break;
            }
        }
        if(acc == null)
            System.out.println("Account Not Found");
        
        return acc;
    }
    
    public void increase_year()
    {
        year++;
        for(int i=0; i<accounts.size(); i++)                    //manage bank activites for all accounts
        {
            accounts.get(i).deduct_loan();
            accounts.get(i).service_charge();
            accounts.get(i).add_interest();
        }
        System.out.println(this.year + " year passed");
    }
    
//    public Account search(String name)
//    {
//        for(int i=0; i<accounts.size(); i++)
//        {
//            if(name.equals(accounts.get(i).getName()))
//            {
//                return accounts.get(i);
//            }
//        }
//        System.out.println("No Accounts Found");
//        return null;
//    }
    
    public static void increaseFund(float amount)
    {
        Bank.fund += amount;
    }
    
    public static void decreaseFund(float amount)
    {
        Bank.fund -= amount;
    }
    
    public static float get_fund()
    {
        return Bank.fund;
    }
    
    public int open(String name)
    {
        //boolean found = false;
        
        for(int i=0; i<accounts.size(); i++)
        {
            if(accounts.get(i).getName().equals(name))
            {
                accounts.get(i).open();
                //found = true;
                //break;
                return 0;
            }
        }
        
        for(int i=0; i<employees.size(); i++)
        {
            if(employees.get(i).get_name().equals(name))
            {
                employees.get(i).open();
                //found = true;
                //break;
                return 1;
            }
        }
//        if(!found)
//        {
//            System.out.println("User Not Found");
//        }
//        System.out.println("User Not Found");
        return -1;
    }
}


public class Bank_Management {

    public static void main(String[] args) {
        
        Bank b = new Bank();
        
        Account acc = null;
        Employee emp = null;
        Scanner scanner = new Scanner(System.in);
        boolean active = false;
        
        while(true)
        {
            String input = scanner.nextLine();
            //input = input.toLowerCase();
            String[] arrOfStr = input.split(" ");
            
            if(arrOfStr[0].toLowerCase().equals("create"))
            {
                if(active)
                    System.out.println("Close all the Accounts First");
                
                else
                {
                    int type = -1;
                    String name = arrOfStr[1];
                    float deposit = 0;

                    if(arrOfStr[2].toLowerCase().equals("savings"))
                    {
                        type = 0;
                        deposit = Float.parseFloat(arrOfStr[3]);
                    }

                    else if(arrOfStr[2].toLowerCase().equals("student"))
                    {
                        type = 1;
                        deposit = Float.parseFloat(arrOfStr[3]);
                    }

                    else if(arrOfStr[2].toLowerCase().equals("fixed"))
                    {
                        type = 2;
                        deposit = Float.parseFloat(arrOfStr[4]);
                    }

                    boolean x = b.add_acc(name, type, deposit);

                    if(x)
                    {
                        acc = b.get_account(name);
                        active = true;
                    }
                }
            }
            
            else if(arrOfStr[0].toLowerCase().equals("deposit"))
            {
                if(acc != null)
                {
//                    if(acc.get_active_status())
                    if(active)
                    {
                        float deposit = Float.parseFloat(arrOfStr[1]);
                        acc.deposit(deposit);
                    }
                    else
                    {
                        System.out.println("Account not active");
                    }
                }
                
                else
                    System.out.println("No Accounts Active");
            }
            
            else if(arrOfStr[0].toLowerCase().equals("withdraw"))
            {
                if(acc != null)
                {
//                    if(acc.get_active_status())
                    if(active)
                    {
                        float wd = Float.parseFloat(arrOfStr[1]);
                        acc.withdraw(wd);
                    }
                    else
                    {
                        System.out.println("Account not active");
                    }
                }
                else
                    System.out.println("No Accounts Active");
            }
            
            else if(arrOfStr[0].toLowerCase().equals("query"))
            {
                if(acc != null)
                {
//                    if(acc.get_active_status())
                    if(active)
                    {
                        acc.query_deposit();
                    }
                    else
                        System.out.println("Account not active");
                }
                
                else
                    System.out.println("No Accounts Active");
            }
            
            else if(arrOfStr[0].toLowerCase().equals("request"))
            {
                if(acc != null)
                {
//                    if(acc.get_active_status())
                    if(active)
                    {
                        float loan = Float.parseFloat(arrOfStr[1]);
                        acc.request_loan(loan);
                    }
                    else
                        System.out.println("Account not active");
                }
                else
                    System.out.println("No Accounts Active");
            }
            
            else if(arrOfStr[0].toLowerCase().equals("close"))
            {
                if(acc != null)
                {
                    acc.close();
                    acc = null;
                    active = false;
                }
                if(emp != null)
                {
                    emp.close();
                    emp = null;
                    active = false;
                }
            }
            
            else if(arrOfStr[0].toLowerCase().equals("open"))
            {
                if(active)
                    System.out.println("Close All the Accounts First");
                
                else
                {
                    String name = arrOfStr[1];
                    int x = b.open(name);

                    if(x == 0)                      //account
                    {
                        acc = b.get_account(name);
                        active = true;
                    }

                    else if(x == 1)                 //employee
                    {
                        {
                            emp = b.get_employee(name);
                            active = true;
                        }
                    }
                    
                    else
                        System.out.println("No Account/Employee Found");
                }
            }
            
            else if(arrOfStr[0].toLowerCase().equals("approve"))
            {
                if(emp != null)
                {
//                    if(emp.get_active_status())
                    if(active)
                    {
                       if(emp.get_type().equals("MD"))
                       {
                           Managing_Director md = (Managing_Director) emp;
                           md.approveLoan();
                       }
                       else if(emp.get_type().equals("Officer"))
                       {
                           Officer of = (Officer) emp;
                           of.approveLoan();
                       }
                       else
                       {
                           System.out.println("You don’t have permission for this operation");
                       }
                    }
                    else
                        System.out.println("No Employees Active");
                }
                else
                    System.out.println("No Employees Active");
            }
            
            else if(arrOfStr[0].toLowerCase().equals("change"))
            {
                if(emp != null)
                {
//                    if(emp.get_active_status())
                    if(active)
                    {
                        if(emp.get_type().equals("MD"))
                        {
                            Managing_Director md = (Managing_Director) emp;
                            int type = Integer.parseInt(arrOfStr[1]);
                            float interest = Float.parseFloat(arrOfStr[2]);
                            md.change_interest_rate(type, interest);
                        }
                        else
                        {
                            System.out.println("You don’t have permission for this operation");
                        }
                    }
                    else
                        System.out.println("No Employees Active");
                }
                else
                    System.out.println("No Employees Active");
            }
            
            else if(arrOfStr[0].toLowerCase().equals("lookup"))
            {
                if(emp != null)
                {
//                    if(emp.get_active_status())
                    if(active)
                    {
                        emp.Lookup(arrOfStr[1]);
                    }
                    else
                        System.out.println("No Employees Active");
                }
                else
                    System.out.println("No Employees Active");
            }
            
            else if(arrOfStr[0].toLowerCase().equals("see"))
            {
                if(emp != null)
                {
//                    if(emp.get_active_status())
                    if(active)
                    {
                        if(emp.get_type().equals("MD"))
                        {
                           Managing_Director md = (Managing_Director) emp;
                           md.see_internal_fund();
                        }
                        else
                            System.out.println("You don’t have permission for this operation");
                    }
                }
                else
                    System.out.println("No Employees Active");
            }
            
            else if(arrOfStr[0].toLowerCase().equals("inc"))
            {
                b.increase_year();
            }
            
            else if(arrOfStr[0].toLowerCase().equals("exit"))
                break;
            
            else
                System.out.println("Action not available");
        }
    }   
}