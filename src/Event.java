import java.util.ArrayList;
import java.util.List;

public class Event {
    private String eventName;
    private String eventDate;
    private List<Member> attendeeList = new ArrayList<>();
    private String guest;
    private String location;
    private int eventID;
    static List<Event> eventList= new ArrayList<>();

    public Event(String eventName, String eventDate, List<Member> attendeeList, String guest, String location) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.attendeeList = attendeeList;
        this.guest = guest;
        this.location = location;
        this.eventID = eventList.size();
    }

    public Event(String eventName, String eventDate, String guest, String location) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.guest = guest;
        this.location = location;
        this.eventID = eventList.size();

    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public List<Member> getAttendeeList() {
        return attendeeList;
    }

    public void setAttendeeList(List<Member> attendeeList) {
        this.attendeeList = attendeeList;
    }

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }
}
