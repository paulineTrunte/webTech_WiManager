package de.htwberlin.webtech.wiManager.web;

import de.htwberlin.webtech.wiManager.service.AbgabeService;
import de.htwberlin.webtech.wiManager.web.api.Abgabe;
import org.assertj.core.api.WithAssertions;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.time.LocalDate;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AbgabeRestController.class)
public class AbgabeRestControllerTest implements WithAssertions {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AbgabeService abgabeService;


    @Test
    @DisplayName("returns 404 if abgabe is not found")
    void abgabeNotFound() throws Exception {
        // given
        doReturn(null).when(abgabeService).findById(anyLong());

        // when
        mockMvc.perform(get("/api/v1/abgaben/123"))
                // then
                .andExpect(status().isNotFound());
    }


    @Test
    @DisplayName("validates create abgabe request")
    void validatesAbgabeRequest() throws Exception {
        // given
        String personToCreateAsJson = "{\"semester\": \"4\", \"modulname\":\"Konfliktmanagement\", \"frist\":\"2022-12-15\", \"notificationMessage\": Hausarbeit}";;

        // when
        mockMvc.perform(
                        post("/api/v1/abgaben")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(personToCreateAsJson)
                )
                // then
                .andExpect(status().isBadRequest());
    }

    /*
    @Test
    @DisplayName("returns found abgaben from abgabeService")
    void foundAbgaben() throws Exception {
        // given
        var abgaben = List.of(
                new Abgabe(4, "Konfliktmanagement", LocalDate.of(2022, 12, 15), "Hausarbeit"),
                new Abgabe(3, "WebTech", LocalDate.of(2022, 12, 19), "Milestone 4"));
        doReturn(abgaben).when(abgabeService).findAll();


        // when
        mockMvc.perform(get("/api/v1/abgaben"))
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(0))
                .andExpect(jsonPath("$[0].semester").value(4))
                .andExpect(jsonPath("$[0].modulName").value("Konfliktmanagement"))
                .andExpect(jsonPath("$[0].frist").value(List.of(22,12,15)))
                .andExpect(jsonPath("$[0].notificationMessage").value( "Hausarbeit"))
                .andExpect(jsonPath("$[1].id").value(1))
                .andExpect(jsonPath("$[1].semester").value(3))
                .andExpect(jsonPath("$[1].modulName").value("WebTech"))
                .andExpect(jsonPath("$[1].frist").value(abgaben.get(1).getFrist().toString()))
                .andExpect(jsonPath("$[1].notificationMessage").value( "Milestone 4"));
    }

     */
}
