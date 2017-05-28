package nz.co.rajees.back2work;


import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.internal.filter.ValueNode;
import net.minidev.json.JSONObject;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class JsonPathTest {

    private static final String JSON = " " +
            "{\"someThing\": {\n" +
            "    \"innerThing\": {\n" +
            "        \"partOne\": \"abc\",\n" +
            "        \"partTwo\": 123\n" +
            "    }\n" +
            " }}";

    @Test
    public void testJsonPath(){
        String actual = JsonPath.read(JSON, "$.someThing.innerThing.partOne");
        assertThat(actual, is(equalTo("abc")));
    }
}
