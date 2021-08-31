package kg.itschool.demo.dao;

import kg.itschool.demo.entity.Plane;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneDAO {
    void addPlane(Plane plane);
}
