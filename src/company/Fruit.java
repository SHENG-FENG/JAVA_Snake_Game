package company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Fruit {
    private int x;
    private int y;
    private ImageIcon img;
    public Fruit(){
        //img = new ImageIcon("fruit.png");
        img = new ImageIcon(getClass().getResource("fruit.png"));
        //設定水果直的隨機生成
        this.x = (int)(Math.floor(Math.random()*Main.column)*Main.CELL_SIZE);
        //設定水果橫的隨機生成
        this.y = (int)(Math.floor(Math.random()*Main.row)*Main.CELL_SIZE);
    }

    public int getX(){
        return this.x;
    }

    public int getY() {
        return this.y;
    }
    public void drawFruit(Graphics g){
        img.paintIcon(null,g,this.x,this.y);
    }
    public void setNewLocation(Snake s){
        int new_X;
        int new_y;
        //新生成的水果新的位置是否有跟蛇的身體有重疊
        boolean overlapping;
        do {
            new_X = (int)(Math.floor(Math.random()*Main.column)*Main.CELL_SIZE);
            new_y = (int)(Math.floor(Math.random()*Main.row)*Main.CELL_SIZE);
            overlapping = check_overlap(new_X,new_y,s);
        }while (overlapping);

        this.x = new_X;
        this.y = new_y;
    }
    private boolean check_overlap(int x,int y,Snake s){
        ArrayList<Node>snake_body = s.getSnakeBody();
        for (int j = 0;j<s.getSnakeBody().size();j++){
            if(x==snake_body.get(j).x &&y==snake_body.get(j).y){
                return true;
            }
        }
        return false;
    }
}