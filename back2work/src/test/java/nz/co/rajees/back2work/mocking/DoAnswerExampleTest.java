package nz.co.rajees.back2work.mocking;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.*;


public class DoAnswerExampleTest {

    private DoAnswerExample classUnderTest;
    private IStringManager mockStringManager;

    @Before
    public void setUp() {
        mockStringManager = Mockito.mock(IStringManager.class);
        classUnderTest = new DoAnswerExample(mockStringManager);
    }

    @Test
    public void testDoAnswer() {
        //arrange
        Mockito.doAnswer(new TestAnswer()).when(mockStringManager).setString(Mockito.anyString());
        //act
        classUnderTest.setName("fat");

    }

    private class TestAnswer implements Answer{
        @Override
        public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
            String argPassedToSetName = (String)invocationOnMock.getArguments()[0];
            System.out.print(argPassedToSetName);
            return null;
        }
    }
}