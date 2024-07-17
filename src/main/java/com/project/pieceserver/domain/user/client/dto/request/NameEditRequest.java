package com.project.pieceserver.domain.user.client.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NameEditRequest {

    @NotBlank
    private String name;
}
