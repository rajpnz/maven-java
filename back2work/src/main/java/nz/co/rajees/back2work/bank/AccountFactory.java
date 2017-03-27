package nz.co.rajees.back2work.bank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 */
public class AccountFactory {

    private static final Pattern ACCOUNT_ID_PATTERN = Pattern.compile("CRED-[0-9]{2}-[0-9]{3}-[0-9]{6}-[0-9]{3}");

    public AccountId createAccountId(String accountIdentifier){
        Matcher matcher = ACCOUNT_ID_PATTERN.matcher(accountIdentifier);
        if(matcher.matches()){
            return new AccountId(accountIdentifier);
        } else {
            throw new IllegalArgumentException("Can't build account id from " + accountIdentifier);
        }
    }
}
