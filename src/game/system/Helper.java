package game.system;

public  class Helper {
    public static int clamp(int var, int min, int max){
        if(var >= max) return max;
        else if(var <= min) return min;
        return var;
    }

}
