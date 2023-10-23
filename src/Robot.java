import java.util.HashSet;

public class Robot {
    int x =0;
    int y =0;
    //Position pos=new Position(0,0);
    char direction='С'; // "С", "В", "Ю", "З"

    HashSet<Position> memory = new HashSet<>();

    public Robot(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        memory.add(new Position(x, y));
    }

    void turnLeft(){
        switch (direction){
            case 'С': direction='З';    break;
            case 'З': direction='Ю';    break;
            case 'Ю': direction='В';    break;
            case 'В': direction='С';    break;
        }
    }

    void turnRight(){
        switch (direction){
            case 'С': direction='В';    break;
            case 'З': direction='С';    break;
            case 'Ю': direction='З';    break;
            case 'В': direction='Ю';    break;
        }
    }

    void stepForward(){
        switch (direction){
            case 'С': x++;    break;
            case 'З': y--;    break;
            case 'Ю': x--;    break;
            case 'В': y++;    break;
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
