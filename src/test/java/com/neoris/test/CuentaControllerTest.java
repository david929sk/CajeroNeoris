package com.neoris.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neoris.Cajero.controller.CuentaController;
import com.neoris.Cajero.entity.Cuenta;
import com.neoris.Cajero.service.CuentaService;

@ExtendWith(MockitoExtension.class)
public class CuentaControllerTest {
    private MockMvc mockMvc;

    @Mock
    private CuentaService cuentaService;

    @InjectMocks
    private CuentaController cuentaController;

    @Test
    public void testGetAllCuentas() throws Exception {
        List<Cuenta> cuentas = new ArrayList<>();
        cuentas.add(new Cuenta(1L, "1234567890", "1234", 1000.0, "Activo", 1L));
        cuentas.add(new Cuenta(2L, "0987654321", "5678", 2000.0, "Activo", 2L));
        when(cuentaService.getAllCuentas()).thenReturn(cuentas);

        mockMvc = MockMvcBuilders.standaloneSetup(cuentaController).build();

        mockMvc.perform(get("/cuentas/all"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"numero\":\"1234567890\",\"valor\":\"1234\",\"saldo\":1000.0},{\"id\":2,\"numero\":\"0987654321\",\"pin\":\"5678\",\"saldo\":2000.0}]"));
    }

    @Test
    public void testGetCuentaById() throws Exception {
        Long id = 1L;
        Cuenta cuenta = new Cuenta(1L, "1234567890", "1234", 1000.0, "Activo", 1L);
        when(cuentaService.getCuentaById(id)).thenReturn(cuenta);

        mockMvc = MockMvcBuilders.standaloneSetup(cuentaController).build();

        mockMvc.perform(get("/cuentas/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"numero\":\"1234567890\",\"valor\":\"1234\",\"saldo\":1000.0}"));
    }

    @Test
    public void testCreateCuenta() throws Exception {
        Cuenta cuenta = new Cuenta(1L, "1234567890", "1234", 1000.0, "Activo", 1L);
        Cuenta cuentaSaved = new Cuenta(1L, "1234567890", "1234", 1000.0, "Activo", 1L);
        when(cuentaService.createCuenta(cuenta)).thenReturn(cuentaSaved);

        mockMvc = MockMvcBuilders.standaloneSetup(cuentaController).build();

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(cuenta);

        mockMvc.perform(post("/cuentas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"numero\":\"1234567890\",\"valor\":\"1234\",\"saldo\":1000.0}"));
    }
}