package net.ssorangecaty.hydrochloric.generation.item.character;

import net.minecraft.util.Identifier;
import net.ssorangecaty.hydrochloric.Hydrochloric;

public class CharacterIdentifier {
    String name;
    public CharacterIdentifier(String name){
        this.name = name;
    }
    public Identifier getImage(){
        return new Identifier(Hydrochloric.MOD_ID,"textures/role/"+name+".png");
    }
    public Identifier getItemId(){
        return new Identifier(Hydrochloric.MOD_ID,name);
    }
    public String getName(){
        return name;
    }
}
