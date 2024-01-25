import java.io.*;
import java.util.Collections;

public class fileHelper {
    //operation to save and read objects to the txt file with string format and fetch them

    public static void writeMember(Member member, String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String s = "/";
        bufferedWriter.write(member.getName() + s + member.getSurname() + s + member.getStudentNumber()
                + s + member.getJoinDate() + s + member.getPhoneNumber() + s + member.getEmail() + s + member.getUsername() + s
                + member.getPassword() + s + member.isBanned()+ s + "{" + member.getNotificationList() + "}" +s+ member.isSubscribed()+ s + member.isResponsible() +s +"\n");
        bufferedWriter.close();
    }

    public static void writeEvent(Event event, String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String s = "/";
        bufferedWriter.write(event.getEventName() + s + event.getEventDate() + s +"{" + event.getAttendeeList() +"}"
                + s + event.getGuest() + s + event.getLocation() + s + event.getEventID() + s + "\n");
        bufferedWriter.close();
    }

    public static void writeResponsible(Responsible responsible, String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String s = "/";
        bufferedWriter.write(responsible.getName() + s + responsible.getSurname() + s + responsible.getStudentNumber()
                + s + responsible.getJoinDate() + s + responsible.getPhoneNumber() + s + responsible.getEmail() + s + responsible.getUsername() + s
                + responsible.getPassword() + s + responsible.isBanned()+ s + "{" + responsible.getNotificationList() + "}"+ s+ responsible.isSubscribed() + s + responsible.isResponsible()+ s +
                responsible.getRole() + "\n");
        bufferedWriter.close();
    }

    public static void readMember(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        while (line != null) {
            String[] member = line.split("/");
            Member member1 = new Member();
            member1.setName(member[0]);
            member1.setSurname(member[1]);
            member1.setStudentNumber(member[2]);
            member1.setJoinDate(member[3]);
            member1.setPhoneNumber(member[4]);
            member1.setEmail(member[5]);
            member1.setUsername(member[6]);
            member1.setPassword(member[7]);
            member1.setBanned(Boolean.parseBoolean(member[8]));
            member1.setResponsible(Boolean.parseBoolean(member[10]));
            //member1.setRole(member[12]);
            member1.setSubscribed(Boolean.parseBoolean(member[11]));
            // those are: name, surname, studentNumber, joinDate, phoneNumber, email, username, password, isBanned, isResponsible, notificationList, isSubscribed, role
            member1.setNotificationList(Collections.singletonList(member[9]));
            Member.memberList.add(member1);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
    }

    public static void readEvent(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        while (line != null) {
            String[] event = line.split("/");
            Event event1 = new Event(event[0], event[1], event[3], event[4]);
            event1.setEventID(Integer.parseInt(event[5]));
            Event.eventList.add(event1);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
    }

    public static void readResponsible(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        while (line != null) {
            String[] responsible = line.split("/");
            Responsible responsible1 = new Responsible();
            responsible1.setName(responsible[0]);
            responsible1.setSurname(responsible[1]);
            responsible1.setStudentNumber(responsible[2]);
            responsible1.setJoinDate(responsible[3]);
            responsible1.setPhoneNumber(responsible[4]);
            responsible1.setEmail(responsible[5]);
            responsible1.setUsername(responsible[6]);
            responsible1.setPassword(responsible[7]);
            responsible1.setBanned(Boolean.parseBoolean(responsible[8]));
            responsible1.setResponsible(Boolean.parseBoolean(responsible[10]));
            responsible1.setRole(responsible[12]);
            responsible1.setSubscribed(Boolean.parseBoolean(responsible[11]));

            // those are: name, surname, studentNumber, joinDate, phoneNumber, email, username, password, isBanned, isResponsible, notificationList, isSubscribed, role
            responsible1.setNotificationList(Collections.singletonList(responsible[9]));
            Responsible.memberList.add(responsible1);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
    }





}
