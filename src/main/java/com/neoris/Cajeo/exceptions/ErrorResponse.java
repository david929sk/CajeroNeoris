package com.neoris.Cajeo.exceptions;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "cliente")
public class ErrorResponse {

	private String message;
    private int status;
}
