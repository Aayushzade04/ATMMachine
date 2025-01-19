import java.util.*;

public class atm 
{
    private static int accountNo = 123456789; //Defualt account number
    private static int pin = 1234; //Default PIN
    private static int balance = 20000; //Default balance

    public static void main(String args[]) 
    {
        int withdraw, deposit, choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("*********WELCOME TO ATM MACHINE**************");

        
        if (login(sc)) 
        {
            while (true) 
            {
                System.out.println("\n*******Welcome to ATM machine*******");
                System.out.println("1... Withdraw");
                System.out.println("2... Deposit");
                System.out.println("3... Check Balance");
                System.out.println("4... Change PIN");
                System.out.println("5... Fund Transfer");
                System.out.println("6... Exit");
                System.out.print("Enter your choice: ");
                
                choice = sc.nextInt();
                switch (choice) 
                {
                    case 1:
                    System.out.println("Current Balance : " + balance);
                    System.out.print("Enter the amount to withdraw : ");
                    withdraw = sc.nextInt();
                    if (balance >= withdraw) 
                    {
                        balance =  balance - withdraw;
                        System.out.println("Withdrawal successful. Remaining balance: " + balance);
                        System.out.println("-----------------------------------------------------");
                        System.out.println("You want to use Other ATM services to to press y for continue or presss n for NO");
                        char c = sc.next().charAt(0);
                        if(c == 'y' || c == 'Y') 
                        {
                            continue;
                        }
                        else 
                        {
                            System.exit(c);
                        }
                    }
                    else
                    {
                        System.out.println("Dont enugh funds. Current balance : " + balance);
                        System.out.println("You want to use Other ATM services to to press y for continue or presss n for NO");
                        char c6 = sc.next().charAt(0);
                        if(c6 == 'y' || c6 == 'Y') 
                        {
                            continue;
                        }
                        else 
                        {
                            System.exit(c6);
                        }
                        System.out.println("-----------------------------------------------------");

                    }
                    break;
                        
                    case 2:
                    System.out.println("Current Balance : " + balance);
                    System.out.print("Enter amount to deposit: ");
                    deposit = sc.nextInt();
                    balance = balance + deposit;
                    System.out.println("Deposit successful. Current balance: " + balance);
                    System.out.println("You want to use Other ATM services to to press y for continue or presss n for NO");
                    char c1 = sc.next().charAt(0);
                    if(c1 == 'y' || c1 == 'Y') 
                    {
                        continue;
                    }
                    else 
                    {
                        System.exit(c1);
                    }
                    System.out.println("-----------------------------------------------------");
                    break;

                    case 3:
                    System.out.println("Current balance: " + balance);
                    System.out.println("You want to use Other ATM services to to press y for continue or presss n for NO");
                    char c2 = sc.next().charAt(0);
                    if(c2 == 'y' || c2 == 'Y') 
                    {
                        continue;
                    }
                    else 
                    {
                        System.exit(c2);
                    }
                    System.out.println("-----------------------------------------------------");

                    break;

                    case 4:
                    Change_Pin(sc);
                    System.out.println("You want to use Other ATM services to to press y for continue or presss n for NO");
                    char c3 = sc.next().charAt(0);
                    if(c3 == 'y' || c3 == 'Y') 
                    {
                        continue;
                    }
                    else 
                    {
                        System.exit(c3);
                    }
                    break;

                    case 5:
                    Fund_Transfer(sc);
                    System.out.println("You want to use Other ATM services to to press y for continue or presss n for NO");
                    char c4 = sc.next().charAt(0);
                    if(c4 == 'y' || c4 == 'Y') 
                    {
                        continue;
                    }
                    else 
                    {
                        System.exit(c4);
                    }
                    break;

                    case 6:
                    System.out.println("********Thank you for using the ATM************ ");
                    System.exit(0);
                    break;

                    default:
                    System.out.println("Invalid choice Please try again.");
                    System.out.println("-----------------------------------------------------------");
                }
            }
        } 
        else 
        {
            System.out.println("You Try too many failed attempts.\n\nPlease create new Account or try after 24 hours ");
            System.out.println("------------------------------------------------------------------");
        }
    }

    private static boolean login(Scanner sc) 
    {
        int s = 2;
        for (int attempts = 0; attempts < 3; attempts++) 
        {
            // s = 3;
            //System.out.println("You have only " + (s --) + " Attempt remaining");
            System.out.print("Enter your Account Number : ");
            int Add_AccountNo = sc.nextInt();
                        //System.out.println("You have only " + (s --) + " Attempt remaining");

            if (Add_AccountNo == accountNo) 
            {
                System.out.print("Enter your PIN : ");
                int enteredPin = sc.nextInt();
                if (enteredPin == pin) 
                {
                    System.out.println("Login successful");
                    return true;
                } 
                else
                {
                    //int s1 = 2;
                    System.out.println("Invalid PIN Try again");
                    System.out.println("You have only " + (s --) + " Attempt remaining");

                }
            }   
            else 
            {
                System.out.println("Invalid Account Number. Try again.");
                System.out.println("You have only " + (s --) + " Attempt remaining");

            }
           

            System.out.print("Do you want to create a new account press y for YES or n for NO ");
            System.out.println("\n                 OR                      ");
            System.out.println("You Try Again to Login press n");
            char select = sc.next().charAt(0);
            if (select == 'y' || select == 'Y') 
            {
                Create_Account(sc);
                return true; 
            }
        }
        return false; 
    }

    private static void Create_Account(Scanner sc) 
    {
        System.out.print("Enter a new Account Number: ");
        accountNo = sc.nextInt();
        System.out.print("Enter a new PIN : ");
        pin = sc.nextInt();
        System.out.println("Enter the Account Holder Name :");
        String Name = sc.next();
        System.out.println("Enter the Address");
        String add = sc.next();
        System.out.println("Account created successfully");
        System.out.println("Your New Account Number : " +accountNo);
        System.err.println("---------------------------------------------------------------------");
    }

    private static void Change_Pin(Scanner sc) 
    {
        System.out.print("Enter your current PIN : ");
        int Current_Pin = sc.nextInt();
        if (Current_Pin == pin) 
        {
            System.out.print("Enter your new PIN : ");
            pin = sc.nextInt();
            System.out.println("PIN changed succesfully ");
        } 
        else 
        {
            System.out.println("Current PIN is incorrect");
        }
    }

    private static void Fund_Transfer(Scanner sc) 
    {
        System.out.println("Current Balance : " + balance);
        System.out.print("Enter the account number to transfer funds to : ");
        int transferAccountNo = sc.nextInt();
        System.out.print("Enter the amount to transfer : ");
        int transferAmount = sc.nextInt();

        if (transferAmount <= balance) 
        {
            balance -= transferAmount;
            System.out.println("Fund transfer successful ");
            System.err.println("Remaining Balance : " + balance);
            System.out.println("Transferred " +transferAmount+ " to account "+transferAccountNo);
        } 
        else 
        {
            System.out.println(" Dont enugh funds for this transfer ");
            System.out.println("Current Balance : " + balance);
        }
    }
}
