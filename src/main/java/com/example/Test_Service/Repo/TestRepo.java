package com.example.Test_Service.Repo;

import com.example.Test_Service.Entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepo extends JpaRepository<Test,Long> {

}
