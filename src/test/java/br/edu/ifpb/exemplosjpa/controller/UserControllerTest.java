package br.edu.ifpb.exemplosjpa.controller;

import br.edu.ifpb.exemplosjpa.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import br.edu.ifpb.exemplosjpa.model.User;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;



class UserControllerTest {
    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void testCreateUser() {
        User user = new User(1L, "Karlos", "Paulino", "karlos@gmail.com", "981672201", "111.111.111-11", LocalDate.of(2004,10,13));

        when(userService.create(any(User.class))).thenReturn(user);

        ResponseEntity<User> response = userController.create(user);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(user, response.getBody());
    }

    @Test
    void testGetAll() throws Exception {

        List<User> users = Arrays.asList(
                new User(1L, "Karlos", "Paulino", "karlos@gmail.com", "981672201", "111.111.111-11", LocalDate.of(2004, 10, 13)),
                new User(2L, "Maria", "Silva", "maria@gmail.com", "981672202", "222.222.222-22", LocalDate.of(1998, 5, 21))
        );

        when(userService.getAll()).thenReturn(users);

        mockMvc.perform(get("/user")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(users.size()))
                .andExpect(jsonPath("$[0].firstName").value("Karlos"))
                .andExpect(jsonPath("$[1].firstName").value("Maria"));
    }
}
