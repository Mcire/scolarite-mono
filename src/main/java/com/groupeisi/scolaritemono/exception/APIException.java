package com.groupeisi.scolaritemono.exception;

import lombok.*;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class APIException {
    String message;
    HttpStatus status;
    LocalDateTime timestamp;
}

