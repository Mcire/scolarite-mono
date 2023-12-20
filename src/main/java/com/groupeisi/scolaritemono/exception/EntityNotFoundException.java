package com.groupeisi.scolaritemono.exception;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntityNotFoundException extends  RuntimeException{
    String message;
}

