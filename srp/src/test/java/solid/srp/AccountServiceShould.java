package solid.srp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceShould {

    private static final int POSITIVE_AMOUNT = 100;
    private static final int NEGATIVE_AMOUNT = -POSITIVE_AMOUNT;
    private static final LocalDate TODAY = LocalDate.now();

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private Clock clock;

    private AccountService accountService;

    @Before
    public void setUp() {
        given(clock.today()).willReturn(TODAY);
        accountService = new AccountService(transactionRepository, clock);
    }

    @Test
    public void deposit_amount_into_the_account() {
        accountService.deposit(POSITIVE_AMOUNT);
        verify(transactionRepository).add(refEq(new Transaction(TODAY, POSITIVE_AMOUNT)));
    }

    @Test
    public void withdraw_amount_from_the_account() {
        accountService.withdraw(POSITIVE_AMOUNT);
        verify(transactionRepository).add(refEq(new Transaction(TODAY, NEGATIVE_AMOUNT)));
    }
}