package solid.dip;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.MonthDay;
import java.util.Collections;

import static solid.dip.EmployeeBuilder.anEmployee;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class BirthdayGreeterShould {

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    private BirthdayGreeter birthdayGreeter;

    private ByteArrayOutputStream consoleContent = new ByteArrayOutputStream();

    @Test
    public void should_send_greeting_email_to_employee() {
        System.setOut(new PrintStream(consoleContent));
        Employee employee = anEmployee().build();
        given(employeeRepository.findEmployeesBornOn(MonthDay.now())).willReturn(Collections.singletonList(employee));

        birthdayGreeter.sendGreetings();

        String actual = consoleContent.toString();
        assertThat(actual)
                .isEqualTo("To:" + employee.getEmail() + ", Subject: Happy birthday!, Message: Happy birthday, dear " + employee.getFirstName()+"!");

    }



}