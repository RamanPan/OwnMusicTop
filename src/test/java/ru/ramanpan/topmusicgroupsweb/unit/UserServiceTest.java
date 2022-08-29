package ru.ramanpan.topmusicgroupsweb.unit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import ru.ramanpan.topmusicgroupsweb.dto.UserDTO;
import ru.ramanpan.topmusicgroupsweb.model.User;
import ru.ramanpan.topmusicgroupsweb.repositories.UserRepo;
import ru.ramanpan.topmusicgroupsweb.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @MockBean
    private UserRepo userRepo;
    @MockBean
    private BCryptPasswordEncoder encoder;
    @MockBean
    private ModelMapper modelMapper;

    @Test
    public void registrationTest() {
        UserDTO userDTO = new UserDTO();
        String password = "qwerty";
        userDTO.setPassword(password);
        userService.registration(userDTO);
        Mockito.verify(encoder, Mockito.times(1)).encode(password);
    }

    @Test
    public void mapToDTOTest() {
        User user = new User();
        userService.mappedToDTO(user);
        Mockito.verify(modelMapper, Mockito.times(1)).map(user, UserDTO.class);
    }

    @Test
    public void addCounterCreatedTopsTest() {
        User user = new User();
        user.setCountCreatedTops(0);
        userService.incrementCountCreatedTops(user);
        Assert.assertEquals(1, (int) user.getCountCreatedTops());
        Mockito.verify(userRepo, Mockito.times(1)).save(user);
    }
}
