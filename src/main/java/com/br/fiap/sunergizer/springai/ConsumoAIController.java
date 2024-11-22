package com.br.fiap.sunergizer.springai;

import com.br.fiap.sunergizer.dto.ConsumoResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/springai/consumo")
@Tag(name = "Consumo - Spring AI")
public class ConsumoAIController {

    private final SpringAIChatService chatService;

    public ConsumoAIController(SpringAIChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/analise")
    public ResponseEntity<Map<String, String>> analisarConsumo(
            @RequestParam(value = "kwh", defaultValue = "0") Double kwhConsumidos) {

        ConsumoResponse consumo = new ConsumoResponse();
        consumo.setKwhConsumidos(kwhConsumidos);
        String message = gerarMensagemDeEntrada(consumo);
        String sugestoes = chatService.run(message);

        return new ResponseEntity<>(Map.of(
                "kwhConsumidos", String.valueOf(kwhConsumidos),
                "sugestoes", sugestoes
        ), HttpStatus.OK);
    }

    private String gerarMensagemDeEntrada(ConsumoResponse consumo) {
        return "Consumo de energia identificado: " + consumo.getKwhConsumidos() +
                " kWh. Sugira formas de otimizar o consumo de energia para reduzir custos.";
    }
}

