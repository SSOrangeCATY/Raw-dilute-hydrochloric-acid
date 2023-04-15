package net.ssorangecaty.hydrochloric.generation.character;

import net.minecraft.util.Identifier;
import net.ssorangecaty.hydrochloric.Mod;

public class CharacterIdentifier {
    String name;
    public CharacterIdentifier(String name){
        this.name = name;
    }
    public Identifier getImage(){
        return new Identifier(Mod.MOD_ID,"textures/role/"+name+".png");
    }
    public Identifier getItemId(){
        return new Identifier(Mod.MOD_ID,name);
    }
}
