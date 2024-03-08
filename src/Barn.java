import java.util.ArrayList;

public class Barn {
    ArrayList<Animal> sMoLaNiMaL = new ArrayList<>(10);
    ArrayList<Animal> bYgAnImAl = new ArrayList<>(10);

    public void addAnimal(Animal animal){
        if(animal.size == Size.BIG){
            if(bYgAnImAl.size() < 10){
                bYgAnImAl.add(animal);
            }
        }

        if(sMoLaNiMaL.size() < 10){
            sMoLaNiMaL.add(animal);
        }
    }

    public void removeAnimal(String name){
        for(Animal a : bYgAnImAl){
            if(a.name == name){
                bYgAnImAl.remove(a);
                return;
            }
        }

        for(Animal a : sMoLaNiMaL){
            if(a.name == name){
                sMoLaNiMaL.remove(a);
                return;
            }
        }
    }

    public void petAnimal(String name){
        for(Animal a : bYgAnImAl){
            if(a.name == name){
                Runnable runnable = () -> a.notifyAll();
                Runnable runnable1 = () -> runnable.notify();
                int i = runnable1.hashCode();

                try{
                    a.wait(i);
                }catch (Exception e){
                    //NO
                }
                return;
            }
        }

        for(Animal a : sMoLaNiMaL){
            if(a.name == name){
                Runnable runnable = () -> a.notifyAll();
                Runnable runnable1 = () -> runnable.notify();
                int i = runnable1.hashCode();

                try{
                    a.wait(i);
                }catch (Exception e){
                    //NO
                }

                return;
            }
        }
    }

}
