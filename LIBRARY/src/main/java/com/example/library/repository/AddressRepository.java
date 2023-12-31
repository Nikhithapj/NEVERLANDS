package com.example.library.repository;

import com.example.library.model.Address;
import com.example.library.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends JpaRepository<Address,Long> {
    Address findById(long id);


  //  @Query(value = "SELECT * FROM addresses WHERE is_default=true AND customer_id=:id",nativeQuery = true)

       @Query(value = "SELECT * FROM addresses WHERE is_default=true AND customer_id=:id",nativeQuery = true)
       Address findByActivatedTrue(@Param("id") long id);


    @Query("SELECT a FROM Address a WHERE a.customer = :customer AND a.is_default = true")
    Address findDefaultAddressByCustomer(@Param("customer") Customer customer);
}
