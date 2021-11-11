/*
Construa um conjunto de classes que implementem a interface IPlugin e 
que permitam adicionar funcionalidades ao programa principal.
*/
package lab12.ex1.reflection;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

abstract class PluginManager {

    public static IPlugin load(String name) throws Exception {
        
        Class<?> c = Class.forName(name);
        return (IPlugin) c.getDeclaredConstructor().newInstance();
    }

}


public class Plugin {
    public static void main(String[] args) throws Exception {
        
        File proxyList = new File("./lab12/ex1/reflection");
        ArrayList<IPlugin> plgs = new ArrayList<IPlugin>();

        for (String f: proxyList.list()) {
            if (f.endsWith(".class")) {   
                try {
                    plgs.add(PluginManager.load("lab12.ex1.reflection." + f.substring(0, f.lastIndexOf('.'))));
                } catch (Exception e) {
                    System.out.println("\t" + f + ": Componente ignorado. Não é IPlugin.");
                }   
            }
        }
        
        Iterator<IPlugin> it = plgs.iterator();
        
        while (it.hasNext()) {
            it.next().fazQualQuerCoisa();
        }
    }
}