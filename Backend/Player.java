import java.util.Random;
import Exceptions.ItemDoesNotCorrespondException;

public class Player {

    protected Pokemon[] team = new Pokemon[4];
    protected Bag bag;

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

        team = generateRandomPokemon();
        while (team[0].equals(team[1]) || team[0].equals(team[2]) || team[0].equals(team[3]) || team[1].equals(team[2]) || team[1].equals(team[3]) || team[2].equals(team[3])) {
            team = generateRandomPokemon();
        }
    }


    private Pokemon[] generateRandomPokemon() {
        Pokemon[] pokemons = Pokemon.generatePokemons();
        Random generator = new Random();
        Pokemon[] t = new Pokemon[4];

        for (int i = 0; i < 4; i++) {
            t[i] = pokemons[generator.nextInt(151)];
        }

        return t;
    }

    public boolean hasItem(Item e) {
        for (Item z : bag.getItems()) {
            if (z.equals(e)) {
                return true;
            }
         }
         return false;
    }


    public int totalDamage(Pokemon attack, Pokemon defense, Move m) {
        Multiplier e = new Multiplier();
        double damage = (2 * m.getPower() * ((attack.getAttack()/defense.getDefense())/50) + 2) * e.getMultiplier(attack, defense) * 5;
        int damageInt = (int) Math.round(damage);
        return damageInt;
    }

    public boolean doesMoveInflictStatus(Move e) {
        Status[] t = Status.generateStatus();

        for (Status x : t) {
            if (e.equals(x.getMove())) {
                return true;
            }
        }

        return false;

    } 


    public void inflictStatus(Move e, Pokemon defense) {
        Random generator = new Random();
        Status[] t = Status.generateStatus();

        for (Status x : t) {
            int randomNum = generator.nextInt(4);
            if (e.equals(x.getMove())) {
                if (randomNum == 0) {
                    defense.setStatus(x);
                } else {
                    break;
                }
            } else {
                continue;
            }
        }

    }



    public void useItem(Pokemon p, Item e) throws ItemDoesNotCorrespondException {
        if (e.equals(p.getStatus()) || e.getName().equals("Full Heal")) {
            bag.removeItem(e);
            p.setStatus(new Status("None"));
        } else {
            throw new ItemDoesNotCorrespondException();
        }
    } 

    public void attack(Pokemon attack, Pokemon defense, Move m) {
        int damageInt = totalDamage(attack, defense, m);
        defense.setHp(defense.getHp() - damageInt);
        if (doesMoveInflictStatus(m)) {
            inflictStatus(m, defense);
        }
    }
    
    

    public static void main(String[] args) {
        Player p = new Player();
        Player t = new Player();
        System.out.println(String.valueOf(p.totalDamage(p.getTeam()[0], t.getTeam()[0], p.getTeam()[0].getMoves()[0])));
        for (int i = 0; i < 4; i++) {
            System.out.println(String.valueOf(p.totalDamage(p.getTeam()[i], t.getTeam()[i], p.getTeam()[i].getMoves()[i])));
        }
        
    }

}
