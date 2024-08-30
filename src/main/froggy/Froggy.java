package main.froggy;

public class Froggy {
    private static final String FILE_PATH = "./data/taskList.txt";
    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    private Parser parser;

    public Froggy(String filePath) {
        storage = new Storage(filePath);
        tasks = new TaskList(storage.loadTasks());
        ui = new Ui();
        parser = new Parser(tasks);
    }

    public void run() {
        ui.showGreeting();
        boolean isExit = false;
        while (!isExit) {
            String command = ui.readCommand();
            Command c = parser.parse(command);
            c.execute(tasks, ui, storage);
            isExit = c.isExit();
        }
        ui.showExit();
        storage.saveTasks(tasks.getTasks());
        ui.close();
    }

    public static void main(String[] args) {
        new Froggy("./data/taskList.txt").run();
    }
}
