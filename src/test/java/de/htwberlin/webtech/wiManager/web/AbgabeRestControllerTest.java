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
    @DisplayName("should return 404 if abgabe is not found")
    void should_return_404_if_abagbe_is_not_found() throws Exception {
        // given
        doReturn(null).when(abgabeService).findById(anyLong());

        // when
        mockMvc.perform(get("/api/v1/abgaben/123"))
                // then
                .andExpect(status().isNotFound());
    }


    @Test
    @DisplayName("should validate create abgabe request")
    void should_validate_create_person_request() throws Exception {
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
    @DisplayName("should return found abgaben from abgabeService")
    void should_return_found_abgaben_from_abgabeService() throws Exception {
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
                .andExpect(jsonPath("$[0].frist").value(abgaben.get(0).getFrist()))
                .andExpect(jsonPath("$[0].notificationMessage").value( "Hausarbeit"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].semester").value(3))
                .andExpect(jsonPath("$[1].modulName").value("WebTech"))
                .andExpect(jsonPath("$[1].frist").value(abgaben.get(1).getFrist()))
                .andExpect(jsonPath("$[1].notificationMessage").value( "Milestone 4"));
    }

    @Test
    @DisplayName("should return 201 http status and Location header when creating abgabe")
    void should_return_201_http_status_and_location_header_when_creating_a_person() throws Exception {
        // given
        String abgabeToCreateAsJson = "{\"semester\": \"4\", \"modulname\":\"Konfliktmanagement\", \"frist\":\"2022-12-15\", \"notificationMessage\": Hausarbeit}";
        var abgabe = new Abgabe(4, "Konfliktmanagement", LocalDate.of(2022, 12, 15), "Hausarbeit");
        doReturn(abgabe).when(abgabeService).create(any());

        // when
        mockMvc.perform(
                        post("/api/v1/abgaben")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(abgabeToCreateAsJson)
                )
                // then
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", Matchers.equalTo(("/api/v1/abgaben/" + abgabe.getId()))));


    }
     */
}
