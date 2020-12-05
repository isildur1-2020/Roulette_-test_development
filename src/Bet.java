public class Bet {
    private final int idUser;
    private final int chosenNumber;
    private final double quantity;
    public Bet(int idUser, int chosenNumber, double quantity) {
        this.idUser = idUser;
        this.chosenNumber = chosenNumber;
        this.quantity = quantity;
    }
    public String showData(double gain) {
        return "" +
                "\nGanador !"+
                "\nId Usuario: "+idUser+
                "\nNúmero escogido: "+validateChosenNumber()+
                "\nCantidad Apostada: "+quantity+
                "\nDinero entregado: "+gain;
    }
    public String validateChosenNumber() {
        if(chosenNumber!=40 && chosenNumber!=41) {
            return String.valueOf(chosenNumber);
        }else if(chosenNumber == 40) {
            return "Rojo";
        }else {
            return "Negro";
        }
    }
    public int getChosenNumber() {
        return chosenNumber;
    }
    public double getQuantity() {
        return quantity;
    }
}
