package de.htwberlin.webtech.wiManager.service;

import de.htwberlin.webtech.wiManager.persistance.ModulRepository;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ModulServiceTest implements WithAssertions {

    @Mock
    private ModulRepository modulRepo;

    @InjectMocks
    private ModulService modulService;

    @Test
    @DisplayName("return true if delete was successful")
    void successfulDelete() {
        // given
        Long givenId = 77L;
        doReturn(true).when(modulRepo).existsById(givenId);

        // when
        boolean result = modulService.deleteById(givenId);

        // then
        verify(modulRepo).deleteById(givenId);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("return false if modul to delete does not exist")
    void deleteNotExistingModule() {
        // given
        Long givenId = 77L;
        doReturn(false).when(modulRepo).existsById(givenId);

        // when
        boolean result = modulService.deleteById(givenId);

        // then
        verifyNoMoreInteractions(modulRepo);
        assertThat(result).isFalse();
    }
}
