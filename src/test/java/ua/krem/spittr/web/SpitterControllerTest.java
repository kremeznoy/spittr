package ua.krem.spittr.web;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ua.krem.spittr.config.WebConfig;
import ua.krem.spittr.data.Spitter;
import ua.krem.spittr.data.SpitterRepository;

import java.util.HashMap;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

/**
 * Description:
 * ====================================
 *
 * @author Sergiy
 * @since 4/4/2016
 */
@WebAppConfiguration
@ContextConfiguration(classes = WebConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SpitterControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void shouldShowRegistrationForm() throws Exception {
        SpitterRepository spitterRepository = org.mockito.Mockito.mock(SpitterRepository.class);

        SpitterController spitterController = new SpitterController(spitterRepository);
        MockMvc mockMvc = standaloneSetup(spitterController).build();

        mockMvc.perform(get("/spitter/register")).andExpect(view().name("registerForm"));
    }

    @Test
    @Ignore
    public void shouldProcessRegistrationForm() throws Exception {
        SpitterRepository spitterRepository = org.mockito.Mockito.mock(SpitterRepository.class);
        Spitter unsaved = new Spitter("krem", "p@aasw0rd", "Serhii", "Kremeznyi");
        Spitter saved = new Spitter(12L, "krem", "p@aasw0rd", "Serhii", "Kremeznyi");

        org.mockito.Mockito.when(spitterRepository.save(unsaved)).thenReturn(saved);

        SpitterController spitterController = new SpitterController(spitterRepository);
        // MockMvc mockMvc = standaloneSetup(spitterController).build();
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        HashMap<String, String> contentTypeParams = new HashMap<String, String>();
        contentTypeParams.put("boundary", "265001916915724");
        MediaType mediaType = new MediaType("multipart", "form-data", contentTypeParams);

        mockMvc.perform(post("/spitter/register").contentType(mediaType).param("firstName", "Serhii").param("lastName", "Kremeznyi")
                .param("username", "krem").param("password", "p@aasw0rd")).andExpect(redirectedUrl("/spitter/krem"));

        org.mockito.Mockito.verify(spitterRepository, org.mockito.Mockito.atLeastOnce()).save(unsaved);
    }
}
