package solid.dip;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.ArgumentCaptor;

import java.time.MonthDay;
import java.util.Collections;

import static solid.dip.EmployeeBuilder.anEmployee;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BirthdayGreeterShould {

    @Mock
    EmployeeRepository employeeRepository;

    @Mock
    MessageSender messageSender;

    @InjectMocks
    private BirthdayGreeter birthdayGreeter;

    @Test
    public void should_send_greeting_email_to_employee() {

        Employee employee = anEmployee()
                .withFirstName("John")
                .withEmail("john.doe@foobar.com")
                .build();

        given(employeeRepository.findEmployeesBornOn(MonthDay.now())).willReturn(Collections.singletonList(employee));

        birthdayGreeter.sendGreetings();

        ArgumentCaptor<Email> emailCaptor = ArgumentCaptor.forClass(Email.class);
        verify(messageSender).send(emailCaptor.capture());

        Email sentEmail = emailCaptor.getValue();
        assertThat(sentEmail.getTo()).isEqualTo("john.doe@foobar.com");
        assertThat(sentEmail.getSubject()).isEqualTo("Happy birthday!");
        assertThat(sentEmail.getMessage()).isEqualTo("Happy birthday, dear John!");
    }
}