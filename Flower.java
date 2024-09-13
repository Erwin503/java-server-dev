class Flower {
    protected String name;
    protected double price;
    protected int freshness; // Свежесть в днях
    protected double stemLength; // Длина стебля в сантиметрах

    public Flower(String name, double price, int freshness, double stemLength) {
        this.name = name;
        this.price = price;
        this.freshness = freshness;
        this.stemLength = stemLength;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getFreshness() {
        return freshness;
    }

    public double getStemLength() {
        return stemLength;
    }

    @Override
    public String toString() {
        return name + ": цена = " + price + ", свежесть = " + freshness + " дней, длина стебля = " + stemLength + " см";
    }
}

class Rose extends Flower {
    public Rose(double price, int freshness, double stemLength) {
        super("Роза", price, freshness, stemLength);
    }
}

class Tulip extends Flower {
    public Tulip(double price, int freshness, double stemLength) {
        super("Тюльпан", price, freshness, stemLength);
    }
}
