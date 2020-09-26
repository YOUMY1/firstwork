import java.io.IOException;
import java.util.*;

public class Manage {
    ArrayList<Animal> animals = new ArrayList<>();
    Iterator<Animal> iterator = animals.iterator();
    static int AllId = 0;// 以便定位每个动物
    Scanner scanner = new Scanner(System.in);
    public void init() throws IOException, InterruptedException {
        animals.add(new Animal("taiger", "boy", 5, ++AllId));
        animals.add(new Animal("monkey", "girl", 6, ++AllId));
        System.out.println("动物园管理系统");
        System.out.println("                                    选择任意键按键继续");
        scanner.nextLine();
        clean();
    }
    public void choiceDisplay() throws InterruptedException, IOException {
        System.out.println("1:增加 2 删除 3 修改 4 查询  5 查询年龄排序(小到大) 6 exit");
        System.out.println("                                    选择按键继续");
        int flag = scanner.nextInt();
        switch (flag) {
            case 1:
                add();
                break;
            case 2:
                delete();
                break;
            case 3:
                modify();
                break;
            case 4:
                query();
                break;
            case 5:
                querySortInAage();
            case 6:
                return;
            default:
                System.out.println("输出错误，请重新选择");
                clean();
                choiceDisplay();
                break;
        }
    }
    public void add() throws IOException, InterruptedException {
        boolean flag = true;
        String variety = null;
        String sex = null;
        int age = -1;
        clean();
        while (flag) {
            System.out.println("请依次输入动物的名字（str）,性别(str),年龄(int)");
            try {
                scanner.nextLine();
                variety = scanner.next();
                sex = scanner.next();
                age = scanner.nextInt();
                Animal animal = new Animal(variety, sex, age, ++AllId);
                boolean add = animals.add(animal);
                if (add) {
                    System.out.println("添加成功添加的内容为 " + variety + " " + sex + " " + age);
                }
            } catch (InputMismatchException e) {
                System.out.println("请你重新输入与之匹配的信息");
                add();
            }

            System.out.println("如果要继续添加请输入 1 输入其他任意键退出添加回到主界面");
            scanner.nextLine();
            String s = scanner.nextLine();
            byte[] bytes = s.getBytes();
            if (bytes.length != 0) {
                int choice = (int) bytes[0];
                if (choice == 49) {
                    add();
                } else
                    flag = false;
            }
            break;
        }
        clean();
        choiceDisplay();
    }
    public void modify() throws IOException, InterruptedException {
        boolean flag1 = true;
        clean();
        while (flag1) {
            System.out.println("请输入要修改动物id");
            int id = scanner.nextInt();
            System.out.println("1 种类  2性别  3 年龄 按其他键退出");
            int flag = scanner.nextInt();
            switch (flag) {
                case 1:
                    String newvariety = scanner.next();
                    for (Animal animal : animals) {
                        if (animal.getId() == id) {
                            animal.setVariety(newvariety);
                            System.out.println("种类修改成功");
                        }
                    }
                    break;
                case 2:
                    String newSex = scanner.next();
                    for (Animal animal : animals) {
                        animal.setSex(newSex);
                        System.out.println("性比修改成功");
                    }
                    break;
                case 3:
                    int newAge = scanner.nextInt();
                    for (Animal animal : animals) {
                        if (animal.getId() == id)
                            animal.setAge(newAge);
                        System.out.println("年龄修改成功");
                    }
                default:
                    break;
            }
            System.out.println("如果要继续修改请输入1 输入其他任意键退出修改回到主界面");
            scanner.nextLine();
            String s = scanner.nextLine();
            byte[] bytes = s.getBytes();
            if (bytes.length != 0) {
                int choice = (int) bytes[0];
                if (choice == 49) {
                    delete();
                } else
                    flag1 = false;
            }
            break;
        }
        clean();
        choiceDisplay();
    }
    public void delete() throws IOException, InterruptedException {
        if (AllId < 0) {
            System.out.println("动物园为空，无法继续删除");
            return;
        }
        boolean flag = true;
        while (flag && AllId > 0) {
            boolean haveboll = false;
            System.out.printf("请输入要删除的动物的id");
            int id = scanner.nextInt();
            Animal temp = null;
            for (Animal animal : animals) {
                if (animal.getId() == id) {
                    temp = animal;
                    haveboll = true;
                    break;
                }
            }
            if (!haveboll) {
                System.out.println("抱歉删除的动物不存在");
            }
            if (haveboll) {
                boolean remove = animals.remove(temp);
                if (remove)
                    System.out.println("删除成功");
                AllId--;
            }

            System.out.println("如果要继续删除请输入 1 输入其他任意键退出删除回到主界面");
            scanner.nextLine();
            String s = scanner.nextLine();
            byte[] bytes = s.getBytes();
            if (bytes.length != 0) {
                int choice = (int) bytes[0];
                if (choice == 49) {
                    delete();
                } else
                    flag = false;
            }
            break;
        }
        clean();
        choiceDisplay();
    }
    public void query() throws IOException, InterruptedException {
        boolean flag = true;
        while (flag) {
            System.out.println("请输出需要查询的id");
            int id = scanner.nextInt();
            while (true) {
                if (id > AllId) {
                    System.out.println("请输入正确的id");
                } else
                    break;
            }
            for (Animal animal : animals) {
                if (animal.getId() == id) {
                    System.out.println(animal.getVariety() + "  " + animal.getSex() + "  " + animal.getAge());
                }
            }
            System.out.println("如果要继续查询请输入 1 输入其他任意键退出查询回到主界面");
            scanner.nextLine();
            String s = scanner.nextLine();
            byte[] bytes = s.getBytes();
            if (bytes.length != 0) {
                int choice = (int) bytes[0];
                if (choice == 49) {
                    query();
                } else
                    flag = false;
            }
            break;
        }
        clean();
        choiceDisplay();
    }
    public void querySortInAage() throws IOException, InterruptedException {
        Collections.sort(animals);
        for (Animal animal : animals) {
            System.out.println(animal.getVariety() + " " + animal.getSex() + " " + animal.getAge());
        }
        System.out.println("如果需要继续查询请输入1 请按其他任意键退出查询返回主界面");
        scanner.nextLine();
        scanner.nextLine();
        clean();
        choiceDisplay();
    }
    public void clean() {
        for (int i = 0; i < 10; i++)
            System.out.println(" ");
    }
}