package ru.ramanpan.topmusicgroupsweb.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.ramanpan.topmusicgroupsweb.dto.SongDTO;
import ru.ramanpan.topmusicgroupsweb.model.Song;
import ru.ramanpan.topmusicgroupsweb.repositories.SongRepo;
import ru.ramanpan.topmusicgroupsweb.services.SongService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SongServiceTest {
    @Autowired
    private SongService songService;
    @MockBean
    private SongRepo songRepo;
    @MockBean
    private ModelMapper modelMapper;

    @Test
    public void findSongsByAlbumTest() {
        String album = "Pretty Hate Machine";
        songService.findSongsByAlbum(album);
        Mockito.verify(songRepo, Mockito.times(1)).findAllByAlbum(album);
    }

    @Test
    public void findSongsByGroupTest() {
        String group = "Nine inch Nails";
        songService.findSongsByGroup(group);
        Mockito.verify(songRepo, Mockito.times(1)).findAllByAuthor(group);
    }

    @Test
    public void mapToDTOTest() {
        Song song = new Song();
        songService.mappedToDTO(song);
        Mockito.verify(modelMapper, Mockito.times(1)).map(song, SongDTO.class);
    }

    @Test
    public void deleteTest() {
        Long id = 1L;
        songService.delete(id);
        Mockito.verify(songRepo, Mockito.times(1)).deleteById(id);
    }
}
