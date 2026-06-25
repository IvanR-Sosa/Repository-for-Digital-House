package com.example.backendAdmin.repository;

import com.example.backendAdmin.entities.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin,Long> {

}
