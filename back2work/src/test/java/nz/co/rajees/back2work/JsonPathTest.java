package nz.co.rajees.back2work;


import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class JsonPathTest {

    private static final String TEST_JSON = " " +
            "{\"someThing\": {\n" +
            "    \"innerThing\": {\n" +
            "        \"partOne\": \"abc\",\n" +
            "        \"partTwo\": 123\n" +
            "    }\n" +
            " }}";

    private Object document;

    @Before
    public void setUp(){
        //document will only be read in once
        document = Configuration.defaultConfiguration().jsonProvider().parse(TEST_JSON);
    }

    @Test
    public void testPartOneAsExpected(){
        //read from json directly
        String actual = JsonPath.read(TEST_JSON, "$.someThing.innerThing.partOne");
        assertThat(actual, is(equalTo("abc")));
    }

    @Test
    public void testPartTwoAsExpected(){
        //read from document
        Integer actual = JsonPath.read(document, "$.someThing.innerThing.partTwo");
        assertThat(actual, is(equalTo(123)));
    }


}
