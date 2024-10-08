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



    // pour method to pour some layers with the same color from bottle i to bottle j based on empty space in bottle j
    public State pour(int i, int j) {
        State newState = new State(numberOfBottles, bottleCapacity, bottles);
        Bottle bottle1 = newState.getBottle(i);
        Bottle bottle2 = newState.getBottle(j);
        int freeSpace = bottle2.getFreeSpace();
        int topColorCapacity = bottle1.getTopColorCapacity();
        int pourAmount = Math.min(freeSpace, topColorCapacity);
        int bottle1TopColorIndex = bottle1.getTopColorIndex();
        int bottle2TopColorIndex = bottle2.getTopColorIndex();
        for (int k = 0; k < pourAmount; k++) {
            bottle2.setColor(bottle2TopColorIndex + 1, bottle1.getTopColor());
            bottle1.setColor(bottle1TopColorIndex, 'e');
            bottle1TopColorIndex--;
            bottle2TopColorIndex++;
        }
        return newState;
    }


//    public String toString() {
//        String state = numberOfBottles + ";" + bottleCapacity + ";";
//        for (int i = 0; i < numberOfBottles; i++) {
//            Bottle bottle = bottles[i];
//            for (int j = 0; j < bottleCapacity; j++) {
//                state += bottle.getColors()[j];
//                if (j < bottleCapacity - 1) {
//                    state += ",";
//                }
//            }
//            if (i < numberOfBottles - 1) {
//                state += ";";
//            }
//        }
//        return state;
//    }


    public boolean isGoal() {
        for (int i = 0; i < getNumberOfBottles(); i++) {
            char[] colors = getBottle(i).getColors();
            char color = colors[0];
            for (int j = 1; j < colors.length; j++) {
                if (colors[j]!=color) {
                    return false;
                }
            }
        }
        return true;
    }


}
