import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // creating some members

        Responsible responsible1 = new Responsible("Taha Alp", "Kocyigit", "22096536","123456",
                "tkoc@outlook.com", "thakcygt", "123456","President");

        Member memberData = new Member("Esref", "Ece", "465132465", "08-03-2023", "12345456", "esrefece@gmail.com",
                "esrefece", "123456", false, false);

        Member memberData2 = new Member("Utku", "Onur", "456978312", "562500000", "utkus@gmail.com",
                "uusahin", "123456", false, false);

        wholeApplication : while(true){
            System.out.println("****** Welcome to the Event Management System ******");
            Member user = new Member();

            utils utils = new utils();
            user = utils.authenticate();


            utils.writeMenu(user.isResponsible());

            application : while (true){
                System.out.print("Enter your choice: ");

                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        user.viewMyProfile();
                        break;
                    case 2:
                        utils.callUpdateProfile(user);
                        System.out.println("Returning to main menu..."+ "\n");
                        break;
                    case 3:
                        user.viewNotifications();
                        System.out.println("Returning to main menu..."+ "\n");
                        break;
                    case 4:
                        user.subscribeNotification();
                        System.out.println("Returning to main menu..."+ "\n");
                        break;
                    case 5:
                        user.unsubscribeNotification();
                        System.out.println("Returning to main menu..."+ "\n");
                        break;
                    case 6:
                        utils.callShowEvent(user);
                        break;
                    case 7:
                        utils.callRegisterEvent(user);
                        break;
                    case 8:
                        if (!user.isResponsible()){
                            System.out.println("Unauthorized access!");
                            System.out.println("Returning to main menu..."+ "\n");
                            return;
                        }
                        utils.callCreateEvent(user);

                        break;
                    case 9:
                        if (!user.isResponsible()){
                            System.out.println("Unauthorized access!");
                            System.out.println("Returning to main menu..."+ "\n");
                            return;
                        }
                        utils.callManageEvent(user);
                        break;
                    case 10:
                        if (!user.isResponsible()){
                            System.out.println("Unauthorized access!");
                            System.out.println("Returning to main menu..."+ "\n");
                            return;
                        }
                        utils.callBanMember(user);
                        break;
                    case 11:
                        if (!user.isResponsible()){
                            System.out.println("Unauthorized access!");
                            System.out.println("Returning to main menu..."+ "\n");
                            return;
                        }
                        utils.callSendNotification(user);
                        break;

                    case 12:
                        if (!user.isResponsible()){
                            System.out.println("Unauthorized access!");
                            System.out.println("Returning to main menu..."+ "\n");
                            return;
                        }
                        utils.callViewAttendees(user);
                        break;

                    case 0:
                        System.out.println("Thank you for using our system");
                        break wholeApplication;

                    case -1:
                        System.out.println("Logging out...");
                        break application;

                    default:
                        System.out.println("Invalid choice, please try again");
                        break;


                }
            }
        }

    }
}