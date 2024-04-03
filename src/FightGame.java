

import model.*;
import model.Character;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FightGame {
    ArrayList<Character> personatges = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public void menu() {

        int opcion = -1;
        boolean correcto;
        do {
            System.out.println("Menu del juego ");
            System.out.println("¿Que desea hacer?");
            System.out.println("1.Crear personajes");
            System.out.println("2.Mostrar personajes");
            System.out.println("3.Luchar");
            System.out.println("4.Salir");
            opcion = getIntFromUser(new ArrayList<Integer>( Arrays.asList(1,2,3,4)));
            switch (opcion) {
                case 1:
                    createCharacter();
                    break;
                case 2:
                    showCharacters();
                    break;
                case 3:
                    performFight();
                    break;
                case 4:
                    System.out.println("Adios");
                    break;
            }
        } while (opcion != 4);
    }

    private void createCharacter() {
        String nom ="";
        do {
            System.out.println("Escribe el nombre (máximo 7 caracteres):");
            nom = input.nextLine();
        }while(nom.length()>7);

        System.out.println("Selecciona tipos de personaje:");
        System.out.println("****Personajes Normales******");
        System.out.println("1.Humano");
        System.out.println("2.Enano");
        System.out.println("****Personajes Luchadores****");
        System.out.println("3.Orco");
        System.out.println("4.Troll");
        switch (getIntFromUser(new ArrayList<Integer>( Arrays.asList(1,2,3,4)))) {
            case 1:
                personatges.add(new Human(nom));
                break;
            case 2:
                personatges.add(new Nan(nom));
                break;
            case 3:
                personatges.add(new Orc(nom));
                break;
            case 4:
                personatges.add(new Troll(nom));
                break;
        }
    }

    private void showCharacters() {
        for (Character character : personatges) {
            System.out.println(character);
        }
    }

    private void performFight() {
        ArrayList<Integer> valorsCorrectes = new ArrayList<>();
        System.out.println("Selecciona el id del luchador");
        for (Character character : personatges) {
            if (character instanceof Fighter && character.getLives() > 0) {
                System.out.println(character);
                valorsCorrectes.add(character.getId());
            }
        }
        if (valorsCorrectes.isEmpty()){
            System.out.println("No se puede jugar, no hay ningun luchador definido!!");
            return;
        }
        Fighter lluitador = (Fighter) personatges.get(getIntFromUser(valorsCorrectes)-1);
        valorsCorrectes.clear();
        System.out.println("Selecciona el oponente:");
        for (Character character : personatges) {
            if (character.getLives() > 0 && character.getId() != lluitador.getId()) {
                System.out.println(character);
                valorsCorrectes.add(character.getId());
            }
        }
        if (valorsCorrectes.isEmpty()){
            System.out.println("No se puede jugar, no hay suficientes personajes!!");
            return;
        }
        Character oponent = personatges.get(getIntFromUser(valorsCorrectes)-1);

        if (lluitador.fight(oponent)) {
            System.out.println(String.format("%s gana a %s.", lluitador.getNom(), oponent.getNom()));
            lluitador.win();
            if(oponent instanceof Fighter)
                ((Fighter) oponent).lose();
            else
                oponent.loseLive();
        }
        else {
            System.out.println(String.format("%s pierde contra %s.", lluitador.getNom(), oponent.getNom()));
            lluitador.lose();
            if(oponent instanceof Fighter)
                ((Fighter) oponent).win();
        }

    }

    public int getIntFromUser(ArrayList<Integer> valorsValids){
        Scanner read = new Scanner(System.in);
        int variableRetorn = 0;
        boolean valorCorrecte = false;

        do{
            if (!read.hasNextInt()) {
                System.out.print("Selecciona un valor correcto:");
                System.out.println(valorsValids);
                read.nextLine();
            }
            else {
                variableRetorn = read.nextInt();

                if (valorsValids.contains(variableRetorn)) {
                    valorCorrecte = true;
                }
                else{
                    System.out.print("Selecciona un valor correcto:");
                    System.out.println(valorsValids);
                }

                read.nextLine();
            }

        }while(!valorCorrecte);

        return variableRetorn;
    }
}
