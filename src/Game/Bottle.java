package Game;

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

    public char[] getColors() {
        return colors;
    }
    
    public void setColor(int i, char color) {
        colors[i] = color;
    }

    public boolean isEmpty() {
        return colors[0] == 'e';
    }

    public boolean isFull() {
        return colors[bottleCapacity-1] != 'e';
    }

    public boolean hasSpace() {
        return !isFull();
    }

    public char getTopColor(){
        char color = 'e';
        for(int i = bottleCapacity-1; i >= 0; i--){
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
            if(colors[i] == 'e'){
                return bottleCapacity - i;
            }
        }
        return freeSpace;
    }

    public int getTopColorIndex(){
        int index = -1;
        for(int i = bottleCapacity-1; i >= 0; i--){
            if(colors[i] != 'e'){
                index = i;
                break;
            }
        }
        return index;
    }

    public int getTopColorCapacity(){
        int topColorIndex = getTopColorIndex();
        if(topColorIndex == -1){  // bottle is empty
            return 0;
        }
        int topColorCapacity = 1;
        char color = colors[topColorIndex];
        for(int i = topColorIndex-1; i >= 0; i--){
            if(colors[i] == color){ // same color
                topColorCapacity++;
            }
            else { // different color
                break;
            }
        }
        return topColorCapacity;
    }


}
