package org.example.clickup.repository;

import org.example.clickup.model.Space;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpaceRepo extends JpaRepository<Space, Integer> {
}
