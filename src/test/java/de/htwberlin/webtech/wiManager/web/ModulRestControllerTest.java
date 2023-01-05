package de.htwberlin.webtech.wiManager.web;

import de.htwberlin.webtech.wiManager.service.ModulService;
import de.htwberlin.webtech.wiManager.web.api.Modul;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ModulRestController.class)
public class ModulRestControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ModulService modulService;

    @Test
    @DisplayName("should return found modul from modulService")
    void should_return_found_abgaben_from_abgabeService() throws Exception {
        // given
        var modules = List.of(
                new Modul(123, "Konfliktmanagement", 4, "WP", "PÜ", "2", 5, false, false),
                new Modul(124, "WebTech", 3, "P", "SL/PCÜ", "2/2", 5, false, false));
        doReturn(modules).when(modulService).findAll();


        // when
        mockMvc.perform(get("/api/v1/modules"))
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(123))
                .andExpect(jsonPath("$[0].modulName").value("Konfliktmanagement"))
                .andExpect(jsonPath("$[0].semester").value(4))
                .andExpect(jsonPath("$[0].art").value("WP"))
                .andExpect(jsonPath("$[0].form").value("PÜ"))
                .andExpect(jsonPath("$[0].sws").value("2"))
                .andExpect(jsonPath("$[0].lp").value(5))
                .andExpect(jsonPath("$[0].belegt").value(false))
                .andExpect(jsonPath("$[0].bestanden").value(false))

                .andExpect(jsonPath("$[1].id").value(124))
                .andExpect(jsonPath("$[1].modulName").value("WebTech"))
                .andExpect(jsonPath("$[1].semester").value(3))
                .andExpect(jsonPath("$[1].art").value("P"))
                .andExpect(jsonPath("$[1].form").value("SL/PCÜ"))
                .andExpect(jsonPath("$[1].sws").value("2/2"))
                .andExpect(jsonPath("$[1].lp").value(5))
                .andExpect(jsonPath("$[1].belegt").value(false))
                .andExpect(jsonPath("$[1].bestanden").value(false));
    }

    @Test
    @DisplayName("should return 404 if modul is not found")
    void should_return_404_if_modul_is_not_found() throws Exception {
        // given
        doReturn(null).when(modulService).findById(anyLong());

        // when
        mockMvc.perform(get("/api/v1/modules/123"))
                // then
                .andExpect(status().isNotFound());
    }

    /*
    @Test
    @DisplayName("should return 201 http status and Location header when creating modul")
    void should_return_201_http_status_and_location_header_when_creating_modul() throws Exception {
        // given
        String abgabeToCreateAsJson = "{\"semester\": \"4\", \"modulname\":\"Konfliktmanagement\", \"art\":\"WP\", \"form\":\" PÜ\", \"sws\":\"2\", \"lp\":\"5\", \"belegt\":\"false\", \"bestanden\":\"false}";
        var modul = new Modul(123, "Konfliktmanagement", 4, "WP", "PÜ", "2", 5, false, false);
        doReturn(modul).when(modulService).create(any());

        // when
        mockMvc.perform(
                        post("/api/v1/modules")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(abgabeToCreateAsJson)
                )
                // then
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", Matchers.equalTo(("/api/v1/modules/" + modul.getId()))));

    }
     */

    @Test
    @DisplayName("should validate create modul request")
    void should_validate_create_modul_request() throws Exception {
        // given
        String personToCreateAsJson = "{\"semester\": \"4\", \"modulname\":\"Konfliktmanagement\", \"frist\":\"2022-12-15\", \"notificationMessage\": Hausarbeit}";;

        // when
        mockMvc.perform(
                        post("/api/v1/modules")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(personToCreateAsJson)
                )
                // then
                .andExpect(status().isBadRequest());
    }
}
