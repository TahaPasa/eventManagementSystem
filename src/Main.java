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
            authenticate: while (true){
                System.out.print("Please enter your username: ");
                Scanner scanner = new Scanner(System.in);
                String username = scanner.nextLine();
                System.out.print("Please enter your password: ");
                String password = scanner.nextLine();

                for (Member member1 : Member.memberList) {
                    if (member1.getUsername().equals(username) && member1.getPassword().equals(password)) {
                        user = member1;

                        if (member1.isBanned()){
                            System.out.println("\n"+"You are banned from the system.");
                            System.out.println("Returning to main menu..."+ "\n");
                            continue authenticate;
                        }

                        System.out.println("Welcome " + member1.getName() + " " + member1.getSurname());
                        if (member1.isResponsible()){
                            user = (Responsible)member1;
                            System.out.println(" loged in as a responsible member");
                        }
                        else{
                            System.out.println(" loged in as a member");
                        }
                        break authenticate;
                    }
                }
                System.out.println("Wrong username or password, Try again.");
            }


            System.out.println("-----------------------" + "\n" + "Please select an option: ");
            System.out.println("1- View my profile");
            System.out.println("2- Update my profile");
            System.out.println("3- View my notifications");
            System.out.println("4- Subscribe to notifications");
            System.out.println("5- Unsubscribe from notifications");
            System.out.println("6- View an event");
            System.out.println("7- Register to an event");
            if (user.isResponsible()){
                System.out.println("8- Create an event");
                System.out.println("9- Manage an event");
                System.out.println("10- Ban a member");
                System.out.println("11- Send a notification");
                System.out.println("12- View attendees of an event");
            }
            System.out.println("0- Exit");
            System.out.println("-1 - Logout"+ "\n" + "-----------------------" + "\n");

            application : while (true){
                System.out.print("Enter your choice: ");

                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        user.viewMyProfile();
                        break;
                    case 2:
                        scanner.nextLine();
                        System.out.print("Please enter your name: ");
                        String name = scanner.nextLine();
                        System.out.print("Please enter your surname: ");
                        String surname = scanner.nextLine();
                        System.out.print("Please enter your student number: ");
                        String studentNumber = scanner.nextLine();
                        System.out.print("Please enter your phone number: ");
                        String phoneNumber = scanner.nextLine();
                        System.out.print("Please enter your email: ");
                        String email = scanner.nextLine();
                        System.out.print("Please enter your username: ");
                        String username = scanner.nextLine();
                        System.out.print("Please enter your password: ");
                        String password = scanner.nextLine();
                        user.updateMyProfile(name, surname, studentNumber, phoneNumber, email, username, password);
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
                        try {
                            System.out.print("Please enter the event ID: ");
                            int eventID = scanner.nextInt();
                            user.showEvent(eventID);
                            System.out.println("Returning to main menu..."+ "\n");
                            break;
                        }catch (Exception e){
                            System.out.println("Event not found");
                            break;
                        }

                    case 7:
                        try {
                            System.out.print("Please enter the event ID: ");
                            int eventID1 = scanner.nextInt();
                            user.registerEvent(eventID1);
                            System.out.println("Returning to main menu..."+ "\n");
                            break;
                        }catch (Exception e){
                            System.out.println("Event not found");
                            break;
                        }

                    case 8:
                        scanner.nextLine();
                        System.out.print("Please enter the event name: ");
                        String eventName = scanner.nextLine();
                        System.out.print("Please enter the event date: ");
                        String eventDate = scanner.nextLine();
                        System.out.print("Please enter the guest of the event: ");
                        String guest = scanner.nextLine();
                        System.out.print("Please enter the location of the event: ");
                        String location = scanner.nextLine();
                        ((Responsible) user).createEvent(eventName, eventDate, guest, location);
                        System.out.println("Returning to main menu..."+ "\n");
                        break;
                    case 9:
                        scanner.nextLine();
                        System.out.print("Please enter the event ID: ");
                        int eventID2 = scanner.nextInt();
                        try {
                            Event event = Event.eventList.get(eventID2);
                        }catch (Exception e){
                            System.out.println("Event not found");
                            break;
                        }
                        scanner.nextLine();
                        System.out.print("Please enter the event name: ");
                        String eventName1 = scanner.nextLine();
                        System.out.print("Please enter the event date: ");
                        String eventDate1 = scanner.nextLine();
                        System.out.print("Please enter the guest of the event: ");
                        String guest1 = scanner.nextLine();
                        System.out.print("Please enter the location of the event: ");
                        String location1 = scanner.nextLine();
                        ((Responsible) user).manageEvent(eventID2, eventName1, eventDate1, new ArrayList<>(), guest1, location1);
                        System.out.println("Returning to main menu..."+ "\n");
                        break;
                    case 10:
                        try {
                            scanner.nextLine();
                            System.out.print("Please enter the username of the member you want to ban: ");
                            String username1 = scanner.nextLine();

                            try{
                                for (Member member :
                                        Member.memberList) {
                                    if (member.getUsername().equals(username1)){
                                        if (member.isResponsible()){
                                            System.out.println("You can not ban a responsible member");
                                            break;
                                        }

                                        ((Responsible) user).banMember(username1);

                                        System.out.println("Member banned successfully");
                                        break;
                                    }

                                }

                            }
                            catch (Exception e){
                                System.out.println("Member not found");
                                break;
                            }


                            System.out.println("Returning to main menu..."+ "\n");
                            break;
                        }catch (Exception e){
                            System.out.println("Member not found");
                            break;
                        }

                    case 11:
                        try {
                            System.out.print("Please enter the event ID: ");
                            int eventID3 = scanner.nextInt();
                            System.out.println("Sending notification to all attendees of the event " + Event.eventList.get(eventID3).getEventName() + "...");
                            for (Member member : Event.eventList.get(eventID3).getAttendeeList()) {
                                ((Responsible) user).sendNotification(eventID3, member.getUsername());
                            }
                            System.out.println("Returning to main menu..."+ "\n");
                            break;

                        }catch (Exception e){
                            System.out.println("Event not found");
                            break;
                        }

                    case 12:
                        try {
                            System.out.print("Please enter the event ID: ");
                            int eventID4 = scanner.nextInt();
                            System.out.println("Attendees of the event " + Event.eventList.get(eventID4).getEventName() + ":");
                            for (Member member : Event.eventList.get(eventID4).getAttendeeList()) {
                                System.out.println(member.getName() + " " + member.getSurname());
                            }
                            System.out.println("Returning to main menu..."+ "\n");
                            break;
                        }catch (Exception e){
                            System.out.println("Event not found");
                            break;
                        }

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