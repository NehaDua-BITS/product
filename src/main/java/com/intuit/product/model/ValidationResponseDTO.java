package com.intuit.product.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ValidationResponseDTO {

    private ValidationResponse validationResponse;

    private ErrorResponse error;

}
