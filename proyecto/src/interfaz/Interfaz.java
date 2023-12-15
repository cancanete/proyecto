package interfaz;

import java.util.ArrayList;
import dominio.*;
import java.io.*;
import java.util.Scanner;

public class Interfaz {
    
    private ArrayList<Competidor> competidores;
    private Scanner sc = new Scanner(System.in);

    public Interfaz()
    {
        leer();
    }
    private void leer()
    {
        ObjectInputStream obj;
        File file = new File ("meritos.txt");
            try
            {
                 obj = new ObjectInputStream(new FileInputStream(file));
                    try
                    {
                        competidores=(ArrayList<Competidor>) obj.readObject();
                        obj.close();
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error al abrir el archivo");
                        competidores=new ArrayList<>();
                    }
            }
            catch(Exception e)
            {
                competidores=new ArrayList<>();
            }

    }

    private void grabar()
    {
        ObjectOutputStream obj;
        File file = new File("meritos.txt");
            try
            {
                obj = new ObjectOutputStream(new FileOutputStream(file));
                obj.writeObject(competidores);
                    obj.close();
                System.out.println("Guardado");
            }
            catch(Exception e)
            {
                System.out.println("Error al guardar");
                System.out.println(e);
            }
    }


    private void annadirEsquiador()
    {
        System.out.println("Introduzca el nombre del esquiador"); 
        String nombre = sc.nextLine();
        System.out.println("Introduzca el tipo de esquí"); 
        String tipoEsqui = sc.nextLine();
        competidores.add(new Esquiador(nombre, tipoEsqui));
     
    }


    private void annadirCompetidor()
    {
        System.out.println("Introduzca el nombre del competidor"); 
        String nombre = sc.nextLine();
        competidores.add(new Competidor(nombre));
     
    }


    private void borrarCompetidor()
    {
        System.out.println("Nombre del Competidor a borrar: ");
        String n = sc.nextLine();
        Competidor p = new Competidor(n);
        int posicion = competidores.indexOf(p);

        if (posicion == -1)
        {
            System.out.println("Competidor no encontrado");
        }
        else
        {
            competidores.remove(posicion);
            System.out.println("Competidor borrado");
            System.out.println("Pulse <enter> para continuar");
            sc.nextLine();
        }
    }
     
    private String menu()
    {
        System.out.println("\n----------Menú----------");
        System.out.println("1. Agregar Esquiador");
        System.out.println("2. Agregar Competidor");
        System.out.println("3. Borrar Esquiador");
        System.out.println("4. Mostrat Competidor");
        System.out.println("5. Salir");

        String opcion = sc.nextLine();
        return opcion;

    }

    public void ejecutar()
    {   String opcion;
        do
        {
             opcion = menu();
            switch (opcion) 
            {
                case "1":
                    annadirEsquiador();
                    break;

                case "2":
                    annadirCompetidor();
                    break;
                    
    
                case "3":
                    borrarCompetidor();
                    break;
                
                case "4":
                    mostrar();
                    break;

                case "5":
                    grabar();
                    break;

                default:
                System.out.println("opción incorrecta ");
                    break;
            }

        }while (! opcion.equals("5"));
        
    }

    public void mostrar()
    {
        System.out.println("competidores " + competidores);
        System.out.println("Pulse <enter> para continuar");
        sc.nextLine();
        
    }
}