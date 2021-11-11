// package pds_2021_111.lab01;

public enum Direction {
    Up(1, "Up"),
    Down(2, "Down"),
    Left(3, "Left"),
    Right(4, "Right"),
    UpLeft(5, "UpLeft"),
    UpRight(6, "UpRight"),
    DownLeft(7, "DownLeft"),
    DownRight(8, "DownRight");

    private final int number;
    private final String label;

    private Direction(int number, String label) {
        this.number = number;
        this.label = label;
    }

    public int getNumber() {
        return this.number;
    }

    public String toString(){
        return this.label;
    }

    public Direction getDirection(int number) {
        switch(number) {
            case 1:
                return Direction.Up;
            case 2:
                return Direction.Down;
            case 3:
                return Direction.Left;
            case 4:
                return Direction.Right;
            case 5:
                return Direction.UpLeft;
            case 6:
                return Direction.UpRight;
            case 7:
                return Direction.DownLeft;
            default:
                return Direction.DownRight;
        }
    }
}
