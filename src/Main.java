import java.util.Scanner;
public class Main {
    private static final Casino casino = new Casino();
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        char exit;
        do {
            startCasino(selectMenu());
            System.out.print("\n---Oprima 'q' para salir, cualquier tecla para continuar--- ");
            exit = input.next().charAt(0);
        }while(exit != 'q');
    }
    public static int selectMenu() {
        int select;
        do {
            System.out.print("" +
                    "Escoja una opción: " +
                    "\n1. Crear una ruleta." +
                    "\n2. Abrir una ruleta." +
                    "\n3. Apostar en una ruleta." +
                    "\n4. Cerrar apuestas en una ruleta." +
                    "\n\nCuál es su elección: ");
            select = input.nextInt();
        }while(select<1 || select>4);
        return select;
    }
    public static void startCasino(int select) {
        int number;
        switch(select) {
            case 1:
                System.out.println("Ruleta creada con ID: " + casino.createRoulette());
                break;
            case 2:
                System.out.print("Ingrese el ID de la ruleta que desea abrir: ");
                number = input.nextInt();
                System.out.println(casino.rouletteOpening(number));
                break;
            case 3:
                betInRoullette();
                break;
            case 4:
                System.out.print("Escribe el número de ID de la ruleta que quieres cerrar: ");
                number = input.nextInt();
                System.out.println(casino.closeBetRoulette(number));
                break;
        }
    }
    public static void betInRoullette() {
        int number;
        Roulette chosenRoulette;
        do {
            System.out.print("Escribe el ID de la ruleta: ");
            number = input.nextInt();
            chosenRoulette = casino.searchRoulette(number);
        }while(chosenRoulette == null);
        do {
            System.out.print("" +
                    "\nApostar número o color:" +
                    "\n1. Número." +
                    "\n2. Color." +
                    "\n\nCuál es su elección: ");
            number = input.nextInt();
        }while(number<1 || number>2);
        switch (number) {
            case 1:
                inputData(chosenRoulette);
                break;
            case 2:
                betColor(chosenRoulette);
                break;
        }
    }
    public static void inputData(Roulette chosenRoulette) {
        System.out.print("Escribe tu ID de usuario: ");
        int idUser = input.nextInt();
        System.out.print("Escribe el número al que le harás la apuesta: ");
        int number = input.nextInt();
        System.out.print("Escribe la cantidad de apuesta: ");
        double quantity = input.nextDouble();
        System.out.println(chosenRoulette.betNumber(idUser, number, quantity));
    }
    public static void betColor(Roulette chosenRoulette) {
        int select;
        do {
            System.out.println("" +
                    "\n1. Rojo." +
                    "\n2. Negro.");
            select = input.nextInt();
        }while(select<1 || select>2);
        System.out.print("Escribe tu ID de usuario: ");
        int idUser = input.nextInt();
        System.out.print("Escribe la cantidad de apuesta: ");
        double quantity = input.nextDouble();
        switch(select) {
            case 1:
                System.out.println(chosenRoulette.betNumber(idUser, 40, quantity));
                break;
            case 2:
                System.out.println(chosenRoulette.betNumber(idUser, 41, quantity));
                break;
        }
    }
}
