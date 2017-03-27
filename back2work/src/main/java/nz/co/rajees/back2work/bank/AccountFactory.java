package nz.co.rajees.back2work.bank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 */
public class AccountFactory {

    private static final Pattern ACCOUNT_ID_PATTERN = Pattern.compile("(CRED)-(\\d{2}-\\d{3}-\\d{6}-\\d{3})");

    public AccountId createAccountId(String accountIdentifier){
        Matcher matcher = ACCOUNT_ID_PATTERN.matcher(accountIdentifier);
        if(matcher.matches()){
            String type = matcher.group(1);
            String accountNum = matcher.group(2);
            return new AccountId(accountIdentifier);
        } else {
            throw new IllegalArgumentException("Can't build account id from " + accountIdentifier);
        }
    }
}
