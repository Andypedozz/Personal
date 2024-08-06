package test.menu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import model.menu.Lobby;

public class TestLobby {

    private Lobby lobby;
    
    @Test
    public void testSelectPokemon() {
        lobby = Lobby.getInstance();
        System.out.println("---- TEST SELECT POKEMON ----");
        assertNull(lobby.getSelected());
        lobby.selectPokemon("Swampert");
        assertNotNull(lobby.getSelected());
    }
    
    @Test
    public void testGetSelected() {
        lobby = Lobby.getInstance();
        System.out.println("---- TEST GET SELECTED ----");
        
    }
    
    @Test
    public void testRemovePokemon() {
        lobby = Lobby.getInstance();
        System.out.println("---- TEST REMOVE POKEMON ----");
    }
    
    @Test
    public void testSelectFromTeam() {
        lobby = Lobby.getInstance();
        System.out.println("---- TEST SELECT FROM TEAM ----");
    }
    
    @Test
    public void testAddPokemon() {
        lobby = Lobby.getInstance();
        System.out.println("---- TEST ADD POKEMON ----");
        lobby.selectPokemon("Swampert");
        assertEquals(lobby.getSelected(),lobby.getPokedex().getPokemon("Swampert"));
        assertEquals(lobby.addPokemon(0),0);
        lobby.selectPokemon("Blaziken");
        assertEquals(lobby.getSelected(),lobby.getPokedex().getPokemon("Blaziken"));
        assertEquals(lobby.addPokemon(0),1);
        lobby.selectPokemon("Salamence");
        assertEquals(lobby.getSelected(),lobby.getPokedex().getPokemon("Salamence"));
        assertEquals(lobby.addPokemon(0),2);
        lobby.selectPokemon("Metagross");
        assertEquals(lobby.getSelected(),lobby.getPokedex().getPokemon("Metagross"));
        assertEquals(lobby.addPokemon(0),-2);
        lobby.deselect();
        assertEquals(lobby.addPokemon(1),-1);
        lobby.selectPokemon("Blaziken");
        lobby.removePokemon(0);
        assertEquals(lobby.addPokemon(0),-3);

    }

    @Test
    public void testDeselect() {
        lobby = Lobby.getInstance();
        System.out.println("---- TEST DESELECT ----");
    }

    


}
