package by.pvt.product;

import by.pvt.WebAppTestConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebAppTestConfiguration.class)
public class SearchControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    @Sql(value = "/test-search.sql")
    public void search() throws Exception {
        String viewName;
        ModelAndView modelAndView = mockMvc.perform(get("/search")
                .param("searchStr", "test"))
                .andReturn()
                .getModelAndView();

        viewName = modelAndView.getViewName();
        List items = (List) modelAndView.getModel().get("items");

        assertEquals("searchResultPage", viewName);
        assertNotNull(items);
        assertEquals(1, items.size());
    }
}