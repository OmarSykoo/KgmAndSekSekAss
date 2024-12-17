package lms.project.Helpers.Builders;

public class NotificationBuilder {

    private final Notification notification = new Notification();

    public NotificationBuilder setUser(User user) {
        notification.setUser(user);
        return this;
    }

    public NotificationBuilder setSeen(boolean seen) {
        notification.setSeen(seen);
        return this;
    }

    public NotificationBuilder setName(String name) {
        notification.setName(name);
        return this;
    }

    public NotificationBuilder setContent(String content) {
        notification.setContent(content);
        return this;
    }

    public Notification build() {
        return notification;
    }
}
