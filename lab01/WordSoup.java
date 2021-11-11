import java.util.HashMap;

// package pds_2021_111.lab01;

public class WordSoup {
    public Coordinates move(int dir, Coordinates coordinates) {
        //    0 1 2 3 4 5 6 7
        // 0  - - - - - - - a
        // 1  d - - - - - k -
        // 2  - n - n - n - -
        // 3  - - a i o - - -
        // 4  l l i w o r d -
        // 5  - - o i o - - -
        // 6  - n - i - o - -
        // 7  t - - - - - d -

        // o switch não funciona com case this.up
        if (dir == Direction.Up.getNumber()) {
            // [i-1, j]
            coordinates.setX(coordinates.getX()-1);
        }
        else if (dir == Direction.Down.getNumber()) {
            // [i+1, j]
            coordinates.setX(coordinates.getX()+1);
        }
        else if (dir == Direction.Left.getNumber()) {
            // [i, j-1]
            coordinates.setY(coordinates.getY()-1);
        }
        else if (dir == Direction.Right.getNumber()) {
            // [i, j+1]
            coordinates.setY(coordinates.getY()+1);
        }
        else if (dir == Direction.UpLeft.getNumber()) {
            // [i-1, j-1]
            coordinates.setX(coordinates.getX()-1);
            coordinates.setY(coordinates.getY()-1);
        }
        else if (dir == Direction.UpRight.getNumber()) {
            // [i-1, j+1]
            coordinates.setX(coordinates.getX()-1);
            coordinates.setY(coordinates.getY()+1);
        }
        else if (dir == Direction.DownLeft.getNumber()) {
            // [i+1, j-1]
            coordinates.setX(coordinates.getX()+1);
            coordinates.setY(coordinates.getY()-1);
        }
        else if (dir == Direction.DownRight.getNumber()) {
            // [i+1, j+1]
            coordinates.setX(coordinates.getX()+1);
            coordinates.setY(coordinates.getY()+1);
        }

        return coordinates;
    }

    public boolean fits(int len, String word, int line, int column, int dir) {
        boolean ret = false;

        int up_space = line + 1;
        int left_space = column + 1;
        int limit = len;
        int down_space = (limit - up_space) + 1;
        int right_space = (limit - left_space) + 1;
        int space_needed = word.length();

        // o switch não funciona com case this.up
        if (dir == Direction.Up.getNumber() && up_space >= space_needed) {
            // find -> dir = up
            ret = true;
        }
        else if (dir == Direction.Down.getNumber() && down_space >= space_needed) {
            // find -> dir = down
            ret = true;
        }
        else if (dir == Direction.Left.getNumber() && left_space >= space_needed) {
            // find -> dir = left
            ret = true;
        }
        else if (dir == Direction.Right.getNumber() && right_space >= space_needed) {
            // find -> dir = right
            ret = true;
        }
        else if (dir == Direction.UpLeft.getNumber() && ((up_space <= left_space) ? up_space : left_space) >= space_needed) {
            // find -> dir = upleft
            ret = true;
        }
        else if (dir == Direction.UpRight.getNumber() && ((up_space <= right_space) ? up_space : right_space) >= space_needed) {
            // find -> dir = upright
            ret = true;
        }
        else if (dir == Direction.DownLeft.getNumber() && ((down_space <= left_space) ? down_space : left_space) >= space_needed) {
            // find -> dir = downleft
            ret = true;
        }
        else if (dir == Direction.DownRight.getNumber() && ((down_space <= right_space) ? down_space : right_space) >= space_needed) {
            // find -> dir = downright
            ret = true;
        }

        return ret;
    }

    public boolean isInside(String word, int x, int y, int dir, HashMap<String, Solution> solution) {
        boolean ret = false;
        
        for (String k : solution.keySet()) {
            Solution val = solution.get(k);

            if (k.toLowerCase().contains(word.toLowerCase()) && val.getDir().getNumber() == dir) {
                // a palavra existe dentro de outra e a direção é a mesma, temos de ver se estão no mesmo sítio
                int size = 0;
                Coordinates k_coor = val.getStart();
                Coordinates word_coor = new Coordinates(x, y);
                while (size < k.length()) {
                    if (k_coor.equals(word_coor)) {
                        ret = true;
                        break;
                    }

                    k_coor = this.move(dir, k_coor);
                    size++;
                }
            }
        }

        return ret;
    }
}
