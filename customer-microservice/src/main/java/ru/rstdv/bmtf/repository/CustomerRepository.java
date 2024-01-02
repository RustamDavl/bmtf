package ru.rstdv.bmtf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rstdv.bmtf.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
