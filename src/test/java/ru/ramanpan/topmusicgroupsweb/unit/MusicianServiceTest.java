package ru.ramanpan.topmusicgroupsweb.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.ramanpan.topmusicgroupsweb.dto.MusicianDTO;
import ru.ramanpan.topmusicgroupsweb.dto.TopDTO;
import ru.ramanpan.topmusicgroupsweb.model.Musician;
import ru.ramanpan.topmusicgroupsweb.model.Top;
import ru.ramanpan.topmusicgroupsweb.repositories.MusicianRepo;
import ru.ramanpan.topmusicgroupsweb.services.MusicianService;
import ru.ramanpan.topmusicgroupsweb.services.TopService;
import ru.ramanpan.topmusicgroupsweb.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MusicianServiceTest {
    @Autowired
    private MusicianService musicianService;
    @MockBean
    private MusicianRepo musicianRepo;
    @MockBean
    private TopService topService;
    @MockBean
    private ModelMapper modelMapper;

    @Test
    public void findAllByTopTest() {
        musicianService.findAllMusicianByTop(1L);
        Mockito.verify(topService,Mockito.times(1)).findTopById(1L);
    }

    @Test
    public void mapToDTOTest() {
        Musician musician = new Musician();
        musicianService.mappedToDTO(musician);
        Mockito.verify(modelMapper, Mockito.times(1)).map(musician, MusicianDTO.class);
    }

    @Test
    public void deleteTest() {
        musicianService.delete(1L);
        Mockito.verify(musicianRepo,Mockito.times(1)).deleteById(1L);
    }
}
