import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //String path = System.getProperty("user.home") + "/Desktop/Nový priečinok/svety/";
        String path = System.getProperty("user.home") + "/AppData/Roaming/.minecraft/saves/";
        Scanner scanner = new Scanner(System.in);
        String fullPath;
        boolean defaultMessage = false;
        String worldName;
        Versions CheckVersion;
        String mcVersion;
        int version;
        String datapackName;
        String description;
        String loadMessage;

        if(args.length == 0) { System.out.println("Type command (template)"); System.exit(0);}

        switch (args[0].toLowerCase()){

            case "template":
            if(args.length > 1){
                for(String par : args){
                    if(par.equals("-d")) defaultMessage = true;
                }
            }
            
            //world name
                do{
                    System.out.print("World name: ");
                    worldName = scanner.nextLine();    
                } while(!validateWorld(worldName, path));
            //datapack name
            do{
                System.out.print("Datapack name: ");
                datapackName = scanner.nextLine();
            } while(datapackName.isEmpty() || datapackExists(path, worldName, datapackName));
            //version
            do{
                System.out.print("Minecraft version: ");
                mcVersion = scanner.nextLine();
                CheckVersion = new Versions(mcVersion);
            } while(!CheckVersion.validateVersion(mcVersion));
            version = CheckVersion.versionNumber(mcVersion);
            //description
            do{
                System.out.print("Description: ");
                description = scanner.nextLine();
            } while(description.isEmpty());
            //load message
            if(!defaultMessage){
                System.out.print("Load message (optional): ");
                loadMessage = scanner.nextLine();
                if(loadMessage.isEmpty()) loadMessage = "";
            } else{
                loadMessage = "aaaaa";
            }
            scanner.close();
            //generate
            fullPath = path + worldName;
            DefaultT template = new DefaultT(datapackName, version, description, loadMessage, fullPath);
            template.generate();
            break;
            default:
            System.out.println(args[0] + " is not a valid command");
            scanner.close();
            break;
        }
    }
    private static boolean validateWorld(String worldName, String path){
        File world = new File(path + worldName);
        if(!world.exists()) System.out.println("Invalid world name");
        return world.exists();
    }
    private static boolean datapackExists(String path, String world, String name){
        File file = new File(path + world + "/datapacks/" + name);
        if(file.exists()) System.out.println("Datapack with that name already exists");
        return file.exists();
    }
}