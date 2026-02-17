package com.blogPosting.Api;

import com.blogPosting.Api.dto.UsersRequestDTO;
import com.blogPosting.Api.dto.UsersResponseDTO;
import com.blogPosting.Api.entity.Users;
import com.blogPosting.Api.dto.mapper.UserMapper;
import com.blogPosting.Api.repository.UsersRepository;
import com.blogPosting.Api.service.UserService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UserServiceTest {


    @Mock
    private UsersRepository usersRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    @Test
    void userCreationTest(){
        UsersRequestDTO dto = new UsersRequestDTO(1L, "joao", "joao@mail.com", "123456");

        Users newUser = new Users();
        newUser.setId(1L);
        newUser.setNickname("joao");
        newUser.setEmail("joao@mail");

        UsersResponseDTO responseDTO = new UsersResponseDTO("joao", "joao@mail.com");

        when(usersRepository.findUserByNickname(dto.nickname())).thenReturn(Optional.of(newUser));
        when(usersRepository.findByEmail(dto.email())).thenReturn(Optional.of(newUser));

        when(userMapper.mapToUser(dto)).thenReturn(newUser);

        when(usersRepository.save(any(Users.class))).thenReturn(newUser);
        when(userMapper.mapToUserResponse(newUser)).thenReturn(responseDTO);

        UsersResponseDTO response = userService.createUser(dto);

        assertNotNull(response);
        assertEquals("joao", newUser.getNickname());

        verify(usersRepository, times(1)).save(any(Users.class));


    }
}
