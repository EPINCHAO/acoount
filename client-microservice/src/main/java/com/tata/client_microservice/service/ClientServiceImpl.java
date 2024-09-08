package com.tata.client_microservice.service;

import com.tata.client_microservice.entity.Client;
import com.tata.client_microservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Long id, Client clientDetails) {
        Optional<Client> clientOptional = clientRepository.findById(id);

        if (clientOptional.isPresent()) {
            Client existingClient = clientOptional.get();
            // Actualizamos los campos del cliente
            existingClient.setName(clientDetails.getName());
            existingClient.setGender(clientDetails.getGender());
            existingClient.setAge(clientDetails.getAge());
            existingClient.setIdentification(clientDetails.getIdentification());
            existingClient.setAddress(clientDetails.getAddress());
            existingClient.setPhone(clientDetails.getPhone());
            existingClient.setPassword(clientDetails.getPassword());
            existingClient.setStatus(clientDetails.getStatus());

            // Guardamos el cliente actualizado
            return clientRepository.save(existingClient);
        }

        return null;
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
