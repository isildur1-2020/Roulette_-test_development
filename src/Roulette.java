import java.util.ArrayList;
public class Roulette {
    private final double id;
    private ArrayList<Bet> bets = new ArrayList<>();
    private double finalNumber;
    public Roulette(double id) {
        this.id = id;
    }
    public String betNumber(int idUser, int chosenNumber, double quantity) {
        if(quantity > 10000) {
            return "La apuesta máxima es de 10.000 dólares";
        }
        if(chosenNumber<0 || chosenNumber>36) {
            if(chosenNumber==40 || chosenNumber==41) {
                Bet bet = new Bet(idUser, chosenNumber, quantity);
                bets.add(bet);
                return "Apuesta realizada con éxito";
            }
            return "Ingresa un número del 0 al 36";
        }
        Bet bet = new Bet(idUser, chosenNumber, quantity);
        bets.add(bet);
        return "Apuesta realizada con éxito";
    }
    public void closeBets() {
        winningNumber();
        System.out.println("Número ganador "+finalNumber);
        for(Bet i: bets) {
            if(i.getChosenNumber() == finalNumber) {
                System.out.println(i.showData(5*i.getQuantity()));
            }else if(i.getChosenNumber()==40 && finalNumber%2==0) {
                System.out.println(i.showData(1.8*i.getQuantity()));
            }else if(i.getChosenNumber()==41 && finalNumber%2!=0) {
                System.out.println(i.showData(1.8*i.getQuantity()));
            }else {
                System.out.println("No ha ganado nada.");
            }
        }
    }
    private void winningNumber() {
        finalNumber = Math.floor(Math.random()*37);
    }
    public double getId() {
        return id;
    }
}
