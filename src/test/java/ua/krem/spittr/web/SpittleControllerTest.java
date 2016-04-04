package ua.krem.spittr.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import ua.krem.spittr.data.Spittle;
import ua.krem.spittr.data.SpittleRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

/**
 * Description:
 * ====================================
 *
 * @author Sergiy
 * @since 3/31/2016
 */
public class SpittleControllerTest {
    @Test
    public void shouldShowRecentSpittles() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(3);
        SpittleRepository spittleRepository = org.mockito.Mockito.mock(SpittleRepository.class);
        org.mockito.Mockito.when(spittleRepository.findSpittles(Long.MAX_VALUE, 3)).thenReturn(expectedSpittles);
        // org.mockito.Mockito.when(spittleRepository.findSpittles(1000000, 3)).thenReturn(expectedSpittles);

        SpittleController spittleController = new SpittleController(spittleRepository);
        MockMvc mockMvc = standaloneSetup(spittleController).setSingleView(
                new InternalResourceView("WEB-INF/views/spittles.jsp")).build();

        mockMvc.perform(get("/spittles")).andExpect(view().name("spittles")).andExpect(model().attributeExists("spittleList")).
                andExpect(model().attribute("spittleList", org.junit.matchers.JUnitMatchers.hasItems(expectedSpittles.toArray())));
    }

    /*@Test
    public void shouldShowPagedSpittles() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(6);
        SpittleRepository spittleRepository = org.mockito.Mockito.mock(SpittleRepository.class);
        org.mockito.Mockito.when(spittleRepository.findSpittles(238900,6)).thenReturn(expectedSpittles);

        SpittleController spittleController = new SpittleController(spittleRepository);
        MockMvc mockMvc = standaloneSetup(spittleController)
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();

        mockMvc.perform(get("/spittles?max=238900&count=6")).andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", org.junit.matchers.JUnitMatchers.hasItem(expectedSpittles.toArray())));
    }*/

    @Test
    public void shouldReturnOnlyOneSpittleById() throws Exception {
        Spittle expectedSpittle = new Spittle("Hello, that's a single Spittle", new Date());
        SpittleRepository spittleRepository = org.mockito.Mockito.mock(SpittleRepository.class);
        org.mockito.Mockito.when(spittleRepository.findOne(12345)).thenReturn(expectedSpittle);

        SpittleController spittleController = new SpittleController(spittleRepository);
        MockMvc mockMvc = standaloneSetup(spittleController).setSingleView(
                new InternalResourceView("WEB-INF/views/spittle.jsp")).build();

        mockMvc.perform(get("/spittles/12345")).andExpect(view().name("spittle"))
                .andExpect(model().attributeExists("spittle"))
                .andExpect(model().attribute("spittle", expectedSpittle));
    }

    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittleList = new ArrayList<>();
        for (int i=0; i<count; i++) {
            spittleList.add(new Spittle("Spittle ID#" + i, new Date()));
        }
        return spittleList;
    }
}
