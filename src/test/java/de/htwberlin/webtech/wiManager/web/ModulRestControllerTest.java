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
    @DisplayName("returns found modules from modulService")
    void foundModules() throws Exception {
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
    @DisplayName("returns 404 if module is not found")
    void moduleNotFound() throws Exception {
        // given
        doReturn(null).when(modulService).findById(anyLong());

        // when
        mockMvc.perform(get("/api/v1/modules/123"))
                // then
                .andExpect(status().isNotFound());
    }


    @Test
    @DisplayName("validates create modul request")
    void validatesModulRequest() throws Exception {
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
