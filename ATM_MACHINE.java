import java.util.Scanner;

class ATM{
    float Balance = 0;
    int PIN = 112233;
    int transactions = 0;
    String history = "";

    ATM(){
        System.out.println("Enter your PIN: ");
        Scanner sc = new Scanner(System.in);
        int enteredPIN = sc.nextInt();
        if(enteredPIN == PIN){
            menu();
        }
        else{
            System.out.println("Invalid PIN...\n");
            new ATM();
        }
    }

    void menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice: ");
        System.out.println("1.Check Balance.");
        System.out.println("2.Transaction History.");
        System.out.println("3.Withdraw.");
        System.out.println("4.Deposit.");
        System.out.println("5.Transfer.");
        System.out.println("6.Quit.");

        int choice = sc.nextInt();

        switch(choice){
            case 1:
                checkBalance();
                break;
            case 2:
                transactionHistory();
                break;
            case 3:
                withdraw();
                break;
            case 4:
                deposit();
                break;
            case 5:
                transfer();
                break;
            case 6:
                System.out.println("\nThank you for visiting..\n");
                break;
            default:
                System.out.println("Invalid choice!!");
                menu();
				break;
        }
    }

    void checkBalance(){
        System.out.println("\nBalance: " + Balance + " Rs.\n");
        menu();
    }

    void transactionHistory(){
        if(transactions == 0){
            System.out.println("\nNo Transactions Happened.\n");
        }else{
            System.out.println(history);
        }
        menu();
    }

    void withdraw(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Amount to withdraw: ");
        float amount = sc.nextFloat();

        if(amount <= Balance){
            Balance -= amount;
			transactions++;
            String str = amount+" Rs is Debited\n";
            history = history.concat(str);
            System.out.println("\nWithdrawal Successful.\n"); 
        }else{
            System.out.println("\nInsufficient Balance!\n");
        }
        
        menu();
    }

    void deposit(){
        Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Amount to Deposit: ");
        float amount = sc.nextFloat();

        Balance += amount;
        transactions++;
        String str = amount+" Rs is Credited\n";
        history = history.concat(str);
        System.out.println("\n"+amount + "Rs is Successfully Deposited to your bank Account\n");
        menu();
    }

    void transfer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter the name of the Reciever: ");
        String name = sc.nextLine();
        System.out.println("\nEnter the amount to transfer: ");
        float amount = sc.nextFloat();

        if(amount <= Balance){
            Balance -= amount;
			transactions++;
            String str = amount+" Rs is Debited\n";
            history = history.concat(str);
            System.out.println("\n"+amount+" Rs is transferred to " + name + "'s account.\n");
        }
        else{
            System.out.println("\nInsufficient Funds!\n");
        }

        menu();
    }
}


public class ATM_MACHINE{
    public static void main(String args[]){
        new ATM();
    }
}

