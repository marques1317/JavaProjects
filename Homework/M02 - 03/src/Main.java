import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
//I have created a new class for patient so that i can store as many patient detailes as possible by merely creating their object
class Patient
{
    //all the getters
    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getAmount() {
        return amount;
    }

    public String getPayment() {
        return payment;
    }

    public String getDate() {
        return date;
    }
    //all the data members
    private String first,last,address,city,state,zip,amount,payment,date;
    //constructor to initialize all the dat members
    public Patient(String s1,String s2,String address,String city,String state,String zip,String amount,String payment,String date)
    {
        this.first=s1;
        this.last=s2;
        this.address=address;
        this.city=city;
        this.state=state;
        this.zip=zip;
        this.amount=amount;
        this.payment=payment;
        this.date=date;
    }
}
class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);//scanner object create to prompt user
        char ch;
        boolean b;
        String s1,s2,address,city,state,zip,amount,payment,date;
        ArrayList<Patient> arr=new ArrayList<>();//creting array list to insert patient objects in it
        do{
            do{
                System.out.print("Enter first name ");
                s1 = input.nextLine();
                b=Pattern.matches("[a-zA-Z]+", s1);//check if first name only containes alphabets returns true if okk otherwise false
                if(!b)//if it returns false
                {
                    System.out.println("Please Enter alphabets only");//tell user to enter only alphabets
                }
            }while(b==false);//do it until it returns true
            do{
                System.out.print("Enter last name ");
                s2 = input.nextLine();
                b=Pattern.matches("[a-zA-Z]+", s2);//check if it containes alpabets only
                if(!b)
                {
                    System.out.println("Please Enter alphabets only");
                }
            }while(b==false);
//address may contain digits like 'house no 289' so no need to check
            System.out.print("Enter address ");
            address = input.nextLine();
            do{
                System.out.print("Enter city ");
                city = input.nextLine();
                b=Pattern.matches("[a-zA-Z]+", city);//check if city only containes alphabets
                if(!b)
                {
                    System.out.println("Please Enter alphabets only");
                }
            }while(b==false);
            do{
                System.out.print("Enter state ");
                state = input.nextLine();
                b=Pattern.matches("[a-zA-Z]+", state);
                if(!b)
                {
                    System.out.println("Please Enter alphabets only");
                }
            }while(b==false);
            do{
                System.out.print("Enter zip ");
                zip = input.nextLine();
                if(zip.length()==5 && Pattern.matches("[0-9]+",zip))//check for its length which must be 5 and it should contain only digits
                {
                    b=true;//if both conditions are met then set b as true
                }else {
                    System.out.println("Must be 5 digits long and Must contain digits only");
                    b=false;
                }
            }while(b==false);
            do{
                System.out.print("Enter amount owed ");
                amount = input.nextLine();
                if (Pattern.matches("[0-9]+",amount)) b=true;//if it only containes digits then okk
                else{
                    System.out.println("Please enter digits only");
                    b=false;
                }
            }while(b==false);
            do{
                System.out.print("Enter payment amount ");
                payment = input.nextLine();
                if(Pattern.matches("[0-9]+",payment)) b=true;
                else{
                    System.out.println("Please enter digits only");b=false;
                }
            }while(b==false);

            System.out.print("Enter payment date in the format 'dd/mm/yyyy'");
            date = input.nextLine();
            Patient p=new Patient(s1,s2,address,city,state,zip,amount,payment,date);
            arr.add(p);
            System.out.println("Any more Entry ? Click y - Yes or n - No");
            ch=input.nextLine().charAt(0);
        }while(ch=='y');

        System.out.printf("%80s\n", "XYZ Community Hospital");
        System.out.printf(String.format("%150s\n", "").replace(' ', '='));
        System.out.printf("%10s%30s%80s\n", "Name", "Address", "Payment Information");
        System.out.printf("%-8s %-12s %-30s %-15s %-5s %-10s %-15s %-15s %-15s \n", "First", "Last", "Address Line 1", "City", "State", "Zip", "Amount Owed",
                "Payment Amt.", "Payment Date");
        System.out.printf(String.format("%150s\n", "").replace(' ', '='));
//traverse arraylist to print all the patient object detailes
        for(int i=0;i<arr.size();i++)
        {
            Patient p=arr.get(i);//get the patient object at index i
            System.out.printf("%-8s %-12s %-30s %-15s %-5s %-10s %-15s %-15s %-15s \n", p.getFirst(), p.getLast(), p.getAddress(), p.getCity(),p.getState(), p.getZip(),p.getAmount(),p.getPayment(),p.getDate());
        }
        input.close();
    }
}


