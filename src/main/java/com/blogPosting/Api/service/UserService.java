package com.blogPosting.Api.service;

import com.blogPosting.Api.dto.UsersRequestDTO;
import com.blogPosting.Api.dto.UsersResponseDTO;
import com.blogPosting.Api.dto.mapper.UserMapper;
import com.blogPosting.Api.entity.Users;
import com.blogPosting.Api.repository.UsersRepository;

import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;


@Service
public class UserService {

    private final UsersRepository usersRepository;
    private final UserMapper userMapper;

    public UserService(UsersRepository usersRepository, UserMapper userMapper){
        this.usersRepository = usersRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    public UsersResponseDTO createUser(@NotNull UsersRequestDTO request) {
        // Procura o usuario no banco
        Users findUser = usersRepository.findUserByName(request.nickname());
        // 1. Verificar se o usuario existe
        // 3. Se nao, Cria o novo usuario.
            Users userEntity = userMapper.mapToUser(request);
            // 4. salva no banco
            Users savedUser = usersRepository.save(userEntity);
            // 5. Retorna mensagem de usuario criado
            return userMapper.mapToUserResponse(savedUser);
        // 2. Se tiver, informar usuario existente
    }
}