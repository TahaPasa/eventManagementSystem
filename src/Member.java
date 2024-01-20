import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Member {
    private String name;
    private String surname;
    private String studentNumber;
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private String joinDate = sdf.format(calendar.getTime());
    private String phoneNumber;
    private String email;
    private String username;
    private String password;
    private boolean isBanned = false;
    private List<String> notificationList = new ArrayList<>();
    static List<Member> memberList = new ArrayList<>();
    private boolean isSubscribed =true;
    private boolean isResponsible = false;

    public Member() {
    }

    public Member(String name, String surname, String studentNumber, String joinDate, String phoneNumber, String email, String username, String password, boolean isBanned, boolean isResponsible) {
        this.name = name;
        this.surname = surname;
        this.studentNumber = studentNumber;
        this.joinDate = joinDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.username = username;
        this.password = password;
        this.isBanned = isBanned;
        this.isResponsible = isResponsible;
        Member.memberList.add(this);
        System.out.println("Member successfully created");
    }

    public Member(String name, String surname, String studentNumber, String phoneNumber, String email, String username, String password, boolean isBanned, boolean isResponsible) {
        this.name = name;
        this.surname = surname;
        this.studentNumber = studentNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.username = username;
        this.password = password;
        this.isBanned = isBanned;
        this.isResponsible = isResponsible;
        Member.memberList.add(this);
        System.out.println("Member successfully created");
    }

    public void showEvent(int eventID){
        try {
            Event event = Event.eventList.get(eventID);
            System.out.println("Event name: " + event.getEventName());
            System.out.println("Event date: " + event.getEventDate());
            System.out.println("Event location: " + event.getLocation());
            System.out.println("Event guest: " + event.getGuest());
            System.out.println("Event ID: " + event.getEventID());
        }catch (Exception e){
            System.out.println("Invalid input or event not found");
            return;
        }
    }

    public void subscribeNotification(){
        this.isSubscribed = true;
        System.out.println("You have successfully subscribed to notifications");
    }

    public void unsubscribeNotification(){
        this.isSubscribed = false;
        System.out.println("You have successfully unsubscribed from notifications");
    }

    public void registerEvent(int eventID){

        try {
            Event event = Event.eventList.get(eventID);
            event.getAttendeeList().add(this);
            System.out.println("You have successfully registered to the event " + event.getEventName());
        }catch (Exception e){
            System.out.println("Event not found");
            return;
        }
    }

    public void viewNotifications(){
        if(this.notificationList.size() == 0){
            System.out.println("You have no notifications");
            return;
        }
        for (String notification : this.notificationList) {
            System.out.println(notification);
        }
    }

    public void viewMyProfile(){
        System.out.println("-----------------------------------");
        System.out.println("Name: " + this.name);
        System.out.println("Surname: " + this.surname);
        System.out.println("Student number: " + this.studentNumber);
        System.out.println("Join date: " + this.joinDate);
        System.out.println("Phone number: " + this.phoneNumber);
        System.out.println("Email: " + this.email);
        System.out.println("Username: " + this.username);
        System.out.println("Password: " + this.password);
        System.out.println("Is banned: " + this.isBanned);
        System.out.println("Is subscribed: " + this.isSubscribed);
        System.out.println("Is responsible: " + this.isResponsible);
        System.out.println("-----------------------------------"+ "\n");

    }

    public void updateMyProfile(String name, String surname, String studentNumber, String phoneNumber, String email, String username, String password){
        this.name = name;
        this.surname = surname;
        this.studentNumber = studentNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.username = username;
        this.password = password;
        System.out.println("Your profile has been successfully updated");
    }

    public void addNotification(String notification){
        this.notificationList.add(notification);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    public List<String> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(List<String> notificationList) {
        this.notificationList = notificationList;
    }

    public boolean isSubscribed() {
        return isSubscribed;
    }

    public void setSubscribed(boolean subscribed) {
        isSubscribed = subscribed;
    }

    public boolean isResponsible() {
        return isResponsible;
    }

    public void setResponsible(boolean responsible) {
        isResponsible = responsible;
    }
}
