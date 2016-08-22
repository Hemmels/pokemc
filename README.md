# pokemc
Will contain a description, and version information here.

To build from a clone of this repo, simply run

gradlew setupDecompWorkspace --refresh-dependencies

then

gradlew eclipse

from the command line.

Then F5 refresh the project. Happy days.

If running a new server "build", you will need to change eula=true in eula.txt, and set online-mode=false in server.properties.

For reference, Forge files:
http://files.minecraftforge.net/

And gradle plugin snapshots:
http://export.mcpbot.bspk.rs/snapshot/
