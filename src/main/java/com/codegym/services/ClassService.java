package com.codegym.services;

import com.codegym.models.Clazz;
import java.util.List;
import java.util.Optional;

public interface ClassService {
    List<Clazz> findAllClass();
    Optional<Clazz> findByClassId(Long id);
    Clazz saveClass(Clazz clazz);
    void removeClass(Long id);
}
