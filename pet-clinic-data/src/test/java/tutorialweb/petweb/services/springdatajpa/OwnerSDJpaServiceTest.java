package tutorialweb.petweb.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tutorialweb.petweb.model.Owner;
import tutorialweb.petweb.repositories.OwnerRepository;
import tutorialweb.petweb.repositories.PetRepository;
import tutorialweb.petweb.repositories.PetTypeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Hey";
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner=Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        Long id=1L;
        Owner owner=Owner.builder().id(id).lastName(LAST_NAME).build();
        when(ownerRepository.findByLastName(any())).thenReturn(owner);
        Owner smith= service.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME,smith.getLastName());
        verify(ownerRepository.findByLastName(any()));

        /*ownerRepository.save(owner);
        ownerRepository.findByLastName("Hey");
        assertEquals(ownerRepository.findById(1L),ownerRepository.findByLastName("Hey"));
        assertNotNull(ownerRepository.findByLastName("Hey"));*/
    }

    @Test
    void findAll() {
        Set<Owner> owners=new HashSet<>();
        owners.add(returnOwner);
        owners.add(Owner.builder().id(2L).build());
        when(service.findAll()).thenReturn(owners);
        Set<Owner> ownerSet=service.findAll();
        assertEquals(2,ownerSet.size());
        assertNotNull(ownerSet);
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
        Owner owner= service.findById(1L);
        assertNotNull(owner);

    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner= service.findById(1L);
        assertNull(owner);

    }

    @Test
    void save() {
        Owner ownerToSave= Owner.builder().id(2L).lastName("Mine").build();
        when(service.save(any())).thenReturn(ownerToSave);
        Owner savedOwner=service.save(ownerToSave);
        assertNotNull(savedOwner);
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(returnOwner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(ownerRepository).deleteById(1L);
    }
}