import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Bouquet {
    private List<Flower> flowers;
    private double accessoryPrice;

    public Bouquet() {
        this.flowers = new ArrayList<>();
    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    public void setAccessoryPrice(double price) {
        this.accessoryPrice = price;
    }

    public double getTotalPrice() {
        double totalPrice = accessoryPrice;
        for (Flower flower : flowers) {
            totalPrice += flower.getPrice();
        }
        return totalPrice;
    }

    public void sortFlowersByFreshness() {
        flowers.sort(Comparator.comparingInt(Flower::getFreshness));
    }

    public List<Flower> filterByStemLength(double min, double max) {
        List<Flower> filtered = new ArrayList<>();
        for (Flower flower : flowers) {
            if (flower.getStemLength() >= min && flower.getStemLength() <= max) {
                filtered.add(flower);
            }
        }
        return filtered;
    }

    public void displayBouquet() {
        for (Flower flower : flowers) {
            System.out.println(flower);
        }
        System.out.println("Аксессуары: " + accessoryPrice + " у.е.");
    }
}

