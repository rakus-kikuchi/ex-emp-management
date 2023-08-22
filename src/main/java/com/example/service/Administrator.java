package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.repository.AdministratorRepository;

//管理者関連機能
@Service
@Transactional
public class Administrator {
    @Autowired
    private AdministratorRepository administratorRepository;
    
}
