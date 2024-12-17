package lms.project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lms.project.Models.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
