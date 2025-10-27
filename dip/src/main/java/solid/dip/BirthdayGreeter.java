package solid.dip;

import java.time.MonthDay;

public class BirthdayGreeter {
    private final EmployeeRepository employeeRepository;
    private final MessageSender messageSender;

    public BirthdayGreeter(EmployeeRepository employeeRepository, MessageSender messageSender) {
        this.employeeRepository = employeeRepository;
        this.messageSender = messageSender;
    }

    public void sendGreetings() {
        MonthDay today = MonthDay.now();
        employeeRepository.findEmployeesBornOn(today)
                .stream()
                .map(this::emailFor)
                .forEach(messageSender::send);
    }

    private Email emailFor(Employee employee) {
        String message = String.format("Happy birthday, dear %s!", employee.getFirstName());
        return new Email(employee.getEmail(), "Happy birthday!", message);
    }

}