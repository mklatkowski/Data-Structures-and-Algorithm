package Main;

import Pomiar.CiagPomiarow;

import java.io.*;
import java.util.ArrayList;

public class KlasaUslugodawcza {

    public static void View(ArrayList<CiagPomiarow> list){
        for(CiagPomiarow x: list){
            System.out.println(x);
        }
    }

    public static void Serialize(ArrayList<CiagPomiarow> ciagi){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Lab04.ser"))){
            for(CiagPomiarow ciag: ciagi){
                oos.writeObject(ciag);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<CiagPomiarow> Deserialize(){
        ArrayList<CiagPomiarow> list = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Lab04.ser"))){
            try{
                while(true){
                    list.add((CiagPomiarow) ois.readObject());
                }
            }
            catch(EOFException e){}
        }
        catch(IOException  | ClassNotFoundException e){
            e.printStackTrace();
        }
        return list;
    }
}
