package dev.ardijorganxhi.pocketscore.model.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private String pocketName;
    private String email;
    private String password;
}
