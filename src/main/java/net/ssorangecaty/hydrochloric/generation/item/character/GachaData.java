package net.ssorangecaty.hydrochloric.generation.item.character;

import net.minecraft.util.math.random.Random;

public class GachaData {
    public static CharacterGen[][] characters = new CharacterGen[6][999];
     public static void inputCharacter(CharacterGen character){
         for (int j = 0;true;j++){
             if(characters[character.quality - 1][j] == null){
                 characters[character.quality - 1][j] = character;
                 break;
             }
         }
     }
    public static CharacterGen gacha(){
        Random random = Random.create();
        int j = random.nextBetween(0,100);
        int q = 0;
        if(j <= 2){
            q = 5;
        }else if(j <= 10){
            q = 4;
        } else if (j <= 60) {
            q = 3;
        } else if (j <= 100){
            q = 2;
        }
        int max;
        for(int c = 0;true;c++){
            if(GachaData.characters[q][c] == null){
                max = c - 1;
                break;
            }
        }
        int r = random.nextBetween(0,max);
        return GachaData.characters[q][r];
    }
    public static CharacterGen[] gachaX10(){
        CharacterGen[] Characters = new CharacterGen[10];
        for(int e = 0;e < 10;e++){
            Characters[e] = gacha();
        }
        return Characters;
    }
}
