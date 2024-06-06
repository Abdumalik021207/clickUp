package org.example.clickup.repository;

import org.example.clickup.model.Attachmet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepo extends JpaRepository<Attachmet,Integer> {
}
