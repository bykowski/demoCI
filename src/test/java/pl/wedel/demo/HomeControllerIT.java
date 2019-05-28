package pl.wedel.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class HomeControllerIT
{
    private MockMvc mockMvc;
    
    @Before
    public void setUp()
    {
        mockMvc = MockMvcBuilders
            .standaloneSetup(new HomeController())
            .build();
    }
    
    @Test
    public void shouldReturn200() throws Exception
    {
        mockMvc.perform(get("/")
                            .contentType("applicaltion/json"))
               .andExpect(status().isOk())
               .andExpect(content().string("Hello world!"));
    }
}
