import java.util.List;

public class Responsible extends Member{
    String role;

    public Responsible() {
    }

    public Responsible(String name, String surname, String studentNumber,
                       String joinDate, String phoneNumber, String email, String username,
                       String password, boolean isBanned,boolean isResponsible, boolean isSubscribed , String role) {
        super(name, surname, studentNumber, joinDate, phoneNumber, email, username, password, isBanned,isResponsible,isSubscribed);
        this.role = role;
    }

    public Responsible(String name, String surname, String studentNumber, String phoneNumber, String email, String username, String password, String role) {
        super(name, surname, studentNumber, phoneNumber, email, username, password, false, true);
        this.role = role;
    }

    void createEvent( String eventName, String eventDate, String guest, String location){
        Event event = new Event(eventName, eventDate, guest, location);
        Event.eventList.add(event);
    }
    void createEvent(String eventName, String eventDate, List<Member> attendeeList, String guest, String location){
        Event event = new Event(eventName, eventDate, attendeeList, guest, location);
        Event.eventList.add(event);
    }

    void banMember(String username){
        for (Member member : Member.memberList) {
            if (member.getUsername().equals(username)) {
                member.setBanned(true);
                return;
            }

        }
        System.out.println("Member not found");
    }

    void sendNotification(int eventID, String username){

        for (Member member : Member.memberList) {
            if (member.getUsername().equals(username)) {
                if (!member.isSubscribed()) {

                    return;
                }
                member.addNotification("Dear " + member.getName() + ",\n" +
                        "You have been invited to the event " + Event.eventList.get(eventID).getEventName() + " on " + Event.eventList.get(eventID).getEventDate() + ".\n" +
                        "The event will be held at " + Event.eventList.get(eventID).getLocation() + ".\n" +
                        "The guest of the event will be " + Event.eventList.get(eventID).getGuest() + ".\n" +
                        "We hope to see you there.\n" +
                        "Best regards,\n" +
                        "Event Management System");
            }
            return;
        }
        System.out.println("Member not found");
    }

    //manageEvent function with its nullable arguments
    void manageEvent(int eventID, String eventName, String eventDate, List<Member> attendeeList, String guest, String location) {


            Event event = Event.eventList.get(eventID);

            if (eventName != null) {
                event.setEventName(eventName);
            }
            if (eventDate != null) {
                event.setEventDate(eventDate);
            }
            if (attendeeList != null) {
                event.setAttendeeList(attendeeList);
            }
            if (guest != null) {
                event.setGuest(guest);
            }
            if (location != null) {
                event.setLocation(location);
            }


    }

    void manageEvent(int eventID, String eventName, String eventDate, String guest, String location) {


            Event event = Event.eventList.get(eventID);

            if (eventName != null) {
                event.setEventName(eventName);
            }
            if (eventDate != null) {
                event.setEventDate(eventDate);
            }
            if (guest != null) {
                event.setGuest(guest);
            }
            if (location != null) {
                event.setLocation(location);
            }

    }

    List<Member> getAttendeeList( int eventID){
        try {
            return Event.eventList.get(eventID).getAttendeeList();
        }catch (Exception e){
            System.out.println("Event not found");
            return null;
        }
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
