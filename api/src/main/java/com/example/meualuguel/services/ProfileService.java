package com.example.meualuguel.services;

import com.example.meualuguel.models.Profile;
import com.example.meualuguel.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService extends AbstractService<Profile, Long> {

    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        super(profileRepository);
    }
}

