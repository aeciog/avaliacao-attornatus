package com.attornatus.testetecnico.pessoasAPI.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MensagemResponseDTO {
    private String messagem;
}
