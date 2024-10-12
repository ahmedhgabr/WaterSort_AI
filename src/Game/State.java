package Game;

public class State {
    int numberOfBottles;
    int bottleCapacity;
    Bottle[] bottles;

    public State(int numberOfBottles, int bottleCapacity, Bottle[] bottleContent) {
        this.numberOfBottles = numberOfBottles;
        this.bottleCapacity = bottleCapacity;
        this.bottles = bottleContent;
    }

    public State(String initialState) {
        String[] state = initialState.split(";");
        this.numberOfBottles = Integer.parseInt(state[0]);
        this.bottleCapacity = Integer.parseInt(state[1]);
        this.bottles = new Bottle[numberOfBottles];
        for (int i = 0; i < numberOfBottles; i++) {
            String[] colors = state[i+2].split(",");
            Bottle bottle = new Bottle(bottleCapacity);
            for (int j = 0; j < bottleCapacity; j++) {
                bottle.setColor(j ,colors[j].charAt(0));
            }
            bottles[i]=bottle;
        }
    }

    public int getNumberOfBottles() {
        return numberOfBottles;
    }

    public int getBottleCapacity() {
        return bottleCapacity;
    }

    public Bottle getBottle(int i) {
        return bottles[i];
    }

    public Bottle[] getBottles() {
        Bottle[] newBottles = new Bottle[bottles.length];
        for(int k=0; k<bottles.length; k++){
            newBottles[k] = new Bottle(bottles[k].getColors().clone());
        }
        return newBottles;
    }

    // pour method to pour some layers with the same color from bottle i to bottle j based on empty space in bottle j
    public int pour(int i, int j) {
        Bottle bottle1 = getBottle(i);
        Bottle bottle2 = getBottle(j);
        int freeSpace = bottle2.getFreeSpace();
        char topColor = bottle1.getTopColor();
        int topColorCapacity = bottle1.getTopColorCapacity();
        int pourAmount = Math.min(freeSpace, topColorCapacity);
        int bottle1TopColorIndex = bottle1.getTopColorIndex();
        int bottle2TopColorIndex = bottle2.getTopColorIndex();
        for (int k = 0; k < pourAmount; k++) {
            bottle2.setColor(bottle2TopColorIndex -1, topColor);
            bottle1.setColor(bottle1TopColorIndex, 'e');
            bottle1TopColorIndex++;
            bottle2TopColorIndex--;
        }
        return pourAmount;
    }


    public String toString() {
        String state = numberOfBottles + ";" + bottleCapacity + ";";
        for (int i = 0; i < numberOfBottles; i++) {
            Bottle bottle = bottles[i];
            for (int j = 0; j < bottleCapacity; j++) {
                state += bottle.getColors()[j];
                if (j < bottleCapacity - 1) {
                    state += ",";
                }
            }
            if (i < numberOfBottles - 1) {
                state += ";";
            }
        }
        return state;
    }


    public boolean isGoal() {
        for (int i = 0; i < getNumberOfBottles(); i++) {
            char[] colors = getBottle(i).getColors();
            char color = colors[bottleCapacity-1];
            for (int j = 0; j < colors.length; j++) { // [e,e,r,r][e,e,g,g]
                if (colors[j]!=color && colors[j]!='e') {
                    return false;
                }
            }
        }
        return true;
    }


}
