package solid.dip;

public class EmailSender implements MessageSender {
    public void send(Email email) {
        System.out.print("To:"
                + email.getTo() + ", Subject: "
                + email.getSubject() + ", Message: "
                + email.getMessage());
    }
}
