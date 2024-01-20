import java.util.ArrayList;
import java.util.Scanner;

public class utils {
    Scanner scanner = new Scanner(System.in);

    public Member authenticate() {
        authenticate: while (true) {
            Member user = new Member();
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
                        return user;
                    }
                    else{
                        System.out.println(" loged in as a member");
                        return user;
                    }

                }
            }
            System.out.println("Wrong username or password, Try again.");
        }
    }

    public void writeMenu(boolean isResponsible){
        System.out.println("\n" + "------------- Please select an option: -------------");
        System.out.println("1- View my profile");
        System.out.println("2- Update my profile");
        System.out.println("3- View my notifications");
        System.out.println("4- Subscribe to notifications");
        System.out.println("5- Unsubscribe from notifications");
        System.out.println("6- View an event");
        System.out.println("7- Register to an event");
        if (isResponsible){
            System.out.println("8- Create an event");
            System.out.println("9- Manage an event");
            System.out.println("10- Ban a member");
            System.out.println("11- Send a notification");
            System.out.println("12- View attendees of an event");
        }
        System.out.println("0- Exit");
        System.out.println("-1 - Logout"+ "\n" + "-----------------------" + "\n");
    }

    public void callUpdateProfile(Member user){

        String name;
        String surname;

        System.out.print("Please enter your name: ");
        name = scanner.nextLine();
        System.out.print("Please enter your surname: ");
        surname = scanner.nextLine();

        for (Member member : Member.memberList) {
            if (member.getName().equals(name) && member.getSurname().equals(surname)) {
                System.out.println("This Name-Surname is already exists!");
                return;
            }
        }


        System.out.print("Please enter your student number: ");
        String studentNumber = scanner.nextLine();
        for (Member member : Member.memberList) {
            if (member.getStudentNumber().equals(studentNumber)) {
                System.out.println("Student number already exists!");
                return;
            }
        }



        System.out.print("Please enter your phone number: ");
        String phoneNumber = scanner.nextLine();
        for (Member member : Member.memberList) {
            if (member.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("This phone number already exists!");
                return;
            }
        }



        String email;
        System.out.print("Please enter your email: ");
        email = scanner.nextLine();
        for (Member member : Member.memberList) {
            if (member.getEmail().equals(email)) {
                System.out.println("Email already exists!");
                return;
            }
        }



        String username;
        System.out.print("Please enter your username: ");
        username = scanner.nextLine();
        for (Member member : Member.memberList) {
            if (member.getUsername().equals(username)) {
                System.out.println("Username already taken");
                return;
            }
        }



        System.out.print("Please enter your password: ");
        String password = scanner.nextLine();
        user.updateMyProfile(name, surname, studentNumber, phoneNumber, email, username, password);
    }

    public void callShowEvent(Member user){

            System.out.print("Please enter the event ID: ");
            int eventID = scanner.nextInt();
            user.showEvent(eventID);
            System.out.println("Returning to main menu..."+ "\n");

    }

    public void callRegisterEvent(Member user){
        System.out.print("Please enter the event ID: ");
        int eventID = scanner.nextInt();
        user.registerEvent(eventID);
        System.out.println("Returning to main menu..."+ "\n");
    }

    public void callCreateEvent(Member user){

        System.out.print("Please enter the event name: ");
        String eventName = scanner.nextLine();
        System.out.print("Please enter the event date (DD-MM-YYYY): ");
        String eventDate = scanner.nextLine();

        if (!checkDateFormat(eventDate)){
            System.out.println("Returning to main menu..."+ "\n");
            return;
        }

        System.out.print("Please enter the guest of the event: ");
        String guest = scanner.nextLine();
        System.out.print("Please enter the location of the event: ");
        String location = scanner.nextLine();
        ((Responsible) user).createEvent(eventName, eventDate, guest, location);
        System.out.println("Event successfully created.");
        System.out.println("Returning to main menu..."+ "\n");


    }

    public void callManageEvent(Member user){
        scanner.nextLine();
        System.out.print("Please enter the event ID: ");
        int eventID2 = scanner.nextInt();
        try {
            Event event = Event.eventList.get(eventID2);
        }catch (Exception e){
            System.out.println("Event not found");
            System.out.println("Returning to main menu..."+ "\n");
            return;
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

        System.out.println("Delete attendees? (y/n)");
        String deleteAttendees = scanner.nextLine();
        if (deleteAttendees.equals("y") || deleteAttendees.equals("Y")){
            ((Responsible) user).manageEvent(eventID2, eventName1, eventDate1, new ArrayList<>(), guest1, location1);
        }
        else if (deleteAttendees.equals("n") || deleteAttendees.equals("N")){
            ((Responsible) user).manageEvent(eventID2, eventName1, eventDate1, guest1, location1);
        }
        else{
            System.out.println("Invalid input");

        }
        System.out.println("Returning to main menu..."+ "\n");
    }

    public void callBanMember(Member user){

            scanner.nextLine();
            System.out.print("Please enter the username of the member you want to ban: ");
            String username1 = scanner.nextLine();

            try {
                for (Member member :
                        Member.memberList) {
                    if (member.getUsername().equals(username1)) {
                        if (member.isResponsible()) {
                            System.out.println("You can not ban a responsible member");
                            return;
                        }

                        ((Responsible) user).banMember(username1);

                        System.out.println("Member banned successfully");
                        return;
                    }
                }


            } catch (Exception e) {
                System.out.println("Member not found");
                return;
            }finally {
                System.out.println("Returning to main menu..." + "\n");
            }
    }

    public void callSendNotification(Member user){
        try {
            System.out.print("Please enter the event ID: ");
            int eventID3 = scanner.nextInt();
            System.out.println("Sending notification to all attendees of the event " + Event.eventList.get(eventID3).getEventName() + "...");
            for (Member member : Event.eventList.get(eventID3).getAttendeeList()) {
                ((Responsible) user).sendNotification(eventID3, member.getUsername());
            }

        }catch (Exception e){
            System.out.println("Event not found");


        }finally {
            System.out.println("Returning to main menu..."+ "\n");
        }
    }

    public void callViewAttendees(Member user){
        try {
            System.out.print("Please enter the event ID: ");
            int eventID4 = scanner.nextInt();
            System.out.println("Attendees of the event " + Event.eventList.get(eventID4).getEventName() + ":");
            for (Member member : Event.eventList.get(eventID4).getAttendeeList()) {
                System.out.println(member.getName() + " " + member.getSurname());
            }
        }catch (Exception e){
            System.out.println("Event not found");

        }finally {
            System.out.println("Returning to main menu..."+ "\n");
        }
    }

    public boolean checkDateFormat(String date){
        if (date.length() != 10){
            System.out.println("Invalid date format");
            return false;
        }
        if (date.charAt(2) != '-' || date.charAt(5) != '-'){
            System.out.println("Invalid date format");
            return false;
        }
        for (int i = 0; i < date.length(); i++) {
            if (i == 2 || i == 5){
                continue;
            }
            if (!Character.isDigit(date.charAt(i))){
                System.out.println("Invalid date format");
                return false;
            }
            //check exceed date values
            if (i == 0 || i == 1){
                if (Integer.parseInt(date.substring(0,2)) > 31){
                    System.out.println("Invalid date format");
                    return false;
                }
            }
            if (i == 3 || i == 4){
                if (Integer.parseInt(date.substring(3,5)) > 12){
                    System.out.println("Invalid date format");
                    return false;
                }
            }

        }
        return true;
    }



}
