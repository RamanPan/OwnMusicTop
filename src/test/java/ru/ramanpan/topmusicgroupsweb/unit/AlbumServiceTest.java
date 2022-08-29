package ru.ramanpan.topmusicgroupsweb.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.ramanpan.topmusicgroupsweb.dto.AlbumDTO;
import ru.ramanpan.topmusicgroupsweb.model.Album;
import ru.ramanpan.topmusicgroupsweb.repositories.AlbumRepo;
import ru.ramanpan.topmusicgroupsweb.services.AlbumService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlbumServiceTest {
    @Autowired
    private AlbumService albumService;
    @MockBean
    private AlbumRepo albumRepo;
    @MockBean
    private ModelMapper modelMapper;

    @Test
    public void findAlbumsByGroupTest() {
        String group = "Disturbed";
        albumService.findAlbumsByGroup(group);
        Mockito.verify(albumRepo, Mockito.times(1)).findAllByMusicGroup(group);
    }

    @Test
    public void mapToDTOTest() {
        Album album = new Album();
        albumService.mappedToDTO(album);
        Mockito.verify(modelMapper, Mockito.times(1)).map(album, AlbumDTO.class);
    }

    @Test
    public void deleteTest() {
        Long id = 1L;
        albumService.delete(id);
        Mockito.verify(albumRepo, Mockito.times(1)).deleteById(id);
    }
}
