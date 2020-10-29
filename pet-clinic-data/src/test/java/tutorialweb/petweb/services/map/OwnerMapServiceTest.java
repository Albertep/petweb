package tutorialweb.petweb.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tutorialweb.petweb.model.Owner;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    final Long ownerId=1L;
    @BeforeEach
    void setUp() {
        ownerMapService= new OwnerMapService(new PetTypeMapService(),new PetMapService());
        ownerMapService.save(Owner.builder().id(ownerId).lastName("Smith").build());
    }

    @Test
    void findAll() {
        ownerMapService.save(Owner.builder().id(2L).build());
        assertEquals(2,ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);
        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void findById() {
        Owner own=ownerMapService.findById(ownerId);
        assertEquals(ownerId,ownerMapService.findById(ownerId).getId());
    }

    @Test
    void saveExistingId() {
        Long id =2L;
        ownerMapService.save(Owner.builder().id(id).build());
        assertNotNull(ownerMapService.findById(id));
        assertEquals(id,ownerMapService.findById(id).getId());
    }

    @Test
    void saveWithoutId() {
        Owner own=Owner.builder().build();
        ownerMapService.save(own);
        assertEquals(2,ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        assertEquals(ownerMapService.findById(ownerId),ownerMapService.findByLastName("Smith"));
    }
}