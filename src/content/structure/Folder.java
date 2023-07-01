package content.structure;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Folder extends Content {

    private Map<String, Content> contents;

    public Folder(String name, int month, int year) {
        super(name, month, year);
        this.contents = new LinkedHashMap<>();
    }
    public Folder(String name) {
        super(name, 0, 0);
        this.contents = new LinkedHashMap<>();
    }

    public Content getSubFolder(String name){
        return contents.get(name);
    }

    @Override
    public void addContent(Content content) {
        contents.put(content.name,content);
    }

    @Override
    public int getSum() {
        int total = 0;
        for (Content content : contents.values()) {
            total += content.getSum();
        }
        return total;
    }

    @Override
    public String printStructure(String prefix) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix).append("- Folder: ").append(name).append("\n");

        for (Content content : contents.values()) {
            sb.append(content.printStructure(prefix + "  "));
        }

        return sb.toString();
    }
}
