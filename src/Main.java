import java.util.ArrayList;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        ArrayList<String> itemList = new ArrayList<>();
        String menuChoice;
        boolean menuDone = false;
        do
        {
            displayMenu();
            menuChoice = SafeInput.getRegExString(in, "Enter your Choice", "[AaDdPpQq]");
            switch(menuChoice)
            {
                case "A":
                case "a":
                    itemList.add(SafeInput.getNonZeroLenString(in,"What item would you like to add"));
                    break;
                case "D":
                case "d":
                    System.out.println();
                    for (int x = 0; x< itemList.size(); x++)
                    {
                        System.out.println(x+ ") " + itemList.get(x));
                    }
                    itemList.remove(SafeInput.getRangedInt(in,"Which item would you like to remove",0,itemList.size() -1));
                    in.nextLine();
                    break;
                case "P":
                case "p":
                    System.out.println();
                    for (int x = 0; x< itemList.size(); x++)
                    {
                        System.out.println(x+ ") " + itemList.get(x));
                    }
                    break;
                case "Q":
                case "q":
                    menuDone = SafeInput.getYNConfirm(in,"Are you sure you want to quit[Y/N]");
                    break;

            }
        }while (!menuDone);
    }
    private static void displayMenu()
    {
        System.out.println("\nA - Add an item to the list\nD - Delete an item from the list\nP - Print the list\nQ - Quit");
    }
}
