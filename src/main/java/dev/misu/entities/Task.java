package dev.misu.entities;

import com.google.gson.annotations.SerializedName;
import dev.misu.entities.enums.Status;

import java.sql.Timestamp;

public class Task {

    private static int count = 1;

    @SerializedName("id")
    private int id;

    @SerializedName("description")
    private String description;

    @SerializedName("status")
    private Status status;

    @SerializedName("created_at")
    private Timestamp createdAt;

    @SerializedName("updated_at")
    private Timestamp updatedAt;

    public Task(String description) {
        this.status = Status.TODO;
        this.description = description;
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "Task { id: " + id +
                ", description: '" + description + '\'' +
                ", status: " + status +
                ", createdAt: " + createdAt +
                ", updatedAt: " + updatedAt +
                " }";
    }

}
