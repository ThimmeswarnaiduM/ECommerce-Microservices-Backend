package e_Commerce_project.Notification.Records;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CustomerResponse(
        @JsonProperty("_id") String id,
        String firstName,
        @JsonProperty("lastName") String lastName,
        String email,
        String password,
        String phoneNumber,
        int age

) {}
