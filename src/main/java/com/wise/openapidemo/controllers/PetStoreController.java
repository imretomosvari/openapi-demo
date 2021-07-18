package com.wise.openapidemo.controllers;

import com.wise.openapidemo.petstore.api.PetApi;
import com.wise.openapidemo.petstore.model.Pet;
import com.wise.openapidemo.service.UuidService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PetStoreController implements PetApi {

    private final UuidService uuidService;


    @Override
    public ResponseEntity<Pet> getPetById(Long petId) {
        log.info("FOUND");

        var foundPet = new Pet();
        foundPet.setId(1L);
        foundPet.setName("Beethoven");

        return ResponseEntity.ok(foundPet);
    }

    @Override
    public ResponseEntity<Pet> addPet(Pet pet) {
        log.info("CREATED");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deletePet(Long petId, String apiKey) {
        log.info("DELETED");
        List<String> uuids = uuidService.getUuids();
        for (String uuid : uuids) {
            log.info(uuid);
        }

        return ResponseEntity.ok().build();
    }
}
