package nz.co.rajees.back2work.mocking;

/**
 * A class to test the doAnswer mechanism in Mockito
 */
public class DoAnswerExample {

    private IStringManager stringManager;

    public DoAnswerExample(IStringManager stringManager) {
        this.stringManager = stringManager;
    }

    public void setName(String name) {
        stringManager.setString(name);
    }
}
