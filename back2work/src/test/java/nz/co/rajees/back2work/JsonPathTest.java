package nz.co.rajees.back2work;


import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

/**
 * @see <a href="https://github.com/json-path/JsonPath">JsonPath</a>
 */
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
    public void setUp() throws IOException {
        //document will only be read in once
        String pathToFile = "src/test/resources/test.json";
        File file = new File(pathToFile);
        try (FileInputStream fis = new FileInputStream(file)) {
            document = Configuration.defaultConfiguration().jsonProvider().parse(fis,"cp1252");
        }

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
        Integer actual = JsonPath.read(TEST_JSON, "$.someThing.innerThing.partTwo");
        assertThat(actual, is(equalTo(123)));
    }

    @Test
    public void testAuthor(){
        String author0 = JsonPath.read(document, "$.store.book[0].author");
        assertThat(author0, is(equalTo("Nigel Rees")));
    }

    @Test
    public void testAllAuthors(){
        List<String> authors = JsonPath.read(document, "$.store.book[*].author");
        assertThat(authors, containsInAnyOrder("Nigel Rees", "Evelyn Waugh","Herman Melville",
                "J. R. R. Tolkien"));
    }
}
