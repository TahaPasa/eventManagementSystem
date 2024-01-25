// Authors: Taha Alp Kocyigit

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {


        
        //Responsible responsible1 = new Responsible("Taha Alp", "Kocyigit", "22096536","123456","tkoc@outlook.com", "thakcygt", "123456","President");

        fileHelper.readResponsible("C:/Users/MSI-NB/Desktop/Software_Engineering_Task_Taha_Alp_Kocyigit/codes/eventManagementSystem/responsibles.txt");
        //print member list
        for (Member member : Member.memberList) {
            System.out.println(member.getName() + " " + member.getSurname() + " " + member.getStudentNumber() + " " + member.getJoinDate() + " " + member.getPhoneNumber() + " " + member.getEmail() + " " + member.getUsername() + " " + member.getPassword() + " " + member.isBanned() + " " + member.getNotificationList() + " " + member.isSubscribed() + " " + member.isResponsible());
        }
        /*
        Member memberData = new Member("Esref", "Ece", "465132465", "08-03-2023", "12345456", "esrefece@gmail.com",
                "esrefece", "123456", false, false);

        Member memberData2 = new Member("Utku", "Onur", "456978312", "562500000", "utkus@gmail.com",
                "usahin", "123456", false, false);*/

        wholeApplication : while(true){
            System.out.println("****** Welcome to the Event Management System ******");

            Scanner scanner = new Scanner(System.in);
            Member user = utils.authenticate();


            utils.writeMenu(user.isResponsible());

            application : while (true){
                System.out.print("Enter your choice: ");


                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        user.viewMyProfile();
                        break;
                    case "2":
                        utils.callUpdateProfile(user);
                        System.out.println("Returning to main menu..."+ "\n");
                        break;
                    case "3":
                        user.viewNotifications();
                        System.out.println("Returning to main menu..."+ "\n");
                        break;
                    case "4":
                        user.subscribeNotification();
                        System.out.println("Returning to main menu..."+ "\n");
                        break;
                    case "5":
                        user.unsubscribeNotification();
                        System.out.println("Returning to main menu..."+ "\n");
                        break;
                    case "6":
                        utils.callShowEvent(user);
                        break;
                    case "7":
                        utils.callRegisterEvent(user);
                        break;
                    case "8":
                        if (!user.isResponsible()){
                            System.out.println("Unauthorized access!");
                            System.out.println("Returning to main menu..."+ "\n");
                            break ;
                        }
                        utils.callCreateEvent(user);
                        break;
                    case "9":
                        if (!user.isResponsible()){
                            System.out.println("Unauthorized access!");
                            System.out.println("Returning to main menu..."+ "\n");
                            break;
                        }
                        utils.callManageEvent(user);
                        break;
                    case "10":
                        if (!user.isResponsible()){
                            System.out.println("Unauthorized access!");
                            System.out.println("Returning to main menu..."+ "\n");
                            break;
                        }
                        utils.callBanMember(user);
                        break;
                    case "11":
                        if (!user.isResponsible()){
                            System.out.println("Unauthorized access!");
                            System.out.println("Returning to main menu..."+ "\n");
                            break;
                        }
                        utils.callSendNotification(user);
                        break;

                    case "12":
                        if (!user.isResponsible()){
                            System.out.println("Unauthorized access!");
                            System.out.println("Returning to main menu..."+ "\n");
                            break;
                        }
                        utils.callViewAttendees(user);
                        break;

                    case "0":
                        System.out.println("Thank you for using our system");
                        break wholeApplication;

                    case "-1":
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