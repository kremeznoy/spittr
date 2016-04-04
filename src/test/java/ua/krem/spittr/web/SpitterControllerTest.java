package ua.krem.spittr.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import ua.krem.spittr.data.Spitter;
import ua.krem.spittr.data.SpitterRepository;

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
public class SpitterControllerTest {

    @Test
    public void shouldShowRegistrationForm() throws Exception {
        SpitterRepository spitterRepository = org.mockito.Mockito.mock(SpitterRepository.class);

        SpitterController spitterController = new SpitterController(spitterRepository);
        MockMvc mockMvc = standaloneSetup(spitterController).build();

        mockMvc.perform(get("/spitter/register")).andExpect(view().name("registerForm"));
    }

    @Test
    public void shouldProcessRegistrationForm() throws Exception {
        SpitterRepository spitterRepository = org.mockito.Mockito.mock(SpitterRepository.class);
        Spitter unsaved = new Spitter("krem", "p@aasw0rd", "Serhii", "Kremeznyi");
        Spitter saved = new Spitter(12L, "krem", "p@aasw0rd", "Serhii", "Kremeznyi");

        org.mockito.Mockito.when(spitterRepository.save(unsaved)).thenReturn(saved);

        SpitterController spitterController = new SpitterController(spitterRepository);
        MockMvc mockMvc = standaloneSetup(spitterController).build();

        mockMvc.perform(post("/spitter/register").param("firstName", "Serhii").param("lastName", "Kremeznyi")
        .param("username", "krem").param("password", "p@aasw0rd")).andExpect(redirectedUrl("/spitter/krem"));

        org.mockito.Mockito.verify(spitterRepository, org.mockito.Mockito.atLeastOnce()).save(unsaved);
    }
}
