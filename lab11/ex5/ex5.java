public class ex5 {
    public static void main(String[] args) {
        if (args.length <= 0 || args.length > 2) {
            argsError();
        }
        else if (args.length == 1) {
            // não é recursivo
            new FileSystemWalker().walk(args[0], false);
        }
        else if (args.length == 2) {
            if (!args[0].equals("-r")) {
                argsError();
            }

            // é recursivo
            new FileSystemWalker().walk(args[1], true);
        }
    }

    private static void argsError() {
		System.err.println("[ERROR] Usage(after compilation):\n	java Ex5 [-option] path\n	Option:\n		-r: Includes the size of the directories inside the one passed");
		System.exit(0);
	}
}