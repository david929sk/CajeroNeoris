package com.neoris.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.neoris.Cajero.controller.ClienteController;
import com.neoris.Cajero.entity.Cliente;
import com.neoris.Cajero.service.ClienteService;

@SpringBootTest
public class ClienteControllerTest {


    @InjectMocks
    private ClienteController clienteController;

    @Mock
    private ClienteService clienteService;

    @Test
    public void testGetClienteById() {
        Long id = 1L;
        Cliente cliente = new Cliente();
        cliente.setId(id);
        when(clienteService.getClienteById(id)).thenReturn(cliente);
        ResponseEntity<Cliente> responseEntity = clienteController.getClienteById(id);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(cliente, responseEntity.getBody());
    }
    
    @Test
    public void testUpdateCliente() {
        Long id = 1L;
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setContrasena("contrasena");
        cliente.setEstado("estado");
        when(clienteService.updateCliente(id, cliente)).thenReturn(cliente);
        ResponseEntity<Cliente> responseEntity = clienteController.updateCliente(id, cliente);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(cliente, responseEntity.getBody());
    }
    
    @Test
    public void testCreateCliente() {
        Cliente cliente = new Cliente();
        cliente.setContrasena("contrasena");
        cliente.setEstado("estado");
        when(clienteService.createCliente(cliente)).thenReturn(cliente);
        ResponseEntity<Cliente> responseEntity = clienteController.createCliente(cliente);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(cliente, responseEntity.getBody());
    }
}
