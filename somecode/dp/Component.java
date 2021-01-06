import java.util.ArrayList;
import java.util.List;

public class Component {
    /**
     * test/
     * ├── a
     * ├── b
     * │ ├── 1.txt
     * │ └── d
     * │     └── 2.txt
     * └── c
     *     └── 3.txt
     */

    public static void main(String[] args) {
        // 创建文件节点
        File txt1 = new File("test/b/1.txt");
        File txt2 = new File("test/b/d/2.txt");
        File txt3 = new File("test/c/3.txt");

        // 创建目录节点
        Directory test = new Directory("test/");
        Directory a = new Directory("test/a/");
        Directory b = new Directory("test/b/");
        Directory c = new Directory("test/c/");
        Directory d = new Directory("test/b/d/");

        // 构造目录结构
        test.addNode(a);
        test.addNode(b);
        test.addNode(c);

        b.addNode(txt1);
        b.addNode(d);

        c.addNode(txt3);
        d.addNode(txt2);

        // 输出目录结构
        System.out.println(">>> dir test:");
        test.printFile();

        System.out.println(">>> dir b:");
        b.printFile();

        // 删除目录 b 后，再输出 test 目录
        test.removeNode(b);
        System.out.println(">>> dir test:");
        test.printFile();
    }
}

abstract class FileSystem {
    protected String path;

    public abstract void printFile();
}

class File extends FileSystem {
    public File(String path) {
        this.path = path;
    }

    public void printFile() {
        System.out.println(path);
    }
}

class Directory extends FileSystem {
    private List<FileSystem> nodes; // 用于存储节点

    public Directory(String path) {
        this.path = path;
        this.nodes = new ArrayList<>();
    }

    public void printFile() {
        System.out.println(path);

        // 递归输出目录和文件
        for (FileSystem node: nodes) {
            node.printFile();
        }
    }

    public void addNode(FileSystem node) {
        nodes.add(node);
    }

    public void removeNode(FileSystem node) {
        nodes.remove(node);
    }
}