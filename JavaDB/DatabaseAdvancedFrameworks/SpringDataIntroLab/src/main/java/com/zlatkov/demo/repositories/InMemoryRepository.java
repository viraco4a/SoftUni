package com.zlatkov.demo.repositories;

import com.zlatkov.demo.repositories.base.DataRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryRepository implements DataRepository {
    @Override
    public List<String> list() {
        return List.of("John", "Jane", "Pesho");
    }
}
