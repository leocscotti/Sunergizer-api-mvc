package com.br.fiap.sunergizer.dto;

import com.br.fiap.sunergizer.models.UserRole;

public record RegisterDTO(String login, String senha, UserRole role) {
}
