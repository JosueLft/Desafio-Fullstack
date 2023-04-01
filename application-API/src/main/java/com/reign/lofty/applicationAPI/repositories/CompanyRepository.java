package com.reign.lofty.applicationAPI.repositories;

import com.reign.lofty.applicationAPI.entities.Company;
import com.reign.lofty.applicationAPI.entities.suppliers.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String> {}