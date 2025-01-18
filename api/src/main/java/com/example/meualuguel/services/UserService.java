package com.example.meualuguel.services;

import com.example.meualuguel.dtos.user.UserCreateDTO;
import com.example.meualuguel.models.Profile;
import com.example.meualuguel.models.User;
import com.example.meualuguel.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService extends AbstractService<User, Long> {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProfileService profileService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository) {
        super(userRepository);
    }
    public User save(UserCreateDTO data) {
        Profile profile = profileService.findById(data.getProfile_id())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Profile não encontrado."));

        User user = modelMapper.map(data, User.class);
        user.setIs_active(true);
        user.setProfile(profile);
        try {
            return userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe um usuário com esse registry.");
        }
    }
}
