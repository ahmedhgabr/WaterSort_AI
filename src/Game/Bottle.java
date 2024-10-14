package Game;

import java.util.HashSet;

public class Bottle {

    char[] colors;
    int bottleCapacity;
    public Bottle(int capacity) {
        colors = new char[capacity];
        bottleCapacity = capacity;
        for (int i = 0; i < capacity; i++) {
            colors[i] = 'e';
        }
    }

    public Bottle(char[] colors) {
        this.colors = colors;
        bottleCapacity = colors.length;
    }

    public char[] getColors() {
        return colors;
    }
    
    public void setColor(int i, char color) {
        colors[i] = color;
    }

    public boolean isEmpty() {
        return colors[bottleCapacity-1] == 'e';
    }

    public boolean isFull() {
        return colors[0] != 'e';
    }

    public boolean hasSpace() {
        return !isFull();
    }

    public char getTopColor(){
        char color = 'e';
        for(int i = 0; i < bottleCapacity; i++){
            if(colors[i] != 'e'){
                color = colors[i];
                break;
            }
        }
        return color;
    }

    public int getFreeSpace(){
        int freeSpace = 0;
        for(int i = 0; i < bottleCapacity; i++){
            if(colors[i] == 'e') {
                freeSpace++;
            }
            else {
                return freeSpace;
            }
        }
        return freeSpace;
    }

    /* getTopColorIndex is a method that returns the index of the top layer with color in the bottle.
    */
    public int getTopColorIndex(){
        int index = bottleCapacity ;
        for(int i = 0; i < bottleCapacity; i++) {
            if (colors[i] != 'e') {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * getTopColorCapacity is a method that returns the number of layers with the same color on top of the bottle.
     * @return
     */
    public int getTopColorCapacity(){
        int topColorIndex = getTopColorIndex();
        if(topColorIndex == bottleCapacity){  // bottle is empty
            return 0;
        }
        int topColorCapacity = 1;
        char color = colors[topColorIndex];
        for(int i = topColorIndex+1; i < bottleCapacity; i++){
            if(colors[i] == color){ // same color
                topColorCapacity++;
            }
            else { // different color
                break;
            }
        }
        return topColorCapacity;
    }

    public boolean isSorted() {
        HashSet<Character> colorsSet = new HashSet<Character>();
        if (isEmpty()) {
            return true;
        }
        for (int i = 0; i < bottleCapacity; i++) {
            if (colors[i] != 'e') {
                colorsSet.add(colors[i]);
            }
        }
        return colorsSet.size() == 1 ;
    }


}
