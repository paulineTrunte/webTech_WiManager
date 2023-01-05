package de.htwberlin.webtech.wiManager.service;

import de.htwberlin.webtech.wiManager.persistance.AbgabeRepository;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AbgabeServiceTest implements WithAssertions {
    @Mock
    private AbgabeRepository abgabeRepo;

    @InjectMocks
    private AbgabeService abgabeService;

    @Test
    @DisplayName("return true if delete was successful")
    void successfulDelete() {
        // given
        Long givenId = 111L;
        doReturn(true).when(abgabeRepo).existsById(givenId);

        // when
        boolean result = abgabeService.deleteById(givenId);

        // then
        verify(abgabeRepo).deleteById(givenId);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("return false if abgabe to delete does not exist")
    void deleteNotExistingAbgabe() {
        // given
        Long givenId = 111L;
        doReturn(false).when(abgabeRepo).existsById(givenId);

        // when
        boolean result = abgabeService.deleteById(givenId);

        // then
        verifyNoMoreInteractions(abgabeRepo);
        assertThat(result).isFalse();
    }

}
