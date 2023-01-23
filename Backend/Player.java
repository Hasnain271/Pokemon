import java.util.Random;
import Exceptions.DoNotHaveItemException;
import Exceptions.ItemDoesNotCorrespondException;

public class Player {

    private Pokemon[] team = new Pokemon[4];
    private Bag bag;

    public Player() {
        bag = new Bag();
        generateTeam();
    }


    public Pokemon[] getTeam() {
        return team;
    }

    public Bag getBag() {
        return bag;
    }


    public void generateTeam() {

        generateRandomPokemon();
        while (team[0].equals(team[1]) || team[0].equals(team[2]) || team[0].equals(team[3]) || team[1].equals(team[2]) || team[1].equals(team[3]) || team[2].equals(team[3])) {
            generateRandomPokemon();
        }
    }


    private void generateRandomPokemon() {
        Pokemon[] pokemons = Pokemon.generatePokemons();
        Random generator = new Random();

        for (int i = 0; i < 4; i++) {
            team[i] = pokemons[generator.nextInt(152)];
        }

    }

    public boolean hasItem(Item e) {
        for (Item z : bag.getItems()) {
            if (z.equals(e)) {
                return true;
            }
         }
         return false;
    }




    public void useItem(Pokemon p, Item e) throws DoNotHaveItemException, ItemDoesNotCorrespondException {
        if (hasItem(e)) {
            if (e.equals(p.getStatus()) || e.getName().equals("Full Heal")) {
                bag.removeItem(e);
                p.setStatus(new Status("None"));
            } else {
                throw new ItemDoesNotCorrespondException();
            }
        } else {
            throw new DoNotHaveItemException();
        }
    }


    public void attack() {
        Multiplier e = new Multiplier();
        
    }

        

}
