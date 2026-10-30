package edu.course.lab02;

public class ProjectTask {

    private final String id;
    private final String title;
    private TaskStatus status;
    private int estimatedHours;

    public ProjectTask(String id, String title, int estimatedHours) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID пустой");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title пустой");
        }
        if (estimatedHours <= 0) {
            throw new IllegalArgumentException("Оценка должна быть > 0");
        }

        this.id = id;
        this.title = title;
        this.estimatedHours = estimatedHours;
        this.status = TaskStatus.TODO;
    }

    public void changeStatus(TaskStatus newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException("Статус не может быть null");
        }
        this.status = newStatus;
    }

    public boolean isCompleted() {
        return this.status == TaskStatus.DONE;
    }

    public void increaseEstimate(int extraHours) {
        if (extraHours <= 0) {
            throw new IllegalArgumentException("Доп. часы должны быть > 0");
        }
        this.estimatedHours += extraHours;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public int getEstimatedHours() {
        return estimatedHours;
    }
}
