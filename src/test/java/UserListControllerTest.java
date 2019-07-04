import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import springboot.controller.UserListController;
import springboot.entity.User;
import springboot.service.UserService;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserListControllerTest {
    @Mock
    private UserService userService;
    @InjectMocks
    UserListController sut;

    @Test
    public void testGetListOfUsers() throws Exception {
        when(userService.findAll()).thenReturn(ImmutableList.of());

        List<User> users = sut.getListOfUsers();

        verify(userService).findAll();
    }
}
