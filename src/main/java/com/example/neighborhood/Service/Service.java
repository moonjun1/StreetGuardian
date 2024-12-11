package com.example.neighborhood.Service;

import com.example.neighborhood.Dto.RegisterDto;
import com.example.neighborhood.Entity.RegisterEntity;
import com.example.neighborhood.Repository.RegisterRepository;

@org.springframework.stereotype.Service
public class Service {
    private RegisterEntity registerEntity = new RegisterEntity();
    public boolean saveRegister(RegisterDto registerDto, RegisterEntity registerEntity, RegisterRepository registerRepository){
        this.registerEntity = registerEntity.inputDto(registerDto);
        try {
            registerRepository.save(registerEntity);
        } catch (Exception e){
            return false;
        }
        return true;
    }
}
