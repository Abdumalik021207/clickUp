package org.example.clickup.repository;

import org.example.clickup.model.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkspaceRepo extends JpaRepository<Workspace, Long> {
    boolean existsByName(String name);
}
