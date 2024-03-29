package maratische.kotlin.sdktest1;


import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public abstract class BaseClass {

    @Autowired
    ServerCheckController personRestController;

//    @MockBean
//    PersonService personService;

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(personRestController);

//        Mockito.when(personService.findPersonById(1L))
//                .thenReturn(new Person(1L, "foo", "bee"));
    }

}
