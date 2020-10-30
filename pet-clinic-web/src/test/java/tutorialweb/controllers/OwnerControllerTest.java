package tutorialweb.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tutorialweb.petweb.model.Owner;
import tutorialweb.petweb.model.Pet;
import tutorialweb.petweb.services.OwnerService;
//import tutorialweb.petweb.services.PetService;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;

   /* @Mock
    PetService petService;
    */
    @InjectMocks
    OwnerController ownerController;

    MockMvc mockMvc;

    Set<Owner> owners;
    @BeforeEach
    void setUp() {
        owners=new HashSet<>();
        Set<Pet> pets=new HashSet<>();
        Set<Pet> pets2=new HashSet<>();
        pets.add(Pet.builder().name("catty").build());
        pets2.add(Pet.builder().name("doggie").build());
        owners.add(Owner.builder().id(1L).pets(pets).build());
        owners.add(Owner.builder().id(1L).pets(pets2).build());

        mockMvc = MockMvcBuilders
                .standaloneSetup(ownerController)
                .build();
    }

    @Test
    void listOwners() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);
        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("prop",hasSize(2)));
    }
    @Test
    void listOwnersIndex() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);
        mockMvc.perform(get("/owners/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("prop",hasSize(2)));
    }

    @Test
    void findOwners() throws Exception {
        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("notimplemented"));
        verifyZeroInteractions(ownerService);
    }
}