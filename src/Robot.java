import java.util.HashSet;

public class Robot {
    int x =0;
    int y =0;
    //Position pos=new Position(0,0);
  //  char direction='С'; // "С", "В", "Ю", "З"
    Direction direction;

    HashSet<Position> memory = new HashSet<>();

    /*public Robot(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        memory.add(new Position(x, y));
    }*/

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        memory.add(new Position(x, y));
    }

    void turnLeft(){
        switch (direction){
            case NORTH: direction =Direction.WEST;    break;
            case WEST : direction =Direction.SOUTH;   break;
            case SOUTH: direction =Direction.EAST;    break;
            case EAST : direction =Direction.NORTH;   break;
        }
    }

    void turnRight(){
        switch (direction){
            case NORTH: direction =Direction.EAST;    break;
            case WEST : direction =Direction.NORTH;    break;
            case SOUTH: direction =Direction.WEST;    break;
            case EAST : direction =Direction.SOUTH;    break;
        }
    }

    void stepForward(){
        switch (direction){
            case NORTH: x++;    break;
            case WEST : y--;    break;
            case SOUTH: x--;    break;
            case EAST : y++;    break;
        }
        //memory.add(new Position(x, y));
    }

    public int runProgram(String program)
    {
        int counter = 0;
        for (int i = 0; i < program.length(); i++) {
            char c = program.charAt(i);
            if(c == 'L')
                this.turnLeft();
            if(c == 'R')
                this.turnRight();
            if(c == 'S')
            {
                counter++;
                this.stepForward();
                if(this.memory.contains(new Position(x, y)))
                    //System.out.println("я здесь уже был");
                    return counter;
                else
                    memory.add(new Position(x, y));
            }
        }
        return -1;
    }
}

enum Direction{     //без слова public, чтобы не выделять в отдельный файл
    NORTH, EAST, SOUTH, WEST;

    @Override
    public String toString() {
        switch (this){
            case SOUTH: return "юг";
            case WEST : return "запад";
            case NORTH: return "север";
            case EAST : return "восток";
        }
        return "";
    }
}