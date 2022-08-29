package ru.ramanpan.topmusicgroupsweb.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.ramanpan.topmusicgroupsweb.dto.TopDTO;
import ru.ramanpan.topmusicgroupsweb.model.Top;
import ru.ramanpan.topmusicgroupsweb.repositories.TopRepo;
import ru.ramanpan.topmusicgroupsweb.services.TopService;
import ru.ramanpan.topmusicgroupsweb.services.UserService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TopServiceTest {
    @Autowired
    private TopService topService;
    @MockBean
    private TopRepo topRepo;
    @MockBean
    private UserService userService;
    @MockBean
    private ModelMapper modelMapper;

    @Test
    public void saveTest() {
        TopDTO topDTO = new TopDTO();
        Long id = 1L;
        topDTO.setUserId(id);
        topService.save(topDTO);
        Mockito.verify(userService, Mockito.times(1)).findById(id);
    }

    @Test
    public void findTopsByAuthorTest() {
        String author = "Roman";
        topService.findTopsByAuthor(author);
        Mockito.verify(topRepo, Mockito.times(1)).findAllByAuthor(author);
    }

    @Test
    public void mapToDTOTest() {
        Top top = new Top();
        topService.mappedToDTO(top);
        Mockito.verify(modelMapper, Mockito.times(1)).map(top, TopDTO.class);
    }
}
