import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> box;

    public Box() {
        this.box = new ArrayList<T>();
    }

    public void addFruit (T fruit, int amount){
        for (int i = 0; i < amount; i++) {
            box.add(fruit);
        }
    }

    public float getWeight (){
        float w = 0.0f;
        for (int i = 0; i < box.size(); i++) {
            w += box.get(i).getWeight();
        }
        return w;
    }
    public boolean compare (Box<?> another) {
        return (this.getWeight() - another.getWeight()) < 0.0001f;
    }

    public void intersperse (Box<T> another){
        another.box.addAll(this.box);
        this.box.clear();
    }
}
