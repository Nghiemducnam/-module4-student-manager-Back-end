package com.codegym.services.impl;

import com.codegym.models.Clazz;
import com.codegym.repositories.ClassRepository;
import com.codegym.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassRepository classRepository;
    @Override
    public List<Clazz> findAllClass() {
        return classRepository.findAll();
    }

    @Override
    public Optional<Clazz> findByClassId(Long id) {
        return classRepository.findById(id);
    }

    @Override
    public Clazz saveClass(Clazz clazz) {
        return classRepository.save(clazz);
    }

    @Override
    public void removeClass(Long id) {
        classRepository.deleteById(id);
    }
}