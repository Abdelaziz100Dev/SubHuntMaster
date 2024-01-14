package com.subhuntmaster.services;

import com.subhuntmaster.domain.Competition;
import com.subhuntmaster.dto.CompetitionDto;
import com.subhuntmaster.repositories.CompetitionRepository;
import com.subhuntmaster.services.interfaces.CompetitionService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CompetitionServImplTest {

    @InjectMocks
    private CompetitionService competitionService;

    @Mock
    private CompetitionRepository competitionRepository;



    @Test
    public void testSaveCompetition() {

        Competition competition = new Competition();
        competition.setId(1L);
        competition.setCode("COMP001");

        // Mock the repository
        when(competitionRepository.save(any())).thenReturn(competition);

        // Invoke the service method
        CompetitionDto savedCompetitionDto = competitionService.save(competition);

        // Verify that the repository method was called
        verify(competitionRepository, times(1)).save(any());

        // Assert the result
        assertNotNull(savedCompetitionDto);
        assertEquals(1L, savedCompetitionDto.getId());
        assertEquals("COMP001", savedCompetitionDto.getCode());
    }
}