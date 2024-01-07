package ru.rstdv.bmtf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rstdv.bmtf.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
