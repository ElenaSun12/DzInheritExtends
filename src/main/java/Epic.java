public class Epic extends Task {
    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id); // вызов родительского конструктора
        this.subtasks = subtasks.clone(); // копируем массив для обеспечения неизменяемости
    }

    public String[] getSubtasks() {
        return subtasks.clone(); // возвращаем копию массива для защиты от изменений
    }

    @Override
    public boolean matches(String query) {
        for (String subtask : subtasks) {
            if (subtask.contains(query)) {
                return true;
            }
        }
        return false;
    }
}