package be.iccbxl.pid.reservationsspringboot.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import be.iccbxl.pid.reservationsspringboot.model.Type;
import be.iccbxl.pid.reservationsspringboot.repository.TypeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeService {
    @Autowired
    private TypeRepository repository;

    public List<Type> getAll() {
        List<Type> types = new ArrayList<>();

        repository.findAll().forEach(types::add);

        return types;
    }

    public Type getType(String id) {
        Long indice = (long) Integer.parseInt(id);

        Optional<Type> type = repository.findById(indice);

        return type.isPresent() ? type.get() : null;
    }

    public void addType(Type type) {
        repository.save(type);
    }

    public void updateType(String id, Type type) {
        repository.save(type);
    }

    public void deleteType(String id) {
        Long indice = (long) Integer.parseInt(id);

        repository.deleteById(indice);
    }
}
