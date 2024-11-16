package com.example.meualuguel.services;

import com.example.meualuguel.dtos.user.UserCreateDTO;
import com.example.meualuguel.models.Profile;
import com.example.meualuguel.models.User;
import com.example.meualuguel.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                .orElseThrow(() -> new RuntimeException("profile not found"));
        User user = modelMapper.map(data, User.class);
        user.setIs_active(true);
        user.setProfile(profile);
        return userRepository.save(user);
    }
}
