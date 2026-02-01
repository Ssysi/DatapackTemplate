import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DefaultT {
    String name;
    double version;
    String description;
    String message;
    String path;

    DefaultT(String name, double version, String description, String message, String path){
        this.name = name;
        this.version = version;
        this.description = description;
        this.path = path;
        this.message = message;
    }

    public void generate(){
        File datapackPath = new File(path + "/datapacks/" + name);
        datapackPath.mkdir();
        //write pack.mcmeta
        try{
            FileWriter writer = new FileWriter(path + "/datapacks/" + name + "/pack.mcmeta");
            writer.write("{\r\n" +
                            "    \"pack\": {\r\n" +
                            "        \"pack_format\": " + version + ",\r\n" +
                            "        \"description\": \"" + description + "\"\r\n" +
                            "    }\r\n" +
                            "}");
            writer.close();
        } catch(IOException e){
            System.out.println(e);
        }
        //directiories
        File minecraftTags;
        File namespaceFunct;
        //directories for versions before 1.21
        if(version < 48){
            minecraftTags = new File(path + "/datapacks/" + name + "/data/minecraft/tags/functions");
            minecraftTags.mkdirs();
            namespaceFunct = new File(path + "/datapacks/" + name + "/data/" + name.replace(' ', '_') + "/functions");
            namespaceFunct.mkdirs();
        } else{
        //directories for versions after 1.21
            minecraftTags = new File(path + "/datapacks/" + name + "/data/minecraft/tags/function");
            minecraftTags.mkdirs();
            namespaceFunct = new File(path + "/datapacks/" + name + "/data/" + name.replace(' ', '_') + "/function");
            namespaceFunct.mkdirs();
        }
        //writing load.json
        try {
            FileWriter writer = new FileWriter(minecraftTags + "/load.json");
            writer.write("{\r\n" +
                                "\"values\": [\r\n" +
                                "    \"" + name.replace(' ', '_') + ":load\"\r\n" +
                                "]\r\n" +
                                "}");
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        //writing tick.json
        try{
            FileWriter writer = new FileWriter(minecraftTags + "/tick.json");
            writer.write("{\r\n" +
                                "\"values\": [\r\n" +
                                "    \"" + name.replace(' ', '_') + ":tick\"\r\n" +
                                "]\r\n" +
                                "}");
            writer.close();
        } catch(IOException e){
            System.out.println(e);
        }
        //creating load.mcfunction
        try{
        FileWriter writer = new FileWriter(namespaceFunct + "/load.mcfunction");
        if(!message.isEmpty()) writer.write("tellraw @a \"" + message + "\"");
        else writer.write("");
        writer.close();
        } catch(IOException e){
            System.out.println(e);
        }
        //creating tick.mcfunstion
        File tick = new File(namespaceFunct + "/tick.mcfunction");
        try{
            tick.createNewFile();
        } catch(IOException e){
            System.out.println(e);
        }
        System.out.println("Created!");
    }

}

