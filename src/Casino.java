import java.util.ArrayList;
public class Casino {
    private ArrayList<Roulette> rouletteCreated = new ArrayList<>();
    private ArrayList<Double> idsCreated = new ArrayList<>();
    public double createRoulette() {
        double id = createIdRoulette();
        idsCreated.add(id);
        return id;
    }
    private double createIdRoulette() {
        boolean idExists = false;
        double id = 0;
        while(!idExists) {
            idExists = true;
            id = Math.floor(Math.random()*1000)+1;
            for(Double i: idsCreated) {
                if(i == id) {
                    idExists = false;
                }
            }
        }
        return id;
    }
    public String rouletteOpening(double idRoulette) {
        for(Double i: idsCreated) {
            if(i == idRoulette) {
                Roulette roulette = new Roulette(idRoulette);
                rouletteCreated.add(roulette);
                return "Operación exitosa";
            }
        }
        return "Operación denegada";
    }
    public String closeBetRoulette(double idRoulette) {
        for(Roulette i: rouletteCreated) {
            if(i.getId() == idRoulette) {
                i.closeBets();
                return "Cerrando apuestas...";
            }
        }
        return "Ruleta no encontrada.";
    }
    public Roulette searchRoulette(int idRoulette) {
        for(Roulette i: rouletteCreated) {
            if(i.getId() == idRoulette) {
                return i;
            }
        }
        return null;
    }
}
