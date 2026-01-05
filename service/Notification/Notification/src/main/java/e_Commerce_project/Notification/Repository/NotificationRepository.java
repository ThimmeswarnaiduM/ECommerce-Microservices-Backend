package e_Commerce_project.Notification.Repository;

import e_Commerce_project.Notification.Entity.Notification;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification, String> {
}
